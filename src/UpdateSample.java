import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class UpdateSample {
    public static void main(String[] args) {
        String url="jdbc:postgresql://localhost:5432/student";
        String name="postgres";
        String password="postgres";

        Connection con=null;
        PreparedStatement pstmt=null;
        String sql=null;

        try{
            con=DriverManager.getConnection(url, name, password);
            sql="insert into employees(name,age)values('テスト太郎',19);";
            pstmt=con.prepareStatement(sql);
            
            int numUpdate=pstmt.executeUpdate();
            System.out.println(numUpdate+"件のデータを取得しました");
        }catch(Exception e){
            System.out.println("SQL="+sql);
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
