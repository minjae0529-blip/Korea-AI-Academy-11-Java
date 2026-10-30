package com.korai.ch12;

/*
Collection : 여러개의 데이터를 관리하는 방법 -> 핵심 : 데이터의 중복을 허용하지 않아야 함.
 - 중복을 허용할려고하면 인덱스 번호 또는 키값으로 구분해야 한다.

1. 배열
2. 리스트 - ArrayList, LinkedList
  * LinkedList :
  *
3. 세트 - HashSet
4. 맵 - HashMap : 순서는 존재하지 않음, 다만 중복은 허용함. 키 값은 중복하지 않는거임
 */

import java.util.ArrayList;

public class CollectionMain01 {
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<>();
        strings.add("자바");
        strings.add("파이썬");

        StringArrayList strList = new StringArrayList();
        strList.add("자바");
        strList.add("파이썬");

        System.out.println(strings.get(0));
        System.out.println(strList.get(1));

        strings.set(1, "자바스크립트");
        System.out.println(strings);

        strList.set(1, "자바스크립트");   // strList도 같은 동작을 하도록 추가
        System.out.println(strList);

        String removedValue = strings.remove(0);
        System.out.println(removedValue);
        System.out.println(strings);

        String removedValue2 = strList.remove(0);
        System.out.println(removedValue2);
        System.out.println(strList);
    }
}

class StringArrayList {
    private String[] list;

    public StringArrayList() {
        list = new String[0];
    }

    // 값 추가: 길이가 1 큰 새 배열을 만들어 복사한 뒤 마지막에 추가
    public void add(String str) {
        String[] newArray = new String[list.length + 1];
        for (int i = 0; i < list.length; i++) {
            newArray[i] = list[i];
        }
        newArray[newArray.length - 1] = str;
        list = newArray;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        for (int i = 0; i < list.length; i++) {
            builder.append(list[i]);
            if (i < list.length - 1) {   // 마지막 요소 뒤에는 쉼표 없음
                builder.append(", ");
            }
        }
        builder.append("]");
        return builder.toString();
    }

    public String get(int index) {
        return list[index];
    }

    // 원하는 위치의 값을 변경
    public void set(int index, String content) {
        list[index] = content;
    }

    // 값 삭제: 길이가 1 작은 새 배열을 만들어 삭제 대상만 빼고 복사
    public String remove(int index) {
        String[] newArray = new String[list.length - 1];        //배열은 새로 추가하거나 제거하면 그 배열을 새로 만들고 붙혀야 함
        String removedValue = list[index];
        for (int i = 0; i < newArray.length; i++) {   // 새 배열 기준으로 반복
            if (i < index) {
                newArray[i] = list[i];       // 삭제 위치 앞: 그대로 복사
            } else {
                newArray[i] = list[i + 1];   // 삭제 위치 이후: 한 칸 뒤 요소를 가져옴
            }
        }
        list = newArray;
        return removedValue;
    }
}