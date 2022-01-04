package com.news.controller.page.admin;

import com.news.controller.BaseController;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/home")
public class HomePage extends BaseController {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rs = req.getRequestDispatcher("/views/homeAdmin.jsp");
        rs.forward(req, resp);
    }
}
