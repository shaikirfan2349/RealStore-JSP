# RealStore-JSP

RealStore is an **e-commerce management system** built with **Spring Boot** and **JSPs**, designed to provide a complete web-based solution for managing categories, products, users, carts, and orders. This version includes **JSP-based frontend UI**.

## Features
- **User Authentication**: Register, login, and secure access.
- **Dynamic UI**: JSPs for frontend rendering.
- **Category & Product Management**: Add, update, and view products.
- **Cart & Order Handling**: Users can add items to the cart and place orders.
- **Spring Security**: Role-based authentication for admins and users.

## Tech Stack
- **Backend**: Java, Spring Boot, Spring Security
- **Frontend**: JSP, JSTL, Bootstrap (optional)
- **Database**: MySQL
- **Build Tool**: Maven

## Installation & Setup
### Prerequisites
- Java 17+
- MySQL Server
- Maven
- Tomcat Server (for JSP rendering)

### Steps
1. **Clone the repository**
   ```sh
   git clone https://github.com/shaikirfan2349/RealStore-JSP.git
   cd RealStore-JSP
   ```
2. **Configure Database**
   - Update `application.properties` with MySQL credentials.
3. **Build & Run the project**
   ```sh
   mvn clean install
   mvn spring-boot:run
   ```
4. **Access the Web App**
   - Open `http://localhost:8080` in your browser.

## Future Enhancements
- Improve UI with React or Angular.
- Add user profile and order tracking.
- Integrate a payment gateway.

## Author
[Irfan Shaik](https://github.com/shaikirfan2349)
