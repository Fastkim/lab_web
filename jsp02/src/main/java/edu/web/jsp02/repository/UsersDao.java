package edu.web.jsp02.repository;

import java.util.List;

import edu.web.jsp02.domain.Post;
import edu.web.jsp02.domain.Users;

public interface UsersDao {
    
    public List<Users> select();
    public int insert(Users entity);
    public Users selectById(Integer id);
    public int delete(Integer id);
    public int update(Users entity);
    public Users selectByIdUsernameAndPassword(Users users);

}
