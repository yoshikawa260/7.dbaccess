package ex_member_management.jyoukyu;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBac {
    private static final String URL = "jdbc:postgresql://localhost:5432/student";
    private static final String NAME = "postgres";
    private static final String PASSWORD = "postgres";

    public static Connection createCon() {
        try {
            Connection con = DriverManager.getConnection(URL, NAME, PASSWORD);
            return con;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("接続できませんでした");
        }
    }

    public static void closeCon(Connection con) {
        try {
            if (con != null) {
                con.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("切断できませんでした");
        }
    }
}
