package edu.web.jsp02.dto;

import edu.web.jsp02.domain.Post;
import edu.web.jsp02.domain.Users;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// VO(Value Object): 값(데이터) 저장하는 객체. DB의 테이블과 같은 구조로 설계. (예) Post
// DTO(Data Transfer Object): 계층들 사이에서 값(데이터)를 전달할 때 사용하는 객체.
//   controller(web) 계층과 service 계층 사이에서 
//   메서드를 호출할 때 argument의 타입 또는 메서드의 리턴 타입으로 사용되는 객체. 

@NoArgsConstructor // 기본 생성자를 만듦.
@AllArgsConstructor // 모든 필드들을 argument로 갖는 생성자를 만듦.
@Builder // Builder 패턴에서 필요한 내부 클래스와 메서드들을 만듦.
@Data // @Getter, @Setter, @ToString, @EqualsAndHashCode, @RequiredArgsConstructor
public class UsersCreateDto {
    
    private String userName;
    private String passWord;
    private String email;

    // UsersCreateDto 타입을 Users 타입으로 변환해서 리턴하는 메서드.
    public Users toEntity() {
        return Users.builder()
                .userName(userName).passWord(passWord).email(email)
                .build();
    }
    
}
