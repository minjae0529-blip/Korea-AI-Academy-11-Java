package com.korai.ch10.library;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Library {
    //도서 등록, 도서 대출, 도서 반납, 도사관에 있는 책들 검색, 전체 목록
    private List<Book> books;
    private int autoIncrement = 1;
    private final int capacity = 5;
    private Scanner scanner;

    //  배열 생성자 선언과 초기화 
    public Library() {
        this.books = new ArrayList<>();     //배열 초기화
    }

    //도서 등록
    public void insert(String bookName,  String author){

        if(books.size() >= capacity){
            System.out.println("도서 등록은 최대 5개까지입니다.");
            return;
        }
        Book book = new Book(bookName, author, autoIncrement);   // ⭐ 받은 재료로 책 만들기
        books.add(book);
        book.setBookNumber(autoIncrement);
        System.out.println("도서가 등록되었습니다.");
        autoIncrement++;
    }

    //현재 있는 도서 전체 보기
    public void printAll(){
        for(Book book : books){
            System.out.println(book);
        }
    }

    //책 검색
    public Book search(String bookName){
     for(Book b : books){
         if(b.getBookName().equals(bookName)){
             return b;
         }
     }
     return null;
    }

    // 대출 기능
    public void borrow(String bookName) {
        // 1. search(bookName)으로 책을 찾아서 Book 변수에 담는다.
        Book book = search(bookName);
        // 2. 만약 책이 없으면(null이면)? -> "없는 책입니다." 출력하고 return
        if(book == null){
            System.out.println("해당 없어요 !");
            return;
        }
        // 3. 만약 이미 대출 중이면(book.isBorrowed()가 true면)? -> "이미 대출 중인 책입니다." 출력하고 return
        if(book.isBorrowed() == true){
            System.out.println("이미 대출 중 입니다.");
            return;
        }
        // 4. 대출이 가능하면 -> 책의 상태를 대출 중(true)으로 바꾸고, "대출이 완료되었습니다." 출력!
        if(book.isBorrowed() == false){
            book.setBorrowed(true);
            System.out.println("대출 완료되었습니다.");
        }
    }

    // 반납 기능
    public void returnBook(String bookName){
        Book book = search(bookName);
        if(book.isBorrowed() == true){
            book.setBorrowed(false);
            System.out.println("반납 완료되었습니다.");
        }
    }

}
