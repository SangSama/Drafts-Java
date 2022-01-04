package com.news.security;

import com.news.model.request.user.AuthRequest;

import javax.servlet.http.HttpServletRequest;

public interface Authentication {
    String authenticate(AuthRequest authRequest, HttpServletRequest httpServletRequest);
}
