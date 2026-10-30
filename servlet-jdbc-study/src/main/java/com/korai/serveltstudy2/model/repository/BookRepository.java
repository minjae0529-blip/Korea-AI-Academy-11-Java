package com.korai.serveltstudy2.model.repository;

public class BookRepository {
    // 저장소
    private static BookRepository instance;

    private  BookRepository() {}

    public static BookRepository getInstance(){
        if(instance == null){
            instance = new BookRepository();
        }
        return null;
    }



}
