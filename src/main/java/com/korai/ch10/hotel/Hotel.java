package com.korai.ch10.hotel;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
    //방 예약, 퇴실, 전체객실 현황, 방검색(객실번호)
    private List<Room> rooms;
    private final int capacity = 5;
    private int autoIncremet = 101;

    public Hotel() {
        this.rooms = new ArrayList<>();
    }

    //방등록
    // 방 등록
    public void addRoom(String type) {
        if (rooms.size() >= capacity) {
            System.out.println("더 이상 방을 등록할 수 없습니다.");
            return;
        }
        Room room = new Room(autoIncremet, type, false);
        rooms.add(room);
        System.out.println(autoIncremet + "호 (" + type + ") 등록 완료!");
        autoIncremet++;
    }

    //체크인
    public void checkIn(int roomNumber){
       Room room = search(roomNumber);
    }

    //방검색
    public Room search(int roomNumber){
        for(Room r : rooms){
            if(r.getRoomNumber() == roomNumber){
                return r;
            }
        }
        return null;
    }

    //객실 전체 출력
   public void printAll(){
        for(Room r : rooms){
            System.out.println(r);
        }
   }


}
