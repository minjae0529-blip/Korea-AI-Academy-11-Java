package com.korai.ch10.TODO.view;

import com.korai.ch10.TODO.config.SecurityConfig;
import com.korai.ch10.TODO.router.RootRouter;
import com.korai.ch10.TODO.service.UserService;

import java.util.Scanner;

public class LoginView implements View {

    /*
     * [선언 이유: private UserService userService]
     * - UserService 클래스가 가지고 있는 login(username, password) 메서드를 호출하여
     *   인증 및 토큰 발급을 처리하기 위해 선언한 참조 변수입니다.
     */
    private UserService userService;

    /*
     * [선언 이유: private Scanner scanner]
     * - 사용자가 입력한 아이디와 비밀번호 문자열을 읽어 들이기 위한 Scanner 객체 참조 변수입니다.
     */
    private Scanner scanner;

    public LoginView(UserService userService) {
        this.userService = userService;
        scanner = new Scanner(System.in);
    }

    /*
     * [강사님 깃허브 원본 복구 및 설명: show()]
     * 1. 사용자로부터 username과 password를 입력받습니다.
     * 2. userService 객체의 login(username, password) 메서드를 호출하여 세션 토큰 문자열을 반환받습니다.
     * 3. 토큰이 null이면 로그인 실패 메시지를 띄우고, "계속 진행하시려면 엔터를 눌러주세요..." 안내 후 scanner.nextLine()으로 대기했다가 return합니다.
     * 4. 로그인이 성공하면 SecurityConfig.setLoginSession(token) 메서드를 호출하여 세션을 전역 저장하고,
     *    환영 문구를 출력한 뒤 RootRouter.setCurrent("todo-list")로 화면을 전환합니다.
     */
    @Override
    public void show() {
        String username;
        String password;

        System.out.println("[ TODO LIST 로그인 ]");
        System.out.print("username: ");
        username = scanner.nextLine();
        System.out.print("password: ");
        password = scanner.nextLine();

        String token = userService.login(username, password);
        if (token == null) {
            System.out.println("로그인 정보를 다시 확인하세요.");
            System.out.print("계속 진행하시려면 엔터를 눌러주세요...");
            scanner.nextLine();
            return;
        }

        SecurityConfig.setLoginSession(token);
        System.out.println(String.format("로그인 성공. %s님 환영합니다.", username));
        RootRouter.setCurrent("todo-list");
    }

}
