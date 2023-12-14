package jdbctest;

import config.AppCtx;
import models.member.Member;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = AppCtx.class)
@Transactional
public class JdbcTemplateTest {
    @Autowired
    private DataSource dataSource;
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Test  // 단위 테스트
    @DisplayName("DataSource를 통한 DB 연결 테스트")
    void ConnectionTest() {
        try(Connection conn = dataSource.getConnection()) {
            System.out.println(conn);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName("INSERT TEST")
    void InsertTest() {
        String sql = "INSERT INTO MEMBER (USER_NO, USER_ID, USER_PW, USER_NM, EMAIL) " +
                " VALUES (SEQ_MEMBER.nextval, ?, ?, ?, ?)";
        int affectedRows = jdbcTemplate.update(sql,"user97","123456","사용자97","user97@test.org");
        System.out.printf("변경된 레코드 : %d행%n", affectedRows);

    }
    @Test
    @DisplayName("Insert 후 시퀀스 번호 추출")
    void insertTest2() {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        int affectedRows = jdbcTemplate.update(con -> {
            String sql = "INSERT INTO MEMBER (USER_NO, USER_ID, USER_PW, USER_NM, EMAIL) " +
                    "VALUES (SEQ_MEMBER.nextval, ?, ?, ?, ?)";
            PreparedStatement pstmt = con.prepareStatement(sql, new String[]{"USER_NO"});

            pstmt.setString(1,"user88");
            pstmt.setString(2,"123456");
            pstmt.setString(3,"사용자88");
            pstmt.setString(4,"user88@test.org");

            return pstmt;
        }, keyHolder);
        // 반환 타입이 number이다.
        long userNo = keyHolder.getKey().longValue();
        System.out.println("userNo : " + userNo);
    }
    @Test
    @DisplayName("SELECT TEST")
    void SelectTest() {
        String sql = "SELECT * FROM MEMBER";
        List<Member> members = jdbcTemplate.query(sql, this::mapper);

        for (Member member : members){
            System.out.println(member);
        }
    }

    @Test
    @DisplayName("단일 조회 테스트, queryForObject")
    void SelectTest2() {
        String userId = "user88";
        String sql = "SELECT * FROM MEMBER WHERE USER_ID = ?";

/*        try(
                Member member = jdbcTemplate.queryForObject(sql, this::mapper, userId);
                System.out.println(member)) {
        } catch (DataAccessException e) {
            e.printStackTrace();
        }*/
    }

    @Test
    @DisplayName("통계데이터 조회")
    void SelectTest3() {
        String sql = " SELECT COUNT(*) FROM MEMBER";
        long total = jdbcTemplate.queryForObject(sql, long.class);
        System.out.println(total);
    }

    @Test
    private Member mapper(ResultSet rs, int i) throws SQLException{
        return Member.builder()
                .userNo(rs.getLong("USER_NO"))
                .userId(rs.getString("USER_ID"))
                .userPw(rs.getString("USER_PW"))
                .userNm(rs.getString("USER_NM"))
                .email(rs.getString("EMAIL"))
                .regDt(rs.getTimestamp("REG_DT").toLocalDateTime())
                .build();
    }
}
