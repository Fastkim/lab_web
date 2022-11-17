package edu.web.jsp02.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zaxxer.hikari.HikariDataSource;

import edu.web.jsp02.datasource.HikariDataSourceUtil;
import edu.web.jsp02.domain.Post;
import edu.web.jsp02.domain.Users;
import lombok.Cleanup;
import lombok.extern.slf4j.Slf4j;

// MVC 아키텍쳐에서 Controller의 계층들 중에서 DB 관련 작업을 수행하는 계층.
// Controller 계층: Web layer(Servlet) - Service layer - Repository layer(DAO)

@Slf4j
public class UsersDaoImpl implements UsersDao {
    // Slf4j 로그를 사용하기 위해서
    // private static final Logger log = LoggerFactory.getLogger(PostDaoImpl.class);
    
    // Singleton
    private static UsersDaoImpl instance = null;
    
    private HikariDataSource ds;
    
    private UsersDaoImpl() {
        ds = HikariDataSourceUtil.getInstance().getDataSource();
    }
    
    public static UsersDaoImpl getInstance() {
        if (instance == null) {
            instance = new UsersDaoImpl();
        }
        
        return instance;
    }

    private Users recordToEntity(ResultSet rs) throws SQLException {
        Integer id = rs.getInt("ID");
        String userName = rs.getString("USERNAME");
        String passWord = rs.getString("PASSWORD");
        String email = rs.getString("EMAIL");
        
        Users entity = Users.builder()
                .id(id).userName(userName).passWord(passWord).email(email)
                .build();
        
        return entity;
    }
    
    public static final String SQL_SELECT = "select * from USERS order by ID";
    
    @Override
    public List<Users> select() {
        log.info("select()");
        log.info("SQL: {}", SQL_SELECT);
        
        List<Users> list = new ArrayList<>();
        
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = ds.getConnection(); // Connection Pool(Data Source)에서 Connection을 빌려옴.
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            
            while (rs.next()) { // select 결과에서 row 데이터가 있으면
                Users users = recordToEntity(rs);
                list.add(users);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                stmt.close();
                conn.close(); // Data Source에서 빌려온 Connection을 반환.
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        return list;
    }
    
    public static final String SQL_INSERT = 
            "insert into USERS (USERNAME, PASSWORD, EMAIL,POINTS) "
            + "values (?, ?, ?, ?)";
    
    @Override
    public int insert(Users entity) {
        log.info("insert(entity={})", entity);
        log.info(SQL_INSERT);
        
        int result = 0; // DB에 insert 성공하면 1, 실패하면 0
        
        try {
            @Cleanup
            Connection conn = ds.getConnection();
            
            @Cleanup
            PreparedStatement stmt = conn.prepareStatement(SQL_INSERT);
            // prepared statement의 바인딩 파라미터(binging parameter) 값들을 세팅.
            stmt.setString(1, entity.getUserName());
            stmt.setString(2, entity.getPassWord());
            stmt.setString(3, entity.getEmail());
            stmt.setInt(4, 0);
            
            result = stmt.executeUpdate(); // insert된 행의 개수를 리턴.
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return result;
    }

    public static final String SQL_SELECT_BY_ID = 
            "select * from USERS where ID = ?";
    
    @Override
    public Users selectById(Integer id) {
        log.info("selectById(id = {})", id);
        
        // 엔터티: DB 테이블의 행에 저장된 데이터. 레코드.
        Users entity = null;
        
        try {
            @Cleanup // 리소스 사용이 끝난 후에 close() 메서드를 자동으로 호출.
            Connection conn = ds.getConnection();
            
            @Cleanup
            PreparedStatement stmt = conn.prepareStatement(SQL_SELECT_BY_ID);
            log.info(SQL_SELECT_BY_ID);
            
            stmt.setInt(1, id);
            
            @Cleanup
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) { // 검색된 행(row, 레코드)가 있으면
                entity = recordToEntity(rs);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // Connection, PreparedStatement, ResultSet을 선언할 때 @Cleanup을 사용했기 때문에,
        // finally에서 close 메서드를 호출할 필요 없이, 모든 리소스는 자동으로 해제됨.
        
        return entity;
    }

    public static final String SQL_DELETE = "delete from USERS where ID = ?";
    
    @Override
    public int delete(Integer id) {
        log.info("delete(id = {})", id);
        
        int result = 0; // DB에서 delete SQL 실행 결과값을 저장하기 위한 변수
        
        try {
            @Cleanup
            Connection conn = ds.getConnection();
            
            @Cleanup
            PreparedStatement stmt = conn.prepareStatement(SQL_DELETE);
            log.info(SQL_DELETE);
            
            stmt.setInt(1, id);
            
            result = stmt.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return result;
    }
    
    public static final String SQL_UPDATE = 
            "update USERS set USERNAME = ?, PASSWORD = ?, EMAIL = ? where ID = ?";

    @Override
    public int update(Users entity) {
        log.info("update(entity = {})", entity);
        
        
        int result = 0; // DB에서 update SQL 실행 결과값을 저장하기 위한 변수
        
        try {
            @Cleanup
            Connection conn = ds.getConnection();
            
            @Cleanup
            PreparedStatement stmt = conn.prepareStatement(SQL_UPDATE);
            log.info(SQL_UPDATE);
            
            stmt.setString(1, entity.getUserName());
            stmt.setString(2, entity.getPassWord());
            stmt.setString(3, entity.getEmail());
            stmt.setInt(4, entity.getId());
            
            result = stmt.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return result;
    }

    private static final String SQL_SELECT_BY_USERNAME_AND_PASSWORD =
            "select * from USERS where USERNAME = ? and PASSWORD = ?";
    
    @Override
    public Users selectByIdUsernameAndPassword(Users users) {
        log.info("selectByUsernameAndPassword({})",users);
        
        Users entity = null; // DB에서 select한 결과를 저장할 객체
        try {
            @Cleanup
            Connection conn = ds.getConnection();
            
            @Cleanup
            PreparedStatement stmt = conn.prepareStatement(SQL_SELECT_BY_USERNAME_AND_PASSWORD);
            log.info(SQL_SELECT_BY_USERNAME_AND_PASSWORD);
            
            stmt.setString(1, users.getUserName());
            stmt.setString(2, users.getPassWord());
            
            @Cleanup
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) { // select 
                Integer id = rs.getInt("ID");
                String userName = rs.getString("USERNAME");
                String passWord = rs.getString("PASSWORD");
                String email = rs.getString("EMAIL");
                int points = rs.getInt("POINTS");
            
            
            entity = Users.builder()
                    .id(id).userName(userName).passWord(passWord)
                    .email(email).points(points)
                    .build();
            }
           
            
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        return entity;
    }
    
}
