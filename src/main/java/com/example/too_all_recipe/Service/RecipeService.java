package com.example.too_all_recipe.Service;

import com.example.too_all_recipe.DTO.RecipeDTO;
import com.example.too_all_recipe.Entity.RecipeEntity;
import com.example.too_all_recipe.Repository.RecipeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RecipeService {
    private final RecipeRepository recipeRepository;
    public void save(RecipeDTO recipeDTO) {
        RecipeEntity recipeEntity = RecipeEntity.toSaveEntity(recipeDTO);
        recipeRepository.save(recipeEntity);
    }
}
