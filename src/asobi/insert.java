package asobi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class insert {
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
                    insert into tekito(name)
                    values('tanaka'),('sakai'),('kobayasi');
                    """;
            prst=con.prepareStatement(sql);
            int update=prst.executeUpdate();
            System.out.println(update+"件追加しました");

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
