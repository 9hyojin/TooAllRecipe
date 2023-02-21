package com.example.too_all_recipe.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/home")
    public String home(){
        return "home";
    }

    @GetMapping("/place")
    public String place(){
        return "place";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/shop")
    public String shop(){
        return "shop";
    }

    @GetMapping("/my")
    public String my(){
        return "my";
    }
}
