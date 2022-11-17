package com.example.spring02.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.spring02.domain.Post;
import com.example.spring02.dto.PostCreateDto;
import com.example.spring02.dto.PostSearchDto;
import com.example.spring02.dto.PostUpdateDto;
import com.example.spring02.service.PostService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/post")
//-> 클래스에 @RequestMapping 애너테이션을 사용하면, 
// 그 클래스의 모든 메서드들의 매핑 주소는 @RequestMapping에서 설정된 URL로 시작함.
@Controller // 스프링 컨테이너가 Bean으로 생성, 관리
public class PostController {

    private final PostService postService; // 생성자에 의한 의존성 주입
    
    @GetMapping("/list")
    public String list(Model model) {
        log.info("list()");
        
        // Service 계층의 메서드를 사용해서 포스트 전체 목록을 검색함.
        List<Post> list = postService.read();
        
        // 포스트 목록을 뷰에 전달하기 위해서 model을 이용.
        model.addAttribute("list", list);
        
        return "/post/list"; // 뷰 이름 - /WEB-INF/views/post/list.jsp
    }
    
    // 새 글 작성
    @GetMapping("/create")
    public String create() {
        log.info("create()");
        
        return "/post/create";
    }
    
    @PostMapping("/create")
    public String create(PostCreateDto dto) {
        log.info("create(dto={})", dto);

        // 서비스 계층이 메서드를 호출해서 포스트 작성 내용을 DB에 저장.
        postService.create(dto);
        
        // 포스트 목록 페이지로 이동(redirect): PRG(Post - Redirect - Get)
        return "redirect:/post/list";
    }
    
    // 상세보기
    @GetMapping("/detail")
    public String detail(Integer id, Model model) {
        log.info("detail(id={})", id);
        
        Post post = postService.read(id);
        model.addAttribute("post", post);
        
        return "/post/detail";
    }
    
    // 수정페이지
    @GetMapping("/modify")
    public String modify(Integer id, Model model) {
        log.info("modify(id={})", id);
        
        Post post = postService.read(id);
        model.addAttribute("post", post);
        
        return "/post/modify";
    }
    
    // 삭제 컨트롤러 메서드
    @PostMapping("/delete")
    public String delete(Integer id) {
        log.info("delete(id={})", id);
        
        postService.delete(id);
        
        return "redirect:/post/list";
    }
    
    @PostMapping("/update")
    public String update(PostUpdateDto dto) {
        log.info("update(dto={})", dto);
        
        postService.update(dto);
        
        return "redirect:/post/detail?id=" + dto.getId(); // 상세보기 페이지로 redirect
        // "redirect:/post/list" // 목록 페이지로 redirect
    }
    
    @GetMapping("/search")
    public String search(PostSearchDto dto, Model model) {
        log.info("search(dto={})", dto);
        
        // 검색 서비스 수행
        List<Post> result = postService.searchByKeyword(dto);
        model.addAttribute("list", result);
        
        return "/post/list";
    }
    
}
