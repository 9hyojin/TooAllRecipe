package com.example.too_all_recipe.DTO;


import com.example.too_all_recipe.Entity.UserEntity;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserDTO {
    private Long id;
    private String loginId;
    private String userName;
    private String userPassword;
    private String password2;


    public static UserDTO toUserDTO(UserEntity userEntity) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(userEntity.getId());
        userDTO.setLoginId(userEntity.getLoginId());
        userDTO.setUserName(userEntity.getUserName());
        userDTO.setUserPassword(userEntity.getUserPassword());
        userDTO.setPassword2(userEntity.getPassword2());
        return userDTO;
    }

}
