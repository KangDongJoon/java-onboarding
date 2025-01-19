package com.onboarding.javaonboarding.auth.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class AuthSignupRequest {

    @Schema(description = "사용자의 이름", example = "JIN HO")
    private String username;
    @Schema(description = "비밀번호", example = "12341234")
    private String password;
    @Schema(description = "별명", example = "Mentos")
    private String nickname;

    public AuthSignupRequest(String username, String password, String nickname) {
        this.username = username;
        this.password = password;
        this.nickname = nickname;
    }

}
