package com.onboarding.javaonboarding.auth.controller;

import com.onboarding.javaonboarding.auth.dto.*;
import com.onboarding.javaonboarding.auth.service.AuthService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/auth/signup")
    @Operation(summary = "회원가입", description = "회원가입 할 때 사용하는 API")
    @Parameters({
            @Parameter(name = "username", description = "이름", example = "JIN HO"),
            @Parameter(name = "password", description = "비밀번호", example = "12341234"),
            @Parameter(name = "nickname", description = "닉네임", example = "Mentos"),
    })
    public ResponseEntity<AuthSignupResponse> signup(@RequestBody AuthSignupRequest request) {
        return ResponseEntity.ok(authService.signup(request));
    }

    @PostMapping("/auth/sign")
    @Operation(summary = "로그인", description = "로그인 할 때 사용하는 API")
    @Parameters({
            @Parameter(name = "username", description = "이름", example = "JIN HO"),
            @Parameter(name = "password", description = "비밀번호", example = "12341234"),
    })
    public ResponseEntity<AuthSignResponse> sign(@RequestBody AuthSignRequest request) {
        return ResponseEntity.ok(authService.sign(request));
    }

    @PostMapping("/auth/refresh-token")
    @Operation(summary = "AccessToken 재발행", description = "RefreshToken이 만료 전이라면 AccessToken 재발행")
    public ResponseEntity<AuthRefreshAccessResponse> refreshAccessToken(@RequestHeader("Authorization") String refreshToken) {
        return ResponseEntity.ok(authService.refreshAccessToken(refreshToken));
    }

}
