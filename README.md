# Office Management CRUD Application

## Overview
This project is a CRUD (Create, Read, Update, Delete) application for office management. It's designed to manage office-related data, including employee details, office environments, and more. The application is built using Java technologies and follows a servlet-based architecture.

## Features
- **Create, Read, Update, Delete Operations:** Allows users to add, view, update, and remove office data.
- **Employee Management:** Manage employee details effectively.
- **Office Environment Settings:** Customize and manage different office environments.

## Technologies Used
- **Java:** The core language used for the backend development.
- **Servlets:** Used for handling requests and responses in the web application.
- **JSP (JavaServer Pages):** For creating dynamic web content.
- **Hibernate:** For object-relational mapping and database operations.
- **MySQL:** As the database to store office data.

## Structure
- **Servlets:** The `src/main/java/int202/officecrud/officecrud` directory contains servlets like `HelloServlet`, `OfficeAddServlet`, `OfficeFindServlet`, etc., for handling various operations.
- **Models:** The `src/main/java/int202/officecrud/officecrud/model` directory includes models like `Employee`, `Environment`, and `Office`.
- **Repository:** The `src/main/java/int202/officecrud/officecrud/repository` contains `OfficeRepository` for database operations.
- **Utilities:** The `src/main/java/int202/officecrud/officecrud/utils` includes utility classes like `Validator`.
- **Web Pages:** The `src/main/webapp` directory contains JSP files for the user interface.
