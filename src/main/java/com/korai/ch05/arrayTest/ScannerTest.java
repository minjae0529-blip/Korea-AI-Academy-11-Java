package com.korai.ch05.arrayTest;

import java.util.Scanner;

public class ScannerTest {
    public static void main(String[] args) {
        int[] nums = new int[]{10, 20, 30, 40, 50};
        //현재 배열 :
        //삭제할 값 : 30이라 입력하면 그 30이 삭제 되ㅏ어야 함

        Scanner scanner = new Scanner(System.in);

        // 전체 배열값 출력하기
        for(int i = 0; i < nums.length; i++){
            System.out.println(nums[i]);
        }

        //삭제할 배열 출력하기
        System.out.println("삭제할 배열을 입력하세요 : ");
        int number = scanner.nextInt();


    }
}
