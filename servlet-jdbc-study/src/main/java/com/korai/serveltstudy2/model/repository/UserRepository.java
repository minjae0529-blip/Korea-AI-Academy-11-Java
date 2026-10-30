package com.korai.serveltstudy2.model.repository;

import com.korai.serveltstudy2.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    private static UserRepository instance;
    private List<User> users;
    private int lastId;

    private UserRepository() {
        lastId = 1;
        users = new ArrayList<>();
    }

    public static UserRepository getInstance() {
        if (instance == null) {
            instance = new UserRepository();
        }
        return instance;
    }

    public void insert(User user) {
        user.setId(lastId++);
        users.add(user);
    }

    public User findByUserName(String username) {
        //for, list에서 username이 동일하면 리턴으로 그 찾은 유저 리턴
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUsername().equals(username)) {
                return users.get(i);
            }
        }
        return null;
    }

    public User findByUserId(int userId){
        for(int i = 0; i < users.size(); i++){
            if(users.get(i).getId() == userId){
                return users.get(i);
            }
        }
        return null;
    }

    //동일한 유저 객체를 밖으로 꺼내 쓰면, 리스트에 있는 유저가 변경될 수도 있음
    //
    public List<User> findAll(){
        return users.stream().map(user -> new User(user)).toList();
    }

}
