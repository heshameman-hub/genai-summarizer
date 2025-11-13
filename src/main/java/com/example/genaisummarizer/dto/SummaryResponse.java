package com.example.genaisummarizer.dto;

import java.util.Map;

public class SummaryResponse {
    private Map<String, String> summaries;

    public SummaryResponse(Map<String, String> summaries) {
        this.summaries = summaries;
    }

    public Map<String, String> getSummaries() {
        return summaries;
    }
}