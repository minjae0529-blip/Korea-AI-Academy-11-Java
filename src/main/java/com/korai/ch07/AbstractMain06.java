package com.korai.ch07;

import java.util.List;

public class AbstractMain06 {
    public static void main(String[] args) {
        List<RemoteControl> remoteControls = List.of(
                new TvRemoteControl(),
                new MonitoremoteControl(),
                new TvRemoteControl(),
                new MonitoremoteControl()
        );

        //변수명 : 자료형
        //무조건 처음부터 끝까지 반복할 때 향상된 for문 사용함
        for(RemoteControl r : remoteControls){
            r.powerOn();
        }

        for(int i = 0; i < remoteControls.size(); i++){
            RemoteControl r = remoteControls.get(i);
            r.powerOn();
        }
    }
}

interface Sensor{
    void send();                //추상메서드
    void on();
    void off();

    default void send2(){       // 일반 메서드
        System.out.println();
    }
}

abstract class RemoteControl implements Sensor{
    @Override
    public void send() {

    }

    @Override
    public void on() {

    }

    @Override
    public void off() {

    }

    //리모컨
    abstract void powerOn();            //추상 메서드
}

class TvRemoteControl extends RemoteControl {
    @Override
    void powerOn() {
        System.out.println("Tv회로에 맞게 전원 공급");
    }

}
class MonitoremoteControl extends RemoteControl {
    @Override
    void powerOn() {
        System.out.println("모니터 회로에 맞게 전원 공급");
    }



}