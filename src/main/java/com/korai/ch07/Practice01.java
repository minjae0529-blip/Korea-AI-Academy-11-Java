package com.korai.ch07;

import java.util.ArrayList;
import java.util.List;

/**
 * ========================================================
 * [연습문제] 자바 객체지향 추상화 & 컬렉션 List 실습 과제
 * ========================================================
 *
 * [요구사항]
 * 1. 추상 클래스 Vehicle
 *    - 필드: String model
 *    - 생성자: model을 매개변수로 받아 초기화
 *    - 추상 메서드: abstract void drive();
 *
 * 2. 자식 클래스 Car (Vehicle 상속)
 *    - 생성자: model 전달받아 부모 생성자 호출 (super 이용)
 *    - drive() 오버라이딩: "[model] 자동차가 도로를 주행합니다." 출력
 *    - Car만의 고유 메서드: void openTrunk() -> "트렁크를 엽니다." 출력
 *
 * 3. 자식 클래스 Airplane (Vehicle 상속)
 *    - 생성자: model 전달받아 부모 생성자 호출 (super 이용)
 *    - drive() 오버라이딩: "[model] 비행기가 활주로를 이륙합니다." 출력
 *    - Airplane만의 고유 메서드: void flyHigh() -> "고도 10,000m로 순항합니다." 출력
 *
 * 4. Practice01 main 메서드
 *    - List<Vehicle> 리스트 생성
 *    - Car 2대, Airplane 1대를 리스트에 추가
 *    - 향상된 for문으로 모든 Vehicle의 drive() 호출
 *    - instanceof와 다운캐스팅을 활용하여:
 *      * Car 객체인 경우 openTrunk() 호출
 *      * Airplane 객체인 경우 flyHigh() 호출
 */

abstract class Vehicle {
    String model;

    Vehicle(String model) {
        this.model = model;
    }

    abstract void drive();
}

class Car extends Vehicle {
    Car(String model) {
        super(model);
    }

    @Override
    void drive() {
        System.out.println(model + " 자동차가 도로를 주행합니다.");
    }

    void openTrunk() {
        System.out.println("  -> [Car 기능] 트렁크를 엽니다.");
    }
}

class Airplane extends Vehicle {
    Airplane(String model) {
        super(model);
    }

    @Override
    void drive() {
        System.out.println(model + " 비행기가 활주로를 이륙합니다.");
    }

    void flyHigh() {
        System.out.println("  -> [Airplane 기능] 고도 10,000m로 순항합니다.");
    }
}

public class Practice01 {
    public static void main(String[] args) {
        System.out.println("=== 1. 다형성 리스트 생성 ===");
        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(new Car("아반떼"));
        vehicles.add(new Airplane("보잉747"));
        vehicles.add(new Car("제네시스"));

        System.out.println("\n=== 2. 향상된 for문 & instanceof 다운캐스팅 실행 ===");
        for (Vehicle v : vehicles) {
            // 다형성: 실제 객체(Car 또는 Airplane)의 오버라이딩된 drive() 실행
            v.drive();

            // 다운캐스팅 분기 처리
            if (v instanceof Car) {
                Car car = (Car) v;
                car.openTrunk();
            } else if (v instanceof Airplane) {
                Airplane airplane = (Airplane) v;
                airplane.flyHigh();
            }
            System.out.println("------------------------------------------");
        }
    }
}
