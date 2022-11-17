package com.example.spring01.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class UserDto {
    
    // DTO 클래스에서 필드들을 선언할 때, 필드 이름은 요청 파라미터와 같게 선언
    // 기본 생성자(default constructor)와 setter 메서드들을 선언.
    
    private String username;
    private int age;
    
    
}
