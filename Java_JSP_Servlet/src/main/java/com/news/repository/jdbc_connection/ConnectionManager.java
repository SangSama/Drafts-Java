package com.news.repository.jdbc_connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
    private ConnectionInfo connectionInfo;

    public ConnectionManager(ConnectionInfo connectionInfo) {
        this.connectionInfo = connectionInfo;
    }

    public Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            return DriverManager.getConnection(
                    connectionInfo.getUrl(),
                    connectionInfo.getUserName(),
                    connectionInfo.getPassword()
            );
        } catch (ClassNotFoundException | SQLException e) {
            return null;
        }
    }
}
