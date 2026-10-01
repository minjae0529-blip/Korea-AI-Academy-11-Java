package com.korai.ch07;

public class ObjectMain01 {
    public static void main(String[] args) {

        final int num = 1;
        System.out.println(num);
        Student s1 = new Student(1, "강민재", "대연동");
        System.out.println(s1.address);

        Student s2 = new Student();
        School school = new School(); //생성자가 생략되어있음
    }
}

class Student {
    final int code;       //필수 : 객체를 생성하는 타이밍에 값을 할당
    final String name;    //필수
    String address; //선택

    // NoArgumentsConstructor (인자들이 없는 생성자. 즉, 생성자의 매개변수가 없음)
    Student() {
        code = 0;
        name = null;
    }

    //RequiredArgumentsConstructor (필수인자들만 받는 생성자)
    Student(int code, String name) {
        this.code = code;
        this.name = name;
    }

    // AllArgumentsConstructor (모든 인자들을 다 받는 생성자)
    public Student(int code, String name, String address) {
        this.code = code;
        this.name = name;
        this.address = address;
    }
    //Q1. 만약에 주소가 선택이라면 프로그램 할 때 생성자를 2개를 만들어야 하는 것인지

}

class School {
    String name;

    School(String name) {
        this.name = name;
    }

    School() {

    }
}


class Teacher {
    String name;
    int age;
    String address;

    public Teacher(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

}