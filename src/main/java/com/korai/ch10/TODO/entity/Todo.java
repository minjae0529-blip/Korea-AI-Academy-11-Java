package com.korai.ch10.TODO.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/*
 * [어노테이션 작성 이유]
 * - @Data : Getter, Setter, toString, equals, hashCode 메서드를 컴파일 시점에 자동 생성하기 위함입니다.
 * - @AllArgsConstructor : 모든 필드(id, status, content, user)를 매개변수로 받는 생성자를 자동 생성하기 위함입니다.
 */
@Data
@AllArgsConstructor
public class Todo {

    /*
     * [선언 이유: private int id]
     * - 각 Todo 인스턴스를 고유하게 식별하기 위한 정수형 기본키(Primary Key) 필드입니다.
     */
    private int id;

    /*
     * [선언 이유: private TodoStatus status = TodoStatus.todo]
     * - 할 일의 상태를 표현하기 위해 TodoStatus enum 타입으로 선언했습니다.
     * - 문자열 대신 enum 타입을 쓴 이유: 컴파일러가 허용된 3가지 상태(todo, inProgress, done) 외의 잘못된 값이 들어오는 것을 막아 타입 안정성을 보장하기 때문입니다.
     * - 기본값을 TodoStatus.todo로 준 이유: 새로 등록되는 할 일의 초기 상태를 '진행전'으로 기본 지정하기 위함입니다.
     */
    private TodoStatus status = TodoStatus.todo;

    /*
     * [선언 이유: private String content]
     * - 사용자가 입력한 할 일 본문 문자열을 저장하는 필드입니다.
     */
    private String content;

    /*
     * [선언 이유: private User user (객체 참조 연관관계)]
     * - 단순 숫자(int userId) 대신, 이 할 일을 작성한 User 클래스의 객체 주소(인스턴스 참조)를 직접 저장하는 필드입니다.
     * - 이렇게 객체 자체를 참조하면 todo.getUser().getName() 처럼 객체 그래프 탐색을 통해 작성자의 세부 정보를 바로 꺼내 쓸 수 있습니다.
     */
    private User user;

}
