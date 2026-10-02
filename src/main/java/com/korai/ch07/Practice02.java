package com.korai.ch07;

import java.util.List;

/**
 * ==============================================================================
 * [연습문제 2] 인터페이스와 default 메서드 & 다운캐스팅 (결제 시스템)
 * ==============================================================================
 *
 * [학습 목표]
 * 1. interface 정의 및 추상 메서드, default 메서드 작성법 숙지
 * 2. interface를 구현(implements)하는 여러 클래스 작성
 * 3. List<Payment> 인터페이스 타입의 다형성 리스트 활용
 * 4. 특정 결제 수단(CreditCard)만의 고유 기능을 instanceof 다운캐스팅으로 실행
 *
 * [요구사항]
 * 1. Payment 인터페이스:
 *    - void pay(int amount);           // 결제 추상 메서드
 *    - default void printReceipt() {   // default 메서드 (공통 영수증 출력)
 *          System.out.println("  [영수증] 결제가 정상 완료되었습니다.");
 *      }
 *
 * 2. CreditCardPayment 클래스 (Payment 구현):
 *    - 필드: String cardNumber
 *    - 생성자: 카드번호 초기화
 *    - pay(amount) 구현: "[cardNumber] 카드로 [amount]원 결제 완료" 출력
 *    - 고유 메서드: void setInstallment(int month) -> "[month]개월 할부 적용" 출력
 *
 * 3. CashPayment 클래스 (Payment 구현):
 *    - pay(amount) 구현: "현금 [amount]원 결제 완료 (현금영수증 자동 발행)" 출력
 *
 * 4. Practice02 main:
 *    - List.of(...)를 사용하여 카드 결제 2개, 현금 결제 1개를 리스트로 생성
 *    - 향상된 for문으로 모두 pay(10000) 및 printReceipt() 호출
 *    - 만약 CreditCardPayment라면 3개월 할부(setInstallment(3)) 메서드 호출
 */

interface Payment {
    void pay(int amount);

    default void printReceipt() {
        System.out.println("  -> [공통 영수증] 결제가 안전하게 처리되었습니다.");
    }
}

class CreditCardPayment implements Payment {
    private String cardNumber;

    public CreditCardPayment(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public void pay(int amount) {
        System.out.println("신용카드(" + cardNumber + ")로 " + amount + "원 결제했습니다.");
    }

    // 신용카드만의 고유 메서드
    public void setInstallment(int month) {
        System.out.println("  -> [카드 전용 옵션] " + month + "개월 무이자 할부를 적용합니다.");
    }
}

class CashPayment implements Payment {
    @Override
    public void pay(int amount) {
        System.out.println("현금으로 " + amount + "원 결제 완료 (현금영수증 발행)");
    }
}

public class Practice02 {
    public static void main(String[] args) {
        System.out.println("========== [결제 시스템 다형성 테스트] ==========");

        // List.of를 활용한 불변 리스트 생성
        List<Payment> payments = List.of(
                new CreditCardPayment("1234-5678-****"),
                new CashPayment(),
                new CreditCardPayment("9876-4321-****")
        );

        int payAmount = 25000;

        for (Payment payment : payments) {
            // 1. 다형성 메서드 호출
            payment.pay(payAmount);
            payment.printReceipt();

            // 2. instanceof 검사 및 다운캐스팅
            if (payment instanceof CreditCardPayment) {
                CreditCardPayment card = (CreditCardPayment) payment;
                card.setInstallment(3);
            }

            System.out.println("----------------------------------------------");
        }
    }
}
