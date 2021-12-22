package com.test;

import com.test.model.entity.NhanVien;
import com.test.repository.NhanVienRepository;
import com.test.repository.impl.NhanVienRepositoryImpl;

import java.util.List;

public class MainOrm {

    public static void main(String[] args) {
//        User user = new User();
//        user.setUserName("sondx");
//        user.setPassword("123456");
//        UserRepository userRepository = new UserRepositoryImpl();
//        userRepository.save(user);

        NhanVien nhanVien = new NhanVien();
        nhanVien.setMaNv("123456");
        nhanVien.setTen("sangggggggggg");
        nhanVien.setLuong(100000000);
        NhanVienRepository nhanVienRepository = new NhanVienRepositoryImpl();
//        nhanVienRepository.save(nhanVien);
//        nhanVienRepository.update("123456", nhanVien);
        List<NhanVien> nhanVien1 = nhanVienRepository.findAll();
        nhanVien1.forEach(System.out::println);


    }
}
