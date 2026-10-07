package com.korai.ch10.TODO.service;

import com.korai.ch10.TODO.config.SecurityConfig;
import com.korai.ch10.TODO.entity.User;
import com.korai.ch10.TODO.repository.UserRepository;
import lombok.RequiredArgsConstructor;

import java.util.Objects;

/*
 * [어노테이션 작성 이유: @RequiredArgsConstructor]
 * - final로 선언된 필드(userRepository)를 매개변수로 받는 생성자(public UserService(UserRepository userRepository))를
 *   Lombok이 자동으로 생성하여 의존성 주입(DI) 코드를 간결하게 만들기 위함입니다.
 */
@RequiredArgsConstructor
public class UserService {

    /*
     * [선언 이유: private final UserRepository userRepository]
     * - 이 클래스(UserService)에서 UserRepository 객체의 findByUsername() 메서드를 호출하여
     *   DB(저장소)에 저장된 사용자 엔티티를 조회하기 위해 선언한 참조 변수입니다.
     * - final을 붙여서 객체 참조의 불변성을 보장합니다.
     */
    private final UserRepository userRepository;

    /*
     * [작성 이유: public String login(String username, String password)]
     * - 로그인 비즈니스 로직을 처리하는 메서드입니다.
     * - 반환 타입이 String인 이유: 성공 시 SecurityConfig에서 발급한 세션 토큰 문자열을 반환하고, 실패 시 null을 반환하기 때문입니다.
     */
    public String login(String username, String password) {

        /*
         * [작성 이유: userRepository.findByUsername(username)]
         * - UserRepository 객체의 findByUsername() 메서드를 호출하여,
         *   사용자가 입력한 아이디와 동일한 username 필드값을 가진 User 인스턴스를 찾습니다.
         * - 일치하는 회원이 없으면 null이 반환되므로, if (foundUser == null)로 즉시 실패(return null) 처리합니다.
         */
        User foundUser = userRepository.findByUsername(username);
        if (foundUser == null) {
            return null;
        }

        /*
         * [작성 이유: Objects.equals(foundUser.getPassword(), password)]
         * - foundUser 객체의 getPassword() 메서드로 꺼낸 저장된 비밀번호와, 입력받은 password 문자열이 같은지 비교합니다.
         * - java.util.Objects.equals()를 쓴 이유: 혹시 저장된 비밀번호가 null이더라도 NullPointerException 예외가 터지지 않고 안전하게 false를 반환하기 때문입니다.
         * - 비밀번호가 일치하지 않으면(!) 즉시 실패(return null) 처리합니다.
         */
        if (!Objects.equals(foundUser.getPassword(), password)) {
            return null;
        }

        /*
         * [작성 이유: SecurityConfig.generateSessionToken(foundUser)]
         * - 아이디와 비밀번호가 모두 맞았으므로, SecurityConfig 클래스의 static 메서드인 generateSessionToken()을 호출하여
         *   해당 User 객체의 정보가 들어간 32자리 UUID@userId 형태의 토큰 문자열을 발급받아 반환합니다.
         */
        return SecurityConfig.generateSessionToken(foundUser);
    }
}
