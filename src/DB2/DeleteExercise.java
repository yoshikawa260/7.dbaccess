package DB2;

public class DeleteExercise {
    public static void main(String[] args) {
        DepartmentDao dao =new DepartmentDao();
        dao.deleteByid(1000);

        Department department=dao.load(1000);
        System.out.println(department);
        
    }
}
