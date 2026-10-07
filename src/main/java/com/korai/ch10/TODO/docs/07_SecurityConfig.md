# 📄 [클래스 07] SecurityConfig.java

- **소속 패키지**: `com.korai.ch10.TODO.config`
- **파일 위치**: [`SecurityConfig.java`](file:///Users/kangminjae/Documents/gov/java/study/src/main/java/com/korai/ch10/TODO/config/SecurityConfig.java)
- **주요 역할**: 로그인 세션 토큰의 저장소 및 고유 세션 토큰 발급 유틸리티

---

## 1. 왜 이 클래스를 만들었는가? (설계 배경)

웹 서비스에서는 로그인에 성공하면 브라우저에 쿠키(Cookie)나 세션(Session), JWT 토큰을 발급하여 "지금 어떤 사용자가 로그인해 있는지"를 기억합니다.  
콘솔 애플리케이션에서도 동일하게:
1. 로그인이 성공했을 때 사용자를 식별할 수 있는 **유일무이한 토큰(Token)**을 생성하고,
2. 다른 기능(예: 할 일 등록)에서 "지금 로그인한 사람이 누구인가?"를 확인할 수 있도록 **전역 로그인 세션**을 보관해야 합니다.

`SecurityConfig`는 이러한 인증 상태 보관과 토큰 생성을 총괄하는 보안 설정 클래스입니다.

---

## 2. 코드 전체 보기 (상세 주석 포함)

```java
package com.korai.ch10.TODO.config;

// [작성 이유]: 토큰 생성 시 사용자의 id 값을 꺼내기 위해 import
import com.korai.ch10.TODO.entity.User;

// [작성 이유]: 전 세계에서 겹치지 않는 고유 난수 문자열을 만들기 위해 import
import java.util.UUID;

public class SecurityConfig {

    /*
     * [작성 이유: private static String loginSession = null]
     * - 현재 애플리케이션에 로그인된 유저의 토큰을 저장하는 전역 세션 변수입니다.
     * - static으로 선언하여 프로그램 어디서든 클래스명으로 접근 가능합니다.
     * - 초기값이 null인 것은 현재 "로그인되지 않은 상태(로그아웃 상태)"를 뜻합니다.
     */
    private static String loginSession = null;

    // [작성 이유]: 현재 로그인된 세션 토큰을 안전하게 꺼내기 위한 Getter
    public static String getLoginSession() {
        return loginSession;
    }

    // [작성 이유]: 로그인 성공 시 토큰을 저장하거나, 로그아웃 시 null로 비우기 위한 Setter
    public static void setLoginSession(String session) {
        SecurityConfig.loginSession = session;
    }

    /*
     * [작성 이유: public static String generateSessionToken(User user)]
     * 로그인 성공 시 유저 고유의 세션 토큰을 발급하는 비즈니스 메서드입니다.
     */
    public static String generateSessionToken(User user) {
        /*
         * [작성 이유: UUID.randomUUID().toString().replaceAll("-", "")]
         * 1. UUID.randomUUID(): 중복될 확률이 0에 수렴하는 128비트 무작위 고유 식별자를 만듭니다.
         * 2. replaceAll("-", ""): UUID에 포함된 하이픈(-) 기호를 빈 문자열("")로 치환하여
         *    32자리의 깔끔한 알파벳+숫자 난수 토큰으로 정제합니다.
         */
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");

        // [작성 이유]: 토큰에 유저 식별자(PK)를 포함하기 위해 가져옵니다.
        int userId = user.getId();

        /*
         * [작성 이유: String token = uuid + "@" + userId]
         * 핵심 설계 아이디어:
         * 난수 문자열 뒤에 구분자("@")와 함께 userId를 덧붙입니다.
         * -> 효과: 토큰 자체만 가지고도 별도의 세션 DB 조회 없이
         *    "이 토큰의 주인이 몇 번 유저인지"를 토큰 문자열 파싱만으로 즉시 알아낼 수 있습니다.
         *    (실무의 JWT 토큰과 유사한 자체 포함형(Self-contained) 토큰 구조)
         */
        String token = uuid + "@" + userId;

        return token;
    }
}
```

---

## 3. 핵심 코드 심층 해설 (왜 이렇게 작성했는가?)

### Q1. `uuid + "@" + userId` 구조의 토큰은 어떤 장점이 있나요?
1. **토큰의 유일성(Uniqueness)**: 앞부분의 UUID 덕분에 매번 로그인할 때마다 서로 다른 난수 토큰이 생성됩니다.
2. **역추적 용이성(Parsability)**: 할 일을 등록할 때 `TodoService`는 토큰에서 `@` 위치를 찾은 뒤 뒤쪽 숫자를 잘라내는 것(`substring`)만으로 작성자의 `userId`를 즉시 알아낼 수 있습니다.
3. 이를 실무에서는 **상태 비저장형(Stateless) 또는 자체 검증형 토큰 구조**의 축소판이라 부릅니다.

### Q2. `replaceAll("-", "")`은 왜 사용했나요?
- `UUID.randomUUID().toString()`을 그냥 출력하면 `550e8400-e29b-41d4-a716-446655440000`처럼 중간에 대시(-)가 포함됩니다.
- 대시를 제거하면 `550e8400e29b41d4a716446655440000` 형태로 깔끔한 32자리 헥사 문자열이 되어 다루기 편리해집니다.

---

## 4. 세션 토큰 생성 및 파싱 구조도

```mermaid
graph LR
    subgraph TokenCreation [토큰 생성 (SecurityConfig)]
        UUID["UUID 난수 (32자)"] --> Join["+ '@' +"]
        UID["User ID (숫자)"] --> Join
        Join --> ResToken["예: 9a8b7c6d... @ 1"]
    end

    subgraph TokenParsing [토큰 해석 (TodoService)]
        ResToken --> Split["substring(indexOf('@') + 1)"]
        Split --> ExtractUID["1번 사용자 식별!"]
    end
```
