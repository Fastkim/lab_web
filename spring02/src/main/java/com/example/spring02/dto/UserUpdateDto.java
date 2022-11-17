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

//업데이트 하기 위해서 필요한 정보들을 전달할 때 사용하는 객체.
public class UserUpdateDto {
    private Integer id;
    private String userName;
    private String passWord;
    private String email;
    
    public User toEntity() {
        return User.builder()
                .id(id).userName(userName).passWord(passWord).email(email)
                .build();
    }
    
    
}
