import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class asobi {
    public static void main(String[] args) {
        String url="jdbc:postgresql://localhost:5432/student";
        String name="postgres";
        String password="postgres";

        Connection con=null;
        PreparedStatement pstmt=null;
        ResultSet rs=null;

        String sql=null;

        try{
            con=DriverManager.getConnection(url, name, password);
            sql="SELECT * FROM departments ORDER BY id";
            pstmt=con.prepareStatement(sql);
            rs=pstmt.executeQuery();

            while(rs.next()){
                int id=rs.getInt("id");
                String nam=rs.getString("name");
                System.out.print("id="+id);
                System.out.print(" name="+nam);
                System.out.println();
            }
            
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
                    if(rs!=null){
                        rs.close();
                    }
                }
            catch(Exception e){
                    e.printStackTrace();
            }
        }
    }
}
                
