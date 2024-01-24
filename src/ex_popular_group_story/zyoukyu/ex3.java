package ex_popular_group_story.zyoukyu;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ex3 {
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
                select m.id id,m.name 名前,m.birth_day 誕生日,m.gender 性別,m.color_id 色のID,c.id 色id,c.name 色の名前
                from members m
                join colors c
                on m.color_id=c.id;
                    """;
            pstmt=con.prepareStatement(sql);

            rs=pstmt.executeQuery();
            while(rs.next()){
                String memberName=rs.getString("名前");
                String birthDay=rs.getString(String.valueOf("誕生日"));
                String gender=rs.getString("性別");
                String colorName=rs.getString("色の名前");

                System.out.print(memberName);
                System.out.print(" "+birthDay);
                System.out.print(" "+gender);
                System.out.print(" "+colorName);
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


