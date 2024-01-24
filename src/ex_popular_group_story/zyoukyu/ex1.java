package ex_popular_group_story.zyoukyu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class ex1 {
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
                    drop table if exists colors;
                    create table colors(id integer primary key,name text);

                    drop table if exists members;
                    create table members(id serial primary key,name text not null,birth_day date,gender varchar(1),color_id integer references colors(id));
                    """;
            pstmt=con.prepareStatement(sql);
            pstmt.executeUpdate();

            System.out.println("テーブルが作成されました");
            
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
