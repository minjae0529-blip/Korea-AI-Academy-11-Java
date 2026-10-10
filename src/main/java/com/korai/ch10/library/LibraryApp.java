package com.korai.ch10.library;

import java.util.Scanner;

public class LibraryApp {
    public static void main(String[] args) {
        //구현해야할 목록
        //책등록, 대출, 반납, 전체목록, 책검색, 종료(0)

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        Library library = new Library();

        while(running){
            System.out.println("==== 코리아 도서관 ====");
            System.out.println("1. 책 등록  2. 대출  3. 반납  4. 전체 목록  5. 책 검색  0. 종료");
            System.out.print("선택 > ");
            int num = scanner.nextInt();
            scanner.nextLine();

            if(num == 1){
                System.out.println("------ 책 등록 ------");
                System.out.print("책 제목 : ");
                String bookName = scanner.nextLine();
                System.out.print("저자 : ");
                String author = scanner.nextLine();
                library.insert(bookName, author);
            }

            if(num == 2){
                System.out.print("대여하실 책이름을 입력해주세요 : ");
                String br = scanner.nextLine();
                library.borrow(br);
            }

            if(num == 3){
                System.out.print("반납하실 책이름을 입력해주세요 :");
                String reBook = scanner.nextLine();
                library.returnBook(reBook);
            }

            if(num == 4){
                library.printAll();
            }

            if(num == 5){
                System.out.print("검색하실 책제목을 입력해주세요 : ");
                String bookName = scanner.nextLine();

                Book book = library.search(bookName);

                if (book == null) {
                    System.out.println("없는 책입니다.");
                } else {
                    System.out.println(book);
                }
            }


            if(num == 0){
                System.out.println("프로그램을 종료합니다.");
                running = false;
                return;
            }
        }

    }
}
