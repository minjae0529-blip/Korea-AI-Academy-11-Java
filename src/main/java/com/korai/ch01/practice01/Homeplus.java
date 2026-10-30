package com.korai.ch01.practice01;

import java.util.Scanner;

public class Homeplus {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] items = {"사과", "바나나", "우유"};
        int[] prices   = {1000,   1500,   2000};
        int[] stocks   = {  10,      5,      8};

        while(true){

            System.out.println("========== [슈퍼마켓] ==========");
            System.out.println("1. 상품 목록 보기");
            System.out.println("2. 상품 구매하기");
            System.out.println("3. 총 결제 금액 확인");
            System.out.println("4. 종료");
            System.out.print("메뉴 선택 >>> ");
            int menu = scanner.nextInt();

            if(menu == 1){
                System.out.println("어떤 상품 항목읖 보시겠어요 ?");
                break;
            }

            if(menu ==2){
                System.out.println("어떤 상품을 구매하시겠습니까 ?");
                break;
            }

            if(menu == 3){
                System.out.println("총 결재 금액 확인");
                break;
            }

            if(menu == 4){
                System.out.println("시스템을 종료합니다");
                break;
            }
        }

    }
}
