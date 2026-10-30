package com.korai.serveltstudy2.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebFilter("/api/*")
public class CorsFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("전처리");
        System.out.println("11");

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        String method = req.getMethod();
        System.out.println(method);     //options : 정찰병으로 사용함, 요청을 날렸을때 응답이 오는지 확인함

        resp.setHeader("Access-Control-Allow-Origin", "*");
        resp.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS");
        resp.setHeader("Access-Control-Allow-Headers", "Content-Type");

        //정찰병 돌려보내야 함
        if("OPTIONS".equals(method)){
            resp.setStatus(200);
            return;
        }

        chain.doFilter(request, response);      //servlet Filter기준으로 전에 전처리, 후ㅇ처리나뉨
        System.out.println("22");
        System.out.println("후처리");
    }
}
