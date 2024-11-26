# Voter Information Management System

A robust **Voter Information Management System** built using **Hibernate** and **Java**. This project enables efficient management of voter details, including personal information, voter IDs, and addresses, with features for CRUD operations and dynamic queries.

---

## Table of Contents
- [Introduction](#introduction)
- [Features](#features)
- [Technologies Used](#technologies-used)
- [Prerequisites](#prerequisites)


---

## Introduction

The **Voter Information Management System** streamlines voter data management through a user-friendly console application. It supports various operations, including adding, updating, and deleting voter records, with dynamic search functionality for enhanced usability. Integration with Hibernate ensures efficient database interactions with MySQL for persistent data storage.

---

## Features

### CRUD Operations
- Add new voters.
- View all voters.
- Update voter details dynamically.
- Delete voters by Aadhar number.

### Search Functionality
- Search voters by name.
- Search voters by city.
- Search voters by constituency.

### Database Integration
- Uses MySQL for persistent data storage.
- Hibernate ORM for efficient data handling.

### Dynamic Input
- Real-time data entry via console inputs.

---

## Technologies Used

- **Programming Language**: Java
- **Framework**: Hibernate
- **Database**: MySQL
- **Build Tool**: Maven (if applicable)
- **Development Environment**: Any IDE (e.g., IntelliJ IDEA, Eclipse)

---

## Prerequisites

Before running the project, ensure the following:

1. **Java Development Kit (JDK)**: Java 8 or later is installed.
2. **MySQL**: Set up a MySQL database instance.
3. **Hibernate Configuration**: Update the `hibernate.cfg.xml` file with your database credentials.

### Sample `hibernate.cfg.xml`

```xml
<hibernate-configuration>
    <session-factory>
        <property name="hibernate.connection.driver_class">com.mysql.cj.jdbc.Driver</property>
        <property name="hibernate.connection.url">jdbc:mysql://localhost:3306/voterId?createDatabaseIfNotExist=true</property>
        <property name="hibernate.connection.username">root</property>
        <property name="hibernate.connection.password">password</property>
        <property name="hibernate.dialect">org.hibernate.dialect.MySQLDialect</property>
        <property name="hibernate.hbm2ddl.auto">update</property>
        <property name="show_sql">true</property>
    </session-factory>
</hibernate-configuration>


