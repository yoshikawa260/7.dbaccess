package ex_member_management.jyoukyu;

public class Advanced2 {
    public static void main(String[] args) {
        StudentDao studentDao = new StudentDao();
        Student student = studentDao.load(2);
        System.out.println(student);
    }

}
