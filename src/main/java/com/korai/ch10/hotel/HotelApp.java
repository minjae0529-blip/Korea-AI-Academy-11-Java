package com.korai.ch10.hotel;

import java.util.Scanner;

public class HotelApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        Hotel hotel = new Hotel();

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

            if (choiceNum == 3) {
                System.out.println("퇴실(체크아웃) 창입니다.");
                System.out.print("퇴실하실 방 번호를 입력하세요: ");
                int inputRoomNumber = scanner.nextInt(); // 1. 방 번호 입력받기 (예: 101)

                // 2. 숫자를 그냥 그대로 쏙 넘기면 끝!
                hotel.removeRoom(inputRoomNumber);

                System.out.println(inputRoomNumber + "호 퇴실 처리가 완료되었습니다.");
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
