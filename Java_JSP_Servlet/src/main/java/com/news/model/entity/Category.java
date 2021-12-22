package com.news.model.entity;

import com.test.orm.annotation.Entity;
import com.test.orm.annotation.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Category {
    @Id
    private long id;
    private String name;
}
