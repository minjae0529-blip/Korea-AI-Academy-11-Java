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

    private void printTodoList(){
        if(todoService.getTodoList() == null){
            System.out.println("등록된 할 일이 없습니다.");
            return;
        }
        //내꺼만 확인할 수 있돌고 필터링이 필요함
        for(Todo todo : todoService.getTodoList()){
            System.out.println(todo);
        }
    }

    //로그인 성공하고 난 뒤 출력 화면 구현
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
