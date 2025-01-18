package com.onboarding.javaonboarding.auth.controller;

import com.onboarding.javaonboarding.auth.dto.*;
import com.onboarding.javaonboarding.auth.service.AuthService;
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
    public ResponseEntity<AuthSignupResponse> signup(@RequestBody AuthSignupRequest request) {
        return ResponseEntity.ok(authService.signup(request));
    }

    @PostMapping("/auth/sign")
    public ResponseEntity<AuthSignResponse> sign(@RequestBody AuthSignRequest request) {
        return ResponseEntity.ok(authService.sign(request));
    }

    @PostMapping("/auth/refresh-token")
    public ResponseEntity<AuthRefreshAccessResponse> refreshAccessToken(@RequestHeader("Authorization") String refreshToken) {
        return ResponseEntity.ok(authService.refreshAccessToken(refreshToken));
    }

}
