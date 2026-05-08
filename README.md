# 📚 BookHaven — Online Bookstore

<div align="center">

A modern full-stack online bookstore built using Spring Boot, Thymeleaf, and MySQL.

![Java](https://img.shields.io/badge/Java-22-orange?style=for-the-badge)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.5-brightgreen?style=for-the-badge)
![MySQL](https://img.shields.io/badge/MySQL-Database-blue?style=for-the-badge)
![Thymeleaf](https://img.shields.io/badge/Thymeleaf-Frontend-darkgreen?style=for-the-badge)

</div>

---

## ✨ Features

### 👤 Customer Features

- Browse available books
- Live search by title
- Add/remove books from cart
- Session-based cart management
- Checkout system
- Order confirmation email

### 🔐 Admin Features

- Secure admin login
- Add new books
- Upload cover images
- Edit book details
- Delete books
- Search books instantly

---

# 🛠️ Tech Stack

| Technology | Used |
|------------|------|
| Backend | Java 22, Spring Boot 3.5 |
| Frontend | Thymeleaf, HTML, CSS |
| Database | MySQL |
| ORM | Spring Data JPA / Hibernate |
| Email | Spring Mail (Gmail SMTP) |
| Build Tool | Maven |

---

# 📂 Project Structure

```bash
bookstore/
│
├── src/
│   └── main/
│       ├── java/bookstore/
│       │   ├── controller/
│       │   ├── model/
│       │   ├── repository/
│       │   └── BookstoreApplication.java
│       │
│       └── resources/
│           ├── templates/
│           ├── static/images/
│           └── application.properties
│
└── pom.xml
```

---

# ⚙️ Installation & Setup

## 1️⃣ Clone Repository

```bash
git clone https://github.com/basavarajsindgi91-netizen/bookstore.git
cd bookstore
```

---

## 2️⃣ Create Database

```sql
CREATE DATABASE bookstore;
```

---

## 3️⃣ Configure Credentials

Create:

```bash
src/main/resources/application-local.properties
```

Add:

```properties
DB_PASSWORD=your_mysql_password

MAIL_USERNAME=your_email@gmail.com
MAIL_PASSWORD=your_gmail_app_password
```

---

## 4️⃣ Run Application

```bash
mvn spring-boot:run
```

Application runs on:

```bash
http://localhost:8083
```

---

# 🔐 Admin Login

| Field | Value |
|------|------|
| URL | `/login` |
| Username | `admin` |
| Password | `admin123` |

---

# 📸 Pages

| Page | URL |
|------|------|
| Shop | `/` |
| Cart | `/cart` |
| Checkout | `/checkout` |
| Admin Panel | `/admin` |
| Login | `/login` |

---

# 📬 Email Confirmation

After checkout, customers receive an email containing:

- Ordered books
- Total amount
- Delivery address
- Purchase confirmation

---

# 🚀 Future Enhancements

- User authentication
- Payment gateway
- Order history
- Wishlist
- Mobile responsive UI
- Category filters

---

# 👨‍💻 Author

### Basavaraj Sindagi

- GitHub: [basavarajsindgi91-netizen](https://github.com/basavarajsindgi91-netizen)

---

# ⭐ Support

If you like this project, give it a ⭐ on GitHub.

---

# 📄 License

This project is licensed under the MIT License.
