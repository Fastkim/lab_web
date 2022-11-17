package com.example.spring02.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@ToString

public class User {
    private Integer id; // 유저 고유번호(primary key)
    private String userName;  //유저 아이디
    private String passWord; //유저 패스워드
    private String email; // 유저 이메일
}
