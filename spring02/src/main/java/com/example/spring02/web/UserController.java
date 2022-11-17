package com.example.spring02.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.spring02.domain.User;
import com.example.spring02.service.UserService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/user")
@Controller
public class UserController {

    private final UserService userService;
    
    @GetMapping("/list")
    public String list(Model model) {
        log.info("list()");
        
        List<User> list = userService.select();
        
        model.addAttribute("list", list);
        
        return "/user/list";
    }
}
