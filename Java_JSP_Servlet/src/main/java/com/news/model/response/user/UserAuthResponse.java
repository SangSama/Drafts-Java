package com.news.model.response.user;

import lombok.Data;

@Data
public class UserAuthResponse {
    private String url;
    private String userName;
    private long roleId;
}
