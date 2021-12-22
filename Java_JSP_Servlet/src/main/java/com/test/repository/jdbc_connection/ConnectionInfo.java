package com.test.repository.jdbc_connection;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ConnectionInfo {
    private String url;
    private String userName;
    private String password;
}
