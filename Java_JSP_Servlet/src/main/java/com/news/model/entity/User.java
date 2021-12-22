package com.news.model.entity;

import com.test.orm.annotation.Entity;
import com.test.orm.annotation.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Setter
@Getter
public class User {
    @Id
    private long id;
    private String username;
    private String password;
    private String email;
    private long roleId;
    private String createdBy;
    private LocalDate createdDate;
    private String modifiedBy;
    private LocalDate modifiedDate;
}
