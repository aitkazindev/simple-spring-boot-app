Here is a `README.md` file for your project:

```markdown
# Spring Simple App

This is a simple Spring Boot application that demonstrates basic CRUD operations with a PostgreSQL database.

## Prerequisites

- Java 23
- Maven
- Docker
- Docker Compose

## Getting Started

### Clone the repository

```bash
git clone https://github.com/aitkazindev/spring-simple-app.git
cd spring-simple-app
```

### Build the project

```bash
mvn clean install
```

### Run the application with Docker Compose

```bash
docker-compose up --build
```

This will start the Spring Boot application and a PostgreSQL database.

### Access the application

The application will be accessible at `http://localhost:8080`.

## Configuration

The application configuration is located in `src/main/resources/application.properties`.

### Database Configuration

The database connection properties are set in the `docker-compose.yml` file and passed as environment variables to the Spring Boot application.

```yaml
environment:
  - SPRING_DATASOURCE_URL=jdbc:postgresql://db:5432/mydb
  - SPRING_DATASOURCE_USERNAME=myuser
  - SPRING_DATASOURCE_PASSWORD=mypassword
```

## Running Tests

To run the tests, use the following command:

```bash
mvn test
```

## Docker

### Build Docker Image

To build the Docker image, run:

```bash
docker build -t spring-simple-app .
```

### Run Docker Container

To run the Docker container, use:

```bash
docker run -p 8080:8080 spring-simple-app
```

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
```
