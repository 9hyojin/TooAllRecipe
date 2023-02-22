package com.example.too_all_recipe.Entity;

import com.example.too_all_recipe.DTO.MemberDTO;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Table(name="member_table")

public class MemberEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 100, nullable = false)
    private String userEmail;
    @Column(length = 45, nullable = false)
    private String userName;
    @Column(length = 100, nullable = false)
    private String userPassword;


    public static MemberEntity toSaveUserEntity(MemberDTO memberDTO) {
        MemberEntity memberEntity = new MemberEntity();
        memberEntity.setUserEmail(memberDTO.getUserEmail());
        memberEntity.setUserName(memberDTO.getUserName());
        memberEntity.setUserPassword(memberDTO.getUserPassword());
        return memberEntity;
    }
}






