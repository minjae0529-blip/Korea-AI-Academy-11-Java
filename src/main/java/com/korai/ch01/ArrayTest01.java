package com.korai.ch01;

import org.w3c.dom.ls.LSOutput;

public class ArrayTest01 {
    public static void main(String[] args) {
        //성적관리 : 학생 5명의 점수를 배열로 저장하고, 다음을 출력하는 프로그램 만들기
        int[] score = {80, 95, 72, 88, 60};
        int sum = 0;
        int max = score[0];
        int min = score[0];

        for(int i = 0; i < score.length; i++){
            sum = score[i] + sum;
        }

        for(int i = 0; i < score.length; i++){
            if(score[i] > max){
                max = score[i];
            }
        }

        for(int i = 0; i < score.length; i++) {
            if (min > score[i]) {
                min = score[i];
            }

        }

        System.out.println("평균점수 : " + sum / 5.0);
        System.out.println("최고점수 : " + max);
        System.out.println("최저점수 : " + min);
    }
}
