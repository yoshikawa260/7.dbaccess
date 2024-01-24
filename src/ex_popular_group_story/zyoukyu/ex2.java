package ex_popular_group_story.zyoukyu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class ex2 {
    public static void main(String[] args) {
        String url="jdbc:postgresql://localhost:5432/student";
        String name="postgres";
        String password="postgres";

        Connection con=null;
        PreparedStatement pstmt=null;
        String sql=null;

        try{
            con=DriverManager.getConnection(url, name, password);
            sql="""
                insert into colors(id,name)
                values(1,'blue'),
                (2,'red'),
                (3,'green'),
                (4,'yellow'),
                (5,'purple'),
                (6,'orange');
                    """;
            pstmt=con.prepareStatement(sql);
            int update=pstmt.executeUpdate();
            System.out.println(update+"件追加されました");
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if(con!=null){
                    con.close();
                }
                if(pstmt!=null){
                    pstmt.close();
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}
