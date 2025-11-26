package com.example.generalapi;

import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class NewsService {
    @Value("${newsapi.key}")
    private String apiKey;

    private String apiUrl = "https://newsapi.org/v2/top-headlines";

    private final RestTemplate restTemplate = new RestTemplate();

    public Map<String, Object> getTopHeadlines(String country, String category) {
        String url = String.format("%s?country=%s&category=%s&apiKey=%s", apiUrl, country, category, apiKey);

        return restTemplate.getForObject(url, Map.class);
    }

}

