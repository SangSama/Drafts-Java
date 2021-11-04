package buoi17;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Test {
    public static void main(String[] args) {
        // Java 8 hỗ trợ 1 số function
        QueryPractice queryPractice = SqlFactory.equal("username", "sondx");
        QueryPractice queryPractice1 = SqlFactory.gt("age", 8);
        QueryPractice queryPractice2 = SqlFactory.lt("age", 30);

        // Function<T, R> => R apply(T t) : biến t thành R
        Function<QueryPractice, String> xx = QueryPractice::conditon;
        System.out.println(xx.apply(queryPractice));

        // Supplier<T> => T get()
        List<QueryPractice> queryPractices = new ArrayList<>();
        queryPractices.add(queryPractice);
        queryPractices.add(queryPractice1);
        queryPractices.add(queryPractice2);
        QueryPractice and = SqlFactory.and(queryPractices);
        Supplier<SqlBuilder> sqlBuilder = () -> new SqlBuilder(and);
        System.out.println(sqlBuilder.get().queryPractice(SqlSupport.SELECT));

        // Predicate<T> => boolean test(T t) : kiểm tra t

        // Stream
        List<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        integers.add(4);
        integers.add(5);
        integers.add(6);
        integers.add(7);
        integers.add(8);
        integers.add(9);
        // Consumer<T> =>

        // biến List thành Stream
        integers.stream().forEach(i -> System.out.println(i));
        // sử dụng map
        integers.stream().map(i -> i*2).forEach(System.out::println);
        // sử dụng filter
        integers.stream().filter(i -> i>5).forEach(System.out::println);
        // sử dụng findFirst
        System.out.println(integers.stream().filter(i -> i>5).findFirst().get());

        /*
        * ObjectNull
        *
        * */
        Optional<String> s = Optional.of("abc");
        System.out.println(s.get());
        Optional<String> ss = Optional.empty();
        // isPresent kiểm tra value != null
        if (ss.isPresent()) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }


    }
}
