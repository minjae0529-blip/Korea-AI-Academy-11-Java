package com.korai.ch04;

public class ArrayMain04 {
    public static void main(String[] args) {
        //for문이 한줄이면 중괄호를 생략할 수 있다 !!
        int[] nums = new int[10]; //nums를 int[10]에 넣음

        //위에 배열 길이만큼 반복해라
        for (int i = 0; i < nums.length; i++) {
            nums[i] = i + 1;
        }

        System.out.println(arrayToString(nums));
    }

    static String arrayToString(int[] arr) {
        String str = ""; //지역변수라 초기화 무조건 해야 함. java에서는 생성자는 자동 초기화가 됨
        //내부에 어떤 데이터가 들어있는지 모르기때문에 += 는 안되는거임 초기화를 하지 않으면
        for (int i = 0; i < arr.length; i++) {
            if (i == 0) str += "[ ";
            str += arr[i] + ", "; //위에 조건문 if ~ else if가 아니라면 지금 이 코드를 시행하는거임
                                  // 0이라면 arr[0] -> 1 이니 [ 1, 이게 출력
            if (i == arr.length - 1) str += "]";
        }
        return str;              //위에 static을 사용하는 문자열을 사용하는 메서드...?를 반환해주는 반환타입 생성
    }
}
