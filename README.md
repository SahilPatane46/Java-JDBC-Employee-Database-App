# 🗄️ Java JDBC – Employee Database App

A **Java database application** that connects to **MySQL/PostgreSQL** using **JDBC**.  
This project demonstrates how to perform **CRUD operations** (Create, Read, Update, Delete) on an Employee table.

---

## 📖 Objective
- Learn how to connect Java with a database using **JDBC driver**.
- Perform CRUD operations with **PreparedStatement** and **ResultSet**.
- Understand **SQL + Java integration**.

---

## 🚀 Features
✔️ Connect to MySQL/PostgreSQL database  
✔️ Add new employee records  
✔️ View all employees  
✔️ Update employee details  
✔️ Delete employee records  
✔️ Clean and secure database access using **PreparedStatement**  

---

## 🛠 Tools & Requirements
- **Java JDK 8+**
- **VS Code / IntelliJ IDEA / Eclipse**
- **MySQL or PostgreSQL**
- **JDBC Driver** (MySQL Connector / PostgreSQL JDBC)

---

## ⚙️ Database Setup

### MySQL Example
1. Start MySQL server.  
2. Create a database and table:
   ```sql
   CREATE DATABASE companyDB;

   USE companyDB;

   CREATE TABLE employees (
       id INT PRIMARY KEY AUTO_INCREMENT,
       name VARCHAR(100) NOT NULL,
       department VARCHAR(50),
       salary DOUBLE
   );
3. Download MySQL JDBC driver (mysql-connector-j.jar) and add it to your classpath.

## ▶️ How to Run
1. Save the file as EmployeeDBApp.java.
2. Compile:
```bash
javac -cp ".;mysql-connector-j-8.0.33.jar" EmployeeDBApp.java
3. Run:
```bash
java -cp ".;mysql-connector-j-8.0.33.jar" EmployeeDBApp
(For PostgreSQL, replace MySQL connector with PostgreSQL JDBC driver.)
