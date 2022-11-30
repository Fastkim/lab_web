package com.example.project5.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.project5.domain.Community;
import com.example.project5.service.CommunityService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Controller // 스프링 컨트롤러 컴포넌트
public class HomeController {
    
    private final CommunityService communityService;
    
    @GetMapping("/") // 요청 URL/방식 매핑.
    public String home(Model model) {
        log.info("home()");
        
        List<Community> list = communityService.read(); // DB에서 포스트 목록 전체 검색.
        model.addAttribute("list", list);
        
        return "/community/festivalList";
    }
    
}
