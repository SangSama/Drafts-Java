package com.news.service;

import com.news.model.request.user.AuthRequest;
import com.news.model.response.user.UserAuthResponse;

public interface UserService {
    UserAuthResponse findByUsernameAndPassword(AuthRequest authRequest);
}
