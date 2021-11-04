package buoi17;

import java.util.ArrayList;
import java.util.List;

/*
* JAVA 8
*
* */

public class Buoi17 {
    /*
    * java 1.0, 1.1,...
    * => 1.5
    *   generic -> thay đổi collection
    * => 1.7
    *   -> sửa lõi của jvm
    * => 1.8 (functional programing => giải quyết nhiều bài toán, code gọn hơn)
    *   <=> Delegate (C#)
    *   <=> Arrow function (Js)
    *   -> default, static
    *   -> Stream (cách thức giao tiếp với Collection)
    *   -> lambda expression, reference method
    *       Cách sử dụng:
    *       => lambda expression : sử dụng khi thực thi nhiều dòng
    *       => reference method : sử dụng khi trên 1 dòng
    *       lambda expression <=> reference method
    *
    *   -> annotation java : FunctionalPrograming => tim của java8
    *
    * - Khi interface được đánh dấu là functionprograming phải thỏa mãn:
    * => interface chỉ chứa duy nhất 1 public abstract method
    *
    *
    * */

    public static void main(String[] args) {
        // lambda expression : toán tử lambda "->"
        Function function1 = s -> System.out.println(s);
        Function function2 = s -> {
            System.out.println(s);
        };
        // reference method
        Function function3 = System.out::println;
        // tương đương với
        Function function = new Function() {
            @Override
            public void print(String s) {
                System.out.println(s);
            }
        };
        function.print("ssm");
        function1.print("ssm1");
        function2.print("ssm2");
        function3.print("ssm3");

        System.out.println("----------------------------------------------------------------------------------------");

//        Query query = SqlFactory.equal("username", "sondx");
//        System.out.println(query.getCondition());

        System.out.println("----------------------------------------------------------------------------------------");

        // <=> call back function
        int sum = add(1, 2, Math2::add);
        System.out.println(sum);
        int sum2 = add(1, 2, Math::add);
        System.out.println(sum2);

//        System.out.println("----------------------------------------------------------------------------------------");
        /*
        * SELECT * FROM user
        * WHERE username = sondx
        * AND age > 8
        * AND age < 30
        * AND ...
        * */

        /*
        * GỢI Ý:
        * - Cộng chuỗi
        * - Collection (stack, map)
        * - Reference method
        * */

        // tự làm
//        Query user = SqlFactory.equal("username", "sondx");
//        Query condition1 = SqlFactory.lt("age", 8);
//        Query condition2 = SqlFactory.gt("age", 30);
//        System.out.println("WHERE " + user.getCondition() + " AND " + condition1.getCondition() + " AND " + condition2.getCondition());

        // chữa
        QueryPractice queryPractice = SqlFactory.equal("username", "sondx");
        QueryPractice queryPractice1 = SqlFactory.gt("age", 8);
        QueryPractice queryPractice2 = SqlFactory.lt("age", 30);
        List<QueryPractice> queryPractices = new ArrayList<>();
        queryPractices.add(queryPractice);
        queryPractices.add(queryPractice1);
        queryPractices.add(queryPractice2);
        QueryPractice and = SqlFactory.and(queryPractices);
        SqlBuilder sqlBuilder = new SqlBuilder(and);
        System.out.println(sqlBuilder.queryPractice(SqlSupport.SELECT));

    }

    // referenceMethod thay thế nhiều class được gọi
    public static int add(int a, int b, ReferenceMethod referenceMethod) {
        return referenceMethod.add(a, b);
    }
}
