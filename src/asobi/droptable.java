package asobi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class droptable {
    public static void main(String[] args) {
        
        String url = "jdbc:postgresql://localhost:5432/student";
        String name = "postgres";
        String password = "postgres";

        Connection con = null;
        PreparedStatement prst = null;
        String sql = null;

        try{
            con=DriverManager.getConnection(url,name, password);
            sql="""
                drop table tekito;
                    """;
            prst=con.prepareStatement(sql);
            prst.executeUpdate();
            System.out.println("テーブルを削除しました。");

        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            try {
                if(con!=null){
                    con.close();
                }
                if(prst!=null){
                    prst.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
