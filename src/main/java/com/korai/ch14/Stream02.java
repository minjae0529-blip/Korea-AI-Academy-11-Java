package com.korai.ch14;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@AllArgsConstructor
@Data
class Role {
    private int id;
    private String name;
}

@AllArgsConstructor
@Data
class User {
    private int id;
    private String userName;
    private List<Role> roles;
}

public class Stream02 {
    public static List<User> generateUsers() {
        List<User> users = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            int num = i + 1;
            User user = new User(num, "user" + num, new ArrayList<>());
            Random random = new Random();
            if (random.nextInt(10) % 2 == 0) {
                user.getRoles().add(new Role(1, "Role_Admin"));
                user.getRoles().add(new Role(2, "Role_User"));
                users.add(user);
                continue;
            }
            user.getRoles().add(new Role(2, "Role_User"));
            users.add(user);
        }
        return users;
    }

    public static void main(String[] args) {
        //List<User> adminUsers
        //List<User> users
        List<User> userAll = generateUsers();

        List<User> adminUsers = userAll.stream()
                .filter(user -> !user.getRoles()
                        .stream()
                        .filter(role -> role.getId() == 1)
                        .toList()
                        .isEmpty())
                .toList();

        List<User> users = userAll.stream()
                .filter(user -> {
                    List<Role> roles = user.getRoles();
                    List<Role> adminRoles = roles.stream().filter(role -> role.getId() == 1).toList();
                    return adminRoles.isEmpty();
                }).toList();

        System.out.println(adminUsers);
        System.out.println(users);

    }
}

