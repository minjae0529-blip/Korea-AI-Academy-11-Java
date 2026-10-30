package com.korai.serveltstudy2.controller;

import com.korai.serveltstudy2.model.User;
import com.korai.serveltstudy2.model.service.UserService;
import org.jboss.weld.context.http.Http;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user/list")
public class UserListController extends HttpServlet {

    private UserService userService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        userService = UserService.getInstance();
        userService.register(new User(0, "user1",  "1234", "강민재"));
        userService.register(new User(0, "user2",  "5678", "강민재1"));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("userList", userService.getUserAll());
        req.getRequestDispatcher("/WEB-INF/views/user-list.jsp").forward(req, resp);
    }
}
