package com.korai.ch10.TODO.entity;

/*
 * [열거형 정의 이유: public enum TodoStatus]
 * - Todo의 진행 상태를 고정된 상수 집합으로 정의하여, 오타를 원천 차단하고 타입 안정성을 보장하기 위함입니다.
 */
public enum TodoStatus {

    /*
     * [상수 선언 이유]
     * - todo("진행전"), inProgress("진행중"), done("완료") 세 가지 인스턴스만 존재하도록 제한합니다.
     * - 괄호 안의 문자열("진행전" 등)은 생성자를 통해 status 필드에 주입됩니다.
     */
    todo("진행전"),
    inProgress("진행중"),
    done("완료");

    /*
     * [선언 이유: private String status]
     * - 각 enum 상수가 가지는 한국어 설명 문자열을 보관하는 멤버 변수입니다.
     */
    private String status;

    /*
     * [작성 이유: enum 생성자]
     * - 각 상수가 생성될 때 한국어 문자열("진행전" 등)을 status 필드에 할당하기 위한 생성자입니다.
     * - enum의 생성자는 private 접근제어자를 기본으로 가지므로 외부에서 new로 생성할 수 없습니다.
     */
    TodoStatus(String status) {
        this.status = status;
    }

    /*
     * [작성 이유: public String getStatus()]
     * - status 필드에 저장된 한국어 문자열을 외부에서 읽어갈 수 있도록 열어둔 Getter 메서드입니다.
     */
    public String getStatus() {
        return status;
    }

    /*
     * [작성 이유: public String toString()]
     * - 콘솔에 Todo 객체를 System.out.println()으로 찍을 때,
     *   해당 상수의 이름과 status 값이 알아보기 쉽게 문자열로 포맷팅되어 출력되도록 재정의(Override)한 것입니다.
     */
    @Override
    public String toString() {
        return "TodoStatus{" +
                "status='" + status + '\'' +
                '}';
    }
}
