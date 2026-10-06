package com.korai.ch01;

import java.util.Objects;

public class ObjectTest {
    public static void main(String[] args) {
        class Student{
            private String name;            //private로 같은 클래스내에서만 선언할 수 있도록 접근지정자 설정
            private int age;

            public Student(String name, int age) {
                this.name = name;
                this.age = age;
            }

            @Override
            public boolean equals(Object o) {
                if (o == null || getClass() != o.getClass()) return false;
                Student student = (Student) o;
                return age == student.age && Objects.equals(name, student.name);
            }

            @Override
            public int hashCode() {
                return Objects.hash(name, age);
            }

        }

        Student student = new Student("강민재", 20);
        Student student1 = new Student("강민재", 20);
        System.out.println(student.hashCode() == student1.hashCode());
        System.out.println(student.hashCode());
        System.out.println(student1.hashCode());


    }
}
