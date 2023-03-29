package com.example.demo.Article.controller;

import com.example.demo.Article.dto.ArticleDto;
import com.example.demo.Article.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Delete;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping("/")
    public String postArticle(@RequestParam String subject, @RequestParam String content){
        System.out.println("s");
        articleService.create(subject, content);
        return "redirect:/article/";
    }
    @PatchMapping("/")
    public ArticleDto patchArticle(@RequestParam Long articleId, @RequestParam String articleSubject, @RequestParam String articleContent){
        ArticleDto articleDto = articleService.modify(articleId, articleSubject, articleContent);
        return articleDto;
    }
    @DeleteMapping("/")
    public void deleteArticle(@RequestParam Long articleId){
        articleService.delete(articleId);
    }
}
