package com.korai.ch10.TODO.config;

import com.korai.ch10.TODO.entity.User;

import java.util.UUID;

public class SecurityConfig {

    /*
     * [선언 이유: private static String loginSession = null]
     * - 로그인한 유저의 세션 토큰 문자열을 프로그램 전역에서 공유하기 위해 static 변수로 선언한 것입니다.
     * - static 변수는 인스턴스(new)를 만들지 않아도 클래스가 메모리에 로드될 때 Method Area(메서드 영역)에 딱 1개만 생성됩니다.
     * - 초기값이 null인 이유: 앱 시작 시에는 로그인된 상태가 아니기 때문입니다.
     */
    private static String loginSession = null;

    /*
     * [작성 이유: getLoginSession() / setLoginSession()]
     * - private static 변수인 loginSession에 안전하게 접근하고 값을 변경하기 위한 정적 게터/세터 메서드입니다.
     */
    public static String getLoginSession() {
        return loginSession;
    }

    public static void setLoginSession(String session) {
        SecurityConfig.loginSession = session;
    }

    /*
     * [작성 이유: public static String generateSessionToken(User user)]
     * - 매개변수로 넘어온 User 객체의 getId() 메서드를 호출하여 회원 번호(int)를 얻습니다.
     * - UUID.randomUUID().toString()으로 겹치지 않는 128비트 난수 문자열을 만들고, replaceAll("-", "")로 대시를 제거합니다.
     * - 난수 문자열과 "@", 그리고 userId를 결합(Concatenation)하여 토큰 문자열을 만듭니다.
     * - 이유: 토큰 자체에 userId를 심어두어, 토큰만 파싱하면 별도 DB 조회 없이 유저를 역추적할 수 있게 하기 위함입니다.
     */
    public static String generateSessionToken(User user) {
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        int userId = user.getId();
        String token = uuid + "@" + userId;
        return token;
    }

    /*
     * [작성 이유: public static int getUserId()]
     * - loginSession 변수에 저장된 토큰 문자열(예: "9a8b7c@1")에서:
     *   1) token.indexOf("@") + 1 : 구분자 '@' 다음 글자의 위치 인덱스를 찾습니다.
     *   2) token.substring(...) : 해당 위치부터 끝까지 잘라내어 "1" 문자열을 추출합니다.
     *   3) Integer.parseInt(...) : 추출한 숫자 문자열을 실제 기본 자료형인 int형(1)으로 변환하여 반환합니다.
     * - 다른 서비스 클래스에서 이 파싱 코드를 중복 작성하지 않고, 메서드 호출 한 줄로 꺼내 쓰게 하기 위해 만들었습니다.
     */
    public static int getUserId() {
        String token = loginSession;
        return Integer.parseInt(token.substring(token.indexOf("@") + 1));
    }
}
