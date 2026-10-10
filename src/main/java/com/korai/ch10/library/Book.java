package com.korai.ch10.library;

public class Book {
    private String bookName;
    private String author;
    private int bookNumber;
    private boolean borrowed; // 대출 여부 (false: 대출 가능, true: 대출 중)

    public Book(String bookName, String author, int bookNumber) {
        this.bookName = bookName;
        this.author = author;
        this.bookNumber = bookNumber;
        this.borrowed = false; // 새로 등록된 책은 대출 안 된 상태
    }

    public String getName() {
        return author;
    }

    public void setName(String author) {
        this.author = author;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getBookNumber() {
        return bookNumber;
    }

    public void setBookNumber(int bookNumber) {
        this.bookNumber = bookNumber;
    }

    public boolean isBorrowed() {
        return borrowed;
    }

    public void setBorrowed(boolean borrowed) {
        this.borrowed = borrowed;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookName='" + bookName + '\'' +
                ", author='" + author + '\'' +
                ", bookNumber=" + bookNumber +
                ", borrowed=" + borrowed +
                '}';
    }
}
