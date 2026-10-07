# 📦 [TODO 애플리케이션] 패키지별 한눈에 보는 요약 가이드

> **💡 안내**  
> 클래스들을 낱개로 보지 않고, **실제 프로젝트의 7개 패키지(역할별 묶음)** 단위로 나누어 정리했습니다.  
> 비전공자도 쉽게 이해할 수 있도록 **일상생활 비유**와 함께, **각 코드를 왜 이렇게 작성했는지 주석**을 달아두었습니다.

```
📁 com.korai.ch10.TODO
 ├── 🚀 [1. root]        TodoApplication.java (메인 실행)
 ├── 👮 [2. router]      RootRouter.java (조립소 & 화면 교통정리)
 ├── 🖥️ [3. view]        View, LoginView, TodoListView, TodoRegisterView, TodoStatusView (화면 창구)
 ├── 🧑‍💼 [4. service]     UserService, TodoService (업무 처리 매니저)
 ├── 🗄️ [5. repository]  UserRepository, TodoRepository (데이터 보관함)
 ├── 🪪 [6. entity]      User, Todo, TodoStatus (데이터 양식)
 └── 🎫 [7. config]      SecurityConfig (출입증 발급 & 보안)
```

---
---

# 📦 패키지 1. `com.korai.ch10.TODO` (루트 패키지)

> **🎡 현실 비유: 놀이공원 회전목마 모터 (전원 스위치)**  
> 프로그램을 켜고, 사용자가 끌 때까지 계속 화면을 돌려주는 시작점입니다.

### 📄 소속 클래스: `TodoApplication.java`

#### 📌 왜 이렇게 코드를 짰는가?
1. **`RootRouter.setUp()`**: 프로그램을 시작하기 전에 모든 부품(저장소, 서비스, 화면)을 한 번에 조립해 두기 위함입니다.
2. **`while (true)`**: 콘솔 프로그램은 1번 실행되면 꺼져버리므로, 사용자가 끌 때까지 계속 화면을 띄워두는 이벤트 루프입니다.
3. **`RootRouter.getCurrentView().show()`**: 현재 화면이 무엇이든 상관없이 "화면 나와라!"라고 다형성으로 한 줄 실행합니다.

```java
package com.korai.ch10.TODO;

import com.korai.ch10.TODO.router.RootRouter;

public class TodoApplication {
    public static void main(String[] args) {
        // [이유 1]: 프로그램 시작 전 모든 부품(저장소, 서비스, 화면)을 딱 1번 조립 완료!
        RootRouter.setUp();

        // [이유 2]: 사용자가 프로그램을 끄기 전까지 화면이 닫히지 않도록 무한히 반복 대기
        while (true) {
            // [이유 3]: 다형성 호출. 현재 화면이 무엇이든 show() 단 한 줄로 화면 출력!
            RootRouter.getCurrentView().show();
        }
    }
}
```

---
---

# 📦 패키지 2. `com.korai.ch10.TODO.router` (라우터 패키지)

> **👮 현실 비유: 종합 안내 데스크 & 교통경찰**  
> 모든 부품을 연결해 주고, "지금은 로그인 화면!", "다음은 목록 화면!"으로 교통정리를 해줍니다.

### 📄 소속 클래스: `RootRouter.java`

#### 📌 왜 이렇게 코드를 짰는가?
1. **하위 계층부터 조립(DI)**: 저장소(Repo) $\rightarrow$ 매니저(Service) $\rightarrow$ 화면(View) 순서로 생성해야 윗사람에게 아랫사람을 쥐여줄 수 있습니다.
2. **`TodoStatusView` 추가 등록 (NEW)**: 이번에 새로 만든 상태 변경 화면을 조립하고 `"todo-status"`라는 이름표로 등록했습니다.
3. **`Map.of(...)` 불변 맵**: 라우팅 테이블이 실행 중에 실수로 지워지거나 변조되지 않도록 안전하게 고정했습니다.

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
        
        // [이유 2: NEW!]: 새로 만든 상태 변경 화면(TodoStatusView)도 조립
        TodoStatusView todoStatusView = new TodoStatusView(todoService);

        // [이유 3]: 불변 Map.of()로 모든 화면을 라우팅 테이블에 안전 보관
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

# 📦 패키지 3. `com.korai.ch10.TODO.view` (화면 UI 패키지)

> **🖥️ 현실 비유: 손님 응대 창구들**  
> 사용자에게 글자를 보여주고 키보드 입력을 받는 창구입니다. 복잡한 계산은 하지 않고 서비스 매니저에게 시킵니다.

### 📄 1) `View.java` (인터페이스)
* **비유**: 🔘 **모니터 전원 버튼 규격** (모든 모니터가 똑같이 `show()` 버튼을 갖춤)
* **왜 짰는가?**: 모든 화면이 `show()`라는 통일된 이름으로 작동하도록 강제하여, 메인 프로그램에서 복잡한 `if-else` 없이 실행하기 위함입니다.

```java
package com.korai.ch10.TODO.view;

public interface View {
    // [이유]: 모든 화면이 화면을 띄울 때 무조건 show()라는 이름을 쓰도록 약속
    public void show();
}
```

---

### 📄 2) `LoginView.java` (로그인 화면)
* **비유**: 🚪 **입구 신분증 검사 창구** (아이디/비밀번호 받아 출입증 받기)
* **왜 짰는가?**:
  1. `userService.login()`으로 검사관에게 확인 위임 (화면은 검증 규칙을 직접 몰라도 됨)
  2. `if (token == null) return;`: 실패 시 조기 종료(Early Return)로 즉시 멈춤
  3. 성공 시 `SecurityConfig.setLoginSession(token)`으로 출입증을 주머니에 넣고 목록 화면으로 이동

```java
package com.korai.ch10.TODO.view;

import com.korai.ch10.TODO.config.SecurityConfig;
import com.korai.ch10.TODO.router.RootRouter;
import com.korai.ch10.TODO.service.UserService;
import java.util.Scanner;

public class LoginView implements View {
    private UserService userService;
    private Scanner scanner;

    public LoginView(UserService userService) {
        this.userService = userService;
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void show() {
        System.out.println("[ TODO LIST 로그인 ]");
        System.out.print("username :  ");
        String username = scanner.nextLine();
        System.out.print("password : ");
        String password = scanner.nextLine();

        // [이유 1]: 검사관에게 인증 위임
        String token = userService.login(username, password);

        // [이유 2]: 실패 시 즉시 조기 종료(return)
        if (token == null) {
            System.out.println("로그인 정보를 다시 확인하세요. 엔터를 눌러 다시 입력하세요.");
            scanner.nextLine();
            return;
        }

        // [이유 3]: 성공 시 출입증을 보관하고 목록 화면으로 이동
        SecurityConfig.setLoginSession(token);
        System.out.println(String.format("로그인 성공. %s님 환영합니다.", username));
        RootRouter.setCurrent("todo-list");
    }
}
```

---

### 📄 3) `TodoListView.java` (할 일 목록 화면)
* **비유**: 📋 **할 일 칠판 게시판 창구** (내 할 일들을 보여주고 다음 메뉴 선택)
* **왜 짰는가?**:
  1. `printTodoList()`와 `showSelectList()`로 분리하여 코드 가독성 증대
  2. `"2".equals(cmd)`: 2번을 누르면 새로 만든 상태 수정 화면(`todo-status`)으로 이동
  3. `"1".equals(cmd)`: 리터럴을 앞에 두어 null 에러(NPE) 방어

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

    @Override
    public void show() {
        System.out.println("[ TODO LIST 목록 ]");
        printTodoList();
        showSelectList();
    }

    private void printTodoList() {
        // [이유 1]: 비어있으면 친절한 안내 문구
        if (todoService.getTodoList() == null || todoService.getTodoList().isEmpty()) {
            System.out.println("등록된 할 일이 없습니다.");
            return;
        }
        for (Todo todo : todoService.getTodoList()) { System.out.println(todo); }
    }

    private void showSelectList() {
        System.out.println("1: 할 일 등록 | 2: 완료상태 수정 | q: 로그아웃");
        System.out.print(">>> ");
        String cmd = scanner.nextLine();

        if ("1".equals(cmd)) { RootRouter.setCurrent("todo-register"); }
        else if ("2".equals(cmd)) { RootRouter.setCurrent("todo-status"); } // [NEW 상태수정 연동!]
        else if ("q".equals(cmd)) { RootRouter.setCurrent("login"); }
        else { System.out.println("다시입력하세요."); }
    }
}
```

---

### 📄 4) `TodoRegisterView.java` (할 일 등록 화면)
* **비유**: ✍️ **할 일 메모 접수 창구** (할 일 내용을 적어 매니저에게 전달)
* **왜 짰는가?**: 창구 직원은 작성자 정보나 번호표 발급을 알 필요 없이 오직 내용(`content`)만 매니저에게 전달하고 목록으로 돌아갑니다.

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
        System.out.println("[ 할 일 등록하기 ]");
        System.out.print("내용 : ");
        String content = scanner.nextLine(); // 띄어쓰기 포함 문장 입력

        // [이유]: 내용만 전달하고 실제 저장은 TodoService에 위임
        todoService.register(content);

        // [이유]: 등록 직후 방금 쓴 글을 확인하도록 목록으로 이동
        RootRouter.setCurrent("todo-list");
    }
}
```

---

### 📄 5) `TodoStatusView.java` (🔥 NEW! 상태 변경 화면)
* **비유**: 🏷️ **스티커 교체 창구** (메모 번호를 골라 [진행전/진행중/완료] 스티커로 교체)
* **왜 짰는가?**:
  1. `selectedTodoId`: 손님이 고른 메모 번호를 기억해 둠
  2. `try-catch`: 숫자가 아닌 글자를 쳤을 때 프로그램이 죽지 않고 재입력 안내
  3. `selectedTodoId == 0`: 메모를 고르지도 않고 스티커를 바꾸려 하면 먼저 고르라고 방어

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
    private int selectedTodoId; // [이유 1]: 선택한 메모 번호 기억 보관함

    public TodoStatusView(TodoService todoService) {
        this.scanner = new Scanner(System.in);
        this.todoService = todoService;
    }

    @Override
    public void show() {
        System.out.println("[ TODO STATUS 변경 ]");
        if (selectedTodoId == 0) {
            System.out.println("TODO를 선택하세요");
        } else {
            System.out.printf("[todoId : %d] TODO를 선택하셨습니다\n", selectedTodoId);
        }
        showSelectList();
    }

    private void selectedTodo() {
        List<Todo> todos = todoService.getTodoList();
        if (todos == null || todos.isEmpty()) return;
        for (Todo todo : todos) { System.out.println(todo); }

        System.out.print("todoId선택 >>> ");
        int todoId;
        try {
            // [이유 2]: 글자 입력 시 에러 방어
            todoId = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("숫자를 입력하세요");
            return;
        }

        boolean found = todos.stream().anyMatch(t -> t.getId() == todoId);
        if (!found) { System.out.println("해당 TODO가 없습니다."); return; }
        selectedTodoId = todoId;
    }

    private void modificationStatus(TodoStatus todoStatus) {
        // [이유 3]: 미선택 상태 변경 시도 방어
        if (selectedTodoId == 0) {
            System.out.println("먼저 TODO를 선택하세요");
            return;
        }
        todoService.updateStatus(selectedTodoId, todoStatus);
        System.out.printf("TODO ID [%d] : %s 상태변경완료\n", selectedTodoId, todoStatus);
    }

    private void showSelectList() {
        System.out.println("1. TODO 선택 | 2. 진행전 | 3. 진행중 | 4. 완료 | b. 뒤로가기");
        System.out.print(">>> ");
        String cmd = scanner.nextLine();
        if ("1".equals(cmd)) selectedTodo();
        else if ("2".equals(cmd)) modificationStatus(TodoStatus.todo);
        else if ("3".equals(cmd)) modificationStatus(TodoStatus.inProgress);
        else if ("4".equals(cmd)) modificationStatus(TodoStatus.done);
        else if ("b".equals(cmd)) {
            selectedTodoId = 0;
            RootRouter.setCurrent("todo-list");
        }
    }
}
```

---
---

# 📦 패키지 4. `com.korai.ch10.TODO.service` (서비스 로직 패키지)

> **🧑‍💼 현실 비유: 업무 총괄 매니저 & 신분증 검사관**  
> 화면 창구와 데이터 보관소 사이에서 실제 판단과 지휘를 내리는 두뇌 역할을 합니다.

### 📄 1) `UserService.java` (회원 인증 서비스)
* **비유**: 👮 **신분증 검사관** (아이디/비밀번호 확인 후 출입증 발급)
* **왜 짰는가?**: 1단계로 회원이 있는지 보고, 2단계로 비밀번호가 맞는지 확인하여 둘 다 통과하면 출입증 토큰을 만들어 줍니다.

```java
package com.korai.ch10.TODO.service;

import com.korai.ch10.TODO.config.SecurityConfig;
import com.korai.ch10.TODO.entity.User;
import com.korai.ch10.TODO.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import java.util.Objects;

@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public String login(String username, String password) {
        // [1단계]: 장부에서 아이디로 회원 조회
        User foundUser = userRepository.findByUsername(username);
        if (foundUser == null) return null;

        // [2단계]: 비밀번호 일치 확인 (Objects.equals로 안전 비교)
        if (!Objects.equals(foundUser.getPassword(), password)) return null;

        // [3단계]: 통과 시 출입증 토큰 발급!
        return SecurityConfig.generateSessionToken(foundUser);
    }
}
```

---

### 📄 2) `TodoService.java` (할 일 총괄 서비스)
* **비유**: 🧑‍💼 **할 일 총괄 매니저** (내 메모 조회, 등록, 스티커 교체 지휘)
* **왜 짰는가?**:
  1. `getTodoList()`: `SecurityConfig.getUserId()`로 '내 할 일'만 골라서 가져옴
  2. `register()`: 내 번호로 회원을 찾아 초기 상태(`TodoStatus.todo`)의 메모지를 등록
  3. `updateStatus()`: 스티커 교체 요청이 들어오면 보관함에 지시

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
    private final TodoRepository todoRepository;
    private final UserRepository userRepository;

    // [이유 1: NEW!]: 내 출입증 회원번호로 '내 메모'만 골라옴!
    public List<Todo> getTodoList() {
        return todoRepository.findAllByUserId(SecurityConfig.getUserId());
    }

    // [이유 2: NEW!]: 내 번호로 회원을 찾아 '진행전' 상태로 등록
    public void register(String content) {
        User foundUser = userRepository.findById(SecurityConfig.getUserId());
        Todo todo = new Todo(0, TodoStatus.todo, content, foundUser);
        todoRepository.insert(todo);
    }

    // [이유 3: NEW!]: 보관함에 스티커 교체 지시
    public void updateStatus(int todoId, TodoStatus todoStatus) {
        todoRepository.updateStatus(todoId, todoStatus);
    }
}
```

---
---

# 📦 패키지 5. `com.korai.ch10.TODO.repository` (저장소 패키지)

> **🗄️ 현실 비유: 장부 보관소 & 번호표 기계**  
> 데이터가 실제로 메모리 리스트에 저장되고 검색되는 가상 데이터베이스입니다.

### 📄 1) `UserRepository.java` (회원 장부)
* **비유**: 📖 **도서관 사서의 회원 명부** (더미 회원 4명 보관 및 검색)

```java
package com.korai.ch10.TODO.repository;

import com.korai.ch10.TODO.entity.User;
import java.util.List;
import java.util.Objects;

public class UserRepository {
    private List<User> users;

    // [이유 1]: 실습을 위해 4명의 회원을 장부에 미리 적어둠 (List.of)
    public UserRepository() {
        User user1 = new User(1, "test1", "1q2w3e4r!", "강민재1");
        User user2 = new User(2, "test2", "1q2w3e4r!", "강민재2");
        User user3 = new User(3, "test3", "1q2w3e4r!", "강민재3");
        User user4 = new User(4, "test4", "1q2w3e4r!", "강민재4");
        users = List.of(user1, user2, user3, user4);
    }

    // [이유 2]: 아이디로 검색 (로그인 시 사용)
    public User findByUsername(String username) {
        for (User user : users) {
            if (Objects.equals(user.getUsername(), username)) return user;
        }
        return null;
    }

    // [이유 3]: 회원 번호로 검색 (출입증 번호로 유저 찾을 때 사용)
    public User findById(int id) {
        for (User user : users) {
            if (user.getId() == id) return user;
        }
        return null;
    }
}
```

---

### 📄 2) `TodoRepository.java` (할 일 보관함)
* **비유**: 🗄️ **할 일 보관함 & 번호표 기계** (번호표 찍기, 내 것만 골라내기, 스티커 교체)

```java
package com.korai.ch10.TODO.repository;

import com.korai.ch10.TODO.entity.Todo;
import com.korai.ch10.TODO.entity.TodoStatus;
import lombok.Getter;
import java.util.ArrayList;
import java.util.List;

public class TodoRepository {
    private int autoIncrement = 1; // [이유 1]: 1번부터 시작하는 번호표 기계
    @Getter private List<Todo> todos;

    public TodoRepository() { todos = new ArrayList<>(); }

    public void insert(Todo todo) {
        // [이유 2]: 번호표를 1씩 올리며 찍고 저장
        todo.setId(autoIncrement++);
        todos.add(todo);
    }

    // [이유 3: NEW!]: 내 회원 번호(userId)와 일치하는 메모만 바구니에 담아 반환!
    public List<Todo> findAllByUserId(int userId) {
        List<Todo> filteredTodos = new ArrayList<>();
        for (Todo todo : todos) {
            if (todo.getUser().getId() == userId) filteredTodos.add(todo);
        }
        return filteredTodos;
    }

    // [이유 4: NEW!]: 번호표를 찾아 스티커 교체
    public void updateStatus(int todoId, TodoStatus todoStatus) {
        for (Todo todo : todos) {
            if (todo.getId() == todoId) {
                todo.setStatus(todoStatus);
                break;
            }
        }
    }
}
```

---
---

# 📦 패키지 6. `com.korai.ch10.TODO.entity` (엔티티 패키지)

> **🪪 현실 비유: 신분증 & 메모지 양식**  
> 시스템에서 돌아다니는 데이터의 뼈대와 규칙을 정해둔 양식입니다.

### 📄 1) `TodoStatus.java` (🔥 NEW Enum!)
* **비유**: 🏷️ **3색 상태 규격 스티커** (아무 글자나 쓰지 못하게 3가지만 허용)

```java
package com.korai.ch10.TODO.entity;

public enum TodoStatus {
    // [이유 1]: 상태는 딱 이 3가지만 존재하도록 엄격하게 제한! (오타 방지)
    todo("진행전"), inProgress("진행중"), done("완료");

    private String status;

    TodoStatus(String status) { this.status = status; }
    public String getStatus() { return status; }

    @Override
    public String toString() {
        return "TodoStatus{status='" + status + "'}";
    }
}
```

---

### 📄 2) `Todo.java` (할 일 엔티티)
* **비유**: 📝 **할 일 메모지** (내용, 번호표, 3색 스티커, 작성자 회원 카드가 꽂힌 종이)

```java
package com.korai.ch10.TODO.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Todo {
    private int id;                              // 번호표
    private TodoStatus status = TodoStatus.todo; // [NEW]: 기본값은 '진행전' 스티커!
    private String content;                      // 할 일 내용
    private User user;                           // [객체 연관]: 작성자 회원 카드 직접 연결!
}
```

---

### 📄 3) `User.java` (회원 엔티티)
* **비유**: 🪪 **플라스틱 회원 카드** (번호, 아이디, 비밀번호, 이름이 적힌 신분증)

```java
package com.korai.ch10.TODO.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
    private int id;          // 회원 번호
    private String username; // 아이디
    private String password; // 비밀번호
    private String name;     // 실명
}
```

---
---

# 📦 패키지 7. `com.korai.ch10.TODO.config` (설정 및 보안 패키지)

> **🎫 현실 비유: 출입증 발급기 & 주머니**  
> 로그인 성공 시 출입증을 발급하고, 필요할 때마다 회원 번호를 확인해 주는 보안실입니다.

### 📄 소속 클래스: `SecurityConfig.java`

#### 📌 왜 이렇게 코드를 짰는가?
1. **`uuid + "@" + userId`**: 난수 뒤에 회원 번호를 적어두어 출입증만 봐도 누구인지 바로 알 수 있습니다.
2. **`getUserId()` 신설 (NEW)**: 매번 복잡하게 문자열을 자르지 않고, `SecurityConfig.getUserId()` 한 줄로 내 회원 번호를 즉시 꺼내 씁니다.
3. **`static` 변수**: 어디서든 객체 생성 없이 로그인 세션을 바로 확인할 수 있습니다.

```java
package com.korai.ch10.TODO.config;

import com.korai.ch10.TODO.entity.User;
import java.util.UUID;

public class SecurityConfig {
    private static String loginSession = null; // 출입증 주머니 (null이면 로그아웃)

    public static String getLoginSession() { return loginSession; }
    public static void setLoginSession(String session) { SecurityConfig.loginSession = session; }

    // [이유 1]: 32자리 난수 뒤에 '@회원번호'를 결합한 토큰 발급
    public static String generateSessionToken(User user) {
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        return uuid + "@" + user.getId();
    }

    // [이유 2: NEW!]: 출입증에서 회원번호 숫자만 쏙 뽑아 정수(int)로 리턴!
    public static int getUserId() {
        String token = loginSession;
        return Integer.parseInt(token.substring(token.indexOf("@") + 1));
    }
}
```
