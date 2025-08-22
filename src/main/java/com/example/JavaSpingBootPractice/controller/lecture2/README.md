# Lecture 2
- Kết nối cơ sở dữ liệu
- kết nối DB qua file application.properties
- các tham số:
```
spring.datasource.url=jdbc:mysql://${DB_HOST:localhost}:${DB_PORT:3306}/${DB_NAME:my_db}?useSSL=false
spring.datasource.username=${DB_USER:root}
spring.datasource.password=${DB_PASSWORD:123456}
```

## Các kiểu dự liệu ánh xạ cơ bản
```
Java (JPA)	            MySQL	                PostgreSQL	    H2	            Mô tả
String	                VARCHAR(255)	        VARCHAR	        VARCHAR 	    Chuỗi văn bản
int / Integer	        INT	                    INTEGER	        INT	            Số nguyên 32-bit
long / Long	            BIGINT                  BIGINT          BIGINT          Số nguyên 64-bit
float / Float	        FLOAT                   REAL            REAL            Số thực 32-bit
double / Double	        DOUBLE                  DOUBLE          PRECISION	    DOUBLE	Số thực 64-bit
boolean / Boolean	    TINYINT(1)/BOOLEAN      BOOLEAN	        BOOLEAN	        Giá trị true/false
java.util.Date	        DATETIME	            TIMESTAMP	    TIMESTAMP	    Ngày giờ (date + time)
java.time.LocalDate	    DATE	                DATE	        DATE	        Ngày tháng (không có giờ)
java.time.LocalDateTime	DATETIME	            TIMESTAMP	    TIMESTAMP	    Ngày giờ (không timezone)
byte[]	                BLOB	                BYTEA	        BYTEA	        Dữ liệu nhị phân
BigDecimal	            DECIMAL(p,s)	        DECIMAL(p,s)	DECIMAL(p,s)	Số thập phân chính xác
```

## Nguyên tắc đặt tên bảng, cột để sử dụng cho JPA
- Tên bảng: snake_case
- Tên cột: camelCase
- dùng @Column để ánh xạ các column
- Nếu sử dụng findByOpenBranchId(int openBranchId) có sẳn của JPA thì phải theo quy tắt đặt tên của JPQL (method + TênThuộcTính)

## Nguyên tắc sử dụng @Query để custom query
- Không gọi trực tiếp tên bảng
- Không đc gọi trực tiếp tên bảng (ví dụ: account => Lecture2Model)
- Chỉ đc gọi các cột đã ánh xạ (ví dụ: a.pending_balance =>  a.pendingBalance)

## Các phương CURD cơ bản của JpaRepository <Lecture2Model, Integer>
```
Phương thức	                        Công dụng
save(S entity)	                    Lưu một entity mới hoặc cập nhật entity đã tồn tại.
saveAll(Iterable<S> entities)	    Lưu nhiều entities cùng lúc.
findById(ID id)	                    Tìm entity bằng khóa chính (trả về Optional<T>).
existsById(ID id)	                Kiểm tra entity có tồn tại với khóa chính id không.
findAll()	                        Lấy tất cả entities.
findAllById(Iterable<ID> ids)	    Lấy nhiều entities bằng danh sách khóa chính.
count()	                            Đếm số lượng entities trong bảng.
deleteById(ID id)	                Xóa entity bằng khóa chính.
delete(T entity)	                Xóa một entity cụ thể.
deleteAll()	                        Xóa tất cả entities trong bảng.

Phương thức phân trang
findAll(Pageable pageable)	        Lấy entities theo phân trang (trả về Page<T>).
findAll(Sort sort)	                Lấy tất cả entities và sắp xếp theo điều kiện.
```

## Quan hệ giữa các Entity trong JPA
```
Quan Hệ	        Annotation	    Mô Tả
One-to-One	    @OneToOne	    1 bản ghi Entity A ↔ 1 bản ghi Entity B (ví dụ: User ↔ UserProfile)
One-to-Many	    @OneToMany	    1 bản ghi Entity A ↔ N bản ghi Entity B (ví dụ: Category ↔ Product)
Many-to-One	    @ManyToOne	    N bản ghi Entity A ↔ 1 bản ghi Entity B (ví dụ: Product ↔ Category)
Many-to-Many	@ManyToMany	    N bản ghi Entity A ↔ N bản ghi Entity B (ví dụ: Student ↔ Course)
```

## Quan hệ One-to-One
- Quan hệ 1-1 giữa 2 Entity:
- Cần xác định bên sở hữu quan hệ (owner) và bên tham chiếu (referenced)
- Phía Owner 
    + Là phía chứa khóa ngoại (foreign key) trong database.
    + Dùng @JoinColumn để ánh xạ cột khóa ngoại.
- Phía Referenced
    + Dùng @OneToOne(mappedBy = "[key]") để  tham chiếu ngược lại Owning Side.
    + Là phía không chứa khóa ngoại (foreign key) trong database.
- Bên phía sở hữu quan hệ (owner)
```
@OneToOne
@JoinColumn(name = "[foreign_key_column_name]") // foreign_key_column_name là tên cột khóa ngoại trong bảng Owner
```
- Bên phía tham chiếu (referenced)
```
@OneToOne(mappedBy = "[field_name]") // [field_name] Khai báo trong owning side
```
ví dụ: 
- Bên bảng account có:
```
private Lecture5EmployeeModel employee;
```
- Thì bên employee có:
```
@OneToOne(mappedBy = "employee", cascade = CascadeType.ALL)
private List<Lecture2AccountModel> accounts;
```

## Quan hệ One-to-Many
- Xác định quan hệ 1-N giữa 2 Entity:
    + Bảng nào chứa foreign key → đó là bảng nhiều (N).
    + Bảng được tham chiếu (chứa PRIMARY KEY được FK trỏ tới) → đó là bảng một (1).
- Bên phía một (One)
```
@OneToMany(mappedBy = "[key]") // Key là thuộc tính bảng Many, Tên field Java (không phải tên cột DB)
private List<ManyEntity> manyEntities; // Thường dùng List/Set
```
- Bên phía nhiều (Many)
- thêm (insertable = false, updatable = false) vào thuộc tính @Column để ngăn chặn JPA tự động cập nhật khóa ngoại
```
@ManyToOne
@JoinColumn(name = "[key]") // Key là tên cột khóa ngoại trong bảng Many
```
ví dụ: 
- Bên bảng account có:
```
private Lecture5EmployeeModel employee;
```
- Thì bên employee có:
```
@OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
private List<Lecture2AccountModel> accounts;
```
* Lưu ý: thêm 2 thuộc tính này vào "insertable = false, updatable = false" khi khai báo để ko bị lỗi duplicate field