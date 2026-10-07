package com.korai.ch02.practice;

import java.util.ArrayList;
import java.util.List;

public class MemoRepository {
    //메모장을 작성하면 작성한 내용들이 모이는 저장소

    private int autoIncrement = 1;
    private List<Memo> memos;

    //생성자
    public MemoRepository() {
        this.memos = new ArrayList<>();
    }

    //저장하는 기능 : 내가 1번을 쓰고 다음꺼를 쓰면 2번
    //숫자가 증가 int id, String name, String content

    public void insert(Memo memo){
        memo.setId(autoIncrement++);
        System.out.println("메모 1개가 추가되었습니다");
        memos.add(memo);
    }

    // 저장된 목록들을 확인할 수 있는 메서드
    public  List<Memo> printAll(){
        return memos;
    }



}
