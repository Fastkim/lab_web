package com.example.project5.dto;

import java.time.LocalDateTime;

import com.example.project5.domain.FestivalPost;

import lombok.Data;

@Data
public class FestivalPostCreateDto {

    private String title;
    private String content;
    private String author;
    private String festivalArea;
    private String festivalPeriod;
    private String festivalCharacter;
    private String festivalInfo;
    private String festivaPlace;
    private String festivalPrice;
    private String festivalAgency;
    private String festivalInquiry;
    private String filePath;
    private String fileName;
   

    public FestivalPost toEntity() {
        return FestivalPost.builder()
                .title(title).content(content).author(author)
                .festivalAgency(festivalAgency).festivalArea(festivalArea)
                .festivalCharacter(festivalCharacter).festivalInfo(festivalInfo).festivaPlace(festivaPlace)
                .festivalInquiry(festivalInquiry).festivalPeriod(festivalPeriod).festivalPrice(festivalPrice)
                .build();
    }

}