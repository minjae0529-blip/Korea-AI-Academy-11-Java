package com.korai.ch01.practice;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        IntArrayList nums = new IntArrayList();
        nums.add(10);
        nums.add(20);
        nums.add(30);
        System.out.println(nums);          // [10, 20, 30]
        nums.set(1, 99);
        System.out.println(nums.get(1));   // 99
        System.out.println(nums);          // [99, 30]
    }
}

class IntArrayList {
    private int[] list;

    public IntArrayList() {
        list = new int[0];
    }

    public void set(int index, int content){
        list[index] = content;
    }

    public void add(int value) {
        // StringArrayList의 add를 보고 타입만 int로 바꿔 보세요
        int[] newArray = new int[list.length + 1];
        for (int i = 0; i < list.length; i++) {
            newArray[i] = list[i];          //값 복사
        }
        newArray[newArray.length - 1] = value;
        list = newArray;
    }

    public int get(int index) {
        return list[index];
    }

    // set, remove, toString도 같은 방식으로 채우면 돼요

    @Override
    public String toString() {
        return "IntArrayList{" +
                "list=" + Arrays.toString(list) +
                '}';
    }
}
