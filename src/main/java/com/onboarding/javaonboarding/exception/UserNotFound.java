package com.onboarding.javaonboarding.exception;

public class UserNotFound extends RuntimeException {

    public UserNotFound(String username) {
        super("해당 유저를 찾을 수 없습니다 : " + username);
    }

}

