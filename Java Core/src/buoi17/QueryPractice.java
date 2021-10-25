package buoi17;

import java.util.List;
import java.util.Map;

public interface QueryPractice {
    String attribute();

    Object value();

    String conditon();

    List<String> attributes();

    Map<String, Object> values();

}
