package com.korai.ch07;

import java.util.Timer;

public class AbstractMain02 {
    public static void main(String[] args) {
        Dog dog = new Dog();
        Cat cat = new Cat();
        dog.move();
        cat.hunt();
        Animal animal1 = dog;
    }
}

abstract class Animal {
    String name;
    void move() {
        System.out.println("움직인다");
    }
}

class Dog extends Animal {
    String name;
    void bark() {
        System.out.println("멍멍멍멍멍멍멍");
    }
}

class Cat extends Animal {
    void hunt() {
        System.out.println("사냥하다");
    }

}
