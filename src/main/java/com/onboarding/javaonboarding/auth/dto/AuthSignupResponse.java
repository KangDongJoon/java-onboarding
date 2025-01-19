package com.onboarding.javaonboarding.auth.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.util.Collections;
import java.util.List;

@Getter
@NoArgsConstructor
public class AuthSignupResponse {

    @Schema(description = "사용자의 이름", example = "JIN HO")
    private String username;
    @Schema(description = "별명", example = "Mentos")
    private String nickname;
    @Schema(description = "사용자의 권한", example = "[{ \"authorityName\": \"ROLE_USER\" }]")
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
