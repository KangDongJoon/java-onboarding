package com.onboarding.javaonboarding.exception;

public class PasswordIncorrect extends RuntimeException {

    public PasswordIncorrect() {
        super("비밀번호가 일치하지않습니다.");
    }

}

