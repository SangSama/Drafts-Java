package buoi12;

public class Buoi12 {
    /*
    *** Abstract class & Interface ***
    *
    *** Abstract class ***
    * => muốn 1 class chứa được abstract method thì phải là class abstract
    * => tất cả các class kế thừa (extends) abstract class thì đều phải ghi đè (override) lại abstract method trong
    * abstract class hoặc class kế thừa phải là class abstract
    * => class abstract là class trừu tượng nên không thể khởi tạo đối tượng trực tiếp từ class abstract được,
    * vì bản chất class này không hoàn thiện, khuyết thiếu.
    * => Phải khởi tạo thông qua các class cụ thể extends đến class abstract
    * ==> sinh ra class abstract để bổ trợ của tính đa hình
    * ==> class abstract sinh ra để làm cha của những thằng khác
    *
    *** Interface ***
    * - Bản chất: là một bản mô tả chức năng các hàm => những thằng khác sẽ thực thi nó
    *       -> chỉ mô tả về phương thức
    *       -> chỉ chứa, khai báo các ký tự hàm
    *       -> những class implement thì phải implement các phương thức của interface
    * - Các phương thức trong interface mặc định là public abstract
    * - Các biến trong interface mặc định là phublic static final
    *!!!!! Từ java 7 đổ về trước thì Interface không khai báo được thân hàm, mặc định là public abstract,
    *      sang java 8 hỗ trợ thêm Default Method, Static Method
    * - Các class implement được nhiều Interface => đa kế thừa kiểu chức năng
    * - 1 Interface có thể extends được nhiều Interface khác
    *
    *** Học thêm 2 phương thức trong java 8
    * ** default method **
    * => phương thức default trong interface thì các class implement nó được mặc định sử sụng phương thức default
    * mà không cần override lại, trừ khi các class imlement có nhu cầu override lại
    * ** Static Method **
    * => không phải có class implement đến interface này vẫn gọi được phương thức này
    *
    *** design pattern
    *** dependency injection
    *** dependency inversion
    *
    * */

    public static void main(String[] args) {
        Travel bicycle = new Bicycle();
        bicycle.move();
        Travel car = new Car();
        car.move();

        // design pattern => dependency injection
        // open sự mở rộng - close sự thay đổi class
        // => làm cho mối liên hệ giữa HolidayTravel và Travel nỏng nẻo hơn
        HolidayTravel holidayTravel1 = new HolidayTravel(new Car());
        holidayTravel1.travel();
        HolidayTravel holidayTravel2 = new HolidayTravel(new Bicycle());
        holidayTravel2.travel();
        HolidayTravel holidayTravel3 = new HolidayTravel(new Train());
        holidayTravel3.travel();


    }
}
