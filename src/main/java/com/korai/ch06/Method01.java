package com.korai.ch06;

public class Method01 {
    public static void main(String[] args) {
        Method0101 m1 = new Method0101();
//      new Method0101().run();
        m1.run(new Method0101());       //  인스턴스
        Method0102.run("1"); // static

    }
}

class Method0101 {
    void run(Method0101 bbb) {
        //인스턴스 메서드
        System.out.println("왈왈");
    }
}

class Method0102 {
    static void run(String a) {
        //스태틱 메서드
        System.out.println("야옹");
        System.out.println(a);
    }
}