package com.korai.ch10.TODO.view;

/*
 * [인터페이스 정의 이유: public interface View]
 * - LoginView, TodoListView, TodoRegisterView, TodoStatusView 등 모든 화면 클래스가
 *   반드시 'public void show()' 메서드를 구현하도록 강제하는 표준 규격(Contract)입니다.
 * - RootRouter의 viewMap과 TodoApplication에서 구체적인 클래스 타입 대신 이 'View' 인터페이스 타입으로
 *   객체들을 다형적으로 묶어서 관리하고, view.show()를 호출하기 위해 정의한 것입니다.
 */
public interface View {

    /*
     * [메서드 선언 이유: public void show()]
     * - 화면의 UI를 콘솔에 출력하고, 사용자 입력을 받아 다음 상태를 처리하는 메서드입니다.
     * - 반환 타입이 void인 이유: 각 구현체 클래스 내부에서 작업이 끝나면 RootRouter.setCurrent(...)를 통해
     *   다음 화면 경로를 직접 설정하기 때문입니다.
     */
    public void show();

}
