package com.news.model.entity;


import com.news.orm.annotation.Column;
import com.news.orm.annotation.Entity;
import com.news.orm.annotation.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Category {
    @Id
    private long id;
    @Column
    private String name;
}
