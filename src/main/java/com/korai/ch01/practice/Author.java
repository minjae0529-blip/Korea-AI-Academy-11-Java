package com.korai.ch01.practice;

import lombok.*;

@Getter
@Setter
@Data
@AllArgsConstructor
public class Author {

    private String name;
    private String birthday;

    @RequiredArgsConstructor
    class Publisher{
        private String name;
        private String address;
    }

    public Author(){}



    public Author(String birthday) {
        this.birthday = birthday;
    }

}


class AuthoorMain{
    public static void main(String[] args) {
        Author author = new Author();

    }
}