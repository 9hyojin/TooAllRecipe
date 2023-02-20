package com.example.too_all_recipe.Controller;

import com.example.too_all_recipe.DTO.RecipeDTO;
import com.example.too_all_recipe.Service.RecipeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class RecipeController {
    private final RecipeService recipeService;

    @GetMapping("/recipes/saveForm")
    public String saveForm(){
        return"/recipes/save";
    }

    @PostMapping("/recipes")
    public String save(@ModelAttribute RecipeDTO recipeDTO) throws IOException {
        recipeService.save(recipeDTO);
        return "callBack";    //작성해서 넘긴 데이터 찾아오기.
    }

    @GetMapping("/recipes")
    public String findAll(Model model) {
        //DB에서 전체글의 데이터를 가져와서 recipes.html에 전달.
        List<RecipeDTO> recipeDTOList = recipeService.findAll();
        model.addAttribute("recipeList", recipeDTOList);

        return "/recipes/recipes";
    }

    @GetMapping("/recipe/{id}")
    public String findById(@PathVariable Long id, Model model) {
        RecipeDTO recipeDTO = recipeService.findById(id);
        model.addAttribute("recipe", recipeDTO);
        return "/recipes/recipeDetail";
    }


    @GetMapping("/callBack")
    public String showCallback(Model model) {
        // 저장된 정보를 조회합니다.
        List<RecipeDTO> callBack = recipeService.findAll();
        // 조회 결과를 모델에 추가합니다.
        model.addAttribute("callBack", callBack);
        // 결과를 보여줄 페이지로 이동합니다.
        return "callBack";
    }












}

