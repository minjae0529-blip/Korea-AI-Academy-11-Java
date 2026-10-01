package com.korai.ch05.practice;

import java.util.Scanner;

public class Practice02_02 {
    public static void main(String[] args) {

        int inputNum = 0;

        Scanner scanner = new Scanner(System.in);

        System.out.println("몇명의 이름을 입력하실건가요?");
        inputNum = scanner.nextInt();
        scanner.nextLine();

        String[] names = new String[inputNum];

        for(int i = 0; i < names.length; i++){
            System.out.print("이름 : ");
            names[i] = scanner.nextLine();
        }

        System.out.println("입력한 이름 정보:");

        for(int i = 0; i < names.length; i++){
            System.out.println(String.format("%d : %s", i + 1, names[i]));
        }
    }
}