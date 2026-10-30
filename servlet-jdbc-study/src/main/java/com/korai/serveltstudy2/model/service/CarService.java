package com.korai.serveltstudy2.model.service;

import com.korai.serveltstudy2.model.Car;
import com.korai.serveltstudy2.model.repository.CarRepository;

import java.util.List;

public class CarService {
    private CarRepository carRepository;
    private List<Car> cars;
    //중복 제거
    public boolean isDuplicatedCarNumber(int carNumber){
        return carRepository.findByCarNumber(carNumber) != null;
    }

    //등록하는것
    public void regiseter(Car car){
        if(isDuplicatedCarNumber(car.getCarNumber())){
            System.out.println("중복된 차량번호가 있습니다");
        }
        cars.add(car);
    }
}
