package com.korai.ch09;

import com.korai.ch09.entity.Car;               // Car가 다른 패키지(entity)에 있어서, 이 파일에서 쓰려면 파일 맨 위에 import 필요
import com.korai.ch09.repository.CarRepository;
import com.korai.ch09.service.InitService;

public class CarMain {
    public static void main(String[] args) {
        //프로그램의 이점 : 각 기능들만 모아놓은 클래스를 활용해서 단일책임원칙 ?
        new InitService();

        InitService.getCarRepository().printAll();
        Car car = new Car(null, "15노 6810", "쏘나타Dn8", "강민재");
        Car car1 = new Car(null, "189누 3446", "K8", "김준일");
        Car car2 = new Car(null, "123가 4567", "아반떼", "이서연");
        Car car3 = new Car(null, "234나 5678", "쏘나타", "박민준");
        Car car4 = new Car(null, "45다 1234", "그랜저", "최지우");
        Car car5 = new Car(null, "312로 7890", "투싼", "정하늘");
        Car car6 = new Car(null, "67마 2468", "쏘렌토", "강도윤");
        Car car7 = new Car(null, "158보 1357", "K5", "윤서아");
        Car car8 = new Car(null, "221소 9753", "카니발", "임재현");
        Car car9 = new Car(null, "89우 8642", "G80", "한예린");
        Car car10 = new Car(null, "376주 3141", "팰리세이드", "오승우");

        InitService.getCarRepository().insert(car);
        InitService.getCarRepository().insert(car1);
        InitService.getCarRepository().insert(car2);
        InitService.getCarRepository().insert(car3);
        InitService.getCarRepository().insert(car4);
        InitService.getCarRepository().insert(car5);
        InitService.getCarRepository().insert(car6);
        InitService.getCarRepository().insert(car7);
        new InitService();      //싱글톤 : null인지 확인하는거 아주 중요함
        InitService.getCarRepository().insert(car8);
        InitService.getCarRepository().insert(car9);
        InitService.getCarRepository().insert(car10);
        Car deletedCar = InitService.getCarRepository().delete(5l);
        System.out.println("삭제된 차량정보");

        InitService.getCarRepository().printAll();
        InitService.getCarRepository().delete(5l);
        InitService.getCarRepository().printAll();

    }
}
