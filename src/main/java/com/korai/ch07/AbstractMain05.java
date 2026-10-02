package com.korai.ch07;

public class AbstractMain05 {
    public static void main(String[] args) {
        SmartPhone smartPhone = new SmartPhone();
        smartPhone.call();

        FeaturePhone featurePhone = new FeaturePhone();
        featurePhone.print1();
        featurePhone.print2();
        System.out.println(featurePhone.phoneNumber);
    }
}
//부모객체먼저 생성, 이후에 자식 클래스
class Phone{
    String phoneNumber;

    public Phone() {
        System.out.println("Phone 생성자 호출");
    }
    void call(){
        System.out.println("띠리링 전화거는 중");
    }
}

class SmartPhone extends Phone{
    public SmartPhone() {
        System.out.println("SmartPhone 생성자 호출");
    }

    @Override
    void call() {
        super.call();
        System.out.println("전화 어플에 들어가서 전화");
    }
}

class FeaturePhone extends  Phone{
    String phoneNumber;

    public FeaturePhone() {
        this.phoneNumber = phoneNumber;
        System.out.println("FeaturePhone 생성자 호출");
        phoneNumber = "010-2222-2222";
        super.phoneNumber ="010-1111-1111";
    }

    void print1(){
        System.out.println(phoneNumber);
    }

    void print2(){
        System.out.println(super.phoneNumber);
    }

}
