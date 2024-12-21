# Yurtify - Web Application

The Yurtify project represents a fictional dormitory service company's website. On this page, you can explore Yurtify dormitories. The website is equipped with cutting-edge technologies. The frontend utilizes Next.js, while the backend leverages Java, Docker, and Flyway technologies.

On this page, you can find information about Yurtify's dormitories, browse photos, list contact information, and submit dormitory registration requests.

Users can log into the system as either an Admin or a Regular User. As a regular user, you will have limited access to menus and buttons in the interface. However, Admin users can navigate the system without any restrictions and have access to the Dormitory Management Menu, Student Management Menu, and Room Management Menu

## Features

- **Administration:**
    - Dormitory, Room, Student administration.

- **Strong Backend:**
  - Strong backend support is provided using Java, Spring Boot, Flyway, and Docker technologies.

- **Solid:**
    - The development followed the SOLID principles.

- **Relational:**
    - PostgreSQL was used as the relational database, and the data is stored relationally on PostgreSQL.

## Installation

### Requirements
- Java 17 or higher
- Maven
- PostgreSQL
- Docker

1. **Clone the repository:**

   ```bash
   git clone https://github.com/Maoziy/yurtify.git

2. **Docker-compose up:**

   ```bash
    cd docker
    
    docker-compose up

3. **Build:**

   ```bash
    mvn clean install -DskipTests

4. **Run:**

   - Now you can run the project  :D

## Postman Collection

- [Postman Collection](postman/YURTIFY.postman_collection.json)