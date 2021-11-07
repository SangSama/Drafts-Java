package com.news;

import com.news.repository.ConnectionInfo;
import com.news.repository.ConnectionManager;

import java.sql.*;

/*
*** porm : là công cụ để build và đóng gói ứng dụng của chúng ta sang dạng file .jaw và file .war
* => đóng gói toàn bộ thư viện luôn
*
*
*** mvnrepository.com : chứa tất cả các repository hỗ trợ trong java
*
*
*** Lombok :
* => rất tiện lợi
* => giúp ta không cần phải sinh ra getter và setter
* => cơ chế:
*   + file java bản chất là 1 file => đọc ghi file đó
*       => Reflection => hoàn toàn có thể đọc hết các thuộc tính
*       => đọc ghi file absolute file => sinh ra các template
*   + Chạy ứng dụng => tìm các class mà được đánh dấu bởi các cái annotation ( @getter, @setter ... )
*       => tìm đến cái part file => sinh ra các template => sinh ra hàm get set
*   VD: public void set* (Type *) {
*           this.* = *;
*       }
*       * : tên thuộc tính
*
*
*** Giao tiếp giữa Java và SQL là bridge nào đó => thông qua 1 giao thức - hình thành cách thức giao tiếp
*
*
*** 3-tier ***
*   - Presentation tier: chỉ để hiển thị
*       => MVC chỉ nằm ở tầng Presentation vì:
*           + M-Model : dữ liệu giao tiếp giữa V và C
*           + V-View : html, vuejs, reactjs
*           + C-Controller : tầng server => nhận được M gửi xuống Business cần làm gì không liên quan đến tầng Business
*   - Business tier: xử lý nghiệp vụ, xử lý logic
*   - Data tier: quản lý những câu truy vấn vào trong database
*       + DAO : Data Access Object
*       + Repository
* */

/*
* Tấn công SQL Injection
* => thường thì rất khó bị tấn công SQL Injection
*
* => cộng chuỗi
* SELECT * FROM nhanvien
* WHERE 1 = 1
* AND name = 'sondx';
*
* DELETE FROM nhanvien; => xóa sạch nhanvien
*
* => để tránh chúng ta sẽ không cộng chuỗi:
*
* */

public class Main {

    public static void main(String[] args) {
        ConnectionInfo connectionInfo = new ConnectionInfo("jdbc:mysql://localhost:3306/csdlhangkhong", "root", "Sang.tt172785");
        ConnectionManager connectionManager = new ConnectionManager(connectionInfo);

        String sql = "SELECT * FROM nhanvien WHERE Luong > ?";
        Connection connection = connectionManager.getConnection();

        if (connection != null) {
            try {
                PreparedStatement callableStatement = connection.prepareStatement(sql);
                callableStatement.setInt(1, 200000);
                callableStatement.execute();
                ResultSet resultSet = callableStatement.getResultSet();
//                System.out.println(resultSet.getString(" MaNV           | Ten                       | Luong"));
                while (resultSet.next()) {
                    String maNV = resultSet.getString("MaNV");
                    String ten = resultSet.getString("Ten");
                    int luong = resultSet.getInt("Luong");
                    System.out.println(maNV + "  " + ten + "  " + luong);
                }
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println(e.getMessage());
            }
        }
    }
}