package ex_popular_group_story;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class ex02 {
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
                insert into members(name,birth_day,gender,color_id)
                values('大野智','1980-11-26','男',1),
                ('櫻井翔','1982-1-25','男',2),
                ('相葉雅紀','1982-12-24','男',3),
                ('二宮和也','1983-6-17','男',4),
                ('松本潤','1983-8-30','男',5);
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
