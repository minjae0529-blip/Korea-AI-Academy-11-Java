package com.korai.ch10;

public class SingletonMain {
    public static void main(String[] args) {
        StudentService studentService = StudentService.getInstance();
        StudentService studentService1 = StudentService.getInstance();
        studentService.기능1();
        studentService1.기능1();
    }
}

//싱글톤 패턴 : 객체를 프로그램 전체에서 딱 하나만 만들어 두고, 모두가 그 하나를 같이 쓰게 하는 설계 방식
//중복생성방지 가능, 접근이 편, 메모리 절약가능

class StudentService{
    //  1) 자기 자신 객체를 static으로 하나만 만들어 둠
    private static StudentService instance;

    // 2) 생성자를 private으로 막아서 밖에서 new를 못 하게 함
    private StudentService() {}

    //외부에서 생성자를 통한 객체 생성이 불가능함. static메서드를 통해서 접근해서 객체를 생성 및 받아올 수 있음
    // 3) 하나뿐인 객체를 꺼내 주는 static getter
    public static StudentService getInstance(){
        if(instance == null){
            instance = new StudentService();
        }
        return instance;
    }

    public void 기능1(){

    }

}
