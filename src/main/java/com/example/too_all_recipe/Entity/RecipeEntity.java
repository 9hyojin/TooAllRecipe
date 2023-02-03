package com.example.too_all_recipe.Entity;

import com.example.too_all_recipe.DTO.RecipeDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="recipe")
public class RecipeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 45 , nullable = false)
    private String title;

    @Column(length = 500 , nullable = false)
    private String content;

    @Column (length = 45)
    private String filename;

    @Column(length = 300)
    private String filepath;

    public static RecipeEntity toSaveEntity(RecipeDTO recipeDTO){
        RecipeEntity recipeEntity = new RecipeEntity();
        recipeEntity.setTitle(recipeDTO.getTitle());
        recipeEntity.setContent(recipeDTO.getContent());
        recipeEntity.setFilename(recipeDTO.getFilename());
        recipeEntity.setFilepath(recipeDTO.getFilepath());
        return recipeEntity;
    }




}
