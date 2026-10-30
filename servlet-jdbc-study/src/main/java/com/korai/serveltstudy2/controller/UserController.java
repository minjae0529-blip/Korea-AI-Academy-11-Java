package com.korai.serveltstudy2.controller;

import com.korai.serveltstudy2.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//데이터 관리를 컨트롤러 여기서 관리하는거임

@WebServlet("/users")
public class UserController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = new User(1, "user1", "test", "강민재");
        req.setAttribute("user", user); // 키 : 값, map임
        req.setAttribute("id", user.getId()); // 키 : 값, map임
        req.setAttribute("username", user.getUsername()); // 키 : 값, map임
        req.setAttribute("password", user.getPassword()); // 키 : 값, map임

        req.getRequestDispatcher("/user2.jsp").forward(req, resp);  //  여기가 뷰어임

    }
}
