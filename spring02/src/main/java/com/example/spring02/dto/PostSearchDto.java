package com.example.spring02.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class PostSearchDto {
    // 요청 파라미터 이름과 동일하게 필드 이름을 선언!
    private String type;
    private String keyword;
}
