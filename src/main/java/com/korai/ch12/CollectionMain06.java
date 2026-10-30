package com.korai.ch12;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;

public class CollectionMain06 {
    public static void main(String[] args) {


        A4.run();
    }
}

class A1 {

    static void run() {
        ArrayList<String> strList = new ArrayList<>();
        //값 추가
        strList.add("데이터1");
        //값 여러개 추가 : 상수느낌임, 불편리스트. 값을 추가하거나 삭제할 수 없음
        strList.addAll(List.of("데이터2", "데이터3", "데이터4"));
        strList.addFirst("데이터5");
        strList.addLast("데이터6");
        strList.add(2, "데이터7");

        System.out.println(strList);


    }

}

class A2 {
    static void run() {
        ArrayList<String> strList = new ArrayList<>();

        //값 여러개 추가 : 상수느낌임, 불편리스트. 값을 추가하거나 삭제할 수 없음
        strList.addAll(List.of("데이터1", "데이터2", "데이터3", "데이터4"));
        strList.remove("데이터2");
        strList.remove(2);
//        boolean isRemoved = strList.remove("데이터2");
//        String removedObject = strList.remove(2);
        strList.addAll(List.of("데이터5", "데이터6", "데이터7", "데이터8"));
        strList.removeAll(List.of("데이터6", "데이터7"));

        System.out.println(strList);
    }

}

class A3 {
    static void run() {
        List<String> strList = List.of("데이터1", "데이터2", "데이터3");
        String data = strList.get(2);

        System.out.println(data);
        System.out.println(strList.get(2));
    }
}

class A4 {
    static void run() {
        List<String> strList = List.of("데이터1", "데이터2", "데이터3");
        boolean isContained = strList.contains("데이터2");     //데이터를 담고 있는지 아닌가 확인하는것(데이터가 통째로 들어있는지)
        System.out.println(isContained);

        boolean isContained2 = strList.get(1).contains("2");
        System.out.println(isContained2);
    }
}