package com.example.too_all_recipe.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RecipeController {

    @GetMapping("/recipeUpload")
        public String recipeUpload(){
            return"./recipes/recipeUpload";
        }


}
