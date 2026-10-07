package com.korai.ch10.TODO.repository;

import com.korai.ch10.TODO.entity.Todo;
import com.korai.ch10.TODO.entity.TodoStatus;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class TodoRepository {

    /*
     * [선언 이유: private int autoIncrement = 1]
     * - 새로 등록되는 Todo 객체에 고유한 번호(id)를 1부터 1씩 증가시키며 부여하기 위한 정수형 카운터 변수입니다.
     */
    private int autoIncrement = 1;

    /*
     * [선언 이유: @Getter private List<Todo> todos]
     * - 생성된 Todo 객체 인스턴스들을 메모리(Heap) 상에 차곡차곡 보관해 둘 컬렉션(List) 참조 변수입니다.
     * - @Getter를 필드에만 붙인 이유: autoIncrement 변수는 외부에 노출하지 않고, 오직 todos 리스트만 외부에 조회할 수 있게 getter 메서드(getTodos())를 자동 생성하기 위함입니다.
     */
    @Getter
    private List<Todo> todos;

    /*
     * [작성 이유: 생성자 TodoRepository()]
     * - Repository 객체가 new로 생성되는 시점에, todos 변수에 실제 객체인 new ArrayList<>() 인스턴스를 할당하여
     *   NullPointerException이 발생하지 않고 메모리가 준비되도록 초기화하기 위함입니다.
     */
    public TodoRepository() {
        todos = new ArrayList<>();
    }

    /*
     * [작성 이유: public void insert(Todo todo)]
     * - 매개변수로 전달받은 todo 객체의 setId() 메서드를 호출하여 현재 autoIncrement 값을 세팅하고,
     *   후위 증가 연산자(++)로 다음 저장을 위해 카운터를 1 올립니다.
     * - 그 후 todos.add(todo)를 실행하여 리스트에 Todo 인스턴스를 추가(저장)합니다.
     */
    public void insert(Todo todo) {
        todo.setId(autoIncrement++);
        todos.add(todo);
    }

    /*
     * [작성 이유: public List<Todo> findAllByUserId(int userId)]
     * - todos 리스트에 들어있는 모든 Todo 객체를 순회(for-each)하면서,
     *   todo.getUser().getId() 메서드로 꺼낸 작성자의 회원 번호가 매개변수 userId와 같은지 비교합니다.
     * - 일치하는 Todo 객체들만 filteredTodos 리스트에 add()하여, 해당 유저의 할 일 목록만 묶어서 반환하기 위함입니다.
     */
    public List<Todo> findAllByUserId(int userId) {
        List<Todo> filteredTodos = new ArrayList<>();
        for (Todo todo : todos) {
            if (todo.getUser().getId() == userId) {
                filteredTodos.add(todo);
            }
        }
        return filteredTodos;
    }

    /*
     * [작성 이유: public void updateStatus(int todoId, TodoStatus todoStatus)]
     * - todos 리스트를 순회하며 todo.getId()가 매개변수로 넘어온 todoId와 일치하는 Todo 객체를 찾습니다.
     * - 찾은 객체의 setStatus(todoStatus) 메서드를 호출하여 상태 필드값을 변경하고,
     *   더 이상 순회할 필요가 없으므로 break로 반복문을 탈출합니다.
     */
    public void updateStatus(int todoId, TodoStatus todoStatus) {
        for (Todo todo : todos) {
            if (todo.getId() == todoId) {
                todo.setStatus(todoStatus);
                break;
            }
        }
    }
}