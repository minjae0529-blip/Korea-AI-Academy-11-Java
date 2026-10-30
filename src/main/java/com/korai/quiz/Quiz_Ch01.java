package com.korai.quiz;

/**
 * ==============================================================================
 * 🎯 [Ch01 실습 연습문제] 자바 기초 문법 & 배열 & 조건문
 * ==============================================================================
 * [풀이 방법]
 * 1. 각 메서드의 '// TODO:' 표시가 있는 부분에 코드를 구현하세요.
 * 2. IntelliJ에서 이 파일을 열고 [Run (Ctrl+Shift+R / 재생버튼)]을 누르세요.
 * 3. 아래 채점 시스템이 자동으로 정답/오답(PASS/FAIL)을 판별해 줍니다!
 * ==============================================================================
 */
public class Quiz_Ch01 {

    /**
     * [문제 1] 짝수 개수 세기 (기반 코드: ArrayTest02.java)
     * - 매개변수로 주어진 정수 배열 numbers에서 "짝수"의 총 개수를 구하여 반환하세요.
     * - 예시: {12, 7, 5, 20, 33, 40, 18} -> 짝수는 12, 20, 40, 18이므로 반환값은 4
     */
    public static int countEvens(int[] numbers) {
        // TODO: 여기에 코드를 작성하세요.
        return 0;
    }

    /**
     * [문제 2] 영화관 좌석 예약 로직 (기반 코드: ArrayTest03.java)
     * - seats 배열은 10개의 좌석 상태를 나타냅니다 (false = 빈자리, true = 이미 예약됨).
     * - 사용자가 예약하려는 seatNumber(1 ~ 10)가 주어집니다.
     * - [요구사항]
     *   1. 배열의 인덱스는 0부터 시작하므로 seatNumber - 1 위치를 확인해야 합니다.
     *   2. 이미 예약된 자리(true)라면 false를 반환하세요 (예약 실패).
     *   3. 빈자리(false)라면 해당 자리를 true로 바꾸고 true를 반환하세요 (예약 성공).
     */
    public static boolean reserveSeat(boolean[] seats, int seatNumber) {
        // TODO: 여기에 코드를 작성하세요.
        return false;
    }

    /**
     * [문제 3] 메뉴 분기 처리 (기반 코드: ScannerTest01.java)
     * - 입력된 번호(menuNum)에 따라 아래 문자열을 반환하세요.
     *   - 1인 경우 -> "등록"
     *   - 2인 경우 -> "조회"
     *   - 3인 경우 -> "삭제"
     *   - 그 외 번호 -> "종료"
     */
    public static String selectMenu(int menuNum) {
        // TODO: 여기에 코드를 작성하세요.
        return "";
    }

    /**
     * [문제 4] 최대값과 최소값의 차이 구하기 (기반 코드: Practice01.java)
     * - 정수 배열 scores에서 가장 큰 값(최대값)과 가장 작은 값(최소값)을 찾아,
     *   두 값의 차이(최대값 - 최소값)를 반환하세요.
     * - 예시: {80, 95, 70, 85, 90} -> 최대 95, 최소 70 -> 반환값 25
     */
    public static int getDiffMaxMin(int[] scores) {
        // TODO: 여기에 코드를 작성하세요.
        return 0;
    }


    // ==============================================================================
    // 📢 아래는 자동 채점 엔진입니다. (수정하지 마세요!)
    // ==============================================================================
    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("  🚀 [Ch01] 자바 기초 실습 자동 채점 시작");
        System.out.println("==================================================");

        int totalScore = 0;

        // [채점 1] 짝수 개수
        int[] q1Input = {12, 7, 5, 20, 33, 40, 18};
        int q1Result = countEvens(q1Input);
        if (q1Result == 4) {
            System.out.println("✅ [문제 1] 짝수 개수 세기: PASS (결과: " + q1Result + "개)");
            totalScore += 25;
        } else {
            System.out.println("❌ [문제 1] 짝수 개수 세기: FAIL (기대값: 4, 내 결과: " + q1Result + ")");
        }

        // [채점 2] 좌석 예약
        boolean[] q2Seats = new boolean[10];
        q2Seats[2] = true; // 3번 좌석은 이미 예약됨
        boolean r1 = reserveSeat(q2Seats, 3); // 3번 시도 -> 실패(false)해야 함
        boolean r2 = reserveSeat(q2Seats, 5); // 5번 시도 -> 성공(true)하고 seats[4]가 true로 바뀌어야 함
        if (!r1 && r2 && q2Seats[4]) {
            System.out.println("✅ [문제 2] 좌석 예약 로직: PASS (중복 방지 & 예약 성공 확인)");
            totalScore += 25;
        } else {
            System.out.println("❌ [문제 2] 좌석 예약 로직: FAIL (3번 예약결과: " + r1 + ", 5번 예약결과: " + r2 + ")");
        }

        // [채점 3] 메뉴 분기
        boolean q3Pass = "등록".equals(selectMenu(1)) &&
                         "조회".equals(selectMenu(2)) &&
                         "삭제".equals(selectMenu(3)) &&
                         "종료".equals(selectMenu(99));
        if (q3Pass) {
            System.out.println("✅ [문제 3] 메뉴 분기 처리: PASS (1:등록, 2:조회, 3:삭제, 기타:종료)");
            totalScore += 25;
        } else {
            System.out.println("❌ [문제 3] 메뉴 분기 처리: FAIL (출력값을 확인하세요)");
        }

        // [채점 4] 최대-최소 차이
        int[] q4Scores = {80, 95, 70, 85, 90};
        int q4Result = getDiffMaxMin(q4Scores);
        if (q4Result == 25) {
            System.out.println("✅ [문제 4] 최대-최소 차이: PASS (결과: " + q4Result + ")");
            totalScore += 25;
        } else {
            System.out.println("❌ [문제 4] 최대-최소 차이: FAIL (기대값: 25, 내 결과: " + q4Result + ")");
        }

        System.out.println("--------------------------------------------------");
        System.out.println("  🎯 총 점: " + totalScore + " / 100 점");
        if (totalScore == 100) {
            System.out.println("  🎉 축하합니다! Ch01 모든 문제를 완벽히 통과했습니다!");
        } else {
            System.out.println("  💡 TODO 주석이 있는 메서드를 채우고 다시 실행(Run)해 보세요!");
        }
        System.out.println("==================================================");
    }
}
