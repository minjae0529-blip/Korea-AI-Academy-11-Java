package com.korai.study.ch01;

public class ClassMain {

    public static void main(String[] args) {
// 1. 변수와 자료형
        int num = 10;
        final String name = "강민재"; //상수

        class Student {
            String name;
            int age;
        }
        Student jun = new Student();
        jun.name = "민인규";
        jun.age = 21;


        class Student2 {
            String name;
            Object age;
        }
        Student2 jun1 = new Student2();
        jun1.name = "민인2";
        jun1.age = jun;

        Student2 jun2 = new Student2();
        jun2.name = "민인3";
        jun2.age = "33";

        System.out.println();


        class Student3<Age> {
            String name;
            Age age;
        }
        Student3<String> jun3 = new Student3<String>();
        Student3<Integer> jun4 = new Student3<Integer>();

        jun3.age = "33";
        jun4.age = 33;
        System.out.println();

        Student3<?> jun333 = jun3; // 제네릭의 와일드 카드

    }

}
