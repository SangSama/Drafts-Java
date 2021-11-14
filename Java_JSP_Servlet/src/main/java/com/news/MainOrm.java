package com.news;

import com.news.model.entity.NhanVien;
import com.news.model.entity.User;
import com.news.repository.NhanVienRepository;
import com.news.repository.UserRepository;
import com.news.repository.impl.NhanVienRepositoryImpl;
import com.news.repository.impl.UserRepositoryImpl;

public class MainOrm {

    public static void main(String[] args) {
//        User user = new User();
//        user.setUserName("sondx");
//        user.setPassword("123456");
//        UserRepository userRepository = new UserRepositoryImpl();
//        userRepository.save(user);

        NhanVien nhanVien = new NhanVien();
        nhanVien.setMaNv("123456");
        nhanVien.setTen("sang");
        nhanVien.setLuong(100000000);
        NhanVienRepository nhanVienRepository = new NhanVienRepositoryImpl();
        nhanVienRepository.save(nhanVien);


    }
}