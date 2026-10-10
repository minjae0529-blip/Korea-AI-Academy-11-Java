package com.korai.ch10.TODO.repository;

import com.korai.ch10.TODO.entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class UserRepository {

    /*
     * [선언 이유: private List<User> users]
     * - 등록된 사용자(User 객체) 목록을 메모리에 보관하기 위한 컬렉션 참조 변수입니다.
     */
    private List<User> users;

    /*
     * [강사님 깃허브 원본 복구: 생성자 테스트 데이터]
     * - 강사님 원본 테스트 데이터인 "김준일", "김준이", "김준삼", "김준사"로 복구했습니다.
     * - List.of() 메서드로 불변 리스트를 생성하여 users 변수에 대입합니다.
     */
    public UserRepository() {
        User user1 = new User(1, "test1", "1q2w3e4r!", "김준일");
        User user2 = new User(2, "test2", "1q2w3e4r!", "김준이");
        User user3 = new User(3, "test3", "1q2w3e4r!", "김준삼");
        User user4 = new User(4, "test4", "1q2w3e4r!", "김준사");
        users = List.of(user1, user2, user3, user4);
    }

    /*
     * [메서드 설명: public User findByUsername(String username)]
     * - users 리스트를 for-each문으로 순회하며, Objects.equals(user.getUsername(), username)으로
     *   일치하는 아이디를 가진 User 객체를 찾아 반환합니다. 일치하는 사용자가 없으면 null을 반환합니다.
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
     * [메서드 설명: public User findById(int id)]
     * - users 리스트를 순회하며 user.getId() == id인 User 인스턴스를 찾아 반환합니다.
     *   일치하는 객체가 없으면 null을 반환합니다.
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