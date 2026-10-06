package com.korai.ch07;

import java.util.LinkedList;
import java.util.List;

public class AbstractMain04 {
    public static void main(String[] args) {
        Dog3 dog = new Dog3();      //dog라는 새로운 인스턴스 생성
        Tiger3 tiger = new Tiger3(); // tiger라는 새로운 인스턴스 생성
        Animal3 animal = new Animal3();
        Animal3 animal1 = dog;      //Animal3를 바라보고 있음.
        Animal3 animal2 = tiger;

        animal1.move(); //animal1에 있는 move라는 메서드 실행
        animal2.move();

        Dog3 animal1ToDog = (Dog3) animal1;
        animal1ToDog.bark();
        ((Dog3) animal1).bark();

//        Dog3 animal2ToDog = (Dog3) animal2;
//        animal2ToDog.bark();
//        ((Dog3) animal2).bark();

        List<Animal3> animal3s = new LinkedList<>();
        animal3s.add(new Dog3());
        animal3s.add(new Tiger3());
        animal3s.add(new Dog3());


        // 가장중효한거 : 배열은 lnngth이지만, 리스트에서는 size임
        // 무엇보다 다운케스팅, 업케스팅 하는데 조건문 활용
        // instanceof : 객체를 비교할 수 있는거, 조건문에 객체를 비교
        for (int i = 0; i < animal3s.size(); i++) {
            animal3s.get(i).move();
            if (animal3s.get(i) instanceof Dog3) {
                Dog3 d = (Dog3) animal3s.get(i);
                d.bark();
            } else if (animal3s.get(i) instanceof Tiger3) {
                Tiger3 t = (Tiger3) animal3s.get(i);
                t.hunt();
            }
        }

    }
}

class Animal3 {
    String name;

    void move() {
        System.out.println("움직인다");
    }
}

class Dog3 extends Animal3 {
    @Override
        // 어노테이션
    void move() {
        System.out.println("많이움직인다");
    }

    void bark() {
        System.out.println("짖다");
    }

}

class Tiger3 extends Animal3 {
    void hunt() {
        System.out.println("사냥하다");
    }
}