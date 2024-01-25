package asobi.DB2asobi;

public class testMembermain {
    public static void main(String[] args) {
        testMemberduo testMemberduo=new testMemberduo();
        testMember testMember=testMemberduo.load(2);
        System.out.println("id: "+testMember.getId());
        System.out.println("name: "+testMember.getName());
        System.out.println("age: "+testMember.getAge());
        System.out.println("dep_id: "+testMember.getDepId());
    }
}
