package com.korai.ch12;

import lombok.AllArgsConstructor;
import lombok.Data;

public class CollectionMain03 {
    //이렇게 묶여있으면 한 번에 데이터 값을 꺼내기 쉬움  + 매개변수로 데이터를 한 번에 전달해줄수있음
    //오버로딩
    @Data
    @AllArgsConstructor
    static class Car {
        private String model;

        @Override
        public String toString() {
            return "Car{" +
                    "model='" + model + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[5];
        nums[0] = 100;
        nums[1] = 200;
        nums[2] = 300;
        nums[3] = 400;
        nums[4] = 500;

        String[] names = {"강민재1", "강민재2", "강민재3", "강민재4"};
        for (int i = 0; i < names.length; i++) {
            System.out.println(names[i]);
            System.out.println();
        }
        print(names);

        Car[] cars = new Car[5];
        cars[0] = new Car("아반떼");
        cars[1] = new Car("테슬라");
        cars[2] = new Car("쏘나타");
        cars[3] = new Car("그렌저");
        cars[4] = new Car("포르쉐");
        print(cars);

    }

    static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        System.out.println();
    }

    static void print(String[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        System.out.println();
    }

    //Object : 최상위 클래스 -> 어떠한 객체를 다 가질수있음. 다형성떄문에 가능한 일임
    //클래스 내부에 있다면, 빼서 static으로 하면 됨
    static void print(Car[] cars) {
        for (int i = 0; i < cars.length; i++) {
            System.out.println(cars[i]);
        }
        System.out.println();
    }
}