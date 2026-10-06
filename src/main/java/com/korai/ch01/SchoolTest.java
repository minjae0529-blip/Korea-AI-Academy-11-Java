package com.korai.ch01;

public class SchoolTest {
    public static void main(String[] args) {
        School school = new School();
        Student1 student1 = new Student1();
        Teacher1 teacher1 = new Teacher1();

        school.comeSchool();
        student1.comeSchool();
        teacher1.comeSchool();

        if(student1 instanceof Student1){
            student1.comeSchool();
            System.out.println("학생입니다.");
        }
    }
}

class School{
    String name;

    void comeSchool(){
        System.out.println("모두가 출근");
    }     //자식 클래스에서 알아서 구현
}

class Student1 extends  School{
    String name;
    int age;
    String address;
    int number;

    void study(){
        System.out.println("학생이 공부합니다");
    }

    @Override
    void comeSchool(){
        System.out.println("학생이 등교합니다");
    }
}

class Teacher1 extends School{
    String name;
    int age;

    void teach(){
        System.out.println("선생님이 학생을 가르칩니다.");
    }

    @Override
    void comeSchool(){
        System.out.println("선생님이 출근합니다");
    }
}