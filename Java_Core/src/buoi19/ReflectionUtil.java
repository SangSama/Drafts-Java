package buoi19;

import buoi19.converter.Converter;
import buoi19.converter.DataConverter;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Map;

public class ReflectionUtil {

    public static <T> T convertToEntity(Map<String, Object> map, Class<T> tClass) {
        try {
            T t = tClass.getConstructor().newInstance();
            Field[] fields = tClass.getDeclaredFields();
            DataConverter dataConverter = new DataConverter();
            Arrays.stream(fields).forEach(field -> {
                String name = field.getName();
                if (map.containsKey(name)) {
                    field.setAccessible(true);
                    Object object = map.get(name);
                    try {
//                        if (field.getType().equals(Integer.class)) {
//                            field.set(t, Integer.parseInt(object.toString()));
//                        } else if (field.getType().equals(Long.class)) {
//                            field.set(t, Long.parseLong(object.toString()));
//                        } else if (field.getType().equals(Boolean.class)) {
//                            field.set(t, Boolean.parseBoolean(object.toString()));
//                        } else {
//                            field.set(t, object.toString());
//                        }
                        Converter<?> converter = dataConverter.getValue(field.getType());
                        if (converter == null) {
                            FieldUtil.set(field, t, object);
                        } else {
                            FieldUtil.set(field, t, converter.converter(object));
                        }
                    } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
            });

            return  t;
        } catch (InvocationTargetException | InstantiationException | IllegalAccessException | NoSuchMethodException e) {
            e.printStackTrace();

            return null;
        }
    }


}
