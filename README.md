# 🤖 AI-Powered Enterprise Support Agent

A production-style intelligent support agent built with **Java 17+**, **Spring Boot 3**, and **LangChain4j** — designed to answer enterprise client queries using a **RAG (Retrieval-Augmented Generation)** pipeline grounded in company-specific knowledge base documents.

> Built as a learning + portfolio project by [Sundaram Mishra](https://github.com/HarshMishra28) — Software Engineer transitioning into AI-integrated backend development.

---

## 🎯 Problem It Solves

Enterprise B2B companies (fintech, SaaS, logistics) receive hundreds of repetitive support queries daily — API errors, KYC questions, SLA policies, onboarding help. Human agents waste hours answering the same questions.

This AI agent:
- Answers instantly from a company knowledge base (no hallucination)
- Works 24/7 with zero wait time
- Cites the exact source document for every answer
- Remembers conversation context across messages
- Saves all chat history to MySQL for audit trail

---

## 🏗️ System Architecture

```
User (Chat UI)
      ↓
ChatController  (REST API - receives message)
      ↓
ChatService     (Business logic - RAG pipeline + LLM call)
      ↓
LangChain4j     (RAG + LLM integration via OpenRouter)
      ↓
ChatRepository  (Saves chat history to MySQL)
      ↓
Response back to User with source citation
```

---

## 🛠️ Tech Stack

| Layer | Technology |
|-------|-----------|
| Language | Java 21 |
| Framework | Spring Boot 3.5.14 |
| AI / LLM | LangChain4j + OpenRouter (Mistral 7B / Llama 3) |
| RAG Pipeline | LangChain4j EmbeddingStore + RAG |
| Database | MySQL 8.0 |
| ORM | Spring Data JPA / Hibernate |
| Build Tool | Maven |
| IDE | VS Code |

---

## ✨ Key Features

- **RAG Pipeline** — AI answers ONLY from uploaded knowledge base documents. Zero hallucination.
- **Source Citations** — Every response shows which document it came from.
- **Conversation Memory** — AI remembers previous messages in a session.
- **Knowledge Base API** — Admin endpoint to upload company documents.
- **Chat History** — All conversations saved to MySQL with timestamps.
- **REST API** — Clean JSON endpoints consumable by any frontend.
- **Chat UI** — Simple HTML/JS interface served by Spring Boot.

---

## 📁 Project Structure

```
src/main/java/com/sundaram/aisupportagent/
├── controller/
│   └── ChatController.java       # REST endpoints
├── service/
│   └── ChatService.java          # Business logic + AI calls
├── model/
│   └── ChatHistory.java          # Database entity
├── repository/
│   └── ChatRepository.java       # MySQL operations
├── config/
│   └── LangChainConfig.java      # LangChain4j configuration
└── AiSupportAgentApplication.java # Entry point

src/main/resources/
└── application.properties        # Configuration (not pushed to GitHub)
```

---

## 🚀 Getting Started

### Prerequisites

- Java 21+
- MySQL 8.0+
- Maven (or use included `mvnw`)
- OpenRouter API key (free at [openrouter.ai](https://openrouter.ai))

### Setup

**1. Clone the repository**
```bash
git clone https://github.com/HarshMishra28/ai-support-agent.git
cd ai-support-agent
```

**2. Create MySQL database**
```sql
CREATE DATABASE aisupportdb;
```

**3. Create application.properties**

Create `src/main/resources/application.properties` with:
```properties
server.port=8080
spring.datasource.url=jdbc:mysql://localhost:3306/aisupportdb
spring.datasource.username=root
spring.datasource.password=YOUR_MYSQL_PASSWORD
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
spring.jpa.show-sql=true
spring.application.name=ai-support-agent
openrouter.api.key=YOUR_OPENROUTER_API_KEY
```

**4. Run the application**
```bash
./mvnw spring-boot:run
```

**5. Open in browser**
```
http://localhost:8080
```

---

## 📡 API Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/api/chat` | Send message, get AI response |
| POST | `/api/knowledge` | Upload document to knowledge base |
| GET | `/api/chat/history` | Get chat history |

### Example Request
```json
POST /api/chat
{
  "message": "What is your refund policy?",
  "sessionId": "user-123"
}
```

### Example Response
```json
{
  "reply": "Our refund policy allows full refunds within 30 days of purchase...",
  "source": "Refund Policy Document v2.1, Section 3",
  "sessionId": "user-123"
}
```

---

## 🧠 What I Learned Building This

- Spring Boot 3 architecture (Controller → Service → Repository)
- REST API design with proper separation of concerns
- JPA/Hibernate for database management without writing SQL
- LangChain4j for Java-based LLM integration
- RAG (Retrieval Augmented Generation) pipeline implementation
- Vector embeddings and semantic search concepts
- Dependency Injection and Spring Boot auto-configuration
- Production-ready application.properties configuration
- Git workflow for professional development

---

## 🗺️ Build Progress

- [x] Phase 0 — Development environment setup
- [x] Phase 1 — Spring Boot project setup + MySQL connection
- [ ] Phase 2 — ChatController + ChatService + basic REST API
- [ ] Phase 3 — RAG pipeline + LangChain4j integration
- [ ] Phase 4 — Chat UI + knowledge base management
- [ ] Phase 5 — Polish + demo video + deployment

---

## 👨‍💻 About

**Sundaram Mishra** — Software Engineer with 2+ years experience in Java, Spring Boot, and JavaScript. Currently building expertise in AI-integrated backend systems.

- 🔗 [LinkedIn](https://linkedin.com/in/sundarammishra)
- 🐙 [GitHub](https://github.com/HarshMishra28)

---

## 📄 License

This project is open source and available under the [MIT License](LICENSE).
