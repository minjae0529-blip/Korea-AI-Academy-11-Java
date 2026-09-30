package com.korai.ch05;

public class ControlMain {
    public static void main(String[] args) {
        //control 제어문
        //1. 조건문 - if, if ~ else if, switch
        //2. 반복문 - while, for
        //3. 분기/점프문 : break, continue, return

        if(true) System.out.println("명령어 실행"); // if문 기본형태
        boolean open = true;

        if(open) System.out.println("가게 오픈");
        else System.out.println("가게 오픈X");

        int score = 70;
        if(score < 60) System.out.println("F");
        else if(score < 70) System.out.println("D");
        else if(score < 80) System.out.println("C");
        else if(score < 90) System.out.println("B");
        else System.out.println("A");

        

    }
}
