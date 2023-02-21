package com.example.too_all_recipe.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping("/signUp")
    public String signUp(){
        return "signUp";
    }
}
