package com.korai.ch01;

import java.util.ArrayList;
import java.util.List;

public class SingletonTest {
    //싱글톤 설정 기준 : 역할, 객체가 몇개가 필요한가, 데이터가 개별로 표현되는지

    public static void main(String[] args) {
        BookRepository bookRepository = BookRepository.getInstance();   // 처음 호출: 객체 생성
        BookRepository bookRepository1 = BookRepository.getInstance();   // 두 번째: 기존 객체 반환

        bookRepository.add(new Book("자바", "강민재"));
        bookRepository.printAll();
    }
}

// 책 한 권을 표현하는 클래스
class Book {
    private String title;
    private String author;

    Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book(title=" + title + ", author=" + author + ")";
    }
}

// 책 여러 권을 담는 저장소 (싱글톤)
class BookRepository {
    private static BookRepository instance;                // ① 처음엔 null
    private final List<Book> books = new ArrayList<>();    // 책 목록

    private BookRepository() {                             // ② 밖에서 new 금지 : 생성자
        System.out.println("BookRepository 객체 생성!");
    }

    public static BookRepository getInstance() {           // ③ 꺼내 쓰는 통로
        if (instance == null) {
            instance = new BookRepository();
        }
        return instance;
    }

    public void add(Book book) {
        books.add(book);
    }

    public void printAll() {
        System.out.println("=== 도서 목록 ===");
        for (Book book : books) {
            System.out.println(book);
        }
    }
}