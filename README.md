BookHaven — Online Bookstore 📚

A modern full-stack online bookstore web application built using Spring Boot, Thymeleaf, and MySQL.
Customers can browse and purchase books seamlessly, while administrators can manage the bookstore through a secure admin dashboard.

✨ Features
👤 Customer Features
Browse all available books
Live search books by title
Add/remove books from cart
Session-based shopping cart
Checkout with customer details
Automatic order confirmation email after purchase
🔐 Admin Features
Secure admin authentication
Add new books with cover image upload
Edit book details
Delete books from catalog
Search books instantly by title
🛠️ Tech Stack
Layer	Technology
Backend	Java 22, Spring Boot 3.5
Frontend	Thymeleaf, HTML5, CSS3
Database	MySQL
ORM	Spring Data JPA, Hibernate
Email Service	Spring Mail (Gmail SMTP)
Build Tool	Maven
📂 Project Structure
bookstore/
├── src/
│   └── main/
│       ├── java/bookstore/
│       │   ├── BookstoreApplication.java
│       │   ├── controller/
│       │   │   └── HomeController.java
│       │   ├── model/
│       │   │   └── Book.java
│       │   └── repository/
│       │       └── BookRepository.java
│       │
│       └── resources/
│           ├── templates/
│           │   ├── shop.html
│           │   ├── cart.html
│           │   ├── checkout.html
│           │   ├── admin.html
│           │   ├── edit.html
│           │   ├── login.html
│           │   └── success.html
│           │
│           ├── static/
│           │   └── images/
│           │
│           └── application.properties
│
└── pom.xml
⚙️ Setup & Installation
Prerequisites

Make sure you have installed:

Java 22+
Maven
MySQL
1️⃣ Clone the Repository
git clone https://github.com/basavarajsindgi91-netizen/bookstore.git
cd bookstore
2️⃣ Create MySQL Database
CREATE DATABASE bookstore;
3️⃣ Configure Environment Variables

Create a file:

src/main/resources/application-local.properties

Add the following configuration:

DB_PASSWORD=your_mysql_password

MAIL_USERNAME=your_email@gmail.com
MAIL_PASSWORD=your_gmail_app_password
📧 Gmail App Password Setup
Open your Google Account
Go to Security
Enable 2-Step Verification
Open App Passwords
Generate a password for this application
4️⃣ Run the Application
mvn spring-boot:run

Application will start at:

http://localhost:8083
🔐 Admin Credentials
Field	Value
Login URL	/login
Username	admin
Password	admin123
📸 Application Pages
Page	URL	Access
Shop	/	Public
Cart	/cart	Public
Checkout	/checkout	Public
Admin Dashboard	/admin	Admin
Admin Login	/login	Admin
📬 Order Confirmation Email

After successful checkout, customers automatically receive an email containing:

Ordered book details
Total amount
Delivery address
Purchase confirmation
🚀 Future Improvements
User authentication & registration
Payment gateway integration
Order history tracking
Book categories & filters
Responsive mobile UI
Wishlist functionality
🧑‍💻 Author

Basavaraj Sindagi

GitHub: basavarajsindgi91-netizen
📄 License

This project is licensed under the MIT License.

⭐ Support

If you like this project, consider giving it a ⭐ on GitHub!
