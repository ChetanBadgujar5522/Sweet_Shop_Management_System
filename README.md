
# 🍬 Sweet-Shop-Management-System  

A full-stack **Sweet Shop Management System** built as a **TDD Kata project**.  
This system demonstrates backend API development, database integration, frontend UI, authentication, and automated testing, following **modern development workflows**.  

---

## 🎯 Objective  

The goal of this kata is to **design, build, and test** a complete Sweet Shop Management System that covers:  
- Secure backend APIs  
- Database management  
- Angular frontend  
- Authentication and authorization  
- TDD practices with high test coverage  
- AI-assisted development  

---

## ✨ Features  

- 👤 **User Authentication**  
  - Register & login with credentials  
  - JWT-based authentication  
  - Role-based access (User/Admin)  

- 🍭 **Sweet Management**  
  - Add, update, delete sweets (Admin only)  
  - Purchase sweets (decrease stock)  
  - Restock sweets (Admin only)  

- 📦 **Orders**  
  - Create and manage orders  
  - Validate stock before purchase  

- 🔎 **Search & Filter**  
  - Search sweets by name, category, or price range  
  - Filter sweets easily in dashboard  

- 📊 **Dashboard**  
  - List all available sweets  
  - Interactive UI with real-time updates  

---

## 🏗️ Tech Stack  

### Backend  
- **Java 21 + Spring Boot 3.5.5**  
- **Spring Security (JWT)**  
- **Spring Data JPA + Hibernate**  

### Database  
- PostgreSQL  

### Frontend  
- **Angular 17**  
- **Bootstrap + Angular Material**  

### Dev Tools  
- **Maven** (build tool)  
- **JUnit 5 + Mockito** (testing)  
- **Postman** (API testing)  

---

## ⚙️ Installation & Setup  

### 1️⃣ Clone Repository  
```bash
git clone https://github.com/ChetanBadgujar5522/Sweet_Shop_Management_System.git
cd sweetshop-management-system
```

---

### 2️⃣ Backend Setup (Spring Boot)  
```bash
cd SweetShop
mvn clean install
mvn spring-boot:run
```

Backend runs on: **http://localhost:8080**

---

### 3️⃣ Frontend Setup (Angular)  
```bash
cd sweetshop-frontend
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

| Endpoint                   | Method | Description                     |
|----------------------------|--------|---------------------------------|
| `/api/auth/register`       | POST   | Register a new user             |
| `/api/auth/login`          | POST   | Login and get JWT token         |
| `/api/sweets`              | GET    | Get all sweets                  |
| `/api/sweets/search`       | GET    | Search sweets                   |
| `/api/sweets/{id}`         | GET    | Get sweet by ID                 |
| `/api/sweets`              | POST   | Add a new sweet (Admin only)    |
| `/api/sweets/{id}`         | PUT    | Update sweet (Admin only)       |
| `/api/sweets/{id}`         | DELETE | Delete sweet (Admin only)       |
| `/api/sweets/{id}/purchase`| POST   | Purchase sweet (decrease qty)   |
| `/api/sweets/{id}/restock` | POST   | Restock sweet (Admin only)      |

---

## ✅ Testing  

### Backend Tests  
```bash
cd SweetShop
mvn test
```

### Frontend Tests  
```bash
cd sweetshop-frontend
ng test
```

Expected: **High coverage reports following TDD principles**.  

---

## 📸 Screenshots  

> *(Add screenshots of your Angular dashboard, login screen, API responses from Postman here)*  

---

## 🤖 My AI Usage  

This project was developed with **AI-assisted workflows** to improve efficiency.  

- **Tools Used**:  
  - ChatGPT (for boilerplate generation, debugging help, and README creation)  
  - GitHub Copilot (for auto-completion and unit test suggestions)  

- **How AI Helped**:  
  - Generated initial **Spring Boot boilerplate code** (controllers, services).  
  - Helped in writing **JUnit + Mockito unit tests**.  
  - Suggested **Angular form validation snippets**.  
  - Drafted this **README.md** file structure.  

- **Reflection**:  
  AI tools accelerated development but did not replace manual coding.  
  I reviewed, modified, and tested all AI-generated code to ensure correctness and maintainability.  

---

## 📜 License  

This project is licensed under the **MIT License**.  

---

🚀 Ready to manage sweets with a modern full-stack system!  
