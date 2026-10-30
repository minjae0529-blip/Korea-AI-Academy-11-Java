package com.korai.serveltstudy2.controller;

import com.korai.serveltstudy2.model.Car;
import tools.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//ObjectMapper = JSON 글자와 자바 객체를 서로 바꿔주는 통역사. 받을 땐 readValue, 보낼 땐 writeValue.
@WebServlet("/api/cars")
public class CarApiController extends HttpServlet {

    // ① [문 열어주기] CORS 허용 (이게 없으면 브라우저가 차단함)
    private void setCors(HttpServletResponse resp) {
        resp.setHeader("Access-Control-Allow-Origin", "*");
        resp.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS");
        resp.setHeader("Access-Control-Allow-Headers", "Content-Type");
    }

    // ② [사전 검사 통과] 브라우저가 몰래 먼저 보내는 OPTIONS 요청 통과용
    @Override
    protected void doOptions(HttpServletRequest req, HttpServletResponse resp) {
        setCors(resp);
        resp.setStatus(HttpServletResponse.SC_OK);
    }

    // ③ [본 요청 처리] 프론트가 보낸 데이터 읽기
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        setCors(resp); // 문 열기
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json;charset=UTF-8");

        // Jackson 통역사로 JSON 글자 -> 자바 Car 객체로 변환!
        ObjectMapper mapper = new ObjectMapper();
        Car car = mapper.readValue(req.getInputStream(), Car.class);

        // 콘솔에 출력해서 확인
        System.out.println("프론트가 보낸 차: "+ car.getCarName());

        // 4단계로 이어짐: 답장 보내기
        mapper.writeValue(resp.getWriter(), car);
    }
}