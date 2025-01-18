package com.onboarding.javaonboarding.auth.service;

import com.onboarding.javaonboarding.auth.dto.AuthSignRequest;
import com.onboarding.javaonboarding.auth.dto.AuthSignResponse;
import com.onboarding.javaonboarding.auth.dto.AuthSignupRequest;
import com.onboarding.javaonboarding.auth.dto.AuthSignupResponse;
import com.onboarding.javaonboarding.exception.PasswordIncorrect;
import com.onboarding.javaonboarding.exception.UserNotFound;
import com.onboarding.javaonboarding.jwt.JwtUtil;
import com.onboarding.javaonboarding.user.entity.User;
import com.onboarding.javaonboarding.user.enums.UserRole;
import com.onboarding.javaonboarding.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AuthService {

    private final JwtUtil jwtUtil;
    private final BCryptPasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    /**
     * 회원가입
     * @param request(username, password, nickname, userrole)
     * @return response(username, nickname, authorities)
     */
    @Transactional
    public AuthSignupResponse signup(AuthSignupRequest request) {

        // 비밀번호 암호화
        String encodePassword = passwordEncoder.encode(request.getPassword());

        User user = new User(
                request.getUsername(),
                encodePassword,
                request.getNickname(),
                UserRole.USER
        );

        // DB 저장
        userRepository.save(user);

        // DTO반환
        return new AuthSignupResponse(
                user.getUsername(),
                user.getNickname(),
                user.getUserRole().getUserRole()
        );
    }

    /**
     * 로그인
     * @param request(username, passsword)
     * @return token
     */
    @Transactional
    public AuthSignResponse sign(AuthSignRequest request) {

        // 가입여부 확인
        User user = userRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new UserNotFound(request.getUsername()));

        // 비밀번호 확인
        if(!passwordEncoder.matches(request.getPassword(), user.getPassword())){
            throw new PasswordIncorrect();
        }

        // 토큰 생성
        String token = jwtUtil.createToken(
                user.getId(),
                user.getUsername(),
                user.getUserRole()
        );

        // 토근 DTO에 담아 반환
        return new AuthSignResponse(token);
    }
}
