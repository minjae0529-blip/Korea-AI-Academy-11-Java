package com.korai.study;

//클래스 영역 (클래스 로딩에 대한 이해)

public class MethodArea {
    //jvm 메모리 구조 코드로 확인하기
    public static void main(String[] args) {

    TestObject.age = 14;

    }

}


//정보제공 (후라이팬 예시)
class TestObject{
    String name;
    static int age;

     static {
         System.out.println("호출");
     }

}
