package com.korai.ch02.practice;

import java.util.List;
import java.util.Scanner;

public class MemoView {

    /*
     * [선언 이유: private MemoService memoService]
     * - 이 클래스(MemoView) 안에서 MemoService 객체가 가지고 있는
     *   register() 메서드(등록)와 getMemos() 메서드(조회)를 호출하기 위해 선언한 참조 변수입니다.
     */
    private MemoService memoService;

    /*
     * [선언 이유: private Scanner scanner]
     * - 사용자가 콘솔에 키보드로 입력한 문자열을 읽어들이기 위해 Scanner 객체의 nextLine() 메서드를 사용하려고 선언한 것입니다.
     */
    private Scanner scanner;

    /*
     * [작성 이유: 생성자 매개변수로 MemoService 받기 (의존성 주입 DI)]
     * - 외부(MemoApplication)에서 생성된 MemoService 객체 인스턴스를 매개변수로 전달받아
     *   this.memoService에 보관해 두고 메서드를 호출하기 위함입니다.
     * - 뷰가 생성될 때 Scanner도 1회만 초기화하여 메모리를 아낍니다.
     */
    public MemoView(MemoService memoService) {
        this.memoService = memoService;
        this.scanner = new Scanner(System.in);
    }

    /*
     * [작성 이유: public void show()]
     * - 콘솔에 방명록 메뉴를 출력하고, 사용자의 입력(cmd)에 따라 적절한 기능을 수행하는 메서드입니다.
     */
    public void show() {
        System.out.println("\n===== [ 📝 미니 방명록 ] =====");
        System.out.println("1. 메모 등록");
        System.out.println("2. 메모 목록 보기");
        System.out.println("q. 프로그램 종료");
        System.out.print("선택 >>> ");
        String cmd = scanner.nextLine(); // Scanner 객체의 nextLine() 메서드로 사용자 명령어 입력 대기

        /*
         * [작성 이유: "1".equals(cmd)]
         * - 문자열 리터럴 "1"을 앞에 두고 equals()를 호출하여, 혹시 cmd가 null이어도 NPE 예외 없이 안전하게 비교합니다.
         */
        if ("1".equals(cmd)) {
            System.out.print("작성자 이름 : ");
            String name = scanner.nextLine();
            System.out.print("메모 내용 : ");
            String content = scanner.nextLine();

            /*
             * [작성 이유: memoService.register(name, content)]
             * - MemoService 객체의 register() 메서드를 호출하여,
             *   새로운 Memo 객체 생성 및 저장소(MemoRepository) 저장을 위임합니다.
             */
            memoService.register(name, content);

        } else if ("2".equals(cmd)) {
            /*
             * [작성 이유: memoService.getMemos()]
             * - MemoService 객체의 getMemos() 메서드를 호출하여 List<Memo> 데이터를 받아옵니다.
             * - 비어있는지 확인한 후, for-each문으로 각 Memo 인스턴스의 toString()을 콘솔에 출력합니다.
             */
            List<Memo> memos = memoService.getMemos();

            if (memos == null || memos.isEmpty()) {
                System.out.println("등록된 메모가 없습니다.");
            } else {
                for (Memo m : memos) {
                    System.out.println(m); // Memo 클래스의 toString() 자동 호출
                }
            }

        } else if ("q".equalsIgnoreCase(cmd)) {
            /*
             * [작성 이유: System.exit(0)]
             * - 현재 실행 중인 JVM(자바 가상 머신) 프로세스를 완전히 종료시키는 표준 메서드입니다.
             */
            System.out.println("프로그램을 종료합니다. 안녕히 가세요!");
            System.exit(0);
        } else {
            System.out.println("잘못된 입력입니다. 다시 입력하세요.");
        }
    }
}