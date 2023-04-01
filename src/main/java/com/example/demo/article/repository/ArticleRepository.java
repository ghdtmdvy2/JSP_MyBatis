package com.example.demo.article.repository;

import com.example.demo.article.dao.ArticleDao;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ArticleRepository {
    void articleSaveMapper(ArticleDao articleDao);

//    @Insert("insert into article(subject, content) values(#{subject}, #{content})")
//    void articleSaveJPQL(ArticleDto articleDto);

    List<ArticleDao> findAllArticle();

    void modify(ArticleDao articleDao);

    void delete(ArticleDao articleDao);
}
