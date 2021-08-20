package buoi17;

public class Buoi17 {
    /*
    * java 1.0, 1.1,...
    * => 1.5
    *   generic -> thay đổi collection
    * => 1.7
    *   -> sửa lõi của jvm
    * => 1.8 (functional programing => giải quyết nhiều bài toán, code gọn hơn)
    *   Delegate
    *   Arrow function
    *
    *   -> Functional
    *   -> Stream (
    *   -> lambda expression, reference method
    *   -> FunctionalPrograming
    * - Khi interface được đánh dấu là functionprograming phải thỏa mãn:
    * => interface chỉ chứa duy nhất 1 public abstract method
    *
    * */

    public static void main(String[] args) {
        // lambda expression
        Function function1 = s -> System.out.println(s);
        Function function2 = s -> {
            System.out.println(s);
        };
        // tương đương với
        Function function = new Function() {
            @Override
            public void print(String s) {
                System.out.println(s);
            }
        };
        function.print("ssm");


    }
}
