package com.example.project5.dto;

import java.time.LocalDateTime;

import com.example.project5.domain.FestivalPost;
import com.example.project5.domain.RecruitPost;

import lombok.Data;

@Data
public class FestivalPostCreateDto {

    private String title;
    private String content;
    private String author;
    private String imgFilePath;
   

    public FestivalPost toEntity() {
        return FestivalPost.builder()
                .title(title).content(content).author(author).imgFilePath(imgFilePath)
                .build();
    }

}