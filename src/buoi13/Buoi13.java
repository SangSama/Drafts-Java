package buoi13;

import java.lang.reflect.Field;

public class Buoi13 {
    /*
    *
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

    }
}
