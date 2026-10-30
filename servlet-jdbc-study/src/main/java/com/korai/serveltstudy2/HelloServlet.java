package com.korai.serveltstudy2;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        String[] names = {"강민재", "강민재1"};

        // Hello
        PrintWriter out = response.getWriter();
        out.println("""
                <html>
                    <title>탭제목</title>
                <head>
                </head>
                <body>
                    <h1></h1>
                    <h1>강민재</h1>
                </body>
                </html>
                """);
    }

    public void destroy() {
    }
}