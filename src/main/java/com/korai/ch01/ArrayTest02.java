package com.korai.ch01;

public class ArrayTest02 {
    public static void main(String[] args) {
        //짝수 찾기 문제
        //마지막 출력 화면에는 짝수의 개수포함해서 진행
        int[] numbers = {12, 7, 5, 20, 33, 40, 18};
        int count = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 == 0) {
                System.out.println("짝수 : " + numbers[i]);
                count++;
            }
        }

        System.out.println("짝수의 개수는 : " + count);
    }
}
