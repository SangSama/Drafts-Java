package com.news.controller.api;

import com.news.controller.BaseController;

import com.news.autowire.BeanFactory;
import com.news.controller.BaseController;
import com.news.model.request.user.AuthRequest;
import com.news.model.response.user.UserAuthResponse;
import com.news.security.Authentication;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/api/login")
public class LoginApiController extends BaseController {
    public final Authentication authentication;

    public LoginApiController(){
        this.authentication = (Authentication) BeanFactory.get("authentication");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AuthRequest authRequest = convertJsonToObject(req, AuthRequest.class);
        String uri = authentication.authenticate(authRequest, req);
        UserAuthResponse authResponse = new UserAuthResponse();
        authResponse.setUrl(uri);
        responseClient(resp, authResponse);
    }
}
