package com.korai.ch04;

import java.util.Arrays;

public class ArrayMain02 {
    public static void main(String[] args) {
        //배열 선언 및 생성, 초기화
        // 배열선언 => 자료형[] 배열 변수명;

        int[] nums1;
        int[][] nums2;

        nums1 = new int[3];
        nums2 = new int[2][3];

        int[] nums3 = nums2[0];
        nums3[0] = 100;         // 집가서 복습하기

        nums2[0][0] = 10;
        nums2[0][1] = 20;
        nums2[0][2] = 30;
        nums2[1][0] = 40;
        nums2[1][1] = 50;
        nums2[1][2] = 60;

        int[] num5 = {10, 20, 30, 40};

        int[] nums4 = new int[]{10, 20, 30, 40,}; // 한 번에 초기화하는 과정
        int[] nums5 = new int[1000];
        Arrays.fill(nums5, 199);

        run(new int[] { 1, 2, 3,});

    }
    static void run(int[] arr){

    }

}
