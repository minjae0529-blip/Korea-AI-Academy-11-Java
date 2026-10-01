package com.korai.ch05.practice;

public class Practice02_01 {
    public static void main(String[] args) {
        // 반복문 중점 : 반복횟수가 얼마나 되는지 -> 알고리즘에 있어서 가장 중요함
        // [단][곱하는 숫자][데이터]
        // [0][0][0] = 2단
        // [0][0][1] = 1
        // [0][0][2] = 2

        int[][][] gugudanArray = new int[8][9][3];

        // ① 배열에 구구단 데이터 저장
        for (int i = 0; i < gugudanArray.length; i++) {
            int dan = i + 2;
            for (int j = 0; j < gugudanArray[i].length; j++) {
                int num = j + 1;
                int result = dan * num;
                gugudanArray[i][j][0] = dan;
                gugudanArray[i][j][1] = num;
                gugudanArray[i][j][2] = result;
            }
        }
        // ② 배열에 저장된 데이터를 출력
        String gugudanString = "";
        for (int i = 0; i < gugudanArray.length; i++) {
            for (int j = 0; j < gugudanArray[i].length; j++) {
                gugudanString += String.format(
                        "%d x %d = %d%s",
                        gugudanArray[i][j][0],
                        gugudanArray[i][j][1],
                        gugudanArray[i][j][2],
                        gugudanArray[i][j][1] % 2 == 0 || gugudanArray[i][j][1] == 9 ? "\n" : "\t"
                );
            }
        }
        System.out.println(gugudanString);
    }
}