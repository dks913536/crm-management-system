# crm-management-system
crm-management-system
# CRM Management System

A **Customer Relationship Management (CRM)** web application built using **Java Spring Boot, JSP, Hibernate, and MySQL**.  
This project manages employees, customers, enquiries, products, and sales workflows with secure role-based access.

---

## 🚀 Features
- Employee Registration & Login (JSP + Spring Boot)
- Role-based access (Admin / Employee)
- Customer Enquiry & Follow-up Management
- Product Catalog Management
- Sales Workflow Tracking
- JSP Views + Controllers + Service + Repository layered architecture
- PostgreSQL integration with Hibernate/JPA

---

## 🛠️ Tech Stack
- **Backend:** Java 17, Spring Boot, Spring MVC, Spring Data JPA
- **Frontend:** JSP, HTML, CSS, Bootstrap
- **Database:** MySQL
- **Build Tool:** Maven,Git, Postman 
- **Server:** Tomcat (embedded with Spring Boot)

---
## 📂 Project Structure
crm-management-system/
┣ src/main/java/in/sp/main
┃ ┣ controllers/ # Controllers (CustEnquiry, Products, Main)
┃ ┣ entity/ # Entities (Employee, Customer, Product, Enquiry, FollowUp)
┃ ┣ model/ # DTOs/Models
┃ ┣ repository/ # JPA Repositories
┃ ┣ service/ # Service Interfaces + Implementations
┃ ┣ urls/ # URL mappings
┃ ┗ CrmProjectApplication.java
┣ src/main/webapp/WEB-INF/views/ # JSP views (login, employees-list, products-list, enquiry etc.)
┣ src/main/resources/ # config + application.properties
┣ pom.xml
┣ README.md
┗ .gitignore

## Configure the database

Create a MySQL database (e.g., crmdb_springboot)

Update application.properties:
spring.datasource.url=jdbc:mysql://localhost:3306/crmdb_springboot
spring.datasource.username=YOUR_DB_USERNAME
spring.datasource.password=YOUR_DB_PASSWORD

🚀 Build & Run Then visit: http://localhost:8080

🔑 Access Application
Login Page: http://localhost:8080/login
Employees: http://localhost:8080/employees
Products: http://localhost:8080/products
Customers: http://localhost:8080/customers

📸 Screenshots
Index Page 
<img width="1915" height="878" alt="image" src="https://github.com/user-attachments/assets/2c3c330c-9bd6-4a22-a50f-02af3a739385" />

🔑 Login Page
    <img width="1913" height="881" alt="image" src="https://github.com/user-attachments/assets/e7a6c53f-1a7d-4eae-97cc-27987d2ae2b5" />

🏠 Dashboard (Login As Admin)
<img width="1918" height="361" alt="image" src="https://github.com/user-attachments/assets/4f4805d9-2039-4244-ac6b-e96c7f7722bd" />
➕ Register Emoployee
<img width="1918" height="880" alt="image" src="https://github.com/user-attachments/assets/526e486b-d784-4a66-b39f-6594ed48a6fa" />

➕ Add Products
<img width="1918" height="896" alt="image" src="https://github.com/user-attachments/assets/fc3ee0e1-4807-4fd2-bb06-bdee09b13b4f" />

📋 Products List
<img width="1918" height="863" alt="image" src="https://github.com/user-attachments/assets/0398c49e-2e6c-41ca-9915-6f80cc087486" />

🏠 Dashboard (Login As Employee)
<img width="1918" height="873" alt="image" src="https://github.com/user-attachments/assets/a2db863e-67fb-45e5-a08c-f6a7cdebec16" />

📋 Enquiry Form
<img width="1916" height="880" alt="image" src="https://github.com/user-attachments/assets/33d3d8e4-0e86-4513-902c-32589be2a283" />

➕ Customer Followup
<img width="1917" height="878" alt="image" src="https://github.com/user-attachments/assets/48290152-67cb-4fbf-8661-67a53050ca98" />


👨‍💻 Author
Deepak Kumar Singh
GitHub: @dks913536
