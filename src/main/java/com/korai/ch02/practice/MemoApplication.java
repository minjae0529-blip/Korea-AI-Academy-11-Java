package com.korai.ch02.practice;

public class MemoApplication {

    public static void main(String[] args) {
        // [1단계]: 보관함(저장소)을 먼저 만든다!
        MemoRepository memoRepository = new MemoRepository();

        // [2단계]: 매니저를 만들면서 보관함을 쥐여준다! (의존성 주입)
        MemoService memoService = new MemoService(memoRepository);

        // [3단계]: 화면을 만들면서 매니저를 연결해준다! (의존성 주입)
        MemoView memoView = new MemoView(memoService);

        // [4단계]: 시동 켜기! 꺼지기 전까지 계속 화면을 돌린다 (while 무한루프)
        while (true) {
            memoView.show();
        }
    }
}