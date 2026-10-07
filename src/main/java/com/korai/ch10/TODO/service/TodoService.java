package com.korai.ch10.TODO.service;

import com.korai.ch10.TODO.config.SecurityConfig;
import com.korai.ch10.TODO.entity.Todo;
import com.korai.ch10.TODO.entity.TodoStatus;
import com.korai.ch10.TODO.entity.User;
import com.korai.ch10.TODO.repository.TodoRepository;
import com.korai.ch10.TODO.repository.UserRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

/*
 * [어노테이션 작성 이유: @RequiredArgsConstructor]
 * - Lombok 라이브러리가 제공하는 기능으로, 아래에 'final'로 선언된 필드들(todoRepository, userRepository)을
 *   매개변수로 받는 생성자를 컴파일할 때 자동으로 만들어 줍니다.
 * - 즉, 개발자가 손으로 생성자를 직접 치지 않아도 의존성 주입(DI) 코드가 완성됩니다.
 */
@RequiredArgsConstructor
public class TodoService {

    /*
     * [선언 이유: private final TodoRepository todoRepository]
     * - 이 클래스(TodoService)에서 TodoRepository 객체가 가지고 있는
     *   insert(), findAllByUserId(), updateStatus() 메서드를 호출하기 위해 선언한 것입니다.
     * - final을 붙인 이유: 한 번 생성자에서 객체 주소를 주입받은 뒤, 프로그램 도중에 이 참조 변수가
     *   다른 객체로 바뀌거나 null이 되지 않도록 불변성(Immutability)을 보장하기 위함입니다.
     */
    private final TodoRepository todoRepository;

    /*
     * [선언 이유: private final UserRepository userRepository]
     * - 할 일을 등록할 때, 현재 로그인한 사람의 User 엔티티 객체가 필요하므로
     *   UserRepository 객체의 findById() 메서드를 호출하기 위해 선언한 것입니다.
     */
    private final UserRepository userRepository;

    /*
     * [작성 이유: public List<Todo> getTodoList()]
     * - 1. SecurityConfig.getUserId() 메서드를 호출하여 현재 로그인된 유저의 id(int) 숫자를 얻어옵니다.
     * - 2. todoRepository 객체의 findAllByUserId(userId) 메서드를 호출하여 해당 유저가 작성한 Todo 리스트만 필터링해서 받아옵니다.
     * - 3. 받아온 List<Todo> 데이터를 화면(TodoListView)에 그대로 반환하여 출력할 수 있게 하기 위함입니다.
     */
    public List<Todo> getTodoList() {
        return todoRepository.findAllByUserId(SecurityConfig.getUserId());
    }

    /*
     * [작성 이유: public void register(String content)]
     * - 1. SecurityConfig.getUserId() 메서드로 로그인된 사용자의 고유 id 값을 가져옵니다.
     * - 2. userRepository.findById(userId) 메서드를 호출하여 실제 User 엔티티 객체를 조회합니다.
     * - 3. new Todo(0, TodoStatus.todo, content, foundUser)를 실행하여 할 일 객체 인스턴스를 메모리에 생성합니다.
     *      (초기 상태는 TodoStatus.todo인 '진행전'으로 세팅)
     * - 4. todoRepository.insert(todo) 메서드를 호출하여 생성된 Todo 객체를 메모리 리스트에 저장하도록 넘겨줍니다.
     */
    public void register(String content) {
        User foundUser = userRepository.findById(SecurityConfig.getUserId());
        Todo todo = new Todo(0, TodoStatus.todo, content, foundUser);
        todoRepository.insert(todo);
    }

    /*
     * [작성 이유: public void updateStatus(int todoId, TodoStatus todoStatus)]
     * - 화면(TodoStatusView)에서 넘겨받은 할 일 번호(todoId)와 변경할 상태(todoStatus)를
     *   todoRepository 객체의 updateStatus() 메서드에 전달하여 저장소 내부의 Todo 상태값을 실제로 변경하기 위함입니다.
     */
    public void updateStatus(int todoId, TodoStatus todoStatus) {
        todoRepository.updateStatus(todoId, todoStatus);
    }

}
