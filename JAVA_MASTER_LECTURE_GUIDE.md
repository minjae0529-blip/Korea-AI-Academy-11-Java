# ☕ Java 객체지향 & 핵심 문법 종합 마스터 바이블 (ch01 ~ ch07)

> **수강생을 위한 완벽한 자바 학습서**  
> 본 교재는 `com.korai.study`의 기초 실습부터 실무 아키텍처, JVM 메모리 동작 원리, 최신 Java 트렌드(Java 17/21), 객체지향 5대 원칙(SOLID), 그리고 **각 장별 실전 연습문제와 해설**까지 단 하나도 빠짐없이 집대성한 종합 마스터 교재입니다.

---

## 📑 챕터별 구성 안내

| 챕터 | 핵심 주제 | 실전 시나리오 & 심화 내용 | 연습문제 |
|:---:|---|---|:---:|
| **ch01** | 변수, 클래스, 제네릭 | JVM 변수 메모리, `Object`의 한계, 제네릭 타입 소거, 와일드카드 | 10선 복습 문제 |
| **ch02** | 함수(메서드)와 재사용 | Call by Value, 스택 프레임, 문자열 파싱, 다중 반환 기법 | 표기 변환 & 마스킹 실습 |
| **ch03** | JVM 메모리, static, 접근 제어자 | Method Area/Stack/Heap, 10대 현실 시뮬레이션, 캡슐화, 3계층 구조 | 영화관 예매 & 안전계좌 |
| **ch04** | 배열의 메모리 구조와 2차원 배열 | 참조형 메모리 연속 할당, 얕은 복사 vs 깊은 복사, `Arrays` 유틸리티 | 행렬 변환 & 동적 배열 |
| **ch05** | 연산자, 제어문, 실전 데이터 가공 | 단락 평가, 최신 화살표 switch, 버퍼 비우기, EOF 처리, 30인 필터링 | 별 찍기 5종 & 구구단 3D |
| **ch06** | 메서드 오버로딩 & 생성자 패턴 | `PrintStream` 내부 분석, 생성자 체이닝(`this()`), 필수 초기화 | 세탁기 & DTO 설계 |
| **ch07** | 상속, 다형성, 추상화, 인터페이스 | 동적 바인딩, `instanceof` 패턴 매칭, SOLID(OCP/DIP), `super` 퍼즐 | 결제·차량·급여 시스템 |

---

# 1. [ch01] 변수, 클래스, 그리고 제네릭 (ClassMain)

```
[ 클래스와 인스턴스의 런타임 메모리 관계 ]
스택 영역 (Stack)                      힙 영역 (Heap)
┌────────────────┐                   ┌──────────────────────────────┐
│  jun (참조변수) │ ── 주소값 참조 ──▶ │ Student 객체 (인스턴스)        │
│  [0x100번지]   │                   │  - name: "김준일" (String 주소)│
└────────────────┘                   │  - age : 33                  │
                                     └──────────────────────────────┘
```

### 1.1 변수(Variable) vs 상수(Constant, `final`)
1. **변수:** 데이터를 임시로 보관하는 메모리 공간으로, 실행 중 값을 바꿀 수 있습니다.
2. **상수 (`final`):** 한 번 초기화되면 값을 재할당할 수 없습니다.
   - 변수에 `final`: 값 재할당 금지
   - 메서드에 `final`: 자식 클래스에서 오버라이딩 금지
   - 클래스에 `final`: 상속 불가 (`String`, `Integer` 등 불변 클래스)

> [!NOTE]
> **리터럴(Literal)과 상수 풀(Constant Pool)**  
> `"김준일"`과 같은 문자열 리터럴은 힙 메모리 내의 **String Constant Pool**에 캐싱되어 재사용됩니다. 따라서 `String a = "김준일"; String b = "김준일";`은 동일한 메모리 주소를 가리키게 됩니다(`a == b` 참).

---

### 1.2 클래스 정의와 `new` 인스턴스화
- **클래스(Class):** 현실 세계의 사물이나 개념을 코드화한 **설계도(틀)**.
- **객체(Object) / 인스턴스(Instance):** `new` 키워드를 통해 힙(Heap) 메모리에 실제 생성된 실체.
- 객체의 필드 접근은 멤버 접근 연산자인 점(`.`)을 사용합니다.

---

### 1.3 `Object` 범용 타입의 한계와 위험성
모든 자바 클래스는 최상위 클래스인 `java.lang.Object`를 상속합니다. 따라서 `Object` 변수에는 어떤 객체든 담을 수 있습니다.
```java
class Student2 {
    String name;
    Object age; // 숫자, 문자열, 다른 객체 모두 대입 가능
}
```
- **문제점:**
  1. 값을 꺼내 쓸 때마다 원래 타입으로 **강제 형변환(Casting)**을 해야 함.
  2. 런타임 시점에 의도치 않은 타입이 들어오면 `ClassCastException` 발생.
  3. 컴파일러가 타입 오류를 미리 잡아내지 못함.

---

### 1.4 제네릭(Generic `<T>`)과 타입 안정성
제네릭은 **타입을 파라미터화**하여 클래스를 작성할 때는 타입을 비워두고, **객체를 생성하는 시점에 구체적인 타입을 결정**하는 기법입니다.
```java
class Student3<A> {
    String name;
    A age; // 생성 시 지정된 타입으로 바인딩
}

Student3<String> jun3 = new Student3<>(); // age는 String만 허용
Student3<Integer> jun33 = new Student3<>(); // age는 Integer만 허용
```
- **다이아몬드 연산자 (`<>`):** Java 7부터 생성자 호출 측의 제네릭 타입을 생략할 수 있습니다.
- **기본형 사용 불가:** 제네릭 파라미터는 참조형(`Object`의 자손)만 가능하므로 `int` 대신 래퍼 클래스인 `Integer`를 써야 합니다.
- **타입 소거(Type Erasure):** 컴파일이 끝나면 JVM 바이트코드에서는 `<T>` 정보가 지워지고 `Object`로 대체되어 하위 호환성을 유지합니다.

---

### 1.5 제네릭 와일드카드(`<?>`)와 참조 복사
```java
int num = 10;
int num2 = num; // [기본형 값 복사] num2에 독립된 값 10이 복사됨 (num을 바꿔도 무영향)

Student3<?> jun333 = jun33; // [와일드카드 & 참조 복사]
```
- **와일드카드 `<?>`:** `?`는 "모든 알 수 없는 타입"을 의미합니다. `Student3<Integer>`든 `Student3<String>`이든 타입에 구애받지 않고 가리키고자 할 때 사용합니다.
- **참조 복사:** 객체의 힙 메모리 주소만 복사되므로, 하나의 객체를 두 변수가 공유하게 됩니다.

---

## 📝 [ch01 연습문제 & 복습 과제]

<details>
<summary><b>[문제 1] 개념 확인 빈칸 채우기 (클릭하여 펼치기)</b></summary>

1. 클래스는 객체를 만들기 위한 ( ① )이고, `new` 키워드로 힙 메모리에 생성된 실체를 ( ② )라고 한다.
2. `final` 키워드가 붙은 변수는 값을 ( ③ )할 수 없다.
3. 제네릭 타입 파라미터에는 `int`와 같은 기본 자료형을 직접 쓸 수 없으므로 ( ④ ) 클래스를 사용해야 한다.
4. `Student3<?>`에서 `?` 기호를 제네릭 ( ⑤ )라고 부른다.

**[정답 및 해설]**  
① 설계도(틀)  
② 객체(또는 인스턴스)  
③ 재할당(변경)  
④ 래퍼(Wrapper) (예: `Integer`)  
⑤ 와일드카드(Wildcard)
</details>

<details>
<summary><b>[문제 2] 출력 결과 예측 (값 복사 vs 참조 복사)</b></summary>

다음 코드를 실행했을 때 최종 출력 결과는 무엇일까요?
```java
int a = 100;
int b = a;
a = 200;
System.out.println("b = " + b);

class Box { int val; }
Box box1 = new Box();
box1.val = 100;
Box box2 = box1;
box1.val = 200;
System.out.println("box2.val = " + box2.val);
```

**[정답 및 해설]**  
```
b = 100
box2.val = 200
```
- `int`는 기본형이므로 `b`에는 값 `100` 자체의 사본이 들어갑니다. 따라서 `a`가 변경되어도 `b`는 유지됩니다.
- `Box`는 참조형이므로 `box2`에는 `box1`이 가리키는 힙 메모리 주소가 복사됩니다. 둘은 동일한 인스턴스를 공유하므로 `box1.val`을 수정하면 `box2.val`도 `200`으로 바뀝니다.
</details>

<details>
<summary><b>[문제 3] 실습 과제: 제네릭 상자(`Box<T>`) 클래스 제작</b></summary>

**요구사항:**
1. 라벨(`String label`)과 내용물(`T item`) 필드를 가진 제네릭 클래스 `Box<T>`를 선언하세요.
2. `Box<String>` (라벨: "편지", 내용물: "합격을 축하합니다") 객체를 생성하세요.
3. `Box<Integer>` (라벨: "용돈", 내용물: 50000) 객체를 생성하세요.
4. 와일드카드 변수 `Box<?> unknownBox = moneyBox;`를 선언하고, 라벨과 내용물을 출력해 보세요.

**[모범 답안]**
```java
class Box<T> {
    String label;
    T item;

    Box(String label, T item) {
        this.label = label;
        this.item = item;
    }
}

public class Practice01Solve {
    public static void main(String[] args) {
        Box<String> letterBox = new Box<>("편지", "합격을 축하합니다");
        Box<Integer> moneyBox = new Box<>("용돈", 50000);

        Box<?> unknownBox = moneyBox;
        System.out.println(unknownBox.label + ": " + unknownBox.item + "원");
    }
}
```
</details>

---

# 2. [ch02] 함수(메서드)의 본질과 재사용 (FunctionMain)

```
[ 메서드 호출 시 스택 프레임 (Call Stack) 동작 ]
main() 실행 ──▶ f3.날짜표기변환() 호출 ──▶ 완료 후 반환 ──▶ f3.업무일지출력() 호출
┌──────────────────┐     ┌──────────────────┐            ┌──────────────────┐
│ main 스택 프레임 │     │ 날짜변환 프레임  │            │ 업무일지 프레임  │
│ - f3 (참조)      │     │ - date: 2026-..  │            │ - date, name...  │
│                  │ ──▶ │ - splitDate[]    │ ── 팝(종료)│                  │
└──────────────────┘     └──────────────────┘            └──────────────────┘
```

### 2.1 함수/메서드를 작성하는 이유
1. **재사용성 (Reusability):** 똑같은 알고리즘을 여러 번 복붙하지 않고 단 한 번만 정의하여 반복 호출.
2. **모듈화 및 정리 (Modularity):** 프로그램에 의미 있는 이름(`날짜표기변환`)을 붙여 가독성과 유지보수성을 극대화.

---

### 2.2 필드 기반 메서드 vs 매개변수 기반 메서드
- **필드 기반 (`업무일지기능`):**
  - 인스턴스 변수에 먼저 데이터를 채우고 메서드를 인자 없이 실행.
  - 객체가 상태를 유지해야 하는 도메인 객체(Entity)에 적합.
- **매개변수 기반 (`업무일지기능2`):**
  - 메서드 호출 시점에 외부에서 데이터를 전달받아 처리.
  - 하나의 인스턴스(도구)로 무수히 많은 서로 다른 데이터를 처리할 수 있어 **서비스/유틸리티 클래스**에 적합.

---

### 2.3 자바의 매개변수 전달 방식: 무조건 Call by Value!
자바는 객체를 넘기든 숫자를 넘기든 **언제나 "값에 의한 호출(Call by Value)"**로 동작합니다.
- 기본형을 넘기면 **실제 값**이 복사되어 넘어갑니다.
- 객체를 넘기면 **참조 주소값**이 복사되어 넘어갑니다. (메서드 안에서 참조 대상 객체의 내부 필드는 바꿀 수 있지만, 매개변수 자체에 새 객체를 대입해도 호출자 측 변수는 바뀌지 않음!)

---

### 2.4 다중 값 반환 기법
자바의 `return` 문은 오직 하나의 값만 반환할 수 있습니다.
- 여러 값을 돌려주고 싶을 때는:
  1. **배열:** `return new int[] {num1, num2};`
  2. **사용자 정의 DTO/VO 객체**
  3. **Java 14+ Record 클래스:** `record Point(int x, int y) {}`

---

## 📝 [ch02 연습문제 & 복습 과제]

<details>
<summary><b>[문제 1] O / X 퀴즈</b></summary>

1. 메서드의 반환 타입이 `void`이면 메서드 내부에 `return;` 문을 절대 쓸 수 없다.
2. 자바에서 매개변수로 객체를 넘기면 원본 변수 자체가 넘어가는 Call by Reference이다.
3. `split("-")` 메서드는 구분자를 기준으로 문자열을 잘라 `String[]` 배열로 반환한다.

**[정답 및 해설]**  
1. **X** : 반환할 값이 없을 뿐, `return;`을 써서 메서드를 중간에 조기 종료(Early Return)할 수 있습니다.
2. **X** : 주소 "값"이 복사되어 전달되는 Call by Value입니다.
3. **O** : 맞습니다.
</details>

<details>
<summary><b>[문제 2] 실습 과제: 문자열 변환 유틸리티 도구 만들기</b></summary>

**요구사항:**
`변환도구` 클래스 안에 다음 3개의 메서드를 작성하고 `main`에서 결과를 검증하세요:
1. `시간표기변환("14:30")` ➔ `"14시 30분"` 반환 (`split(":")` 활용)
2. `전화번호마스킹("010-1234-5678")` ➔ `"010-****-5678"` 반환
3. `날짜분리("2026-09-29")` ➔ 정수 배열 `{2026, 9, 29}` 반환 (`Integer.parseInt()` 활용)

**[모범 답안]**
```java
class 변환도구 {
    String 시간표기변환(String time) {
        String[] t = time.split(":");
        return t[0] + "시 " + t[1] + "분";
    }

    String 전화번호마스킹(String phone) {
        String[] p = phone.split("-");
        return p[0] + "-****-" + p[2];
    }

    int[] 날짜분리(String date) {
        String[] parts = date.split("-");
        return new int[] {
            Integer.parseInt(parts[0]),
            Integer.parseInt(parts[1]),
            Integer.parseInt(parts[2])
        };
    }
}
```
</details>

---

# 3. [ch03] JVM 메모리 구조, static, 그리고 접근 제어자

```
┌─────────────────────────────────────────────────────────────┐
│                    JVM Runtime Data Area                    │
├──────────────────────────────┬──────────────────────────────┤
│ 1. 메서드 영역 (Method Area) │ [Static Bank]                │
│    - 클래스 로더가 적재한    │  - 은행.총예금 : 10000        │
│      클래스 구조, 상수, static│  - 은행.다음번호: 1002       │
├──────────────────────────────┼──────────────────────────────┤
│ 2. 힙 영역 (Heap Area)       │ [계좌 객체 1]   [계좌 객체 2]│
│    - new로 생성된 인스턴스   │  예금주: 준일    예금주: 준이 │
│    - GC의 관리 대상          │  잔액: 7000      잔액: 3000   │
├──────────────────────────────┼──────────────────────────────┤
│ 3. 스택 영역 (Stack Area)    │ main() 지역변수:             │
│    - 각 스레드마다 독립 생성 │  a1 ──▶ [계좌 객체 1 주소]   │
│    - 지역 변수, 참조 변수    │  a2 ──▶ [계좌 객체 2 주소]   │
└──────────────────────────────┴──────────────────────────────┘
```

### 3.1 `static` 변수 vs 인스턴스 변수
- **인스턴스 변수:** 객체마다 서로 다른 고유한 값을 가져야 할 때 (예: 계좌 잔액, 고객 이름).
- **`static` 변수 (클래스 변수):** 클래스로부터 만들어진 **모든 객체가 단 하나의 값을 공유**해야 할 때 (예: 은행 총예금, 누적 고객 번호, 전역 설정값).

> [!WARNING]
> **`static` 남용의 위험성 (기술 면접 핵심 질문)**  
> 1. **메모리 누수:** 프로그램이 종료될 때까지 메모리(Method Area)에 계속 상주하므로 GC가 정리하지 못합니다.  
> 2. **동시성(Concurrency) 버그:** 멀티스레드 환경에서 여러 스레드가 하나의 static 변수를 동시에 수정하면 Race Condition이 발생합니다.  
> 3. **테스트의 어려움:** 전역 상태를 공유하므로 단위 테스트의 독립성이 깨집니다.

---

### 3.2 10대 현실 시뮬레이션 핵심 요약

1. **학생관리시스템 (`StaticBasic`):** 연도(`2026`)와 순번(`번호++`) 조합 학번 발급.
2. **은행과 계좌 (`StaticBank`):** `총예금`은 `static`, `잔액`은 개별 인스턴스.
3. **카페 (`StaticCafe`):** `static int 번호 = 100;` 주문번호 자동 카운팅 및 삼항연산 가격 결정.
4. **회사와 사원 (`StaticCompany`):** 연도(`26`) + 부서(`D`/`X`) + 사원수 결합 사번 발급.
5. **택배 (`StaticDelivery`):** 날짜 코드 조합 운송장 번호 생성 및 무게(10kg)별 요금 계산.
6. **게임 (`StaticGame`):** 공통 서버명 일괄 바인딩, 접속자 수 누적 및 개별 레벨업.
7. **병원 (`StaticHospital`):** `대기인원` 증감 제어 및 진료 상태 플래그.
8. **도서관 (`StaticLibrary`):** `b3 = b1` 참조 복사 후 대출 상태 변경 시 동일 인스턴스 수정 원리.
9. **주차장 (`StaticParking`):** `남은자리` 소진 시 만차 메시지 및 `null` 반환.
10. **로딩 테스트 (`StaticTest`):** static 필드 접근 시 `static { ... }` 블록이 최초 1회만 실행됨을 증명.

---

### 3.3 접근 제어자 4단계와 캡슐화 (Encapsulation)
- **가시성:** `private` < `default` < `protected` < `public`
- **캡슐화의 목적:** 외부에서 내부 변수에 직접 접근해 비정상적인 값(음수 잔액, 200점 점수 등)을 넣는 것을 차단하고, 유효성 검증 로직이 포함된 **Getter / Setter** 메서드를 통해서만 제어하도록 강제합니다.

---

## 📝 [ch03 연습문제 & 복습 과제]

<details>
<summary><b>[문제 1] 영화관 예매 시스템 (`PracticeStatic`)</b></summary>

**요구사항:**
1. `티켓` 클래스: `좌석번호`, `영화제목`, `가격` 필드를 선언하고 생성자에서 초기화하세요.
2. `영화관` 클래스:
   - `static int 좌석번호 = 1;`
   - `static int 남은좌석 = 3;`
   - `static int 총매출;`
   - `static { ... }` 블록에서 `"영화관 오픈"` 출력
   - `static int 가격계산(int 나이)`: 20세 미만은 8000원, 성인은 12000원 반환
   - `static 티켓 예매(String 영화제목, int 나이)`:
     - 남은 좌석이 0이면 `"<영화제목> 매진"` 출력 후 `null` 반환
     - 남은 좌석 1 감소, 총매출에 가격 누적
     - 좌석번호를 1씩 증가시키며 새 `티켓` 객체를 생성하여 반환

**[모범 답안]**
```java
class 티켓 {
    int 좌석번호;
    String 영화제목;
    int 가격;

    티켓(int 좌석번호, String 영화제목, int 가격) {
        System.out.println("티켓 생성자 호출");
        this.좌석번호 = 좌석번호;
        this.영화제목 = 영화제목;
        this.가격 = 가격;
    }
}

class 영화관 {
    static int 좌석번호 = 1;
    static int 남은좌석 = 3;
    static int 총매출;

    static {
        System.out.println("영화관 오픈");
    }

    static int 가격계산(int 나이) {
        return 나이 < 20 ? 8000 : 12000;
    }

    static 티켓 예매(String 영화제목, int 나이) {
        if (남은좌석 <= 0) {
            System.out.println(영화제목 + " 매진");
            return null;
        }
        int price = 가격계산(나이);
        남은좌석--;
        총매출 += price;
        return new 티켓(좌석번호++, 영화제목, price);
    }
}
```
</details>

<details>
<summary><b>[문제 2] 안전계좌 캡슐화 실습 (`PracticeAccess`)</b></summary>

**요구사항:**
`안전계좌` 클래스의 `예금주`와 `잔액`을 `private`으로 선언하고 다음 메서드를 구현하세요:
1. `getOwner()`, `getBalance()` Getter 구현
2. `boolean 입금(int 금액)`: 입금액이 0 이하이면 `"입금 실패"` 출력 후 `false`, 정상이면 잔액 증가 후 `true`
3. `boolean 출금(int 금액)`: 출금액이 잔액보다 크면 `"출금 실패"` 출력 후 `false`, 정상이면 잔액 차감 후 `true`

**[모범 답안]**
```java
class 안전계좌 {
    private String 예금주;
    private int 잔액;

    안전계좌(String 예금주, int 잔액) {
        this.예금주 = 예금주;
        this.잔액 = 잔액;
    }

    public String getOwner() { return 예금주; }
    public int getBalance() { return 잔액; }

    public boolean 입금(int 금액) {
        if (금액 <= 0) {
            System.out.println("입금 실패: 잘못된 금액");
            return false;
        }
        잔액 += 금액;
        return true;
    }

    public boolean 출금(int 금액) {
        if (금액 > 잔액) {
            System.out.println("출금 실패: 잔액 부족");
            return false;
        }
        잔액 -= 금액;
        return true;
    }
}
```
</details>

---

# 4. [ch04] 배열(Array)의 구조와 다차원 배열

```
[ 2차원 배열의 메모리 구조: 배열의 배열 ]
nums2 (참조 변수) ──▶ [ 행 0 주소 ] ──▶ [ 10, 20, 30 ]  (nums2[0])
                     [ 행 1 주소 ] ──▶ [ 40, 50, 60 ]  (nums2[1])
```

### 4.1 배열의 메모리 특성
- 배열은 인덱스를 통한 **임의 접근(Random Access, $O(1)$)**이 가능하여 조회가 매우 빠릅니다.
- 한 번 선언된 배열의 크기는 메모리상에 연속 할당되므로 변경할 수 없습니다.

### 4.2 얕은 복사(Shallow Copy) vs 깊은 복사(Deep Copy)
- **얕은 복사:** `Student[] s2 = s1;` (배열의 주소값만 복사하여 원본과 동일한 배열 공유)
- **깊은 복사:** `System.arraycopy()` 또는 `clone()`을 사용하여 새로운 배열 공간을 만들고 원소들을 하나씩 복사.

### 4.3 2차원 배열과 행 참조
`int[][] arr = new int[2][3];`에서 `arr[0]`은 그 자체로 1차원 배열(`int[]`)을 가리키는 참조 변수입니다.

---

## 📝 [ch04 연습문제 & 복습 과제]

<details>
<summary><b>[문제 1] 2차원 행렬(Matrix) 대각선 합 구하기</b></summary>

**요구사항:**
$3 \times 3$ 크기의 2차원 배열이 주어졌을 때, 좌상단에서 우하단으로 이어지는 주 대각선 원소들의 합을 구하는 코드를 작성하세요.
```java
int[][] matrix = {
    { 1,  2,  3 },
    { 4,  5,  6 },
    { 7,  8,  9 }
};
```

**[모범 답안]**
```java
int sum = 0;
for (int i = 0; i < matrix.length; i++) {
    sum += matrix[i][i]; // (0,0), (1,1), (2,2)
}
System.out.println("주 대각선의 합: " + sum); // 1 + 5 + 9 = 15
```
</details>

---

# 5. [ch05] 연산자, 제어문, 콘솔 입출력과 실전 데이터 모델링

### 5.1 `switch`문의 Fall-through와 Java 14+ 화살표 문법
```java
// 구형 문법: break가 없으면 아래로 흘러내림
switch (code) {
    case 1: System.out.println("A"); break;
    default: System.out.println("기타");
}

// 모던 문법 (Java 14+ Switch Expressions): break 불필요, 쉼표 복수 매칭, 값 직접 반환
String grade = switch (score / 10) {
    case 10, 9 -> "A";
    case 8      -> "B";
    default    -> "F";
};
```

---

### 5.2 `Scanner`의 치명적 함정: 개행 문자(`\n`) 버퍼 비우기
```java
int count = scanner.nextInt();
scanner.nextLine(); // ★ 필수: 버퍼에 남은 \n을 비워주지 않으면 다음 nextLine()이 건너뛰어짐!
String name = scanner.nextLine();
```

---

### 5.3 동적 배열 확장 알고리즘과 대용량 데이터 필터링
배열 크기를 동적으로 늘리는 알고리즘:
```java
User[] newArray = new User[oldArray.length + 1];
System.arraycopy(oldArray, 0, newArray, 0, oldArray.length);
newArray[newArray.length - 1] = newUser;
oldArray = newArray;
```

---

## 📝 [ch05 연습문제 & 복습 과제]

<details>
<summary><b>[문제 1] 별 찍기 종합 세트 (우측 정렬 & 역삼각형)</b></summary>

**요구사항:**
아래 형태의 5줄 우측 정렬 삼각형을 출력하는 이중 `for` 문을 완성하세요.
```
    *
   **
  ***
 ****
*****
```

**[모범 답안]**
```java
for (int i = 0; i < 5; i++) {
    for (int j = 0; j < 4 - i; j++) {
        System.out.print(" ");
    }
    for (int k = 0; k < i + 1; k++) {
        System.out.print("*");
    }
    System.out.println();
}
```
</details>

<details>
<summary><b>[문제 2] Scanner 동적 회원 목록 입력기</b></summary>

**요구사항:**
`while(true)` 루프를 돌며 사용자에게 `"회원을 추가하시겠습니까? (y/n): "`을 묻고,
- `y` 입력 시 이름을 입력받아 동적 배열에 추가합니다.
- `n` 입력 시 루프를 탈출하고 현재까지 입력된 전체 명단을 출력합니다.

**[모범 답안]**
```java
Scanner scanner = new Scanner(System.in);
String[] names = new String[0];

while (true) {
    System.out.print("회원을 추가하시겠습니까? (y/n): ");
    String answer = scanner.nextLine();
    if (answer.equalsIgnoreCase("y")) {
        System.out.print("이름: ");
        String name = scanner.nextLine();
        String[] newArr = new String[names.length + 1];
        System.arraycopy(names, 0, newArr, 0, names.length);
        newArr[newArr.length - 1] = name;
        names = newArr;
    } else if (answer.equalsIgnoreCase("n")) {
        break;
    }
}
System.out.println("등록된 회원: " + Arrays.toString(names));
```
</details>

---

# 6. [ch06] 메서드 오버로딩과 생성자 패턴

### 6.1 메서드 오버로딩 (Method Overloading)
- 하나의 클래스 내에 **이름이 동일하지만 매개변수 시그니처(개수, 타입, 순서)가 다른 메서드를 여러 개 정의**.
- **성립 불가 조건:** 반환 타입(Return Type)만 다른 경우, 매개변수 변수명만 다른 경우는 컴파일 에러 발생.

---

### 6.2 생성자 체이닝 (`this()`)
중복 코드를 줄이기 위해 하나의 생성자에서 다른 생성자를 호출하는 테크닉:
```java
class Student {
    String name;
    int age;

    Student() {
        this("이름없음", 20); // 반드시 생성자의 첫 번째 줄에 위치해야 함!
    }

    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
```

---

## 📝 [ch06 연습문제 & 복습 과제]

<details>
<summary><b>[문제 1] 세탁기 오버로딩 메서드 설계</b></summary>

**요구사항:**
`세탁기` 클래스 안에 다음 오버로딩 메서드를 구현하세요:
1. `세탁()` : `"표준 세탁 코스 실행"` 출력
2. `세탁(int 세제)` : `"세제 [세제]ml 투입 후 세탁 실행"` 출력
3. `세탁(int 세제, int 섬유유연제)` : `"세제 [세제]ml, 섬유유연제 [섬유유연제]ml 투입 후 안심 세탁 실행"` 출력

**[모범 답안]**
```java
class 세탁기 {
    void 세탁() {
        System.out.println("표준 세탁 코스 실행");
    }
    void 세탁(int 세제) {
        System.out.println("세제 " + 세제 + "ml 투입 후 세탁 실행");
    }
    void 세탁(int 세제, int 섬유유연제) {
        System.out.println("세제 " + 세제 + "ml, 섬유유연제 " + 섬유유연제 + "ml 투입 후 안심 세탁 실행");
    }
}
```
</details>

---

# 7. [ch07] 객체지향의 정수: 상속, 다형성, 추상화, 인터페이스

```
[ 객체지향 상속 & 다형성 계층도 ]
            ┌────────────────────────┐
            │   <<interface>> Sensor  │
            └───────────┬────────────┘
                        │ implements
            ┌───────────▼────────────┐
            │ abstract RemoteControl │
            └───────────┬────────────┘
                        │ extends
          ┌─────────────┴─────────────┐
          │                           │
┌─────────▼───────────┐     ┌─────────▼───────────────┐
│   TvRemoteControl   │     │   MonitorRemoteControl  │
│ - powerOn() 오버라이딩 │    │ - powerOn() 오버라이딩   │
└─────────────────────┘     └─────────────────────────┘
```

### 7.1 다형성(Polymorphism)과 동적 바인딩(Dynamic Binding)
- **업캐스팅:** 부모 타입으로 자식 객체를 가리킴 (`Animal a = new Dog();`).
- **동적 바인딩:** 컴파일 시점에는 부모의 메서드를 가리키는 것처럼 보이지만, **런타임 시점에 실제 생성된 힙 메모리의 자식 객체 메서드가 실행**되는 원리.

---

### 7.2 모던 다운캐스팅: Java 16+ Pattern Matching for `instanceof`
```java
// 구형 다운캐스팅 방식
if (animal instanceof Dog) {
    Dog d = (Dog) animal;
    d.bark();
}

// Java 16+ 신규 패턴 매칭 문법 (타입 체크와 형변환을 한 번에!)
if (animal instanceof Dog d) {
    d.bark();
}
```

---

### 7.3 추상 클래스(`abstract`) vs 인터페이스(`interface`)
| 항목 | 추상 클래스 (`abstract class`) | 인터페이스 (`interface`) |
|---|---|---|
| **상속/구현** | `extends` (단일 상속만 지원) | `implements` (다중 구현 가능) |
| **목적** | 관련성 높은 클래스들의 공통 뼈대 및 상태 상속 | 서로 다른 클래스들에 표준 행동 규격 강제 |
| **필드** | 일반 인스턴스 변수 선언 가능 | `public static final` 상수만 가능 |
| **메서드** | 추상 메서드 + 일반 구현 메서드 모두 가능 | 기본적으로 `public abstract` (Java 8부터 `default`, `static` 메서드 허용) |

---

### 7.4 상속과 SOLID 객체지향 설계 5대 원칙
1. **SRP (단일 책임 원칙):** 하나의 클래스는 하나의 책임만 가져야 한다.
2. **OCP (개방-폐쇄 원칙):** 확장은 열려 있고 변경에는 닫혀 있어야 한다. (인터페이스를 두어 새 구현체 추가 시 기존 코드 수정 없음!)
3. **LSP (리스코프 치환 원칙):** 자식 클래스는 언제나 부모 클래스를 대체할 수 있어야 한다.
4. **ISP (인터페이스 분리 원칙):** 사용하지 않는 메서드에 의존하지 않도록 인터페이스를 작게 쪼갠다.
5. **DIP (의존 역전 원칙):** 구체 클래스(`ArrayList`)가 아니라 상위 인터페이스(`List`)에 의존해야 한다.

---

### 7.5 `Parent & Child` 동적 바인딩 퍼즐 완벽 해설 (`Main.java`)
```java
class Parent {
    static int total = 0;
    int v = 1;
    public Parent() {
        total += (++v); // v=2, total=2
        show();         // ★ 런타임 인스턴스가 Child이므로 Child.show()가 실행됨!
    }
    public void show() { total += total; }
}
class Child extends Parent {
    int v = 10;
    public Child() {
        total += v++; // v=10, total = 6 + 10 = 16
        show();       // Child.show() 실행 -> total = 16 + 32 = 48
    }
    @Override
    public void show() { total += total * 2; }
}
```
- **부모 생성자가 돌고 있는 중이라도 가상 메서드 테이블(vtable)에 의해 이미 재정의된 자식의 `show()`가 바인딩**됩니다.

---

## 📝 [ch07 종합 연습문제 (실전 프로젝트 과제)]

<details>
<summary><b>[실습 과제 1] 다형성 결제 시스템 (`Payment` 인터페이스)</b></summary>

**요구사항:**
1. `Payment` 인터페이스:
   - 추상 메서드 `void pay(int amount);`
   - default 메서드 `void printReceipt(int amount)`: `"[amount]원 영수증이 출력되었습니다."` 출력
2. 구현체 `CreditCard` (카드결제)와 `KakaoPay` (간편결제) 클래스 작성.
   - `CreditCard` 고유 메서드: `void cancel()` (`"카드 결제를 취소합니다."`)
3. `List<Payment>` 다형성 리스트에 두 결제 수단을 담고 일괄 결제(`pay(50000)`) 및 영수증을 출력하세요.
4. 반복문 순회 중 `CreditCard`인 경우에만 `cancel()`을 호출하는 다운캐스팅을 작성하세요.

**[모범 답안]**
```java
interface Payment {
    void pay(int amount);
    default void printReceipt(int amount) {
        System.out.println(amount + "원 영수증이 출력되었습니다.");
    }
}

class CreditCard implements Payment {
    @Override
    public void pay(int amount) {
        System.out.println("신용카드로 " + amount + "원 결제 완료");
    }
    public void cancel() {
        System.out.println("카드 결제를 취소합니다.");
    }
}

class KakaoPay implements Payment {
    @Override
    public void pay(int amount) {
        System.out.println("카카오페이로 " + amount + "원 간편 결제 완료");
    }
}

public class PaymentMain {
    public static void main(String[] args) {
        List<Payment> payments = List.of(new CreditCard(), new KakaoPay());

        for (Payment p : payments) {
            p.pay(50000);
            p.printReceipt(50000);
            if (p instanceof CreditCard card) {
                card.cancel();
            }
        }
    }
}
```
</details>

<details>
<summary><b>[실습 과제 2] 직원 급여 관리 시스템 (`Employee` 추상 클래스)</b></summary>

**요구사항:**
1. 추상 클래스 `Employee`:
   - 필드: `final int id; final String name;`
   - 추상 메서드: `abstract int getSalary();`
2. `FullTimeEmployee` (정규직): 월 고정급여 반환
3. `PartTimeEmployee` (시급제): 시급 $\times$ 근무시간 반환
4. `List<Employee>` 리스트를 순회하며 전 직원의 급여 합계를 계산해 출력하세요.

**[모범 답안]**
```java
abstract class Employee {
    final int id;
    final String name;

    Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    abstract int getSalary();
}

class FullTimeEmployee extends Employee {
    int monthlySalary;

    FullTimeEmployee(int id, String name, int monthlySalary) {
        super(id, name);
        this.monthlySalary = monthlySalary;
    }

    @Override
    int getSalary() { return monthlySalary; }
}

class PartTimeEmployee extends Employee {
    int hourlyRate;
    int hours;

    PartTimeEmployee(int id, String name, int hourlyRate, int hours) {
        super(id, name);
        this.hourlyRate = hourlyRate;
        this.hours = hours;
    }

    @Override
    int getSalary() { return hourlyRate * hours; }
}
```
</details>

---

## 🏆 핵심 기술 면접 대비 5대 Q&A

1. **Q. 메서드 오버로딩(Overloading)과 오버라이딩(Overriding)의 차이는 무엇인가요?**
   - **오버로딩:** 같은 클래스 내에서 메서드 이름은 같지만 매개변수의 개수, 타입, 순서가 다른 메서드를 여러 개 정의하는 것 (컴파일 타임 다형성).
   - **오버라이딩:** 부모 클래스로부터 상속받은 메서드를 자식 클래스에서 재정의하는 것 (런타임 다형성, 동적 바인딩).

2. **Q. 추상 클래스와 인터페이스는 언제 각각 선택해야 하나요?**
   - **추상 클래스:** 밀접하게 연관된 클래스들 간에 필드 상태와 공통 코드를 물려주고 상속 계층(`is-a` 관계)을 형성할 때 사용합니다.
   - **인터페이스:** 서로 관련 없는 클래스들이라도 동일한 행동 규격(`can-do` 관계)을 갖추게 하거나, 다중 구현 및 결합도를 낮추는 의존 역전(DIP)을 적용할 때 사용합니다.

3. **Q. `static` 키워드의 특징과 남용 시 문제점은?**
   - `static` 멤버는 클래스 로딩 시 Method Area에 적재되어 인스턴스 생성 없이 공유됩니다. 남용 시 GC의 관리를 받지 못해 메모리 누수가 발생할 수 있고, 멀티스레드 환경에서 데이터 불일치가 일어나며 객체지향 캡슐화를 저해합니다.

4. **Q. 업캐스팅된 객체에서 오버라이딩된 메서드가 호출되는 원리는?**
   - JVM의 가상 메서드 테이블(Virtual Method Table, vtable)에 의해 런타임에 실제 힙에 존재하는 인스턴스 타입의 메서드 주소를 찾아 실행하는 **동적 바인딩(Dynamic Binding)** 덕분입니다.

5. **Q. `equals()`를 재정의할 때 `hashCode()`도 함께 재정의해야 하는 이유는?**
   - 자바의 객체 규약(Contract)상 두 객체가 `equals()`로 같다고 판별되면 두 객체의 `hashCode()` 반환값도 반드시 같아야 합니다. 이를 지키지 않으면 `HashSet`, `HashMap` 같은 해시 기반 컬렉션에서 객체를 정상적으로 검색하거나 저장하지 못하는 치명적인 버그가 발생합니다.
