package com.korai.ch01.practice;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Scanner;

public class Movie {
    public static void main(String[] args) {
        String
    }
}
@NoArgsConstructor
@Data
class 티켓{
    int 좌석번호 = 4;
    String 영화제목;
    int 가격;

    public 티켓(int 좌석번호, String 영화제목, int 가격) {
        this.좌석번호 = 좌석번호;
        this.영화제목 = 영화제목;
        this.가격 = 가격;
    }
}

class 영화관{
    static int 좌석번호 = 1;
    static int 남은좌석 = 3;        //남은 좌석
    static int 총매출;

    public 영화관() {
        System.out.println("영화관 생성자 호출 ");
    }

    //static int 가격계산(int 나이) : 나이가 20 미만이면 8000, 아니면 12000
    static int 가격계산(int age){
        int price = 12000;
        if(age < 20){
            price -= 4000;
        }
        return 12000;
    }

    //티켓예매 :
    public static 티켓예매(String 영화제목, int 나이){
        if(남은좌석 < 0){
            System.out.println("선태하신 영화에 좌석이 없습니다" + 영화제목 +"매진");
            return null;
        }

        if(남은좌석 > 좌석번호){
            System.out.println("선택하신 영화 예매가 성공하였습니다" + 영화제목);
            남은좌석 --;
        }
        return ;
    }


}
