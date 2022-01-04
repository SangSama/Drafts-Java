package com.news.model.entity;

import com.news.orm.annotation.Column;
import com.news.orm.annotation.Entity;
import com.news.orm.annotation.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Role {
    @Id
    private long id;
    @Column
    private String name;
}
