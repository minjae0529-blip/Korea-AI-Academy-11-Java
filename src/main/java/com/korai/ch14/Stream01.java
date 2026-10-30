package com.korai.ch14;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

public class Stream01 {
    public static void main(String[] args) {

        //스트림 : 생성 : 리스트, 배열 등등(스트림 객체를 생성), 중간연산, 최종연산
        Stream<Integer> numStream = Stream.of(10, 20, 30, 40, 50);
        System.out.println(numStream);              // 스트림 객체 주소 같은 게 출력됨 (내용 X)
        System.out.println(numStream.toList());     // [10, 20, 30, 40, 50]

        //map
        Stream.of(1, 2, 3)
                .map(num -> num * 10)    // 요소를 하나씩 꺼내서 10배로 변환
                .toList();               // [10, 20, 30]

        Function<Integer, Integer> fx = (num) -> num * 10;
        //        ↑받는 타입  ↑돌려주는 타입

//        Function<Integer, Integer> fx1 = new Function<Integer, Integer>() {
//            @Override
//            public Integer apply(Integer num) {
//                return num * 10;
//            }
//        };
        print(fx);                                  // 50

        //스트림으로 리턴되는것들은 전부 중간연산임, Set으로 리턴되는것들은 최종연산으로 들어감, Boolean도 포함
        List<String> names = List.of("강민재", "강민재1", "강민재2");
        Stream<String> namesStream = names.stream();                           //생성
        Stream<String> namesStream2 = namesStream.map(n -> n + "님");     //중간연산
        Stream<String> namesStream3 = namesStream2.map(n -> "이름 : " + n); //중간연산
        Stream<String> namesStream4 = namesStream3.filter(name -> !name.contains("1")); // 1들어간 거 제외
        List<String> newNames = namesStream4.toList();
        System.out.println(newNames);

        System.out.println(names.stream()
                .map(n-> n+"님")
                .map(n -> "이름" + n)
                .filter(name -> !name.contains("일"))
                .toList());
    }

    //클래스 만드는 법 : 파일에 만들기, 지역, 전역에 생성 가능, 익명 클래스
    static void print(Function<Integer, Integer> a) {
        System.out.println(a.apply(5));             // 5 * 10 = 50
    }
}