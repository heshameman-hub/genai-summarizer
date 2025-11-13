package com.example.genaisummarizer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class GenAiSummarizerApplication {
    public static void main(String[] args) {
        SpringApplication.run(GenAiSummarizerApplication.class, args);
    }
}