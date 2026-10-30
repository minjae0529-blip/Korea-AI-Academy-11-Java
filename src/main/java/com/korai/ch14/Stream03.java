package com.korai.ch14;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class Stream03 {
    public static void main(String[] args) {
        List<Integer> nums = List.of(5, 2, 10, 30, 22, 33, 50, 53);
        System.out.println(nums.stream().filter(n -> n % 5 == 0).toList());  // 5의 배수를 담은 List를 출력하시오.
        System.out.println(nums.stream().map(n -> n % 5 == 0 ? n * 1000 : n).toList());  // 5의 배수에 1000을 곱한 값들을 담은 List를 출력하시오.

        //<> : 컴파일러가 자동으로 추측하는 것임, 단 변수선언에는 안되는거임
        //new CustomStream 클래스에 리스트 이름을 nums라고 선언
        System.out.println(new CustomStream<>(nums).filter(n -> n % 5 == 0).toList());
        //람다안쓰면
//        Predicate<Integer> p1 = new Predicate<Integer>() {
//            @Override
//            public boolean test(Integer n) {
//                return n % 5 ==0;
//            }
//        };

        //fx = n -> n % 5 == 0 ? n * 1000 : n
        //apply는 값을 단지 전달만 하는 계산기임
        System.out.println(new CustomStream<>(nums).map(n -> n % 5 == 0 ? n * 1000 : n).toList());

    }
}

@Data
@AllArgsConstructor
class CustomStream<T> { //클래스를 제네릭으로 받는 이유가, 다양한 자료가 있음, String, Integer 등등
    private List<T> list;

    public CustomStream<T> map(Function<T, T> fx) {
        List<T> newList = new ArrayList<>();
        for (T t : list) {
            newList.add(fx.apply(t));
        }
        this.list = newList;
        return this;
    }

    public CustomStream<T> filter(Predicate<T> predicate) {
        List<T> newList = new ArrayList<>();
        for (T t : list) {
            if (predicate.test(t)) {
                newList.add(t);
            }
        }
        this.list = newList;   //→ 결과를 내 안에 저장하고
        return this;           //→ 나 자신을 돌려줘서, 다음 메서드(.map, .toList)를 이어 쓰게 함 = 체인링
    }

    public List<T> toList() {
        return list;
    }
}