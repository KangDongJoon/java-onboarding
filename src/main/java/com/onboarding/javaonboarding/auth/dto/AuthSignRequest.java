package com.onboarding.javaonboarding.auth.dto;

import lombok.Getter;

@Getter
public class AuthSignRequest {

    private String username;
    private String password;


    public AuthSignRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

}
