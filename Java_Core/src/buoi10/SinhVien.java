package buoi10;

public class SinhVien {
    public static String schoolName = "Đại học";
    private String name;
    private int age;

    // final: sinh ra để khai báo một hằng số, muốn thay đổi cũng không được
    private static final Double PI = 3.14;

    private static SinhVien sinhvien;

    // Singleton design pattern: trong 1 class chỉ có thể khởi tạo duy nhất 1 đối tượng
    // cho môi trường Single Thread
    public static SinhVien of(String name, int age) {
        // thay đổi PI lỗi
//        PI = 3.15;
        if (sinhvien == null) sinhvien = new SinhVien(name, age);
        return sinhvien;
    }

    // cho môi trường Multi Thread
//    public static SinhVien of(String name, int age) {
//        if (sinhvien == null) {
//            synchronized (SinhVien.class) {
//                if (sinhvien == null) sinhvien = new SinhVien(name, age);
//            }
//        }
//        return sinhvien;
//    }

    public SinhVien() {
    }

    public SinhVien(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // trong các phương thức static không thể sử dụng các biến non static
    // trong các phương thức static không thể dùng từ khóa this
    /*
    Có 2 thời điểm:
    * Qúa trình compile time:
    * => biến và phương thức static được khởi tạo trong quá trình compile time
    * Qúa trình run time:
    * => các thuộc tính và phương thức thì nó sẽ được tạo trong quá trình run time
    *
    * */
    // khi chạy thì mới biết biến this thuộc object nào, và đang trỏ đến vùng nhớ nào
    // => vì khi chạy từ khóa new mới tạo ra 1 vùng nhớ để lưu biến đó trên vùng nhớ heap
    // tại thời điểm compile time thì this chưa được xác định (chưa biết biến gì và chưa biết trỏ đến vùng nhớ nào)
    // => thuộc tính non static cũng vậy, khi có vùng nhớ để lưu trữ nó nó mới có thể mang được giá trị
    // ==> trong quá trình compile time, nó chưa trỏ đến vùng nhớ nào nên chưa có giá trị => static không hiểu được
    public static void cute() {
    }

    public static String getSchoolName() {
        return schoolName;
    }

    public static void setSchoolName(String schoolName) {
        SinhVien.schoolName = schoolName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

//    @Override
//    public String toString() {
//        return "SinhVien{" +
//                "schoolName='" + schoolName + '\'' +
//                "name='" + name + '\'' +
//                ", age=" + age +
//                '}';
//    }
}
