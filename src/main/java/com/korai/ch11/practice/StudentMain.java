package com.korai.ch11.practice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentMain {
    public static int pathIndex = 0;
    public static boolean running = true;

    public static void main(String[] args) {
        //학생 성적관리 프로그램
        List<View> viewList = new ArrayList<>();
        viewList.add(HomeView.getHomeView());        // index 0: 홈 화면
        viewList.add(RegisterView.getRegisterView());// index 1: 등록 화면
        viewList.add(ListView.getListView());        // index 2: 목록 조회 화면

        while (running) {
            viewList.get(pathIndex).show();
        }
    }
}

interface View {
    void show();
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class Student {
    private int age;
    private String name;
}

// -----------------------------------------------------------------------------
// [HomeView] 홈 메뉴 화면
// -----------------------------------------------------------------------------
class HomeView implements View {
    private HomeView() {
    }

    private static HomeView instance;

    public static HomeView getHomeView() {
        while (instance == null) {
            instance = new HomeView();
        }
        return instance;
    }

    @Override
    public void show() {
        Scanner scanner = new Scanner(System.in);
        String menu;
        System.out.println("[ HOME ]");
        System.out.println("R. 학생 등록하기");
        System.out.println("L. 학생 목록조회");
        System.out.println("Q. 프로그램 종료");
        System.out.print(">>>");
        menu = scanner.nextLine().trim();

        // [수정 1] 메뉴 분기 완성: R(등록), L(목록), Q(종료) 및 TodoMain -> StudentMain 참조로 수정
        if ("Q".equals(menu) || "q".equals(menu)) {
            StudentMain.running = false;
        } else if ("R".equals(menu) || "r".equals(menu)) {
            StudentMain.pathIndex = 1; // R 입력 시 RegisterView(인덱스 1)로 이동
        } else if ("L".equals(menu) || "l".equals(menu)) {
            StudentMain.pathIndex = 2; // L 입력 시 ListView(인덱스 2)로 이동
        } else {
            System.out.println("다시 입력해주세요");
        }
    }
}

// -----------------------------------------------------------------------------
// [RegisterView] 학생 등록 화면
// -----------------------------------------------------------------------------
class RegisterView implements View {
    private RegisterView() {
    }

    private static RegisterView instance;

    public static RegisterView getRegisterView() {
        while (instance == null) {
            instance = new RegisterView();
        }
        return instance;
    }

    @Override
    public void show() {
        Scanner scanner = new Scanner(System.in);
        // [수정 2] 첫 번째 안내 문구를 '나이'에서 '이름'으로 수정
        System.out.println("이름을 입력해주세요");
        System.out.print(">>>");
        Student newStudent = new Student();
        newStudent.setName(scanner.nextLine());

        System.out.println("나이를 입력해주세요");
        System.out.print(">>>");
        newStudent.setAge(scanner.nextInt());
        scanner.nextLine(); // 개행 버퍼 비우기

        // [수정 3] 메서드 호출명을 getInstance() -> getStudentRepository() 로 일치시킴
        StudentRepository.getStudentRepository().insert(newStudent);
        System.out.println("등록완료 !");
        StudentMain.pathIndex = 0; // 등록 완료 후 다시 홈(index 0)으로 복귀
    }
}

// -----------------------------------------------------------------------------
// [ListView] 학생 목록 화면
// -----------------------------------------------------------------------------
class ListView implements View {
    private static ListView instance;

    private ListView() {
    }

    public static ListView getListView() {
        while (instance == null) {
            instance = new ListView();
        }
        return instance;
    }

    @Override
    public void show() {
        // [수업 방식 적용] size() == 0 검사 및 조기 return 방식
        System.out.println("[ LIST ]");
        List<Student> students = StudentRepository.getStudentRepository().findAll();
        if (students.size() == 0) {
            System.out.println("등록된 학생이 없습니다");
            StudentMain.pathIndex = 0;
            return;
        }
        for (Student student : students) {
            System.out.println(student);
        }
        StudentMain.pathIndex = 0;
    }
} // [수정 5 핵심!] ListView 클래스를 닫는 중괄호 추가 (이 중괄호가 누락되어 아래 저장소가 내부에 갇혔었음)

// -----------------------------------------------------------------------------
// [StudentRepository] 학생정보 저장소 (싱글톤)
// -----------------------------------------------------------------------------
class StudentRepository {
    private static StudentRepository instance;
    private List<Student> studentList;

    public static StudentRepository getStudentRepository() {
        while (instance == null) {
            instance = new StudentRepository();
        }
        return instance;
    }

    private StudentRepository() {
        studentList = new ArrayList<>();
    }

    public void insert(Student student) {
        studentList.add(student);
    }

    public List<Student> findAll() {
        // 원본 보호를 위해 복사본을 만들어 반환
        return new ArrayList<>(studentList);
    }
}