package com.korai.ch10.TODO.view;

import com.korai.ch10.TODO.router.RootRouter;
import com.korai.ch10.TODO.service.TodoService;

import java.util.Scanner;

public class TodoRegisterView implements View {

    /*
     * [선언 이유: private final TodoService todoService]
     * - TodoService 클래스가 가지고 있는 register(content) 메서드를 호출하여
     *   새로운 할 일을 등록하기 위해 선언한 참조 변수입니다.
     */
    private final TodoService todoService;

    /*
     * [선언 이유: private Scanner scanner]
     * - 콘솔에서 사용자가 입력하는 할 일 본문 내용(nextLine)을 입력받기 위한 참조 변수입니다.
     */
    private Scanner scanner;

    public TodoRegisterView(TodoService todoService) {
        this.todoService = todoService;
        scanner = new Scanner(System.in);
    }

    /*
     * [강사님 깃허브 원본 복구 및 설명: show()]
     * 1. scanner.nextLine()으로 사용자가 입력한 할 일 내용 문자열(content)을 받습니다.
     * 2. todoService 객체의 register(content) 메서드를 호출하여 등록 작업을 위임합니다.
     * 3. 등록이 완료되면 RootRouter.setCurrent("todo-list")를 호출하여 목록 화면으로 이동합니다.
     */
    @Override
    public void show() {
        String content;
        System.out.println("[ 할 일 등록하기 ]");
        System.out.print("내용: ");
        content = scanner.nextLine();
        todoService.register(content);
        RootRouter.setCurrent("todo-list");
    }

}
