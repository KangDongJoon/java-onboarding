package com.onboarding.javaonboarding.auth.service;

import com.onboarding.javaonboarding.jwt.JwtUtil;
import com.onboarding.javaonboarding.user.entity.User;
import com.onboarding.javaonboarding.user.enums.UserRole;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.security.Keys;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.util.ReflectionTestUtils;

import java.security.Key;
import java.util.Base64;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
class AuthServiceTest {

    @InjectMocks
    private JwtUtil jwtUtil;

    private String secretKey;
    private Key encodeSecretKey;
    private User user;

    @BeforeEach
    public void setUp() {
        jwtUtil = new JwtUtil();
        secretKey = "joon1231234123121212512325123121awdd2afawfasfwa";
        encodeSecretKey = Keys.hmacShaKeyFor(Base64.getDecoder().decode(secretKey));
        ReflectionTestUtils.setField(jwtUtil, "key", encodeSecretKey);
        user = new User("username", "password", "nickname", UserRole.USER);
        ReflectionTestUtils.setField(user, "id", 1L);
    }

    @Test
    public void encodeSecretKeyTest() {
        byte[] decodedSecretKey = Base64.getDecoder().decode(secretKey);
        assertArrayEquals(decodedSecretKey, encodeSecretKey.getEncoded());
    }

    @Test
    public void createAccessTokenTest() {
        String accessToken = jwtUtil.accessToken(user.getId(), user.getUsername(), user.getUserRole());

        assertNotNull(accessToken);
    }

    @Test
    public void createRefreshTokenTest() {
        String refreshToken = jwtUtil.refreshToken(user.getId(), user.getUsername(), user.getUserRole());

        assertNotNull(refreshToken);
    }

    @Test
    public void verifyExpiredTokenTest() throws InterruptedException {
        String accessToken = jwtUtil.accessToken(user.getId(), user.getUsername(), user.getUserRole());
        TimeUnit.SECONDS.sleep(31);

        assertThrows(ExpiredJwtException.class, () -> jwtUtil.extractClaims(jwtUtil.substringToken(accessToken)));
    }

}
