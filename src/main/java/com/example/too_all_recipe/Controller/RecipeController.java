package com.example.too_all_recipe.Controller;

import com.example.too_all_recipe.DTO.RecipeDTO;
import com.example.too_all_recipe.Service.RecipeService;
import jakarta.annotation.Resource;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class RecipeController {
    private final RecipeService recipeService;

    @GetMapping("/recipes/save")
    public String saveForm(){
        return"/recipes/save";
    }

    @PostMapping("/recipes/save")
    public String save(@ModelAttribute RecipeDTO recipeDTO){
        recipeService.save(recipeDTO);
        return "/recipes/list";
    }

    @GetMapping("/recipes")
    public String findAll(Model model) {
        //DB에서 전체글의 데이터를 가져와서 list.html에 전달.
        List<RecipeDTO> recipeDTOList = recipeService.findAll();
        model.addAttribute("recipeList", recipeDTOList);
        return "/recipes/list";
    }

}

