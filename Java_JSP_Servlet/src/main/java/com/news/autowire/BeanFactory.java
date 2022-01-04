package com.news.autowire;

import com.news.autowire.annotation.Autowire;
import com.news.autowire.annotation.Component;
import com.news.autowire.annotation.Repository;
import com.news.autowire.annotation.Service;
import org.reflections.Reflections;

import java.lang.reflect.InvocationTargetException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class BeanFactory {
    private static Map<String, Object> beans = new ConcurrentHashMap<>();

    static {
        // đọc toàn bộ trong base package này
        var reflections = new Reflections("com.news");
        var repositoriesClasses = reflections.getTypesAnnotatedWith(Repository.class);
        var serviceClasses = reflections.getTypesAnnotatedWith(Service.class);
        var componentClasses = reflections.getTypesAnnotatedWith(Component.class);
        try {
            putBean(repositoriesClasses);
            putBean(serviceClasses);
            putBean(componentClasses);
        } catch (IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
    }

    private static void putBean(Set<Class<?>> classes) throws IllegalAccessException, InstantiationException {
        if (classes.isEmpty()) return;

        for (var clazz : classes) {
            var key = getKey(clazz);
            var fields = clazz.getDeclaredFields();
            if (fields.length == 0) {
                try {
                    var object = clazz.getDeclaredConstructor().newInstance();
                    beans.put(key, object);
                    continue;
                } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }

            List<Class> types = new LinkedList<>();
            var values = new LinkedList<>();

            for (var field : fields) {
                if (field.isAnnotationPresent(Autowire.class)) {
                    types.add(field.getType());
                    Object bean = beans.get(field.getName());
                    values.add(bean);
                }
            }

            Class[] parameters = new Class[types.size()];
            var i = 0;

            for (Class type : types) {
                parameters[i++] = type;
            }

            try {
                var constructor = clazz.getConstructor(parameters);
                var object = constructor.newInstance(values.toArray());
                beans.put(key, object);
            } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }

        }
    }

    //NewsRepositoryImpl => newsRepository
    private static String getKey(Class<?> bean) {
        var name = bean.getSimpleName();
        if (name.endsWith("Impl")) {
            name = name.substring(0, name.indexOf("Impl"));
        }
        name = name.substring(0, 1).toLowerCase() + name.substring(1);

        return name;
    }

    public static Object get(String key){
        return beans.get(key);
    }
}
