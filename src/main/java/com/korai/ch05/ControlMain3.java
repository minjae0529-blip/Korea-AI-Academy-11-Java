package com.korai.ch05;

public class ControlMain3 {
    public static void main(String[] args) {

        for (int i = 0; i < 5; i++) {
            String star = "";           // String   초기화

            for (int j = 0; j < i + 1; j++) {
                star += "*";            //star = star + "*";
            }
            System.out.println(star);
        }

        System.out.println();

        //역삼각형
        for (int i = 0; i < 5; i++) {
            String star = "";           // String   초기화

            for (int j = 0; j < 5 - i; j++) {
                star += "*";            //star = star + "*";
            }
            System.out.println(star);
        }

        System.out.println();

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 4 - i; j++) {
                System.out.print(" ");
            }
            for(int j =0; j < 1 + i; j++){
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 4 + i; j++) {
                System.out.print(" ");
            }
            for(int j =0; j < 5 - i; j++){
                System.out.print("*");
            }
            System.out.println();
        }




    }
}
