package edu.web.jsp02.domain;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

// MVC 아키텍쳐에서 Model에 해당하는 클래스. DB의 USERS 테이블의 내용.
// Model 클래스: (1) 필드, (2) 생성자, (3) getters, (4) toString

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@ToString
public class Users {
    private Integer id; // 유저 고유 번호(Primary Key)
    private String userName; // 유저 아이디
    private String passWord; // 유저 패스워드
    private String email; // 유저 이메일
    private Integer points;
    
}
    
    
