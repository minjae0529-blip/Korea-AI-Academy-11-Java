package com.korai.ch13;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Scanner;

public class AnonymousClass02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Button homeButton = new Button("홈", new MouseEvent() {
            @Override
            public void click() {
                System.out.println("홈 화면으로 이동");
            }
        });

        Button loginButton = new Button("로그인", new MouseEvent() {
            @Override
            public void click() {
                System.out.println("로그인 되었습니다");
            }
        });

        Button logoutButton = new Button("로그아웃", new MouseEvent() {
            @Override
            public void click() {
                System.out.println("로그아웃 되었습니다");
            }
        });

        while (true) {
            System.out.print("버튼클릭 (1:홈, 2:로그인, 3:로그아웃, 0:종료) : ");
            int in = scanner.nextInt();
            scanner.nextLine();

            switch (in) {
                case 1:
                    homeButton.onClick();
                    break;
                case 2:
                    loginButton.onClick();
                    break;
                case 3:
                    logoutButton.onClick();
                    break;
                case 0:
                    System.out.println("종료");
                    return;
                default:
                    System.out.println("잘못된 입력");
                    break;
            }
        }
    }
}

interface MouseEvent {
    void click();
}

@AllArgsConstructor
@Data
//하나의 클래스로 여러개의 기능들 구현가능, 자유도 높힘
// 한 번만 쓰는 기능?
class Button {
    private String text;
    private MouseEvent mouseEvent;

    public void onClick() {
        mouseEvent.click();
    }
}