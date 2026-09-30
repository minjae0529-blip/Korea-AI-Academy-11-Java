package com.korai.ch05;

public class Operator {
    public static void main(String[] args) {
        //논리연산자 : T/F - 1/0 -- 1은 전기가 흐른다, 0은 전기가 흐르지 않는다로 구분
        //곱 = 그리고 = AND = &&
        //합 = 또는 = OR = ||
        //부정 = 반전 = NOT  = !

        //합 -> T || T = T, T || F = T, F || F = F
        //곱 -> T && T = T, T && F = F, F && F = F

        boolean open1 = true;
        boolean open2 = false;

        System.out.println(open1);
        System.out.println(open2);
    }
}
