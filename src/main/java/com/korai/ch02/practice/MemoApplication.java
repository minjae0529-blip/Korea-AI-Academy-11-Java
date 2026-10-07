package com.korai.ch02.practice;

public class MemoApplication {

    public static void main(String[] args) {

        /*
         * [작성 이유 1: new MemoRepository()]
         * - 가장 하위 계층인 저장소 객체를 메모리에 먼저 인스턴스화합니다.
         * - 이 객체 안에 빈 ArrayList와 autoIncrement 카운터(1)가 준비됩니다.
         */
        MemoRepository memoRepository = new MemoRepository();

        /*
         * [작성 이유 2: new MemoService(memoRepository)]
         * - MemoService 객체를 생성하면서, 방금 위에서 만든 memoRepository 인스턴스의 주소값을
         *   생성자 매개변수로 전달(의존성 주입 DI)합니다.
         * - 이유: MemoService 내부에서 memoRepository.insert()와 printAll() 메서드를 호출할 수 있게 연결하기 위함입니다.
         */
        MemoService memoService = new MemoService(memoRepository);

        /*
         * [작성 이유 3: new MemoView(memoService)]
         * - MemoView 객체를 생성하면서, 위에서 만든 memoService 인스턴스의 주소값을
         *   생성자 매개변수로 전달(의존성 주입 DI)합니다.
         * - 이유: MemoView 내부에서 memoService.register()와 getMemos() 메서드를 호출할 수 있게 연결하기 위함입니다.
         */
        MemoView memoView = new MemoView(memoService);

        /*
         * [작성 이유 4: while (true)]
         * - 사용자가 'q'를 입력하여 System.exit(0)으로 프로세스를 종료하기 전까지,
         *   memoView 객체의 show() 메서드를 지속적으로 반복 호출하여 화면을 유지하기 위한 이벤트 루프입니다.
         */
        while (true) {
            memoView.show();
        }
    }
}