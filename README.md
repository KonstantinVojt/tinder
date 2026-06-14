# Tinder API – Spring Boot REST API

A REST API that simulates the core matching mechanic of Tinder. Built to practice Spring Boot, dependency injection, and the Strategy design pattern.

## Tech Stack

- Java 17
- Spring Boot 3.2.1
- Spring Data JPA
- PostgreSQL
- Lombok
- Maven

## How It Works

The app exposes a single endpoint:

```
GET /new-match
```

Returns a random user from the database:

```json
{
  "id": 1,
  "name": "Maria",
  "sex": "FEMALE",
  "point": 10
}
```

## Match Strategies

Two algorithms implemented via the `MatchService` interface:

- `RandomMatchService` – returns a random user (active by default)
- `HighestScoreMatchService` – returns the user with the highest score

Switch strategies by moving `@Primary` between implementations.

## Database Implementations

Two implementations of `UsersDatabaseService`:

- `UsersDatabaseRealServiceImpl` – fetches from PostgreSQL (active by default)
- `UsersDatabaseFakeServiceImpl` – uses hardcoded in-memory data, useful for running without a database

## Getting Started

### Prerequisites

- Java 17+
- PostgreSQL
- Maven

### Setup

1. Clone the repository:
   ```bash
   git clone https://github.com/KonstantinVojt/tinder.git
   cd tinder
   ```

2. Configure the database:
   ```bash
   cp src/main/resources/application.properties.example src/main/resources/application.properties
   ```

3. Edit `application.properties`:
   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/postgres
   spring.datasource.username=your_username
   spring.datasource.password=your_password
   ```

4. Run:
   ```bash
   DB_PASSWORD=your_password ./mvnw spring-boot:run
   ```

The `users` table is created automatically on startup via `ddl-auto=update`.

## Add Users Manually

```sql
INSERT INTO users (name, sex, point) VALUES ('Alice', 'FEMALE', 8);
INSERT INTO users (name, sex, point) VALUES ('Bob', 'MALE', 5);
```

## Project Structure

```
src/main/java/com/example/tinder/
├── controller/
│   └── TinderController.java
├── entity/
│   ├── User.java
│   └── Sex.java
├── repository/
│   └── UserRepository.java
└── service/
    ├── match/
    │   ├── MatchService.java
    │   └── impl/
    │       ├── RandomMatchService.java
    │       └── HighestScoreMatchService.java
    └── database/
        ├── UsersDatabaseService.java
        └── impl/
            ├── UsersDatabaseRealServiceImpl.java
            └── UsersDatabaseFakeServiceImpl.java
```
