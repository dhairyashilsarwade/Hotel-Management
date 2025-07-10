# Hotel Management System

The **Hotel Management System** is a console-based Java application that allows hotel staff to manage room records. It supports adding, viewing, and deleting room entries stored in a PostgreSQL database. The application is built using **Core Java**, **JDBC**, and **PostgreSQL**, and uses multithreading for logging actions to a `.log` file.

---

## Features

- Add new hotel room with type and price
- View all available rooms with ID, type, and price
- Delete a room based on ID
- Threaded logging of all operations to a log file
- Simple menu-driven interface for easy navigation

---

## Technologies Used

- **Java 17**
- **PostgreSQL 15+**
- **JDBC 4.2**
- **Apache Maven 3.8.6+**
- **Multithreading & File I/O**

---

## Dependency

```xml
<dependency>
    <groupId>org.postgresql</groupId>
    <artifactId>postgresql</artifactId>
    <version>42.7.7</version>
</dependency>
```

---

## Prerequisites

Make sure you have the following installed:

- **Java JDK 17 or newer**
- **Apache Maven**
- **PostgreSQL (configured and running)**

---

## Database Setup

1. **Create a new database:**

```sql
CREATE DATABASE hotel;
```

2. **Create the `rooms` table:**

```sql
CREATE TABLE rooms (
    id SERIAL PRIMARY KEY,
    type VARCHAR(100) NOT NULL,
    price NUMERIC(10, 2) NOT NULL
);
```

---

## How to Run

Clone the repository or download the code.  
Open the project in VS Code, IntelliJ, or Eclipse.  
**In `HotelDBManager.java`, configure your DB credentials:**

```java
private static final String URL = "jdbc:postgresql://localhost:5432/hotel";
private static final String USER = "postgres";
private static final String PASSWORD = "yourpassword";
```

Build the project:

```bash
mvn clean install
```

Run `MainFile.java`.

---

## Log Output

- All room-related actions are logged to a file called `hotel-actions.log` with timestamps, for example:

```
[2025-07-10 17:25:42] Added room: Deluxe
[2025-07-10 17:26:05] Deleted room ID: 2
```

---

## Input Validations

- Room Type: Cannot be empty
- Room Price: Must be a valid decimal number
- Room ID (for deletion): Must be a valid number

---

## Contact

- **Developer:** Dhairyashil Sarwade        
- **Email:** dhairyashilsarwade.com
- **GitHub:** dhairyashilsarwade

---

**Happy coding!**
