package com.korai.ch05;

import java.util.Scanner;

public class ControlMain6 {
    public static void main(String[] args) {
        // while문
        // 처음에는 0칸짜리 배열
        String[] names = new String[0];
        Scanner scanner = new Scanner(System.in);
        System.out.println("===== 이름 입력 프로그램 =====");
        while (true) {

            System.out.println("이름을 추가하시겠습니까? (Y/N)");
            String yesOrNo = scanner.nextLine();

            if (yesOrNo.equals("Y")) {
                System.out.println("추가하실 이름을 입력하세요 : ");
                String name = scanner.nextLine();
                // 기존 배열보다 1칸 큰 배열 생성
                String[] newNames = new String[names.length + 1];
                // 기존 이름 복사
                for (int i = 0; i < names.length; i++) {
                    newNames[i] = names[i];
                }
                // 마지막 칸에 새로운 이름 저장
                newNames[newNames.length - 1] = name;
                // names가 새로운 배열을 가리키도록 변경
                names = newNames;
            } else if (yesOrNo.equals("N")) {
                System.out.println("프로그램을 종료합니다");
                break;
            } else {
                System.out.println("다시 입력해주세요");
            }
            System.out.println();
        }
        // 입력된 이름 출력
        System.out.println("===== 입력된 이름 =====");
        for (int i = 0; i < names.length; i++) {
            System.out.println((i + 1) + " : " + names[i]);
        }
    }
}