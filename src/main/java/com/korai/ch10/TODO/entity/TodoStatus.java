package com.korai.ch10.TODO.entity;

public enum TodoStatus {
    todo("진행전"), inProgress("진행중"), done("완료");

    /*
     * [선언 이유: private String status]
     * - 각 enum 상수가 가지는 한국어 설명 문자열("진행전", "진행중", "완료")을 저장하는 필드입니다.
     */
    private String status;

    TodoStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    /*
     * [메서드 설명: @Override public String toString()]
     * - 객체를 문자열로 출력(System.out.println)할 때 enum 상수명 대신
     *   한국어 상태 문자열(status)이 출력되도록 오버라이딩한 메서드입니다.
     */
    @Override
    public String toString() {
        return status;
    }
}
