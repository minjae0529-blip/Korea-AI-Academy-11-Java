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
    private int selectedTodoId;     // selecteedTodoId → selectedTodoId (오타 수정)

    public TodoStatusView(TodoService todoService) {
        this.scanner = new Scanner(System.in);
        this.todoService = todoService;
    }

    @Override
    public void show() {
        System.out.println("[ TODO STATUS 변경 ]");
        System.out.println("--------------------------------------------");
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
        if (todos == null || todos.isEmpty()) {          // null, 빈 리스트 모두 처리
            System.out.println("등록된 할 일이 없습니다.");
            return;
        }
        for (Todo todo : todos) {
            System.out.println(todo);
        }
    }

    private void selectedTodo() {
        printTodoList();

        List<Todo> todos = todoService.getTodoList();
        if (todos == null || todos.isEmpty()) {          // 할 일이 없으면 여기서 종료
            return;
        }

        System.out.print("todoId선택 >>> ");
        int todoId;
        try {
            todoId = Integer.parseInt(scanner.nextLine());   // 숫자가 아닌 입력 처리
        } catch (NumberFormatException e) {
            System.out.println("숫자를 입력하세요");
            return;
        }

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
        selectedTodoId = todoId;
    }

    private void modificationStatus(TodoStatus todoStatus) {
        if (selectedTodoId == 0) {                       // 선택 없이 변경하는 것 방지
            System.out.println("먼저 TODO를 선택하세요");
            return;
        }
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

        // "1".equals(cmd): cmd가 null이어도 NullPointerException이 나지 않음
        if ("1".equals(cmd)) {
            selectedTodo();
        } else if ("2".equals(cmd)) {
            modificationStatus(TodoStatus.todo);          // selectedTodo → modificationStatus
        } else if ("3".equals(cmd)) {
            modificationStatus(TodoStatus.inProgress);    // selectedTodo → modificationStatus
        } else if ("4".equals(cmd)) {
            modificationStatus(TodoStatus.done);
        } else if ("b".equals(cmd)) {
            selectedTodoId = 0;
            RootRouter.setCurrent("todo-list");
        } else {
            System.out.println("다시입력하세요");
        }
    }
}