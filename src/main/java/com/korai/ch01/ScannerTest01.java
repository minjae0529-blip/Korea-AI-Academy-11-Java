package com.korai.ch01;

import java.util.Scanner;

public class ScannerTest01 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();

        while(true){
            if(num == 1){
                System.out.println("1번 선택하셨습니다.");
                break;
            }

            if(num ==2){
                System.out.println("2번 선택하셨습니다");
                break;
            }

        }
    }
}
