package com.example.spring.ai.image.api.service;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Base64;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ProxyService {

    private static final String MODEL = "black-forest-labs/flux-dev";
    private final WebClient webClient;

    public Mono<byte[]> generateImage(String prompt){
        Map<String,Object> requestBody = Map.of(
                "response_format", "b64_json",
                "prompt", prompt,
                "model", MODEL
        );

        return webClient.post()
                .uri("/nebius/v1/images/generations")
                .bodyValue(requestBody)
                .retrieve()
                .bodyToMono(JsonNode.class)
                .handle((json, sink) -> {
                    JsonNode dataNode = json.path("data");
                    if (dataNode.isArray() && dataNode.size() > 0) {
                        String base64 = dataNode.get(0).path("b64_json").asText(null);
                        if (base64 != null) {
                            sink.next(Base64.getDecoder().decode(base64));
                            return;
                        }
                        sink.error(new RuntimeException("No base64 data found"));
                    }
                    sink.error(new RuntimeException("Unexpected response: " + json.toPrettyString()));
                });
    }


}
