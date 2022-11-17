package edu.web.jsp02.service;

import java.util.List;

import edu.web.jsp02.domain.Post;
import edu.web.jsp02.domain.Users;
import edu.web.jsp02.dto.PostCreateDto;
import edu.web.jsp02.dto.PostUpdateDto;
import edu.web.jsp02.dto.UsersCreateDto;
import edu.web.jsp02.dto.UsersSignUpDto;
import edu.web.jsp02.dto.UsersUpdateDto;
import edu.web.jsp02.repository.PostDao;
import edu.web.jsp02.repository.PostDaoImpl;
import edu.web.jsp02.repository.UsersDao;
import edu.web.jsp02.repository.UsersDaoImpl;
import lombok.extern.slf4j.Slf4j;

// Request --> Controller --> Service --> Repository
// Service(Business) 계층을 담당하는 클래스

@Slf4j // Slf4j의 Logger 객체가 생성됨.
public class UsersServiceImpl implements UsersService {
    
    private UsersDao usersDao; // DB select, insert, update, delete 기능
    
    // Singleton
    private static UsersServiceImpl instance = null;
    
    private UsersServiceImpl() {
        usersDao = UsersDaoImpl.getInstance();
    }
    
    public static UsersServiceImpl getInstance() {
        if (instance == null) {
            instance = new UsersServiceImpl();
        }
        
        return instance;
    }

    @Override
    public List<Users> read() {
        log.info("read()");
        
        return usersDao.select();
    }

    @Override
    public int create(UsersCreateDto dto) {
        log.info("create(dto={})", dto);
        
        return usersDao.insert(dto.toEntity());
    }

    @Override
    public Users read(Integer id) {
        log.info("read(id = {})", id);
        
        // PostDao 객체의 메서드를 호출해서 DB 테이블에서 id로 검색.
        return usersDao.selectById(id);
    }

    @Override
    public int delete(Integer id) {
        log.info("delete(id = {})", id);
        
        // 데이터베이스에서 id로 레코드를 삭제.
        return usersDao.delete(id);
    }

    @Override
    public int update(UsersUpdateDto dto) {
        log.info("update(dto = {})", dto);
        
        // DTO를 Entity로 변환해서 Repository 계층의 메서드를 호출.
        
        // update된 행의 개수를 리턴.
        return usersDao.update(dto.toEntity());
    }
    
    @Override
    public int signUp(UsersSignUpDto dto) {
        log.info("signup(dto = {}", dto);
        return usersDao.insert(dto.toEntity());
    }

    @Override
    public Users signIn(String userName, String passWord) {
        log.info("signIn(username={}, password={}", userName, passWord);
        
        Users users = Users.builder()
                .userName(userName).passWord(passWord)
                .build();
        
        return usersDao.selectByIdUsernameAndPassword(users);
    }

}
