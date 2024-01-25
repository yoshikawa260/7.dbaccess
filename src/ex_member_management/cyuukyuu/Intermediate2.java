package ex_member_management.cyuukyuu;

import java.util.List;

public class Intermediate2 {
    public static void main(String[] args) {
        Employeedao dao=new Employeedao();
        List<Employee>lists=dao.findAll();
        for(Employee employee:lists){
            System.out.println(employee);
        }
        
    }
}
