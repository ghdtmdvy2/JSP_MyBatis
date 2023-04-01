package com.example.demo.article.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleDao {
    private Long id;
    private String subject;
    private String content;
    private Long usersId;
    private String username;
    public ArticleDao(String subject, String content, Long usersId, String username){
        this.subject = subject;
        this.content = content;
        this.usersId = usersId;
        this.username = username;
    }
}
