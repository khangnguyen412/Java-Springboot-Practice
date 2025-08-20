# Lecture 3
- @‌Valid, Validation
- Exception Handling
- Logging & Testing

## Các annotation Validation cơ bản
```
Annotation	        Ý nghĩa
@NotNull	        Không được null
@NotEmpty	        Không rỗng (áp dụng cho String, Collection)
@NotBlank	        Không để trống, khác " "
@Size(min, max)	    Độ dài chuỗi, số phần tử collection
@Min, @Max	        Giá trị nhỏ nhất, lớn nhất
@Email	            Email hợp lệ
@Pattern	        Regex pattern
```

## Exception Handling
- Custom Exception (tự định nghĩa lỗi riêng).
- Error Response DTO (chuẩn hoá JSON trả về).
- GlobalExceptionHandler (gom tất cả lỗi).

- Tách riêng ra thư mục exception
```
src/main/java/com/example/demo/
│
├── controller/
├── dto/
├── entity/
├── repository/
├── service/
├── exception/
│     ├── ErrorResponse.java                // DTO trả về json khi có lỗi
│     ├── CustomerNotFoundException.java    // Custom Exception
│     └── GlobalExceptionHandler.java       // Global Exception Handler
└── DemoApplication.java
```
- GlobalExceptionHandler sẽ tự động bắt lỗi KHÔNG cần phải xử lý try/catch để trả JSON nữa.
- Còn CustomerNotFoundException đc sử dụng cho ném exception khi không tìm thấy khách hàng (vd: services/Lecture2CustomerServices.java)
- Lưu ý:
    - @Validated: Dùng để validate các tham số trong controller.
    - @Valid: Dùng để validate các đối tượng trong service.
    - @ExceptionHandler: Dùng để bắt lỗi.
    - @RestControllerAdvice: Dùng để bắt lỗi toàn cục, add vào đầu class GlobalExceptionHandler.

## Logging & Testing
- Path: src/main/java/com/example/JavaSpingBootPractice/controller/lecture2/Lecture2AccountController.java

- Tạo file ghi log cho springboot: 
    - Tạo file src/main/resources/logback-spring.xml
    - Thêm dependency logback-spring.xml
- Khi app sẽ taọ các file log và ghi vào ./logs

## Test tự động (unit test / integration test)
- Path: src/test/java/com/example/JavaSpingBootPractice/Lecture3CustomApiTest.java
- Log vẫn ghi vào file ./log