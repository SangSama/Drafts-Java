package com.news.orm.pool;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class HikariConfiguration {
    public HikariConfiguration(){

    }

    public HikariConfig config(){
        HikariConfig config = new HikariConfig();
        config.setAutoCommit(false);
        config.setJdbcUrl("jdbc:mysql://localhost:3306/csdlhangkhong");
        config.setUsername("root");
        config.setPassword("Sang.tt172785");
        config.setDriverClassName("com.mysql.cj.jdbc.Driver");
        config.setConnectionTimeout(10000);
        config.setIdleTimeout(20);
        config.setMinimumIdle(10);
        config.setMaximumPoolSize(20);

        return config;
    }

    public HikariDataSource dataSource(){
        HikariDataSource hikariDataSource = new HikariDataSource(config());

        return hikariDataSource;
    }
}
