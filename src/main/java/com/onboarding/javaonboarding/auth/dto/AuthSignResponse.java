package com.onboarding.javaonboarding.auth.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AuthSignResponse {
    @Schema(description = "AccessToken", example = "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiIxIiwidXNlcm5hbWUiOiJKSU4gSE8iLCJ1c2VyUm9sZSI6IlVTRVIiLCJleHAiOjE3MzcyNzg0MTEsImlhdCI6MTczNzI3ODM4MX0.h8EnMz1amiKd6kKOoA2rj7MDBFquphpgEt2WeEbEybE")
    private final String accessToken;
    @Schema(description = "RefreshToken", example = "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiIxIiwidXNlcm5hbWUiOiJKSU4gSE8iLCJ1c2VyUm9sZSI6IlVTRVIiLCJleHAiOjE3MzczNjQ3ODEsImlhdCI6MTczNzI3ODM4MX0.wgLrEU_mDjSfFmLheX8kwKjExaoPZ0REP8Axq0pBbtw")
    private final String refreshToken;
}
