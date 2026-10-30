package com.korai.serveltstudy2.controller;

import com.korai.serveltstudy2.exception.DuplicatedException;
import com.korai.serveltstudy2.model.User;
import com.korai.serveltstudy2.model.service.UserService;
import tools.jackson.databind.ObjectMapper;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/api/users")
public class UserApiController extends HttpServlet {

    private UserService userService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        userService = UserService.getInstance();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, RuntimeException, IOException {
        req.setCharacterEncoding("UTF-8");  //요청이 들어왔을 때 한글 인코딩하는 작업
        ObjectMapper objectMapper = new ObjectMapper();
        User user = objectMapper.readValue(req.getInputStream(), User.class);
        System.out.println("사용자 등록 요청 들어옴 ");

        System.out.println(user);
        try {
            userService.register(user);
            resp.setContentType("application/json");
            resp.setCharacterEncoding("UTF-8");
            resp.getWriter().println(objectMapper.writeValueAsString(Map.of(
                    "message", "사용자 등록성공"
            )));

        }catch (DuplicatedException e){
            resp.setContentType("application/json");
            resp.setCharacterEncoding("UTF-8");
            resp.setStatus(400);
            resp.getWriter().println(objectMapper.writeValueAsString(Map.of(
                    "message", e.getMessage()
            )));
            return;
        }
    }
}
