# 📑 [TODO 애플리케이션] 비전공자를 위한 클래스별 1장 PDF 요약 마스터 가이드

> **💡 안내**  
> 본 문서는 추가된 **상태 관리(TodoStatus, TodoStatusView)**, **내 할 일만 필터링(findAllByUserId)**, **세션 단축(getUserId)** 등 최신 업데이트 내용을 100% 반영하였습니다.  
> 어려운 전문 용어를 배제하고 **일상생활 비유(회원증, 장부, 출입증, 3색 스티커)**를 적용하여, 비전공자도 **각 클래스를 딱 1장씩** 쉽고 명확하게 이해할 수 있도록 PDF 규격 템플릿으로 제작되었습니다.

---

## 🗺️ [한눈에 보는 비전공자 찰떡 비유 맵]

| 실제 시스템 역할 | 프로그램 속 클래스명 | 현실 세계 비유 |
|:---|:---|:---|
| **전원 스위치 & 회전목마** | `TodoApplication` | 놀이공원 회전목마처럼 끄기 전까지 계속 화면을 돌려주는 모터 |
| **화면 규격 약속** | `View` (인터페이스) | 모든 모니터가 똑같은 전원 버튼(`show()`)을 갖추도록 정한 규격 |
| **안내 데스크 & 교통경찰** | `RootRouter` | 모든 부품을 연결해주고, "지금은 로그인 화면!", "다음은 목록 화면!"을 교통정리 |
| **출입증 발급기 & 세션** | `SecurityConfig` | 로그인 성공 도장을 찍어주는 출입증(`uuid@userId`) 발급기 |
| **회원 신분증** | `User` | 회원 번호, 아이디, 비밀번호, 이름이 적힌 플라스틱 회원 카드 |
| **할 일 메모지** | `Todo` | 할 일 내용과 상태 스티커가 붙어 있고, 작성자 회원 카드가 꽂혀 있는 메모지 |
| **3색 상태 스티커** | `TodoStatus` (Enum) | [진행전 / 진행중 / 완료] 딱 3가지 색상만 붙일 수 있도록 규격화한 스티커 |
| **회원 관리 장부** | `UserRepository` | 도서관 사서의 회원 명부. 아이디나 회원 번호로 회원을 찾아줌 |
| **할 일 보관함 & 번호표 기계** | `TodoRepository` | 메모지를 모아두는 바인더. 메모가 들어올 때마다 1, 2, 3 번호표를 찍어주고, 내 메모만 골라줌 |
| **신분증 검사관** | `UserService` | 아이디와 비밀번호를 장부와 대조하여 맞으면 출입증을 발급해 줌 |
| **할 일 총괄 매니저** | `TodoService` | 출입증을 확인하여 "누구의 메모인지" 매핑하고, 등록/조회/상태변경을 총괄 지휘 |
| **로그인 창구** | `LoginView` | 회원에게 아이디와 비밀번호를 물어보는 창구 |
| **할 일 게시판 창구** | `TodoListView` | 내 할 일 메모들을 칠판에 붙여서 보여주고, 다음 행동을 물어보는 창구 |
| **할 일 작성 창구** | `TodoRegisterView` | "무슨 일 하실 건가요?" 내용을 받아 적는 창구 |
| **상태 변경 창구 (NEW!)** | `TodoStatusView` | "몇 번 메모지의 스티커를 [진행전/진행중/완료]로 바꿀까요?"를 처리하는 창구 |

---
---

<!-- PAGE BREAK -->
# 📄 [PAGE 01] TodoApplication.java

| 항목 | 내용 |
|:---|:---|
| **비전공자 비유** | 🎡 **회전목마 모터**: 프로그램을 켜고, 끄기 전까지 계속 화면을 돌려주는 역할 |
| **소속 계층** | 메인 진입점 (Main Entry Point) |
| **핵심 역할** | 프로그램 시작 시 부품을 한 번에 조립하고(`setUp`), 화면을 무한 반복 출력 |

### 📌 왜 이렇게 코드를 짰는가? (비전공자 맞춤 3줄 요약)
1. **`RootRouter.setUp()`을 맨 처음 부르는 이유**: 자동차를 출발하기 전에 엔진, 바퀴, 핸들(Repo, Service, View)을 먼저 완벽하게 조립해 두기 위함입니다.
2. **`while (true)`로 무한 반복하는 이유**: 콘솔 창은 한 번 실행되고 그냥 끝나버리기 때문에, 사용자가 '종료'를 누를 때까지 계속 화면을 띄워두기 위함입니다.
3. **`RootRouter.getCurrentView().show()`를 쓰는 이유**: 메인은 현재 화면이 로그인인지 목록인지 몰라도, "지금 화면 나와라!"라고 한 줄로 명령할 수 있습니다.

### 💻 코드 & 줄별 작성 의도 주석
```java
package com.korai.ch10.TODO;

import com.korai.ch10.TODO.router.RootRouter;

public class TodoApplication {
    public static void main(String[] args) {
        // [이유 1]: 프로그램 시작 전 모든 부품(저장소, 서비스, 화면)을 딱 1번 조립 완료!
        RootRouter.setUp();

        // [이유 2]: 사용자가 프로그램을 끄기 전까지 화면이 닫히지 않도록 무한히 반복 대기
        while (true) {
            // [이유 3]: 다형성(Polymorphism) 호출. 현재 화면이 무엇이든 show() 단 한 줄로 화면 출력!
            RootRouter.getCurrentView().show();
        }
    }
}
```

---
---

<!-- PAGE BREAK -->
# 📄 [PAGE 02] View.java (인터페이스)

| 항목 | 내용 |
|:---|:---|
| **비전공자 비유** | 🔘 **표준 규격 전원 버튼**: 어떤 가전제품이든 전원 버튼을 누르면 켜지듯이 만든 약속 |
| **소속 계층** | 화면 규격 (View Interface) |
| **핵심 역할** | 모든 화면 클래스가 무조건 `show()`라는 이름의 화면 표시 기능을 갖추도록 강제 |

### 📌 왜 이렇게 코드를 짰는가? (비전공자 맞춤 3줄 요약)
1. **버튼 이름 통일**: 어떤 화면은 `display()`, 어떤 화면은 `render()`로 제각각 만들면 헷갈리므로, 무조건 `show()` 하나로 통일했습니다.
2. **코드 수정 최소화**: 나중에 새로운 화면(예: 삭제 화면)이 추가되어도, 메인 프로그램 코드를 한 글자도 건드릴 필요가 없습니다.
3. **규격만 정의**: 화면마다 필요한 내부 재료는 다르므로 껍데기 약속(인터페이스)만 만들어 두었습니다.

### 💻 코드 & 줄별 작성 의도 주석
```java
package com.korai.ch10.TODO.view;

/*
 * [이유 1]: 모든 화면이 따라야 하는 표준 규격을 선언합니다.
 * LoginView, TodoListView, TodoStatusView 등이 모두 이 인터페이스를 지킵니다.
 */
public interface View {
    /*
     * [이유 2]: 화면을 모니터에 출력하는 표준 약속 메서드입니다.
     * 화면이 끝나면 자기가 알아서 다음 화면으로 넘기기 때문에 돌려주는 값(return)은 void입니다.
     */
    public void show();
}
```

---
---

<!-- PAGE BREAK -->
# 📄 [PAGE 03] LoginView.java

| 항목 | 내용 |
|:---|:---|
| **비전공자 비유** | 🚪 **입구 신분증 검사 창구**: 아이디/비밀번호를 받아 검사관에게 확인받는 곳 |
| **소속 계층** | 화면 계층 (View Layer) |
| **핵심 역할** | 아이디/비밀번호 입력받기 $\rightarrow$ 인증 요청 $\rightarrow$ 출입증(토큰) 저장 $\rightarrow$ 목록 화면으로 이동 |

### 📌 왜 이렇게 코드를 짰는가? (비전공자 맞춤 3줄 요약)
1. **`UserService`를 외부에서 받는 이유(DI)**: 창구 직원이 검사관을 직접 만들지 않고, 본사에서 배정해 준 검사관에게 검사를 맡기기 위함입니다.
2. **`token == null`일 때 조기 리턴(Early Return)**: 로그인이 실패하면 에러 문구를 보여주고 즉시 멈춰서 다음 단계로 넘어가지 못하게 막습니다.
3. **`scanner.nextLine()`으로 멈추는 이유**: 사용자가 "로그인 실패!" 메시지를 읽을 시간도 없이 화면이 넘어가 버리는 것을 막기 위해 엔터 칠 때까지 기다려줍니다.

### 💻 코드 & 줄별 작성 의도 주석
```java
package com.korai.ch10.TODO.view;

import com.korai.ch10.TODO.config.SecurityConfig;
import com.korai.ch10.TODO.router.RootRouter;
import com.korai.ch10.TODO.service.UserService;
import java.util.Scanner;

public class LoginView implements View {
    private UserService userService;
    private Scanner scanner;

    // [이유 1]: 외부에서 검사관(UserService)을 전달받아 결합도를 낮춤 (의존성 주입)
    public LoginView(UserService userService) {
        this.userService = userService;
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void show() {
        String username;
        String password;

        System.out.println("[ TODO LIST 로그인 ]");
        System.out.print("username :  ");
        username = scanner.nextLine();
        System.out.print("password : ");
        password = scanner.nextLine();

        // [이유 2]: 비밀번호가 맞는지 판단하는 일은 화면이 아니라 전문가(UserService)에게 위임!
        String token = userService.login(username, password);

        // [이유 3]: 실패 시 즉시 조기 종료(return). 사용자가 엔터를 누를 때까지 친절히 대기
        if (token == null) {
            System.out.println("로그인 정보를 다시 확인하세요.");
            System.out.println("엔터를 눌러 다시 입력하세요.");
            scanner.nextLine();
            return;
        }

        // [이유 4]: 성공하면 출입증(token)을 주머니(SecurityConfig)에 넣고, 할 일 목록 화면으로 이동!
        SecurityConfig.setLoginSession(token);
        System.out.println(String.format("로그인 성공. %s님 환영합니다.", username));
        RootRouter.setCurrent("todo-list");
    }
}
```

---
---

<!-- PAGE BREAK -->
# 📄 [PAGE 04] TodoListView.java

| 항목 | 내용 |
|:---|:---|
| **비전공자 비유** | 📋 **할 일 게시판 창구**: 내 할 일 목록을 칠판에 보여주고, 다음 메뉴를 고르는 곳 |
| **소속 계층** | 화면 계층 (View Layer) |
| **핵심 역할** | 내 할 일 목록 콘솔 출력, 번호 메뉴(1: 등록, 2: 상태수정, q: 로그아웃) 분기 |

### 📌 왜 이렇게 코드를 짰는가? (비전공자 맞춤 3줄 요약)
1. **출력부(`printTodoList`)와 메뉴부(`showSelectList`) 분리**: 한 화면 안에서도 '목록 보여주기'와 '버튼 누르기'를 쪼개어 코드를 읽기 쉽게 정리했습니다.
2. **`"2".equals(cmd)` 분기 추가 (NEW)**: 이번 업데이트로 2번을 누르면 새로 만든 '상태 수정 화면(`todo-status`)'으로 이동하도록 연결했습니다.
3. **`"1".equals(cmd)`로 비교하는 이유**: `cmd.equals("1")`로 쓰면 사용자가 아무것도 입력 안 했을 때 에러(NPE)가 날 수 있어, 글자 `"1"`을 앞에 두어 안전하게 방어했습니다.

### 💻 코드 & 줄별 작성 의도 주석
```java
package com.korai.ch10.TODO.view;

import com.korai.ch10.TODO.entity.Todo;
import com.korai.ch10.TODO.router.RootRouter;
import com.korai.ch10.TODO.service.TodoService;
import java.util.Scanner;

public class TodoListView implements View {
    private Scanner scanner;
    private TodoService todoService;

    public TodoListView(TodoService todoService) {
        this.scanner = new Scanner(System.in);
        this.todoService = todoService;
    }

    // [이유 1]: show() 하나에 다 몰아넣지 않고 목록 출력과 메뉴 선택으로 깔끔하게 분리
    @Override
    public void show() {
        System.out.println("[ TODO LIST 목록 ]");
        printTodoList();
        showSelectList();
    }

    private void printTodoList() {
        // [이유 2]: 등록된 할 일이 없으면 빈 화면 대신 친절한 안내 문구 출력
        if (todoService.getTodoList() == null || todoService.getTodoList().isEmpty()) {
            System.out.println("등록된 할 일이 없습니다.");
            return;
        }
        // [이유 3]: 내 할 일들을 순회하며 출력 (Todo의 toString이 예쁘게 출력해 줌)
        for (Todo todo : todoService.getTodoList()) {
            System.out.println(todo);
        }
    }

    private void showSelectList() {
        String cmd;
        System.out.println("1: 할 일 등록");
        System.out.println("2: 완료상태 수정"); // [NEW]: 상태 수정 메뉴
        System.out.println("q: 로그아웃");
        System.out.print(">>> ");
        cmd = scanner.nextLine();

        // [이유 4]: 안전한 리터럴 비교로 화면 전환 지시
        if ("1".equals(cmd)) {
            RootRouter.setCurrent("todo-register");
        } else if ("2".equals(cmd)) {
            RootRouter.setCurrent("todo-status");  // [NEW]: 상태 수정 화면으로 전환!
        } else if ("q".equals(cmd)) {
            RootRouter.setCurrent("login");        // 로그아웃 후 로그인 화면으로 복귀
        } else {
            System.out.println("다시입력하세요.");
        }
    }
}
```

---
---

<!-- PAGE BREAK -->
# 📄 [PAGE 05] TodoRegisterView.java

| 항목 | 내용 |
|:---|:---|
| **비전공자 비유** | ✍️ **할 일 메모 접수 창구**: 사용자가 말한 할 일 내용을 종이에 적어 매니저에게 넘기는 곳 |
| **소속 계층** | 화면 계층 (View Layer) |
| **핵심 역할** | 할 일 내용(문장)을 입력받아 매니저(`TodoService.register`)에게 전달하고 목록으로 복귀 |

### 📌 왜 이렇게 코드를 짰는가? (비전공자 맞춤 3줄 요약)
1. **`scanner.nextLine()` 사용**: "자바 10장 복습하기"처럼 띄어쓰기가 들어간 긴 문장을 통째로 받기 위해 사용했습니다.
2. **뷰는 내용만 넘김 (캡슐화)**: 창구 직원은 "누가 로그인했는지", "번호표가 몇 번인지" 몰라도 되고 오직 적힌 내용(`content`)만 넘기면 매니저가 알아서 처리합니다.
3. **등록 후 바로 `todo-list`로 이동**: 글을 썼으면 내가 쓴 글이 잘 등록되었는지 바로 확인하고 싶으므로 목록 화면으로 즉시 전환합니다.

### 💻 코드 & 줄별 작성 의도 주석
```java
package com.korai.ch10.TODO.view;

import com.korai.ch10.TODO.router.RootRouter;
import com.korai.ch10.TODO.service.TodoService;
import java.util.Scanner;

public class TodoRegisterView implements View {
    private final TodoService todoService;
    private Scanner scanner;

    public TodoRegisterView(TodoService todoService) {
        this.todoService = todoService;
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void show() {
        String content;
        System.out.println("[ 할 일 등록하기 ]");
        System.out.print("내용 : ");
        // [이유 1]: 공백이 포함된 문장 전체를 입력받기 위해 nextLine() 사용
        content = scanner.nextLine();

        // [이유 2]: 창구는 내용만 넘기고, 세션 확인 및 저장은 TodoService에 위임
        todoService.register(content);

        // [이유 3]: 등록 완료 후 방금 등록한 할 일을 바로 확인하도록 목록으로 전환
        RootRouter.setCurrent("todo-list");
    }
}
```

---
---

<!-- PAGE BREAK -->
# 📄 [PAGE 06] TodoStatusView.java (🔥 NEW!)

| 항목 | 내용 |
|:---|:---|
| **비전공자 비유** | 🏷️ **스티커 교체 창구**: "몇 번 메모지의 스티커를 [진행전/진행중/완료]로 바꿀까요?" 처리 |
| **소속 계층** | 화면 계층 (View Layer) |
| **핵심 역할** | 수정할 할 일 선택(`selectedTodoId`) $\rightarrow$ 상태 스티커 교체 $\rightarrow$ 뒤로가기 |

### 📌 왜 이렇게 코드를 짰는가? (비전공자 맞춤 3줄 요약)
1. **`selectedTodoId` 변수를 둔 이유**: 사용자가 "1번 할 일 골랐어요!"라고 했을 때 그 번호를 기억해 두어야 다음 메뉴에서 상태를 바꿀 수 있기 때문입니다.
2. **`try-catch (NumberFormatException)` 예외 처리**: 사용자가 숫자가 아니라 "abc" 같은 글자를 입력해도 프로그램이 강제 종료되지 않고 친절하게 "숫자를 입력하세요"라고 안내합니다.
3. **`selectedTodoId == 0` 방어 로직**: 사용자가 어떤 할 일을 고르지도 않았는데 상태부터 바꾸려고 하면 "먼저 TODO를 선택하세요"라고 막아줍니다.

### 💻 코드 & 줄별 작성 의도 주석
```java
package com.korai.ch10.TODO.view;

import com.korai.ch10.TODO.entity.Todo;
import com.korai.ch10.TODO.entity.TodoStatus;
import com.korai.ch10.TODO.router.RootRouter;
import com.korai.ch10.TODO.service.TodoService;
import java.util.List;
import java.util.Scanner;

public class TodoStatusView implements View {
    private Scanner scanner;
    private TodoService todoService;
    // [이유 1]: 현재 사용자가 어떤 할 일을 선택했는지 기억하는 변수 (0이면 아직 미선택)
    private int selectedTodoId;

    public TodoStatusView(TodoService todoService) {
        this.scanner = new Scanner(System.in);
        this.todoService = todoService;
    }

    @Override
    public void show() {
        System.out.println("[ TODO STATUS 변경 ]");
        System.out.println("--------------------------------------------");
        // [이유 2]: 현재 선택된 할 일이 있는지 없는지 화면 상단에 명확하게 안내
        if (selectedTodoId == 0) {
            System.out.println("TODO를 선택하세요");
        } else {
            System.out.printf("[todoId : %d] TODO를 선택하셨습니다\n", selectedTodoId);
        }
        System.out.println("--------------------------------------------");
        showSelectList();
    }

    // [이유 3]: 할 일 번호를 입력받아 선택 상태로 저장하는 메서드
    private void selectedTodo() {
        List<Todo> todos = todoService.getTodoList();
        if (todos == null || todos.isEmpty()) {
            System.out.println("등록된 할 일이 없습니다.");
            return;
        }
        for (Todo todo : todos) { System.out.println(todo); }

        System.out.print("todoId선택 >>> ");
        int todoId;
        try {
            // [이유 4]: 문자를 입력했을 때 프로그램이 터지지 않도록 예외 처리
            todoId = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("숫자를 입력하세요");
            return;
        }

        // [이유 5]: 실제 존재하는 ID인지 검증 후 기억
        boolean found = todos.stream().anyMatch(t -> t.getId() == todoId);
        if (!found) {
            System.out.println("선택하신 TODO-ID의 정보가 존재하지 않습니다");
            return;
        }
        selectedTodoId = todoId;
    }

    // [이유 6]: 선택된 할 일의 상태를 변경하는 메서드
    private void modificationStatus(TodoStatus todoStatus) {
        if (selectedTodoId == 0) {
            System.out.println("먼저 TODO를 선택하세요");
            return;
        }
        todoService.updateStatus(selectedTodoId, todoStatus);
        System.out.printf("TODO ID [%d] : %s 상태변경완료\n", selectedTodoId, todoStatus);
    }

    private void showSelectList() {
        System.out.println("1. TODO 선택하기 ");
        System.out.println("2. 진행전으로 변경 ");
        System.out.println("3. 진행중으로 변경 ");
        System.out.println("4. 완료상태로 변경 ");
        System.out.println("b. 뒤로가기 ");
        System.out.print(">>> ");
        String cmd = scanner.nextLine();

        if ("1".equals(cmd)) { selectedTodo(); }
        else if ("2".equals(cmd)) { modificationStatus(TodoStatus.todo); }
        else if ("3".equals(cmd)) { modificationStatus(TodoStatus.inProgress); }
        else if ("4".equals(cmd)) { modificationStatus(TodoStatus.done); }
        else if ("b".equals(cmd)) {
            selectedTodoId = 0; // 뒤로 갈 때는 선택 번호 초기화
            RootRouter.setCurrent("todo-list");
        } else { System.out.println("다시입력하세요"); }
    }
}
```

---
---

<!-- PAGE BREAK -->
# 📄 [PAGE 07] RootRouter.java

| 항목 | 내용 |
|:---|:---|
| **비전공자 비유** | 👮 **교통경찰 & 총괄 조립소**: 모든 부품을 연결해주고 차선(화면)을 바꿔주는 관제탑 |
| **소속 계층** | 라우팅 및 객체 조립소 (IoC Container / Router) |
| **핵심 역할** | 모든 객체(Repo, Service, View)를 순서대로 조립하고, 현재 보여줄 화면을 관리 |

### 📌 왜 이렇게 코드를 짰는가? (비전공자 맞춤 3줄 요약)
1. **하위 부품부터 조립**: 리포지토리(장부) $\rightarrow$ 서비스(매니저) $\rightarrow$ 뷰(화면) 순서로 생성해야 윗사람에게 아랫사람을 넘겨줄 수 있습니다.
2. **`TodoStatusView` 추가 등록 (NEW)**: 이번에 새로 만든 상태 변경 화면을 조립하고 `"todo-status"`라는 경로로 라우터 맵에 등록했습니다.
3. **`Map.of(...)` 불변 맵 사용**: 프로그램 실행 도중에 화면 목록이 실수로 지워지거나 변조되지 않도록 안전하게 고정했습니다.

### 💻 코드 & 줄별 작성 의도 주석
```java
package com.korai.ch10.TODO.router;

import com.korai.ch10.TODO.repository.TodoRepository;
import com.korai.ch10.TODO.repository.UserRepository;
import com.korai.ch10.TODO.service.TodoService;
import com.korai.ch10.TODO.service.UserService;
import com.korai.ch10.TODO.view.*;
import java.util.Map;

public class RootRouter {
    private static String current = "login"; // 시작 화면은 무조건 로그인
    private static Map<String, View> viewMap;

    public static void setUp() {
        // [이유 1]: 하위 저장소부터 차례대로 생성하여 서비스와 뷰에 주입(DI)
        UserRepository userRepository = new UserRepository();
        UserService userService = new UserService(userRepository);
        LoginView loginView = new LoginView(userService);

        TodoRepository todoRepository = new TodoRepository();
        TodoService todoService = new TodoService(todoRepository, userRepository);
        TodoListView todoListView = new TodoListView(todoService);
        TodoRegisterView todoRegisterView = new TodoRegisterView(todoService);
        
        // [이유 2]: NEW! 새로 만든 TodoStatusView도 조립하여 준비
        TodoStatusView todoStatusView = new TodoStatusView(todoService);

        // [이유 3]: 불변 Map.of()로 모든 화면을 라우팅 테이블에 등록
        viewMap = Map.of(
                "login", loginView,
                "todo-list", todoListView,
                "todo-register", todoRegisterView,
                "todo-status", todoStatusView // [NEW 등록!]
        );
    }

    public static View getCurrentView() { return viewMap.get(current); }
    public static void setCurrent(String path) { current = path; }
}
```

---
---

<!-- PAGE BREAK -->
# 📄 [PAGE 08] SecurityConfig.java

| 항목 | 내용 |
|:---|:---|
| **비전공자 비유** | 🎫 **출입증 발급기 & 주머니**: 로그인 도장이 찍힌 출입증을 발급하고 유저 번호를 확인 |
| **소속 계층** | 보안/설정 계층 (Config Layer) |
| **핵심 역할** | 전역 로그인 세션 보관, `UUID@userId` 토큰 생성, **`getUserId()` 번호 추출 (NEW!)** |

### 📌 왜 이렇게 코드를 짰는가? (비전공자 맞춤 3줄 요약)
1. **`uuid + "@" + userId` 구조**: 출입증에 무작위 난수뿐만 아니라 회원 번호(`userId`)를 같이 적어두어, 출입증만 봐도 누구인지 바로 알 수 있습니다.
2. **`getUserId()` 메서드 신설 (NEW)**: 서비스마다 매번 복잡하게 문자열을 자르지 않고, `SecurityConfig.getUserId()` 한 줄로 내 회원 번호를 바로 꺼내 쓰도록 개선했습니다.
3. **`static` 변수 사용**: 프로그램 어디서든 번거롭게 객체를 만들지 않고 즉시 현재 로그인한 사람을 확인할 수 있습니다.

### 💻 코드 & 줄별 작성 의도 주석
```java
package com.korai.ch10.TODO.config;

import com.korai.ch10.TODO.entity.User;
import java.util.UUID;

public class SecurityConfig {
    // [이유 1]: 현재 로그인한 사람의 출입증을 담아두는 전역 주머니 (null이면 로그아웃)
    private static String loginSession = null;

    public static String getLoginSession() { return loginSession; }
    public static void setLoginSession(String session) { SecurityConfig.loginSession = session; }

    // [이유 2]: 32자리 난수 뒤에 '@회원번호'를 붙여 중복 없고 역추적 쉬운 토큰 발급
    public static String generateSessionToken(User user) {
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        return uuid + "@" + user.getId();
    }

    // [이유 3: NEW!]: 출입증에서 '@' 뒷부분의 회원번호 숫자만 쏙 뽑아 정수(int)로 리턴!
    public static int getUserId() {
        String token = loginSession;
        return Integer.parseInt(token.substring(token.indexOf("@") + 1));
    }
}
```

---
---

<!-- PAGE BREAK -->
# 📄 [PAGE 09] User.java (엔티티)

| 항목 | 내용 |
|:---|:---|
| **비전공자 비유** | 🪪 **플라스틱 회원 카드**: 번호, 아이디, 비밀번호, 이름이 적힌 신분증 |
| **소속 계층** | 도메인 엔티티 (Domain Entity) |
| **핵심 역할** | 회원 1명의 필수 정보를 하나로 묶어서 들고 다니는 데이터 그릇 |

### 📌 왜 이렇게 코드를 짰는가? (비전공자 맞춤 3줄 요약)
1. **필요한 정보 4개**: 회원 번호(`id`), 아이디(`username`), 비밀번호(`password`), 실명(`name`)을 규격화했습니다.
2. **Lombok `@Data` 적용**: 게터(꺼내기), 세터(넣기), 출력 기능(`toString`)을 자동으로 만들어 코드를 5줄로 단축했습니다.
3. **Lombok `@AllArgsConstructor`**: `new User(1, "test", ...)`처럼 한 줄로 회원 카드를 발급할 수 있습니다.

### 💻 코드 & 줄별 작성 의도 주석
```java
package com.korai.ch10.TODO.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data              // [이유 1]: 게터, 세터, toString 자동 생성
@AllArgsConstructor // [이유 2]: 모든 정보를 채워 넣는 생성자 자동 생성
public class User {
    private int id;          // 회원 고유 번호 (1, 2, 3...)
    private String username; // 로그인 아이디
    private String password; // 비밀번호
    private String name;     // 회원 이름
}
```

---
---

<!-- PAGE BREAK -->
# 📄 [PAGE 10] TodoStatus.java (🔥 NEW Enum!)

| 항목 | 내용 |
|:---|:---|
| **비전공자 비유** | 🏷️ **3색 상태 규격 스티커**: 아무 글자나 쓰지 못하도록 정해진 3가지 딱지만 쓰게 만든 규칙 |
| **소속 계층** | 도메인 엔티티 / 열거형 (Enum) |
| **핵심 역할** | 할 일 상태를 [진행전(`todo`) / 진행중(`inProgress`) / 완료(`done`)]으로 한정 |

### 📌 왜 이렇게 코드를 짰는가? (비전공자 맞춤 3줄 요약)
1. **문자열 대신 `enum`을 쓴 이유**: 만약 `String`으로 쓰면 "진행중", "진행 중", "ing"처럼 오타가 날 수 있어, 오직 3가지 정해진 상수만 쓰도록 강제했습니다.
2. **한글 설명(`status`) 내장**: 화면에 표시할 때 직관적으로 "진행전", "진행중", "완료"라는 한글을 바로 꺼낼 수 있게 필드를 두었습니다.
3. **`toString()` 오버라이딩**: 콘솔에 출력할 때 상태명이 보기 좋게 찍히도록 오버라이드했습니다.

### 💻 코드 & 줄별 작성 의도 주석
```java
package com.korai.ch10.TODO.entity;

public enum TodoStatus {
    // [이유 1]: 상태는 딱 이 3가지만 존재하도록 엄격하게 제한! (오타 방지)
    todo("진행전"), inProgress("진행중"), done("완료");

    private String status;

    // [이유 2]: 각 상수마다 한글 설명 문구를 연결
    TodoStatus(String status) {
        this.status = status;
    }

    public String getStatus() { return status; }

    // [이유 3]: 콘솔 출력 시 깔끔하게 상태를 보여주기 위한 toString
    @Override
    public String toString() {
        return "TodoStatus{status='" + status + "'}";
    }
}
```

---
---

<!-- PAGE BREAK -->
# 📄 [PAGE 11] Todo.java (엔티티)

| 항목 | 내용 |
|:---|:---|
| **비전공자 비유** | 📝 **할 일 메모지**: 내용, 번호표, **3색 스티커(NEW)**, 작성자 회원증이 함께 붙은 종이 |
| **소속 계층** | 도메인 엔티티 (Domain Entity) |
| **핵심 역할** | 할 일 1건의 데이터(id, 상태, 내용, 작성자)를 묶어서 보관 |

### 📌 왜 이렇게 코드를 짰는가? (비전공자 맞춤 3줄 요약)
1. **`TodoStatus status = TodoStatus.todo` 기본값 (NEW)**: 메모지를 처음 만들면 기본 상태가 자동으로 "진행전" 스티커가 붙도록 설정했습니다.
2. **`User user` 객체 참조**: 단순히 숫자 `userId`만 적어두는 게 아니라 작성자의 회원 카드(`User`) 자체를 꽂아두어, 필요할 때 작성자 이름을 바로 꺼낼 수 있습니다.
3. **`id`는 임시값 0으로 출발**: 나중에 보관함(`TodoRepository`)에 들어갈 때 진짜 번호표를 받으므로 처음엔 0으로 시작합니다.

### 💻 코드 & 줄별 작성 의도 주석
```java
package com.korai.ch10.TODO.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Todo {
    private int id;                                     // 할 일 번호표
    private TodoStatus status = TodoStatus.todo;        // [NEW]: 기본값은 '진행전' 스티커!
    private String content;                             // 할 일 내용 문장
    private User user;                                  // [객체 연관]: 작성자 회원 카드 직접 연결!
}
```

---
---

<!-- PAGE BREAK -->
# 📄 [PAGE 12] UserRepository.java

| 항목 | 내용 |
|:---|:---|
| **비전공자 비유** | 📖 **회원 관리 장부**: 도서관 사서의 회원 명부. 아이디나 번호로 사람을 찾아줌 |
| **소속 계층** | 데이터 저장소 (Repository Layer) |
| **핵심 역할** | 메모리 상에 회원 목록을 보관하고 `findByUsername`과 `findById`로 검색 |

### 📌 왜 이렇게 코드를 짰는가? (비전공자 맞춤 3줄 요약)
1. **더미 회원 4명 사전 등록**: 실제 데이터베이스가 없어도 즉시 로그인 테스트를 할 수 있도록 4명의 회원을 미리 적어두었습니다.
2. **`Objects.equals(...)` 사용**: 혹시 아이디가 비어있거나 이상한 값이 들어와도 에러(NPE)로 프로그램이 죽지 않고 안전하게 비교합니다.
3. **`findById` 제공**: 출입증에서 꺼낸 회원 번호(숫자)로 회원을 빠르게 찾기 위해 번호 전용 검색기를 만들었습니다.

### 💻 코드 & 줄별 작성 의도 주석
```java
package com.korai.ch10.TODO.repository;

import com.korai.ch10.TODO.entity.User;
import java.util.List;
import java.util.Objects;

public class UserRepository {
    private List<User> users;

    // [이유 1]: 실습을 위해 4명의 회원을 미리 장부에 적어둠 (List.of 불변 리스트)
    public UserRepository() {
        User user1 = new User(1, "test1", "1q2w3e4r!", "강민재1");
        User user2 = new User(2, "test2", "1q2w3e4r!", "강민재2");
        User user3 = new User(3, "test3", "1q2w3e4r!", "강민재3");
        User user4 = new User(4, "test4", "1q2w3e4r!", "강민재4");
        users = List.of(user1, user2, user3, user4);
    }

    // [이유 2]: 아이디로 검색 (로그인할 때 사용, Objects.equals로 안전 비교)
    public User findByUsername(String username) {
        for (User user : users) {
            if (Objects.equals(user.getUsername(), username)) { return user; }
        }
        return null;
    }

    // [이유 3]: 회원 번호로 검색 (출입증 번호로 유저 찾을 때 사용)
    public User findById(int id) {
        for (User user : users) {
            if (user.getId() == id) { return user; }
        }
        return null;
    }
}
```

---
---

<!-- PAGE BREAK -->
# 📄 [PAGE 13] TodoRepository.java

| 항목 | 내용 |
|:---|:---|
| **비전공자 비유** | 🗄️ **할 일 보관함 & 번호표 기계**: 메모지를 모아두고 번호표를 1씩 찍어주는 곳 |
| **소속 계층** | 데이터 저장소 (Repository Layer) |
| **핵심 역할** | 메모 보관, `autoIncrement++` 번호표 발급, **내 메모만 찾기(NEW)**, **상태 변경(NEW)** |

### 📌 왜 이렇게 코드를 짰는가? (비전공자 맞춤 3줄 요약)
1. **`autoIncrement++`**: 메모지가 들어올 때마다 번호표를 1, 2, 3... 순서대로 하나씩 올려서 찍어줍니다.
2. **`findAllByUserId(userId)` (NEW)**: 남의 메모까지 다 보여주면 안 되므로, "내 회원 번호"와 일치하는 메모만 바구니에 골라 담아서 돌려줍니다.
3. **`updateStatus(todoId, todoStatus)` (NEW)**: 지정된 메모지를 찾아서 상태 스티커를 새것으로 갈아 끼워줍니다.

### 💻 코드 & 줄별 작성 의도 주석
```java
package com.korai.ch10.TODO.repository;

import com.korai.ch10.TODO.entity.Todo;
import com.korai.ch10.TODO.entity.TodoStatus;
import lombok.Getter;
import java.util.ArrayList;
import java.util.List;

public class TodoRepository {
    private int autoIncrement = 1; // 1번부터 시작하는 번호표 기계

    @Getter
    private List<Todo> todos;      // 메모지들을 모아둔 리스트

    public TodoRepository() { todos = new ArrayList<>(); }

    // [이유 1]: 새 메모지에 번호표를 찍고(1씩 증가) 보관함에 넣음
    public void insert(Todo todo) {
        todo.setId(autoIncrement++);
        todos.add(todo);
    }

    // [이유 2: NEW!]: 내 회원 번호(userId)와 일치하는 메모만 골라내는 필터링 기능
    public List<Todo> findAllByUserId(int userId) {
        List<Todo> filteredTodos = new ArrayList<>();
        for (Todo todo : todos) {
            if (todo.getUser().getId() == userId) {
                filteredTodos.add(todo);
            }
        }
        return filteredTodos; // 없으면 빈 리스트 리턴 (null 에러 방지)
    }

    // [이유 3: NEW!]: 번호표(todoId)에 해당하는 메모지를 찾아 스티커 교체
    public void updateStatus(int todoId, TodoStatus todoStatus) {
        for (Todo todo : todos) {
            if (todo.getId() == todoId) {
                todo.setStatus(todoStatus);
                break; // 찾았으면 반복 중단
            }
        }
    }
}
```

---
---

<!-- PAGE BREAK -->
# 📄 [PAGE 14] UserService.java

| 항목 | 내용 |
|:---|:---|
| **비전공자 비유** | 👮 **신분증 검사관**: 가져온 신분증과 비밀번호가 장부와 맞는지 검사하여 출입증 발급 |
| **소속 계층** | 비즈니스 로직 (Service Layer) |
| **핵심 역할** | 로그인 검증 (아이디 존재 확인 $\rightarrow$ 비밀번호 일치 확인 $\rightarrow$ 출입증 토큰 발급) |

### 📌 왜 이렇게 코드를 짰는가? (비전공자 맞춤 3줄 요약)
1. **화면과 장부 사이의 중재자**: 화면 직원이 장부를 직접 만지면 규칙이 깨지므로, 검사관을 거쳐서 안전하게 인증합니다.
2. **2단계 철저한 검사**: 1단계로 아이디가 있는지 보고, 2단계로 비밀번호를 확인하여 둘 중 하나라도 틀리면 `null`(실패)을 돌려줍니다.
3. **토큰 발급**: 인증에 통과하면 비밀번호 대신 안전한 출입증(`SecurityConfig.generateSessionToken`)을 건네줍니다.

### 💻 코드 & 줄별 작성 의도 주석
```java
package com.korai.ch10.TODO.service;

import com.korai.ch10.TODO.config.SecurityConfig;
import com.korai.ch10.TODO.entity.User;
import com.korai.ch10.TODO.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import java.util.Objects;

@RequiredArgsConstructor
public class UserService {
    // [이유 1]: 장부(UserRepository)를 불변(final)으로 주입받음
    private final UserRepository userRepository;

    public String login(String username, String password) {
        // [1단계]: 장부에서 아이디로 회원 조회
        User foundUser = userRepository.findByUsername(username);
        if (foundUser == null) { return null; }

        // [2단계]: 비밀번호가 맞는지 안전하게 확인 (Objects.equals)
        if (!Objects.equals(foundUser.getPassword(), password)) { return null; }

        // [3단계]: 통과했으면 출입증 토큰을 만들어 전달!
        return SecurityConfig.generateSessionToken(foundUser);
    }
}
```

---
---

<!-- PAGE BREAK -->
# 📄 [PAGE 15] TodoService.java

| 항목 | 내용 |
|:---|:---|
| **비전공자 비유** | 🧑‍💼 **할 일 총괄 매니저**: 출입증 확인, 메모지 작성, 보관함 넣기, 상태 변경을 총괄 지휘 |
| **소속 계층** | 비즈니스 로직 (Service Layer) |
| **핵심 역할** | 내 할 일만 가져오기(`findAllByUserId`), 새 할 일 작성 등록, **상태 변경 위임(NEW)** |

### 📌 왜 이렇게 코드를 짰는가? (비전공자 맞춤 3줄 요약)
1. **`getTodoList()`의 진화 (NEW)**: 이제 전체 할 일이 아니라 `SecurityConfig.getUserId()`를 이용해 '현재 로그인한 내 할 일'만 가져옵니다.
2. **`register()`의 간결화 (NEW)**: 복잡한 문자열 자르기 없이 `SecurityConfig.getUserId()`로 회원을 찾아 기본 상태(`TodoStatus.todo`)를 주어 등록합니다.
3. **`updateStatus()` 추가 (NEW)**: 상태 변경 요청이 들어오면 보관함(`TodoRepository`)에 스티커 교체를 지시합니다.

### 💻 코드 & 줄별 작성 의도 주석
```java
package com.korai.ch10.TODO.service;

import com.korai.ch10.TODO.config.SecurityConfig;
import com.korai.ch10.TODO.entity.Todo;
import com.korai.ch10.TODO.entity.TodoStatus;
import com.korai.ch10.TODO.entity.User;
import com.korai.ch10.TODO.repository.TodoRepository;
import com.korai.ch10.TODO.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import java.util.List;

@RequiredArgsConstructor
public class TodoService {
    // [이유 1]: 할 일 보관함과 회원 장부를 둘 다 쥐고 조율함
    private final TodoRepository todoRepository;
    private final UserRepository userRepository;

    // [이유 2: NEW!]: 내 출입증 회원번호로 '내 할 일'만 골라서 반환!
    public List<Todo> getTodoList() {
        return todoRepository.findAllByUserId(SecurityConfig.getUserId());
    }

    // [이유 3: NEW!]: 내 회원번호로 유저를 찾아 '진행전' 상태의 새 메모지를 등록!
    public void register(String content) {
        User foundUser = userRepository.findById(SecurityConfig.getUserId());
        Todo todo = new Todo(0, TodoStatus.todo, content, foundUser);
        todoRepository.insert(todo);
    }

    // [이유 4: NEW!]: 메모지 번호와 새 스티커를 받아 보관함에 교체 지시
    public void updateStatus(int todoId, TodoStatus todoStatus) {
        todoRepository.updateStatus(todoId, todoStatus);
    }
}
```

---
---

## 🏆 전체 4대 핵심 동작 시나리오 총정리

```
[시나리오 1: 로그인]
사용자 ──> LoginView ──> UserService (장부 검사) ──> SecurityConfig (출입증 발급) ──> TodoListView 이동

[시나리오 2: 내 목록 보기 (NEW 내 것만 필터링!)]
사용자 ──> TodoListView ──> TodoService ──> SecurityConfig.getUserId() ──> TodoRepository.findAllByUserId() ──> 내 메모만 출력

[시나리오 3: 새 할 일 등록 (NEW 진행전 상태 자동 부여!)]
사용자 ──> TodoRegisterView ──> TodoService ──> new Todo(0, TodoStatus.todo, ...) ──> TodoRepository.insert() ──> TodoListView 복귀

[시나리오 4: 상태 변경 (NEW 신규 추가 파이프라인!)]
사용자 ──> TodoStatusView (번호 선택 후 3색 스티커 지정) ──> TodoService.updateStatus() ──> TodoRepository.updateStatus() ──> 스티커 교체 완료!
```
