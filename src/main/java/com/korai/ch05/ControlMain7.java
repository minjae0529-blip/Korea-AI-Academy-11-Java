package com.korai.ch05;

public class ControlMain7 {
    public static void main(String[] args) {
        //0을 기준으로 사용하는 습관 들이기 !
        for(int i = 0; i < 10; i++){
            if(i % 2 == 0) {
                continue;
            }
            System.out.println("i : " + i );
        }
    }
}
