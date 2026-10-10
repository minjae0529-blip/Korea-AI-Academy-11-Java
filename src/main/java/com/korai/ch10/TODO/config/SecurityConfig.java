package com.korai.ch10.TODO.config;

import com.korai.ch10.TODO.entity.User;

import java.util.UUID;

public class SecurityConfig {

    /*
     * [선언 이유: private static String loginSession]
     * - 로그인한 사용자의 인증 세션 토큰("랜덤UUID@사용자ID")을 프로그램 전역에서 공유 및 보관하기 위한 static 변수입니다.
     */
    private static String loginSession = null;

    public static String getLoginSession() {
        return loginSession;
    }

    public static void setLoginSession(String loginSession) {
        SecurityConfig.loginSession = loginSession;
    }

    /*
     * [메서드 설명: public static String generateSessionToken(User user)]
     * - UUID.randomUUID()로 생성한 고유 난수 문자열 뒤에 "@"와 user.getId()를 이어 붙여
     *   유일한 세션 토큰 문자열을 발급합니다.
     */
    public static String generateSessionToken(User user) {
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        int userId = user.getId();
        String token = uuid + "@" + userId;
        return token;
    }

    /*
     * [강사님 깃허브 원본 복구 및 설명: getUserId()]
     * - 강사님 원본 코드 구조:
     *   1. loginSession.indexOf("@") + 1 로 "@" 다음 위치 인덱스를 구합니다.
     *   2. loginSession.substring(startIndex)로 사용자 ID 문자열을 잘라냅니다.
     *   3. Integer.parseInt(userIdStr)로 문자열을 정수(int)로 변환하여 반환합니다.
     */
    public static int getUserId() {
        int startIndex = loginSession.indexOf("@") + 1;
        String userIdStr = loginSession.substring(startIndex);
        return Integer.parseInt(userIdStr);
    }
}
