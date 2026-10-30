package com.korai.servletstudy;   // 패키지 위치

import java.io.*;                 // java.io 안의 클래스 전부 가져오기 (* = 전부). 여기선 PrintWriter, IOException을 씀
import javax.servlet.http.*;      // HttpServlet, HttpServletRequest, HttpServletResponse 전부 가져오기
import javax.servlet.annotation.*;// @WebServlet 가져오기

@WebServlet(name = "helloServlet", value = "/hello-servlet")
// ↑ 이 클래스를 서블릿으로 등록하는 이름표 (web.xml에 안 적어도 됨)
//   name  = 서블릿 별명 (web.xml의 <servlet-name>과 같은 역할, 생략 가능)
//   value = 연결할 주소. 주소 끝이 /hello-servlet이면 이 클래스가 실행됨
//   → index.jsp의 "Hello Servlet" 링크를 누르면 여기로 옴
public class HelloServlet extends HttpServlet {   // HttpServlet 상속 = "나는 서블릿이다"

    private String message;
    // ↑ 필드(클래스 변수). 서블릿 객체는 1개뿐이라 모든 손님이 이 변수를 함께 봐요
    //   여기처럼 "모두에게 똑같은 고정 문구"는 괜찮지만, 손님마다 다른 값(이름 등)을 넣으면 섞이니 주의!

    public void init() {
        // 생명주기 1단계: 객체 생성 직후 1번만 실행
        message = "Hello World!";   // 필드에 문구를 미리 넣어 둠 (준비 작업)
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 생명주기 2단계: GET 요청마다 실행
        // (FirstServlet은 req/resp라고 썼고, 여기는 request/response라고 썼을 뿐 같은 거예요. 변수 이름은 자유)

        response.setContentType("text/html");
        // ↑ "보내는 건 HTML이야" → 브라우저가 <h1> 같은 태그를 해석해서 큰 글씨로 보여줌
        //   ⚠️ charset=UTF-8이 없어서 한글을 출력하면 깨질 수 있어요
        //      한글을 쓸 거라면 "text/html; charset=UTF-8"로 바꾸세요

        // Hello
        PrintWriter out = response.getWriter();      // 브라우저에 글자를 쓸 펜 꺼내기
        out.println("<html><body>");                 // HTML 문서 시작 + 화면 본문 시작
        out.println("<h1>" + message + "</h1>");     // <h1> = 큰 제목. init()에서 넣은 "Hello World!" 출력
        out.println("</body></html>");               // 본문 끝 + 문서 끝 (여는 태그 순서의 반대로 닫음)
    }

    public void destroy() {
        // 생명주기 3단계: 톰캣이 꺼질 때 1번 실행. 지금은 할 일이 없어서 비워 둠
    }
}