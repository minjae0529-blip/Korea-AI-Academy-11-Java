package com.korai.ch08;

import java.util.Objects;

public class Object02 {
    public static void main(String[] args) {
        class Student {
            private String name;            //private로 같은 클래스내에서만 선언할 수 있도록 접근지정자 설정
            private int age;

            public Student(String name, int age) {      //생성자
                this.name = name;
                this.age = age;
            }

            @Override
            public boolean equals(Object o) {
                if (o == null || this.getClass() != o.getClass()) return false;
                Student student = (Student) o;
                return age == student.age && Objects.equals(name, student.name);   //name이 null일수도 있음, 널포인트 인셉션 안뜸
            }

            @Override
            public int hashCode() {
                return Objects.hash(name, age);
            }
        }

        //이 밑 두 객체를 같은 객체로 볼 것 인가 ? -> 논리적으로 바라봤을 때 같은 데이터이다.
        //같은 객체로 보고 싶다 -> 결과값이 True로.
        //결론 : equals - 사물함 내부 물품이 똑같은지 화인 / hashcode - 사물함 번호가 똑같은지 확인
        Student student1 = new Student("강민재", 26);
        Student student2 = new Student("강민재", 26);
        Student student3 = student1;

        boolean result1 = student1.equals(student2);
        boolean result2 = student1.equals(student3);

        System.out.println("==== 1 ====");
        System.out.println(result1);
        System.out.println(result2);

        //온전히 주소값을 비교했을 때는 같지 않는거임, 여기서 해쉬코드를 통해서 비교하면 값은 똑같이 되는거야
        System.out.println("==== 2 ====");
        System.out.println(student1 == student2);   //주소 비교
        System.out.println(student1 == student3);

        //해쉬메서드에 넣는 순간 고유한 값이 존재함
        System.out.println("==== 3 ====");
        System.out.println(student1.hashCode() == student2.hashCode()); //안에 내부 값들을 해쉬코드로 만들었기 때문에
        //내부에 있는 값들이 똑같기 때문에 해쉬값으로도 출력해도 동일한 출력 결과물이 나옴
        System.out.println(student1.hashCode());
        System.out.println(student2.hashCode());

        //해쉬값 출력
        System.out.println("==== 4 ====");
        System.out.println(Objects.hash("강민재", 26));
        System.out.println(Objects.hash("강민재"));
        System.out.println(Objects.hash(26));

    }
}
