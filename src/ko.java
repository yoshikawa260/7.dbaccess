import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ko {
    public static void main(String[] args) {
        String url="jdbc:postgresql://localhost:5432/Ouyou";
        String name="postgres";
        String password="postgres";

        Connection con =null;
        PreparedStatement prst=null;
        ResultSet rs=null;
        String sql=null;

        try{
            con=DriverManager.getConnection(url, name, password);
            sql="""
                select *
                from products;
                    """;
            prst=con.prepareStatement(sql);
            rs=prst.executeQuery();
            while (rs.next()) {
                int productId=rs.getInt("productid");
               
                System.out.print("productid:"+productId);
                System.out.println();
                
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            try{
                if(con!=null){
                    con.close();
                }
                if(prst!=null){
                    prst.close();
                }
                if(rs!=null){
                    rs.close();
                }
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
    }
}
