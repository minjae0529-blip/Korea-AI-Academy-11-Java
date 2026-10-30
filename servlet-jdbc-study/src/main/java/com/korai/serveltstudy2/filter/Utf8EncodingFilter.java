package com.korai.serveltstudy2.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

//스프링부트가면 어노테이션으로 필터 순서를 정할 수 있음. 서블릿은 xml.pom에 서블릿 매핑해서 해야 함 매핑순으로, 출력
//@WebFilter("/api/*")    //api로 시작하는 경로는 전부 필터를 걸쳐가는거임
public class Utf8EncodingFilter implements Filter {
    //살자가 비어있으면 추상메서드
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("1");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8"); //한글은 전처리이기때문에 필터에 거치기전에 인코딩을 해줘야 함

        chain.doFilter(request, response);  //dofilter 전에 실행되는ㄴ게 전처리

        System.out.println("3");
    }
}
