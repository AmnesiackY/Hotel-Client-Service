# Hotel Client Service

Spring Boot microservice for managing hotel clients.  
Built with **Kotlin**, **Spring Boot**, and **JPA**.

This project is focused on clean architecture, proper REST API design,
and gradual evolution from in-memory storage to a production-ready database setup.

---

## 📌 Features

- CRUD API for hotel clients
- RESTful endpoints
- Proper HTTP semantics:
    - `200 OK`
    - `204 No Content`
    - `400 Bad Request`
    - `404 Not Found`
- Input validation
- Global error handling
- Persistence with JPA
- In-memory database (H2) for local development
- Ready for PostgreSQL & Flyway integration

---

## 🛠 Tech Stack

- Kotlin
- Spring Boot
- Spring Web
- Spring Data JPA
- H2 Database (default)
- Gradle

---

## 📂 Project Structure

```
hotel-client-service
├── README.md
├── build.gradle.kts
├── settings.gradle.kts
├── docker-compose.yml        # (planned)
└── src
└── main
├── kotlin
│   └── com
│       └── yarek
│           └── hotel
│               ├── controller
│               │   └── ClientController.kt
│               ├── service
│               │   ├── ClientService.kt
│               │   └── PingService.kt
│               ├── repository
│               │   └── ClientRepository.kt
│               ├── entity
│               │   └── ClientEntity.kt
│               ├── dto
│               │   └── ClientDto.kt
│               ├── exception
│               │   ├── ApiError.kt
│               │   ├── ClientNotFoundException.kt
│               │   └── GlobalExceptionHandler.kt
│               ├── PingController.kt
│               └── HotelApplication.kt
└── resources
└── application.yml
```


---

## ▶️ Running the Application

### Prerequisites

- Java 17
- Gradle

### Start the application

```bash
./gradlew bootRun
```

The service will be available at:
```
http://localhost:8080
```

## 🧪 API Usage Examples

# Create client
```
POST /api/clients
Content-Type: application/json

{
"firstName": "John",
"lastName": "Doe",
"email": "john@hotel.com"
}
```

# Get client by id
```
GET /api/clients/{id}
```

# Get all clients
```
GET /api/clients
```

# Delete client
```
DELETE /api/clients/{id}

Responses:
204 No Content — client deleted
404 Not Found — client does not exist
```

## 🚀 Roadmap
```
1. PostgreSQL via Docker
2. Flyway database migrations
3. OpenAPI / Swagger documentation
4. Dockerized Spring Boot application
```

👤 Author

Yaroslav Yarovyi
QA / Automation Engineer