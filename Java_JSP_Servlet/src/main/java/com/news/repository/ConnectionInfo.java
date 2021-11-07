package com.news.repository;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ConnectionInfo {
    private String url;
    private String userName;
    private String password;
}
