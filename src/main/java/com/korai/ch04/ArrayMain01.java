package com.korai.ch04;

public class ArrayMain01 {
    public static void main(String[] args) {
        // 배열 : 나열하고자 하는 개수만큼 자료형의 크기대로 배정한 것(순서대로)
        // 배열의 공간 번호  = 인덱스
        byte[] a1 = new byte[4];
        short[] a2 = new short[4];
        int[] a3 = new int[4];

        //garbage : 변수안에 안들어가 있는 상태. 즉 메모리 공간을 확보해주는거임.
        a1 = new byte[5];
        a1 = null; // 소멸시키고 싶을 때 사용하면 됨

        int num = 10;
//        num = null;  리터럴 상수라 안됨.  -> num = 0; 이거도 동일한 원리임

        class Student{
            String name;
            double[] scores;
        }

        Student s = new Student();
        s.name = "강민재3";
        s.scores = new double[3];
        s.scores[0] = 70.0;

        Student[] students = new Student[4];
        students[0] = new Student();
        students[0].name = "강민재";
        students[1] = new Student();
        students[1].name = "민인규";

        Student[] students2 = students; //위에 있는 students 배열의 주소와 동일한 주소를 가리키고 있음
        students2[0] = s;
        students2[0].scores[1] = 80.5;



    }

}
