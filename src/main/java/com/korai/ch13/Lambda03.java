package com.korai.ch13;

import java.util.function.*;

//내장형 람다 인터페이스
public class Lambda03 {
    public static void main(String[] args) {

        // Runnable: 매개변수도 없고, 반환값도 없는 함수형 인터페이스
        // 형태: () -> { 실행할 코드 }
        // 호출: runnable.run()
        Runnable runnable = () -> {};

        // Supplier<T>: 매개변수는 없고, T 타입 값을 "공급(반환)"하는 인터페이스
        // 여기서는 Integer 타입의 1000을 반환
        // 호출: supplier.get()  → 1000
        Supplier<Integer> supplier = () -> 1000;

        // Consumer<T>: T 타입 값을 매개변수로 "소비"하고, 반환값은 없는 인터페이스
        // 여기서는 String을 받아서 아무 동작도 하지 않음 (중괄호 안이 비어 있음)
        // 호출: consumer.accept("hello")
        Consumer<String> consumer = str -> {};

        // Function<T, R>: T 타입을 받아서 R 타입으로 "변환(반환)"하는 인터페이스
        // 여기서는 Integer를 받아서 String으로 변환
        // 호출: function.apply(10)  → "10"
        Function<Integer, String> function = num -> Integer.toString(num);

        // Predicate<T>: T 타입을 받아서 true/false(boolean)를 반환하는 "판단" 인터페이스
        // 여기서는 짝수이면 true, 홀수이면 false
        // 호출: predicate.test(4)  → true, predicate.test(3)  → false
        Predicate<Integer> predicate = num -> num % 2 == 0;

        runnable.run();
        int r1 = supplier.get();
        consumer.accept("");
        String r2 = function.apply(10);
        boolean r3 = predicate.test(20);

        //매개변수를 2개 이상 받을려면, Bi를 붙혀야 함
        BiConsumer<String, Integer> consumer2 = (str, num) -> {};
        BiFunction<Integer, Integer, String> function2 = (num1, num2) -> Integer.toString(num1 + num2);
        BiPredicate<Integer, Integer> predicate2 = (num1, num2) -> num1 % num2 % 2 == 0;


    }
}