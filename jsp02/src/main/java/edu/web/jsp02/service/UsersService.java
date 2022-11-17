package edu.web.jsp02.service;

import java.util.List;

import edu.web.jsp02.domain.Post;
import edu.web.jsp02.domain.Users;
import edu.web.jsp02.dto.PostCreateDto;
import edu.web.jsp02.dto.PostUpdateDto;
import edu.web.jsp02.dto.UsersCreateDto;
import edu.web.jsp02.dto.UsersSignUpDto;
import edu.web.jsp02.dto.UsersUpdateDto;

public interface UsersService {
    
    public List<Users> read(); // 유저 전체 목록 읽어오기
    public int create(UsersCreateDto dto); // 회원가입
    public Users read(Integer id); // id(포스트 번호)가 일치하는 유저계정 1개 읽어오기
    public int delete(Integer id); // id(포스트 번호)가 일치하는 유저계정 1개 삭제
    public int update(UsersUpdateDto dto); // id가 일치하는 유저의 아이디,패스워드,이메일 업데이트
    public int signUp(UsersSignUpDto dto);
    public Users signIn(String userName, String passWord);

}
