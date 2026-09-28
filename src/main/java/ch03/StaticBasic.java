package ch03;

import com.korai.study.ch02.Function;

import java.time.LocalDate;

public class StaticBasic {
    public static void main(String[] args) {

        학생관리시스템 system = new 학생관리시스템(); //자료형 변수 = 새로운 객체()
        학생 s1 = system.학생추가("강민재");        //객체 추가(인수값)
        학생 s2 = system.학생추가("강민재2");
        학생 s3 = system.학생추가("강민재3");
        학생 s4 = system.학생추가("강민재4");
    }

} // 여기까지가 Main 클래스 : 밑에 있는 클래스는 Main에서 실행하기 위한 자식 클래스

//학생 클래스
class 학생 {
    int 학번; // 변수(필드) - 인스턴스 변수 / 실존해야만 쓸 수 있는 변수
    String 이름; // 변수(필드) - 인스턴스 변수

    학생(int 학번 , String 이름) {
        //힙 메모리를 빌려서 객체를 생성 및 할당
        System.out.println("생성자 호출");
        this.이름 = 이름;
        this.학번 = 학번;
    }
}

//학생관리시스템
class 학생관리시스템 {
    static int 년도 = LocalDate.now().getYear();
    static int 번호 = 1;

    static{
        System.out.println("학생관리시스템 클래스 로딩");
    }

    static 학생 학생추가(String 이름) {
        return new 학생(년도 * 10000 + 번호++, 이름);
    }

}