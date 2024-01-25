package asobi.DB2asobi;

public class testMember {
    private Integer id;
    private String name;
    private Integer age;
    private Integer depId;
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
    public Integer getDepId() {
        return depId;
    }
    public void setDepId(Integer depId) {
        this.depId = depId;
    }
    @Override
    public String toString() {
        return "testMember [id=" + id + ", name=" + name + ", age=" + age + ", depId=" + depId + "]";
    }

    
}
