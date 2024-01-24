package ex_popular_group_story;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class ex06 {
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
                drop table members;
                    """;
            pstmt=con.prepareStatement(sql);

            int Update=pstmt.executeUpdate();
            
            System.out.println(Update+"件テーブルが削除されました");
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

