package com.korai.ch10.TODO.view;

/*
 * [인터페이스 정의 이유: public interface View]
 * - 모든 화면 구현체 클래스(LoginView, TodoListView, TodoRegisterView, TodoStatusView)가
 *   공통으로 show() 메서드를 구현하도록 강제하는 인터페이스입니다.
 * - RootRouter에서 Map<String, View> 형태로 다양한 화면 객체를 다형성을 통해 일관되게 다루기 위해 정의되었습니다.
 */
public interface View {

    /*
     * [메서드 선언 이유: void show()]
     * - 화면의 UI를 콘솔에 출력하고 입력을 처리하는 메서드 규격입니다.
     */
    void show();
}
