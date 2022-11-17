package com.example.spring02.service;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.spring02.domain.Post;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {
        "file:src/main/webapp/WEB-INF/applicationContext.xml"
})
public class TestPostService {
    
    // 필드에 의한 의존성 주입
    @Autowired private PostService postService;
    
    @Test
    public void testRead() {
        Assertions.assertNotNull(postService);
        log.info(postService.toString());
        
        List<Post> list = postService.read();
    }
    
}
