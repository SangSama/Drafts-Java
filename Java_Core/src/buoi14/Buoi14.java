package buoi14;

public class Buoi14 {

    /*
    * => Lập trình OOP là trừu tượng hóa các vấn đề
    *
    *** Centent ***
    * Nested Class
    * Inner Class
    * Static Class - Non Static Class
    * Anonymous Object
    * Anonymous Class
    * Builder Pattern
    * Adapter Pattern
    * Command Pattern
    * Factory Pattern
    * Dependence Injection
    * Dependence Inversion
    *
    * => Nested Class : trong class chứa class
    * => Inner Class : class bên trong class
    *
    * */

    // non static class - inner class
    public class Nested {}

    // static class
    public static class StaticNested {}

    public interface Interface{}

    public static void main(String[] args) {
        // non-static - class của object
        Buoi14 test = new Buoi14();
        Nested nested = test.new Nested();
        System.out.println(nested);         //oop.Buoi14$Nested... => đối tượng Nested thuộc class Buoi14

        // static
        StaticNested staticNested = new  Buoi14.StaticNested();
        System.out.println(staticNested);

        // Anonymous Object - Anonymous Class
        // không biết class nào implement interface Demo
        // => Anonymous Class = class ẩn danh (java tự có 1 class nào đó implement interface mà ta không nhìn thấy)
        // không biết object này được tạo ra bởi class nào
        // => Anonymous Object
        // phương thức Demo không biết class nào override nên override tại đây
        Demo demo = new Demo() {
            @Override
            public void demo() {

            }
        };

        // Builder Pattern
        // => tạo thành 1 dòng chảy
        Student student = new Student.StudentBuilder()
                .className("ĐTVT.11-K62")
                .age(22)
                .dob("04-04-1999")
                .name("sáng xinh xắn")
                .build();
        System.out.println(student);

        // Adapter Pattern
        // dùng method nào override lại method ý thôi
        // tránh phải override lại những method không dùng đến
        // thêm, bớt method ở Travel thì chỉ có AdapterTravel cần thay đổi

    }

}