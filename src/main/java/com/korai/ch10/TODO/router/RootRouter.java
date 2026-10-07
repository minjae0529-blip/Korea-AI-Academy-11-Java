package com.korai.ch10.TODO.router;

import com.korai.ch10.TODO.repository.TodoRepository;
import com.korai.ch10.TODO.repository.UserRepository;
import com.korai.ch10.TODO.service.TodoService;
import com.korai.ch10.TODO.service.UserService;
import com.korai.ch10.TODO.view.*;

import java.util.Map;

public class RootRouter {

    /*
     * [선언 이유: private static String current = "login"]
     * - 현재 활성화된 화면의 경로 문자열(Key)을 보관하는 정적 변수입니다.
     * - 기본값을 "login"으로 둔 이유: 프로그램 시작 시 가장 먼저 로그인 화면이 떠야 하기 때문입니다.
     */
    private static String current = "login";

    /*
     * [선언 이유: private static Map<String, View> viewMap]
     * - 경로 이름(String)을 Key로, 해당 경로의 View 객체 인스턴스를 Value로 매핑하여 저장하는 Map 컬렉션입니다.
     * - Value 타입을 'View' 인터페이스로 선언한 이유: 다형성(Polymorphism)을 활용해 LoginView, TodoListView 등
     *   모든 구현체 클래스를 하나의 맵에 담기 위함입니다.
     */
    private static Map<String, View> viewMap;

    /*
     * [작성 이유: public static void setUp()]
     * - 애플리케이션에 필요한 모든 객체를 new로 인스턴스화하고 의존성(DI)을 연결하는 초기화 메서드입니다.
     * - 하위 계층(Repository)부터 생성하여 상위 계층(Service, View)의 생성자 매개변수로 주입합니다.
     */
    public static void setUp() {
        // 1. 유저 계층 객체 생성 및 의존성 주입
        UserRepository userRepository = new UserRepository();
        UserService userService = new UserService(userRepository); // userService에 userRepository 주입
        LoginView loginView = new LoginView(userService);           // loginView에 userService 주입

        // 2. 할 일 계층 객체 생성 및 의존성 주입
        TodoRepository todoRepository = new TodoRepository();
        // TodoService는 할 일 저장뿐만 아니라 작성자 User 객체 조회가 필요하므로 2개의 저장소를 주입받음
        TodoService todoService = new TodoService(todoRepository, userRepository);
        TodoListView todoListView = new TodoListView(todoService);

        TodoRegisterView todoRegisterView = new TodoRegisterView(todoService);
        TodoStatusView todoStatusView = new TodoStatusView(todoService);

        /*
         * [작성 이유: Map.of(...)]
         * - Java 9+ 메서드로, 불변(Immutable) Map을 생성하여 viewMap 변수에 할당합니다.
         * - 런타임에 라우팅 경로가 임의로 추가/삭제/변경되지 않도록 방어하기 위함입니다.
         */
        viewMap = Map.of(
                "login", loginView,
                "todo-list", todoListView,
                "todo-register", todoRegisterView,
                "todo-status", todoStatusView
        );
    }

    public static String getCurrent() {
        return current;
    }

    /*
     * [작성 이유: public static View getCurrentView()]
     * - viewMap.get(current)를 호출하여 현재 활성화된 경로의 View 객체를 꺼내서 반환합니다.
     * - 반환 타입이 'View' 인터페이스이므로, 호출하는 쪽(TodoApplication)에서는 실제 객체가
     *   LoginView인지 TodoListView인지 알 필요 없이 show() 메서드만 호출하면 됩니다.
     */
    public static View getCurrentView() {
        return viewMap.get(current);
    }

    /*
     * [작성 이유: public static void setCurrent(String path)]
     * - 각 View에서 화면 이동이 필요할 때 호출하여 current 경로 변수값을 변경합니다.
     */
    public static void setCurrent(String path) {
        current = path;
    }

}
