# Lecture 4
## Spring Security Cơ Bản
- @EnableWebSecurity
- Authentication vs Authorization
- In-Memory authentication
- Password encoding
## JWT Authentication
- JWT token generation
- Token validation
- @PreAuthorize, @PostAuthorize
- Security configuration
## OAuth2 & Role-Based Access
- Role-based security
- Permission management
- Session management

## Cấu trúc thư mục JWT
```
src
└── main
    ├── java
    │   └── com
    │       └── example
    │           └── JavaSpringBootPractice/
    │               ├── controller/
    │               │   └── lecture4
    │               │       └── Lecture4Security.java        // Controller test API
    │               ├── security/
    │               │   ├── SecurityConfig.java              // Cấu hình Spring Security
    │               │   ├── Lecture4UserSecurity.java        // UserDetailsService (in-memory user)
    │               │   ├── jwt/
    │               │   │   ├── JwtTokenProvider.java        // Tạo + xác thực JWT
    │               │   │   ├── JwtAuthenticationFilter.java // Filter check JWT
    │               │   │   └── JwtAuthEntryPoint.java       // Handle lỗi 401 Unauthorized
    │               │   └── ...
    │               └── JavaSpringBootPracticeApplication.java // Main app
    └── resources/
        ├── application.properties (hoặc application.yml)    // Cấu hình log, db, jwt secret...
        └── logback-spring.xml (nếu muốn custom logging)
```