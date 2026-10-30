package com.korai.ch13;

public class Lambda02 {
    public static void main(String[] args) {

        // ===== [규칙 1] 기본 형태: (매개변수) -> { 실행문 }
        // Calculator01: 매개변수 없음, 반환값 없음(void)
        // 매개변수가 없으면 () 를 반드시 써야 함
        Calculator01 calculator01 = () -> {
            System.out.println("명령하나");
            System.out.println("명령둘");   // 실행문이 2줄 이상이면 {} 필수
        };

        // ===== [규칙 2] 실행문이 1줄이면 {} 생략 가능 (끝의 ; 도 같이 뺌)
        Calculator01 calculator01_1 = () -> System.out.println("명령 1개");

        // ===== [규칙 3] 반환값이 있는 인터페이스(int calc())는 값을 반환해야 함
        // {} 를 쓰면 return 을 반드시 써야 함
        Calculator02 calculator02 = () -> {
            System.out.println("명령하나");
            System.out.println("명령둘");
            return 0;
        };

        // ===== [규칙 4] {} 를 생략하면 return 도 같이 생략
        // 식의 결과값이 자동으로 반환됨 (return 10; 이 아니라 그냥 10)
        Calculator02 calculator02_1 = () -> 10;

        // ===== [규칙 5] 매개변수 타입은 써도 되고 생략해도 됨
        Calculator03 calculator03 = (int num) -> {   // 타입 명시
            return 0;
        };

        // 타입 생략: 인터페이스(int calc(int num))를 보고 컴파일러가 int 로 추론
        Calculator03 calculator03_1 = (num) -> {
            return 0;
        };

        // ===== [규칙 6] 매개변수가 1개일 때만 () 생략 가능
        Calculator03 calculator03_2 = num -> {
            return 0;
        };

        // 규칙 2, 4, 6 을 모두 적용한 가장 짧은 형태
        Calculator03 calculator03_3 = num -> num * 10;

        // ===== [규칙 7] 매개변수 이름은 자유롭게 바꿔도 됨
        // 인터페이스의 num 과 이름이 달라도 상관없음 (타입과 개수만 맞으면 됨)
        Calculator03 calculator03_4 = a -> a * 10;

        // ===== [규칙 8] 매개변수가 2개 이상이면 () 필수
        Calculator04 calculator04 = (int num1, int num2) -> num1 + num2;

        // 타입 생략 + {} 생략 + return 생략
        Calculator04 calculator04_1 = (num1, num2) -> num1 + num2;

        // 이름 변경도 가능
        Calculator04 calculator04_2 = (a, b) -> a + b;
    }

    // ===== [규칙 9] 람다는 "추상 메서드가 딱 1개인 인터페이스"(함수형 인터페이스)에만 쓸 수 있음
    // @FunctionalInterface: 추상 메서드가 1개가 아니면 컴파일 오류를 내줌
    // (람다 사용에 꼭 필요한 건 아니고, 실수를 막아주는 안전장치)
    @FunctionalInterface
    interface Calculator01 {
        void calc();                       // 매개변수 X, 반환값 X
    }

    @FunctionalInterface
    interface Calculator02 {
        int calc();                        // 매개변수 X, 반환값 O
    }

    @FunctionalInterface
    interface Calculator03 {
        int calc(int num);                 // 매개변수 1개, 반환값 O
    }

    @FunctionalInterface
    interface Calculator04 {
        int calc(int num1, int num2);      // 매개변수 2개, 반환값 O
    }
}