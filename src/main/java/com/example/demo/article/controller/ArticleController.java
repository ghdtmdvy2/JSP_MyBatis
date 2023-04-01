package com.example.demo.article.controller;

import com.example.demo.article.dao.ArticleDao;
import com.example.demo.article.service.ArticleService;
import com.example.demo.user.context.UserContext;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
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
    @PreAuthorize("isAuthenticated()")
    public String getArticleList(Model model, @AuthenticationPrincipal UserContext userContext){
        List<ArticleDao> articleList = articleService.getArticleList();
        model.addAttribute("articleList",articleList);
        model.addAttribute("userContext", userContext);
//        model.addAttribute("test","test에요");
        return "article/list";
    }
    @PostMapping("/")
    public String postArticle(@RequestParam String subject, @RequestParam String content, @AuthenticationPrincipal UserContext userContext){
        System.out.println("s");
        articleService.create(subject, content, userContext.getId());
        return "redirect:/article/";
    }
    @PatchMapping("/")
    public ArticleDao patchArticle(@RequestParam Long articleId, @RequestParam String articleSubject, @RequestParam String articleContent){
        ArticleDao articleDao = articleService.modify(articleId, articleSubject, articleContent);
        return articleDao;
    }
    @DeleteMapping("/")
    public void deleteArticle(@RequestParam Long articleId){
        articleService.delete(articleId);
    }
}
