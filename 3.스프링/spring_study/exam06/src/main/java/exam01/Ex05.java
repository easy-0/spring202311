package exam01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.Arrays;

public class Ex05 {
    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        String url = "jdbc:oracle:thin:@localhost:1521:orcl";
        String username = "SPRING6";
        String password = "_aA123456";

        String sql = "SELECT * FROM MEMBER";
        try(Connection conn = DriverManager.getConnection(url, username, password);
            PreparedStatement pstmt = conn.prepareStatement(sql)){
            ResultSet rs = pstmt.executeQuery();

            while(rs.next()){
                long userNo = rs.getLong("USER_NO");
                String userId = rs.getString("USER_ID");
                String userNm = rs.getString("USER_NM");
                LocalDateTime regDt = rs.getTimestamp("REG_DT").toLocalDateTime();
                System.out.printf("userNo : %d, userId : %s, userNm : %s, regDt : %s", userNo, userId, userNm, regDt);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
