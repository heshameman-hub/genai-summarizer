 🧠 GenAI Summarizer (Java Spring Boot)

This project is a **GenAI-powered microservice** built with **Java & Spring Boot**.  
It accepts a text input and returns **summaries in multiple formats** (e.g., bullet points and executive summaries).  
It also uses **smart model selection** (GPT-3.5 for short texts, GPT-4 for long ones) and **caching** to save cost and speed up responses.

---

## 🚀 Features

- ✅ REST API endpoint: `/api/summarize`
- 🧩 Accepts JSON input:
  ```json
  { "text": "Your input text here..." }
💡 Returns multiple summary formats:


executive_summary

🧠 Automatically selects model based on text length:

Short → GPT-3.5 (cheaper, faster)

Long → GPT-4 (stronger)

🔁 Caching for repeated requests (in-memory)

🛡️ Keeps API keys secure — application.properties ignored in .gitignore

🛠️ Project Setup
1️⃣ Prerequisites
Java 17+

Maven 3.8+

OpenAI API Key (you can get one from https://platform.openai.com)

2️⃣ Configuration
Create a file:
src/main/resources/application.properties

Add your OpenAI credentials:

properties

openai.api.key=sk-your-real-key-here
openai.api.url=https://api.openai.com/v1/chat/completions
server.port=8080
spring.cache.type=simple
⚠️ Never commit this file — it contains secrets.
Instead, share only the example file application.properties.template.

3️⃣ Build & Run Locally
In your terminal:

mvn clean install
mvn spring-boot:run
If everything is correct, the service will start on:

http://localhost:8080
4️⃣ Test the API
You can use curl or Postman:

🧪 Using curl:

curl -X POST http://localhost:8080/api/summarize \
  -H "Content-Type: application/json" \
  -d "{\"text\": \"Artificial intelligence is transforming industries by automating repetitive tasks, enhancing decision making, and creating new opportunities for innovation.\"}"
✅ Sample Response:

{
  "bullet_points": [
    "AI automates repetitive tasks.",
    "Enhances decision-making.",
    "Creates new innovation opportunities."
  ],
  "executive_summary": "Artificial intelligence improves efficiency and enables innovation across industries."
}
💰 Cost Optimization Strategy
Model switching: GPT-3.5 for short, GPT-4 for long.

Caching: Stores previous summaries to avoid repeated API calls.

Configurable API Key: Loaded from environment or properties (never hardcoded).

🧩 Tech Stack
Layer	Technology
Backend	Spring Boot
HTTP Client	Spring WebClient
AI Integration	OpenAI Chat API
Build Tool	Maven
Cache	Spring Cache (in-memory)

📂 Project Structure

genai-summarizer/
 ├── pom.xml
 └── src/main/
     ├── java/com/example/genaisummarizer/
     │   ├── controller/SummarizerController.java
     │   ├── service/SummarizerService.java
     │   ├── dto/TextRequest.java
     │   └── dto/SummaryResponse.java
     └── resources/
         ├── application.properties      # Local only (ignored)
         └── application.properties.template
☁️ Deployment (Optional)
You can easily deploy the API on cloud platforms such as Render, Railway, or Heroku.

Example: Deploy on Render
Push your project to GitHub.

Go to https://render.com → “New Web Service”.

Connect your GitHub repo.

Set:

Build Command: mvn clean install

Start Command: mvn spring-boot:run

Environment Variable: OPENAI_API_KEY=sk-...

Click Deploy 🎉

Your API will be available online!

👩‍💻 Author
Eman Hesham
Backend Developer

؟






