## Practice Java

- Description: Project Springboot for practice and research with the Springboot Framework
- Purpose: For learning and researching Springboot deeper, this project recorded my learning process.

## Technology in project:

- Language: HTML, CSS, JAVA, JS

## Project structure

```
src/
├── main/
│   ├── java/
│   │   └── com/example/demo/
│   │       ├── DemoApplication.java          # Entry point
│   │       ├── controller/                   # Controllers
│   │       │   └── UserController.java
│   │       ├── service/                      # Business logic
│   │       │   └── UserService.java
│   │       ├── model/                        # Data models
│   │       │   └── User.java
│   │       ├── repository/                   # Database access
│   │       │   └── UserRepository.java
│   │       └── config/                       # Configuration
│   │           └── SecurityConfig.java
│   └── resources/                            # Static files, configs
│       ├── application.properties            # Configurations
│       ├── static/                           # CSS, JS, Images
│       └── templates/                        # Templates (Thymeleaf)
└── test/
    └── java/
        └── com/example/demo/
            └── DemoApplicationTests.java
```