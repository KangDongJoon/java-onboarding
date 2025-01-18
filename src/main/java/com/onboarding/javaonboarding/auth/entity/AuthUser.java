package com.onboarding.javaonboarding.auth.entity;

import com.onboarding.javaonboarding.user.enums.UserRole;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;
import java.util.List;

@Getter
public class AuthUser {

    private final Long id;
    private final String username;
    private final String nickname;
    private final Collection<? extends GrantedAuthority> authorities;

    public AuthUser(Long id, String username, String nickname, String userRole) {
        this.id = id;
        this.username = username;
        this.nickname = nickname;
        this.authorities = List.of(new SimpleGrantedAuthority(UserRole.of(userRole).name()));
    }
}
