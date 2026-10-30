package com.korai.serveltstudy2.model.service;

import com.korai.serveltstudy2.exception.DuplicatedException;
import com.korai.serveltstudy2.model.User;
import com.korai.serveltstudy2.model.repository.UserRepository;

import java.util.List;

public class UserService {
    private static UserService instance;
    private UserRepository userRepository;

    private UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public static UserService getInstance(){
        if(instance ==null){
            instance = new UserService(UserRepository.getInstance());
        }
        return instance;
    }

    public void register(User user)throws DuplicatedException{
        if(isDuplicatedUsername(user.getUsername())){
        throw new DuplicatedException("이미 존재하는 사용자 이름입니다");
        }
        userRepository.insert(user);
    }

    //boolean 자료형일때는 메서드 명 앞에 is, has 많이 붙힘
    public boolean isDuplicatedUsername(String username){
        return userRepository.findByUserName(username) != null;
        //닉네임이 중복되면 안되기때문에, 상룡자가 이름을 넣었을 때 중복을 방지하기위해 리턴으로 null이지 않을때만 리턴해주는거임
    }

    public List<User> getUserAll(){
        return userRepository.findAll();
    }

}
