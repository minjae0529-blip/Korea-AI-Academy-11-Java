package com.korai.ch10.TODO.view;

import com.korai.ch10.TODO.entity.Todo;
import com.korai.ch10.TODO.router.RootRouter;
import com.korai.ch10.TODO.service.TodoService;

import java.util.Scanner;

public class TodoListView implements View {

    /*
     * [선언 이유: private Scanner scanner]
     * - 메뉴 번호("1", "2", "q")를 콘솔에서 입력받기 위해 Scanner 객체를 참조하는 변수입니다.
     */
    private Scanner scanner;

    /*
     * [선언 이유: private TodoService todoService]
     * - TodoService 클래스가 가지고 있는 getTodoList() 메서드를 호출하여
     *   저장소에 보관된 할 일 리스트를 가져오기 위해 선언한 참조 변수입니다.
     */
    private TodoService todoService;

    /*
     * [작성 이유: 생성자 매개변수로 TodoService 받기 (의존성 주입)]
     * - 외부(RootRouter)에서 생성된 TodoService 인스턴스를 매개변수로 전달받아
     *   this.todoService에 담아둠으로써 두 클래스 간의 결합도를 낮추기 위함입니다.
     */
    public TodoListView(TodoService todoService) {
        this.scanner = new Scanner(System.in);
        this.todoService = todoService;
    }

    @Override
    public void show() {
        System.out.println("[ TODO LIST 목록 ]");
        printTodoList();  // 1. 목록 출력 메서드 호출
        showSelectList(); // 2. 메뉴 선택 및 이동 메서드 호출
    }

    /*
     * [작성 이유: private void printTodoList()]
     * - 할 일 목록을 콘솔에 출력하는 역할을 담당하는 메서드입니다.
     */
    private void printTodoList() {
        /*
         * [작성 이유: todoService.getTodoList() == null || isEmpty()]
         * - todoService.getTodoList() 메서드를 호출하여 반환된 리스트가 비어있는지 확인합니다.
         * - 리스트에 내용이 없으면 "등록된 할 일이 없습니다."를 출력하고 즉시 return으로 빠져나갑니다.
         */
        if (todoService.getTodoList() == null || todoService.getTodoList().isEmpty()) {
            System.out.println("등록된 할 일이 없습니다.");
            return;
        }

        /*
         * [작성 이유: for-each 순회 출력]
         * - todoService.getTodoList()로 받아온 List<Todo> 안의 Todo 인스턴스들을 하나씩 꺼내어
         *   System.out.println(todo)로 출력합니다.
         * - 이때 Todo 클래스에 붙은 Lombok @Data가 자동 생성한 toString() 메서드가 호출되어 필드값들이 출력됩니다.
         */
        for (Todo todo : todoService.getTodoList()) {
            System.out.println(todo);
        }
    }

    /*
     * [작성 이유: private void showSelectList()]
     * - 사용자에게 메뉴 번호를 보여주고 입력을 받아 화면 경로(RootRouter)를 변경하는 메서드입니다.
     */
    private void showSelectList() {
        String cmd;
        System.out.println("1: 할 일 등록");
        System.out.println("2: 완료상태 수정");
        System.out.println("q: 로그아웃");
        System.out.print(">>> ");
        cmd = scanner.nextLine(); // 사용자 입력 대기

        /*
         * [작성 이유: "1".equals(cmd)]
         * - cmd.equals("1") 대신 문자열 리터럴 "1"을 앞에 두고 equals()를 호출한 이유:
         *   혹시 cmd가 null이더라도 NullPointerException 예외가 발생하지 않고 안전하게 false를 반환하기 때문입니다.
         * - 입력값에 따라 RootRouter.setCurrent() 정적 메서드를 호출하여 다음 표시할 화면 경로 문자열을 변경합니다.
         */
        if ("1".equals(cmd)) {
            RootRouter.setCurrent("todo-register"); // 할 일 등록 뷰로 경로 변경
        } else if ("2".equals(cmd)) {
            RootRouter.setCurrent("todo-status");   // 상태 수정 뷰로 경로 변경
        } else if ("q".equalsIgnoreCase(cmd)) {
            RootRouter.setCurrent("login");         // 로그인 뷰로 경로 변경 (로그아웃 효과)
        } else {
            System.out.println("다시입력하세요.");
        }
    }
}
