package com.example.too_all_recipe.Controller;

import com.example.too_all_recipe.DTO.RecipeDTO;
import com.example.too_all_recipe.DTO.UserDTO;
import com.example.too_all_recipe.Service.RecipeService;
import com.example.too_all_recipe.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/signUp")
    public String signUp(){
        return "signUp";
    }

    @PostMapping("/signUp")
    public String saveUser(@ModelAttribute UserDTO userDTO) throws IOException {
        userService.saveUser(userDTO);
        return "login"; 
    }
}
