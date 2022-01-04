package com.news.model.entity;

import com.news.orm.annotation.Column;
import com.news.orm.annotation.Entity;
import com.news.orm.annotation.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Setter
@Getter
public class User {
    @Id
    private long id;
    @Column
    private String username;
    @Column
    private String password;
    @Column
    private String email;
    @Column
    private long roleId;
    @Column
    private String createdBy;
    @Column
    private LocalDate createdDate;
    @Column
    private String modifiedBy;
    @Column
    private LocalDate modifiedDate;
}
