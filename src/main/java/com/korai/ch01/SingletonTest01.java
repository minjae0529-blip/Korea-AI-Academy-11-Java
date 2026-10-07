package com.korai.ch01;

public class SingletonTest01 {
    public static void main(String[] args) {

    }
}

class Memo {
    String content;

    public Memo(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Memo{" +
                "content='" + content + '\'' +
                '}';
    }
}



