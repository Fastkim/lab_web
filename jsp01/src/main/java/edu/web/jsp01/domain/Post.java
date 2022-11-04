package edu.web.jsp01.domain;

import java.time.LocalDateTime;

public class Post {
    private Integer id; // 포스트 글 번호
    private String title; // 포스트 글 제목
    private String content; // 포스트 글 내용(본문)
    private LocalDateTime createTime; // 포스트 글 작성 시간
    
    // 기본 생성자
    public Post() {}
    
    // 모든 필드를 argument로 갖는 생성자
    public Post(Integer id, String title, String content, LocalDateTime createTime) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.createTime = createTime;
    }

    
    // getters & setters
    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
    }


    public String getTitle() {
        return title;
    }


    public void setTitle(String title) {
        this.title = title;
    }


    public String getContent() {
        return content;
    }


    public void setContent(String content) {
        this.content = content;
    }


    public LocalDateTime getCreateTime() {
        return createTime;
    }


    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }
    
    // toString
    
    @Override
    public String toString() {
        return "Post [id=" + id + ", title=" + title + ", content=" + content + ", createTime=" + createTime + "]";
    }

}
