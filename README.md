# SpringBoot-JWT
JWT Authentication on Spring Boot APIs


## Prerequisites
Ensure you have this installed before proceeding further
- Java 8
- Maven 3.3.9+
- Spring Tool Suite™ (STS) or others

## Usage


```bash

# login for generate token JWT
curl -i -H "Content-Type: application/json" -X POST -d '{
    "username": "admin",
    "password": "password"
}' http://localhost:8080/login

```
