package com.example.spring02.dto;

import com.example.spring02.domain.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data

public class UserSignUpDto {
    
    private String userName;
    private String passWord;
    private String email;
    
    // UserSignUpDto 타입의 객체를 User 타입으로 변환해서 리턴하는 메서드
    public User toEntity() {
        return User.builder()
                .userName(userName).passWord(passWord).email(email)
                .build();
    }
}
