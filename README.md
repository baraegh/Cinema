```
  ██████╗██╗███╗   ██╗███████╗███╗   ███╗ █████╗
 ██╔════╝██║████╗  ██║██╔════╝████╗ ████║██╔══██╗
 ██║     ██║██╔██╗ ██║█████╗  ██╔████╔██║███████║
 ██║     ██║██║╚██╗██║██╔══╝  ██║╚██╔╝██║██╔══██║
 ╚██████╗██║██║ ╚████║███████╗██║ ╚═╝ ██║██║  ██║
  ╚═════╝╚═╝╚═╝  ╚═══╝╚══════╝╚═╝     ╚═╝╚═╝  ╚═╝
```

# 🎬 Cinema — Spring MVC & Hibernate

A full-stack cinema management web application built with the Spring ecosystem, Hibernate/JPA, Freemarker templates, AJAX live search, and WebSockets chat.

This project was developed as part of the **Cinema** module at **42 Network / 1337**.

---

# 🚀 Features

## 🛠 Admin Panel

Manage the entire cinema system through dedicated admin pages:

- Create and manage movie halls
- Add and manage films
- Create cinema sessions
- Upload movie posters
- Configure ticket prices and schedules

---

## 🎥 Sessions & Movies

- Display available movie sessions
- View detailed film information
- Show assigned hall and session details

---

## 🔎 Live Search (AJAX + jQuery)

- Real-time movie session search
- Dynamic page updates without page reload
- JSON API responses

---

## 💬 Real-Time Chat (WebSockets + STOMP)

- Dedicated chat room for every movie
- Real-time messaging between users
- Persistent messages stored in database
- Automatically load last 20 messages

---

## 🖼 Avatar & Image Upload

- Upload user avatars/images
- Unique filename generation
- Access uploaded images directly

---

# 🧰 Tech Stack

## Backend

- Java (LTS)
- Spring MVC
- Spring WebSocket
- Hibernate / JPA
- Maven

## Frontend

- Freemarker Templates
- HTML/CSS
- JavaScript
- jQuery

## Database

- PostgreSQL / MySQL

---

# 📁 Project Structure

```bash
Cinema/
│
├── src/
│   └── main/
│       ├── java/
│       │   └── fr/42/cinema/
│       │       ├── config/
│       │       ├── controllers/
│       │       ├── services/
│       │       ├── repositories/
│       │       ├── models/
│       │       ├── websocket/
│       │       └── utils/
│       │
│       ├── resources/
│       │   ├── sql/
│       │   │   ├── schema.sql
│       │   │   └── data.sql
│       │   └── application.properties
│       │
│       └── webapp/
│           ├── WEB-INF/
│           ├── templates/
│           ├── static/
│           └── uploads/
│
├── pom.xml
└── README.md
```

---

# ⚙️ Installation & Setup

## 1️⃣ Clone the repository

```bash
git clone git@github.com:baraegh/Cinema.git
cd cinema
```

---

## 2️⃣ Configure the database

Create a database:

```sql
CREATE DATABASE cinema;
```

Update your database credentials inside:

```bash
src/main/resources/application.properties
```

Example:

```properties
db.url=jdbc:postgresql://localhost:5432/cinema
db.username=postgres
db.password=password
```

---

## 3️⃣ Run SQL scripts

Execute:

```bash
schema.sql
data.sql
```

---

## 4️⃣ Build the project

```bash
mvn clean install
```

---

## 5️⃣ Run the application

Deploy the generated WAR file on:

- Apache Tomcat
- Jetty
- Any compatible servlet container

---

# 🌐 Main Routes

## Admin Routes

| Route | Description |
|-------|-------------|
| `/admin/panel/halls` | Manage cinema halls |
| `/admin/panel/films` | Manage films |
| `/admin/panel/sessions` | Manage sessions |

---

## User Routes

| Route | Description |
|-------|-------------|
| `/sessions/search` | Live search endpoint |
| `/sessions/{id}` | Session details |
| `/films/{id}/chat` | Real-time movie chat |

---

# 🔌 WebSocket Endpoints

| Endpoint | Description |
|----------|-------------|
| `/films/{id}/chat/messages` | Subscribe to chat messages |
| `/app/chat` | Send messages |

---

# 📡 Example JSON Response

```json
{
  "sessions": [
    {
      "id": 2,
      "dateTime": "20/12/2020 09:00",
      "film": {
        "name": "Good Film",
        "posterUrl": "images/poster.png"
      }
    }
  ]
}
```

---

# 🧠 Concepts Learned

- MVC architecture
- Spring Controllers
- Hibernate ORM
- Entity relationships
- AJAX requests
- REST APIs
- WebSockets & STOMP
- File upload handling
- Session & cookie management
- Real-time communication

---

# 📸 Screenshots

Add screenshots here:

<img width="1512" height="858" alt="Screenshot 2026-05-14 at 15 26 35" src="https://github.com/user-attachments/assets/80decd0f-2a6d-445c-a6a8-a9e0ba8c394b" />
<img width="1512" height="858" alt="Screenshot 2026-05-14 at 15 29 19" src="https://github.com/user-attachments/assets/baa2ec67-64c7-4b17-8ec8-d4f04db7157f" />
<img width="1512" height="858" alt="Screenshot 2026-05-14 at 15 30 18" src="https://github.com/user-attachments/assets/b84f8ce3-582e-4b74-9de9-01a1102d4ae0" />


---

# 📚 Subject Requirements

This project follows the specifications from the **Cinema — Spring MVC & Hibernate** subject.

Main requirements included:

- Spring MVC Controllers
- Hibernate/JPA repositories
- Freemarker templates
- AJAX live search
- STOMP WebSockets chat
- File upload system
- Persistent messaging system

---

# 👨‍💻 Author

**Elbarae EL-ghannouchi**  
Student at **1337**

---

# 📄 License

This project is for educational purposes.
