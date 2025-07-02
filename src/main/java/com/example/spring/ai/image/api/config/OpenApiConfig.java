package com.example.spring.ai.image.api.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Value("${spring.application.name}")
    private String applicationName;

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(buildInfo())
                .externalDocs(buildExternalDocs());
    }

    private Info buildInfo() {
        return new Info()
                .title(applicationName + " - AI Image Generation API")
                .description("This service provides AI-powered image generation using the HuggingFace API.")
                .version("1.0.0")
                .contact(buildContact())
                .license(buildLicense());
    }

    private Contact buildContact() {
        return new Contact()
                .name("Orhan Türkmenoğlu")
                .email("orhantrkmn749@gmail.com")  // Kendi mailini yazabilirsin
                .url("https://github.com/orhanturkmenoglu");
    }

    private License buildLicense() {
        return new License()
                .name("MIT License")
                .url("https://opensource.org/licenses/MIT");
    }

    private ExternalDocumentation buildExternalDocs() {
        return new ExternalDocumentation()
                .description("Project GitHub Repository")
                .url("https://github.com/orhanturkmenoglu/spring-ai-image-api");
    }
}