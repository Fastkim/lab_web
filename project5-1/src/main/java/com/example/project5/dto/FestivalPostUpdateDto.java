package com.example.project5.dto;


import com.example.project5.domain.FestivalPost;

import lombok.Data;

@Data
public class FestivalPostUpdateDto {
    // 필드 이름은 요청 파라미터와 같게.
    private Integer id;
    private String title;
    private String content;
    private String imgFilePath;

    // DTO를 Entity 객체로 변환/리턴 -> PostService에서 PostRepository 메서드를 호출할 때.
    public FestivalPost toEntity() {
        return FestivalPost.builder()
                .id(id).title(title).content(content).imgFilePath(imgFilePath)
                .build();
    }
}
