# Hotel Client Service

Spring Boot microservice for managing hotel clients.  
Built with **Kotlin**, **Spring Boot**, **PostgreSQL**, and **Flyway**.

This project is focused on clean backend architecture, proper REST API design,
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
- PostgreSQL database (Docker)
- Database schema versioning with Flyway

---

## 🛠 Tech Stack

- Kotlin
- Spring Boot
- Spring Web
- Spring Data JPA
- PostgreSQL 16
- Flyway
- Gradle
- Docker & Docker Compose

---

## 📂 Project Structure

```text
hotel-client-service
├── README.md
├── build.gradle.kts
├── settings.gradle.kts
├── docker-compose.yml
└── src
    └── main
        ├── kotlin
        │   └── com
        │       └── yarek
        │           └── hotel
        │               ├── controller
        │               │   ├── ClientController.kt
        │               │   └── PingController.kt
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
        │               └── HotelApplication.kt
        └── resources
            ├── application.yml
            └── db
                └── migration
                    ├── V1__create_clients_table.sql
                    └── V2__add_phone_to_clients.sql
```

---

## ▶️ Running the Application

### Prerequisites

- Java 17
- Docker & Docker Compose

# How to start?

## Start PostgreSQL

```bash
docker compose up -d
```

PostgreSQL will be available on:
```
Host: localhost
Port: 5432
Database: hotel
User: hotel_user
Password: hotel_pass
```

### Run Spring Boot application
```bash
./gradlew bootRun
```

The service will be available at:
```
http://localhost:8080
```

# 🧪 API Usage Examples

## Create client
```
POST /api/clients
Content-Type: application/json

{
"firstName": "John",
"lastName": "Doe",
"email": "john@hotel.com"
}
```

## Get client by id
```
GET /api/clients/{id}
```

## Get all clients
```
GET /api/clients
```

## Delete client
```
DELETE /api/clients/{id}

Responses:
204 No Content — client deleted
404 Not Found — client does not exist
```

## 🗄 Database & Migrations

The service uses PostgreSQL running in a Docker container.
Database data is persisted using Docker volumes.

### Flyway migrations
Database schema is managed using Flyway.
Migration files are located in:
```
src/main/resources/db/migration
```
Flyway automatically applies all pending migrations on application startup.


## 🚀 Roadmap
```
̶1̶.̶ ̶P̶o̶s̶t̶g̶r̶e̶S̶Q̶L̶ ̶v̶i̶a̶ ̶D̶o̶c̶k̶e̶r̶
̶2̶.̶ ̶F̶l̶y̶w̶a̶y̶ ̶d̶a̶t̶a̶b̶a̶s̶e̶ ̶m̶i̶g̶r̶a̶t̶i̶o̶n̶s̶
3. OpenAPI / Swagger documentation
4. Dockerized Spring Boot application
5. Unit and integration tests
6. CI pipeline
```



👤 Author

Yaroslav Yarovyi
QA / Automation Engineer
Exploring backend development with Kotlin & Spring