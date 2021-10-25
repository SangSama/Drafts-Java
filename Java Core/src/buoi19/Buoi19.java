package buoi19;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Buoi19 {
    /*
    * Annotation
    * => nó không tác động đến logic của class
    * => nó chỉ có ý nghĩa để đánh dấu
    * VD: @Functionalinterface đánh dấu interface đó là 1 functional, nó không thay đổi logic của interface đó
    * nhưng phải theo đúng luật chơi của nó :v Nếu không sẽ lỗi
    *
    * Reflection
    * => vô cùng hay
    * => hầu hết các list framework đều phải sử dụng Reflection
    *
    * !!! Tất cả class tất cả đều là con class Object (extends Object)
    * native => nó call xuống thư viện C (class Object được implement dưới C không phải ở Java)
    *
    * Mọi class thì đều implement từ thằng Type
    * => Object.class bản chất trả về Type
    *
    * */

    public static void main(String[] args) {
        // Object.class bản chất trả về Type
//        Type type = Demo.class;
//        System.out.println(type.getTypeName());


        // không cần sử dụng từ khóa NEW cũng có thể khởi tạo được đối tượng class thông qua Type
//        try {
//            Demo demo = Demo.class.newInstance(); // Demo.class <=> Type rồi gọi đến hàm newInstance()
//            System.out.println(demo);
//        } catch (InstantiationException | IllegalAccessException e) {
//            e.printStackTrace();
//        }


        // không có hàm setter, không có hàm constructor truyền tham số ??
        // => Cách 3 như sau:
//        try {
//            DemoSecound demoSecound = DemoSecound.class.newInstance();
//            // getDeclaredField lấy được cả Field private
//            Field field = DemoSecound.class.getDeclaredField("name");
//            // getField lấy các Field Public : Field field1 = DemoSecound.class.getField("name");
//            // cho phép bên ngoài truy cập vào thuộc tính này, set giá trị cho Field này
//            field.setAccessible(true);
//            field.set(demoSecound, "sang"); // set giá trị
//            System.out.println(demoSecound.getName() + " sama");
//        } catch (InstantiationException | IllegalAccessException | NoSuchFieldException e) {
//            e.printStackTrace();
//        }


        // truy cập và set lại giá trị của các thuộc tính private
//        Map<String, Object> map = new HashMap<>();
//        map.put("name", "sang");
//        map.put("age", 15);
//        map.put("address", "hanoi");
//        map.put("sex", true);
//
//        map.put("demo1", new Demo1("sangxxx", "demo"));

//        DemoSecound demoSecound = ReflectionUtil.convertToEntity(map, DemoSecound.class);
//        System.out.println(demoSecound);


        //
//        DemoSecound demoSecound = ReflectionUtil.convertToEntity(map, DemoSecound.class);
//        System.out.println(demoSecound);

//        Field[] fields = DemoSecound.class.getDeclaredFields();
//
//        Arrays.stream(fields).forEach(field -> {
//            Object object = null;
//            try {
//                object = FieldUtil.get(demoSecound, field);
//                System.out.println(object);
//            } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
//                e.printStackTrace();
//            }
//        });

        // dạy trong bài 20 - File
        Field[] fields = DemoSecound.class.getDeclaredFields();
        Arrays.stream(fields).forEach(field -> {
            if (field.isAnnotationPresent(MyAnnotation.class)){
                String name  = field.getAnnotation(MyAnnotation.class).name();
                System.out.println(name);
            }
        });

    }
}
