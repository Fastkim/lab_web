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

// 업데이트 하기 위해서 필요한 정보들을 전달할 때 사용하는 객체.
public class UsersUpdateDto {
    private Integer id;
    private String userName;
    private String passWord;
    private String email;
    
    public Users toEntity() {
        return Users.builder()
                .id(id).userName(userName).passWord(passWord).email(email)
                .build();
    }
}
