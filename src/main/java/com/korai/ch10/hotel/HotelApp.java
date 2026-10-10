package com.korai.ch10.hotel;

import java.util.Scanner;

public class HotelApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        while (running){
            System.out.println("==== 신라 호텔 관리 시스템 ====");
            System.out.println("1. 방 등록  2. 예약(체크인)  3. 퇴실(체크아웃)  4. 전체 객실 현황  5. 방 검색  0. 종료");
            int choiceNum = scanner.nextInt();

            if(choiceNum == 1){
                System.out.println("방등록입니다.");
                break;
            }

            if(choiceNum == 2){
                System.out.println("예약(체크인) 확인창입니다");
                break;
            }

            if(choiceNum == 3){
                System.out.println("퇴실(체크아웃) 창입니다.");
                break;
            }

            if(choiceNum == 4){
                System.out.println("전체 객실 현황입니다.");
                break;
            }

            if(choiceNum == 5){
                System.out.println("방검색 창입니다. ");
            }

            if(choiceNum == 0){
                System.out.println("프로그램을 종료합니다");
                System.exit(0);
            }
        }

    }
}
