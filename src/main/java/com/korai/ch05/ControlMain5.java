package com.korai.ch05;

import java.util.Scanner;

public class ControlMain5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name;
        String age;
        String address;
        System.out.println("[프로그램 실행]");
        System.out.println("이름 : ");
        name = scanner.nextLine();
        System.out.println("나이 : ");
        age = scanner.nextLine();
        System.out.println("주소 : ");
        address = scanner.nextLine();

        String ouputText = String.format("""
                %s님의 나이는 %s입니다.
                주소는 %s입니다. """, name, age, address);
        System.out.println(ouputText);
    }
}
