package com.korai.ch01;

public class ControlTest01 {
    public static void main(String[] args) {

        for(int i = 0; i < 5; i++){
            int num = 0;
            for(int j = 0; j < 5-i; j++){
                System.out.print(j+1);
            }
            System.out.println();
        }
    }
}
