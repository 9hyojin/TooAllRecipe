package com.example.too_all_recipe.Controller;

import com.example.too_all_recipe.DTO.MemberDTO;
import com.example.too_all_recipe.Service.MemberService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
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

    @PostMapping("/user")
    public String signup(MemberDTO memberDTO) { // 회원 추가
        memberService.saveUser(memberDTO);
        return "redirect:/login";
    }

    @GetMapping("/logout")
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
        new SecurityContextLogoutHandler().logout(request, response, SecurityContextHolder.getContext().getAuthentication());
        return "redirect:/login";
    }

//    @PostMapping("/signUp")
//    public String saveUser(@ModelAttribute MemberDTO memberDTO) throws IOException {
////        memberService.saveUser(memberDTO);
//        return "login";
}
