package buoi11;

public class Buoi11 {
    /*
    *** Kế thừa ***
    * - Tại sao cần kế thừa?
    * - Nên dùng kế thừa như thế nào? Trong trường hợp nào?
    * => kế thừa khi một thằng con kế thừa cha thì nó sẽ được kế thừa mọi thuộc tính cũng như phương thức của cha
    * - Muốn kế thừa dùng từ khóa "extends"
    * VD: public class Dog extends Animal{} ==> Dog là mở rộng của Animal
    *
    * ===> Mọi class trong java thì mặc định kế thừa từ class Object
    *      VD: public class Animal extends Object{}
    *   => Bản chất mọi class đều extends với Object, trong Oject có 1 số phương thức nên gọi được toString();
    *      VD: dog.toString(); dù Dog, Animal không có phương thức toString()
    *
    *** Đa hình ***
    * => đa hình có nghĩa thằng cha có thể tồn tại dưới hình dạng các class mà extends nó
    *
    *
    * ** Signature Function **
    * => Hai hàm được gọi là chung chữ ký hàm <=> cùng tên hàm, cùng danh sách tham số và cùng kiểu trả về
    *
    * ** Override : class con ghi đè class cha
    * => nghĩa là class con ghi đè lại phương thức class cha
    * => hai class này phải có chung chữ ký hàm
    * => Access Modifier của thằng con phải >= thằng cha
    *   VD: cha : protected => con : protected hoặc public
    * ===> Phương thức của cha không còn phù hợp với con
    *      => thì con sẽ override lại và sửa cho phù hợp với ngữ cảnh của con
    * !!! Override:
    * => check tham số đầu vào
    * => kiểm tra xem danh sách tham số đầu vào của hai hàm override này có giống nhau kiểu dữ liệu không (compiletime)
    *    => Animal và Dog là 2 kiểu dữ liệu khác nhau
    * => khi return => trả về object
    * => chỉ check về mặt kiểu trả về
    *    => Animal, Dog chung kiểu trả về => Vì bản chất Doa vẫn là Animal
    * => Object chấp nhận đa hình nhưng kiểu dữ liệu là khác nhau.
    *
    * ** Overload : các hàm cùng 1 class ghi đè nhau
    * => Trong cùng 1 class có nhiều hàm có cùng tên nhưng khác nhau về danh sách tham số
    *
    * ** static dùng trong override được không?
    * => không, vì override xuất hiện khi chạy trong quá trình runtime do runtime xác định gọi phương thức override nào,
    * của cha hay của con, còn static chạy trong quá trình compiletime thì xác định gọi phương thức nào tronng class nào
    *
    * ** final
    * - final class thì sẽ không có extends vì final là hằng số k cho phép mở rộng.
    * - final phương thức override thì không thể vì final là hằng số thì sẽ k cho phép ghi đè.
    *
    *** is-a & has-a
    * ** is-a : là một
    * => có nghĩa, tôi là một ai đó => nó tương đương khái niệm kế thừa
    * VD: Dog là một Animal
    *
    * ** has-a : có một
    * => có nghĩa, trong tôi có một cái gì đó
    * VD: Trong class House có chứa 1 đối tượng của class điều hòa
    *
    * ==> Trong nguyên lý thiết kế hướng đối tượng, người ta thường sử dụng mối quan hệ has-a hơn is-a
    * ( vì cây kế thừa càng sâu thì độ phức tập truy suất đến con càng lớn )
    *
    *** dependency injection **
    * => phu thuộc vào thằng trừu tượng thay vì phụ thuộc vào 1 thằng cục thể
    *
    * */

    /*
    * HW: T34-T59
    * */

    public static void main(String[] args) {
        // khi kế thừa, con có quyền truy cập vào thuộc tính, phương thức của cha
        // phương thức cha để private thì sẽ không truy cập được
        // thuộc tính cha để private thì con không truy cập trực tiếp tên thuộc tính mà phải thông quá get-set
        // => thuộc tính cha để protected thì con có thể truy cập trực tiếp
        // VD: protected String name;
        //     => dog.name = "dog";
        Dog dog = new Dog();
        dog.setName("dog");
        dog.setColor("black");
        System.out.println(dog.getName()+"--"+dog.getColor());
        // Bản chất mọi class đều extends với Object
        System.out.println(dog.toString());

        // đa hình
        Animal animal = new Dog();
        /* Bản chất:
        - Lưu cha trước: Tạo ra vùng nhớ chứa thằng cha
        - Sau đó tạo vùng nhớ cho thằng con bao lấy thằng cha
        - Khi tham chiếu (reference) thì tham chiếu đến vùng nhớ cha, nhưng vùng nhớ cha nằm trong vùng nhớ con
        - Do tham chiếu đến vùng nhớ cha nên chỉ nhờ thấy phương thức trong vùng nhớ cha, không nhìn thấy trong con
        => để nhìn thấy trong con được cần ép kiểu.
        - Với các phương thức override con đã ghi đè cha thì sẽ tham chiều đến phương thức con đã ghi đè
        * */
        ((Dog) animal).test();
        System.out.println(animal.speak()); // gâu gâu
        // => nếu speak(String x) trong Dog còn Animal không có phương thức ý thì sẽ gọi đến speak() của Animal
        // không gọi được phương thức demo() vì Animal không có phương thức này
//        System.out.println(animal.demo());
        System.out.println(animal.getClass().getTypeName()); // kiểu Dog, không phải kiểu Animal
        // Animal, Dog là 2 kiểu dữ liệu khác nhau.

        // dependency injection
        Dog[] dogs = new Dog[5];
        ManageAnimal manageAnimal = new ManageAnimal(dogs);


    }
}
