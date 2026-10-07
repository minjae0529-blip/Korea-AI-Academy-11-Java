package com.korai.ch10.TODO.view;

import com.korai.ch10.TODO.config.SecurityConfig;
import com.korai.ch10.TODO.router.RootRouter;
import com.korai.ch10.TODO.service.UserService;

import java.util.Scanner;

public class LoginView implements View{

    private UserService userService;
    private Scanner scanner;

    //메인뷰가 생성되면 스캐너도 그떄 생성되는거임
    public LoginView(UserService userService){      //종속성 주입 -> 결합도를 낮추기 위해 사용
        this.userService = userService;
        scanner = new Scanner(System.in);
    }

    @Override
    public void show(){
        String username;
        String password;

        System.out.println("[ TODO LIST 로그인 ]");
        System.out.print("username :  ");
        username = scanner.nextLine();
        System.out.print("password : ");
        password = scanner.nextLine();

        String token = userService.login(username, password);
        if(token == null){
            System.out.println("로그인 정보를 다시 확인하세요.");
            System.out.println("엔터를 눌러 다시 입력하세요.");
            scanner.nextLine();
            return;     //함수를 중간에 끊고 나가고 싶을때, 단 반환타입이 void여야 함
        }

        SecurityConfig.setLoginSession(token);
        System.out.println(String.format("로그인 성공. %s님 환영합니다.", username));
        RootRouter.setCurrent("todo-list");

    }
}
