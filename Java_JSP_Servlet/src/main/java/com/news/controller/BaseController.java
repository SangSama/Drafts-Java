package com.news.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class BaseController extends HttpServlet {
    private final static ObjectMapper objectMapper = new ObjectMapper();

    public <T> T convertJsonToObject(HttpServletRequest request, Class<T> tClass){
        var json = new StringBuilder();
        String line;
        try {
            while ((line = request.getReader().readLine()) != null) {
                json.append(line);
            }
            return objectMapper.readValue(json.toString(), tClass);
        } catch (IOException e) {
            e.printStackTrace();

            return null;
        }
    }

    public <T> T convertFromMap(HttpServletRequest request, Class<T> clazz) {
        try {
            T t = clazz.getDeclaredConstructor().newInstance();
            BeanUtils.populate(t, request.getParameterMap());

            return t;
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getCause().toString());
        }
    }

    public void responseClient(HttpServletResponse resp, Object model) throws IOException {
        var out = resp.getWriter();
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        out.print(objectMapper.writeValueAsString(model));
        out.flush();
    }
}
