package com.example.too_all_recipe.Service;

import com.example.too_all_recipe.DTO.MemberDTO;
import com.example.too_all_recipe.Entity.MemberEntity;
import com.example.too_all_recipe.Repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class MemberService implements UserDetailsService {
    private final MemberRepository memberRepository;

    public Long saveUser(MemberDTO memberDTO) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        memberDTO.setUserPassword(encoder.encode(memberDTO.getUserPassword()));
        return memberRepository.save(MemberEntity.builder()
                .userEmail(memberDTO.getUserEmail())
                .auth(memberDTO.getAuth())
                .userPassword(memberDTO.getUserPassword()).build()).getId();

//        MemberEntity memberEntity = MemberEntity.toSaveUserEntity(memberDTO);
//        memberRepository.save(memberEntity);
    }


    /**
     * Spring Security 필수 메소드 구현
     *
     * @param userEmail 이메일
     * @return UserDetails
     * @throws UsernameNotFoundException 유저가 없을 때 예외 발생
     */
     // 기본적인 반환 타입은 UserDetails, UserDetails를 상속받은 UserInfo로 반환 타입 지정 (자동으로 다운 캐스팅됨)
    @Override
    public MemberEntity loadUserByUsername(String userEmail) throws UsernameNotFoundException { // 시큐리티에서 지정한 서비스이기 때문에 이 메소드를 필수로 구현
        return memberRepository.findByUserEmail(userEmail)
                .orElseThrow(() -> new UsernameNotFoundException((userEmail)));
    }

    /**
     * 회원정보 저장
     *
     * @param infoDto 회원정보가 들어있는 DTO
     * @return 저장되는 회원의 PK
     */
//    public Long save(UserInfoDto infoDto) {
//        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//        infoDto.setPassword(encoder.encode(infoDto.getPassword()));
//
//        return userRepository.save(UserInfo.builder()
//                .email(infoDto.getEmail())
//                .auth(infoDto.getAuth())
//                .password(infoDto.getPassword()).build()).getCode();


}


