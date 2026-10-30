package com.korai.ch12;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.*;

public class CollectionMain07 {
    public static void main(String[] args) {
        //공통된 점은 인덱스가 없음.
        //중복제거해서 저장하는 용도
        // 중복이 있나 없나에 대한 확인만 하면 됨
        Set<Integer> nums = new HashSet<>();
        Set<Integer> num = new TreeSet<>();
        System.out.println(Objects.hash("ㄱ"));      //한글은 3byte . 즉 데이터에도 정해진 순서가 있음
        System.out.println(Objects.hash("ㄴ"));      //Hash값에 넣으면 해쉬 알고리즘의해서 정렬이 됨

        nums.add(10);
        nums.add(20);
        nums.add(30);
        nums.add(40);
        nums.add(50);
        nums.add(60);
        nums.add(70);
        nums.add(80);

        num.add(10);
        num.add(20);
        num.add(30);
        System.out.println(nums);       //해싱 기법에 의한 정렬. 순서대로 보고 싶다면 Tree Set
        System.out.println(num);       //Tree Set

        //80만출력 : Set은 확인용
        System.out.println(nums.contains(30));
        System.out.println(nums.containsAll(List.of(10, 20, 30)));

        List<String> names = List.of(
          "강민재",
          "강민재1",
          "강민재2",
          "강민재"
        );

        Set<String> nameSet = new HashSet<>();
        nameSet.addAll(names);
        System.out.println(nameSet);


        @AllArgsConstructor
        @Data
        class Student{
            String name;
            String address;
        }

        List<Student> students = List.of(
                new Student("강민재", "부산"),
                new Student("강민재", "서울"),
                new Student("강민쟁", "천안"),
                new Student("강민제", "강남"),
                new Student("강민제", "강남")
        );

        Set<String> addressSet = new HashSet<>();
        for(int i = 0; i < students.size(); i++){
            addressSet.add(students.get(i).getAddress());
        }
        System.out.println(addressSet);


        Iterator<String> addr = addressSet.iterator();
        while (addr.hasNext()){
            System.out.println(addr.next());
        }


    }
}
