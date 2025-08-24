# Lecture 6
- Query Optimization 
    + Là quá trình cải thiện câu SQL để chạy nhanh hơn, giảm tải DB, tiết kiệm tài nguyên.
    + Query Optimizer tự động, nhưng dev vẫn phải viết query tốt và hỗ trợ optimizer.
- Các cách Optimization
    + Lazy vs Eager Loading (Đã học trước đó)
    + JOIN FETCH, EntityGraph, Batch Fetching
    + Pagination
    + Indexing 
    + Caching (đã học trước đó)

## Những trường hợp khi tạo index
- Cột thường xuyên xuất hiện trong WHERE clause
- Cột thường xuyên được sắp xếp (ORDER BY)
- Cột dùng trong JOIN

### Nguyên tắc khi tạo index
- Không index quá nhiều:
    + Mỗi index = thêm chi phí update/insert.
    + Chỉ index cột thực sự cần tìm kiếm/tối ưu.
- Index phù hợp với truy vấn thực tế:
    + Nếu query hay lọc theo WHERE email → index email.
    + Nếu query hay lọc WHERE email AND status → có thể dùng composite index (email, status).
- Đặt cột có độ phân biệt cao lên trước trong composite index
- Không index cột nhỏ, ít giá trị lặp lại:
    + Như status chỉ có "ACTIVE" / "INACTIVE" → index không giúp nhiều.
- Index cho tìm kiếm dạng text:
    + Nếu LIKE 'abc%' → index bình thường vẫn hoạt động.
    + Nếu LIKE '%abc%' → cần FULLTEXT index (MySQL) hoặc GIN index (Postgres).
- Theo dõi query thực tế bằng EXPLAIN
    + Trước khi tạo index, chạy EXPLAIN SELECT ... để xem DB có dùng index hay không.

### Nguyên tắc vàng khi sử dụng index
- Index chỉ nên tạo dựa trên query thường dùng.
- Không tạo index theo cảm tính.
- Luôn dùng EXPLAIN để kiểm chứng.

- ví dụ cho bảng customer
```sql
-- Index cho tra cứu nhanh bằng fed_id (unique nếu không trùng lặp)
CREATE UNIQUE INDEX idx_customer_fedid ON customer(fed_id);

-- Composite index cho city + postal_code
CREATE INDEX idx_customer_city_postal ON customer(city, postal_code);
```
- Thêm annotation @Index
```java
@Entity
@Table(name = "customer",
indexes = {
        @Index(name = "idx_customer_fedid", columnList = "fed_id", unique = true),
        @Index(name = "idx_customer_city_postal", columnList = "city, postal_code")
    }
)
```
- Kiểm tra index có hoạt động hay không
    + Sử dụng EXPLAIN để kiểm tra.
    + Nếu index không được dùng, xem lại câu query.
    + Nếu index được dùng, xem lại cấu hình.
```sql
EXPLAIN SELECT * FROM customer WHERE fed_id = '777-77-7777';
```
- Mỗi lần chạy query, DB sẽ kiểm tra xem có index nào phù hợp hay không.
    + Nếu có, DB sẽ sử dụng index đó.
    + Nếu không, DB sẽ scan toàn bộ bảng.

## @Async annotation
- Dùng để chạy bất đồng bộ (asynchronous), tức là không chặn luồng chính.
- Khi gọi method có @Async, Spring sẽ chạy nó trong thread pool riêng, trả kết quả ngay cho caller.

## CompletableFuture
- Khi cần lấy kết quả trả về từ async task, dùng CompletableFuture<T>.
- Nó giúp chain nhiều async tasks lại với nhau.

## Task scheduling với @Scheduled
- Dùng để chạy task theo schedule.
- Cần thêm @EnableScheduling ở class main.
- Dùng annotation @Scheduled để đánh dấu method là task.


## Thread Pool Configuration
- Mặc định, @Async và @Scheduled dùng thread pool nhỏ.
- Bạn nên custom Executor để quản lý số lượng thread.