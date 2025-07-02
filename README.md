# Spring AI Image API

![Project Logo](https://raw.githubusercontent.com/orhanturkmenoglu/spring-ai-image-api/main/docs/logo.png)  
*(Varsa kendi logonu buraya ekleyebilirsin)*

---

## Açıklama

Spring AI Image API, yapay zeka destekli görsel oluşturma amaçlı geliştirilmiş bir REST API servisidir.  
Spring Boot ve WebClient kullanılarak OpenAI gibi AI modellerine istek gönderir ve dönen görüntüyü Base64 formatında sunar.

---

## Özellikler

- AI tabanlı görsel oluşturma (prompt ile)  
- Asenkron ve reaktif WebClient entegrasyonu  
- Base64 olarak resim dönüşü  
- Kolayca farklı AI servislerine uyarlanabilir  
- Modüler ve temiz kod yapısı  
- Logging ve hata yönetimi (isteğe bağlı olarak eklenebilir)  

---

## Kullanılan Teknolojiler

- **Java 17+**  
- **Spring Boot 3.x**  
- **Spring WebFlux** (WebClient)  
- **Lombok**  
- **Reactor** (Mono, Flux)  
- **OpenAI API** veya diğer AI modelleri (örnek: black-forest-labs)  

---

## Kurulum ve Çalıştırma

1. Depoyu klonlayın:

```bash
git clone https://github.com/orhanturkmenoglu/spring-ai-image-api.git
cd spring-ai-image-api
