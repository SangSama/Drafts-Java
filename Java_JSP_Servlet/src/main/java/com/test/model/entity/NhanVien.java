package com.test.model.entity;

import com.test.orm.annotation.Column;
import com.test.orm.annotation.Entity;
import com.test.orm.annotation.Id;
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
