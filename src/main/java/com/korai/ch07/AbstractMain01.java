package com.korai.ch07;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AbstractMain01 {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();
        names.add("강민재");
        names.add("강민재");
        names.add("강민재");
        System.out.println(names);

        LinkedList<String> names2 = new LinkedList<>();
        names2.add("강민재");
        names2.add("강민재");
        names2.add("강민재");
        System.out.println(names2);

        //2차원 배열
        List<List<String>> lists = new ArrayList<>();
        double[][] doubles = new double[2][2];
        lists.add(new ArrayList<>());
        lists.get(0).add("강민재");
        lists.get(0).add("민인규");
        lists.get(0).get(0);

        lists.add(new LinkedList<>());
        lists.get(1).add("강아지");
        lists.get(1).add("고양이");
        lists.get(1).add("다람쥐, 코끼리");

        lists.add(new ArrayList<>());
        lists.get(2).add("마라탕");
        lists.get(2).add("치킨");
        lists.get(2).add("맥주");

        System.out.println(lists);

        double d = 10.0;
        int i = (int) d;
        System.out.println((int)d);

    }
}
