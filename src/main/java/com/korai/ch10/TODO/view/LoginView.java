package com.korai.ch10.TODO.view;

import com.korai.ch10.TODO.config.SecurityConfig;
import com.korai.ch10.TODO.router.RootRouter;
import com.korai.ch10.TODO.service.UserService;

import java.util.Scanner;

public class LoginView implements View {

    /*
     * [선언 이유: private UserService userService]
     * - 이 클래스(LoginView) 안에서 UserService 클래스가 가지고 있는 login() 메서드를 호출하기 위해
     *   해당 객체의 주소값을 담아둘 참조 변수를 선언한 것입니다.
     * - private을 붙인 이유: 외부 클래스에서 이 변수에 직접 접근해서 null로 바꾸거나 다른 객체로 변경하지 못하게 캡슐화(보호)하기 위해서입니다.
     */
    private UserService userService;

    /*
     * [선언 이유: private Scanner scanner]
     * - 사용자가 키보드로 콘솔에 입력한 문자열을 읽어들이는 Scanner 객체의 메서드(nextLine)를 사용하기 위해 선언한 것입니다.
     */
    private Scanner scanner;

    /*
     * [작성 이유: 생성자 매개변수로 UserService 받기 (의존성 주입)]
     * - LoginView 내부에서 직접 'new UserService()'를 생성하면 두 클래스 간의 결합도가 너무 높아집니다.
     * - 그래서 외부(RootRouter)에서 이미 생성된 UserService 인스턴스를 매개변수로 넘겨받아
     *   this.userService에 저장해 두고 메서드를 호출하기 위해 이렇게 작성한 것입니다.
     * - 뷰 객체가 메모리에 올라갈 때 Scanner도 한 번만 생성해서 재사용하기 위해 생성자 안에서 new Scanner를 실행합니다.
     */
    public LoginView(UserService userService) {
        this.userService = userService;
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void show() {
        String username;
        String password;

        System.out.println("[ TODO LIST 로그인 ]");
        System.out.print("username :  ");
        username = scanner.nextLine(); // Scanner 객체의 nextLine() 메서드를 호출해 입력값을 문자열로 받음
        System.out.print("password : ");
        password = scanner.nextLine();

        /*
         * [작성 이유: userService.login(username, password)]
         * - UserService 객체에 정의된 login() 메서드를 호출하여,
         *   DB(저장소)에 해당 유저가 있고 비밀번호가 맞는지 검증하고 세션 토큰 문자열을 반환받기 위함입니다.
         */
        String token = userService.login(username, password);

        /*
         * - userService.login()이 검증에 실패하여 null을 반환한 경우,
         *   아래에 있는 세션 저장 및 화면 이동 코드가 실행되면 안 되므로
         *   return을 통해 show() 메서드 실행을 여기서 조기 종료(Early Return)하고 빠져나가기 위함입니다.
         */
        if (token == null) {
            System.out.println("로그인 정보를 다시 확인하세요.");
            System.out.println("엔터를 눌러 다시 입력하세요.");
            scanner.nextLine(); // 사용자가 에러 메시지를 확인하고 엔터를 칠 때까지 콘솔 입력을 대기시킴
            return;
        }

        /*
         * [작성 이유: SecurityConfig.setLoginSession(token)]
         * - SecurityConfig 클래스의 static 메서드인 setLoginSession()을 호출하여,
         *   발급된 토큰 문자열을 static 변수에 저장해 두고 다른 클래스(TodoService 등)에서도 꺼내 쓸 수 있게 하기 위함입니다.
         */
        SecurityConfig.setLoginSession(token);
        System.out.println(String.format("로그인 성공. %s님 환영합니다.", username));

        /*
         * [작성 이유: RootRouter.setCurrent("todo-list")]
         * - RootRouter의 static 변수인 current 값을 "todo-list"로 변경하여,
         *   TodoApplication의 다음 루프에서 TodoListView 객체의 show()가 실행되도록 화면 경로를 전환하기 위함입니다.
         */
        RootRouter.setCurrent("todo-list");
    }
}
