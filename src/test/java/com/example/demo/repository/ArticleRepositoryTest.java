package com.example.demo.repository;

import com.example.demo.article.dto.ArticleDto;
import com.example.demo.article.repository.ArticleRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ArticleRepositoryTest {
    @Autowired
    ArticleRepository articleRepository;
    @Test
    void articleSaveMapper(){
        articleRepository.articleSaveMapper(new ArticleDto("테스트 제목 Mapper","테스트 내용 Mapper"));
    }
    @Test
    void articleSaveJPQL(){
        articleRepository.articleSaveJPQL(new ArticleDto("테스트 제목 JPQL","테스트 내용 JPQL"));
    }
}