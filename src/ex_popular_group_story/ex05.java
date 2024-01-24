package ex_popular_group_story;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class ex05 {
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
                delete from members
                where id in(1,2)
                    """;
            pstmt=con.prepareStatement(sql);

            int Update=pstmt.executeUpdate();
            
            System.out.println(Update+"件更新されました");
            
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

