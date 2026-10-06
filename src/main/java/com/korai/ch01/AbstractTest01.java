package com.korai.ch01;

import java.util.LinkedList;
import java.util.List;

public class AbstractTest01 {
    public static void main(String[] args) {
    Dog dog = new Dog();
    Cat cat = new Cat();

    Animal animalToDog =  dog;
    Animal animalToCat =  cat;

    animalToDog.move();
    animalToCat.move();

//    Dog dog1 = (Dog) animalToDog;
//    dog1.move();                         다운케스팅 후 출력
//    ((Dog) animalToDog).move();         형변환 후 바로 메서드 실행

            if(animalToDog instanceof Dog){
                System.out.println("개입니다");
                ((Dog) animalToDog).cute();
                }

        if(animalToCat instanceof Cat){
            System.out.println("야옹입니다");
            ((Cat) animalToCat).eat();
        }

    }
}

class Animal{
    String name;
    int age;

    void move(){
        System.out.println("동물이 움직이고 있어요 이거는 부모클래스");
    }
}


class Dog extends Animal{

    String name;
    int age;

    @Override
    void move(){
        System.out.println("개가 움직여요. 이거는 자식클래스");
    }

    void cute(){
        System.out.println("귀여운 강아지가 애교를 부리네요");
    }
}


class Cat  extends  Animal{
    String name;
    int age;

    void eat(){
        System.out.println("고양이가 츄르를 먹고 있어요");
    }
}