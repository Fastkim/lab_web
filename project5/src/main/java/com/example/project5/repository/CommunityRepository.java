package com.example.project5.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.project5.domain.Community;

// JpaRepository<엔터티 클래스 타입, PK 데이터 타입>을 상속하는 인터페이스를 선언.

public interface CommunityRepository extends JpaRepository<Community, Integer> {

    // select * from COMMUNITYS order by ID desc
    List<Community> findByOrderByIdDesc();
    
}
