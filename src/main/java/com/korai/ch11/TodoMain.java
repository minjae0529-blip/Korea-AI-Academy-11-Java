package com.korai.ch11;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class TodoMain {
    public static int pathIndex = 0;
    public static boolean running = true;

    public static void main(String[] args) {
        //싱글톤
        List<View> viewList = new ArrayList<>();        //viewList라는 리스트명이 있고, View라는 자료형(인터페이스)안에 값이 저장
        viewList.add(HomeView.getHomeView());                //하나의 객체를 계속 돌리면서 사용하는거임 (유일한 1개의 객체) -> 외부에서 new 막음
        viewList.add(RegisterView.getRegisterView());               //WHY new를 사용하는지 : 인스턴스만을 list가 담을수있기때문에 new로 인스턴스 생성
        viewList.add(ListView.getListView());

//        viewList.get(0).show(); = get(0) = 0번째 리스트에 있는 녀석을 꺼내와(그게 HomeView) 거기에 있는 show() 메서드 실행해
        Scanner scanner = new Scanner(System.in);

        while (running) {
            viewList.get(pathIndex).show();
        }
    }
}

//정보를 관리할 수 있도록 도와주는 엔티티 / 정보를 저장하는 틀로 사용
//엔티티 = model, view, controller / mvc
// Object 클래스
@Data
@NoArgsConstructor
@AllArgsConstructor
class Todo {
    private int id;
    private String content;
}

//기능을 추상화 할 때 사용
//인터페이스러 기늘을 추상화를 했으면 구현 객체는 무조건 존재함
interface View {
    void show();
}

//클래스는 생성이 가능해야 합니다 = 메모리에 인스턴스를 실존하게 하는 것
//구현 : 중괄호 여닫히고 메서드가 정의되어있는것.
class HomeView implements View {

    //싱글톤 2번 : 해당 클래스 자료형의 인스턴스를 담아둘 변수를 static 변수를 정의한다
    //private으로 외부 접근제한
    private static HomeView instance;

    //private 접근제한자 : 해당 클래스 내부에서만 접근 가능함
    //싱글톤 규칙 : 1. 생성자는 private으로 정의함. 2. 생성자를 숨겼다는것은 외부에서 생성을 제한하기 위함
    //싱글톤 : 하나의 규칙을 생성
    private HomeView() {

    }

    //싱글톤 3번 : static 변수 instance가 null일 때 인스턴스를 생성
    //static getter를 통해서만 instance를 접근할 수 있게 유도
    public static HomeView getHomeView() {
        while (instance == null) {
            instance = new HomeView();
        }
        return instance;
    }

    @Override
    public void show() {
        Scanner scanner = new Scanner(System.in);
        String menu;
        System.out.println("[ HOME ]");
        System.out.println("R. TODO 등록하기");
        System.out.println("L. TODO 목록조회");
        System.out.println("Q. 프로그램 종료");
        System.out.print(">>>");
        menu = scanner.nextLine().trim();
        menu = String.valueOf(menu.charAt(0));

        System.out.println(String.valueOf(menu.matches("[a-zA-Z]")));
        boolean isAlphabet = menu.matches("[a-zA-Z]");  //정규 표현식
        if (!isAlphabet) {
            System.out.println("영문자만 입력 가능합니다");
            return;
        }

        menu = menu.toUpperCase(); // 대문자로 바꿔주는 행위
        if ("Q".equals(menu)) {
            TodoMain.running = false;
        } else if ("R".equals(menu)) {
            TodoMain.pathIndex = 1;
        } else if ("L".equals(menu)) {
            TodoMain.pathIndex = 2;
        } else {
            System.out.println("다시 입력하세요");
        }
    }
}

class RegisterView implements View {
    public static RegisterView getRegisterView() {
        while (instance == null) {
            instance = new RegisterView();
        }
        return instance;
    }

    private static RegisterView instance;

    private RegisterView() {

    }

    @Override
    public void show() {
        Scanner scanner = new Scanner(System.in);
        String content;
        System.out.println("[ REGISTER ]");
        System.out.println("내용을 입력하세요 : ");
        System.out.print(">>>");
        content = scanner.nextLine().trim();
        Todo newTodo = new Todo();
        newTodo.setContent(content);    //NoArgsConstructor로 setter를 통해 값을 기입
        TodoRepository.getInstance().insert(newTodo);
        System.out.println("TODO 등록 완료");
        TodoMain.pathIndex = 0;
    }
}

class ListView implements View {
    public static ListView getListView() {
        while (instance == null) {
            instance = new ListView();
        }
        return instance;
    }

    private static ListView instance;

    private ListView() {
    }

    @Override
    public void show() {
        System.out.println("[ LIST ]");
        List<Todo> todos = TodoRepository.getInstance().findAll();
        if(todos.size() == 0){
            System.out.println("등록된 TODO가 없습니다");
            TodoMain.pathIndex = 0;
            return;
        }
        for(Todo todo : todos){
            System.out.println(todo);
        }
        TodoMain.pathIndex = 0;
    }
}

interface Repository<T> {
    void insert(T t);

    void update(T t);

    T delete(int id);

    T findById(int id);

    List<T> findAll();
}

class TodoRepository implements Repository<Todo> {

    private static TodoRepository instance;
    private int lastId;
    private List<Todo> todos;

    private TodoRepository() {
        lastId = 1;
        todos = new ArrayList<>();
    }

    public static TodoRepository getInstance() {
        if (instance == null) {
            instance = new TodoRepository();
        }
        return instance;
    }

    @Override
    public List<Todo> findAll() {
        List<Todo> copyTodos = new ArrayList<>();   //원본 주소를 넘겨주게 되면, 내부 값들을 변경할 수 있기에 카피해서 보내주는거임
        copyTodos.addAll(todos);
        return copyTodos;
    }

    @Override
    public Todo findById(int id) {
        for (int i = 0; i < todos.size(); i++) {
            if (todos.get(i).getId() == id) {
                return todos.get(i);
            }
        }
        return null;
    }

    @Override
    public Todo delete(int id) {
        for (int i = 0; i < todos.size(); i++) {
            if (todos.get(i).getId() == id) {
                return todos.remove(i);
            }
        }
        return null;
    }

    @Override
    public void insert(Todo todo) {
        todo.setId(lastId++);
        todos.add(todo);
    }

    @Override
    public void update(Todo todo) {
        for (int i = 0; i < todos.size(); i++) {
            if (todos.get(i).getId() == todo.getId()) {
                todos.set(i, todo);
                break;
            }
        }
    }
}