package com.korai.ch05.practice;

import java.util.Scanner;

public class Practice01 {
    public static void main(String[] args) {
        /*
        1. B
        2. A,B /else가 없음
        3. Y
        4.if조건문에서는 괄호내에서는 boolean자료형만 들어올 수 있음. int 정수형은 안됨
          해당 문제를 해결하려고 하면 저 값이 true/false인지 조건을 바꿔주면 됨

          int n = 3;
          if((n=5) == 3); -> 이렇게 할 수 있음 대입을 먼저 진행해서 3과 비교하는거임

        5.연산자의 우선순위 : 괄호 -> 부정/증감연산자 / 왼쪽으로 쉬프트하면 원래값의 2배 증가 우측쉬프트는 2로 나눈 몫이 결과
          결론 : 비트연산으로 바뀜

        8. 자료형은 서로 같으나, 서로 저장되어 있는 메모리의 장소는 다름 -> 결론 : 다르다

        10. price = 11000, 비쌀
         */
        //6번 : ★ 정수 n이 짝수면 "짝수", 홀수면 "홀수"를 출력하세요. n이 -3일 때도 맞게 나와야 합니다.
        Scanner sc = new Scanner(System.in);
        System.out.println("입력하실 숫자를 알려주세요 : ");
        int n = sc.nextInt();

        if (n % 2 == 0) {
            System.out.println("짝수입니다");
        } else System.out.println("홀수입니다.");

//        //7번  윤년은 “4의 배수이면서 100의 배수가 아닌 해, 또는 400의 배수인 해”입니다. 빈칸을 채우세요.
        int year = 2024;
        if (year % 4 ==0 && year % 100 != 0 || year % 400 ==0) System.out.println("윤년");
        else System.out.println("평년");

        //9번 : 세 정수 a, b, c 중 가장 큰 값을 출력하세요. Math.max는 쓰지 말고 if만 쓰세요.
        int[] number = {30, 50, 52};
        int min = 0;
        int max = 0;

        for (int i = 0; i < number.length; i++) {
            if (number[i] > max) {
                max = number[i];
            }
        }

        for (int j = 0; j < number.length; j++) {
            if (number[j] < min) {
                min = number[j];
            }
        }

        System.out.println("제일 큰 값은 : " + max);
        System.out.println("제일 작은 값은 : " + min);

    }
}
