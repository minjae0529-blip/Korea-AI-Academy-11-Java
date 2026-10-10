package com.korai.ch10.TODO.service;

import com.korai.ch10.TODO.config.SecurityConfig;
import com.korai.ch10.TODO.entity.User;
import com.korai.ch10.TODO.repository.UserRepository;
import lombok.RequiredArgsConstructor;

import java.util.Objects;

/*
 * [어노테이션 작성 이유: @RequiredArgsConstructor]
 * - final로 선언된 멤버 변수(userRepository)를 매개변수로 받는 생성자를
 *   Lombok이 컴파일 시점에 자동으로 생성합니다.
 */
@RequiredArgsConstructor
public class UserService {

    /*
     * [선언 이유: private final UserRepository userRepository]
     * - UserRepository 클래스가 가지고 있는 findByUsername() 메서드를 호출하여
     *   사용자 정보를 조회하기 위해 선언한 참조 변수입니다.
     */
    private final UserRepository userRepository;

    /*
     * [메서드 설명: public String login(String username, String password)]
     * 1. userRepository.findByUsername(username) 메서드를 호출하여 해당 아이디의 User 객체를 조회합니다.
     * 2. 사용자가 존재하지 않거나(foundUser == null) 비밀번호가 일치하지 않으면(!Objects.equals(...)) null을 반환합니다.
     * 3. 인증이 성공하면 SecurityConfig.generateSessionToken(foundUser)를 호출하여 세션 토큰 문자열을 반환합니다.
     */
    public String login(String username, String password) {
        User foundUser = userRepository.findByUsername(username);
        if (foundUser == null) {
            return null;
        }
        if (!Objects.equals(foundUser.getPassword(), password)) {
            return null;
        }
        return SecurityConfig.generateSessionToken(foundUser);
    }
}
