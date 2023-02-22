package com.example.too_all_recipe.Repository;

import com.example.too_all_recipe.DTO.MemberDTO;
import com.example.too_all_recipe.Entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<MemberEntity,Long> {
    Optional<MemberEntity>findByUserEmail(String userEmail);
}
