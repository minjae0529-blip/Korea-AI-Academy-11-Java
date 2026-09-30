package com.korai.ch05;

public class ContrilMain2 {
    public static void main(String[] args) {
        // switch ~ case => if 조건문과 완전히 다른 동작 방

        String 문선택 = "1번문";
        switch (문선택) {

            case "1번문":
                System.out.println("1번째 버섯");
            case "2번문":
                System.out.println("2번째 버섯");
            case "3번문":
                System.out.println("3번째 버섯");
            case "4번문":
                System.out.println("4번째 버섯");
            default:
                System.out.println("마지막 버섯 ");
        }




    }

}

