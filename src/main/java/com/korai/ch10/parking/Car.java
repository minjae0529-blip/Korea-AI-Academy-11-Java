package com.korai.ch10.parking;

import java.time.LocalTime;

public class Car {
    //주차중인 차 상태
    private int no;
    private String carNumber;
    private boolean compact;        //자리 존재 여부
    private LocalTime entryTime;    //시간

    //생성자
    public Car(int no, String carNumber, boolean compact, LocalTime entryTime) {
        this.no = no;
        this.carNumber = carNumber;
        this.compact = compact;
        this.entryTime = entryTime;
    }

    //toString
    @Override
    public String toString() {
        return "Car{" +
                "no=" + no +
                ", carNumber='" + carNumber + '\'' +
                ", compact=" + compact +
                ", entryTime=" + entryTime +
                '}';
    }


    public int getNo() {
        return no;
    }

    public LocalTime getEntryTime() {
        return entryTime;
    }

    public boolean isCompact() {
        return compact;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setNo(int no) {
        this.no = no;
    }
}
