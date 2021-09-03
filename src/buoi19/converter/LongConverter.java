package buoi19.converter;

import java.util.Objects;

public class LongConverter implements Converter<Long>{
    @Override
    public Long converter(Object value) {
        if (Objects.isNull(value)) {
            return Object.class.isPrimitive() ? 0l : null;
        }

        return Long.parseLong(value.toString());
    }
}
