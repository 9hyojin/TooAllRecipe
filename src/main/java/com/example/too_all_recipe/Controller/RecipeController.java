package com.example.too_all_recipe.Controller;

import com.example.too_all_recipe.DTO.RecipeDTO;
import com.example.too_all_recipe.Service.RecipeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
@Controller
@RequiredArgsConstructor
public class RecipeController {
    private final RecipeService recipeService;

    @GetMapping("/recipes/upload")
    public String recipeForm(){
        return"/recipes/upload";
    }

    @PostMapping("/recipes")
    public String recipeSave(@ModelAttribute RecipeDTO recipeDTO){
        recipeService.save(recipeDTO);
        return "/recipes/recipes";
    }

}

