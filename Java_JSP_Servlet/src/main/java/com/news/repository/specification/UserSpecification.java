package com.news.repository.specification;

import com.news.model.entity.User;
import com.news.model.request.user.AuthRequest;
import com.news.orm.Query;
import com.news.orm.QueryFactory;
import com.news.utils.StringUtil;

import java.util.ArrayList;
import java.util.List;

public class UserSpecification {
    private UserSpecification() {
    }

    public static Query<User> filterAuth(AuthRequest authRequest) {
        List<Query<User>> queries = new ArrayList<>();
        queries.add(withUsername(authRequest.getUsername()));
        queries.add(withPassword(authRequest.getPassword()));
        return QueryFactory.and(queries);
    }

    private static Query<User> withUsername(String username) {
        if (StringUtil.isEmpty(username)) return null;

        return QueryFactory.eq("username", username);
    }

    private static Query<User> withPassword(String password) {
        if (StringUtil.isEmpty(password)) return null;

        return QueryFactory.eq("password", password);
    }
}
