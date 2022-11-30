package com.example.project5.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.project5.domain.Community;
import com.example.project5.repository.CommunityRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor // final 필드를 초기화하는 생성자.
@Service // 스프링 컨텍스트에 Service 컴포넌트로 등록.

public class CommunityService {
    
    private final CommunityRepository communityRepository;
    
    @Transactional(readOnly = true) // 검색 속도가 빨라짐.
    public List<Community> read() {
        log.info("read()");
        
        return communityRepository.findByOrderByIdDesc();
    }
    
    
    
    
    
    
    
    
}
