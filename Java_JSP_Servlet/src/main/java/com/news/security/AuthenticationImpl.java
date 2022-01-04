package com.news.security;

import com.news.autowire.annotation.Autowire;
import com.news.autowire.annotation.Component;
import com.news.common.RoleConstant;
import com.news.model.request.user.AuthRequest;
import com.news.model.response.user.UserAuthResponse;
import com.news.service.UserService;

import javax.servlet.http.HttpServletRequest;

@Component
public class AuthenticationImpl implements Authentication {
    @Autowire
    private final UserService userService;

    public AuthenticationImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String authenticate(AuthRequest authRequest, HttpServletRequest httpServletRequest) {

        UserAuthResponse userAuthResponse = userService.findByUsernameAndPassword(authRequest);
        if(userAuthResponse == null){
            return "/login?message=username or password wrong";
        }

        if(userAuthResponse.getRoleId() == RoleConstant.ADMIN.role()){
            return "/admin/home";
        }

        return "/home";
    }
}
