package com.example.project5.domain;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.Formula;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString
@Entity(name = "RECRUITPOSTS")
@SequenceGenerator(name="RECRUITPOSTS_SEQ_GEN", sequenceName = "RECRUITPOSTS_SEQ" ,allocationSize = 1)
public class RecruitPost extends BaseTimeEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RECRUITPOSTS_SEQ_GEN")
    private Integer id;
    
    @Column(nullable = false)
    private String title;
    
    @Column(nullable = false)
    private String content;
    
    @Column(nullable = false)
    private String author;
    
    @Column(nullable = false)
    private String place;
    
    @Column(nullable = false)
    private LocalDateTime meetingDate;
    
    @Column(nullable = false)
    private Integer totalMember; // 총 인원 수
    
//    @Column(columnDefinition = "number(20) default '0'", nullable = false)
    private Integer joinMember; // 현재 인원 수
    
    private String filePath; // 업로드한 이미지 파일의 경로
    
    private String fileName; // 파일 이름
    
    @Column(nullable = true) // 위도 정보
    private double lat;
    
    @Column(nullable = true) // 경도 정보
	private double lng;
    
    @Column(nullable = false)
    private LocalDateTime closeDate; // 마감 날짜
    
    private final String postGroup="recruitPost";
    
    public RecruitPost updateRecruitPost(String title, String content, String place, 
            Integer totalMember, String filePath, String fileName,LocalDateTime closeDate) {
        this.title=title;
        this.content=content;
        this.place=place;
        this.totalMember=totalMember;
        this.filePath=filePath;
        this.fileName = fileName;
        this.closeDate=closeDate;
         
        return this;
    }
    
    public RecruitPost updateCount(Integer joinMember) {
        this.joinMember = joinMember;
        return this;
    }
    
    // joinMember이 null 일때 기본값을 0으로 설정
    @PrePersist
    public void prePersist() {
        this.joinMember = this.joinMember == null ? 0 : this.joinMember;
    }


}
