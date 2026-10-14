package com.korai.ch01.practice;

public class Test {
    public static void main(String[] args) {
        System.out.println(MathUtil.max(3, 9, 5));
    }
}

class MathUtil{
    static int max = 0;
    static int max(int num1, int num2, int num3){
        for(int i = 0; i < 3; i++){

            if(max < num1){
                max = num1;
            } else if (num1 < num2) {
                max = num2;
            } else if (num2 < num3) {
                max = num3;
            }
        }
        return max;
    }

}