package buoi12;

public interface Travel {

    /*
    * interface => chỉ định nghĩa hàm
    *           => những hàm implement Travel phải định nghĩa lại xem hàm này làm gì bằng cách override lại
    * - Các phương thức trong interface mặc định là public abstract
    * => void move() <=> public abstract void move()
    * - Các biến trong interface mặc định là public static final
    * => String name = "abc" <=> public static final String name = "abc"
    *
    * */

    String name = "abc";

    void move();

    // Default Method in JAVA 8
    // => phương thức default trong interface thì các class implement nó được mặc định sử sụng phương thức default
    // mà không cần override lại, trừ khi các class imlement có nhu cầu override lại
    default void print() {
        System.out.println("Default Method in JAVA 8");
    }

    // Static Method in JAVA 8
    // => không phải có class implement đến interface này vẫn gọi được phương thức này
    static Travel getInstance() {
        return new Car();

    }
}
