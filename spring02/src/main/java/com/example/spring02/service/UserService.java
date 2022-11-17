package com.example.spring02.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.spring02.domain.User;
import com.example.spring02.mapper.UserMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor // final 필드를 argument로 갖는 생성자를 만듦. 
@Service


public class UserService {
    
    private final UserMapper userMapper; 
    
    public List<User> select() {
        log.info("select()");
        
        return userMapper.select();
    }
    
    public int insert(User entity) {
        log.info("insert");
        
        return userMapper.insert(entity);
    };
    
    public User selectById(Integer id) {
        log.info("selectById");
        
        return userMapper.selectById(id);
    }
    
    public int delete(Integer id) {
        log.info("delete");
        
        return userMapper.delete(id);
    }
    
    public int update(User entity) {
        log.info("update");
        
        return userMapper.update(entity);
    }
    
    public User selectByIdUserNameAndPassWord(User user) {
        log.info("selectByIdUserNameAndPassWord");
        
        return userMapper.selectByIdUsernameAndPassword(user);
    }
    
    
}
