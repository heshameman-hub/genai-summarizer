package com.example.genaisummarizer.controller;

import com.example.genaisummarizer.dto.SummaryResponse;
import com.example.genaisummarizer.dto.TextRequest;
import com.example.genaisummarizer.service.SummarizerService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class SummarizerController {

    private final SummarizerService summarizerService;

    public SummarizerController(SummarizerService summarizerService) {
        this.summarizerService = summarizerService;
    }

    @PostMapping("/summarize")
    public SummaryResponse summarize(@RequestBody TextRequest request) {
        return summarizerService.summarize(request.getText());
    }
}