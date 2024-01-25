package asobi.DB2asobi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class testMemberduo {
    public testMember load(int i){
        Connection con=DBmaneger2.createConection();
        String sql="""
                select *
                from test_members
                where id= ?;
                """;
        try{
            PreparedStatement prst=con.prepareStatement(sql);
            prst.setInt(1, i);
            ResultSet rs=prst.executeQuery();
            if(rs.next()){
                testMember testMember=new testMember();
                testMember.setId(rs.getInt("id")); 
                testMember.setName(rs.getString("name"));
                testMember.setAge(rs.getInt("age"));
                testMember.setDepId(rs.getInt("dep_id"));
                return testMember;
            }
            return null;
        }catch(Exception e){
            e.printStackTrace();
            throw new RuntimeException("loadエラー");
        }finally{
            DBmaneger2.disConect(con);
        }
    }
}
