package ex_member_management.cyuukyuu;

public class Intermediate1 {
    public static void main(String[] args) {
        Employeedao dao=new Employeedao();
        Employee employee=dao.load(1);
        System.out.println(employee);
        }
}
