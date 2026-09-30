package com.korai.ch01;

import java.util.Scanner;

public class ArrayTest03 {
    public static void main(String[] args) {

        // false = 빈자리
        // true = 예약된 자리
        boolean[] seats = new boolean[10];
        Scanner sc = new Scanner(System.in);
        System.out.println("====== 앉으실 좌석을 선택하세요 ======");

        // 현재 좌석 상태 출력
        for (int i = 0; i < seats.length; i++) {

            if (seats[i] == false) {
                System.out.println((i + 1) + "번 : □");
            } else {
                System.out.println((i + 1) + "번 : ■");
            }
        }

        // 좌석 번호 입력
        int choiceNum = sc.nextInt();
        // 이미 예약되어 있는지 확인
        if (seats[choiceNum - 1] == true) {

            System.out.println("이미 예약된 좌석입니다.");

        } else {

            // 좌석 예약
            seats[choiceNum - 1] = true;

            System.out.println(choiceNum + "번 좌석 예약되었습니다.");
        }

        // 예약 후 좌석 상태 출력
        System.out.println("===== 현재 좌석 현황 =====");

        for (int i = 0; i < seats.length; i++) {

            if (seats[i] == false) {
                System.out.println((i + 1) + "번 : □");
            } else {
                System.out.println((i + 1) + "번 : ■");
            }
        }

        sc.close();
    }
}