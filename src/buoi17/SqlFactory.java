package buoi17;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SqlFactory {
    // thông thường sẽ
//    public static Query gte(String attribute, Object value) {
//        return new Query(attribute, value, new Expression() {
//            @Override
//            public String operator() {
//                return Expression.gte();
//            }
//        });
//    }

    // hoặc sẽ tạo ra các hàm dùng riêng VD như Equal.java
//    public static Query equal(String attribute, Object value) {
//        return new Query(attribute, value, new Equal());
//    }

    // thay vì phải implement các class như vậy => dùng lambda or reference
    // lambda expression <=> call back function
//    public static Query notEqual(String attribute, Object value) {
//        return new Query(attribute, value, () -> Expression.notEqual() );
//    }

    // hoặc có thể như vậy, nhưng như thế này không tường minh
//    public static Query lt(String attribute, Object value) {
//        return new Query(attribute, value, () -> " > ");
//    }

    // reference method <=> call back function
//    public static Query gt(String attribute, Object value) {
//        return new Query(attribute, value, Expression::gt);
//    }


    // chữa bài
    public static QueryPractice equal(String attribute, Object value) {
        return new Query(attribute, value, Expression::equal);
    }

    public static QueryPractice notEqual(String attribute, Object value) {
        return new Query(attribute, value, Expression::notEqual);
    }

    public static QueryPractice gt(String attribute, Object value) {
        return new Query(attribute, value, Expression::gt);
    }

    public static QueryPractice gte(String attribute, Object value) {
        return new Query(attribute, value, Expression::gte);
    }

    public static QueryPractice lt(String attribute, Object value) {
        return new Query(attribute, value, Expression::lt);
    }

    public static QueryPractice lte(String attribute, Object value) {
        return new Query(attribute, value, Expression::lte);
    }

    public static Query and(List<QueryPractice> queryPractices) {
        List<QueryPractice> queryPractices1 = new ArrayList<>();
        for (QueryPractice queryPractice : queryPractices) {
            if (queryPractice != null) {
                queryPractices1.add(queryPractice);
            }
        }
        if (queryPractices1.isEmpty()) {
            return null;
        }
        List<String> conditions = new ArrayList<>();
        List<String> attributes = new ArrayList<>();
        Map<String , Object> values = new HashMap<>();
        for (QueryPractice queryPractice : queryPractices1) {
            conditions.add(queryPractice.conditon());
            attributes.add(queryPractice.attribute());
            values.put(queryPractice.attribute(), queryPractice.value());
        }
        String condition = String.join(" AND ", conditions);
        return new Query(condition, attributes, values);
    }

}
