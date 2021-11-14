package com.news.orm.pool;

import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionPool {
    private final HikariConfiguration hikariConfiguration;
    private final HikariDataSource hikariDataSource;
    private static volatile ConnectionPool connectionPool; // => SingerTorn => đảm bảo ra 1 biến duy nhất
    // volatile : là biến thông báo giữa các thread với nhau

    private ConnectionPool() {
        this.hikariConfiguration = new HikariConfiguration();
        this.hikariDataSource = hikariConfiguration.dataSource();
    }

    public static ConnectionPool of(){
        if (connectionPool == null){
            // synchronized => giúp đồng bộ
            synchronized (ConnectionPool.class){
                if (connectionPool == null){
                    connectionPool = new ConnectionPool();
                }
            }
        }

        return connectionPool;
    }

    public Connection getConnection() throws SQLException {
        return hikariDataSource.getConnection();
    }
}
