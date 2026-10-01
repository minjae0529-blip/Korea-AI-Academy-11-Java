package com.korai.ch06;

public class Method03 {
    public static void main(String[] args) {
        System.out.println(new Student());
        System.out.println(new Student("강민재"));
        System.out.println(new Student("강민재1", 26));
    }
}

class Student {
    String name;
    int age;
    String address;

    Student() {
        System.out.println("이름, 나이없이 생성");
    }

    Student(String name) {
        System.out.println("이름만 생성");
        this.name = name;
    }

    Student(int age) {
        System.out.println("나이만 생성");
        this.age = age;
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println("이름, 나이 생성");
    }

    public Student(int age, String address) {
        this.age = age;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }


}