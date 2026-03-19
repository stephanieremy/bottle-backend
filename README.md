# Bottle Backend

A REST API for managing a personal wine cellar, built with Java Spring Boot and MongoDB. Designed with hexagonal architecture to keep the domain logic clean and framework-independent.

---

## Tech Stack

- **Java 21**
- **Spring Boot 3**
- **MongoDB** (via Spring Data MongoDB)
- **MapStruct** — entity/DTO mapping
- **Lombok** — boilerplate reduction

---

## Architecture

The project follows **hexagonal architecture** (ports & adapters):

```
com.bottle.app
├── application         # Use case implementations (@Service)
├── domain              # Pure Java — entities, ports, exceptions
│   └── bottle          # Bottle entity, WineType enum
└── infrastructure      # Spring & MongoDB adapters
    ├── api             # REST controllers, DTOs, mappers, exception handler
    └── repository      # MongoDB adapter, entities, mappers
```

**Dependency rule**: infrastructure → application → domain. The domain has zero framework dependencies.

---

## Prerequisites

- Java 21+
- Maven 3.8+
- MongoDB instance (local or Atlas)

---

## Getting Started

### 1. Clone the repository

```bash
git clone https://github.com/stephanieremy/bottle-backend.git
cd bottle-backend
```

### 2. Configure MongoDB

In `src/main/resources/application.properties`, set your MongoDB connection:

```properties
spring.data.mongodb.uri=mongodb://localhost:27017/bottle
```

Or for MongoDB Atlas:

```properties
spring.data.mongodb.uri=mongodb+srv://<user>:<password>@<cluster>.mongodb.net/bottle
```

### 3. Run the application

```bash
./mvnw spring-boot:run
```

The API will be available at `http://localhost:8080`.

---

## API Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| `GET` | `/bottle` | Get all bottles (optional `?type=RED` filter) |
| `GET` | `/bottle/{id}` | Get a bottle by ID |
| `POST` | `/bottle` | Create a new bottle |
| `PUT` | `/bottle/{id}` | Update a bottle |
| `DELETE` | `/bottle/{id}` | Delete a bottle |

### Bottle payload example

```json
{
  "name": "Château Margaux",
  "designation": "Margaux, Bordeaux",
  "vintage": 2016,
  "type": "RED",
  "region": "Bordeaux",
  "quantity": 6,
  "price": 380,
  "score": 97
}
```

### Wine types

`RED` · `WHITE` · `PINK` · `CHAMPAGNE` · `SPARKLING` · `MUTED`

---

## Running Tests

```bash
./mvnw test
```

Unit tests cover the `BottleService` use case layer — no Spring context required.

---

## Error Handling

The API returns standard HTTP status codes:

| Status | Meaning |
|--------|---------|
| `200` | Success |
| `201` | Created |
| `404` | Bottle not found |
| `500` | Unexpected server error |
