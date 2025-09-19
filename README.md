# 🍬 Sweet-Shop-Management-System 

A full-stack **Sweet Shop Management System** designed as a **TDD Kata project**.  
This project demonstrates **backend API development, frontend implementation, database management, authentication, and testing** using modern tools and best practices.  

---

## 🎯 Objective  

The goal of this project is to design, build, and test a **complete Sweet Shop Management System** with:  
- A secure backend API  
- Database integration  
- A user-friendly Angular frontend  
- Full testing support  
- Deployment-ready workflows  

---

## ✨ Features  

- 👤 **User Authentication**  
  - Register and login  
  - JWT-based token authentication  

- 🍭 **Sweet Management**  
  - Add, update, and delete sweets  
  - Purchase sweets (quantity decreases accordingly)  

- 📦 **Order Handling**  
  - Create and manage orders  
  - Validate stock before purchase  

- 📊 **Dashboard**  
  - View sweets list  
  - Search and filter sweets  

- 🛠 **Modern Dev Practices**  
  - TDD-driven (includes unit tests)  
  - Uses AI tools for faster workflow  

---

## 🏗️ Tech Stack  

### Backend  
- **Java 21 + Spring Boot 3.5.5**  
- **Spring Security (JWT)**  
- **Spring Data JPA (Hibernate)**  

### Database  
- PostgreSQL / MySQL / SQLite (configurable)  

### Frontend  
- **Angular 17**  
- **Bootstrap / Material UI**  

### Dev Tools  
- Maven  
- JUnit 5 + Mockito (testing)  
- Postman (API testing)  

---

## ⚙️ Installation & Setup  

### 1️⃣ Clone Repository  
```bash
git clone https://github.com/yourusername/sweetshop.git
cd sweetshop
```

### 2️⃣ Backend Setup (Spring Boot)  
```bash
cd backend
mvn clean install
mvn spring-boot:run
```

Backend runs on: **http://localhost:8080**

### 3️⃣ Frontend Setup (Angular)  
```bash
cd frontend
npm install
ng serve
```

Frontend runs on: **http://localhost:4200**

---

## 🔑 Authentication Flow  

1. **Register**  
   ```http
   POST /api/auth/register
   {
     "username": "john",
     "password": "secret123",
     "role": "USER"
   }
   ```

2. **Login**  
   ```http
   POST /api/auth/login
   {
     "username": "john",
     "password": "secret123"
   }
   ```

3. **Receive JWT Token**  
   ```json
   {
     "token": "eyJhbGciOiJIUzI1..."
   }
   ```

4. **Use Token for Protected APIs**  
   ```http
   GET /api/sweets
   Authorization: Bearer <your_token>
   ```

---

## 📡 API Endpoints  

| Endpoint              | Method | Description                  |
|-----------------------|--------|------------------------------|
| `/api/auth/register`  | POST   | Register a new user          |
| `/api/auth/login`     | POST   | Login and get JWT token      |
| `/api/sweets`         | GET    | Get all sweets               |
| `/api/sweets/{id}`    | GET    | Get sweet by ID              |
| `/api/sweets`         | POST   | Add a new sweet              |
| `/api/sweets/{id}`    | PUT    | Update sweet                 |
| `/api/sweets/{id}`    | DELETE | Delete sweet                 |
| `/api/sweets/{id}/purchase`| POST   | Purchase sweet (decrease qty)|

---

## ✅ Testing  

Run backend tests:  
```bash
mvn test
```

Run frontend tests:  
```bash
ng test
```

---

## 📸 Screenshots (Demo)  

> *(Add screenshots of your Angular frontend and API responses here)*  

---

## 📜 License  

This project is licensed under the **MIT License**.  

---

🚀 Ready to manage sweets with a modern full-stack system!  
