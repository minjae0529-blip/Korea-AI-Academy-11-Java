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
 * - final로 선언된 멤버 변수(todoRepository, userRepository)를 매개변수로 받는
 *   생성자를 자동으로 생성해 주는 Lombok 어노테이션입니다.
 */
@RequiredArgsConstructor
public class TodoService {

    /*
     * [선언 이유: private final TodoRepository todoRepository]
     * - TodoRepository 클래스가 가지고 있는 findAllByUserId(), insert() 메서드를
     *   호출하기 위해 선언한 참조 변수입니다.
     */
    private final TodoRepository todoRepository;

    /*
     * [선언 이유: private final UserRepository userRepository]
     * - UserRepository 클래스가 가지고 있는 findById() 메서드를 호출하여
     *   현재 로그인한 사용자(User 객체) 정보를 조회하기 위해 선언한 참조 변수입니다.
     */
    private final UserRepository userRepository;

    /*
     * [메서드 설명: public List<Todo> getTodoList()]
     * - SecurityConfig.getUserId() 메서드로 로그인된 사용자의 ID를 얻어온 뒤,
     *   todoRepository 객체의 findAllByUserId(userId) 메서드를 호출하여 해당 사용자의 할 일 목록을 반환받습니다.
     */
    public List<Todo> getTodoList() {
        return todoRepository.findAllByUserId(SecurityConfig.getUserId());
    }

    /*
     * [메서드 설명: public void register(String content)]
     * 1. userRepository.findById(SecurityConfig.getUserId())를 호출하여 작성자 User 객체를 조회합니다.
     * 2. 조회된 User 객체와 입력받은 본문(content), 기본 상태(TodoStatus.todo)를 담아 새로운 Todo 객체를 생성합니다.
     * 3. todoRepository 객체의 insert(todo) 메서드를 호출하여 저장소 리스트에 추가합니다.
     */
    public void register(String content) {
        User foundUser = userRepository.findById(SecurityConfig.getUserId());
        Todo todo = new Todo(0, TodoStatus.todo, content, foundUser);
        todoRepository.insert(todo);
    }

    /*
     * [강사님 깃허브 원본 복구 및 변경점]
     * - 이전 코드에서 임의로 추가되었던 updateStatus(int todoId, TodoStatus todoStatus) 메서드는
     *   강사님 깃허브 원본 리포지토리에 아직 작성되지 않은 코드이므로 강사님 원본에 맞추어 제거했습니다.
     */
}
