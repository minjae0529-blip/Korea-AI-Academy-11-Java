package com.korai.ch10.TODO.repository;

import com.korai.ch10.TODO.entity.Todo;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class TodoRepository {

    /*
     * [선언 이유: private int autoIncrement = 1]
     * - 저장소에 Todo 객체가 추가될 때마다 고유한 id 번호를 1부터 1씩 증가시키며 부여하기 위한 정수 변수입니다.
     */
    private int autoIncrement = 1;

    /*
     * [선언 이유: @Getter private List<Todo> todos]
     * - 메모리(List) 상에 생성된 Todo 인스턴스들을 보관하기 위한 컬렉션 참조 변수입니다.
     * - Lombok의 @Getter 어노테이션으로 getTodos() 메서드가 자동 생성됩니다.
     */
    @Getter
    private List<Todo> todos;

    public TodoRepository() {
        todos = new ArrayList<>();
    }

    /*
     * [메서드 설명: public void insert(Todo todo)]
     * - 매개변수로 전달받은 todo 객체의 setId()를 호출하여 autoIncrement 값을 주입하고,
     *   todos.add(todo)를 호출하여 리스트에 저장합니다.
     */
    public void insert(Todo todo) {
        todo.setId(autoIncrement++);
        todos.add(todo);
    }

    /*
     * [강사님 깃허브 원본 복구 및 변경점: findAllByUserId(int userId)]
     * 1. 변수명 및 반복문 방식:
     *    - 강사님 원본 변수명인 filteringTodos로 복구했습니다.
     *    - 강사님 원본 코드와 동일하게 인덱스 기반 for문(int i = 0; i < todos.size(); i++)으로 순회하며
     *      각 Todo의 작성자 ID(todos.get(i).getUser().getId())와 조회 대상 userId를 비교합니다.
     * 2. 빈 결과 반환값:
     *    - 일치하는 할 일이 없으면(filteringTodos.size() == 0) null을 반환합니다.
     *    - 일치하는 목록이 존재할 때만 filteringTodos 리스트를 반환합니다.
     */
    public List<Todo> findAllByUserId(int userId) {
        List<Todo> filteringTodos = new ArrayList<>();
        for (int i = 0; i < todos.size(); i++) {
            if (todos.get(i).getUser().getId() == userId) {
                filteringTodos.add(todos.get(i));
            }
        }
        if (filteringTodos.size() == 0) {
            return null;
        }
        return filteringTodos;
    }

    /*
     * [강사님 깃허브 원본 복구 및 변경점]
     * - 이전 코드에서 임의로 추가되었던 updateStatus(int todoId, TodoStatus todoStatus) 메서드는
     *   강사님 깃허브 원본 리포지토리에 없는 코드이므로 강사님 원본에 맞추어 완전 제거했습니다.
     */
}