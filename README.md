# Internship Eligibility Checker - Spring Boot Backend

Backend built to match the existing `internship-checker` frontend API contract.

## Stack
Java 17, Spring Boot 3.5.6, Maven, Spring Web, Spring Data JPA, MySQL, Spring Security, JWT.

## 1. Create MySQL database
MySQL can create it automatically, but this is also valid:
```sql
CREATE DATABASE internship_checker;
```

## 2. Configure password
Open `src/main/resources/application.properties` and replace:
```properties
spring.datasource.password=YOUR_MYSQL_PASSWORD
```
with your MySQL root password.

## 3. Run backend
In IntelliJ, run `InternshipEligibilityBackendApplication.java`.
Or:
```bash
mvn spring-boot:run
```
Backend: `http://localhost:8080`
API: `http://localhost:8080/api`

## Default admin
The first startup creates:
- Email: `admin@internship.com`
- Password: `Admin@123`
- Role: `ADMIN`

Change the password for a real deployment.

## Frontend connection
The supplied frontend already uses:
`http://localhost:8080/api`

Run the frontend with Live Server on port 5500.

## API contract
- POST `/api/auth/register`
- POST `/api/auth/login`
- GET `/api/students/me`
- PUT `/api/students/me`
- GET `/api/internships`
- GET `/api/internships/{id}`
- POST `/api/internships/{id}/check-eligibility`
- POST `/api/applications`
- GET `/api/applications/my`
- POST `/api/admin/internships`
- PUT `/api/admin/internships/{id}`
- DELETE `/api/admin/internships/{id}`
- GET `/api/admin/students`
- GET `/api/admin/applications`
- PUT `/api/admin/applications/{id}/status`

## Notes
Eligibility is calculated on the backend using CGPA, branch and required skills. Duplicate applications are blocked. JWT is required for protected APIs.
