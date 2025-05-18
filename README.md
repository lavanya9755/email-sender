# 📧 Email Sender Service - Spring Boot

This project is a simple **Spring Boot** based email sender service. It supports sending plain text emails, HTML emails, and emails with attachments using **JavaMailSender**.

---

## 🚀 Features

- Send simple text emails
- Send emails to multiple recipients
- Send HTML content emails
- Send email with file attachments
- Attach files from `File` or `InputStream`

---

## 📦 Dependencies

- Spring Boot Starter Mail
- Jakarta Mail
- SLF4J Logger

Make sure your `pom.xml` includes:
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-mail</artifactId>
</dependency>
````

---

## 🔧 Configuration

Update the `application.properties` file with your email configuration:

```properties
spring.mail.host=smtp.gmail.com
spring.mail.port=587
spring.mail.username=your_email@gmail.com
spring.mail.password=your_email_password_or_app_password
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true
```

> ⚠️ **Use App Password** if you're using Gmail with 2FA enabled.

---

## 🧪 Usage

### 1. Send Simple Email

```java
emailService.sendEmail("to@example.com", "Subject", "Hello from Spring Boot");
```

### 2. Send Email to Multiple Recipients

```java
emailService.sendEmail(new String[]{"a@example.com", "b@example.com"}, "Group Mail", "This is a test");
```

### 3. Send Email with Attachment (from File)

```java
File file = new File("path/to/file.txt");
emailService.sendEmailwithFile("to@example.com", "Subject", "Message body", file);
```

### 4. Send Email with HTML Content

```java
emailService.sendEmailwithHTML("to@example.com", "Subject", "<h1>Hello</h1><p>This is HTML</p>");
```

### 5. Send Email with File (from InputStream)

```java
InputStream ins = new FileInputStream("path/to/file.txt");
emailService.sendEmailwithFile("to@example.com", "Subject", "Message body", ins);
```

---

## 📁 Project Structure

```
src/
├── main/
│   ├── java/
│   │   └── com/example/demo/
│   │       ├── services/
│   │       │   └── EmailService.java
│   │       └── impl/
│   │           └── EmailServiceImpl.java
│   └── resources/
│       ├── application.properties
│       └── email/ (used for InputStream attachment saving)
```

---

## 🧠 Notes

* Constructor injection is preferred for better testability, but field injection using `@Autowired` also works.
* Make sure the file path used with `InputStream` exists (`src/main/resources/email/`).
* The logger is used to print success messages; check your console or logs.

---
