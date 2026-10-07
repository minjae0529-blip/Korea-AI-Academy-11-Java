package com.korai.ch10.TODO.repository;

import com.korai.ch10.TODO.entity.Todo;
import com.korai.ch10.TODO.entity.TodoStatus;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class TodoRepository {
    private int autoIncrement = 1;

    @Getter     // lombok: 이 필드(todos)에만 getter 생성
    private List<Todo> todos;

    public TodoRepository() {
        todos = new ArrayList<>();
    }

    public void insert(Todo todo) {
        todo.setId(autoIncrement++);
        todos.add(todo);
    }

    public List<Todo> findAllByUserId(int userId) {
        List<Todo> filteredTodos = new ArrayList<>();      // 이름 오타 수정 (fillteringTodos)
        for (Todo todo : todos) {                          // 향상된 for문으로 간단하게
            if (todo.getUser().getId() == userId) {
                filteredTodos.add(todo);
            }
        }
        return filteredTodos;                              // 없으면 빈 리스트 (null 아님)
    }

    public void updateStatus(int todoId, TodoStatus todoStatus) {   // todoIdm → todoId
        for (Todo todo : todos) {
            if (todo.getId() == todoId) {
                todo.setStatus(todoStatus);
                break;
            }
        }
    }
}