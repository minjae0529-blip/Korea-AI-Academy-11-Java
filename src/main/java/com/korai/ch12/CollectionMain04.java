package com.korai.ch12;

import java.lang.reflect.UndeclaredThrowableException;
import java.nio.charset.StandardCharsets;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;

class 내가만든예외 extends RuntimeException{
    public 내가만든예외(String message) {
        super(message);
    }
}

public class CollectionMain04 {
    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>();
        nums.add(100);
        nums.add(200);
        nums.add(300);
        nums.add(400);
        nums.add(500);

//        try {
//            print(nums);
//        } catch (IndexOutOfBoundsException e) {
//            System.out.println("여기 호출됨 ?");
//            e.printStackTrace();
//        }

        try {
            print(nums, nums.size() + 2);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("인덱스 초과 오류 해결");
        } catch (NullPointerException e) {
            System.out.println("넗 포인트예외처리됨");
        } catch (RuntimeException e) {
            System.out.println("runtime 예외처리됨");
            e.getMessage();
        } catch (Exception e) {
            System.out.println("예외처리됨");
            e.getMessage();
        }

        System.out.println("프로그램 정상 종료");
    }

//    static void print(List<Integer> number) {
//        for (int i = 0; i < number.size() + 1; i++) {
//            try{
//                System.out.println(number.get(i));
//            }catch (IndexOutOfBoundsException e){
//                e.printStackTrace();
//            }

    static void print(List<Integer> number, int size) throws Exception {
        if (size == 7) {
            throw new 내가만든예외("내가 강제로 호출한 예와");
        }
        System.out.println("리스트 크기 : " + number.size());

        for (int i = 0; i < number.size() + 1; i++) {
            System.out.println(number.get(i));
        }
    }



}


