package com.news.model.entity;

import com.news.orm.annotation.Column;
import com.news.orm.annotation.Entity;
import com.news.orm.annotation.Id;
import lombok.Data;

@Entity
@Data
public class User {
    @Id
    private Long id;
    @Column
    private String userName;
    @Column
    private String password;

//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getUserName() {
//        return userName;
//    }
//
//    public void setUserName(String userName) {
//        this.userName = userName;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }

}
