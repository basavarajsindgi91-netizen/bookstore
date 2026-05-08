BookHaven — Online Bookstore
A full-stack online bookstore web application built with Spring Boot, Thymeleaf, and MySQL. Customers can browse and purchase books, while admins can manage the entire catalog through a dedicated panel.

🚀 Features
Customer Side

Browse all available books on a clean, elegant shop page
Search books by title (live search)
Add/remove books from a session-based cart
Checkout with name, mobile, email, and delivery address
Receive an order confirmation email automatically after placing an order

Admin Side

Secure admin login
Add new books with title, author, price, and cover image upload
Edit existing book details
Delete books from the catalog
Search books by title


🛠️ Tech Stack
LayerTechnology
Backend: Java 22, Spring Boot 3.5
Frontend: Thymeleaf, HTML, CSS
Database: MySQL ORMSpring Data JPA / HibernateEmailSpring Mail (Gmail SMTP)Build ToolMaven

⚙️ Setup & Installation
Prerequisites

Java 22+
Maven
MySQL

1. Clone the repository
bashgit clone https://github.com/basavarajsindgi91-netizen/bookstore.git
cd bookstore
2. Create the database
sqlCREATE DATABASE bookstore;
3. Configure credentials
Create src/main/resources/application-local.properties (this file is gitignored):
propertiesDB_PASSWORD=your_mysql_password
MAIL_USERNAME=your_email@gmail.com
MAIL_PASSWORD=your_gmail_app_password

Gmail App Password: Go to your Google Account → Security → 2-Step Verification → App Passwords, and generate one for this app.

4. Run the application
bashmvn spring-boot:run
The app will start at http://localhost:8083

🔐 Admin Access
FieldValueURL/loginUsername:admin Password:admin123

📁 Project Structure
bookstore/
├── src/
│   └── main/
│       ├── java/bookstore/
│       │   ├── BookstoreApplication.java
│       │   ├── controller/HomeController.java
│       │   ├── model/Book.java
│       │   └── repository/BookRepository.java
│       └── resources/
│           ├── templates/        # Thymeleaf HTML pages
│           │   ├── shop.html
│           │   ├── cart.html
│           │   ├── checkout.html
│           │   ├── admin.html
│           │   ├── edit.html
│           │   ├── login.html
│           │   └── success.html
│           ├── static/images/    # Book cover images
│           └── application.properties
└── pom.xml

📸 Pages
PageURLAccessShop/PublicCart/cartPublicCheckout/checkoutPublicAdmin/adminAdminLogin/loginAdmin

📬 Order Email
After a successful checkout, the customer receives a confirmation email with:

List of ordered books and prices
Total amount
Delivery address


📝 License
This project is open source and available under the MIT License.
