package com.korai.ch10.TODO.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/*
 * [어노테이션 작성 이유]
 * - @Data : Getter, Setter, toString(), equals(), hashCode() 메서드를 자동 생성합니다.
 * - @AllArgsConstructor : 모든 필드(id, status, content, user)를 매개변수로 받는 생성자를 자동 생성합니다.
 */
@Data
@AllArgsConstructor
public class Todo {

    /*
     * [선언 이유: private int id]
     * - 각 할 일 객체를 식별하기 위한 고유한 정수형 ID 번호 필드입니다.
     */
    private int id;

    /*
     * [강사님 깃허브 원본 복구 및 선언 이유: private TodoStatus status]
     * - 할 일의 상태를 고정된 열거형(TodoStatus.todo, inProgress, done)으로 관리하기 위한 필드입니다.
     * - 강사님 원본 코드와 동일하게 필드 선언 시 기본값 대입 없이 선언되어 있습니다.
     */
    private TodoStatus status;

    /*
     * [선언 이유: private String content]
     * - 할 일의 본문 내용 문자열을 저장하는 필드입니다.
     */
    private String content;

    /*
     * [선언 이유: private User user]
     * - 해당 할 일을 작성한 사용자 정보를 담고 있는 User 객체 참조 필드입니다.
     */
    private User user;
}
