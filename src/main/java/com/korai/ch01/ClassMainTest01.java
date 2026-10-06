package com.korai.ch01;

public class ClassMainTest01 {
    public static void main(String[] args) {
        //Class 복습
        //1. 변수와 자료형

        int num = 10; //a라는 변수명이 존재하고, 그 값은 10, 값의 반환자료형은 int(정수)
        final String name = "강민재"; //final은 상수. 즉 변수처럼 변하지 않고, 그 값으로 존재하는 거임

        class Student{
            String name;
            int age;
        }

        Student min = new Student();
        min.name = "강민재";
        min.age = 26;

        class Student2{
            String name;
            Object age;         //Object : 최대한 많은 값 받기
        }

        Student2 min2 = new Student2();
        min2.name = "강민재";
        min2.age = min;         //min의 자료형은 String이지만, 오류가 안남, 왜냐하면 오브젝트는 최상위이기 때문임

        Student2 min3 = new Student2();
        min3.age = "26살";

        class Student3<A> {
            String name;
            A age;
        }

        Student3<String> minjae = new Student3<String>();
        Student3<Integer> minjae1 = new Student3<>();

        minjae.age = "26살";
        minjae1.age = 26;

        //제네릭에 와일드카드
        int num2 = num;
        Student3<?> minjae00 = minjae1;

    }



}
