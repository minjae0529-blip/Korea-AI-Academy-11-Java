package com.korai.ch04;

import java.time.LocalDateTime;

public class ArrayMain03 {
    public static void main(String[] args) {
        //배열을 활용한 반복 작업 -> 규칙 찾기
        //인덱스가 필요할 때 for, 인덱스가 필요없을 때 while문 사용

        int[] nums = new int[100];

        //방법 1 : 규칙 찾기
        int index = 0;
        nums[index] = index+1;
        index ++;


        //방법 2 : while 활용 :  반복 횟수가 정해져 있지 않을 때 자주 사용
        while (index < 100){
            nums[index] = index+1;
            index ++;
        }

        //방법 3 : for문 활용 :  순서대로 반복할 때,배열 전체 순회할 때 자주 사용
        for(int i = 0; i < nums.length; i++){
            nums[i] = i+1;
        }

        long expired = LocalDateTime.now().getSecond() + (1000l * 60 * 60 * 24 );

        while(true){
            if(LocalDateTime.now().getSecond() == expired);
            break;
        }
    }
}
