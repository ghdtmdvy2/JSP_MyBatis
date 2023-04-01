package com.example.demo.user.controller;

import com.example.demo.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    @GetMapping("/login")
    public String login(){
        return "user/login";
    }
    @GetMapping("/signup")
    public String signup(){
        return "user/signup";
    }
    @PostMapping("/signup")
    public String postSignup(@RequestParam String username, @RequestParam String password){
        userService.create(username, password);
        return "redirect:/article/";
    }
}
