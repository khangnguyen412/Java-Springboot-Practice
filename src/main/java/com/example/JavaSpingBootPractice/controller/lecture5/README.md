# Lecture 5
## Advanced JPA
- @NamedQuery, @NamedQueries
- @Formula, @JoinFormula
- Lazy vs Eager loading
- Fetch strategies
## Transaction Management
- @Transactional annotation
- Propagation levels
- Isolation levels
- Exception handling in transactions
## Caching
- @Cacheable, @CacheEvict, @CachePut
- Redis caching integration
- Cache configuration

## Transaction Management
- Transaction (giao dịch) là một tập hợp nhiều thao tác với DB (insert, update, delete...) nhưng được coi như một đơn vị công việc duy nhất.
- Transaction đảm bảo 4 tính chất ACID:
    + A – Atomicity (Nguyên tử): hoặc tất cả các thao tác thành công, hoặc rollback (không có gì thay đổi).
    + C – Consistency (Nhất quán): dữ liệu trước và sau giao dịch phải hợp lệ.
    + I – Isolation (Cô lập): các transaction song song không ảnh hưởng lẫn nhau sai quy tắc.
    + D – Durability (Bền vững): khi commit thì dữ liệu được lưu vĩnh viễn.
- Spring cung cấp annotation @Transactional để quản lý giao dịch cho bạn.
- Khi bạn gọi 1 method có @Transactional:
- Spring mở một transaction mới (nếu chưa có).
    + Spring chạy toàn bộ method trong transaction đó.
    + Nếu không có exception → commit (ghi dữ liệu).
    + Nếu có exception → rollback (hủy bỏ thay đổi).

## @Formula, @JoinFormula
- @Formula
    + Dùng để tính toán giá trị của 1 field dựa trên các field khác.
    + Dùng để ánh xạ một field trong entity với công thức SQL (một subquery hoặc biểu thức).
    + Field này không có cột thật trong DB, mà Hibernate sẽ sinh ra khi query.
    + Rất hữu ích khi bạn cần tính toán giá trị hoặc lấy dữ liệu tổng hợp từ các cột khác.
    + Ví dụ: Giả sử bảng account có 2 cột: avail_balance và pending_balance, bạn muốn có một field totalBalance = avail_balance + pending_balance.
- @JoinFormula
    + Dùng để join 2 table dựa trên 1 field.
    + Hữu ích khi quan hệ không thẳng bằng FK hoặc cần tính toán.
    + Ví dụ: join table customer và order dựa trên field custId.

## Caching
- Caching là kỹ thuật lưu trữ dữ liệu tạm thời để tránh truy vấn lại cơ sở dữ liệu nhiều lần, từ đó cải thiện hiệu năng ứng dụng.
- Các loại caching: 
    + Hibernate L2 cache
    + Cache ở tầng service/controller
- Hibernate L2 cache(Đặt trên entity hoặc collection.): @Cache (org.hibernate.annotations.Cache)
- Cache ở tầng service/controller (method result): @Cacheable, @CacheEvict, @CachePut