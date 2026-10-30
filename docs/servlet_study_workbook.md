# 🌐 Servlet 왕초보 노트 & 실습 문제집 (주석 100%)

> 💡 **학습자**: 강민재
> **아는 것**: Java, JavaScript | **모르는 것**: HTML, 웹 서버 → 이 노트에서 처음부터 설명합니다.
> **실습 환경**: IntelliJ Ultimate + Tomcat 10 (설치 방법은 **그림 실습 가이드** 0~9단계 참고)
> **읽는 법**: 📖 개념 읽기 → 🛠️ 실습 따라 치기 → ❓ 퀴즈 → 💻 코딩 문제 순서로 진행합니다. 정답은 직접 풀어본 뒤에 펼치세요.

---

## 📚 [Step 0] 용어 사전: 이것만 알면 시작할 수 있다

> 🍜 **식당 비유로 기억하기**
> 손님(브라우저)이 주문서(요청)를 내면 → 매니저(톰캣)가 받아서 → 담당 요리사(서블릿)에게 넘기고 → 요리사가 접시(응답)에 음식을 담으면 → 매니저가 손님에게 가져다줍니다.

| 용어 | 쉬운 뜻 | 식당 비유 |
|---|---|---|
| **클라이언트** | 서비스를 요청하는 쪽. 보통 **브라우저(크롬)** | 손님 |
| **서버** | 요청을 받아 처리해주는 컴퓨터/프로그램 | 식당 |
| **요청 (Request)** | 브라우저가 서버에 보내는 메시지. "이 주소 화면 주세요 + 추가 정보" | 주문서 |
| **응답 (Response)** | 서버가 브라우저에 돌려주는 메시지. 보통 화면에 그릴 글자(HTML) | 음식이 담긴 접시 |
| **HTTP** | 브라우저와 서버가 대화하는 **규칙**. 주문서 양식이라고 생각하면 됨 | 주문서 양식 |
| **URL** | 주소. 예: `http://localhost:8080/servlet_study/hello` | 메뉴판의 메뉴 위치 |
| **톰캣 (Tomcat)** | 요청을 받아서 알맞은 서블릿을 실행해주는 프로그램. 우리가 설치함 | 매니저 |
| **서블릿 (Servlet)** | 요청을 처리하는 **자바 클래스**. 우리가 직접 작성하는 부분 | 요리사 |
| **HTML** | 브라우저가 화면을 그릴 때 읽는 문서. `<h1>제목</h1>`처럼 **태그**로 감쌈 | 음식 담는 모양 |
| **파라미터** | 요청에 같이 보내는 추가 정보. `?name=민재` 에서 이름 `name`, 값 `민재` | 주문서의 "맵기: 보통" 같은 메모 |
| **어노테이션** | `@Override` 같은 **`@` 표시**. 컴퓨터에게 주는 메모. 서블릿에선 `@WebServlet`을 씀 | 요리사 이름표 |

### 🔤 HTML 3분 속성 강의
HTML은 **`<태그>내용</태그>`** 모양으로 씁니다. 여는 태그와 닫는 태그(`/` 붙음) 사이에 내용을 넣어요.
```html
<h1>큰 제목</h1>          <!-- h1 = heading 1 = 가장 큰 제목 글씨 -->
<p>일반 문장</p>           <!-- p = paragraph = 문단 -->
첫 줄<br>둘째 줄           <!-- br = 줄바꿈. 닫는 태그 없이 혼자 씀 -->
<b>굵게</b>                <!-- b = bold = 굵은 글씨 -->
<a href="/hello">이동</a>  <!-- a = 링크. 클릭하면 href에 적힌 주소로 이동 -->
<!-- 이렇게 생긴 건 HTML 주석. 화면에 안 보임 (자바의 // 와 같음) -->
```
> 💡 서블릿은 이런 HTML **글자를 만들어서** 브라우저에 보내는 역할입니다. 브라우저는 받은 글자를 해석해서 예쁜 화면으로 보여줍니다.

---

## 📌 [Step 1] 첫 서블릿 & 생명주기

### 📖 개념 읽기

**① 서블릿에는 `main()`이 없다**
지금까지 자바 프로그램은 `main()`부터 실행했죠? 서블릿에는 `main()`이 없습니다. 대신 **톰캣이 알아서 객체를 만들고(`new`), 요청이 오면 메서드를 호출**해줍니다. 우리는 "요청이 오면 할 일"만 메서드 안에 적으면 됩니다.
> JS로 치면 `button.addEventListener("click", function() {...})`와 비슷합니다. 내가 직접 함수를 부르지 않고, "클릭되면 이걸 실행해줘"라고 등록만 하죠. 서블릿도 "**이 주소로 요청이 오면** `doGet`을 실행해줘"라고 등록하는 겁니다.

**② 상속 구조: 이미 배운 상속 그대로**
```
HttpServlet (톰캣이 제공하는 부모 클래스, 기본 기능이 다 들어 있음)
    ↑ extends (상속)
MyServlet   (내가 만드는 자식 클래스. 필요한 메서드만 @Override)
```

**③ GET 방식이란?**
주소창에 주소를 치고 엔터를 누르거나 링크를 클릭하면 **GET 방식** 요청이 갑니다. GET 요청이 오면 톰캣이 서블릿의 **`doGet()`** 메서드를 호출해요. (POST 방식은 Step 2에서 배웁니다.)

**④ 생명주기 = 서블릿 객체의 일생**

| 순서 | 메서드 | 언제 호출? | 몇 번? | 식당 비유 |
|---|---|---|---|---|
| 1 | `init()` | 첫 요청이 왔을 때 객체 만든 직후 | **딱 1번** | 요리사 출근해서 앞치마 입기 |
| 2 | `doGet()` / `doPost()` | 요청이 올 때마다 | **요청마다 계속** | 주문 들어올 때마다 요리 |
| 3 | `destroy()` | 톰캣이 꺼질 때 | **딱 1번** | 퇴근하며 정리 |

**⑤ 요리사는 딱 1명 (중요!)**
손님이 100명 와도 서블릿 **객체는 1개만** 만들어집니다. 1명의 요리사가 분신술(스레드)을 써서 동시에 여러 주문을 처리한다고 생각하세요.
그래서 **필드(클래스 맨 위 변수)에 손님 정보를 저장하면 손님끼리 섞입니다.** 손님 정보는 항상 **메서드 안의 지역 변수**에 두세요.

### 🛠️ 실습 1-1. 첫 서블릿
> 📍 위치: `src/main/java/com/example/servlet_study/` 폴더에서 **오른쪽 클릭 → New → Java Class → `HelloServlet2`** (그림 가이드 8단계 참고)

```java
package com.example.servlet_study;   // 이 파일이 들어있는 폴더(패키지) 이름. IntelliJ가 자동으로 써줌

// ===== 필요한 도구 가져오기 (import) =====
import jakarta.servlet.annotation.WebServlet;     // @WebServlet 표시를 쓰기 위해
import jakarta.servlet.http.HttpServlet;          // 부모 클래스 HttpServlet
import jakarta.servlet.http.HttpServletRequest;   // 요청(주문서) 객체의 타입
import jakarta.servlet.http.HttpServletResponse;  // 응답(접시) 객체의 타입
import java.io.IOException;                       // 글자를 내보내다 문제가 생기면 나는 예외
import java.io.PrintWriter;                       // 응답에 글자를 쓰는 펜

@WebServlet("/hello2")                    // "주소 끝이 /hello2인 요청은 이 클래스가 처리한다"는 이름표
public class HelloServlet2 extends HttpServlet {   // HttpServlet을 상속받아야 톰캣이 서블릿으로 인정함

    @Override                             // 부모(HttpServlet)의 doGet을 내 방식으로 다시 정의한다는 표시
    protected void doGet(HttpServletRequest req,    // req  = 톰캣이 만들어서 넘겨주는 주문서 (손님이 보낸 정보)
                         HttpServletResponse resp)  // resp = 톰캣이 넘겨주는 빈 접시 (여기에 결과를 담음)
            throws IOException {          // 글자를 쓰다 생기는 예외는 톰캣에게 떠넘김 (자바 예외 처리에서 배운 throws)

        resp.setContentType("text/html; charset=UTF-8");
        // ↑ 브라우저에게 "지금 보내는 건 HTML이고, 글자는 UTF-8(한글 가능) 방식이야"라고 알려줌
        //   이 줄이 없으면 한글이 '???'나 이상한 글자로 깨짐

        PrintWriter out = resp.getWriter();
        // ↑ 접시(resp)에서 펜(PrintWriter)을 꺼냄. out.println()으로 쓴 글자가 브라우저로 감
        //   System.out.println()은 IntelliJ 콘솔에 찍히고, out.println()은 브라우저 화면에 찍힘!

        out.println("<h1>Hello Servlet!</h1>");
        // ↑ <h1>...</h1> = 큰 제목. 브라우저에 큰 글씨로 "Hello Servlet!"이 보임

        out.println("<p>지금 시간: " + java.time.LocalDateTime.now() + "</p>");
        // ↑ <p>...</p> = 일반 문장. 현재 시간을 문자열로 이어 붙여서 출력
    }
}
```
**▶ 실행 순서**
1. IntelliJ 오른쪽 위 **■ (서버 끄기)** → **▶ (실행)**
2. 크롬 주소창 끝을 `/hello2`로 바꾸고 엔터
   예: `http://localhost:8080/servlet_study_war_exploded/hello2`
3. ✅ 확인: **새로고침(⌘+R)** 할 때마다 시간이 바뀌나요? 바뀌면 요청할 때마다 `doGet`이 실행된다는 뜻입니다.

### 🛠️ 실습 1-2. 생명주기 눈으로 확인하기
```java
package com.example.servlet_study;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/life")                         // 주소: .../life
public class LifeServlet extends HttpServlet {

    @Override
    public void init() {                     // 객체가 처음 만들어진 직후 톰캣이 1번만 호출
        System.out.println("[init] 요리사 출근!");    // IntelliJ 아래쪽 콘솔에 찍힘
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("[doGet] 주문 처리 중");  // 요청 올 때마다 콘솔에 찍힘
        resp.getWriter().println("check console");    // 브라우저에는 이 글자만 보임 (영어라 인코딩 설정 생략)
    }

    @Override
    public void destroy() {                  // 톰캣이 꺼질 때 1번만 호출
        System.out.println("[destroy] 요리사 퇴근!");
    }
}
```
**▶ 실행 순서 & 관찰**
1. ■ → ▶ 후 주소 끝을 `/life`로 접속
2. 새로고침 **5번**
3. IntelliJ 아래쪽 **Server / Output 콘솔** 확인 → `[init]`은 몇 번? `[doGet]`은 몇 번?
4. **■ 버튼**으로 서버 끄기 → 콘솔에 뭐가 찍히나요?

> 예상 결과: `[init]` 1번, `[doGet]` 5번, 끌 때 `[destroy]` 1번

### ❓ 개념 퀴즈
- [ ] **Q1.** 서블릿에는 `main()`이 없습니다. 그럼 누가 객체를 만들고 `doGet()`을 호출하나요?
- [ ] **Q2.** `System.out.println("안녕")`과 `out.println("안녕")`은 각각 어디에 출력되나요?
- [ ] **Q3.** 새로고침을 10번 하면 `init()`과 `doGet()`은 각각 몇 번 실행되나요?
- [ ] **Q4.** `resp.setContentType("text/html; charset=UTF-8");`을 빼먹으면 어떤 일이 생기나요?
- [ ] **Q5.** 브라우저 주소창 끝에 `/hello2`를 쳤는데 `HelloServlet2`가 실행되는 이유는 코드의 어느 줄 때문인가요?

<details>
<summary><b>💡 정답 보기</b></summary>

- **A1.** 톰캣이 합니다. 톰캣이 `new HelloServlet2()`로 객체를 만들고, 요청이 오면 `doGet()`을 호출해요.
- **A2.** `System.out.println`은 **IntelliJ 콘솔**(개발자만 보는 곳)에, `out.println`은 **브라우저 화면**(손님이 보는 곳)에 출력됩니다.
- **A3.** `init()` 1번, `doGet()` 10번
- **A4.** 한글이 깨져서 보이거나, HTML 태그가 적용되지 않고 `<h1>` 글자가 그대로 보일 수 있어요.
- **A5.** `@WebServlet("/hello2")` 줄 때문입니다. 이 이름표를 보고 톰캣이 "/hello2 담당은 HelloServlet2구나" 하고 연결해줘요.
</details>

### 💻 코딩 문제
- [ ] **문제 1-1. 자기소개 서블릿**
  - **요구사항**: `/me` 주소로 접속하면 큰 제목으로 내 이름, 그 아래 문단으로 "Java와 JavaScript를 배웠습니다"를 출력하세요.
  - **힌트**: 실습 1-1을 복사해서 클래스 이름, `@WebServlet` 주소, `out.println` 내용만 바꾸면 됩니다.
  <details>
  <summary><b>💡 모범 답안 보기</b></summary>

  ```java
  @WebServlet("/me")                                  // 주소 .../me 담당
  public class MeServlet extends HttpServlet {        // 서블릿이 되기 위해 상속
      @Override
      protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
          resp.setContentType("text/html; charset=UTF-8");   // 한글 깨짐 방지
          PrintWriter out = resp.getWriter();                // 브라우저에 쓸 펜
          out.println("<h1>강민재</h1>");                     // 큰 제목
          out.println("<p>Java와 JavaScript를 배웠습니다</p>"); // 문단
      }
  }
  ```
  </details>

- [ ] **문제 1-2. 구구단 서블릿**
  - **요구사항**: `/gugu`로 접속하면 2단~9단을 출력하세요. 각 단 제목은 `<h3>2단</h3>`, 각 줄 끝에는 줄바꿈 `<br>`을 붙입니다.
  - **힌트**: 자바에서 배운 **이중 for문**을 그대로 쓰고, `System.out.println` 대신 `out.println`을 쓰면 됩니다.
  <details>
  <summary><b>💡 모범 답안 보기</b></summary>

  ```java
  @WebServlet("/gugu")
  public class GuguServlet extends HttpServlet {
      @Override
      protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
          resp.setContentType("text/html; charset=UTF-8");
          PrintWriter out = resp.getWriter();

          for (int dan = 2; dan <= 9; dan++) {                // 바깥 for: 2단부터 9단까지
              out.println("<h3>" + dan + "단</h3>");           // 단 제목 (h3 = 중간 크기 제목)
              for (int i = 1; i <= 9; i++) {                  // 안쪽 for: 1부터 9까지 곱하기
                  out.println(dan + " x " + i + " = " + (dan * i) + "<br>");  // <br>로 줄바꿈
              }
          }
      }
  }
  ```
  * **해설**: HTML에서는 그냥 엔터를 쳐도 줄이 안 바뀝니다. 그래서 `<br>`을 붙여야 화면에서 줄이 바뀌어요.
  </details>

- [ ] **문제 1-3. 이 코드는 왜 위험할까? (생각 문제)**
  ```java
  @WebServlet("/bad")
  public class BadServlet extends HttpServlet {
      private String userName;            // ← 필드(클래스 변수)

      @Override
      protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
          userName = req.getParameter("name");   // 손님이 보낸 이름을 필드에 저장 (getParameter는 Step 2에서 배움)
          resp.getWriter().println("Hello " + userName);
      }
  }
  ```
  <details>
  <summary><b>💡 정답 보기</b></summary>

  서블릿 객체는 1개뿐이라 `userName` 필드도 **모든 손님이 같이 쓰는 칠판 1개**입니다. 철수가 이름을 적은 직후에 영희가 자기 이름으로 덮어쓰면, 철수 화면에 "Hello 영희"가 나올 수 있어요.
  **해결**: `doGet` 안에서 `String userName = req.getParameter("name");`처럼 **지역 변수**로 선언합니다. 지역 변수는 요청마다 따로 만들어져서 섞이지 않아요.
  </details>

---

## 📌 [Step 2] 손님이 보낸 정보 받기 (파라미터, GET / POST)

### 📖 개념 읽기

**① 파라미터 = 주문서에 적힌 메모**
주소 `.../greet?name=민재&age=20`에서
- `?` 뒤부터 파라미터가 시작됩니다.
- `name=민재` → **이름**은 `name`, **값**은 `민재`
- `&` → 파라미터가 여러 개일 때 연결하는 기호

서블릿에서는 이렇게 꺼냅니다.
```java
String name = req.getParameter("name");  // "민재"
String age  = req.getParameter("age");   // "20" ← 숫자처럼 보여도 항상 String(문자열)!
```

**② 매번 주소창에 `?name=...`을 칠 수는 없으니 → 입력 칸(form)을 만든다**
HTML의 **`<form>`** 태그는 "입력 칸 묶음 + 전송 버튼"입니다. 버튼을 누르면 브라우저가 입력값을 파라미터로 만들어서 서버에 보내요.
```html
<form action="greet" method="get">   <!-- action: 어느 주소로 보낼지 / method: 어떤 방식(get, post)으로 보낼지 -->
    <input type="text" name="name">   <!-- 글자 입력 칸. name="name" → 파라미터 이름이 name이 됨 -->
    <button>보내기</button>           <!-- 누르면 form 전송 -->
</form>
```
> ⭐ **연결 고리**: HTML `<input name="name">`의 **name 값**과 서블릿 `req.getParameter("name")`의 **글자**가 **똑같아야** 값을 꺼낼 수 있어요.

**③ GET vs POST**

| | GET | POST |
|---|---|---|
| 데이터 위치 | 주소창 뒤에 `?name=민재`로 **보임** | 주소창에 **안 보임** (편지 봉투 안에 넣어 보내는 느낌) |
| 언제 쓰나 | 검색, 조회 | 로그인, 회원가입, 글쓰기 |
| 서블릿 메서드 | `doGet()` | `doPost()` |
| 비유 | 엽서 (누구나 내용을 봄) | 봉투에 넣은 편지 |

**④ POST 한글 깨짐**
POST로 온 한글은 그냥 꺼내면 깨집니다. **꺼내기 전에** `req.setCharacterEncoding("UTF-8");`를 한 줄 써줘야 해요.

### 🛠️ 실습 2-1. GET으로 이름 받기
> 📍 HTML 파일 위치: `src/main/webapp` 폴더에서 **오른쪽 클릭 → New → HTML File → `greet`**

**`src/main/webapp/greet.html`**
```html
<!DOCTYPE html>                <!-- "이 문서는 HTML이에요" 선언. 항상 맨 위에 씀 -->
<html>                         <!-- HTML 문서 시작 -->
<head>                         <!-- head: 화면에 안 보이는 설정 부분 -->
    <meta charset="UTF-8">     <!-- 한글 깨짐 방지 -->
    <title>인사하기</title>     <!-- 브라우저 탭에 보이는 제목 -->
</head>
<body>                         <!-- body: 실제 화면에 보이는 부분 -->
    <form action="greet" method="get">               <!-- 버튼 누르면 greet 주소로 GET 방식 전송 -->
        이름: <input type="text" name="name">        <!-- 파라미터 이름 = name -->
        나이: <input type="number" name="age">       <!-- type="number" = 숫자만 입력 / 파라미터 이름 = age -->
        <button>보내기</button>                       <!-- 전송 버튼 -->
    </form>
</body>
</html>
```

**`GreetServlet.java`**
```java
package com.example.servlet_study;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/greet")      // form의 action="greet"과 연결되는 주소
public class GreetServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String name = req.getParameter("name");
        // ↑ input의 name="name" 칸에 적힌 값을 꺼냄. 예: "민재"

        String ageText = req.getParameter("age");
        // ↑ name="age" 칸의 값. 숫자를 입력해도 "20"처럼 문자열로 옴

        int age = Integer.parseInt(ageText);
        // ↑ 문자열 "20"을 숫자 20으로 바꿈 (자바에서 배운 Integer.parseInt)
        //   ⚠️ 나이 칸을 비워두면 "" → parseInt에서 에러(500) 발생. 문제 2-3에서 해결해봐요

        resp.setContentType("text/html; charset=UTF-8");   // 응답 한글 깨짐 방지
        PrintWriter out = resp.getWriter();                // 브라우저에 쓸 펜
        out.println("<h2>" + name + "님, 내년엔 " + (age + 1) + "살이네요!</h2>");  // h2 = 조금 작은 제목
    }
}
```
**▶ 실행 순서**
1. ■ → ▶
2. 주소 끝을 `/greet.html`로 접속 (**.html까지** 써야 해요. HTML 파일을 직접 여는 거라서)
3. 이름과 나이를 입력하고 보내기 클릭
4. ✅ 확인: **주소창**을 보세요. 끝이 `/greet?name=민재&age=20`처럼 바뀌었나요? 이게 GET 방식입니다.

### 🛠️ 실습 2-2. POST로 바꿔보기 (일부러 에러 내보기)
1. `greet.html`에서 `method="get"`을 **`method="post"`**로 바꾸고 저장합니다.
2. 다시 전송하면 → **HTTP Status 405** 화면이 나옵니다.
   - 이유: POST로 보냈는데 서블릿에 `doPost()`가 없어서 "그 방식으론 주문 못 받아요"라는 뜻이에요.
3. `GreetServlet`에 아래 메서드를 **추가**합니다 (`doGet` 아래에).
```java
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("UTF-8");
        // ↑ POST로 온 한글을 제대로 읽도록 설정. ⚠️ 반드시 getParameter보다 먼저!

        doGet(req, resp);
        // ↑ 처리 내용은 doGet과 똑같으니 doGet을 그대로 호출해서 재사용 (그냥 자바 메서드 호출)
    }
```
4. ■ → ▶ 후 다시 전송 → ✅ 주소창에서 `?name=...`이 **사라졌는지** 확인하세요.
5. 🔬 실험: `setCharacterEncoding` 줄을 지우고 한글 이름을 보내보세요. 깨지는 걸 직접 보면 오래 기억에 남아요.

### 🛠️ 실습 2-3. 여러 가지 입력 칸
```html
<form action="join" method="post">
    <!-- 라디오 버튼: 여러 개 중 하나만 선택. name이 같은 것끼리 한 묶음 -->
    <input type="radio" name="gender" value="M"> 남      <!-- 선택하면 gender=M 이 전송됨 -->
    <input type="radio" name="gender" value="F"> 여      <!-- 화면 글자(여)가 아니라 value(F)가 전송됨! -->

    <!-- 체크박스: 여러 개 선택 가능 -->
    <input type="checkbox" name="hobby" value="game"> 게임
    <input type="checkbox" name="hobby" value="music"> 음악
    <input type="checkbox" name="hobby" value="sport"> 운동

    <!-- 드롭다운(펼침 목록) -->
    <select name="city">
        <option value="seoul">서울</option>              <!-- 선택하면 city=seoul 전송 -->
        <option value="busan">부산</option>
    </select>

    <button>가입</button>
</form>
```
체크박스처럼 **같은 이름으로 값이 여러 개** 오면 `getParameterValues`(복수형 s)를 씁니다.
```java
String gender = req.getParameter("gender");          // 하나만 오니까 getParameter → "M"
String[] hobbies = req.getParameterValues("hobby");  // 여러 개 → 배열 {"game", "music"}
// ⚠️ 아무것도 체크 안 하면 hobbies는 null! 반드시 null 확인 후 사용
```

### ❓ 개념 퀴즈
- [ ] **Q1.** HTML에 `<input type="text" name="userId">`가 있습니다. 서블릿에서 이 값을 꺼내는 코드를 쓰세요.
- [ ] **Q2.** `req.getParameter("age")`로 꺼낸 값의 타입은? 숫자로 계산하려면?
- [ ] **Q3.** form의 `method="post"`인데 서블릿에 `doGet`만 있으면 어떤 에러 숫자가 보이나요?
- [ ] **Q4.** 로그인 form은 GET과 POST 중 무엇이 맞나요? 이유는?
- [ ] **Q5.** `<input type="radio" name="gender" value="F"> 여`를 선택하면 서버에 오는 값은 "여"인가요, "F"인가요?
- [ ] **Q6.** 아무것도 입력하지 않은 칸의 `getParameter()` 결과는 `""`(빈 문자열)입니다. 그럼 HTML에 **아예 없는 이름**을 `getParameter("xyz")`로 꺼내면?

<details>
<summary><b>💡 정답 보기</b></summary>

- **A1.** `String userId = req.getParameter("userId");`
- **A2.** `String`입니다. `Integer.parseInt(req.getParameter("age"))`로 숫자로 바꿔야 계산할 수 있어요.
- **A3.** 405 (Method Not Allowed: 그 방식은 허용 안 됨)
- **A4.** POST가 맞습니다. GET이면 비밀번호가 주소창에 `?pw=1234`처럼 그대로 보이고 방문 기록에도 남아요.
- **A5.** `"F"`입니다. 화면 글자가 아니라 `value`가 전송돼요.
- **A6.** `null`입니다. 그래서 `if (name == null || name.isBlank())`처럼 둘 다 검사하는 습관을 들이세요. (`isBlank()` = 비어 있거나 공백뿐이면 true)
</details>

### 💻 코딩 문제
- [ ] **문제 2-1. 계산기**
  - **요구사항**: `calc.html`에 숫자 칸 2개(`num1`, `num2`)와 연산자 드롭다운(`op`: + - * /)을 만들고, 결과를 `/calc` 서블릿(POST)에서 출력하세요.
  - **힌트**: HTML은 실습 2-3의 `<select>`를 참고하세요. 연산자 비교는 `op.equals("+")`처럼 합니다.
  <details>
  <summary><b>💡 모범 답안 보기</b></summary>

  **calc.html**
  ```html
  <!DOCTYPE html>
  <html>
  <head><meta charset="UTF-8"><title>계산기</title></head>
  <body>
      <form action="calc" method="post">            <!-- /calc로 POST 전송 -->
          <input type="number" name="num1">         <!-- 첫 번째 숫자 -->
          <select name="op">                        <!-- 연산자 선택 -->
              <option value="+">+</option>
              <option value="-">-</option>
              <option value="*">*</option>
              <option value="/">/</option>
          </select>
          <input type="number" name="num2">         <!-- 두 번째 숫자 -->
          <button>=</button>                        <!-- 전송 버튼 -->
      </form>
  </body>
  </html>
  ```
  **CalcServlet.java**
  ```java
  @WebServlet("/calc")
  public class CalcServlet extends HttpServlet {
      @Override
      protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
          req.setCharacterEncoding("UTF-8");                 // POST 한글 처리 (습관처럼 맨 위에)
          resp.setContentType("text/html; charset=UTF-8");   // 응답 한글 처리
          PrintWriter out = resp.getWriter();

          int a = Integer.parseInt(req.getParameter("num1")); // 첫 숫자 꺼내서 int로 변환
          int b = Integer.parseInt(req.getParameter("num2")); // 두 번째 숫자
          String op = req.getParameter("op");                 // 연산자 "+", "-", "*", "/"

          if (op.equals("/") && b == 0) {                     // 0으로 나누기 방지
              out.println("<h2>0으로 나눌 수 없습니다</h2>");
              return;                                         // 메서드 종료 (아래 코드 실행 안 함)
          }

          double result = 0;                                  // 결과 담을 변수
          if (op.equals("+")) result = a + b;
          else if (op.equals("-")) result = a - b;
          else if (op.equals("*")) result = a * b;
          else if (op.equals("/")) result = (double) a / b;   // 소수점까지 나오게 double로 형변환

          out.println("<h2>" + a + " " + op + " " + b + " = " + result + "</h2>");
      }
  }
  ```
  </details>

- [ ] **문제 2-2. 회원가입 정보 확인**
  - **요구사항**: 아이디(`id`), 비밀번호(`pw`, `type="password"`), 성별(radio), 취미(checkbox), 지역(select)을 POST로 보내고, 서블릿에서 아래처럼 출력하세요.
    - 아이디가 비어 있으면 "아이디를 입력하세요"만 출력하고 끝냅니다.
    - 비밀번호는 글자 수만큼 `*`로 출력합니다. (`"*".repeat(개수)`)
    - 취미를 하나도 고르지 않았으면 "없음"을 출력합니다.
  <details>
  <summary><b>💡 모범 답안 보기</b></summary>

  ```java
  @WebServlet("/join")
  public class JoinServlet extends HttpServlet {
      @Override
      protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
          req.setCharacterEncoding("UTF-8");
          resp.setContentType("text/html; charset=UTF-8");
          PrintWriter out = resp.getWriter();

          String id = req.getParameter("id");                // 아이디
          if (id == null || id.isBlank()) {                  // 값이 없거나 공백뿐이면
              out.println("<p>아이디를 입력하세요</p>");
              return;                                        // 여기서 끝
          }

          String pw = req.getParameter("pw");                // 비밀번호
          String gender = req.getParameter("gender");        // 라디오: 하나만 옴
          String[] hobbies = req.getParameterValues("hobby");// 체크박스: 여러 개 → 배열
          String city = req.getParameter("city");            // 드롭다운

          out.println("<p>아이디: " + id + "</p>");
          out.println("<p>비밀번호: " + "*".repeat(pw.length()) + "</p>");  // 글자 수만큼 *
          out.println("<p>성별: " + gender + "</p>");

          if (hobbies == null) {                             // 아무것도 체크 안 했으면 null
              out.println("<p>취미: 없음</p>");
          } else {
              out.println("<p>취미: " + String.join(", ", hobbies) + "</p>");  // 배열을 "a, b" 형태로 합침
          }
          out.println("<p>지역: " + city + "</p>");
      }
  }
  ```
  </details>

- [ ] **문제 2-3. 실습 2-1 고치기**
  - **요구사항**: 실습 2-1의 `GreetServlet`에서 나이 칸을 비우거나 이름 칸을 비우면 500 에러 대신 "이름과 나이를 모두 입력하세요"가 나오게 고치세요.
  <details>
  <summary><b>💡 모범 답안 보기</b></summary>

  ```java
  String name = req.getParameter("name");
  String ageText = req.getParameter("age");

  resp.setContentType("text/html; charset=UTF-8");
  PrintWriter out = resp.getWriter();

  // 둘 중 하나라도 비어 있으면 안내 문구 출력 후 종료
  if (name == null || name.isBlank() || ageText == null || ageText.isBlank()) {
      out.println("<p>이름과 나이를 모두 입력하세요</p>");
      return;
  }
  int age = Integer.parseInt(ageText);   // 여기까지 왔으면 값이 있으니 안전하게 변환
  out.println("<h2>" + name + "님, 내년엔 " + (age + 1) + "살이네요!</h2>");
  ```
  </details>

---

## 📌 [Step 3] 다른 페이지로 넘기기: forward vs redirect

### 📖 개념 읽기
서블릿 하나가 모든 걸 하지 않고 **다른 서블릿에게 일을 넘길 때**가 있어요. 방법은 2가지입니다.

**① forward (포워드) = 주방 안에서 넘기기**
> 손님은 A 요리사에게 주문했는데, A가 **주방 안에서 몰래** B 요리사에게 주문서를 넘김 → B가 만든 음식이 손님에게 나감
> 손님은 B가 만든 줄 모름 → **주소창이 안 바뀜**, 주문서(request)를 그대로 넘기니 **메모도 유지**

**② redirect (리다이렉트) = 손님에게 다른 창구로 가라고 하기**
> A가 손님에게 "**B 창구로 다시 주문하세요**"라고 말함 → 손님이 B에게 **새 주문서**를 냄
> **주소창이 B로 바뀜**, 주문서가 새로 만들어지니 A에서 적은 **메모는 사라짐**

| | forward | redirect |
|---|---|---|
| 비유 | 주방 안에서 몰래 넘김 | 손님을 다른 창구로 보냄 |
| 브라우저 요청 횟수 | 1번 | 2번 |
| 주소창 | 안 바뀜 | 바뀜 |
| `setAttribute`로 넣은 값 | 유지됨 | 사라짐 |
| 코드 | `req.getRequestDispatcher("/b").forward(req, resp);` | `resp.sendRedirect("b");` |

**③ `setAttribute` / `getAttribute` = 주문서에 붙이는 포스트잇**
- `getParameter`: **손님이** 적어 보낸 값 (읽기만 가능, 항상 String)
- `setAttribute("이름", 값)`: **서블릿(요리사)이** 주문서에 붙이는 포스트잇. 다음 요리사가 `getAttribute("이름")`으로 읽음. 아무 객체나 붙일 수 있음(Object 타입)

### 🛠️ 실습 3-1. 두 방식 직접 비교하기
```java
// ===== StartServlet.java =====
@WebServlet("/start")
public class StartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // ↑ forward는 ServletException도 던질 수 있어서 throws에 추가
        //   import jakarta.servlet.ServletException; 도 추가해야 함

        req.setAttribute("msg", "start가 붙인 포스트잇");
        // ↑ 주문서(req)에 "msg"라는 이름으로 문자열을 붙임

        String type = req.getParameter("type");
        // ↑ 주소의 ?type=forward 또는 ?type=redirect 값을 꺼냄

        if ("forward".equals(type)) {
            // "forward".equals(type) 순서로 쓰면 type이 null이어도 에러가 안 남
            req.getRequestDispatcher("/end").forward(req, resp);
            // ↑ getRequestDispatcher("/end") = "/end 담당 요리사 불러줘"
            //   .forward(req, resp)          = 내 주문서와 접시를 그대로 넘김
        } else {
            resp.sendRedirect("end");
            // ↑ 브라우저에게 "end 주소로 다시 요청하세요"라고 응답 (주소창이 바뀜)
        }
    }
}

// ===== EndServlet.java =====
@WebServlet("/end")
public class EndServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html; charset=UTF-8");
        Object msg = req.getAttribute("msg");
        // ↑ 포스트잇 "msg" 읽기. 없으면 null
        resp.getWriter().println("<h2>end 도착! 포스트잇 내용: " + msg + "</h2>");
    }
}
```
**▶ 실행 & 관찰표** (직접 채워보세요)

| 접속 주소 끝 | 최종 주소창 끝 | 포스트잇 내용 |
|---|---|---|
| `/start?type=forward` | | |
| `/start?type=redirect` | | |

### ❓ 개념 퀴즈
- [ ] **Q1.** 위 관찰표의 정답은?
- [ ] **Q2.** `getParameter`와 `getAttribute`의 차이를 "누가 넣은 값인지"로 설명하세요.
- [ ] **Q3.** 로그인에 실패해서 로그인 화면(`login.html`)으로 돌려보내려 합니다. forward와 redirect 중 무엇이 자연스러울까요?

<details>
<summary><b>💡 정답 보기</b></summary>

- **A1.** forward: 주소창은 `/start?type=forward` 그대로이고, 포스트잇 내용이 보입니다. redirect: 주소창이 `/end`로 바뀌고, 포스트잇 내용은 `null`입니다.
- **A2.** `getParameter`는 **손님(브라우저)**이 보낸 값이고, `getAttribute`는 **서버의 서블릿**이 `setAttribute`로 붙여둔 값입니다.
- **A3.** redirect입니다. 손님을 "로그인 화면 창구"로 다시 보내는 것이라 주소창도 `login.html`로 바뀌는 게 자연스러워요.
</details>

### 💻 코딩 문제
- [ ] **문제 3-1. 합격/불합격 안내**
  - **요구사항**: `/score?point=85`처럼 점수를 받아서
    - 60점 이상이면 `/pass`로 **forward**해서 "합격! (85점)"
    - 60점 미만이면 `/fail`로 **forward**해서 "불합격 (40점)"
    - 점수를 `setAttribute("point", 점수)`로 붙여서 넘기세요.
  <details>
  <summary><b>💡 모범 답안 보기</b></summary>

  ```java
  @WebServlet("/score")
  public class ScoreServlet extends HttpServlet {
      @Override
      protected void doGet(HttpServletRequest req, HttpServletResponse resp)
              throws ServletException, IOException {
          int point = Integer.parseInt(req.getParameter("point"));  // "85" → 85
          req.setAttribute("point", point);                        // 포스트잇에 점수 붙이기

          if (point >= 60) {
              req.getRequestDispatcher("/pass").forward(req, resp); // 합격 담당에게 넘김
          } else {
              req.getRequestDispatcher("/fail").forward(req, resp); // 불합격 담당에게 넘김
          }
      }
  }

  @WebServlet("/pass")
  public class PassServlet extends HttpServlet {
      @Override
      protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
          resp.setContentType("text/html; charset=UTF-8");
          Object point = req.getAttribute("point");               // 포스트잇 읽기
          resp.getWriter().println("<h2>합격! (" + point + "점)</h2>");
      }
  }
  // FailServlet은 PassServlet을 복사해서 주소를 "/fail", 문구를 "불합격"으로 바꾸면 됨
  ```
  </details>

---

## 📌 [Step 4] 손님 기억하기: 세션(Session)과 로그인

### 📖 개념 읽기

**① 문제: 서버는 손님을 기억하지 못한다**
HTTP는 요청 하나가 끝나면 그 손님을 잊어버립니다. 그러면 로그인하고 다음 페이지로 가면 "누구세요?"가 되겠죠.

**② 해결: 세션 = 손님별 사물함**
> 처음 온 손님에게 서버가 **사물함(세션)**을 하나 만들어주고, **사물함 열쇠 번호표(`JSESSIONID` 쿠키)**를 손님(브라우저)에게 줍니다.
> 손님은 다음부터 요청할 때마다 번호표를 자동으로 같이 냅니다. 서버는 번호표로 그 손님의 사물함을 찾아요.
> - **사물함(세션)은 서버에** 있고, 손님은 **번호표만** 가지고 있습니다.
> - 크롬과 사파리는 서로 다른 손님 취급입니다 (번호표가 다르니까).

**③ 데이터 보관 장소 3가지 (scope = 보관 범위)**

| 보관 장소 | 비유 | 얼마나 유지? | 누가 같이 봄? |
|---|---|---|---|
| **request** | 주문서 포스트잇 | 요청 1번 끝나면 버려짐 | 그 요청 하나 |
| **session** | 손님별 사물함 | 로그아웃하거나 30분 동안 안 오면 비워짐 | 그 손님(브라우저)만 |
| **application** | 식당 입구 공용 게시판 | 서버가 꺼질 때까지 | 모든 손님 |

**④ 세션 사용법 (이 4줄이면 끝)**
```java
HttpSession session = req.getSession();             // 이 손님의 사물함 가져오기 (없으면 새로 만들어줌)
session.setAttribute("loginId", "minjae");           // 사물함에 넣기
String id = (String) session.getAttribute("loginId"); // 사물함에서 꺼내기 (Object로 나와서 (String) 형변환 필요)
session.invalidate();                                // 사물함 통째로 비우고 없애기 = 로그아웃
```

### 🛠️ 실습 4-1. 세 가지 보관 장소 비교 실험
```java
@WebServlet("/scope")
public class ScopeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        // ===== 1. request (포스트잇): 요청마다 새로 만들어지므로 항상 처음 =====
        Integer r = (Integer) req.getAttribute("cnt");   // 꺼내기 (처음엔 null)
        if (r == null) r = 0;                             // 없으면 0부터
        r = r + 1;                                        // 1 증가
        req.setAttribute("cnt", r);                       // 다시 넣기

        // ===== 2. session (손님별 사물함): 같은 브라우저면 계속 누적 =====
        HttpSession session = req.getSession();           // 이 손님의 사물함
        Integer s = (Integer) session.getAttribute("cnt");
        if (s == null) s = 0;
        s = s + 1;
        session.setAttribute("cnt", s);

        // ===== 3. application (공용 게시판): 모든 손님이 같이 누적 =====
        ServletContext app = getServletContext();         // 공용 게시판 가져오기 (import jakarta.servlet.ServletContext;)
        Integer a = (Integer) app.getAttribute("cnt");
        if (a == null) a = 0;
        a = a + 1;
        app.setAttribute("cnt", a);

        // ===== 결과 출력 =====
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.println("<p>request(포스트잇): " + r + "</p>");
        out.println("<p>session(내 사물함): " + s + "</p>");
        out.println("<p>application(공용 게시판): " + a + "</p>");
    }
}
```
**▶ 실험 순서**
1. 크롬에서 `/scope` 접속 후 **5번 새로고침**합니다. 숫자를 기록하세요.
2. 크롬 메뉴 → **새 시크릿 창** (⌘+Shift+N) → 같은 주소로 **3번 새로고침**합니다. 숫자를 기록하세요.
   (시크릿 창 = 번호표가 없는 새 손님)
3. 왜 그런 숫자가 나왔는지 위 표를 보며 설명해보세요.

### 🛠️ 실습 4-2. 로그인 / 마이페이지 / 로그아웃
**`src/main/webapp/login.html`**
```html
<!DOCTYPE html>
<html>
<head><meta charset="UTF-8"><title>로그인</title></head>
<body>
    <h2>로그인</h2>
    <form action="login" method="post">                      <!-- 비밀번호가 있으니 POST -->
        아이디: <input type="text" name="id"><br>            <!-- 파라미터 이름 id -->
        비밀번호: <input type="password" name="pw"><br>      <!-- type="password" = 입력하면 ●●● 로 보임 -->
        <button>로그인</button>
    </form>
</body>
</html>
```

**`LoginServlet.java`**: 로그인 처리
```java
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("UTF-8");        // POST 한글 처리
        String id = req.getParameter("id");       // 입력한 아이디
        String pw = req.getParameter("pw");       // 입력한 비밀번호

        // 연습용으로 아이디 admin / 비번 1234만 통과 (나중엔 DB에서 확인하게 됨)
        if ("admin".equals(id) && "1234".equals(pw)) {
            HttpSession session = req.getSession();   // 이 손님의 사물함 가져오기
            session.setAttribute("loginId", id);      // 사물함에 "loginId = admin" 넣기 → 이게 '로그인 상태'
            resp.sendRedirect("mypage");              // 마이페이지로 이동하라고 안내
        } else {
            resp.sendRedirect("login.html");          // 틀리면 로그인 화면으로 돌려보냄
        }
    }
}
```

**`MyPageServlet.java`**: 로그인한 사람만 볼 수 있는 페이지
```java
@WebServlet("/mypage")
public class MyPageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession session = req.getSession();                   // 사물함 가져오기
        String loginId = (String) session.getAttribute("loginId"); // 사물함에서 loginId 꺼내기

        if (loginId == null) {                // 사물함에 loginId가 없다 = 로그인 안 한 손님
            resp.sendRedirect("login.html");  // 로그인 화면으로 보냄
            return;                           // ⚠️ 여기서 메서드 끝! (return이 없으면 아래 코드도 실행됨)
        }

        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.println("<h2>" + loginId + "님의 마이페이지</h2>");
        out.println("<a href='logout'>로그아웃</a>");
        // ↑ <a href='logout'> = 클릭하면 logout 주소로 이동하는 링크
        //   자바 문자열 안이라 큰따옴표 대신 작은따옴표(')를 사용
    }
}
```

**`LogoutServlet.java`**: 로그아웃
```java
@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.getSession().invalidate();       // 사물함 통째로 없애기 → loginId도 사라짐 = 로그아웃
        resp.sendRedirect("login.html");     // 로그인 화면으로 이동
    }
}
```
**▶ 테스트 순서**
1. `/login.html` 접속 → `admin` / `1234` 입력 → 마이페이지가 보이면 성공
2. **로그아웃** 클릭 → 로그인 화면으로 돌아가나요?
3. 로그아웃한 상태에서 주소창에 `/mypage`를 **직접** 입력 → 로그인 화면으로 쫓겨나면 성공
4. 틀린 비밀번호로 로그인 → 다시 로그인 화면이 나오나요?

### ❓ 개념 퀴즈
- [ ] **Q1.** 실습 4-1에서 크롬 5번, 시크릿 창 3번 후 **시크릿 창**에 보이는 세 숫자는?
- [ ] **Q2.** 세션 데이터는 브라우저와 서버 중 어디에 저장되나요? 브라우저는 무엇을 가지고 있나요?
- [ ] **Q3.** 로그인 정보를 세션 대신 **application(공용 게시판)**에 저장하면 어떤 일이 생길까요?
- [ ] **Q4.** `MyPageServlet`에서 `return;`을 지우면 로그인 안 한 사람에게 어떤 문제가 생길 수 있나요?

<details>
<summary><b>💡 정답 보기</b></summary>

- **A1.** request: 1, session: 3, application: 8
  - request는 매 요청마다 새 포스트잇이라 항상 1입니다.
  - session은 시크릿 창이라는 새 손님의 사물함이라 3입니다.
  - application은 모두가 쓰는 게시판이라 5+3=8입니다.
- **A2.** 서버에 저장됩니다. 브라우저는 사물함 번호표인 `JSESSIONID` 쿠키만 가지고 있어요.
- **A3.** 모든 손님이 같은 게시판을 보니까, 한 명이 로그인하면 **모든 사람이 그 사람으로 로그인된 상태**가 됩니다. 큰 보안 사고예요.
- **A4.** `sendRedirect`를 호출해도 메서드가 바로 끝나지 않고 아래 코드가 계속 실행됩니다. 그러면 마이페이지 내용을 쓰려다 에러가 나거나 내용이 노출될 수 있어요. 그래서 이동 후에는 꼭 `return;`을 씁니다.
</details>

### 💻 코딩 문제
- [ ] **문제 4-1. 장바구니**
  - **요구사항**: `/cart?item=사과`로 접속할 때마다 세션에 있는 리스트에 상품을 추가하고, 지금까지 담은 목록과 개수를 출력하세요. 크롬과 시크릿 창의 장바구니가 따로인지 확인하세요.
  - **힌트**: 세션에 `ArrayList<String>`을 넣어두고 꺼내서 `add` 합니다. 처음엔 `null`이니 새로 만들어서 넣어야 해요.
  <details>
  <summary><b>💡 모범 답안 보기</b></summary>

  ```java
  @WebServlet("/cart")
  public class CartServlet extends HttpServlet {
      @Override
      protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
          req.setCharacterEncoding("UTF-8");
          HttpSession session = req.getSession();                       // 내 사물함

          ArrayList<String> cart = (ArrayList<String>) session.getAttribute("cart");  // 장바구니 꺼내기
          if (cart == null) {                       // 처음 온 손님이라 장바구니가 없으면
              cart = new ArrayList<>();             // 새 장바구니 만들고
              session.setAttribute("cart", cart);   // 사물함에 넣어둠
          }

          String item = req.getParameter("item");   // 주소의 ?item=사과
          if (item != null && !item.isBlank()) {    // 값이 있을 때만
              cart.add(item);                       // 장바구니에 추가
          }

          resp.setContentType("text/html; charset=UTF-8");
          PrintWriter out = resp.getWriter();
          out.println("<h2>장바구니 (" + cart.size() + "개)</h2>");
          for (String c : cart) {                   // 향상된 for문으로 하나씩 출력
              out.println("- " + c + "<br>");
          }
      }
  }
  ```
  * **해설**: 사물함에는 리스트 **객체의 주소(참조)**가 들어 있습니다. 그래서 꺼낸 리스트에 `add`만 해도 사물함 속 리스트가 바뀌어요. 자바에서 배운 "참조 타입" 개념과 같습니다.
  </details>

---

## 📌 [Step 5] 종합 미니 프로젝트: 방명록

### 🎯 만들 것
로그인한 사람만 글을 남길 수 있는 방명록을 만듭니다. 글은 서버 메모리의 리스트에 저장하고(서버를 끄면 사라짐), 본인 글만 삭제할 수 있게 합니다.

| 기능 | 주소 | 방식 | 할 일 | 참고 Step |
|---|---|---|---|---|
| 로그인 화면 | `/gb-login.html` | GET | 이름만 입력하는 form | 4 |
| 로그인 처리 | `/gb-login` | POST | 세션에 이름 저장 → `guestbook`으로 redirect | 4 |
| 글 목록 + 쓰기 칸 | `/guestbook` | GET | 로그인 확인, 글 목록 출력, 글쓰기 form 출력 | 1, 4 |
| 글 저장 | `/guestbook-write` | POST | 세션 이름 + 내용 저장 → `guestbook`으로 redirect | 2, 3 |
| 글 삭제 | `/guestbook-delete?id=3` | GET | 본인 글이면 삭제 → `guestbook`으로 redirect | 2, 4 |

### ✅ 진행 체크리스트
- [ ] 1. 글 정보를 담는 `Entry` 클래스 (필드: `int id`, `String writer`, `String content`)
- [ ] 2. 모든 서블릿이 같이 쓰는 저장소: `GuestbookStore` 클래스에 `static ArrayList<Entry>`와 번호 증가용 `static int`
- [ ] 3. 로그인 (실습 4-2 복사해서 수정)
- [ ] 4. 목록 출력 (`for`문 + `out.println`)
- [ ] 5. 글 저장 (POST + `setCharacterEncoding` + redirect)
- [ ] 6. 삭제 (본인 글에만 삭제 링크 표시)

<details>
<summary><b>💡 막혔을 때 보는 핵심 코드 (주석 포함)</b></summary>

```java
// ===== Entry.java : 글 1개의 정보 =====
public class Entry {
    private int id;            // 글 번호
    private String writer;     // 작성자
    private String content;    // 내용

    public Entry(int id, String writer, String content) {  // 생성자
        this.id = id;
        this.writer = writer;
        this.content = content;
    }
    public int getId() { return id; }
    public String getWriter() { return writer; }
    public String getContent() { return content; }
}
```
```java
// ===== GuestbookStore.java : 모든 서블릿이 함께 쓰는 저장소 =====
public class GuestbookStore {
    public static ArrayList<Entry> list = new ArrayList<>();  // static = 객체 없이 클래스 이름으로 바로 접근, 모두 공유
    public static int nextId = 1;                             // 다음 글 번호
}
```
```java
// ===== GuestbookServlet.java : 목록 + 글쓰기 칸 =====
@WebServlet("/guestbook")
public class GuestbookServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String loginName = (String) req.getSession().getAttribute("loginName"); // 사물함에서 이름 꺼내기
        if (loginName == null) {                       // 로그인 안 했으면
            resp.sendRedirect("gb-login.html");        // 로그인 화면으로
            return;
        }

        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.println("<h2>방명록 (" + loginName + "님 환영)</h2>");

        // 글쓰기 칸 출력
        out.println("<form action='guestbook-write' method='post'>");
        out.println("<input type='text' name='content'>");
        out.println("<button>등록</button>");
        out.println("</form>");

        // 글 목록 출력
        for (Entry e : GuestbookStore.list) {
            out.print(e.getId() + ". <b>" + e.getWriter() + "</b>: " + e.getContent());
            if (e.getWriter().equals(loginName)) {     // 내 글일 때만 삭제 링크 보여주기
                out.print(" <a href='guestbook-delete?id=" + e.getId() + "'>삭제</a>");
            }
            out.println("<br>");
        }
    }
}
```
```java
// ===== GuestbookDeleteServlet.java : 삭제 =====
@WebServlet("/guestbook-delete")
public class GuestbookDeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String loginName = (String) req.getSession().getAttribute("loginName");
        int id = Integer.parseInt(req.getParameter("id"));   // ?id=3 → 3

        // 링크를 숨겨도 주소창에 직접 칠 수 있으니, 서버에서도 꼭 본인 글인지 확인!
        GuestbookStore.list.removeIf(e -> e.getId() == id && e.getWriter().equals(loginName));
        // ↑ removeIf: 조건이 true인 요소를 리스트에서 지움 (JS의 filter 반대 느낌, 람다식 사용)

        resp.sendRedirect("guestbook");                      // 목록으로 돌아가기
    }
}
```
</details>

---

## 🏁 최종 셀프 체크 (말로 설명할 수 있으면 ✅)
- [ ] 식당 비유로 브라우저 → 톰캣 → 서블릿 → 응답 흐름을 설명할 수 있다.
- [ ] `@WebServlet("/주소")`, `extends HttpServlet`, `doGet`의 역할을 설명할 수 있다.
- [ ] HTML `<input name="x">`와 `req.getParameter("x")`의 관계를 설명할 수 있다.
- [ ] GET과 POST의 차이, 그리고 `doGet`/`doPost`를 설명할 수 있다.
- [ ] forward(주방 안에서 넘기기)와 redirect(다른 창구로 보내기)를 구분할 수 있다.
- [ ] 세션 = 손님별 사물함, `JSESSIONID` = 번호표라고 설명할 수 있다.

## 🧯 에러 났을 때 보는 표
| 화면/콘솔 | 뜻 | 확인할 것 |
|---|---|---|
| **404** | 그런 주소(메뉴) 없음 | `@WebServlet` 주소와 주소창 철자 비교. `.html` 파일이면 `webapp` 폴더에 있는지 |
| **405** | 그 방식(GET/POST)은 처리 못함 | form의 `method`와 `doGet`/`doPost`가 맞는지 |
| **500** + `NumberFormatException` | 숫자가 아닌 걸 `parseInt` 함 | 빈 칸으로 보냈는지 |
| **500** + `NullPointerException` | `null`인 변수를 사용함 | 파라미터 이름 오타 (HTML `name`과 자바 글자 비교) |
| 한글이 `???` 또는 이상한 글자 | 인코딩 설정 누락 | 응답이면 `setContentType`, POST 입력이면 `setCharacterEncoding` |
| 코드를 고쳤는데 그대로임 | 서버가 옛날 코드로 실행 중 | ■ 끄고 ▶ 다시 실행 |
