package com.example.demo.Article.service;

import com.example.demo.Article.dto.ArticleDto;
import com.example.demo.Article.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ArticleService {
    private final ArticleRepository articleRepository;

    public List<ArticleDto> getArticleList() {
        return articleRepository.findAllArticle();
    }
}
