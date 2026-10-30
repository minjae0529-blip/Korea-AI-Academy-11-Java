package com.korai.serveltstudy2.controller;

import com.korai.serveltstudy2.model.Product;
import lombok.Data;
import tools.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@WebServlet("/api/products")
public class ProductApiController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> products = new ArrayList<>();
        products.add(new Product("상품1", 10000));
        products.add(new Product("상품2", 20000));
        products.add(new Product("상품3", 30000));
        products.add(new Product("상품4", 40000));

        ObjectMapper objectMapper = new ObjectMapper();

        String json = objectMapper.writeValueAsString(products);

        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().println(json);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("요청 들어옴");

//        BufferedReader bufferedReader = req.getReader();
//        String json = "";
//
//        while((json = bufferedReader.readLine()) != null){
//            System.out.println(json);
//        }


        ObjectMapper objectMapper = new ObjectMapper();

        Product p = objectMapper.readValue(req.getInputStream(), Product.class);
        System.out.println(p);
    }

}
