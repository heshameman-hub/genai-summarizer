package com.example.genaisummarizer.service;

import com.example.genaisummarizer.dto.SummaryResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

@Service
public class SummarizerService {

    @Value("${openai.api.key}")
    private String apiKey;

    @Value("${openai.api.url}")
    private String apiUrl;

    private final WebClient webClient = WebClient.builder().build();

    @Cacheable(value = "summaries", key = "#text")
    public SummaryResponse summarize(String text) {
        String model = chooseModel(text);

        Map<String, String> summaries = new HashMap<>();
        summaries.put("bullet_points", callOpenAI(text, model, "bullet points"));
        summaries.put("executive_summary", callOpenAI(text, model, "executive summary"));

        return new SummaryResponse(summaries);
    }

    private String chooseModel(String text) {
        return text.length() < 200 ? "gpt-3.5-turbo" : "gpt-4";
    }

    private String callOpenAI(String text, String model, String format) {
        String prompt = "Summarize the following text in " + format + ":\n" + text;

        Mono<Map> response = webClient.post()
                .uri(apiUrl)
                .header("Authorization", "Bearer " + apiKey)
                .bodyValue(Map.of(
                        "model", model,
                        "messages", new Object[]{ Map.of("role","user","content", prompt) },
                        "temperature", 0.5
                ))
                .retrieve()
                .bodyToMono(Map.class);

        Map body = response.block();
        try {
            return ((Map)((Map)((java.util.List)body.get("choices")).get(0)).get("message")).get("content").toString();
        } catch (Exception e) {
            return "Error generating summary";
        }
    }
}
