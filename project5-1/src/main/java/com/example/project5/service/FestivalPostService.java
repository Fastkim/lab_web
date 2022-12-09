package com.example.project5.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.project5.domain.FestivalPost;
import com.example.project5.dto.FestivalPostCreateDto;
import com.example.project5.dto.FestivalPostUpdateDto;
import com.example.project5.repository.FestivalPostRepository;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor // final 필드를 초기화하는 생성자.
@Service // 스프링 컨텍스트에 Service 컴포넌트로 등록.

public class FestivalPostService {
    
    private final FestivalPostRepository festivalPostRepository;
    
    @Transactional(readOnly = true) // 검색 속도가 빨라짐.
    public List<FestivalPost> read() {
        log.info("read()");
        
        return festivalPostRepository.findByOrderByIdDesc();
    }
    
    public FestivalPost create(FestivalPostCreateDto dto) {
        log.info("create(dto={})", dto);
        
        FestivalPost entity = festivalPostRepository.save(dto.toEntity()); 
        
        return entity;
        
    }
    
    @Transactional(readOnly = true)
    public FestivalPost read(Integer id) {
        log.info("read(id={})", id);
        
        return festivalPostRepository.findById(id).get();
    }
    
    public Integer delete(Integer id) {
        log.info("delete(id={})", id);
        
        festivalPostRepository.deleteById(id);
        
        return id; // 삭제한 포스트 아이디(번호)를 리턴.
    }

    @Transactional // readOnly = false(기본값)
    public Integer update(FestivalPostUpdateDto dto) {
        log.info("update(dto={})", dto);
        
        // 메서드에 @Transactional 애너테이션을 사용하고,
        // (1) 수정하기 전의 엔터티 객체를 검색한 후에
        // (2) 검색된 엔터티 객체를 수정하면
        // 메서드가 종료될 때 데이터베이스 테이블에 자동으로 update SQL이 실행됨.
        // PostRepository의 save() 메서드를 명시적으로 호출하지 않아도 됨.
        FestivalPost entity = festivalPostRepository.findById(dto.getId()).get(); // (1)
        entity.updateFestivalPost(dto.getTitle(), dto.getContent(), dto.getImgFilePath()); // (2)
        
        return entity.getId();
    }

    public List<FestivalPost> search(String type, String keyword) {
        log.info("search(type={}, keyword={})", type, keyword);
        
        List<FestivalPost> list = new ArrayList<>();
        switch (type) {
        case "t": // 제목만 검색
            list = festivalPostRepository.findByTitleIgnoreCaseContainingOrderByIdDesc(keyword);
            break;
        case "c": // 내용만 검색
            list = festivalPostRepository.findByContentIgnoreCaseContainingOrderByIdDesc(keyword);
            break;
        }
        
        return list;
    }
    
    
    
    
    
    
}
