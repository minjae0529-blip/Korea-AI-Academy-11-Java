package com.korai.ch10.TODO.view;

import com.korai.ch10.TODO.router.RootRouter;
import com.korai.ch10.TODO.service.TodoService;

import java.util.Scanner;

public class TodoRegisterView implements View {

    /*
     * [선언 이유: private final TodoService todoService]
     * - 이 클래스(TodoRegisterView) 안에서 TodoService 클래스가 가지고 있는 register() 메서드를 호출하여
     *   새로운 할 일을 비즈니스 로직 및 저장소에 등록하기 위해 선언한 참조 변수입니다.
     * - final을 붙여 한 번 주입된 객체 주소가 변경되지 않도록 보호합니다.
     */
    private final TodoService todoService;
    private Scanner scanner;

    /*
     * [작성 이유: 생성자 의존성 주입]
     * - 외부(RootRouter)에서 생성된 TodoService 인스턴스를 매개변수로 전달받아 this.todoService에 할당하기 위함입니다.
     */
    public TodoRegisterView(TodoService todoService) {
        this.todoService = todoService;
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void show() {
        String content;
        System.out.println("[ 할 일 등록하기 ]");
        System.out.print("내용 : ");

        /*
         * [작성 이유: scanner.nextLine()]
         * - Scanner 객체의 nextLine() 메서드를 호출하여 사용자가 콘솔에 입력한 공백(스페이스)을 포함한
         *   한 줄 전체 문자열을 읽어와 content 변수에 대입합니다.
         */
        content = scanner.nextLine();

        /*
         * [작성 이유: todoService.register(content)]
         * - todoService 객체의 register(content) 메서드를 호출하여,
         *   현재 세션의 유저 정보 파싱, Todo 객체 인스턴스화, 저장소(TodoRepository) insert를 수행하도록 위임합니다.
         */
        todoService.register(content);

        /*
         * [작성 이유: RootRouter.setCurrent("todo-list")]
         * - 등록이 완료되었으므로, 사용자가 방금 등록한 항목을 목록에서 즉시 확인할 수 있도록
         *   RootRouter의 current 경로 변수를 "todo-list"로 변경합니다.
         */
        RootRouter.setCurrent("todo-list");
    }

}
