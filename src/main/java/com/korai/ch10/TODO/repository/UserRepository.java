package com.korai.ch10.TODO.repository;

import com.korai.ch10.TODO.entity.User;

import java.util.List;
import java.util.Objects;   // 추가

public class UserRepository {

    private List<User> users;

    public UserRepository() {
        User user1 = new User(1, "test1", "1q2w3e4r!", "강민재1");
        User user2 = new User(2, "test2", "1q2w3e4r!", "강민재2");
        User user3 = new User(3, "test3", "1q2w3e4r!", "강민재3");
        User user4 = new User(4, "test4", "1q2w3e4r!", "강민재4");
        users = List.of(user1, user2, user3, user4);
    }

    public User findByUsername(String username) {
        for (User user : users) {
            if (Objects.equals(user.getUsername(), username)) {   // Object → Objects
                return user;
            }
        }
        return null;
    }
    //id로찾는거
    public User findById(int id) {
        for (User user : users) {
            if (user.getId() == id) {   // Object → Objects
                return user;
            }
        }
        return null;
    }
}