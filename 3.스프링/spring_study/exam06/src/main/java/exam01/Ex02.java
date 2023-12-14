package exam01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Ex02 {
    public static void main(String[] args) throws ClassNotFoundException{
        Class.forName("oracle.jdbc.driver.OracleDriver");
        String url = "jdbc:oracle:thin:@localhost:1521:orcl";
        String username = "SPRING6";
        String password = "_aA123456";

        try(Connection conn = DriverManager.getConnection(url,username,password);
        Statement stmt = conn.createStatement()){
            String sql = "insert into member ( " +
                    "user_no, user_id, user_pw, user_nm, email) " +
                    "values (seq_member.nextval, 'user01', '123456', '사용자01', 'user01@test.org')";
            int result = stmt.executeUpdate(sql);
            System.out.println("변경된 레코드 : " + result);
        } catch (SQLException e){
            e.printStackTrace();
        }

    }
}
