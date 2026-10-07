package com.korai.ch10.TODO;

import com.korai.ch10.TODO.router.RootRouter;

public class TodoApplication {

    public static void main(String[] args) {

        /*
         * [작성 이유: RootRouter.setUp()]
         * - RootRouter 클래스의 정적(static) 메서드인 setUp()을 호출하여,
         *   애플리케이션에 필요한 모든 Repository, Service, View 인스턴스를 생성하고 의존성을 조립(DI)하기 위함입니다.
         * - static 메서드이므로 'new RootRouter()' 없이 클래스명으로 직접 호출합니다.
         */
        RootRouter.setUp();

        /*
         * [작성 이유: while (true)]
         * - 콘솔 환경에서 main 메서드가 종료되어 프로세스가 죽는 것을 막고,
         *   사용자가 시스템을 종료할 때까지 화면을 지속적으로 갱신하고 입력을 대기하기 위한 이벤트 루프(Event Loop)입니다.
         */
        while (true) {

            /*
             * [작성 이유: RootRouter.getCurrentView().show()]
             * - 1. RootRouter.getCurrentView() : RootRouter의 viewMap에서 현재 current 경로에 해당하는 View 인터페이스 구현체 객체를 꺼냅니다.
             * - 2. .show() : 꺼내온 View 인스턴스의 show() 메서드를 호출하여 해당 화면을 콘솔에 출력하고 입력을 처리합니다.
             * - 다형성(Polymorphism) 덕분에 구체 클래스 타입(LoginView인지 TodoListView인지)을 몰라도 메서드 호출이 가능합니다.
             */
            RootRouter.getCurrentView().show();
        }
    }
}