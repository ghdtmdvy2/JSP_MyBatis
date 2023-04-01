package com.example.demo.article.service;

import com.example.demo.article.dao.ArticleDao;
import com.example.demo.article.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ArticleService {
    private final ArticleRepository articleRepository;

    public List<ArticleDao> getArticleList() {
        return articleRepository.findAllArticle();
    }

    public void create(String subject, String content, Long userId) {
        ArticleDao articleDao = new ArticleDao();
        articleDao.setSubject(subject);
        articleDao.setContent(content);
        articleDao.setUsersId(userId);
        articleRepository.articleSaveMapper(articleDao);
    }

    public ArticleDao modify(Long articleId, String subject, String content) {
        ArticleDao articleDao = new ArticleDao();
        articleDao.setId(articleId);
        articleDao.setSubject(subject);
        articleDao.setContent(content);
        articleRepository.modify(articleDao);
        return articleDao;
    }

    public void delete(Long articleId) {
        ArticleDao articleDao = new ArticleDao();
        articleDao.setId(articleId);
        articleRepository.delete(articleDao);
    }
}
