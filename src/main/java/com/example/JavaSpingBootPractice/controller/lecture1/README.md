# Lecture 1
- Dependency Injection Là một kỹ thuật lập trình trong đó một đối tượng (hoặc component) không tự tạo các dependency của nó mà được tiếp nhận các dependency từ bên ngoài (thường là container DI).

- ResponseEntity - Kiểm soát HTTP Response 
- Giúp tùy chỉnh HTTP Status Code, Headers và Body.
- Phù hợp cho các trường hợp:
    + Trả về status code khác 200 (404, 500, 201,...).
    + Thêm custom headers vào response.
    + Trả về dữ liệu có cấu trúc phức tạp.

- ResponseEntity:
    + ResponseEntity.ok() 200 OK Trả về phản hồi thành công (thường dùng cho GET).
    + ResponseEntity.created(URI location) 201 Created Trả về khi tạo mới resource (thường dùng cho POST). Thêm header Location.
    + ResponseEntity.noContent() 204 No Content Trả về khi thành công nhưng không body (ví dụ: DELETE thành công).
    + ResponseEntity.badRequest() 400 Bad Request Yêu cầu không hợp lệ (ví dụ: validate sai).
    + ResponseEntity.notFound() 404 Not Found Resource không tồn tại.
    + ResponseEntity.internalServerError() 500 Internal Server Error Lỗi server (xử lý exception).

- HttpStatus:
    + HttpStatus.OK 200 Thành công (GET/PUT/PATCH).
    + HttpStatus.CREATED 201 Tạo mới thành công (POST).
    + HttpStatus.NO_CONTENT 204 Thành công nhưng không có dữ liệu trả về (DELETE).
    + HttpStatus.BAD_REQUEST 400 Yêu cầu không hợp lệ (validation sai, thiếu tham số).
    + HttpStatus.UNAUTHORIZED 401 Chưa xác thực (thiếu token hoặc sai credentials).
    + HttpStatus.FORBIDDEN 403 Không có quyền truy cập (đã đăng nhập nhưng không đủ quyền).
    + HttpStatus.NOT_FOUND 404 Không tìm thấy tài nguyên (URL sai hoặc dữ liệu không tồn tại).
    + HttpStatus.INTERNAL_SERVER_ERROR 500 Lỗi server (exception không xử lý được).