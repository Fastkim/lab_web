package com.example.spring02.mapper;

import java.util.List;

import com.example.spring02.domain.User;

public interface UserMapper {
    public List<User> select();
    public int insert(User entity);
    public User selectById(Integer id);
    public int delete(Integer id);
    public int update(User entity);
    public User selectByIdUsernameAndPassword(User user);
}
