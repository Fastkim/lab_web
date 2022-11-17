package com.example.spring02.ojdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import lombok.extern.slf4j.Slf4j;
import oracle.jdbc.OracleDriver;

@Slf4j // 로그
@ExtendWith(SpringExtension.class) // Spring JUnit 테스트를 실행하는 클래스
@ContextConfiguration(locations = {
        "file:src/main/webapp/WEB-INF/applicationContext.xml"
}) // 스프링 컨텍스트 환경설정 파일의 위치, 이름.
public class TestOjdbc {

    @Test
    public void testOjdbc() throws SQLException {
        // OJDBC: 드라이버 등록, 연결, Prepared Statement, 실행, 결과 처리, 리소스 해제
        DriverManager.registerDriver(new OracleDriver());
        
        Connection conn = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521:xe", 
                "scott", "tiger");
        Assertions.assertNotNull(conn); // conn이 null이 아니면 단위 테스트 성공.
        log.info("conn = {}", conn);
        
        // 오라클에서 현재 시간 정보 출력을 위한 SQL
        PreparedStatement stmt = conn.prepareStatement("select sysdate from dual");
        Assertions.assertNotNull(stmt);
        
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) { // select 검색 결과(행, row, entity)가 있으면
            LocalDateTime time = rs.getTimestamp("sysdate").toLocalDateTime();
            log.info("time = {}", time);
        }
        
        rs.close();
        stmt.close();
        conn.close();
    }
    
}
