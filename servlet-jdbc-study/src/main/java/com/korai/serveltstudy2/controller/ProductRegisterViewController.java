package com.korai.serveltstudy2.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/product/register")
public class ProductRegisterViewController extends HttpServlet {

    //WEB-INF는 서블렛에서 자체적으로 접근제한을 걸어놔서 URL에 쳐도 접근이 안됨, 그렇기에 저렇게 해야 함
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/product-register.jsp").forward(req, resp);
    }

}
