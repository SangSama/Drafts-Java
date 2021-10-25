package buoi14;

public class Student {
    private String name;
    private String address;
    private String phone;
    private String email;
    private String sex;
    private String dob;
    private String fullName;
    private String passWord;
    private int age;
    private String schoolName;
    private String className;

    // Builder Pattern => sinh ra để giảm thiểu constructor

    public Student(StudentBuilder builder) {
        this.name = builder.name;
        this.address = builder.address;
        this.phone = builder.phone;
        this.email = builder.email;
        this.sex = builder.sex;
        this.dob = builder.dob;
        this.fullName = builder.fullName;
        this.passWord = builder.passWord;
        this.age = builder.age;
        this.schoolName = builder.schoolName;
        this.className = builder.className;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", sex='" + sex + '\'' +
                ", dob='" + dob + '\'' +
                ", fullName='" + fullName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", age=" + age +
                ", schoolName='" + schoolName + '\'' +
                ", className='" + className + '\'' +
                '}';
    }

    // Builder Pattern
    // chứa tất cả các thuộc tính của class Student (Outter class) nhưng chỉ có hàm set, và trả về kiểu StudentBuilder
    // => tạo thành 1 dòng chảy
    public static class StudentBuilder implements Builder<Student> {
        private String name;
        private String address;
        private String phone;
        private String email;
        private String sex;
        private String dob;
        private String fullName;
        private String passWord;
        private int age;
        private String schoolName;
        private String className;

        public StudentBuilder name(String name) {
            this.name = name;
            return this;
        }

        public StudentBuilder address(String address) {
            this.address = address;
            return this;
        }

        public StudentBuilder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public StudentBuilder email(String email) {
            this.email = email;
            return this;
        }

        public StudentBuilder sex(String sex) {
            this.sex = sex;
            return this;
        }

        public StudentBuilder dob(String dob) {
            this.dob = dob;
            return this;
        }

        public StudentBuilder fullName(String fullName) {
            this.fullName = fullName;
            return this;
        }

        public StudentBuilder passWord(String passWord) {
            this.passWord = passWord;
            return this;
        }

        public StudentBuilder age(int age) {
            this.age = age;
            return this;
        }

        public StudentBuilder schoolName(String schoolName) {
            this.schoolName = schoolName;
            return this;
        }

        public StudentBuilder className(String className) {
            this.className = className;
            return this;
        }

        // trả về outter class
        public Student build() {
            return new Student(this);
        }
    }
}
