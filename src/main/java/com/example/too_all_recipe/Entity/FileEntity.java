package com.example.too_all_recipe.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="file_table")
public class FileEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String originalFileName;

    @Column
    private String storedFileName;

    //파일여러개에 레시피는 하나만 가능
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "recipe_id")
    private RecipeEntity recipeEntity;

    public static FileEntity toFileEntity(RecipeEntity recipeEntity, String originalFileName, String storedFileName){
        FileEntity fileEntity = new FileEntity();
        fileEntity.setOriginalFileName(originalFileName);
        fileEntity.setStoredFileName(storedFileName);
        fileEntity.setRecipeEntity(recipeEntity);  //PK값이 아닌 부모엔티티 객체를 넘겨줘야함!
        return fileEntity;
    }


}