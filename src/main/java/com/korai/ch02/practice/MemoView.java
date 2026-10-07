package com.korai.ch02.practice;

import java.util.List;
import java.util.Scanner;

public class MemoView {

    private MemoService memoService;
    private Scanner scanner;

    // [이유]: 외부에서 매니저(MemoService)를 전달받고, 키보드 입력기를 준비합니다.
    public MemoView(MemoService memoService) {
        this.memoService = memoService;
        this.scanner = new Scanner(System.in);
    }

    public void show() {
        System.out.println("\n===== [ 📝 미니 방명록 ] =====");
        System.out.println("1. 메모 등록");
        System.out.println("2. 메모 목록 보기");
        System.out.println("q. 프로그램 종료");
        System.out.print("선택 >>> ");
        String cmd = scanner.nextLine();

        // 1번 선택: 메모 쓰기
        if ("1".equals(cmd)) {
            System.out.print("작성자 이름 : ");
            String name = scanner.nextLine();
            System.out.print("메모 내용 : ");
            String content = scanner.nextLine();

            // 매니저에게 등록 요청!
            memoService.register(name, content);

            // 2번 선택: 목록 보기
        } else if ("2".equals(cmd)) {
            List<Memo> memos = memoService.getMemos();

            if (memos == null || memos.isEmpty()) {
                System.out.println("등록된 메모가 없습니다.");
            } else {
                for (Memo m : memos) {
                    System.out.println(m); // Memo의 toString() 출력
                }
            }

            // q 선택: 종료하기
        } else if ("q".equalsIgnoreCase(cmd)) {
            System.out.println("프로그램을 종료합니다. 안녕히 가세요!");
            System.exit(0); // 프로그램 즉시 종료
        } else {
            System.out.println("잘못된 입력입니다. 다시 입력하세요.");
        }
    }
}