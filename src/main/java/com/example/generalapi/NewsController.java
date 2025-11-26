package com.example.generalapi;

import org.jspecify.annotations.Nullable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class NewsController {
    private final NewsService newsService;

    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    @GetMapping("/news")
    public  Map<String, Object> getNews(
        @RequestParam(defaultValue = "us") String country,
        @RequestParam(defaultValue = "general") String category){
        return newsService.getTopHeadlines(country, category);

    }
}
