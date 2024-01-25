package ex_member_management.jyoukyu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {
    public Student load(int id) {
        Connection con = DBac.createCon();
        String sql = """
                select h.id hId,h.name hName,h.student_id hStudentId,s.id sId,s.name sName,s.age sAge
                from hobbies h
                join students s
                on h.student_id=s.id
                where s.id=?;
                    """;

        try {
            PreparedStatement prst = con.prepareStatement(sql);
            prst.setInt(1, id);
            ResultSet rs = prst.executeQuery();
            if (rs.next()) {
                Student student = new Student();
                List<Hobby> list = new ArrayList<>();
                Hobby hobby = new Hobby();

                hobby.setId(rs.getInt("hId"));
                hobby.setName(rs.getString("hName"));
                hobby.setStudentId(rs.getInt("hStudentId"));
                student.setId(rs.getInt("sId"));
                student.setName(rs.getString("sName"));
                student.setAge(rs.getInt("sAge"));
                list.add(hobby);
                student.setHobbyList(list);
                return student;

            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("ロードできませんでした");
        } finally {
            DBac.closeCon(con);
        }
    }

    public List<Student> findAll() {
        Connection con = DBac.createCon();
        String sql = """
                select h.id hId,h.name hName,h.student_id hStudentId,s.id sId,s.name sName,s.age sAge
                from hobbies h
                join students s
                on h.student_id=s.id
                order by s.id;
                    """;

        List<Student> students = new ArrayList<>();
        try {
            PreparedStatement prst = con.prepareStatement(sql);
            ResultSet rs = prst.executeQuery();
            while (rs.next()) {
                Student student = new Student();
                Hobby hobby = new Hobby();
                List<Hobby> HobbyLists = new ArrayList<>();
                hobby.setId(rs.getInt("hId"));
                hobby.setName(rs.getString("hName"));
                hobby.setStudentId(rs.getInt("hStudentId"));
                student.setId(rs.getInt("sId"));
                student.setName(rs.getString("sName"));
                student.setAge(rs.getInt("sAge"));
                HobbyLists.add(hobby);
                student.setHobbyList(HobbyLists);
                students.add(student);
            }
            return students;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("検索できませんでした");

        } finally {
            DBac.closeCon(con);
        }
    }
    // public void insert(Student student){
    //     Connection con=DBac.createCon();
    //     String sql="""
    //         insert into students(name,age)
    //         values(?,?);

    //         insert into hobbies(name,student_id)
    //         values(?,?);
    //             """;
    //     try{
    //         PreparedStatement prst=con.prepareStatement(sql);
    //         prst.setString(1, student.getName());
    //         prst.setInt(2, student.getAge());
    //         prst.setString(3, student.getHobbyList().get);

    //     }
    // }
}
