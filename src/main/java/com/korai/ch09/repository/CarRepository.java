package com.korai.ch09.repository;
import com.korai.ch09.entity.Car;
import java.util.List;

public class CarRepository {
    private Long autoIncrement = 1l;         // 자동으로 1씩 증가
    private final List<Car> carList;

    public CarRepository(List<Car> carList) {
        this.carList = carList;
    }

        public void insert(Car car) {
            car.setId(autoIncrement++);
            carList.add(car);
        }

    public Car delete(Long id) {
        for (int i = 0; i < carList.size(); i++) {
            if (carList.get(i).getId() != id) {
                continue;
            }
            return carList.remove(i);
        }
        return null;
    }

    // 현재까지 어떤 차량들이 있는지 한눈에 알아볼 수 있게 해주는 메서드
    public void printAll() {
        System.out.println("Car 전체 조회");
        for (Car car : carList) {       //향상된 for문 : 안에 내부 값들을 조건없이 다 꺼낼 때 사용
            System.out.println(car);
        }
        System.out.println();
    }

}
