package com.news.model.entity;

import com.test.orm.annotation.Entity;
import com.test.orm.annotation.Id;
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
    private String thumbnail;
    private String title;
    private String shortDescription;
    private String content;
    private int status;
    private int isHot;
    private long userId;
    private long categoryId;
    private LocalDate createDate;
    private LocalDate modifiedDate;
    private LocalDateTime publishDate;
}
