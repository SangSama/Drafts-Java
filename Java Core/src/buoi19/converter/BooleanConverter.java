package buoi19.converter;

import java.util.Objects;

public class BooleanConverter implements Converter<Boolean>{
    @Override
    public Boolean converter(Object value) {
        if (Objects.isNull(value)) {
            return Object.class.isPrimitive() ? false : null;
        }

        return Boolean.parseBoolean(value.toString());
    }
}
