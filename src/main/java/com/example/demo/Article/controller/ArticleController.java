package com.example.demo.Article.controller;

import com.example.demo.Article.dto.ArticleDto;
import com.example.demo.Article.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/article")
public class ArticleController {
    private final ArticleService articleService;
    @GetMapping("/")
    public String getArticleList(Model model){
        List<ArticleDto> articleList = articleService.getArticleList();
        model.addAttribute("articleList",articleList);
//        model.addAttribute("test","test에요");
        return "article/list";
    }
}
