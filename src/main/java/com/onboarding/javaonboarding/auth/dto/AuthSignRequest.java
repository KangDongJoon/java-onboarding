package com.onboarding.javaonboarding.auth.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

@Getter
public class AuthSignRequest {

    @Schema(description = "사용자의 이름", example = "JIN HO")
    private String username;
    @Schema(description = "비밀번호", example = "12341234")
    private String password;


    public AuthSignRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

}
