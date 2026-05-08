# 📚 BookHaven — Online Bookstore

<div align="center">

A modern full-stack online bookstore built using Spring Boot, Thymeleaf, and MySQL.

![Java](https://img.shields.io/badge/Java-22-orange?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.5-brightgreen?style=for-the-badge&logo=springboot&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-Database-blue?style=for-the-badge&logo=mysql&logoColor=white)
![Thymeleaf](https://img.shields.io/badge/Thymeleaf-Frontend-darkgreen?style=for-the-badge&logo=thymeleaf&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-Build-red?style=for-the-badge&logo=apachemaven&logoColor=white)
![MIT License](https://img.shields.io/badge/License-MIT-yellow?style=for-the-badge)

</div>

---

## ✨ Features

<table>
<tr>
<td width="50%">

### 👤 Customer Features
- 🔍 Browse & live-search books by title
- 🛒 Add / remove books from cart
- 🧾 Session-based cart management
- 💳 Checkout system
- 📧 Order confirmation email

</td>
<td width="50%">

### 🔐 Admin Features
- 🔒 Secure admin login
- ➕ Add new books with cover images
- ✏️ Edit & delete book listings
- 🔍 Instant book search

</td>
</tr>
</table>

---

## 🛠️ Tech Stack

| Layer | Technology |
|-------|-----------|
| **Backend** | Java 22, Spring Boot 3.5 |
| **Frontend** | Thymeleaf, HTML, CSS |
| **Database** | MySQL |
| **ORM** | Spring Data JPA / Hibernate |
| **Email** | Spring Mail (Gmail SMTP) |
| **Build** | Maven |

---

## 📂 Project Structure

```bash
bookstore/
│
├── src/
│   └── main/
│       ├── java/bookstore/
│       │   ├── controller/          # MVC Controllers
│       │   ├── model/               # Entity classes
│       │   ├── repository/          # JPA Repositories
│       │   └── BookstoreApplication.java
│       │
│       └── resources/
│           ├── templates/           # Thymeleaf HTML templates
│           ├── static/images/       # Static assets
│           └── application.properties
│
└── pom.xml
```

---

## ⚙️ Installation & Setup

### 1️⃣ Clone the Repository

```bash
git clone https://github.com/basavarajsindgi91-netizen/bookstore.git
cd bookstore
```

### 2️⃣ Create the Database

```sql
CREATE DATABASE bookstore;
```

### 3️⃣ Configure Credentials

Create the file `src/main/resources/application-local.properties` and add:

```properties
DB_PASSWORD=your_mysql_password
MAIL_USERNAME=your_email@gmail.com
MAIL_PASSWORD=your_gmail_app_password
```

> 💡 **Tip:** For Gmail, use an [App Password](https://support.google.com/accounts/answer/185833) instead of your main account password.

### 4️⃣ Run the Application

```bash
mvn spring-boot:run
```

The app will start at → **[http://localhost:8083](http://localhost:8083)**

---

## 🔐 Admin Access

| Field | Value |
|-------|-------|
| **URL** | `/login` |
| **Username** | `admin` |
| **Password** | `admin123` |

> ⚠️ Change these credentials before deploying to production.

---

## 📸 Pages

| Page | URL |
|------|-----|
| 🏪 Shop | `/` |
| 🛒 Cart | `/cart` |
| 💳 Checkout | `/checkout` |
| 🛠️ Admin Panel | `/admin` |
| 🔒 Login | `/login` |

---

## 📬 Order Confirmation Email

After a successful checkout, customers automatically receive an email containing:

- 📖 List of ordered books
- 💰 Total amount
- 🏠 Delivery address
- ✅ Purchase confirmation

---

## 🚀 Future Enhancements

- [ ] User authentication & registration
- [ ] Payment gateway integration
- [ ] Order history & tracking
- [ ] Wishlist functionality
- [ ] Mobile responsive UI
- [ ] Category filters & sorting

---

## 👨‍💻 Author

**Basavaraj Sindagi**

[![GitHub](https://img.shields.io/badge/GitHub-basavarajsindgi91--netizen-181717?style=for-the-badge&logo=github)](https://github.com/basavarajsindgi91-netizen)

---

## ⭐ Support

If you find this project useful, please consider giving it a **⭐ star** on GitHub — it helps others discover the project!

---

## 📄 License

This project is licensed under the **MIT License** — see the [LICENSE](LICENSE) file for details.
