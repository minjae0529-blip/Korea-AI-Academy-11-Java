package com.korai.ch13;

public class AnonymousClass01 {
    //자바스크립트에는 익명함수 존재, 자바에서는 익명 클래스 존재
    //익명클래스 : 말 그대로 클래스의 이름이 없는거임
    //1회성 클래스임, 재사용 할 일이 없는것을 익명클래스로 만들어야 함
    //재사용할 일 없는 일 :
    class A extends Object{}
    Object object2 = new A();

    Object object = new Object(){};     //objcet를 상속받은 클래스를 상속받은 이름없는 클래스를 정의와 동시에 생성

    class B{}
    Object object3 = new B();

    class C {}
    Object object4 = new C() {}; //C클래스를 상속받은 익명 클래스

    abstract class D extends C{}
    D object5 = new D() {};     //D에서 만드는게 아니라 자식에서 구현

    interface E{}
    E object6 = new E() {};


}

