package com.korai.ch10.TODO.view;

import com.korai.ch10.TODO.entity.Todo;
import com.korai.ch10.TODO.entity.TodoStatus;
import com.korai.ch10.TODO.router.RootRouter;
import com.korai.ch10.TODO.service.TodoService;

import java.util.List;
import java.util.Scanner;

public class TodoStatusView implements View {

    private Scanner scanner;

    /*
     * [선언 이유: private TodoService todoService]
     * - 이 클래스(TodoStatusView)에서 TodoService 객체의 getTodoList() 메서드와
     *   updateStatus() 메서드를 호출하여 상태를 변경하기 위해 선언한 참조 변수입니다.
     */
    private TodoService todoService;

    /*
     * [선언 이유: private int selectedTodoId]
     * - 사용자가 "몇 번 할 일을 수정할 것인가" 선택한 todoId(int) 값을 임시로 기억해 두기 위한 인스턴스 변수입니다.
     * - 초기값 0은 "아직 아무것도 선택되지 않음"을 나타냅니다.
     */
    private int selectedTodoId;

    public TodoStatusView(TodoService todoService) {
        this.scanner = new Scanner(System.in);
        this.todoService = todoService;
    }

    @Override
    public void show() {
        System.out.println("[ TODO STATUS 변경 ]");
        System.out.println("--------------------------------------------");

        // [작성 이유]: selectedTodoId 변수의 값(0인지 아닌지)에 따라 선택 여부 안내 문구를 분기 출력
        if (selectedTodoId == 0) {
            System.out.println("TODO를 선택하세요");
        } else {
            System.out.printf("[todoId : %d] TODO를 선택하셨습니다\n", selectedTodoId);
        }
        System.out.println("--------------------------------------------");
        showSelectList();
    }

    private void printTodoList() {
        List<Todo> todos = todoService.getTodoList();
        if (todos == null || todos.isEmpty()) {
            System.out.println("등록된 할 일이 없습니다.");
            return;
        }
        for (Todo todo : todos) {
            System.out.println(todo);
        }
    }

    /*
     * [작성 이유: private void selectedTodo()]
     * - 사용자가 입력한 번호표(id)가 실제 존재하는 Todo 인스턴스의 id인지 검증하고,
     *   유효한 경우 selectedTodoId 인스턴스 변수에 대입하여 기억하기 위한 메서드입니다.
     */
    private void selectedTodo() {
        printTodoList();

        List<Todo> todos = todoService.getTodoList();
        if (todos == null || todos.isEmpty()) {
            return;
        }

        System.out.print("todoId선택 >>> ");
        int todoId;

        /*
         * [작성 이유: try-catch (NumberFormatException)]
         * - Integer.parseInt() 메서드는 숫자가 아닌 문자열("abc" 등)이 들어오면 NumberFormatException 예외를 던집니다.
         * - 이 예외를 catch 블록으로 잡아내어 프로그램이 비정상 종료되는 것을 막고, "숫자를 입력하세요"를 출력한 뒤 return하기 위함입니다.
         */
        try {
            todoId = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("숫자를 입력하세요");
            return;
        }

        /*
         * [작성 이유: for문으로 ID 존재 여부 검증]
         * - List<Todo> 안의 각 Todo 객체의 getId() 메서드를 호출하여, 입력받은 todoId와 같은 것이 있는지 선형 탐색합니다.
         */
        boolean found = false;
        for (Todo todo : todos) {
            if (todo.getId() == todoId) {
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("선택하신 TODO-ID의 정보가 존재하지 않습니다");
            return;
        }

        // 유효한 ID이므로 selectedTodoId 변수에 저장
        selectedTodoId = todoId;
    }

    /*
     * [작성 이유: private void modificationStatus(TodoStatus todoStatus)]
     * - 매개변수로 전달받은 TodoStatus enum 상수(todo, inProgress, done)를
     *   todoService 객체의 updateStatus() 메서드에 전달하여 실제 수정을 지시하기 위함입니다.
     */
    private void modificationStatus(TodoStatus todoStatus) {
        /*
         * [작성 이유: if (selectedTodoId == 0) return]
         * - 사용자가 1번 메뉴(TODO 선택)를 먼저 거치지 않고 바로 2, 3, 4번 상태 변경을 눌렀을 때
         *   수정할 대상 ID가 없으므로 작업을 차단하기 위한 유효성 검사(방어 코드)입니다.
         */
        if (selectedTodoId == 0) {
            System.out.println("먼저 TODO를 선택하세요");
            return;
        }

        // todoService 객체의 updateStatus() 메서드 호출!
        todoService.updateStatus(selectedTodoId, todoStatus);
        System.out.printf("TODO ID [%d] : %s 상태변경완료\n", selectedTodoId, todoStatus);
    }

    private void showSelectList() {
        String cmd;
        System.out.println("1. TODO 선택하기 ");
        System.out.println("2. 진행전으로 변경 ");
        System.out.println("3. 진행중으로 변경 ");
        System.out.println("4. 완료상태로 변경 ");
        System.out.println("b. 뒤로가기 ");
        System.out.print(">>> ");
        cmd = scanner.nextLine();

        if ("1".equals(cmd)) {
            selectedTodo();
        } else if ("2".equals(cmd)) {
            modificationStatus(TodoStatus.todo);       // TodoStatus.todo enum 상수를 넘김
        } else if ("3".equals(cmd)) {
            modificationStatus(TodoStatus.inProgress); // TodoStatus.inProgress enum 상수를 넘김
        } else if ("4".equals(cmd)) {
            modificationStatus(TodoStatus.done);       // TodoStatus.done enum 상수를 넘김
        } else if ("b".equalsIgnoreCase(cmd)) {
            selectedTodoId = 0;                        // 뒤로가기 시 선택된 ID를 0으로 초기화
            RootRouter.setCurrent("todo-list");        // 목록 화면으로 라우팅 경로 변경
        } else {
            System.out.println("다시입력하세요");
        }
    }
}