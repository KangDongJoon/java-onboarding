package com.onboarding.javaonboarding.auth.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AuthSignResponse {
    private final String token;
}
