# 🚀 User Profile CRUD — Sample MvcRest App

Minimal Spring Boot-based RESTful CRUD service managing a user profile entity. Includes OpenAPI/Swagger UI, Liquibase migrations, Actuator, Prometheus metrics, and optional local Docker stack for Postgres, Prometheus, Grafana, and SonarQube.

## Technology stack

- **Language/Runtime**: Java 21
- **Frameworks**: Spring Boot (Web, Data JPA, Actuator), Springdoc OpenAPI, Undertow
- **Persistence**: PostgreSQL (Liquibase migrations), H2 for tests
- **Observability**: Micrometer + Prometheus, Logback (plain/JSON), Grafana dashboards
- **Quality**: JUnit 5, Mockito, Hamcrest, JaCoCo (80%+), Qulice

## Prerequisites

- Java 21+
- Git
- Docker (optional, for local infra and monitoring)
- An IDE (IntelliJ IDEA recommended)

## Quickstart

1. Clone and enter the project

```bash
git clone https://github.com/IQKV/quickstart-mvc-rest-user-profile-crud.git
cd quickstart-mvc-rest-user-profile-crud
```

2. Start Postgres (choose one)

- Existing Postgres: set env vars (see Configuration) and ensure DB is reachable
- Docker: `docker compose -f compose.yaml up -d postgres`

3. Run the app

```bash
./mvnw spring-boot:run -Dspring-boot.run.profiles=local -P dev
```

4. Explore the API

- Swagger UI: `http://localhost:8080/swagger-ui.html`
- OpenAPI JSON: `http://localhost:8080/v3/api-docs`
- Actuator Health: `http://localhost:8080/actuator/health`
- Prometheus metrics: `http://localhost:8080/actuator/prometheus`

To build a runnable jar:

```bash
./mvnw package
java -jar target/*.jar
```

## Configuration

Key application properties (defaults in `src/main/resources/application.yml`):

- **Server**: `SERVER_PORT` (default 8080)
- **Datasource**:
  - `DATASOURCE_URL` (default `jdbc:postgresql://localhost:5432/svc_testing_db`)
  - `DATASOURCE_USERNAME` (default `postgres`)
  - `DATASOURCE_PASSWORD` (default `postgres`)
  - `DATASOURCE_DRIVER` (default `org.postgresql.Driver`)
- **Management**: `MANAGEMENT_SERVER_PORT` (default 8080)

Local developer-friendly settings are enabled via the `local` Spring profile (`application-local.yml`): SQL logged, caches off, actuator endpoints exposed.

## API Endpoints

Base path: `http://localhost:8080/api/v1/user-profiles`

- Create

```bash
curl -sS -X POST http://localhost:8080/api/v1/user-profiles \
  -H "Content-Type: application/json" \
  -d '{"email":"john.doe@example.com","active":true}'
```

- Get by id

```bash
curl -sS http://localhost:8080/api/v1/user-profiles/1
```

- List (optional filter by `email`)

```bash
curl -sS "http://localhost:8080/api/v1/user-profiles?email=john"
```

- Update

```bash
curl -sS -X PUT http://localhost:8080/api/v1/user-profiles/1 \
  -H "Content-Type: application/json" \
  -d '{"email":"johnny@example.com","active":false}'
```

- Delete by id

```bash
curl -sS -X DELETE http://localhost:8080/api/v1/user-profiles/1
```

- Delete all

```bash
curl -sS -X DELETE http://localhost:8080/api/v1/user-profiles
```

- List active

```bash
curl -sS http://localhost:8080/api/v1/user-profiles/active
```

## Running with Docker extras (Monitoring & Quality)

`compose.yaml` includes optional services for local development:

- **postgres**: Postgres 16 (exposes 5432)
- **prometheus**: scrapes app metrics; uses host network for easy local testing
- **grafana**: pre-provisioned dashboards; default admin password `changeme`
- **sonar**: SonarQube Community (ports 9000/9001 bound to localhost)

Start all:

```bash
docker compose up -d
```

Services:

- Prometheus config: `src/main/docker/prometheus/prometheus.yml`
- Grafana provisioning: `src/main/docker/grafana/provisioning/`

Note for macOS: remove `network_mode: host` in `compose.yaml` and replace `localhost` with `host.docker.internal` in Prometheus and Grafana datasources as hinted in comments.

## Working in your IDE

1. Open the project via `pom.xml`
2. Activate Spring profile `local` in your Run Configuration (or set `SPRING_PROFILES_ACTIVE=local`)
3. Run the application; visit Swagger UI at `http://localhost:8080/swagger-ui.html`

## Tests, coverage, and quality

- Run unit tests with coverage and style checks:

```bash
./mvnw verify -Puse-qulice
```

JaCoCo rules require at least 80% coverage overall and per-class thresholds (see `pom.xml`). You may also use the `use-testcontainers` profile to leverage ephemeral Postgres in tests:

```bash
./mvnw test -Puse-testcontainers
```

## Code conventions

The code follows the [Google Java Style Guide](https://google.github.io/styleguide/javaguide.html) and is checked by:

- SonarQube, PMD, Checkstyle, SpotBugs, Qulice

## Troubleshooting

- Cannot connect to DB: verify Postgres is running and `DATASOURCE_*` env vars match the instance
- Port conflicts: change `SERVER_PORT` or stop conflicting services
- macOS networking with Docker monitoring: see the note above regarding `network_mode: host`

## License

Licensed under the Apache License, Version 2.0. See [LICENSE](LICENSE).
