package com.korai.ch05;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ControlMain4 {
    public static void main(String[] args) throws IOException {

        // 입력, while문
        Scanner scanner = new Scanner(System.in); // 터미널에서 값을 가져온거임

        System.out.println("하실 말씀을 알려주세요 : ");
        String input = scanner.nextLine();
        System.out.println(input);

        // try-with-resources를 사용하여 사용 후 스트림 자동 해제(close)
        try (FileReader fileReader = new FileReader("input.txt"); // 외부에서 가져오는거
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            StringBuilder stringBuilder = new StringBuilder();
            String text = "";

            while ((text = bufferedReader.readLine()) != null) {
                // readLine()은 개행 문자를 제외하므로 줄바꿈("\n") 추가
                stringBuilder.append(text).append("\n");
            }

            System.out.println(stringBuilder);
        }
    }
}
