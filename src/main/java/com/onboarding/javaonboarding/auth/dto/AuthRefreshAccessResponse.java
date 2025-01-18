package com.onboarding.javaonboarding.auth.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AuthRefreshAccessResponse {
    private final String refreshAccessToken;
}
