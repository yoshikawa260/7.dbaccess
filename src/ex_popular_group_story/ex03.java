package ex_popular_group_story;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ex03 {
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
            sql="""
                select *
                from members
                    """;
            pstmt=con.prepareStatement(sql);

            rs=pstmt.executeQuery();
            while(rs.next()){
                String memberName=rs.getString("name");
                String birthDay=rs.getString(String.valueOf("birth_day"));
                String gender=rs.getString("gender");
                int colorId=rs.getInt("color_id");

                System.out.print(memberName);
                System.out.print(" "+birthDay);
                System.out.print(" "+gender);
                System.out.print(" "+colorId);
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
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}

