package com.korai.ch12;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class CollectionMain08 {
    public static void main(String[] args) {
        Map<String, String> productMap = new HashMap<>();

        productMap.put("productName", "상품1");
        productMap.put("price", "20000");
        productMap.put("createdAt", "2026-10-19");

        System.out.println(productMap.get("price"));

        Map<String, Object> student = new LinkedHashMap<>();      //해쉬값이라 밑에 출력 결과가 해쉬 알고리즘에 의해서 변함
                                                                 // TreeMap은 키값 기준에서 알파벳으로 정렬
        student.put("name", " 강민재");
        student.put("age", 33);
        student.put("gender", true);
        System.out.println(student);
    }
}
