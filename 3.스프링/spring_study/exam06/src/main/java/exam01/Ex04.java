package exam01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Ex04 {
    public static void main(String[] args) throws ClassNotFoundException{
        Class.forName("oracle.jdbc.driver.OracleDriver");
        String url = "jdbc:oracle:thin:@localhost:1521:orcl";
        String username = "SPRING6";
        String password = "_aA123456";

        String sql = "INSERT INTO MEMBER " +
                "(USER_NO, USER_ID, USER_PW, USER_NM, EMAIL) " +
                "VALUES (SEQ_MEMBER.nextval, ?, ?, ?, ?)";

        try(Connection conn = DriverManager.getConnection(url, username, password);
            PreparedStatement pstmt = conn.prepareStatement(sql,
                    new String[]{"USER_NO"} )) {
            pstmt.setString(1,"user04");
            pstmt.setString(2,"234567");
            pstmt.setString(3,"사용자04");
            pstmt.setString(4,"user04@test.org");

            int result = pstmt.executeUpdate();

            ResultSet rs = pstmt.getGeneratedKeys();
            if(rs.next()){
                long userNo = rs.getLong(1);
                System.out.printf("USER_NO : %d%n", userNo);
            }
            System.out.println("변경된 레코드 : " + result);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
