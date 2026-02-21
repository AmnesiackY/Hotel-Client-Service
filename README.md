# Hotel Client Service

![Build](https://github.com/AmnesiackY/Hotel-Client-Service/actions/workflows/build.yml/badge.svg)
![Release](https://img.shields.io/github/v/release/AmnesiackY/Hotel-Client-Service)

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
- GitHub Actions

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

- Docker & Docker Compose

### Start the application

```bash
docker compose up --build
```

This will start both PostgreSQL and the Spring Boot application.  
The service will be available at:

```
http://localhost:8080
```

PostgreSQL connection details (for local access):
```
Host: localhost
Port: 5432
Database: hotel
User: hotel_user
Password: hotel_pass
```

To stop and clean up:

```bash
docker compose down -v
```

### Running without Docker

If you prefer to run locally without Docker, start PostgreSQL separately and then:

```bash
./gradlew bootRun
```

---

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

---

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

---

## ⚙️ Testing

The project includes **unit tests for application use cases**.

Unit tests are written for the **application layer** and verify business behavior
without relying on Spring context, database, or external services.

Key points:
- Unit tests target **use cases** (business logic)
- Dependencies are injected via interfaces and replaced with fakes in tests
- Tests are fast, deterministic, and easy to maintain

### Run tests

```bash
./gradlew test
```

### API Tests (TypeScript + Playwright)

API tests are written in TypeScript using Playwright and cover the REST API end-to-end against a running instance of the service.

Make sure the application is running first, then:

```bash
npx playwright test
```

---

## ⚙️ Continuous Integration & Delivery (CI/CD)

The project uses **GitHub Actions** with two separate pipelines:

### Build pipeline (`build.yml`)

Triggered on every push and pull request to `main`:

1. Builds the application using a **multi-stage Docker build**
2. Runs all unit tests inside the builder stage
3. Publishes a **test report** as a GitHub Actions artifact

Uses **GitHub Actions Cache** for Docker layer caching, keeping builds under 1 minute.

### Release pipeline (`release.yml`)

Triggered on every push to `main`.  
Uses [semantic-release](https://semantic-release.gitbook.io/) to automate versioning based on commit messages:

| Commit type | Example | Version bump |
|-------------|---------|--------------|
| `fix:` | `fix: correct phone validation` | `1.0.0` → `1.0.1` |
| `feat:` | `feat: add room endpoint` | `1.0.0` → `1.1.0` |
| `feat!:` | `feat!: redesign client DTO` | `1.0.0` → `2.0.0` |
| `chore:`, `docs:` | `chore: update deps` | no release |

On release, the pipeline automatically:
- Creates a **Git tag** (e.g. `v1.1.0`)
- Generates a **GitHub Release**
- Updates **CHANGELOG.md**

### Commit message convention

This project follows [Conventional Commits](https://www.conventionalcommits.org/):

```
feat: add client search endpoint
fix: correct pagination offset
docs: update README
chore: update dependencies
feat!: remove legacy endpoint  ← breaking change
```

---

## 🚀 Roadmap

```
✅ Clean layered architecture (Domain, Application, API, Infrastructure)
✅ Dockerized Spring Boot application (multi-stage build)
✅ Docker Compose with PostgreSQL and health checks
✅ GitHub Actions CI pipeline with test reporting and layer caching
✅ Automated semantic versioning and releases with CHANGELOG generation
⬜ Extended integration test coverage
⬜ Deploy to cloud infrastructure
```

---

👤 **Author**

Yaroslav Yarovyi  
QA / Automation Engineer  
Currently exploring backend development and DevOps with Kotlin & Spring
