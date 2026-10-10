package com.korai.ch10.parking;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    //차량 관리목록 : 주차되어 있는 차들을 가져와야하니 객체를 여기다가 생성해야함
    //그래서 그 객체가 담긴 리스트를 만든 후 사용자가 입력한 값들에 대해 그 리스트에 저장을 해야 함
    private List<Car> carList;
    private int autoincrement = 1;
    private Car car;
    static final int capacity = 10;

    public ParkingLot() {
        this.carList = new ArrayList<>();
    }

    //주차하는거
    public void park(Car car) {
        if (capacity == 0) {
            System.out.println("만차입니다");
            return;
        }
        car.setNo(autoincrement);
        carList.add(car);
        autoincrement++;
    }

    //주차장에 차가 뭐가 있는지
    public void printAll() {
        for (Car c : carList) {
            System.out.println(c);
        }
        System.out.println("현재 주차장의 자리는 : " + (capacity - carList.size()));
    }

    //차를 찾는 메서드 + 주차장 자리가 얼마나 있는지
    public Car findCar(String carNumber) {
        // 1. for문으로 carList에서 차를 하나씩 꺼낸다
        for (int i = 0; i < carList.size(); i++) {
            if (carList.get(i).getCarNumber().equals(carNumber)) {
                return carList.get(i);
            }
        }
        return null;
    }

    //차를 빼는 메서드
    public Car exit(String carNumber) {
        Car car = findCar(carNumber);   // 여기서 찾은 차를 car에 담음

        if (carNumber == null) {
            return null;
        } else {
            carList.remove(car);
            System.out.println("차량이 출고되었습니다.");
        }
        return car;
    }

}
