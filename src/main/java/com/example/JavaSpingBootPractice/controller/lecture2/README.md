# Lecture 2
- Kết nối cơ sở dữ liệu
- kết nối DB qua file application.properties
- các tham số:
    + spring.datasource.url=jdbc:mysql://${DB_HOST:localhost}:${DB_PORT:3306}/${DB_NAME:my_db}?useSSL=false
    + spring.datasource.username=${DB_USER:root}
    + spring.datasource.password=${DB_PASSWORD:123456}

- Các kiểu dự liệu ánh xạ cơ bản
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

- Nguyên tắc đặt tên bảng, cột để sử dụng cho JPA
    + Tên bảng: snake_case
    + Tên cột: camelCase
    + dùng @Column để ánh xạ các column

- Các phương CURD cơ bản của JpaRepository<Lecture2Model, Integer>
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