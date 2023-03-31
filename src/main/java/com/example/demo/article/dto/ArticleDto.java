package com.example.demo.article.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleDto {
    private Long id;
    private String subject;
    private String content;
    public ArticleDto(String subject, String content){
        this.subject = subject;
        this.content = content;
    }
}
