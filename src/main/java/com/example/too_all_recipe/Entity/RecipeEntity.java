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

    @Column(length = 300)
    private String introduce;

    @Column(length = 800 , nullable = false)
    private String content;

    @Column(length = 500, nullable = false)
    private String ingredients;

    @Column(length = 20)
    private String cookingTime;

    @Column
    private Integer fileAttached; //첨부 1 or 미첨부 0



    public static RecipeEntity toSaveEntity(RecipeDTO recipeDTO){
        RecipeEntity recipeEntity = new RecipeEntity();
        recipeEntity.setTitle(recipeDTO.getTitle());
        recipeEntity.setIntroduce(recipeDTO.getIntroduce());
        recipeEntity.setCookingTime(recipeDTO.getCookingTime());
        recipeEntity.setContent(recipeDTO.getContent());
        recipeEntity.setIngredients(recipeDTO.getIngredients());
        recipeEntity.setFileAttached(0); //파일 미첨부
        return recipeEntity;
    }


}
