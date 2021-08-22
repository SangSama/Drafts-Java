package buoi17;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Query implements QueryPractice {
    private String attribute;
    private Object value;
    private String condition;

    private List<String> attributes = new ArrayList<>();
    private Map<String, Object> values = new HashMap<>();

    public Query(String attribute, Object value, Expression expression) {
        this.attribute = attribute;
        this.value = value;
        this.condition = attribute + expression.operator() + ":" + attribute;
        this.attributes.add(attribute);
        this.values.put(attribute, value);
    }

    public Query(String condition, List<String> attributes, Map<String, Object> values) {
        this.condition = condition;
        this.attributes.addAll(attributes);
        this.values.putAll(values);
    }

    // cmt lại
//    public String getAttribute() {
//        return attribute;
//    }
//
//    public Object getValue() {
//        return value;
//    }
//
//    public String getCondition() {
//        return condition;
//    }

    @Override
    public String attribute() {
        return attribute;
    }

    @Override
    public Object value() {
        return value;
    }

    @Override
    public String conditon() {
        return condition;
    }

    @Override
    public List<String> attributes() {
        return attributes;
    }

    @Override
    public Map<String, Object> values() {
        return values;
    }

}
