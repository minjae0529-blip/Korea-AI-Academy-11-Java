package com.korai.serveltstudy2.model.repository;

import com.korai.serveltstudy2.model.Car;   // Car 위치에 맞게 확인

import java.util.ArrayList;
import java.util.List;

public class CarRepository {

    private static final CarRepository instance = new CarRepository();

    private CarRepository() {}

    public static CarRepository getInstance() {
        return instance;
    }

    private final List<Car> cars = new ArrayList<>();   // 반드시 new로 만들기

    // 차량 전체 조회
    public List<Car> findByCarAll() {
        return cars;
    }

    public Car findByCarNumber(int carNumber) {
        for (Car c : cars) {
            if (c.getCarNumber() == carNumber) {
                return c;
            }
        }
        return null;
    }

    public boolean isDuplicatedCarNumber(int carNumber) {
        return findByCarNumber(carNumber) != null;
    }

    public void save(Car car) {
        cars.add(car);
    }
}