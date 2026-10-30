package com.korai.ch03.practice;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.SortedMap;

@Data
@AllArgsConstructor
public class Visitor {
    //상태, 이름, 나이, 키, 돈, 탑승횟수
    private String name;
    private int age;
    private int length;
    private int haveMoney;
    private int takeCount;

    public void moneyCheck(int price){
        if(price < haveMoney){
            System.out.println("비용이 부족해 이용하실 수 없습니다");
        }else if(price > haveMoney){
            System.out.println("탑승가능");
        }
    }

    public void sendMoney(int price){
        haveMoney -= price;
    }

    public void count(){
        takeCount++;
    }
}
