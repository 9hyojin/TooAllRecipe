package com.example.too_all_recipe.Service;

import com.example.too_all_recipe.DTO.RecipeDTO;
import com.example.too_all_recipe.Entity.FileEntity;
import com.example.too_all_recipe.Entity.RecipeEntity;
import com.example.too_all_recipe.Repository.FileRepository;
import com.example.too_all_recipe.Repository.RecipeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RecipeService {
    private final RecipeRepository recipeRepository;
    private final FileRepository fileRepository;

    public void save(RecipeDTO recipeDTO) throws IOException {
        //파일 첨부 여부에 따라 로직 분리
        if (recipeDTO.getFile().isEmpty()) {
            //첨부파일 없음
            RecipeEntity recipeEntity = RecipeEntity.toSaveEntity(recipeDTO);
            recipeRepository.save(recipeEntity);
        } else {
            //첨부파일 있음
            /*
                1. DTO에 담긴 파일을 꺼냄
                2. 파일의 이름 가져옴
                3. 서버 저장용 이름을 만듦
                4. 저장 경로 설정
                5. 해당 경로에 파일 저장
                6. recipe_table에 해당 데이터 save처리
                7. recipe_file_table에 해당 데이터 save처리
             */
            MultipartFile file = recipeDTO.getFile(); // 1.
            String originalFilename = file.getOriginalFilename(); // 2.
            String storedFileName = System.currentTimeMillis() + "_" + originalFilename; // 3.  uuid를 사용해도 되고, currentTimeMillis 사용해도 됨.
            String savePath = "/Users/koo/springboot_img/" + storedFileName;
            file.transferTo(new File(savePath)); // 5.
            RecipeEntity recipeEntity = RecipeEntity.toSaveFileEntity(recipeDTO);
            Long saveId = recipeRepository.save(recipeEntity).getId();  //getId 하는 이유: 자식테이블에서는 부모의 PK가 필요함. (Long타입 아닌 RecipeEntity타입)
            RecipeEntity recipe = recipeRepository.findById(saveId).get(); //부모 엔티티를 db에서 가져옴

            FileEntity fileEntity = FileEntity.toFileEntity(recipe, originalFilename, storedFileName);
            fileRepository.save(fileEntity);
        }
    }






    public List<RecipeDTO> findAll() {
        List<RecipeEntity> recipeEntityList = recipeRepository.findAll();
        List<RecipeDTO> recipeDTOList = new ArrayList<>();
        for (RecipeEntity recipeEntity : recipeEntityList) {
            recipeDTOList.add(RecipeDTO.toRecipeDTO(recipeEntity));
        }
        return recipeDTOList;
    }
}
