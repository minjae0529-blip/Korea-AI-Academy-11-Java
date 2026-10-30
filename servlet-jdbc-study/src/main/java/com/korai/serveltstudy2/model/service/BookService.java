package com.korai.serveltstudy2.model.service;

import com.korai.serveltstudy2.model.Book;
import com.korai.serveltstudy2.model.User;
import com.korai.serveltstudy2.model.repository.BookRepository;

import java.util.List;

public class BookService {
    private Book book;
    private List<Book> books;
    private static BookService instance;
    private BookRepository bookRepository;

    private BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public static BookService getInstance() {
        if (instance == null) {
            instance = new BookService(BookRepository.getInstance());
        }
        return instance;
    }

    public Book findByBookName(String bookName) {
        //for, list에서 username이 동일하면 리턴으로 그 찾은 유저 리턴
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getBookName().equals(bookName)) {
                return books.get(i);
            }
        }
        return null;
    }

    //동일한 유저 객체를 밖으로 꺼내 쓰면, 리스트에 있는 유저가 변경될 수도 있음

}
