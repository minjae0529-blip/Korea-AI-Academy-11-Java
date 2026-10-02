package com.korai.ch07;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * ==============================================================================
 * [연습문제 4] 2차원 중첩 리스트 (List<List<String>>) 카테고리 관리
 * ==============================================================================
 *
 * [학습 목표]
 * 1. List<List<String>> 구조의 초기화 및 데이터 추가(add) 방식 숙지
 * 2. 외부 리스트(카테고리)와 내부 리스트(아이템 목록)의 계층 구조 이해
 * 3. 이중 for문(인덱스 기반 vs 향상된 for문)을 이용한 2차원 리스트 순회 출력
 *
 * [요구사항]
 * 1. 2차원 리스트 marketList 생성 (List<List<String>> marketList = new ArrayList<>();)
 * 2. 3개의 카테고리(내부 리스트)를 생성하여 marketList에 추가:
 *    - 0번 인덱스: [전자기기] -> "맥북", "아이폰", "아이패드" (ArrayList 사용)
 *    - 1번 인덱스: [과일음료] -> "아메리카노", "사과주스", "바나나우유" (LinkedList 사용)
 *    - 2번 인덱스: [야식메뉴] -> "치킨", "피자", "마라탕", "맥주" (ArrayList 사용)
 *
 * 3. 이중 향상된 for문을 사용하여 모든 상품 목록을 카테고리별로 예쁘게 출력
 * 4. 2차원 리스트에서 [야식메뉴]의 2번째 인덱스("마라탕")를 직접 get(행).get(열)로 꺼내서 출력
 */

public class Practice04 {
    public static void main(String[] args) {
        System.out.println("========== [2차원 중첩 리스트 실습] ==========");

        // 1. 2차원 리스트 생성
        List<List<String>> marketList = new ArrayList<>();

        // 2. 카테고리별 내부 리스트 생성 및 추가
        // 카테고리 0: 전자기기 (ArrayList 사용)
        List<String> electronics = new ArrayList<>();
        electronics.add("맥북");
        electronics.add("아이폰");
        electronics.add("아이패드");
        marketList.add(electronics);

        // 카테고리 1: 과일음료 (LinkedList 사용)
        List<String> beverages = new LinkedList<>();
        beverages.add("아메리카노");
        beverages.add("사과주스");
        beverages.add("바나나우유");
        marketList.add(beverages);

        // 카테고리 2: 야식메뉴 (ArrayList 생성 후 직접 체이닝 추가)
        marketList.add(new ArrayList<>());
        marketList.get(2).add("치킨");
        marketList.get(2).add("피자");
        marketList.get(2).add("마라탕");
        marketList.get(2).add("맥주");

        // 3. 이중 반복문으로 전체 순회 출력
        String[] categoryNames = {"📱 전자기기", "☕ 과일음료", "🍗 야식메뉴"};

        for (int i = 0; i < marketList.size(); i++) {
            System.out.println("[" + categoryNames[i] + "]");
            List<String> subList = marketList.get(i);

            for (int j = 0; j < subList.size(); j++) {
                System.out.println("  " + (j + 1) + ". " + subList.get(j));
            }
            System.out.println();
        }

        // 4. 직접 인덱스로 특정 원소 뽑기
        // 야식메뉴(인덱스 2)에서 마라탕(인덱스 2) 가져오기
        String favoriteFood = marketList.get(2).get(2);
        System.out.println("👉 야식메뉴 2번 인덱스 바로 꺼내기: marketList.get(2).get(2) = " + favoriteFood);
    }
}
