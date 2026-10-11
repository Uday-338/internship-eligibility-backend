# Quick test after starting the backend

Use Postman or the frontend.

### Student register
POST http://localhost:8080/api/auth/register
```json
{"name":"Uday","email":"uday@example.com","phone":"9876543210","branch":"IT","year":3,"cgpa":8.2,"password":"student123"}
```

### Student login
POST http://localhost:8080/api/auth/login
```json
{"email":"uday@example.com","password":"student123","role":"STUDENT"}
```

Copy the returned `token` and send it as:
`Authorization: Bearer YOUR_TOKEN`

### Admin login
POST http://localhost:8080/api/auth/login
```json
{"email":"admin@internship.com","password":"Admin@123","role":"ADMIN"}
```

Then use the admin token for `/api/admin/**` endpoints.
