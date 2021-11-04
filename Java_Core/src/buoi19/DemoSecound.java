package buoi19;

// muốn giữ hàm Demo nên mới tạo hàm này
public class DemoSecound {
    @MyAnnotation(name = "name")
    private String name;
    @MyAnnotation(name = "age")
    private Integer age;
    private String address;
    private Boolean sex;
    private Demo1 demo1;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public Demo1 getDemo1() {
        return demo1;
    }

    public void setDemo1(Demo1 demo1) {
        this.demo1 = demo1;
    }

    @Override
    public String toString() {
        return "DemoSecound{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", sex=" + sex +
                ", demo1=" + demo1 +
                '}';
    }
}
