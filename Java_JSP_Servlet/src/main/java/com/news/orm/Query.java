package com.news.orm;

import java.util.List;

public interface Query<T> {
    String condition();

    Object value();

    List<Object> values();
}
