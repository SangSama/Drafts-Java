package buoi19.converter;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class DataConverter {
    private final Map<Type, Converter<?>> converter;

    public DataConverter() {
        this.converter = defaultConverter();
    }

    private Map<Type, Converter<?>> defaultConverter() {
        Map<Type, Converter<?>> map = new HashMap<>();
        map.put(Long.class, new LongConverter());
        map.put(Boolean.class, new BooleanConverter());
        map.put(Integer.class, new IntegerConverter());
        map.put(String.class, new StringConverter());
        return map;
    }

    public Converter<?> getValue(Type type) {
        return converter.get(type);
    }
}
