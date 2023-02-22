package com.example.too_all_recipe.Controller;

import com.example.too_all_recipe.DTO.MemberDTO;
import com.example.too_all_recipe.Service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/signUp")
    public String signUp(){
        return "signUp";
    }


    @PostMapping("/signUp")
    public String saveUser(@ModelAttribute MemberDTO memberDTO) throws IOException {
        memberService.saveUser(memberDTO);
        return "login";
    }
}
