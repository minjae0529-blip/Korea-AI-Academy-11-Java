package com.korai.ch02.practice;

import java.util.List;

public class MemoService {

    private MemoRepository memoRepository;

    // [의존성 주입]: 저장소를 밖에서 받아서 쥐고 있음!
    //객체를 만들 때 생성자 사용
    public MemoService(MemoRepository memoRepository) {
        this.memoRepository = memoRepository;
    }

    // 1. 메모 등록 기능
    public void register(String name, String content) {
        Memo memo = new Memo(0, name, content); // 새 메모 객체 생성 (id는 임시 0)
        memoRepository.insert(memo);            // 저장소에 넣기!
    }

    // 2. 전체 메모 목록 가져오기 기능
    public List<Memo> getMemos() {
        return memoRepository.printAll();       // 저장소에서 목록 꺼내주기!
    }
}