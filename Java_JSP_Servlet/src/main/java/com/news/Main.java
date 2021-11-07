package com.news;

import com.news.repository.ConnectionInfo;
import com.news.repository.ConnectionManager;

import java.sql.*;

/*
* Tấn công SQL Injection
*
*
*
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
