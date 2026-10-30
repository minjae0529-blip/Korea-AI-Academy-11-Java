package com.korai.ch12;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CollectionMain09 {

    @Data
    @AllArgsConstructor
    static class Student {
        private String name;
        private String address;
    }

    public static void main(String[] args) {
        List<Map<String, Map<String, Map<String, Object>>>> data = List.of(
                Map.of("class1", Map.of(

                        "student1", Map.of(
                                "id", 1,
                                "object", new Student("강민재", "서울"),
                                "createdAt", LocalDate.of(2025, 1, 1)
                        ),
                        "student2", Map.of(
                                "id", 2,
                                "object", new Student("강민재2", "서울"),
                                "createdAt", LocalDate.of(2025, 1, 2)
                        ),
                        "student3", Map.of(
                                "id", 3,
                                "object", new Student("강민재3", "서울"),
                                "createdAt", LocalDate.of(2025, 1, 3)
                        )
                )),
                Map.of("class2", Map.of()),
                Map.of("class3", Map.of())
        );

        System.out.println(data);

        //Student라는 객체로 자료형이 되어 있으니, 객체를 맞춰주고, 참조해서 get한 값을 객체에 담고 마지막에 getName으로 꺼내서 출력
        System.out.println(((Student) data.get(0).get("class1").get("student1").get("object")).getName());

        for (int i = 0; i < data.size(); i++) {
            Set<String> classKeySet = data.get(i).keySet();

            for (String classKey : classKeySet) {
                Map<String, Map<String, Object>> studentMap = data.get(i).get(classKey);
                Set<String> studentKeySet = studentMap.keySet();

                for (String studentKey : studentKeySet) {
                    Map<String, Object> student = studentMap.get(studentKey);
                    Student s = (Student) student.get("object");
                    System.out.println(s.getName());
                }
            }
        }

        Map<String, Integer> ages = Map.of(
          "강민재", 26,
          "강민재1", 27,
          "강민재2", 29
        );

        Set<Map.Entry<String, Integer>> entries = ages.entrySet();
        for(Map.Entry<String, Integer> entey : entries){
            System.out.println(entey.getKey());
            System.out.println(entey.getValue());
        }

        List<Map.Entry<String, Integer>> entryList = new ArrayList<>();
        entryList.addAll(entries);
        System.out.println(entryList.get(0));

    }
}