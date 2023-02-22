package com.example.too_all_recipe.Service;

import com.example.too_all_recipe.DTO.MemberDTO;
import com.example.too_all_recipe.Entity.MemberEntity;
import com.example.too_all_recipe.Repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;



@Service
@RequiredArgsConstructor
public class MemberService  {
    private final MemberRepository memberRepository;

    public void saveUser(MemberDTO memberDTO) {
        MemberEntity memberEntity = MemberEntity.toSaveUserEntity(memberDTO);
        memberRepository.save(memberEntity);
    }
}


