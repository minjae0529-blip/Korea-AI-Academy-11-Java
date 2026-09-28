package com.korai.study.ch02;

public class Function {
    public static void main(String[] args) {

        // 함수란 : 반복적인 작업을 다시 사용할 수 있도록 정의(도구를 만드는 것)
        // 목적 : 1. 재사용성, 2. 정리

        class 업무일지기능 {
            String date;
            String name;
            String content;
            void 업무일지출력() {
                System.out.println("업무일지 [" + date + "]");
                System.out.println("이름 : " + name);
                System.out.println("내용 : " + content);
            }
        }

        업무일지기능 f1 = new 업무일지기능();
        f1.date = "2026-09-23";
        f1.name = "강민재";
        f1.content = "진짜 집가고싶다";
        f1.업무일지출력();        // 함수 호출

        업무일지기능 f2 = new 업무일지기능();
        f2.date = "2026-09-26";
        f2.name = "강민재";
        f2.content = "TODAY IS DAY-04";
        f2.업무일지출력();        // 함수 호출


        class 업무일지기능2 {

            void 업무일지출력(String date, String name, String content) {
                System.out.println("업무일지 [" + date + "]");
                System.out.println("이름 : " + name);
                System.out.println("내용 : " + content);
            }

            //2026-09-23 -> 2026년 09월 07일
            String 날짜표기변환(String date){
                String[] splitDate = date.split("-");
                String year = splitDate[0];
                String month = splitDate[1];
                String day = splitDate[2];
                return year + "년" + month + "월" + day + "일";
            }
        }

        업무일지기능2  f3 = new 업무일지기능2();
        f3.업무일지출력("26-09-30", "강민재", "밥먹고싶다");
        f3.업무일지출력("26-09-30", "강민재", "치킨먹고싶다");
        f3.업무일지출력(f3.날짜표기변환("26-09-30"), "강민재", "치킨먹고싶다");

    }

}
