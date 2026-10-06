package com.korai.ch08;

public class Object01 {
    // 최상위 클래스(Object)
    public static void main(String[] args) {
        //동일한 코드
        System.out.println(Student.class.getName());
        System.out.println(new Student().getClass().getName());

        //동일한 코드
        System.out.println(new Student() instanceof Student);
        System.out.println(new Student().getClass() == Student.class);

        Student student = new Student();
        System.out.println(student.hashCode());
        System.out.println(Integer.toHexString(student.hashCode()));

        //동일한 코드
        System.out.println(student.toString());         //String으로 리턴
        System.out.println(student);                    //Object으로 리턴

        //sout 했을 때만 생략 가능 함
        String str1 = student.toString();
        Student s2 = student;

        HighStudent highStudent = new HighStudent();
        System.out.println(highStudent);



    }
}


class Student extends Object{

}

class HighStudent extends Student{
    //다중 상속은 아님

    @Override
    public String toString() {
        return "내 마음대로 재정의 가능";     //모든객체가 오트젝트를 상속받고 있기 때문에 toString내부에도 내 맘대로 재정의 가능함
                                        //toString은 객체가 가지고 있는 데이터를 문자열로 시각화 할 때 사용
    }
}


class Teacher{
    private  String name;
    private int age;
    private String address;

    public Teacher(int age, String name, String address) {
        this.age = age;
        this.name = name;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }

}