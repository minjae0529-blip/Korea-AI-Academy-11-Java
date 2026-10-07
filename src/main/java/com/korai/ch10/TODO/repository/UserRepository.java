package com.korai.ch10.TODO.repository;

import com.korai.ch10.TODO.entity.User;

import java.util.List;
import java.util.Objects;

public class UserRepository {

    /*
     * [선언 이유: private List<User> users]
     * - User 엔티티 객체 인스턴스들을 보관해 둘 컬렉션 참조 변수입니다.
     */
    private List<User> users;

    /*
     * [작성 이유: 생성자 UserRepository()]
     * - 실제 데이터베이스 대신 메모리에서 테스트하기 위해 4개의 User 객체를 new로 생성하고,
     *   List.of() 메서드로 불변(Immutable) 리스트를 만들어 users 변수에 할당(초기화)하기 위함입니다.
     */
    public UserRepository() {
        User user1 = new User(1, "test1", "1q2w3e4r!", "강민재1");
        User user2 = new User(2, "test2", "1q2w3e4r!", "강민재2");
        User user3 = new User(3, "test3", "1q2w3e4r!", "강민재3");
        User user4 = new User(4, "test4", "1q2w3e4r!", "강민재4");
        users = List.of(user1, user2, user3, user4);
    }

    /*
     * [작성 이유: public User findByUsername(String username)]
     * - users 리스트의 User 객체들을 for문으로 하나씩 꺼내어,
     *   user.getUsername()의 반환값과 매개변수 username이 일치하는지 Objects.equals()로 비교합니다.
     * - 일치하는 User 인스턴스를 찾으면 즉시 해당 객체 주소를 반환하고, 끝까지 없으면 null을 반환합니다.
     */
    public User findByUsername(String username) {
        for (User user : users) {
            if (Objects.equals(user.getUsername(), username)) {
                return user;
            }
        }
        return null;
    }

    /*
     * [작성 이유: public User findById(int id)]
     * - 토큰에서 추출한 회원 번호(int)와 user.getId() 값이 같은지 기본 자료형 동등 비교(==)를 수행하여,
     *   일치하는 User 객체를 찾아 반환하기 위함입니다.
     */
    public User findById(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }
}