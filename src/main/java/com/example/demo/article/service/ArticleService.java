package com.example.demo.article.service;

import com.example.demo.article.dto.ArticleDto;
import com.example.demo.article.repository.ArticleRepository;
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

    public void create(String subject, String content) {
        ArticleDto articleDto = new ArticleDto();
        articleDto.setSubject(subject);
        articleDto.setContent(content);
        articleRepository.articleSaveMapper(articleDto);
    }

    public ArticleDto modify(Long articleId, String subject, String content) {
        ArticleDto articleDto = new ArticleDto();
        articleDto.setId(articleId);
        articleDto.setSubject(subject);
        articleDto.setContent(content);
        articleRepository.modify(articleDto);
        return articleDto;
    }

    public void delete(Long articleId) {
        ArticleDto articleDto = new ArticleDto();
        articleDto.setId(articleId);
        articleRepository.delete(articleDto);
    }
}
