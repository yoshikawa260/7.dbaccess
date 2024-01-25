package DB2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao {
    public Employee load(int id) {
        Connection con = DBmaneger.createConnection();
        String sql = """
                select id,name,age,gender,department_id
                from employees
                where id=?;
                """;

        try {
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                Employee employee = new Employee();
                employee.setId(rs.getInt("id"));
                employee.setName(rs.getString("name"));
                employee.setAge(rs.getInt("age"));
                employee.setGender(rs.getString("gender"));
                employee.setDepartmentId(rs.getInt("department_id"));
                return employee;
            }
            return null;
        } catch (SQLException e) {
            System.err.println("SQL= " + sql);
            throw new RuntimeException("load処理に失敗しました", e);
        } finally {
            DBmaneger.closeConnection(con);
        }
    }

    public List<Employee> findByDepartmentId(int departmentId) {
        Connection con1 = DBmaneger.createConnection();
        String sql2 = """
                select id,name,age,gender,department_id
                from employees
                where department_id=?;
                """;
        try {
            PreparedStatement pstmt2 = con1.prepareStatement(sql2);
            pstmt2.setInt(1, departmentId);
            ResultSet rs2 = pstmt2.executeQuery();
            List<Employee> employeeList = new ArrayList<>();
            while (rs2.next()) {
                Employee employee = new Employee();
                employee.setId(rs2.getInt("id"));
                employee.setName(rs2.getString("name"));
                employee.setAge(rs2.getInt("age"));
                employee.setGender(rs2.getString("gender"));
                employee.setDepartmentId(rs2.getInt("department_id"));
                employeeList.add(employee);
            }
            return employeeList;

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("検索処理に失敗しました");
        } finally {
            DBmaneger.closeConnection(con1);
        }
    }

    public int insert(Employee employee){
        Connection con=DBmaneger.createConnection();
        String sql="""
                insert into employees(id,name,age,gender,department_id)
                values(?,?,?,?,?)
                """;
        try{
        PreparedStatement prst=con.prepareStatement(sql);
        prst.setInt(1, employee.getId());
        prst.setString(2, employee.getName());
        prst.setInt(3, employee.getAge());
        prst.setString(4, employee.getGender());
        prst.setInt(5, employee.getDepartmentId());
        int result=prst.executeUpdate();
        return result;
        
    }catch(SQLException e){
        e.printStackTrace();
        throw new RuntimeException("insert処理に失敗しました");
    }finally{
        DBmaneger.closeConnection(con);
    }

    }
}
