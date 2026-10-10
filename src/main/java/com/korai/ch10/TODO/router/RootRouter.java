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
     * - 현재 화면으로 띄워줄 View 객체의 키값(경로 이름)을 기억하는 static 변수입니다.
     * - 초기값은 최초 실행 화면인 "login"입니다.
     */
    private static String current = "login";

    /*
     * [선언 이유: private static Map<String, View> viewMap]
     * - 화면 경로 이름(String)과 해당 화면 객체(View 구현체)를 키-값 쌍으로 매핑하여
     *   보관하기 위한 Map 컬렉션입니다.
     */
    private static Map<String, View> viewMap;

    /*
     * [메서드 설명: public static void setUp()]
     * - 프로그램 시작 시 필요한 Repository, Service, View 객체들을 차례로 생성(new)하고
     *   생성자를 통해 의존성을 주입(DI)한 뒤 viewMap에 등록하는 초기 설정 메서드입니다.
     */
    public static void setUp() {
        UserRepository userRepository = new UserRepository();
        UserService userService = new UserService(userRepository);
        LoginView loginView = new LoginView(userService);

        TodoRepository todoRepository = new TodoRepository();
        TodoService todoService = new TodoService(todoRepository, userRepository);
        TodoListView todoListView = new TodoListView(todoService);

        TodoRegisterView todoRegisterView = new TodoRegisterView(todoService);
        TodoStatusView todoStatusView = new TodoStatusView(todoService);

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

    public static void setCurrent(String path) {
        current = path;
    }

    /*
     * [메서드 설명: public static View getCurrentView()]
     * - viewMap.get(current)를 호출하여 현재 경로(current)에 매핑된 View 객체를 찾아 반환합니다.
     */
    public static View getCurrentView() {
        return viewMap.get(current);
    }
}
