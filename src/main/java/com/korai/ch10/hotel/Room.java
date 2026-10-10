package com.korai.ch10.hotel;

public class Room {
    private int roomNumber;         //객실번호
    private String type;            //객실(디럭스, 프리미엄 등)
    private boolean reserved;       //예약여부

    public Room(int roomNumber, boolean reserved, String type) {
        this.roomNumber = roomNumber;
        this.reserved = reserved;
        this.type = type;
    }

    public boolean isReserved() {
        return reserved;
    }

    public void setReserved(boolean reserved) {
        this.reserved = reserved;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomNumber=" + roomNumber +
                ", type='" + type + '\'' +
                ", reserved=" + reserved +
                '}';
    }

}
