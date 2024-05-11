# To-Do List RESTful API

## Overview
This project is my very first RESTful API, created based on the trainee course provided by the students of Emakers Jr, a junior company at the Federal University of Lavras. It is designed to manage tasks efficiently, following the MVC (Model-View-Controller) pattern for structuring the application. Key features include database management using Flyway for migrations, documentation with Swagger, implementation with Spring Boot, CORS support for cross-origin requests, PostgreSQL for data storage, and specialized exception handling for robust error management.

## Features

### MVC Architecture
The application is structured according to the MVC design pattern, separating concerns into models, views, and controllers for better organization and scalability.

### Flyway Migrations
Database migrations are managed seamlessly with Flyway, ensuring smooth updates to the database schema as the application evolves.

### Swagger Documentation
API endpoints are documented using Swagger, providing clear and comprehensive documentation for developers to interact with the API effortlessly.

### Spring Boot
The application is built using Spring Boot, offering a powerful and flexible framework for developing Java applications with minimal configuration.

### CORS Support
Cross-Origin Resource Sharing (CORS) is implemented to allow secure interaction between the API and client applications hosted on different domains.

### PostgreSQL Database
Data is stored in a PostgreSQL database, providing reliability, scalability, and support for complex data structures.

### Exception Handling
Specialized exception handling is implemented to provide detailed error messages and graceful degradation in case of unexpected errors, ensuring a smooth user experience.

## Getting Started

### Prerequisites
- Java Development Kit (JDK) 17
- Apache Maven
- PostgreSQL

### Installation
1. Clone the repository:

```bash
git clone https://github.com/gabrafo/ToDoListAPI.git
cd APItest
```

2. Create `application.properties` file:
- Create a new `application.properties` file in the `src/main/resources` directory.
- Add your database configuration to this file. For example:

```
spring.datasource.url=jdbc:postgresql://localhost:5432/todo_database
spring.datasource.username=your_username
spring.datasource.password=your_password
```

3. Build and run the application:

```
mvn spring-boot:run
```

4. Access the API documentation:
Open your web browser and navigate to `http://localhost:8080/swagger-ui.html` to view the Swagger documentation.

## Usage
- Use the provided API endpoints to perform CRUD operations on tasks.
- Refer to the Swagger documentation for detailed information on available endpoints and request/response formats.
