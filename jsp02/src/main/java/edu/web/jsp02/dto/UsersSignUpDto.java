package edu.web.jsp02.dto;


import edu.web.jsp02.domain.Users;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
// 회원 가입에서 사용되는 DTO(Data Transfer Object)
public class UsersSignUpDto {
    private String userName;
    private String passWord;
    private String email;
    
    // DTO를 Entity로 변환하는 메서드
    public Users toEntity() {
        return Users.builder()
                .userName(userName).passWord(passWord).email(email)
                .build();
    }
}
