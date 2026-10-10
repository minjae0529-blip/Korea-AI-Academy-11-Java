package com.korai.ch10.TODO.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/*
 * [어노테이션 작성 이유]
 * - @Data : id, username, password, name에 대한 Getter, Setter 및 toString(), equals(), hashCode() 메서드를 자동 생성합니다.
 * - @AllArgsConstructor : 4개 필드 전체를 매개변수로 받아 초기화하는 생성자를 자동 생성합니다.
 */
@Data
@AllArgsConstructor
public class User {

    /*
     * [선언 이유: private int id]
     * - 각 사용자를 고유하게 식별하기 위한 정수형 ID(식별자) 필드입니다.
     */
    private int id;

    /*
     * [선언 이유: private String username]
     * - 로그인 시 사용할 사용자 계정 아이디 문자열 필드입니다.
     */
    private String username;

    /*
     * [선언 이유: private String password]
     * - 로그인 인증 검사에 사용할 비밀번호 문자열 필드입니다.
     */
    private String password;

    /*
     * [선언 이유: private String name]
     * - 사용자의 실제 이름 문자열 필드입니다.
     */
    private String name;
}
