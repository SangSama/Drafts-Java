package buoi19.converter;

import java.util.Objects;

public class IntegerConverter implements Converter<Integer>{
    @Override
    public Integer converter(Object value) {
        if (Objects.isNull(value)) {
            return value.getClass().isPrimitive() ? 0 : null;
        }

        return Integer.parseInt(value.toString());
    }
}
