package DB2;

import java.util.List;

public class FindByDepartmentIdExample {
    public static void main(String[] args) {
        EmployeeDao dao=new EmployeeDao();
        List<Employee>lists=dao.findByDepartmentId(2);
        for(Employee list:lists){
            System.out.println("name="+list.getName());
        }
    }
}
