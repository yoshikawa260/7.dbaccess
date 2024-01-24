package asobi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class select {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/student";
        String name = "postgres";
        String password = "postgres";

        Connection con = null;
        PreparedStatement prst = null;
        ResultSet rs = null;
        String sql = null;

        try {
            con = DriverManager.getConnection(url, name, password);
            sql = """
                    select *
                    from tekito
                    order by id;
                    """;
            prst = con.prepareStatement(sql);
            rs = prst.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name2 = rs.getString("name");

                System.out.print("id:" + id);
                System.out.print(" name:" + name2);
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
                if (prst != null) {
                    prst.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
