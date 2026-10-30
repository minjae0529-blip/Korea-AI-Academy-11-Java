package com.korai.ch13;

//람다 : 추상메서드를 하나만 가지고 있는 인터페이스를 익명 객체로 생성할 때 편리하게 생성할 수 있도록 만들어주는 문법
//람다 사용요건 : 추상메서드는 1개만 있어야 함, 일반메서드는 개수 상관없음.
public class Lambda01 {
    public static void main(String[] args) {
        KeyboardEvent k1 = new KeyboardEvent() {
            @Override
            public void keyUp() {
                System.out.println("키업");
            }

            @Override
            public void keyDown() {
                System.out.println("키다운");
            }
        };

        k1.keyDown();
        k1.keyUp();

        Speaker speaker = () -> System.out.println("A스피커 사운드를 재생");
        //(매개변수) -> { 실행할 내용 }
        // () -> System.out.println("A스피커 사운드를 재생"); 이부분이 정의 + 생성임
//        Speaker speaker1 = new Speaker() {
//            @Override
//            public void play() {
//
//            }
//        };
        speaker.play();
    }
}

interface KeyboardEvent {
    void keyUp();
    void keyDown();
}

interface Speaker{
    void play();
}
