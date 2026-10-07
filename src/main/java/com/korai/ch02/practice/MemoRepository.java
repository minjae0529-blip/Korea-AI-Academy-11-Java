package com.korai.ch02.practice;

import java.util.ArrayList;
import java.util.List;

public class MemoRepository {

    /*
     * [선언 이유: private int autoIncrement = 1]
     * - 새로 등록되는 Memo 인스턴스에 고유한 번호(id)를 1부터 1씩 증가시키며 부여하기 위한 정수형 카운터 변수입니다.
     */
    private int autoIncrement = 1;

    /*
     * [선언 이유: private List<Memo> memos]
     * - 생성된 Memo 객체들을 메모리(Heap) 상에 차곡차곡 보관해 두기 위한 List 컬렉션 참조 변수입니다.
     */
    private List<Memo> memos;

    /*
     * [작성 이유: 생성자 MemoRepository()]
     * - MemoRepository 객체가 new로 생성될 때, memos 변수에 실제 ArrayList 객체 인스턴스(new ArrayList<>())를
     *   할당하여 초기화하기 위함입니다. 이렇게 해야 null 상태가 되지 않아 NullPointerException을 방지할 수 있습니다.
     */
    public MemoRepository() {
        this.memos = new ArrayList<>();
    }

    /*
     * [작성 이유: public void insert(Memo memo)]
     * - 매개변수로 전달받은 memo 객체의 setId() 메서드를 호출하여 현재 autoIncrement 값을 주입하고,
     *   후위 증가 연산자(++)를 통해 다음 저장을 위해 카운터를 1 올립니다.
     * - memos 리스트의 add() 메서드를 호출하여 번호가 부여된 Memo 인스턴스를 리스트에 추가(저장)합니다.
     */
    public void insert(Memo memo) {
        memo.setId(autoIncrement++);
        System.out.println("메모 1개가 추가되었습니다");
        memos.add(memo);
    }

    /*
     * [작성 이유: public List<Memo> printAll()]
     * - 지금까지 리스트에 저장된 모든 Memo 객체 목록을 외부(MemoService)에 그대로 반환하여,
     *   화면에서 목록을 출력할 수 있게 하기 위함입니다.
     */
    public List<Memo> printAll() {
        return memos;
    }

}
