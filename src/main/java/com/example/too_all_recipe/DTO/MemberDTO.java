package com.example.too_all_recipe.DTO;


import com.example.too_all_recipe.Entity.MemberEntity;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MemberDTO {
    private Long id;
    private String userEmail;
    private String userName;
    private String userPassword;

    public static MemberDTO toUserDTO(MemberEntity memberEntity) {
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setId(memberEntity.getId());
        memberDTO.setUserEmail(memberEntity.getUserEmail());
        memberDTO.setUserName(memberEntity.getUserName());
        memberDTO.setUserPassword(memberEntity.getUserPassword());
        return memberDTO;
    }

}
