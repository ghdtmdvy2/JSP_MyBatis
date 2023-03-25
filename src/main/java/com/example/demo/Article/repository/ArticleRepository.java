package com.example.demo.Article.repository;

import com.example.demo.Article.dto.ArticleDto;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ArticleRepository {
    void articleSaveMapper(ArticleDto articleDto);

    // insert into article(subject, content) values("제목", "내용");

    @Insert("insert into article(subject, content) values(#{subject}, #{content})")
    void articleSaveJPQL(ArticleDto articleDto);
}
