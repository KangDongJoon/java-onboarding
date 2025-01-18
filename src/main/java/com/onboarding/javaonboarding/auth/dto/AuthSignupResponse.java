package com.onboarding.javaonboarding.auth.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.util.Collections;
import java.util.List;

@Getter
@NoArgsConstructor
public class AuthSignupResponse {

    private String username;
    private String nickname;
    private List<Authority> authorities;

    public AuthSignupResponse(String username, String nickname, String userRole) {
        this.username = username;
        this.nickname = nickname;
        this.authorities = Collections.singletonList(new Authority(userRole));
    }

    @AllArgsConstructor
    @Getter
    public static class Authority {
        private String authorityName;
    }
}
