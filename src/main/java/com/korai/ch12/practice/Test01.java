package com.korai.ch12.practice;

import java.util.*;

public class Test01 {
    public static void main(String[] args) {
        //문제 1 : ArrayList를 사용하여 5명의 학생 점수를 저장하고, 평균과 최고 점수를 구하시오.

        List<Integer> score = new ArrayList<>(List.of(85, 92, 78, 96, 88));
        int max = 0;
        double average = 0;
        System.out.println("점수 : " + score);

        for (int i = 0; i < score.size(); i++) {
            if (max < score.get(i)) {
                max = score.get(i);
            }
        }
        System.out.println("최고점수 : " + max);

        for (int i = 0; i < score.size(); i++) {
            average = average + score.get(i);
        }
        System.out.println("평균 : " + average / 5);


        System.out.println("문제 2번");
        HashSet<String> stringList = new HashSet<>();
        stringList.add("java");
        stringList.add("python");
        stringList.add("java");
        stringList.add("c++");
        stringList.add("python");
        stringList.add("go");

        System.out.println(stringList);

        System.out.println("문제 3번");
        List<Integer> numbers = new ArrayList<>();
        List<Integer> numberList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            numbers.add(i);
        }

        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) % 3 == 0) {
                numberList.add(numbers.get(i));
            }
        }
        System.out.println(numberList.reversed());

        List<Integer> list1 = new ArrayList<>();
        list1.add(5);
        list1.add(2);
        list1.add(8);

        List<Integer> list2 = new ArrayList<>();
        list2.add(3);
        list2.add(9);
        list2.add(1);

        list1.addAll(list2);            //배열 병합
        Collections.sort(list1);        //애가 오름차순으로 해주는거
        System.out.println(list1);



    }


}

