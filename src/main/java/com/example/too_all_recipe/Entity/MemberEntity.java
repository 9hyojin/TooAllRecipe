package com.example.too_all_recipe.Entity;

import com.example.too_all_recipe.DTO.MemberDTO;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name="member_table")

public class MemberEntity implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    private String userEmail;

    @Column(length = 45, nullable = false)
    private String userName;

    @Column(length = 100, nullable = false)
    private String userPassword;

    @Column(name = "auth")
    private String auth;

    @Builder
    public MemberEntity(String userEmail, String userPassword, String auth) {
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.auth = auth;
    }



    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<GrantedAuthority> roles = new HashSet<>();
        for (String role : auth.split(",")) {
            roles.add(new SimpleGrantedAuthority(role));
        }
        return roles;
    }

    // 사용자의 id를 반환 (unique한 값)
    @Override
    public String getUsername() {
        return userEmail;
    }

    // 사용자의 password를 반환
    @Override
    public String getPassword() {
        return userPassword;
    }

    // 계정 만료 여부 반환
    @Override
    public boolean isAccountNonExpired() {
        // 만료되었는지 확인하는 로직
        return true; // true -> 만료되지 않았음
    }

    // 계정 잠금 여부 반환
    @Override
    public boolean isAccountNonLocked() {
        // 계정 잠금되었는지 확인하는 로직
        return true; // true -> 잠금되지 않았음
    }

    // 패스워드의 만료 여부 반환
    @Override
    public boolean isCredentialsNonExpired() {
        // 패스워드가 만료되었는지 확인하는 로직
        return true; // true -> 만료되지 않았음
    }

    // 계정 사용 가능 여부 반환
    @Override
    public boolean isEnabled() {
        // 계정이 사용 가능한지 확인하는 로직
        return true; // true -> 사용 가능
    }
}


//    @Column(length = 100, nullable = false)
//    private String password2;

//    public static MemberEntity toSaveUserEntity(MemberDTO memberDTO){
//        MemberEntity memberEntity = new MemberEntity();
//        memberEntity.setUserEmail(memberDTO.getUserEmail());
//        memberEntity.setUserName(memberDTO.getUserName());
//        memberEntity.setUserPassword(memberDTO.getUserPassword());
//        return memberEntity;
//    }






