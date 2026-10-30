package com.korai.serveltstudy2.controller;

import com.korai.serveltstudy2.model.Book;
import com.korai.serveltstudy2.model.repository.BookRepository;
import com.korai.serveltstudy2.model.service.BookService;
import tools.jackson.databind.ObjectMapper;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/api/books")
public class BookApiController extends HttpServlet {


    @Override
    public void init(ServletConfig config) throws ServletException {
        BookService bookService = BookService.getInstance();
    }

    // ★ [추가 1] 405 에러를 막는 브라우저 사전 검사용 메서드
    @Override
    protected void doOptions(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setHeader("Access-Control-Allow-Origin", "*");
        resp.setHeader("Access-Control-Allow-Methods", "POST, OPTIONS");
        resp.setHeader("Access-Control-Allow-Headers", "Content-Type");
        resp.setStatus(HttpServletResponse.SC_OK);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json;charset=UTF-8");

        ObjectMapper objectMapper = new ObjectMapper();
        Book book = objectMapper.readValue(req.getInputStream(), Book.class);

        System.out.println("프론트가 보낸 책: "+ book.getBookName() + " ㅣ 책가격" + book.getPrice());

        objectMapper.writeValue(resp.getWriter(), book);
    }
}
