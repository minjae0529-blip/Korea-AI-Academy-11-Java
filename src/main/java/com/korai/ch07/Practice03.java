package com.korai.ch07;

import java.util.ArrayList;
import java.util.List;

/**
 * ==============================================================================
 * [연습문제 3] final 필드, 생성자(super), 추상 클래스 (직원 급여 관리)
 * ==============================================================================
 *
 * [학습 목표]
 * 1. final 필드의 초기화 규칙 복습 (사번 id, 이름 name은 변경 불가)
 * 2. super(...)를 통한 부모 생성자 명시적 호출
 * 3. 추상 클래스 Employee와 추상 메서드 getSalary() 구현
 * 4. List<Employee>를 순회하며 전체 직원의 총 지급 급여 합산하기
 *
 * [요구사항]
 * 1. Employee 추상 클래스:
 *    - final int id;      // 사번 (불변)
 *    - final String name; // 이름 (불변)
 *    - 생성자 Employee(int id, String name): 필드 초기화
 *    - abstract int getSalary(); // 월급 계산 추상 메서드
 *
 * 2. FullTimeEmployee (정규직):
 *    - 필드: int monthlyBaseSalary (기본급), int bonus (보너스)
 *    - 생성자: id, name, baseSalary, bonus 전달받아 초기화
 *    - getSalary(): baseSalary + bonus 반환
 *
 * 3. PartTimeEmployee (아르바이트):
 *    - 필드: int hourlyRate (시급), int workHours (근무시간)
 *    - 생성자: id, name, hourlyRate, workHours 전달받아 초기화
 *    - getSalary(): hourlyRate * workHours 반환
 *
 * 4. Practice03 main:
 *    - 정규직 2명, 파트타임 2명을 List<Employee>에 저장
 *    - 일반 for문(또는 향상된 for문)을 돌며 각 직원의 이름과 이번 달 급여를 출력
 *    - 전체 직원에게 지급된 총 급여 합계(totalSalary)를 계산하여 마지막에 출력
 */

abstract class Employee {
    final int id;
    final String name;

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public abstract int getSalary();

    public void printInfo() {
        System.out.printf("[사번: %d] %s 님 -> 급여: %,d원\n", id, name, getSalary());
    }
}

class FullTimeEmployee extends Employee {
    int monthlyBaseSalary;
    int bonus;

    public FullTimeEmployee(int id, String name, int monthlyBaseSalary, int bonus) {
        super(id, name); // 부모 클래스의 final 필드 초기화 위임
        this.monthlyBaseSalary = monthlyBaseSalary;
        this.bonus = bonus;
    }

    @Override
    public int getSalary() {
        return monthlyBaseSalary + bonus;
    }
}

class PartTimeEmployee extends Employee {
    int hourlyRate;
    int workHours;

    public PartTimeEmployee(int id, String name, int hourlyRate, int workHours) {
        super(id, name); // 부모 생성자 호출
        this.hourlyRate = hourlyRate;
        this.workHours = workHours;
    }

    @Override
    public int getSalary() {
        return hourlyRate * workHours;
    }
}

public class Practice03 {
    public static void main(String[] args) {
        System.out.println("========== [직원 급여 관리 시스템] ==========");

        List<Employee> employees = new ArrayList<>();
        employees.add(new FullTimeEmployee(101, "강민재", 3500000, 500000));
        employees.add(new FullTimeEmployee(102, "김철수", 2800000, 300000));
        employees.add(new PartTimeEmployee(201, "이영희", 10000, 80));   // 80시간 근무
        employees.add(new PartTimeEmployee(202, "박민수", 11000, 120));  // 120시간 근무

        int totalSalary = 0;

        for (int i = 0; i < employees.size(); i++) {
            Employee emp = employees.get(i);
            emp.printInfo();
            totalSalary += emp.getSalary();
        }

        System.out.println("==========================================");
        System.out.printf("👉 총 지급 급여 합계: %,d원\n", totalSalary);
    }
}
