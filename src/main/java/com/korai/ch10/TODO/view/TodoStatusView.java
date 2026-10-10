package com.korai.ch10.TODO.view;

import com.korai.ch10.TODO.entity.Todo;
import com.korai.ch10.TODO.entity.TodoStatus;
import com.korai.ch10.TODO.router.RootRouter;
import com.korai.ch10.TODO.service.TodoService;

import java.util.List;
import java.util.Scanner;

public class TodoStatusView implements View {

    /*
     * [선언 이유: private final Scanner scanner]
     * - 콘솔에서 사용자의 키보드 입력(nextInt, nextLine)을 받기 위해 선언한 Scanner 객체 참조 변수입니다.
     */
    private final Scanner scanner;

    /*
     * [선언 이유: private final TodoService todoService]
     * - TodoService 클래스가 가지고 있는 getTodoList() 메서드를 호출하여
     *   할 일 목록 데이터를 가져오기 위해 선언한 참조 변수입니다.
     */
    private final TodoService todoService;

    /*
     * [선언 이유: private int selectedTodoId]
     * - 사용자가 선택한 할 일의 id 번호(int)를 기억해 두기 위한 인스턴스 변수입니다.
     */
    private int selectedTodoId;

    public TodoStatusView(TodoService todoService) {
        this.scanner = new Scanner(System.in);
        this.todoService = todoService;
    }

    @Override
    public void show() {
        System.out.println("[ TODO STATUS 변경 ]");
        showSelectList();
    }

    /*
     * [메서드 설명: private void printTodoList()]
     * - todoService 객체의 getTodoList() 메서드를 호출하여 반환값이 null이면 안내 메시지를 출력하고,
     *   목록이 있으면 for-each문으로 각 Todo 인스턴스를 콘솔에 출력합니다.
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
     * [강사님 깃허브 원본 복구 및 변경점: selectedTodo()]
     * 1. 임의의 try-catch 제거:
     *    - 이전 코드에서는 Integer.parseInt()에 임의의 try-catch(NumberFormatException)를 사용했으나,
     *      강사님 깃허브 원본 코드는 try-catch 없이 scanner.nextInt()로 정수를 바로 입력받고,
     *      버퍼에 남은 엔터(\n)를 처리하기 위해 scanner.nextLine()을 연속 호출하는 방식입니다.
     * 2. ID 존재 여부 검사 로직:
     *    - todoService.getTodoList() 메서드를 호출해 반환받은 List<Todo> 컬렉션을 for문으로 순회합니다.
     *    - 각 Todo 객체의 getId() 메서드를 호출하여 입력받은 todoId와 같은지 확인하고, 일치하면 foundStatus = true로 변경합니다.
     *    - 목록에 없는 번호일 경우(!foundStatus) "선택하신 TODO ID의 정보가 존재하지 않습니다."를 출력하고 return합니다.
     *    - 존재하는 번호라면 selectedTodoId 변수에 todoId를 저장합니다.
     */
    private void selectedTodo() {
        int todoId;
        printTodoList();
        System.out.print("todoId 선택 >>> ");
        todoId = scanner.nextInt();
        scanner.nextLine();
        List<Todo> todos = todoService.getTodoList();
        boolean foundStatus = false;
        for (Todo todo : todos) {
            if (todo.getId() == todoId) {
                foundStatus = true;
            }
        }

        if (!foundStatus) {
            System.out.println("선택하신 TODO ID의 정보가 존재하지 않습니다.");
            return;
        }

        selectedTodoId = todoId;
    }

    /*
     * [강사님 깃허브 원본 복구 및 변경점: showSelectList()]
     * 1. 메뉴 안내 문구 원본 복구:
     *    - 강사님 원본 형태인 "1: TODO 선택하기", "2: 진행전으로 변경", "3: 진행중으로 변경", "4: 완료로 변경", "b: 뒤로가기"로 일치시켰습니다.
     * 2. 빈 분기 처리 유지:
     *    - 강사님 깃허브 진도 기준 1, 2, 3, 4번 분기는 아직 구현되지 않은 빈 블록({}) 상태입니다.
     *    - 이전 코드에서 임의로 추가했던 modificationStatus() 메서드와 호출 코드를 강사님 원본에 맞추어 완전히 제거했습니다.
     * 3. 뒤로가기 분기:
     *    - "b".equals(cmd) 입력 시 RootRouter.setCurrent("todo-list") 메서드를 호출하여 화면 전환을 수행합니다.
     */
    private void showSelectList() {
        String cmd;
        System.out.println("1: TODO 선택하기");
        System.out.println("2: 진행전으로 변경");
        System.out.println("3: 진행중으로 변경");
        System.out.println("4: 완료로 변경");
        System.out.println("b: 뒤로가기");
        System.out.print(">>> ");
        cmd = scanner.nextLine();
        if ("1".equals(cmd)) {

        } else if ("2".equals(cmd)) {

        } else if ("3".equals(cmd)) {

        } else if ("4".equals(cmd)) {

        } else if ("b".equals(cmd)) {
            RootRouter.setCurrent("todo-list");
        } else {
            System.out.println("다시 입력하세요.");
        }
    }
}