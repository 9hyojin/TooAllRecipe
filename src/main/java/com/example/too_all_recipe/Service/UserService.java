package com.example.too_all_recipe.Service;

import com.example.too_all_recipe.DTO.RecipeDTO;
import com.example.too_all_recipe.DTO.UserDTO;
import com.example.too_all_recipe.Entity.RecipeEntity;
import com.example.too_all_recipe.Entity.UserEntity;
import com.example.too_all_recipe.Repository.FileRepository;
import com.example.too_all_recipe.Repository.RecipeRepository;
import com.example.too_all_recipe.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public void saveUser(UserDTO userDTO) throws IOException {
        UserEntity userEntity = UserEntity.toSaveUserEntity(userDTO);
        userRepository.save(userEntity);
    }
}
