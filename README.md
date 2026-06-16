# Spring Boot Product API

A RESTful API built with Spring Boot for managing products. This project demonstrates backend development concepts including CRUD operations, DTO validation, database integration using Spring Data JPA, and version-controlled database migrations using Flyway.

## Features

- Create, Read, Update, and Delete (CRUD) products
- DTO-based request validation
- Spring Data JPA integration
- H2 in-memory database
- Flyway database migrations
- Seeded sample product data
- RESTful API design with proper HTTP status codes

## Technologies Used

- Java 21
- Spring Boot 3.5.15
- Spring Web
- Spring Data JPA
- Flyway
- H2 Database
- Maven
- Jakarta Validation

## Project Structure

```
src
├── main
│   ├── java
│   │   └── com.example.Product_api
│   │       ├── controller
│   │       ├── dto
│   │       ├── model
│   │       ├── repository
│   │       └── service
│   └── resources
│       └── db
│           └── migration
│               ├── V1__Create_product_table.sql
│               └── V2__Insert_sample_data.sql
```

## API Endpoints

| Method | Endpoint | Description |
|----------|----------|----------|
| GET | `/api/products` | Get all products |
| GET | `/api/products/{id}` | Get product by ID |
| POST | `/api/products` | Create a product |
| PUT | `/api/products/{id}` | Update a product |
| DELETE | `/api/products/{id}` | Delete a product |

## Sample Product JSON

```json
{
  "name": "Laptop",
  "description": "Gaming Laptop",
  "price": 1200
}
```

## Database Migrations

Flyway automatically executes the following migrations on startup:

### V1__Create_product_table.sql

Creates the Product table.

### V2__Insert_sample_data.sql

Inserts sample products:

- Gaming Mouse
- Mechanical Keyboard
- 4K Monitor

## Running the Application

Clone the repository:

```bash
git clone https://github.com/subhojit1707-crypto/Spring-boot-Product-api.git
```

Navigate to the project:

```bash
cd Spring-boot-Product-api
```

Run the application:

```bash
./mvnw spring-boot:run
```

For Windows:

```cmd
mvnw.cmd spring-boot:run
```

## H2 Database Console

Access the H2 Console:

http://localhost:8080/h2-console

Configuration:

```text
JDBC URL: jdbc:h2:mem:productdb
Username: sa
Password:
```

## Example API Requests

### Get All Products

```http
GET http://localhost:8080/api/products
```

### Get Product By ID

```http
GET http://localhost:8080/api/products/1
```

### Create Product

```http
POST http://localhost:8080/api/products
Content-Type: application/json
```

```json
{
  "name": "Laptop",
  "description": "Gaming Laptop",
  "price": 1200
}
```

### Update Product

```http
PUT http://localhost:8080/api/products/1
```

```json
{
  "name": "Updated Laptop",
  "description": "Updated Description",
  "price": 1500
}
```

### Delete Product

```http
DELETE http://localhost:8080/api/products/1
```

## Internship Tasks Covered

### Task 1: Build a RESTful API with Spring Boot

- Spring Web
- Spring Data JPA
- CRUD Endpoints
- DTO Validation
- Proper HTTP Status Codes

### Task 2: Database Integration & Migrations

- H2 Relational Database
- Spring Data JPA
- Flyway Database Migrations
- Seed Sample Data

## Author

**Subhojit Mandal**

GitHub: https://github.com/subhojit1707-crypto