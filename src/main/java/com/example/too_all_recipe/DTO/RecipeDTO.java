package com.example.too_all_recipe.DTO;

import com.example.too_all_recipe.Entity.FileEntity;
import com.example.too_all_recipe.Entity.RecipeEntity;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;


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
    private MultipartFile file;
    private String originalFileName; //원본 파일 이름
    private String storedFileName; // 서버 저장용 파일 이름 - 식별자 (uuid사용해도 됨)
    private Integer FileAttached; //파일 첨부 여부 (첨부 1, 미첨부 0)

    public static RecipeDTO toRecipeDTO(RecipeEntity recipeEntity) {
        RecipeDTO recipeDTO = new RecipeDTO();
        recipeDTO.setId(recipeEntity.getId());
        recipeDTO.setTitle(recipeEntity.getTitle());
        recipeDTO.setIntroduce(recipeEntity.getIntroduce());
        recipeDTO.setContent(recipeEntity.getContent());
        recipeDTO.setCookingTime(recipeEntity.getCookingTime());
        recipeDTO.setIngredients(recipeEntity.getIngredients());
        if (recipeEntity.getFileAttached() == 0) {
            recipeDTO.setFileAttached(recipeEntity.getFileAttached()); // 0
        } else {
            recipeDTO.setFileAttached(recipeEntity.getFileAttached()); // 1
            // 파일 이름을 가져가야 함.
            // orginalFileName, storedFileName : board_file_table(BoardFileEntity)
            // join
            // select * from board_table b, board_file_table bf where b.id=bf.board_id
            // and where b.id=?
            recipeDTO.setOriginalFileName(recipeEntity.getFileEntityList().get(0).getOriginalFileName());
            recipeDTO.setStoredFileName(recipeEntity.getFileEntityList().get(0).getStoredFileName());
        }
        return recipeDTO;
    }
}



