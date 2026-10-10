package com.korai.ch10.TODO.view;

import com.korai.ch10.TODO.entity.Todo;
import com.korai.ch10.TODO.router.RootRouter;
import com.korai.ch10.TODO.service.TodoService;

import java.util.Scanner;

public class TodoListView implements View {

    /*
     * [선언 이유: private Scanner scanner]
     * - 콘솔에서 사용자가 선택한 메뉴 번호("1", "2", "q") 문자열을 입력받기 위한 Scanner 참조 변수입니다.
     */
    private Scanner scanner;

    /*
     * [선언 이유: private TodoService todoService]
     * - TodoService 클래스가 가지고 있는 getTodoList() 메서드를 호출하여
     *   할 일 목록 데이터를 가져오기 위해 선언한 참조 변수입니다.
     */
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

    /*
     * [강사님 깃허브 원본 복구 및 설명: printTodoList()]
     * - todoRepository.findAllByUserId()가 등록된 할 일이 없으면 null을 반환하므로,
     *   강사님 원본 코드에서는 if (todoService.getTodoList() == null) 조건 하나로 빈 목록 여부를 검사합니다.
     * - 목록이 존재하면 for-each문을 통해 각 Todo 인스턴스를 순차적으로 출력합니다.
     */
    private void printTodoList() {
        if (todoService.getTodoList() == null) {
            System.out.println("등록된 할 일이 없습니다.");
            return;
        }
        for (Todo todo : todoService.getTodoList()) {
            System.out.println(todo);
        }
    }

    /*
     * [강사님 깃허브 원본 복구 및 설명: showSelectList()]
     * - 사용자가 입력한 메뉴 번호에 따라 RootRouter.setCurrent(...) 메서드를 호출하여 화면 경로를 전환합니다:
     *   "1" -> RootRouter.setCurrent("todo-register") (등록 화면)
     *   "2" -> RootRouter.setCurrent("todo-status") (상태 변경 화면)
     *   "q" -> RootRouter.setCurrent("login") (로그아웃 후 로그인 화면)
     */
    private void showSelectList() {
        String cmd;
        System.out.println("1: 할 일 등록");
        System.out.println("2: 완료상태 수정");
        System.out.println("q: 로그아웃");
        System.out.print(">>> ");
        cmd = scanner.nextLine();
        if ("1".equals(cmd)) {
            RootRouter.setCurrent("todo-register");
        } else if ("2".equals(cmd)) {
            RootRouter.setCurrent("todo-status");
        } else if ("q".equals(cmd)) {
            RootRouter.setCurrent("login");
        } else {
            System.out.println("다시입력하세요.");
        }
    }

}
