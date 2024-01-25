package DB2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DepartmentDao {
    public Department load(int id) {
        Connection con = DBmaneger.createConnection();
        String sql = """
                select id,name
                from departments
                where id=?;
                """;
        try {
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                Department department = new Department();
                department.setId(rs.getInt("id"));
                department.setName(rs.getString("name"));
                return department;
            }
            return null;
        } catch (SQLException e) {
            System.err.println("SQL= " + sql);
            throw new RuntimeException("load処理に失敗しました", e);
        } finally {
            DBmaneger.closeConnection(con);
        }
    }

    public int insert(Department department) {
        Connection connection = DBmaneger.createConnection();
        String sql = """
                insert into departments(id,name)
                values(?,?);
                """;
        try {
            PreparedStatement prst = connection.prepareStatement(sql);
            prst.setInt(1, department.getId());
            prst.setString(2, department.getName());
            int result = prst.executeUpdate();
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("insertに失敗しました");
        } finally {
            DBmaneger.closeConnection(connection);
        }
    }

    public int Update(Department department) {
        Connection con = DBmaneger.createConnection();
        String sql = """
                update departments
                set name=?
                where id=?;
                """;
        try {
            PreparedStatement prst = con.prepareStatement(sql);
            prst.setString(1, department.getName());
            prst.setInt(2, department.getId());
            int result = prst.executeUpdate();
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Update失敗です");
        } finally {
            DBmaneger.closeConnection(con);
        }
    }

    public int deleteByid(int id){
        Connection con=DBmaneger.createConnection();
        String sql="""
                delete from departments
                where id=?;
                """;
        try{
            PreparedStatement prst=con.prepareStatement(sql);
            prst.setInt(1, id);
            int result=prst.executeUpdate();
            return result;
        }catch(Exception e){
            e.printStackTrace();
            throw new RuntimeException("deleteに失敗しました");

        }finally{
            DBmaneger.closeConnection(con);
        }
    }
}
