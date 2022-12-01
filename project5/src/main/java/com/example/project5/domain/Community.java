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
// -> 오라클의 시퀀스 객체를 고유키 생성에 사용하기 위해서.
public class Community extends BaseTimeEntity {
    
    
    @Id // Primary Key(고유키)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "COMMUNITYS_SEQ_GEN")
    private Integer id;
    
    @Column(nullable = false) // Not Null 제약조건
    private String title;
    
    @Column(nullable = false)
    private String content;
    
    @Column(nullable = false)
    private String author;
    
    public Community update(String title, String content) {
        this.title = title;
        this.content = content;
        
        return this;
    }
}
