package com.example.too_all_recipe.Entity;

import com.example.too_all_recipe.DTO.RecipeDTO;
import com.example.too_all_recipe.DTO.UserDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="user_table")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 45, nullable = false)
    private String loginId;

    @Column(length = 45, nullable = false)
    private String userName;

    @Column(length = 100, nullable = false)
    private String userPassword;

    @Column(length = 100, nullable = false)
    private String password2;

    public static UserEntity toSaveUserEntity(UserDTO userDTO){
        UserEntity userEntity  = new UserEntity();
        userEntity.setLoginId(userDTO.getLoginId());
        userEntity.setUserName(userDTO.getUserName());
        userEntity.setUserPassword(userDTO.getUserPassword());
        userEntity.setPassword2(userDTO.getPassword2());
        return userEntity;
    }


}




