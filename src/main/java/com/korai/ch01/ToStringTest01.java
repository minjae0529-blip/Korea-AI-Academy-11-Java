package com.korai.ch01;

public class ToStringTest01 {
    public static void main(String[] args) {
        Student s1 = new Student("강민재", "부산 대연", 26);
        System.out.println(s1);
    }
}

 class Student{
    String name;
    int age;
    String address;

    public Student(String name, String address, int age) {
        this.name = name;
        this.address = address;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }
}
