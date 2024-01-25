package ex_member_management.cyuukyuu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Employeedao {
    public Employee load(int id) {
        Connection con = DBaccess.createConnection();
        String sql = """
                select e.id as eId,e.name as eName,e.age as eAge,e.gender as eGender,e.department_id as eDepartmentId,d.id as dId,d.name as dName
                from employees e
                join departments d
                on e.department_id=d.id
                where e.id=?;
                """;

        try {
            PreparedStatement prst = con.prepareStatement(sql);
            prst.setInt(1, id);
            ResultSet rs = prst.executeQuery();
            if (rs.next()) {
                Employee employee = new Employee();
                Department department = new Department();
                employee.setId(rs.getInt("eId"));
                employee.setName(rs.getString("eName"));
                employee.setAge(rs.getInt("eAge"));
                employee.setGender(rs.getString("eGender"));
                employee.setDepartmentId(rs.getInt("eDepartmentId"));
                department.setId(rs.getInt("dId"));
                department.setName(rs.getString("dName"));
                employee.setDepartment(department);
                return employee;
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("loadできませんでした");
        } finally {
            DBaccess.closeConnection(con);
        }
    }

    public List<Employee> findAll() {
        Connection con = DBaccess.createConnection();
        String sql = """
                select e.id as eId,e.name as eName,e.age as eAge,e.gender as eGender,e.department_id as eDepartmentId,d.id as dId,d.name as dName
                from employees e
                join departments d
                on e.department_id=d.id
                order by e.id;
                """;
        List<Employee> list = new ArrayList<>();
        try {
            PreparedStatement prst = con.prepareStatement(sql);
            ResultSet rs = prst.executeQuery();
            while (rs.next()) {
                Employee employee = new Employee();
                Department department = new Department();
                employee.setId(rs.getInt("eId"));
                employee.setName(rs.getString("eName"));
                employee.setAge(rs.getInt("eAge"));
                employee.setGender(rs.getString("eGender"));
                employee.setDepartmentId(rs.getInt("eDepartmentId"));
                department.setId(rs.getInt("dId"));
                department.setName(rs.getString("dName"));
                employee.setDepartment(department);
                list.add(employee);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("検索できませんでした");
        } finally {
            DBaccess.closeConnection(con);
        }

    }

    public List<Employee>findByDepartmentId(int id){
        Connection con=DBaccess.createConnection();
        String sql="""
            select e.id as eId,e.name as eName,e.age as eAge,e.gender as eGender,e.department_id as eDepartmentId,d.id as dId,d.name as dName
            from employees e
            join departments d
            on e.department_id=d.id
            where d.id=?
            order by e.id;
                """;
            List<Employee>lists=new ArrayList<>();
        try{
            PreparedStatement prst=con.prepareStatement(sql);
            prst.setInt(1, id);
            ResultSet rs=prst.executeQuery();
            while (rs.next()) {
                Employee employee = new Employee();
                Department department = new Department();
                employee.setId(rs.getInt("eId"));
                employee.setName(rs.getString("eName"));
                employee.setAge(rs.getInt("eAge"));
                employee.setGender(rs.getString("eGender"));
                employee.setDepartmentId(rs.getInt("eDepartmentId"));
                department.setId(rs.getInt("dId"));
                department.setName(rs.getString("dName"));
                employee.setDepartment(department);
                lists.add(employee);
            }
            return lists;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("検索できませんでした");
        } finally {
            DBaccess.closeConnection(con);
        }

        
    }

}
