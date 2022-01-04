package com.news.service.impl;

import com.news.autowire.annotation.Autowire;
import com.news.autowire.annotation.Service;
import com.news.model.entity.User;
import com.news.model.request.user.AuthRequest;
import com.news.model.response.user.UserAuthResponse;
import com.news.orm.Query;
import com.news.repository.UserRepository;
import com.news.repository.specification.UserSpecification;
import com.news.service.UserService;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowire
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserAuthResponse findByUsernameAndPassword(AuthRequest authRequest) {
        Query<User> query = UserSpecification.filterAuth(authRequest);
        Optional<User> user = userRepository.find(query);
        if (user.isEmpty()) {
            return null;
        }

        UserAuthResponse userAuthResponse = new UserAuthResponse();
        userAuthResponse.setUserName(user.get().getUsername());
        userAuthResponse.setRoleId(user.get().getRoleId());

        return userAuthResponse;
    }
}
