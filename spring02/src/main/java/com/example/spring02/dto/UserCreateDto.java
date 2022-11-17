package com.example.spring02.dto;

import com.example.spring02.domain.User;

public class UserCreateDto {

    private String userName;
    private String passWord;
    private String email;
    
    // UserCreateDto 타입을 User 타입으로 변환해서 리턴하는 메서드
    public User toEntity() {
        return User.builder()
                .userName(userName).passWord(passWord).email(email)
                .build();
    }
}
