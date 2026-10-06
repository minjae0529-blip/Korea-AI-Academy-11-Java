package com.korai.ch09.service;
import com.korai.ch09.repository.CarRepository;
import java.util.ArrayList;

public class InitService implements Runnable {

    // 프로그램 전체에서 공유할 저장소. private이라 밖에서는 getter로만 꺼내 쓴다
    private static CarRepository carRepository;

    public InitService() {
        //유일한 객체를 생성하기 위해서 이런 코드가 있음
        if(carRepository == null){
            run();
        }

    }

    @Override           //new InitService하게 되면 실행
    public void run() {
        System.out.println("프로그램 초기설정 시작");
        // run()이 실행되면 빈 ArrayList를 가진 CarRepository 객체를 만들어서 carRepository에 저장한다
        carRepository = new CarRepository(new ArrayList<>());
        System.out.println("프로그램 초기설정 완료");
    }

    // private인 carRepository를 밖에서 쓸 수 있게 돌려주는 getter
    public static CarRepository getCarRepository() {
        return carRepository;
    }


}
