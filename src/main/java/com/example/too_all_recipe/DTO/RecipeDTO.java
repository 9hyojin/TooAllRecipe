package com.example.too_all_recipe.DTO;

import com.example.too_all_recipe.Entity.RecipeEntity;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RecipeDTO {
    private Long id;
    private String title;
    private String introduce;
    private String content;
    private String ingredients;
    private String cookingTime;

    public static RecipeDTO toRecipeDTO(RecipeEntity recipeEntity){
        RecipeDTO recipeDTO = new RecipeDTO();
        recipeDTO.setId(recipeEntity.getId());
        recipeDTO.setTitle(recipeEntity.getTitle());
        recipeDTO.setIntroduce(recipeEntity.getIntroduce());
        recipeDTO.setContent(recipeEntity.getContent());
        recipeDTO.setCookingTime(recipeEntity.getCookingTime());
        recipeDTO.setIngredients(recipeEntity.getIngredients());
        return recipeDTO;
    }


//    private MultipartFile recipeFile;  //save.html -> Controller 로 파일을 담는 용도
//    private String originalFileName;  //원래 파일이름
//    private String storedFileName;  //서버 저장용 파일 이름 (식별자)
//    private int fileAttached;  //파일 첨부 여부 (첨부 1, 미첨부 0)
}
