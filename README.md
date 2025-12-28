# Hotel Client Service

![Build](https://github.com/AmnesiackY/Hotel-Client-Service/actions/workflows/build.yml/badge.svg)

Spring Boot microservice for managing hotel clients.  
Built with **Kotlin**, **Spring Boot**, **PostgreSQL**, and **Flyway**.

This project focuses on clean backend architecture, proper REST API design,
and controlled database schema evolution using Flyway with a production-ready persistence setup.



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

## 🏗 Architecture

The project follows a **Clean Architecture inspired structure** with clear
separation of concerns.

Layers overview:

- **API layer**
  - REST controllers
  - API DTOs
  - API mappers
  - Swagger/OpenAPI documentation

- **Application layer**
  - Use cases (business actions)
  - Orchestrates domain logic
  - Independent from frameworks

- **Domain layer**
  - Core business models
  - Repository contracts
  - Business exceptions

- **Infrastructure layer**
  - JPA repositories
  - Database entities
  - External integrations

Business logic depends only on domain contracts and is fully testable
without Spring context or database.
---
## 🧩 Architecture Diagram

```
[ Controller / API ]
          |
          v
     [ API DTOs ]
          |
          v
     [ Use Cases ]
          |
          v
      [ Domain ]
          |
          v
[ Repository Interface ]
          |
          v
[ JPA Adapter / Database ]
```
---

## ▶️ Running the Application

### Prerequisites

- Java 17
- Docker & Docker Compose

### Start PostgreSQL

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

## 🧪 API Usage

All API endpoints can be explored and tested using the interactive
**Swagger UI**.

After starting the application, open:

```
http://localhost:8080/swagger-ui/index.html
```

Swagger provides:
- full list of available endpoints
- request and response schemas
- interactive request execution directly from the browser

This allows quick exploration of the API without any additional tools
such as Postman.


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

## ⚙️ Testing

The project includes **unit tests for application use cases**.

Unit tests are written for the **application layer** and verify business behavior
without relying on Spring context, database, or external services.

Key points:
- Unit tests target **use cases** (business logic)
- Dependencies are injected via interfaces and replaced with fakes in tests
- Tests are fast, deterministic, and easy to maintain

Example:
- `CreateClientUseCaseTest` verifies client creation logic without database access

## ⚙️ Continuous Integration (CI)

The project uses **GitHub Actions** for Continuous Integration.

On every push and pull request to the `main` branch, the CI pipeline:
- builds the project
- runs all unit tests
- ensures the application is in a healthy state

This helps keep the main branch stable and prevents broken changes
from being merged.


## 🚀 Roadmap
```
1. Dockerized Spring Boot application
2. Extended unit and integration test coverage
```



👤 Author

Yaroslav Yarovyi  
QA / Automation Engineer  
Currently exploring backend development with Kotlin & Spring