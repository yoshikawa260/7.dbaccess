package ex_member_management.cyuukyuu;

import java.util.List;

public class intermediate3 {
    public static void main(String[] args) {
        Employeedao dao =new Employeedao();
        List<Employee>employeeList=dao.findByDepartmentId(2);
        for(Employee employee:employeeList){
            System.out.println(employee);
        }
    }
}
