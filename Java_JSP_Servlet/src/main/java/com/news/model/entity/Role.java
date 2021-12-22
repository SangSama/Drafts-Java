package com.news.model.entity;

import com.test.orm.annotation.Entity;
import com.test.orm.annotation.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Role {
    @Id
    private long id;
    private String name;
}
