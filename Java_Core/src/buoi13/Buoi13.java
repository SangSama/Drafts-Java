package buoi13;

import java.lang.reflect.Field;
import java.util.Scanner;

public class Buoi13 {
    /*
    * LÀM BÀI TẬP VỀ NHÀ: từ trang 33-59 tỏng file TopTaiLieu.com....
    *
    * */

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        // có 3 cách khởi tạo giá trị thuộc tính name
        // constructor truyền tham số
//        Tree tree1 = new Tree("táo");
//        System.out.println(tree1.getName());
        // dùng hàm setter
//        Tree tree2 = new Tree();
//        tree2.setName("đào");
//        System.out.println(tree2.getName());
        // dùng field => cách này hay hỏi khi pv
//        Tree tree3 = new Tree();
//        Field field = Tree.class.getDeclaredField("name");
//        field.setAccessible(true);
//        field.set(tree3, "xả");
//        System.out.println(tree3.getName());

        Scanner sc = new Scanner(System.in);

    }
}
