package com.onboarding.javaonboarding.auth.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class AuthSignupRequest {

    private String username;
    private String password;
    private String nickname;

    public AuthSignupRequest(String username, String password, String nickname) {
        this.username = username;
        this.password = password;
        this.nickname = nickname;
    }

}
