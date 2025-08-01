# 🚀 User Profile CRUD - Sample MvcRest App

Minimal Spring Boot-based RESTful CRUD example, which manages a user profile entity (including Swagger UI).

## Technology stack

Java 21, Spring Boot, JPA, Postgres.

## Prerequisites

The following items should be installed in your system:

- Java 21 or newer.
- git command line tool (https://help.github.com/articles/set-up-git)
- Your preferred IDE (IDEA preferably)

## Database configuration

The application uses PostgreSQL as a persistent storage. Options to get it up:

1. Use a remote existing PostgreSQL. It is needed to specify the path in configs.
1. Start local postgres in docker `docker compose -f compose.yaml up -d`

### Running locally

This application is a [Spring Boot](https://spring.io/guides/gs/spring-boot) application built
using [Maven](https://spring.io/guides/gs/maven/). You can build a jar file and run it from the command line:

```bash
git clone https://github.com/IQKV/quickstart-mvc-rest-user-profile-crud.git
cd quickstart-mvc-rest-user-profile-crud
./mvnw package
java -jar target/*.jar
```

You might also want to use Maven's `spring-boot:run` goal - applications run in an exploded form, as they do in your IDE:

```bash
./mvnw spring-boot:run -Dspring-boot.run.profiles=local -P dev
```

Now you can access to the Swagger UI here: http://localhost:8080/swagger-ui.html

### Working with the Application in your IDE

1. On the command line

```bash
git clone https://github.com/IQKV/quickstart-mvc-rest-user-profile-crud.git
```

2. Inside IDE

In the main menu, choose `File -> Open` and select the Application [pom.xml](pom.xml). Click on the `Open` button.
Activate "local" profile in the Run settings or set it via environment
variables. [instruction](https://stackoverflow.com/questions/38520638/how-to-set-spring-profile-from-system-variable)
Wait for indexing completion and push the green "play" button.

3. Navigate to Swagger UI

Visit [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html) in your browser.

## Code conventions

The code adheres to the [Google Code Conventions](https://google.github.io/styleguide/javaguide.html). Code
quality is measured by:

- [SonarQube](https://docs.sonarsource.com/)
- [PMD](https://pmd.github.io/)
- [CheckStyle](https://checkstyle.sourceforge.io/)
- [SpotBugs](https://spotbugs.github.io/)
- [Qulice](https://www.qulice.com/)

### Tests

This project contains JUnit tests, Hamcrest matchers, Mockito test doubles, Wiremock stubs, etc. You can run the test suite using

```bash
./mvnw verify -Puse-qulice
```

The minimum percentage of code coverage required for the workflow to pass is **80%**.
