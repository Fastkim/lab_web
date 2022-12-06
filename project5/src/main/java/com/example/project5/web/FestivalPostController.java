package com.example.project5.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.project5.domain.FestivalPost;
import com.example.project5.dto.FestivalPostCreateDto;
import com.example.project5.dto.FestivalPostUpdateDto;
import com.example.project5.service.FestivalPostService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Controller
@RequestMapping("/community")
public class FestivalPostController {
    
    private final FestivalPostService festivalPostService;
    
    
    @GetMapping("/festivalPostCreate") // GET 방식의 /post/create 요청을 처리하는 메서드.
    public void create() {
        log.info("create()");
        // 컨트롤러 메서드의 리턴 타입이 void인 경우 뷰의 이름은 요청 주소와 같음.
        // src/main/resources/templates/post/create.html
    }
    
    @PostMapping("/festivalpostcreate")
    public String create(FestivalPostCreateDto dto, RedirectAttributes attrs) {
        log.info("create(dto={})", dto);
        
        // 새 포스트 작성
        FestivalPost entity = festivalPostService.create(dto);
        
        attrs.addFlashAttribute("createdId", entity.getId());
        
        return "redirect:/";
    }
    
    @GetMapping({"/festivalpostdetail", "/festivalpostmodify" })
    // 컨트롤러 메서드가 2개 이상의 요청 주소를 처리할 때는 mapping에서 요청 주소를 배열로 설정.
    public void detail(Integer id, Model model) {
        log.info("detail(id={})", id);  
        
        // 요청 파라미터 id를 번호로 갖는 포스트 내용을 검색 -> 뷰에 전달.
        FestivalPost festivalPost = festivalPostService.read(id);
        model.addAttribute("festivalpost", festivalPost);
    }
    
    @PostMapping("/festivalpostdelete")
    public String delete(Integer id, RedirectAttributes attrs) {
        log.info("delete(id={})", id);
        
        Integer postId = festivalPostService.delete(id);
        attrs.addFlashAttribute("deletedPostId", postId);
        
        // 삭제 완료 후에는 목록 페이지로 이동(redirect) - PRG 패턴
        return "redirect:/";
    }
    
    @PostMapping("/festivalpostupdate")
    public String update(FestivalPostUpdateDto dto) {
        log.info("update(dto={})", dto);
        
        Integer postId = festivalPostService.update(dto);
        
        // 포스트 수정 성공 후에는 상세 페이지로 이동(redirect)
        return "redirect:/community/festivalpostdetail?id=" + dto.getId();
    }
    
    @GetMapping("/festivalpostsearch")
    public String search(String type, String keyword, Model model) {
        log.info("search(type={}, keyword={})", type, keyword);

        List<FestivalPost> list = festivalPostService.search(type, keyword);
        model.addAttribute("list", list);

        return "/community/festivalpostlist"; // list.html 파일

    }
}
