package com.korai.servletstudy;   // 이 파일이 들어 있는 폴더(패키지) 위치

// ===== 필요한 도구 가져오기 =====
import javax.servlet.ServletException;           // 서블릿 처리 중 문제가 생기면 나는 예외
import javax.servlet.annotation.WebServlet;      // @WebServlet 표시용 (이 파일에서는 안 쓰고 있어서 회색으로 보일 거예요)
import javax.servlet.http.HttpServlet;           // 서블릿의 부모 클래스
import javax.servlet.http.HttpServletRequest;    // 요청(주문서) 객체 타입
import javax.servlet.http.HttpServletResponse;   // 응답(접시) 객체 타입
import java.io.IOException;                      // 글자를 내보내다 문제가 생기면 나는 예외

// ※ 이 클래스에는 @WebServlet이 없음!
//   대신 web.xml에서 "/first 주소 = FirstServlet"으로 연결해 두었기 때문에 동작합니다.
public class FirstServlet extends HttpServlet { // HttpServlet을 상속받아야 톰캣이 서블릿으로 인정함

    @Override                                    // 부모(HttpServlet)의 init()을 내 방식으로 다시 정의
    public void init() throws ServletException {
        // 생명주기 1단계: 첫 요청이 와서 객체가 만들어진 직후 "딱 1번"만 실행됨
        System.out.println("FirstServlet 초기화");  // IntelliJ 콘솔에 찍힘 (브라우저 X)
    }

    //get요청만 받음, 요청이 get일때만 작동함, req에 들어있음, 반대로 응답은 resp
    @Override
    protected void doGet(HttpServletRequest req,    // req  = 톰캣이 만들어 넘겨준 요청 정보 (주문서)
                         HttpServletResponse resp)  // resp = 결과를 담아 돌려보낼 응답 (빈 접시)
            throws ServletException, IOException {  // 생길 수 있는 예외는 톰캣에게 넘김
        // 생명주기 2단계: GET 요청이 올 때마다 실행됨 (새로고침할 때마다 반복)
        System.out.println("GET요청 들어옴");          // 콘솔에 찍힘

        resp.setStatus(400);
        // ↑ 응답 "상태 코드"를 400으로 설정
        //   200 = 성공(기본값), 400 = 잘못된 요청(Bad Request), 404 = 주소 없음, 500 = 서버 코드 에러
        //   화면엔 글자가 정상으로 보이지만, F12 → Network 탭을 보면 빨간색 400으로 표시돼요
        //   (상태 코드를 바꿔보는 연습용 코드. 평소에는 이 줄을 안 써도 200이 나가요)

        resp.setContentType("text/plain");
        // ↑ "보내는 내용은 그냥 글자(text/plain)야"라고 브라우저에 알림
        //   text/plain → <h1> 같은 태그도 그대로 글자로 보여줌
        //   text/html  → 태그를 해석해서 화면을 꾸며줌

        resp.setCharacterEncoding("UTF-8");
        // ↑ 응답 글자를 UTF-8(한글 가능) 방식으로 보내기 → "응답데이터" 한글이 안 깨짐
        //   위 두 줄은 resp.setContentType("text/plain; charset=UTF-8"); 한 줄로 합쳐 쓸 수도 있어요

        resp.getWriter().println("응답데이터");
        // ↑ getWriter() = 응답에 글자를 쓰는 펜을 꺼냄
        //   .println(...) = 그 펜으로 "응답데이터"를 써서 브라우저 화면에 보냄
    }

    // ===== 아래는 연습하다가 주석 처리해 둔 service() 메서드 =====
    // service()는 GET, POST 구분 없이 "모든 요청"을 제일 먼저 받는 메서드예요.
    // 원래 부모 HttpServlet의 service()가 요청 방식을 보고 doGet() / doPost()로 나눠줍니다.
    // ⚠️ 만약 이걸 오버라이드(주석 해제)하면, 나눠주는 일을 내가 가로채는 거라
    //    위의 doGet()이 더 이상 자동으로 호출되지 않아요!
//    @Override
//    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println("서비스 호출");
//        System.out.println(req.getMethod());        //조회의 기능을 해야함   ← getMethod() = 요청 방식 "GET"/"POST"를 문자열로 알려줌
//        if (req.getMethod().equalsIgnoreCase("GET")) {   // equalsIgnoreCase = 대소문자 무시하고 비교 ("get"도 "GET"으로 인정)
//            System.out.println("GET요청 들어옴");
//        }
//    }

    // ※ destroy()는 만들지 않았지만 괜찮아요. 부모 클래스에 빈 destroy()가 이미 있어서 그걸 씁니다.
}