package com.example.too_all_recipe.DTO;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RecipeDTO {
    private Long id;
    private String title;
    private String content;
    private String filename;
    private String filepath;


}
