package ex_member_management.jyoukyu;

import java.util.ArrayList;
import java.util.List;

public class Advanced3 {
    public static void main(String[] args) {
        StudentDao dao=new StudentDao();
        List<Student>lists=new ArrayList<>();
        lists=dao.findAll();
        System.out.println(lists);
    }
}
