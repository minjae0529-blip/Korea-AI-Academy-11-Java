package com.korai.ch10.parking;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ParkingApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ParkingLot lot = new ParkingLot();
//      boolaen runnung = true;
//      HH:mm -> 시간, 분 / MM -> 달
        while (true) {
            System.out.println("==== 코리아 주차장 ====");
            System.out.println("1. 입차 2. 출차 3. 주차현황 4. 차량검색 5. 오늘 매출 0. 종료");
            System.out.print("선택 > ");
            //nextInt() -> nextLine() 넘어갈 때 sc.nextLine() 청소를 해야 입력이 가능함 규칙임
            int num = sc.nextInt();
            sc.nextLine();

            switch (num) {
                case 1:
                    System.out.println();
                    System.out.println("------ 입차 ------");
                    System.out.print("차량번호 : ");
                    String carNumber = sc.nextLine();

                    System.out.print("차종 (1. 일반  2. 경차) > ");
                    int type = sc.nextInt();

                    String typeName = (type == 2) ? "경차" : "일반";

                    System.out.print("출입시간을 적어주세요 :");
                    String timeInput = sc.nextLine();
                    sc.nextLine();
//                    LocalTime localTime = LocalTime.parse(timeInput);

                    System.out.println();
                    System.out.println("입차가 완료되었습니다.");
                    System.out.println("차량번호 : " + carNumber);
                    System.out.println("차종     : " + typeName);
                    System.out.println("입차시간 : " + timeInput);
                    System.out.println("------------------");
                    System.out.println();
                    Car car = new Car(0, carNumber, type == 2, LocalTime.now());
                    lot.park(car);
                    break;

                case 2:
                    System.out.print("차량번호 : ");
                    String outNumber = sc.nextLine();
                    lot.exit(outNumber);
                    // carNumber = get(i).boolean = false;
                    //이런식에 메서드가 필요함
                    // 차량 목록이 들어있는 리스트를 띄워주는 메서드 필요
                    break;

                case 3:
                    // 몇번인지, 차량번호, 경차인지 아닌지, 언제 입차했는지
                    lot.printAll();
                    break;

                case 4:
                    //차량을 찾아주는 메서드
                    System.out.print("차량번호 : ");
                    String searchNumber = sc.nextLine();
                    System.out.println(lot.findCar(searchNumber));
                    break;

                case 5:
                    System.out.println("오늘 매출은 : ");
                    int total = 0;
                    // totalMoney 메서드 구현 필요
                    break;

                case 0:
                    System.out.println("프로그램을 종료합니다");
                    System.exit(0);
                    break;

                default:
                    System.out.println("잘못된 입력입니다.");
            }
        }
    }
}