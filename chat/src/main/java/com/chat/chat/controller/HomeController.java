package com.chat.chat.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/chat/api")
public class HomeController {

    @GetMapping("/home")
    public String homeController(){
        return "hello controller";
    }
    
}
