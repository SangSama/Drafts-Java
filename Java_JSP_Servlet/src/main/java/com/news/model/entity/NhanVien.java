package com.news.model.entity;

import com.news.orm.annotation.Column;
import com.news.orm.annotation.Entity;
import com.news.orm.annotation.Id;
import lombok.Data;

@Entity(name = "nhanvien")
@Data
public class NhanVien {
    @Id(name = "MaNV", autoIncrement = false)
    private String maNv;
    @Column(name = "Ten")
    private String ten;
    @Column(name = "Luong")
    private int luong;
}
