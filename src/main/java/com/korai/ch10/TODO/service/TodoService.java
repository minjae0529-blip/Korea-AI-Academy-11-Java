package com.korai.ch10.TODO.service;

import com.korai.ch10.TODO.config.SecurityConfig;
import com.korai.ch10.TODO.entity.Todo;
import com.korai.ch10.TODO.entity.TodoStatus;
import com.korai.ch10.TODO.entity.User;
import com.korai.ch10.TODO.repository.TodoRepository;
import com.korai.ch10.TODO.repository.UserRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

import static com.korai.ch10.TODO.config.SecurityConfig.generateSessionToken;
import static com.korai.ch10.TODO.config.SecurityConfig.getLoginSession;

@RequiredArgsConstructor
public class TodoService {
    private final TodoRepository todoRepository;
    private final UserRepository userRepository;

    public List<Todo> getTodoList(){

        return todoRepository.findAllByUserId(SecurityConfig.getUserId());
    }

    public void register(String content) {
        User foundUser = userRepository.findById(SecurityConfig.getUserId());   // 로그인한 사용자 조회
        Todo todo = new Todo(0, TodoStatus.todo, content, foundUser);
        todoRepository.insert(todo);
    }

    public void updateStatus(int todoId, TodoStatus todoStatus){
        todoRepository.updateStatus(todoId, todoStatus);
    }

}
