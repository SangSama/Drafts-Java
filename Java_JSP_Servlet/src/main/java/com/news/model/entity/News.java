package com.news.model.entity;

import com.news.orm.annotation.Column;
import com.news.orm.annotation.Entity;
import com.news.orm.annotation.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Setter
@Getter
public class News {
    @Id
    private long id;
    @Column
    private String thumbnail;
    @Column
    private String title;
    @Column
    private String shortDescription;
    @Column
    private String content;
    @Column
    private int status;
    @Column
    private int isHot;
    @Column
    private long userId;
    @Column
    private long categoryId;
    @Column
    private LocalDate createDate;
    @Column
    private LocalDate modifiedDate;
    @Column
    private LocalDateTime publishDate;
}
