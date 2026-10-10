package com.korai.ch10.TODO;

import com.korai.ch10.TODO.repository.TodoRepository;
import com.korai.ch10.TODO.repository.UserRepository;
import com.korai.ch10.TODO.router.RootRouter;
import com.korai.ch10.TODO.service.TodoService;
import com.korai.ch10.TODO.service.UserService;
import com.korai.ch10.TODO.view.LoginView;
import com.korai.ch10.TODO.view.TodoListView;
import com.korai.ch10.TODO.view.View;

import java.util.Map;

public class TodoApplication {

    /*
     * [main 메서드 동작 설명]
     * 1. RootRouter.setUp()을 호출하여 애플리케이션의 모든 Repository, Service, View 객체를 초기화 및 연결합니다.
     * 2. while(true) 무한 루프를 돌며 RootRouter.getCurrentView()로 현재 활성화된 View 객체를 가져오고,
     *    .show() 메서드를 실행하여 콘솔 화면을 계속해서 유지합니다.
     */
    public static void main(String[] args) {
        RootRouter.setUp();

        while(true) {
            RootRouter.getCurrentView().show();
        }
    }
}