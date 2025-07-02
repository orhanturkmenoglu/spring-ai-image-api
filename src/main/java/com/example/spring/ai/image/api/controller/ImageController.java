package com.example.spring.ai.image.api.controller;

import com.example.spring.ai.image.api.service.ProxyService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/image")
@RequiredArgsConstructor
@Tag(name = "Image Generation API", description = "API for generating images from text prompts")
public class ImageController {

    private final ProxyService proxyService;

    @Operation(summary = "Generate image from prompt",
            description = "Generates an image based on the provided text prompt. Returns PNG image bytes.")
    @GetMapping(value = "/generate", produces = MediaType.IMAGE_PNG_VALUE)
    public Mono<ResponseEntity<byte[]>> generateImage(
            @Parameter(description = "Text prompt for image generation", required = true)
            @RequestParam String prompt) {
        return proxyService.generateImage(prompt)
                .map(imageBytes -> ResponseEntity
                        .ok()
                        .contentType(MediaType.IMAGE_PNG)
                        .body(imageBytes));
    }
}
