package com.example.project5.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

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
@Entity(name = "COMMUNITYS")

@SequenceGenerator(name = "COMMUNITYS_SEQ_GEN", sequenceName = "COMMUNITYS_SEQ", initialValue = 1, allocationSize = 1)

public class FestivalPost extends BaseTimeEntity {
    
    @Id // Primary key(고유키)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "COMMUNITYS_SEQ_GEN")
    private Integer id;
    
    @Column(nullable = false) // Not Null 제약조건
    private String title;
    
    @Column(nullable = false)
    private String content;
    
    @Column(nullable = false)
    private String author;
    
    @Column
    private String imgFilePath; // 이미지 경로
    
    private final String postGroup="festivalPost"; // 여러개의 포스트들을 분류하는 제목
    
    public FestivalPost updateFestivalPost(String title, String content, String imgFilePath) {
        this.title=title;
        this.content=content;
        this.imgFilePath=imgFilePath;
        
        return this;
    }
}
