# Bank Management System (Java Swing & JDBC / MySQL)

## Professional Overview
The **Bank Management System** is a desktop application engineered in Java using **Swing GUI** and **JDBC** connected to a **MySQL** relational database. Developed for the *Database Systems* and *Object-Oriented Programming* courses at UET Lahore, this application manages client accounts, financial transactions, customer profiles, and system feedback using clean Data Access Object (DAO) abstraction patterns.

## Objectives
- Apply core Object-Oriented Programming principles (Encapsulation, Inheritance, Polymorphism, Abstraction).
- Implement the Data Access Object (DAO) architectural pattern to decouple persistence logic from presentation UI.
- Design and query a normalized MySQL relational database schema complete with Entity-Relationship Diagrams (ERD).

## Features
- **Interactive Java Swing GUI**: Graphical dashboard (`BankGUI.java`) for managing client accounts and system navigation.
- **Account & Financial Operations**: Account creation, deposit processing, withdrawal verification, and dynamic balance inquiries.
- **Data Access Object (DAO) Pattern**: `BankDAO.java` encapsulating parameterized SQL queries and database CRUD operations.
- **Relational Database Backend**: MySQL database structure modeled via ER Diagram (`sql.mwb`, `ERD.png`).
- **Resilient Fallback Storage**: Dynamic JDBC connection wrapper (`DBConnection.java`) with in-memory datastore fallback (`DataStore.java`).

## Technologies Used
- **Primary Language**: Java (JDK 8+)
- **GUI Framework**: Java Swing / AWT
- **Database Connectivity**: JDBC (Java Database Connectivity)
- **Database Engine**: MySQL / MySQL Workbench

## Architecture Overview
The system follows a standard 3-Tier Architecture:
1. **Presentation Layer**: `BankGUI.java` (User Interface & Event Handling).
2. **Business / Domain Layer**: `Account`, `Bank`, `Client`, `Customer`, `Person` domain models.
3. **Persistence Layer**: `BankDAO.java` and `DBConnection.java` interacting with MySQL Database tables.

## Folder Structure
```text
bank-management-system-java/
├── src/
│   ├── Account.java
│   ├── Bank.java
│   ├── BankDAO.java
│   ├── BankGUI.java
│   ├── Client.java
│   ├── Customer.java
│   ├── DBConnection.java
│   ├── DataStore.java
│   ├── FeedbackStore.java
│   ├── Main.java
│   ├── Person.java
│   └── TestDB.java
├── docs/
│   ├── Bank Management System Lab Report.pdf
│   └── sql.mwb
├── assets/
│   ├── diagrams/
│   │   ├── ERD.png
│   │   ├── Modeling Additions.png
│   │   └── Proj StrJDBC.png
│   └── screenshots/
│       ├── Output SQL.png
│       └── Views.png
├── .gitignore
├── LICENSE
└── README.md
```

## Installation Guide
1. Ensure Java Development Kit (JDK 8 or higher) and MySQL Server are installed.
2. Import `docs/sql.mwb` into MySQL Workbench or execute database initialization scripts.
3. Configure database host, port, username, and password in `src/DBConnection.java`.
4. Compile Java source files:
```bash
javac src/*.java
```

## How to Run
Run the compiled `Main` class:
```bash
java -cp src Main
```

## Screenshots & Diagrams
Entity Relationship Diagram (ERD) & Database Output:
![ERD Diagram](assets/diagrams/ERD.png)
![SQL Output](assets/screenshots/Output%20SQL.png)
![Database Views](assets/screenshots/Views.png)

## Verification & Documentation
- [Bank Management System Lab Report (PDF)](docs/Bank%20Management%20System%20Lab%20Report.pdf)
- [MySQL Workbench Schema Model](docs/sql.mwb)

## Learning Outcomes
- Architected desktop applications utilizing OOP design patterns (DAO, Singleton DB connection).
- Integrated MySQL database operations with Java applications via parameterized JDBC statements.
- Developed normalized relational database schemas enforcing primary/foreign key integrity constraints.

## Future Improvements
- Integrate BCrypt password hashing and user role-based access control (Admin vs. Customer).
- Migrate presentation layer to modern JavaFX or Web REST API (Spring Boot).
- Add automated transaction auditing and PDF receipt generation.

## License
Distributed under the MIT License. See `LICENSE` for more information.

## Author
**Tahniat Farhan**  
BS Cyber Security  
University of Engineering and Technology (UET) Lahore
