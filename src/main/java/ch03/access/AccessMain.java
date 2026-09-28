package ch03.access;

class 선생 {
    private String name;

    void 이름설정하기(String name) {
        this.name = name;
    }

    //setter
    void setName(String name) {
        this.name = name;
    }

    //getter
    String getName() {
        return name;
    }
}


public class AccessMain {

    static class 학생 {
        String name;
        private int age;
    }

    public static void main(String[] args) {
        학생 s1 = new 학생();
        s1.name = "강민재";
        s1.age = 26;
        System.out.println(s1.age);
    }

    static void run1() {
        학생 s2 = new 학생();
        s2.age = 11;
        s2.name = "미미";

        선생 t1 = new 선생();
        t1.이름설정하기("강민재");
        System.out.println(t1.getName());
    }


}
