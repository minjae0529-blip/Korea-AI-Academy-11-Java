# 📘 Korea AI Academy Java 프로그래밍 핵심 완성 교재 (ch01 ~ ch07)

> **수강생을 위한 완벽 학습 가이드**  
> 본 교재는 `src/main/java/com/korai/study` 패키지(ch01 ~ ch07)의 모든 소스 코드와 예제, 연습문제, 실전 시나리오를 단 하나도 빠짐없이 체계적으로 정리한 마스터 교재입니다.  
> 초보자도 원리부터 동작 메커니즘(JVM 메모리, 스택 프레임, 힙 할당)까지 한눈에 이해할 수 있도록 그림, 코드 주석, 실행 흐름도로 구성되어 있습니다.

---

## 📑 목차 (Table of Contents)

1. **[ch01. 변수와 클래스, 그리고 제네릭 (ClassMain)](#ch01-변수와-클래스-그리고-제네릭)**
   - 1.1 변수(Variable)와 상수(Constant, `final`)
   - 1.2 클래스 선언과 객체 생성(`new`), 인스턴스화
   - 1.3 `Object` 범용 타입의 유연성과 형변환의 한계
   - 1.4 제네릭(Generic `<A>`)의 등장 배경과 타입 안정성
   - 1.5 제네릭 와일드카드(`<?>`)와 기본형 vs 참조형 복사

2. **[ch02. 함수(메서드)의 본질과 재사용 (FunctionMain)](#ch02-함수메서드의-본질과-재사용)**
   - 2.1 함수를 사용하는 두 가지 핵심 이유 (재사용성 & 코드 정리)
   - 2.2 필드 기반 메서드 vs 매개변수 기반 메서드
   - 2.3 매개변수(Parameter), 반환값(`return`), 반환 타입(`void`)
   - 2.4 문자열 가공(`split`)과 다중 값 반환(배열 반환) 테크닉
   - 2.5 메서드 호출 체이닝과 합성

3. **[ch03. JVM 메모리 구조, static, 그리고 접근 제어자](#ch03-jvm-메모리-구조-static-그리고-접근-제어자)**
   - 3.1 JVM 메모리 3대 영역 (Method Area / Stack / Heap)
   - 3.2 클래스 로딩과 `static { ... }` 초기화 블록
   - 3.3 `static` 멤버(클래스 변수/메서드) vs 인스턴스 멤버
   - 3.4 현실 세계 10대 실전 시나리오 분석
     - ① 학생관리시스템 (자동 학번 발급)
     - ② 은행과 계좌 (총예금 공유 vs 개인 잔액)
     - ③ 카페 주문 (누적 주문번호 & 삼항연산 가격)
     - ④ 회사와 사원 (연도+부서코드+사번 조합)
     - ⑤ 택배회사 (날짜 기반 운송장 & 무게별 요금)
     - ⑥ 게임서버 (서버 접속자 수 추적 & 레벨업)
     - ⑦ 병원 접수 (대기인원 증감 & 진료 상태 관리)
     - ⑧ 도서관 (도서 등록번호 & 대출 상태 참조 복사)
     - ⑨ 주차장 (남은 자리 카운팅 & 만차 null 처리)
     - ⑩ 클래스 로딩 단 1회 증명 테스트
   - 3.5 접근 제어자 4종 (`private`, default, `protected`, `public`)
   - 3.6 캡슐화(Encapsulation)와 Getter / Setter
   - 3.7 내부 클래스(Inner Class)의 생성 문법
   - 3.8 3계층 아키텍처 기초 (Entity, Service, Main)

4. **[ch04. 배열(Array)의 구조와 다차원 배열](#ch04-배열array의-구조와-다차원-배열)**
   - 4.1 배열의 본질과 메모리 할당 (연속 공간 & 참조형 타입)
   - 4.2 기본형 배열(`byte[]`, `int[]`)과 객체 배열(`Student[]`)
   - 4.3 2차원 배열의 선언, 생성, 행(Row) 단위 참조
   - 4.4 `Arrays.fill()`과 `Arrays.toString()`
   - 4.5 반복문을 통한 배열 탐색과 `arrayToString()` 수동 구현
   - 4.6 시간 기반 무한 루프 제어

5. **[ch05. 연산자, 제어문, 콘솔 입출력과 실전 데이터 모델링](#ch05-연산자-제어문-콘솔-입출력과-실전-데이터-모델링)**
   - 5.1 연산자의 원리: 논리 연산자(`&&`, `||`, `!`)와 전기 회로 메커니즘
   - 5.2 삼항 연산자와 윤년 계산 알고리즘, 최댓값 판별법
   - 5.3 조건문: `if ~ else if ~ else` 성적 판정
   - 5.4 `switch ~ case` 문과 `break`의 본질 (Fall-through 현상과 최신 화살표 문법)
   - 5.5 다중 반복문과 별 찍기 5대 패턴
   - 5.6 구구단 2D/3D 배열 포맷팅 (`\t` vs `\n`)
   - 5.7 콘솔 입력(`Scanner`)과 버퍼 개행(`\n`) 처리 주의점
   - 5.8 파일 읽기(`FileReader`, `BufferedReader`)와 EOF 루프
   - 5.9 동적 배열 확장 알고리즘 (`new User[length + 1]`)
   - 5.10 실전 `User` 데이터 30인 모델링 및 조건 필터링

6. **[ch06. 메서드 심화와 생성자 오버로딩](#ch06-메서드-심화와-생성자-오버로딩)**
   - 6.1 정적 메서드 호출 vs 인스턴스 메서드 호출
   - 6.2 매개변수로 객체 전달하기 (Call by Reference)
   - 6.3 메서드 오버로딩 (Method Overloading)의 조건과 원리
   - 6.4 `System.out.println()` 내부 구조 분석 (`PrintStream`)
   - 6.5 생성자 오버로딩 (기본 생성자부터 다중 파라미터까지)
   - 6.6 `this` 참조와 `toString()` 재정의

7. **[ch07. 객체지향의 핵심: 상속, 다형성, 추상화, 인터페이스](#ch07-객체지향의-핵심-상속-다형성-추상화-인터페이스)**
   - 7.1 컬렉션 프레임워크와 다형성의 첫걸음 (`List<String> = new ArrayList<>()`)
   - 7.2 상속(`extends`)의 개념과 부모 멤버 확장
   - 7.3 메서드 오버라이딩(`@Override`)과 동적 바인딩(Dynamic Binding)
   - 7.4 업캐스팅(Upcasting)과 부모 타입 리스트를 통한 일괄 처리
   - 7.5 다운캐스팅(Downcasting)과 `instanceof` 타입 검증
   - 7.6 `super` 키워드와 부모 생성자 호출 메커니즘, 필드 은닉(Shadowing)
   - 7.7 추상 클래스(`abstract class`)와 추상 메서드 규격
   - 7.8 인터페이스(`interface`)의 특징과 `default` 메서드, 다중 구현
   - 7.9 클래스 초기화 순서와 오버라이딩 퍼즐 심화 분석 (`Parent & Child`)
   - 7.10 생성자 설계 패턴(NoArgs, RequiredArgs, AllArgs)과 `Object` 클래스

---

# 1. ch01. 변수와 클래스, 그리고 제네릭

> **관련 소스 파일:** `ch01/ClassMain.java`  
> **핵심 키워드:** 변수, 상수(`final`), 클래스(Class), 객체(Object/Instance), `new`, 필드, 참조, `Object` 타입, 제네릭(`<T>`), 다이아몬드 연산자(`<>`), 와일드카드(`<?>`), 값 복사 vs 참조 복사

```
[ 클래스와 객체의 관계 비유 ]
클래스(붕어빵 틀 / 설계도)  ── new 키워드로 찍어냄 ──▶  객체(붕어빵 / 실제 메모리에 생성된 인스턴스)
- String name; int age; (필드)                     - jun.name = "김준일"; jun.age = 33;
```

### 1.1 변수(Variable)와 상수(Constant, `final`)
- **변수(Variable):** 데이터를 저장할 수 있는 메모리 공간의 이름이며, 언제든지 다른 값으로 변경(재할당)할 수 있습니다.
  ```java
  int num = 10;
  num = 20; // 변경 가능
  ```
- **상수(Constant):** 키워드 `final`이 붙은 변수로, 한 번 값을 대입(초기화)하면 이후 절대로 변경할 수 없습니다.
  ```java
  final String name = "김준일";
  // name = "이순신"; // 컴파일 에러 발생! (Cannot assign a value to final variable)
  ```

### 1.2 클래스 선언과 객체 생성(`new`), 인스턴스화
자바에서는 연관된 데이터(상태)를 묶어서 하나의 새로운 **사용자 정의 자료형**을 만들 수 있습니다. 이것이 바로 **클래스(Class)**입니다.
```java
// Student라는 이름의 설계도 정의
class Student {
    String name; // 학생의 이름을 저장할 멤버 변수 (필드)
    int age;     // 학생의 나이를 저장할 멤버 변수 (필드)
}

// 객체 생성 (인스턴스화)
Student jun = new Student();
jun.name = "김준일"; // 점(.) 연산자를 통해 객체의 필드에 직접 접근
jun.age = 33;
```
- `Student jun`: 스택(Stack) 메모리에 `Student` 객체의 주소값을 담을 수 있는 참조 변수 `jun`을 선언합니다.
- `new Student()`: 힙(Heap) 메모리에 실제 `name`과 `age` 변수가 존재하는 공간을 할당하고, 그 시작 주소값을 반환합니다.
- `=`: 대입 연산자를 통해 힙 메모리의 주소값을 스택의 `jun` 변수에 저장합니다.

### 1.3 `Object` 범용 타입의 유연성과 형변환의 한계
만약 학생의 나이(`age`)에 정수(33), 문자열("33세"), 또는 또 다른 객체를 자유롭게 넣고 싶다면 어떻게 해야 할까요?  
자바의 모든 클래스는 기본적으로 최상위 클래스인 `java.lang.Object`를 상속받습니다. 따라서 `Object` 타입 변수는 어떤 형태의 객체든 담을 수 있습니다.
```java
class Student2 {
    String name;
    Object age; // 어떤 자료형이든 다 담을 수 있는 최상위 타입
}

Student2 jun2 = new Student2();
jun2.name = "김준이";
jun2.age = jun; // 다른 Student 객체를 담음

Student2 jun22 = new Student2();
jun22.name = "김준이이";
jun22.age = "33"; // 문자열을 담음
```
- **문제점:** `Object` 타입은 모든 것을 담을 수 있어 편리하지만, 값을 꺼내서 사용할 때 원래 타입이 무엇인지 알기 어렵고, 반드시 강제 형변환(Casting)을 거쳐야 하며, 잘못된 형변환 시 `ClassCastException` 런타임 에러가 발생합니다.

### 1.4 제네릭(Generic `<A>`)의 등장 배경과 타입 안정성
위와 같은 `Object`의 한계(타입 불안정성)를 해결하기 위해 Java 5부터 **제네릭(Generic)**이 도입되었습니다.  
클래스를 정의할 때는 구체적인 타입을 명시하지 않고 가상의 타입 매개변수(`<A>`)로 비워두었다가, **실제 객체를 생성할 때(`new`) 구체적인 타입을 지정**합니다.
```java
class Student3<A> {
    String name;
    A age; // 객체를 생성할 때 지정한 타입으로 결정됨
}

// 1. age를 String으로 사용하고 싶을 때
Student3<String> jun3 = new Student3<String>();
jun3.age = "33";
// jun3.age = 33; // 컴파일 에러! (문자열만 대입 가능하여 타입 안정성 보장)

// 2. age를 Integer로 사용하고 싶을 때 (다이아몬드 연산자 <> 생략 가능)
Student3<Integer> jun33 = new Student3<>();
jun33.age = 33;
```
- **다이아몬드 연산자 (`<>`):** Java 7부터는 좌항에 타입이 명시되어 있다면 우항 생성자 호출 시 타입 지정을 생략할 수 있습니다.
- **주의:** 제네릭 타입 파라미터에는 `int`, `double` 같은 기본형(Primitive Type)을 직접 쓸 수 없으며, 반드시 `Integer`, `Double` 같은 래퍼 클래스(Wrapper Class)를 사용해야 합니다.

### 1.5 제네릭 와일드카드(`<?>`)와 기본형 vs 참조형 복사
```java
int num = 10;
int num2 = num; // [값 복사] num2에 숫자 10 자체가 복사됨. num을 바꿔도 num2는 영향 없음.

Student3<?> jun333 = jun33; // [제네릭 와일드카드 & 참조 복사]
```
- **제네릭 와일드카드 (`<?>`):** "알 수 없는 임의의 타입"을 의미합니다. `Student3<Integer>`, `Student3<String>` 등 어떤 제네릭 타입이든 가리킬 수 있는 범용 참조 변수를 만들 때 사용합니다.
- **값 복사 vs 참조 복사:**
  - 기본 자료형(`int`, `double`, `boolean` 등): 변수에 값 자체가 저장되므로 대입 시 실제 값이 복사됩니다.
  - 참조 자료형(클래스 객체, 배열 등): 변수에 객체의 **메모리 주소값**이 저장되므로, 대입 시 같은 객체를 가리키게 되어 한쪽에서 수정하면 다른 쪽에도 영향을 미칩니다.

---

# 2. ch02. 함수(메서드)의 본질과 재사용

> **관련 소스 파일:** `ch02/FunctionMain.java`  
> **핵심 키워드:** 함수/메서드, 재사용성, 코드 정리, 매개변수(Parameter), 반환값(`return`), 반환 타입(`void`), `split()`, 다중 값 반환

### 2.1 함수를 사용하는 두 가지 핵심 이유
프로그래밍을 하다 보면 동일하거나 유사한 코드를 반복해서 작성하게 됩니다.
```java
// [개선 전: 중복 코드의 연속]
String date = "2026-09-23";
String name = "김준일";
String content = "자바 수업 진행하기";
System.out.println("업무일지[ " + date + "]");
System.out.println("이름: " + name);
System.out.println("내용: " + content);
System.out.println();

date = "2026-09-24";
name = "김준일";
content = "git 수업 진행하기";
// ... 똑같은 출력 코드가 반복됨 ...
```
1. **재사용성 (Reusability):** 반복적인 작업을 하나의 틀(도구)로 정의해 두면 언제 어디서든 호출만으로 재사용할 수 있습니다.
2. **정리 및 유지보수성 (Organization & Maintenance):** 코드에 명확한 이름(`업무일지출력`, `날짜표기변환`)이 붙어 가독성이 비약적으로 상승하며, 출력 형식을 바꿀 때 함수 내부 한 곳만 수정하면 전체에 반영됩니다.

### 2.2 필드 기반 메서드 vs 매개변수 기반 메서드
수업 예제에서는 두 가지 접근 방식을 비교하여 설명합니다.

#### 방식 1: 필드 기반 메서드 (`업무일지기능`)
```java
class 업무일지기능 {
    String date;
    String name;
    String content;

    void 업무일지출력() {
        System.out.println("업무일지[ " + date + "]");
        System.out.println("이름: " + name);
        System.out.println("내용: " + content);
        System.out.println();
    }
}

업무일지기능 f1 = new 업무일지기능();
f1.date = "2026-09-25";
f1.name = "김준일";
f1.content = "함수 수업하기";
f1.업무일지출력();
```
- 객체를 만들고 필드에 먼저 데이터를 채워 넣은 뒤, 메서드는 인자 없이 호출하여 객체의 상태를 출력합니다. 새로운 데이터를 출력하려면 매번 새 객체를 만들거나 필드 값을 덮어써야 합니다.

#### 방식 2: 매개변수(Parameter) 기반 메서드 (`업무일지기능2`)
```java
class 업무일지기능2 {
    // 호출 시점에 외부에서 데이터를 전달받음
    void 업무일지출력(String date, String name, String content) {
        System.out.println("업무일지[ " + date + "]");
        System.out.println("이름: " + name);
        System.out.println("내용: " + content);
        System.out.println();
    }
}

업무일지기능2 f3 = new 업무일지기능2();
f3.업무일지출력("2026-09-27", "김준일", "변수 수업하기");
f3.업무일지출력("2026-09-28", "김준일", "상수 수업하기");
```
- 하나의 도구(`f3`)를 만들어 두고 호출할 때마다 매개변수로 다른 데이터를 전달하므로 훨씬 유연하고 재사용성이 뛰어납니다.

### 2.3 매개변수, 반환값(`return`), 반환 타입
```
[ 메서드 선언의 4대 요소 ]
  String    날짜표기변환   (String date)   { ... return 결과; }
    ①            ②             ③                  ④
① 반환 타입 (Return Type): 호출한 쪽에 돌려줄 데이터의 타입. 돌려줄 값이 없으면 `void`
② 메서드 이름 (Method Name): 동사형으로 기능이 명확하게 드러나도록 명명
③ 매개변수 (Parameter): 작업을 수행하기 위해 외부에서 전달받는 입력값
④ 반환문 (`return`): 결과값을 호출한 자리로 돌려주고 메서드를 즉시 종료
```

### 2.4 문자열 가공과 다중 값 반환 테크닉
```java
// "2026-09-28" 문자열을 "2026년 09월 28일" 형식으로 변환하여 반환
String 날짜표기변환(String date) {
    String[] splitDate = date.split("-"); // "-"를 기준으로 잘라 배열로 만듦
    String year = splitDate[0];
    String month = splitDate[1];
    String day = splitDate[2];
    return year + "년 " + month + "월 " + day + "일";
}

// 자바는 기본적으로 메서드에서 1개의 값만 return할 수 있음
// 여러 개의 값을 한 번에 반환하고 싶다면 배열이나 객체로 묶어서 반환!
int[] fx1() {
    int num1 = 10;
    int num2 = 20;
    return new int[] {num1, num2}; // 두 정수를 묶어 배열로 반환
}
```

### 2.5 메서드 호출 체이닝과 합성
```java
// 날짜표기변환의 결과(String)가 업무일지출력의 첫 번째 매개변수로 즉시 전달됨
f3.업무일지출력(f3.날짜표기변환("2026-09-28"), "김준일", "상수 수업하기");
```

---

# 3. ch03. JVM 메모리 구조, static, 그리고 접근 제어자

> **관련 소스 파일:** `ch03/MethodArea.java`, `StaticBasic`, `StaticBank`, `StaticCafe`, `StaticCompany`, `StaticDelivery`, `StaticGame`, `StaticHospital`, `StaticLibrary`, `StaticParking`, `StaticTest`, `ch03/access/*`  
> **핵심 키워드:** JVM 메모리(Method Area, Stack, Heap), 클래스 로딩, `static` 블록, `static` 변수/메서드, 인스턴스 멤버, `this`, 접근 제어자 4종, 캡슐화(Getter/Setter), 3계층 아키텍처

### 3.1 JVM 메모리 3대 영역
자바 프로그램이 실행될 때 JVM(자바 가상 머신)은 운영체제로부터 메모리를 할당받아 다음과 같이 구역을 나누어 관리합니다.

```
┌─────────────────────────────────────────────────────────────┐
│                       JVM 메모리 구조                        │
├──────────────────────────────┬──────────────────────────────┤
│ 1. 메서드 영역 (Method Area) │ - 클래스 바이트코드(.class)   │
│    (또는 클래스 영역)        │ - static 변수, static 메서드 │
│                              │ - 프로그램 시작 시 딱 1회 로딩│
├──────────────────────────────┼──────────────────────────────┤
│ 2. 스택 영역 (Stack Area)    │ - 메서드 호출 시 프레임 생성 │
│                              │ - 지역 변수, 매개변수        │
│                              │ - 메서드 끝나면 즉시 소멸    │
├──────────────────────────────┼──────────────────────────────┤
│ 3. 힙 영역 (Heap Area)       │ - new 연산자로 생성된 객체   │
│                              │ - 인스턴스 변수들            │
│                              │ - 가비지 컬렉터(GC)가 수거   │
└──────────────────────────────┴──────────────────────────────┘
```

### 3.2 클래스 로딩과 `static { ... }` 초기화 블록
클래스는 프로그램 시작 시 모든 클래스가 한 번에 올라가는 것이 아니라, **해당 클래스를 코드에서 최초로 참조(호출)하는 순간** JVM에 의해 메모리(Method Area)에 딱 한 번 로딩됩니다.
```java
public class MethodArea {
    public static void main(String[] args) {
        // TestObject를 처음 언급하는 순간 TestObject 클래스가 로딩되며 static 블록이 먼저 1회 실행됨!
        TestObject.name = "김준일";
        System.out.println(TestObject.name);
    }
}

class TestObject {
    static String name;
    int age;

    public TestObject() {
        System.out.println("생성자 호출"); // new로 객체를 만들 때마다 실행
    }

    static {
        System.out.println("스태틱 호출"); // 클래스가 처음 로딩될 때 딱 1번만 실행
    }
}
```

### 3.3 `static` 변수 vs 인스턴스 변수 비교
| 구분 | `static` 변수 (클래스 변수) | 인스턴스 변수 (일반 필드) |
|---|---|---|
| **키워드** | `static` 붙음 | `static` 없음 |
| **메모리 위치** | 메서드 영역 (Method Area) | 힙 영역 (Heap Area) |
| **생성 시점** | 클래스가 처음 메모리에 로딩될 때 | `new`로 객체를 생성할 때마다 |
| **개수** | 프로그램 전체에 **단 1개만** 존재 | 생성된 객체 수만큼 각각 생성됨 |
| **접근 방식** | `클래스명.변수명` (권장) | `참조변수명.변수명` |
| **용도** | 모든 객체가 공유해야 하는 공통 데이터, 누적 카운터, 전역 설정 | 개별 객체마다 달라야 하는 고유한 상태값 |

---

### 3.4 현실 세계 10대 실전 시나리오 분석

강의 소스코드 `ch03`에는 `static`과 객체지향을 체득하기 위한 10개의 강력한 현실 예제가 포함되어 있습니다.

#### ① `StaticBasic` : 학생관리시스템 (학번 자동 채번)
- **핵심:** 올해 연도(`LocalDate.now().getYear()`)와 누적 순번(`번호++`)을 `static`으로 유지하여, 학생이 추가될 때마다 고유한 학번(`20260001`, `20260002`...)을 자동으로 생성합니다.
```java
class 학생관리시스템 {
    static int 년도 = LocalDate.now().getYear(); // 2026
    static int 번호 = 1;

    static 학생 학생추가(String 이름) {
        // 년도 * 10000 + 번호++ => 20260001, 20260002...
        return new 학생(년도 * 10000 + 번호++, 이름);
    }
}
```

#### ② `StaticBank` : 은행과 계좌 (공유 자산 vs 개인 자산)
- **핵심:** 모든 고객의 예금 합계인 `은행.총예금`은 `static` 변수로 은행 전체에서 1개만 관리하고, 각 고객의 `계좌.잔액`은 개별 인스턴스 변수로 관리합니다.
```java
class 계좌 {
    int 잔액; // 개별 고객마다 다른 잔액 (인스턴스 변수)
    void 입금(int 금액) {
        잔액 += 금액;
        은행.총예금 += 금액; // static 총예금에 누적
    }
}
class 은행 {
    static int 다음번호 = 1000;
    static int 총예금; // 은행 전체가 공유하는 단 하나의 총예금
}
```

#### ③ `StaticCafe` : 카페 주문 시스템 (주문번호 자동 발급 & 삼항 연산 가격 책정)
- **핵심:** `static int 번호 = 100`으로 마지막 주문번호를 관리하고, 메뉴가 "라떼"인지 여부에 따라 삼항 연산자로 가격을 차등 부여합니다.
```java
class 주문 {
    int 주문번호;
    String 메뉴;
    int 가격;
    주문(int 주문번호, String 메뉴) {
        this.주문번호 = 주문번호;
        this.메뉴 = 메뉴;
        this.가격 = 메뉴.equals("라떼") ? 5000 : 4500;
    }
}
class 카페 {
    static int 번호 = 100;
    static 주문 주문하기(String 메뉴) {
        return new 주문(++번호, 메뉴); // 101, 102, 103...
    }
}
```

#### ④ `StaticCompany` : 회사와 사원 (사번 규칙 조합)
- **핵심:** `static final String 회사명 = "코라이소프트"`(상수), 입사년도 뒷자리(`26`), 부서가 개발이면 "D", 아니면 "X", 그리고 누적 사원수를 조합하여 사번(`26D1`, `26X2`, `26D3`)을 자동 발급합니다.

#### ⑤ `StaticDelivery` : 택배회사 (운송장 번호 & 조건부 배송료)
- **핵심:** 월/일을 조합한 날짜 코드에 순번을 곱해 유일한 운송장 번호를 생성하고, 무게가 10kg 초과면 6,000원, 이하이면 4,000원을 부과합니다.

#### ⑥ `StaticGame` : 게임 서버 (서버명 일괄 바인딩 & 동시 접속자 수)
- **핵심:** 모든 캐릭터 객체는 생성 시 `게임서버.서버이름`("아시아-7")을 공유받으며, `게임서버.접속자수`가 캐릭터 생성 시마다 1씩 증가합니다. `p1.레벨업()`은 해당 캐릭터만의 인스턴스 상태를 변경합니다.

#### ⑦ `StaticHospital` : 병원 접수 시스템 (대기 인원 증감 카운팅)
- **핵심:** 환자가 접수하면 `static int 대기인원`이 증가하고 번호표가 발급되며, 의사가 `병원.진료(p1)`를 수행하면 해당 환자의 `진료완료 = true`가 되고 `대기인원--`로 차감됩니다.

#### ⑧ `StaticLibrary` : 도서관 (등록번호 발급 & 참조 복사의 원리)
- **핵심:** `도서 b3 = b1;`을 수행했을 때 `b3`는 새로운 도서가 아니라 `b1`과 동일한 힙 메모리 주소를 가리킵니다. 따라서 `b3.대출가능 = false;`로 바꾸면 `b1.대출가능` 역시 `false`로 변경되는 참조 복사의 핵심 원리를 보여줍니다.

#### ⑨ `StaticParking` : 주차장 시스템 (자원 한도 관리 & `null` 반환)
- **핵심:** `static int 남은자리 = 2`로 제한을 두고, 만차가 되면 입차를 거부하고 `null`을 반환합니다. 호출부에서 `null` 체크의 필요성을 학습합니다.

#### ⑩ `StaticTest` : 클래스 로딩 단 1회 증명
- **핵심:** `TestClass.value`를 네 번 연속 출력해도 `static { ... }` 블록의 출력문("테스트 클래스 1")은 오직 처음에 단 한 번만 실행됨을 확인합니다.

---

### 3.5 접근 제어자 4종 (Access Modifiers)
자바에서는 객체 내부의 중요한 데이터를 외부로부터 보호(정보 은닉)하기 위해 접근 범위를 지정할 수 있습니다.

| 접근 제어자 | 같은 클래스 | 같은 패키지 | 자식 클래스(상속) | 전체(외부 패키지) |
|---|:---:|:---:|:---:|:---:|
| **`private`** | **O** | X | X | X |
| **(default)** | **O** | **O** | X | X |
| **`protected`** | **O** | **O** | **O** | X |
| **`public`** | **O** | **O** | **O** | **O** |

> **접근 제어자가 필요한 이유:** 만약 은행 계좌의 `잔액`이 `public`이라면, 해커나 다른 개발자가 실수로 `a.잔액 = -100000;` 처럼 말도 안 되는 값으로 직접 조작할 수 있습니다. 이를 막기 위해 필드는 `private`으로 감추고, 검증된 메서드만을 통해서 접근하도록 해야 합니다.

### 3.6 캡슐화(Encapsulation)와 Getter / Setter
- **Getter:** `private` 필드의 값을 안전하게 **읽어서 돌려주는** 메서드 (규칙: `get` + 필드명 첫 글자 대문자)
- **Setter:** `private` 필드에 전달받은 값을 검증한 후 안전하게 **설정해 주는** 메서드 (규칙: `set` + 필드명 첫 글자 대문자)
```java
class 선생 {
    private String name; // 외부에서 직접 접근 불가!

    // Setter
    void setName(String name) {
        if (name == null || name.trim().isEmpty()) return; // 유효성 검증
        this.name = name;
    }

    // Getter
    String getName() {
        return name;
    }
}
```

### 3.7 내부 클래스(Inner Class)의 생성 문법
클래스 내부에 선언된 인스턴스 멤버 클래스를 외부에서 생성할 때는 반드시 바깥 클래스의 인스턴스가 먼저 존재해야 합니다.
```java
public class AccessMain2 {
    class School { String name; }

    public static void main(String[] args) {
        AccessMain2 am2 = new AccessMain2();
        AccessMain2.School s1 = am2.new School(); // 바깥 객체(am2)를 통해 new 생성!
        s1.name = "부경대";
    }
}
```

### 3.8 3계층 아키텍처 기초 (Package & Layer)
`ch03/access`는 실무 스프링/웹 애플리케이션의 3계층 구조를 엿볼 수 있도록 패키지가 분리되어 있습니다:
- **`entity` 패키지 (`Role.java`):** 데이터베이스 테이블과 매핑되는 핵심 데이터 모델
- **`service` 패키지 (`UserService.java`):** 비즈니스 로직을 처리하는 계층
- **`main` / 실행 패키지 (`AccessMain6.java`):** 사용자의 요청을 받아 전체 흐름을 제어

---

# 4. ch04. 배열(Array)의 구조와 다차원 배열

> **관련 소스 파일:** `ch04/ArrayMain01.java` ~ `ArrayMain04.java`  
> **핵심 키워드:** 배열(Array), 연속된 메모리 공간, 인덱스(0-based Index), `length`, 참조 타입, 객체 배열, 2차원 배열, `Arrays.fill()`, `Arrays.toString()`

### 4.1 배열의 본질과 메모리 할당
**배열(Array)**이란 동일한 자료형의 데이터들을 메모리의 연속된 공간에 순서대로 나열해 놓은 고정 크기의 참조 자료구조입니다.
```java
byte[] a1 = new byte[4];  // 1바이트짜리 방 4개 = 4바이트 연속 할당
short[] a2 = new short[4]; // 2바이트짜리 방 4개 = 8바이트 연속 할당
int[] a4 = new int[4];    // 4바이트짜리 방 4개 = 16바이트 연속 할당

a1 = new byte[5]; // 기존 4칸짜리 배열의 크기가 늘어나는 것이 아니라, 새로운 5칸짜리 배열이 생성되어 주소가 바뀜!
a1 = null;        // 참조를 끊음 -> 기존 배열은 가비지 컬렉터(GC)에 의해 메모리에서 해제됨
```

### 4.2 기본형 배열 vs 객체 배열 (`Student[]`)
```java
class Student {
    String name;
    double[] scores;
}

Student[] students = new Student[4];
```
- `new Student[4]`는 학생 객체 4개를 만드는 것이 아니라, **학생 객체의 주소값을 담을 수 있는 참조 변수(포인터) 4칸**을 만드는 것입니다! (초기값은 모두 `null`)
- 따라서 각 방마다 `new Student()`를 따로 생성해서 대입해 주어야 합니다.
```java
students[0] = new Student();
students[0].name = "김준일";
students[1] = new Student();
students[1].name = "김준이";

Student[] students2 = students; // 배열 참조 복사! 동일한 배열 객체를 가리킴
```

### 4.3 2차원 배열의 선언, 생성, 행(Row) 단위 참조
2차원 배열은 실질적으로 **"배열을 요소로 갖는 배열"** (배열의 배열)입니다.
```java
int[][] nums2 = new int[2][3]; // 2행 3열의 2차원 배열 생성
```
```
nums2 ──▶ [ [0행 주소], [1행 주소] ]
               │            │
               ▼            ▼
          [ 0, 0, 0 ]   [ 0, 0, 0 ]
```
```java
int[] nums3 = nums2[0]; // 0번째 행 배열 자체의 주소를 꺼내옴!
nums3[0] = 100;         // nums2[0][0] 또한 100으로 바뀜!

nums2[0][0] = 10;
nums2[0][1] = 20;
nums2[0][2] = 30;
nums2[1][0] = 40;
nums2[1][1] = 50;
nums2[1][2] = 60;
```

### 4.4 `Arrays.fill()`과 `Arrays.toString()`
- **`Arrays.fill(배열, 값)`:** 배열의 모든 원소를 지정한 값으로 일괄 채워 넣습니다.
  ```java
  int[] nums5 = new int[1000];
  Arrays.fill(nums5, 100); // 1000개 방을 모두 100으로 초기화
  ```
- **`Arrays.toString(배열)`:** 배열의 내용물을 `[1, 2, 3]` 형태의 문자열로 보기 좋게 변환해 줍니다. (단순히 `System.out.println(nums)`를 실행하면 `[I@1b6d3586` 같은 해시코드가 출력됩니다!)

### 4.5 `arrayToString()` 수동 구현 알고리즘 (`ArrayMain04`)
`Arrays.toString()`이 내부적으로 어떻게 동작하는지 직접 구현해 보는 코드입니다:
```java
static String arrayToString(int[] arr) {
    String str = "";
    for (int i = 0; i < arr.length; i++) {
        if (i == 0) str += "[ ";
        str += arr[i] + ", ";
        if (i == arr.length - 1) str += "]";
    }
    return str;
}
```

---

# 5. ch05. 연산자, 제어문, 콘솔 입출력과 실전 데이터 모델링

> **관련 소스 파일:** `ch05/Operator.java`, `ControlMain.java` ~ `ControlMain7.java`, `User.java`, `UserMain.java`, `practice/*`  
> **핵심 키워드:** 논리 연산자, 단락 평가, 삼항 연산자, 윤년 공식, `if-else`, `switch-case`와 Fall-through, 최신 switch 문법, 다중 루프(별 찍기, 구구단), `Scanner`와 버퍼 비우기, `BufferedReader`와 EOF, 동적 배열 크기 확장, 실무 데이터 필터링

### 5.1 연산자의 원리: 논리 연산자와 전기 회로 메커니즘 (`Operator.java`)
컴퓨터의 논리는 전류가 흐르는지(1, True) 흐르지 않는지(0, False)에서 시작합니다.
- **AND 연산 (`&&`, 논리곱):** 모든 조건이 True여야만 True
  - `T && T = T`, `T && F = F`, `F && T = F`, `F && F = F`
- **OR 연산 (`||`, 논리합):** 조건 중 하나라도 True이면 True
  - `T || T = T`, `T || F = T`, `F || T = T`, `F || F = F`
- **NOT 연산 (`!`):** True는 False로, False는 True로 반전

#### 단락 평가 (Short-circuit Evaluation)
`A && B` 연산 시 `A`가 이미 False라면 뒤의 `B`는 실행조차 하지 않고 즉시 False로 판정합니다.  
`A || B` 연산 시 `A`가 이미 True라면 뒤의 `B`는 실행하지 않고 즉시 True로 판정합니다.

### 5.2 삼항 연산자와 윤년 계산 공식, 최댓값 판별
```java
// 1. 삼항 연산자: 조건식 ? 참일 때 값 : 거짓일 때 값
int n = -3;
System.out.println(n % 2 == 0 ? "짝수" : "홀수");

// 2. 4년마다 오고 100년마다는 아니지만 400년마다는 윤년인 공식
boolean isLeapYear = (2026 % 4 == 0 && 2026 % 100 != 0 || 2026 % 400 == 0);

// 3. 세 변수(a, b, c) 중 최댓값 구하기 (가장 깔끔한 알고리즘)
int maxValue = a;
if (maxValue < b) maxValue = b;
if (maxValue < c) maxValue = c;
```

---

### 5.3 조건문과 `switch ~ case`의 본질 (`ControlMain`, `ControlMain2`)

#### `if`문 vs `switch`문의 차이점
- `if`문은 조건식을 위에서부터 차례대로 하나씩 평가하면서 참인 블록을 찾아 실행합니다.
- `switch`문은 변수의 값과 일치하는 `case` 라벨로 **직접 점프**합니다.

#### `break`가 없을 때 발생하는 Fall-through 현상
```java
String 문선택 = "2번문";
switch (문선택) {
    case "1번문": System.out.println("첫번째 버섯");
    case "2번문": System.out.println("두번째 버섯"); // 여기서부터 실행 시작!
    case "3번문": System.out.println("세번째 버섯"); // break가 없어서 밑으로 계속 흘러내림!
        break;                                  // 여기서 비로소 탈출!
    case "4번문": System.out.println("네번째 버섯");
    default:     System.out.println("마지막 버섯");
}
// 출력 결과:
// 두번째 버섯
// 세번째 버섯
```

#### 최신 자바(Java 14+)의 향상된 Switch 식
```java
int score = 42;
String grade = switch (score / 10) {
    case 10, 9 -> "A";
    case 8      -> "B";
    case 7      -> "C";
    default    -> "F";
};
System.out.println(grade); // F
```

---

### 5.4 다중 반복문과 별 찍기 5대 패턴 (`ControlMain3`, `Practice02_01`)

```java
// 패턴 1: 왼쪽 직각삼각형 (5줄)
for (int i = 0; i < 5; i++) {
    for (int j = 0; j < i + 1; j++) {
        System.out.print("*");
    }
    System.out.println();
}

// 패턴 2: 역직각삼각형 (5줄 -> 1줄)
for (int i = 0; i < 5; i++) {
    for (int j = 0; j < 5 - i; j++) {
        System.out.print("*");
    }
    System.out.println();
}

// 패턴 3: 오른쪽 정렬 직각삼각형 (공백 먼저 찍고 별 찍기)
for (int i = 0; i < 5; i++) {
    for (int j = 0; j < 4 - i; j++) {
        System.out.print(" ");
    }
    for (int j = 0; j < 1 + i; j++) {
        System.out.print("*");
    }
    System.out.println();
}
```

---

### 5.5 콘솔 입력(`Scanner`)의 치명적 함정과 해결법 (`Practice02_02`)

```java
Scanner scanner = new Scanner(System.in);
System.out.print("몇명의 이름을 입력하실건가요? ");
int n = scanner.nextInt(); 
scanner.nextLine(); // ★ 매우 중요: 버퍼에 남아있는 엔터(\n)를 소비해서 비워줌!
```
> **왜 `scanner.nextLine()`을 한 번 더 실행해야 하는가?**  
> `scanner.nextInt()`는 숫자만 읽어가고, 사용자가 누른 Enter(`\n`)는 키보드 입력 버퍼에 그대로 남겨둡니다. 그 뒤에 바로 `scanner.nextLine()`을 호출하면 버퍼에 남아있던 `\n`을 읽고 "빈 문자열"이 입력된 것으로 인식하여 첫 번째 입력을 그냥 건너뛰어 버리는 심각한 버그가 발생합니다.

### 5.6 파일 읽기와 EOF(End Of File) 처리 (`ControlMain4`)
```java
FileReader fileReader = new FileReader("input.txt");
BufferedReader bufferedReader = new BufferedReader(fileReader);
StringBuilder stringBuilder = new StringBuilder();
String text = "";
// 한 줄씩 읽다가 더 이상 읽을 데이터가 없으면 readLine()은 null을 반환함 (EOF 체크)
while ((text = bufferedReader.readLine()) != null) {
    stringBuilder.append(text).append("\n");
}
System.out.println(stringBuilder);
```

### 5.7 배열의 크기를 동적으로 늘리는 알고리즘 (`ControlMain6`)
자바의 일반 배열은 한 번 생성하면 길이를 바꿀 수 없습니다. 사용자가 `y`를 누를 때마다 크기가 1씩 커지는 배열을 만드는 실무 알고리즘:
```java
// 1. 기존 배열보다 길이가 1 더 큰 새 배열을 생성
String[] newNames = new String[names.length + 1];

// 2. 기존 배열의 데이터를 새 배열로 복사
for (int i = 0; i < names.length; i++) {
    newNames[i] = names[i];
}

// 3. 새 배열의 마지막 칸에 새 데이터 추가
newNames[newNames.length - 1] = name;

// 4. 참조 변수가 새 배열을 가리키도록 교체
names = newNames;
```

### 5.8 실전 대용량 데이터 필터링 (`User.java`, `UserMain.java`)
30명의 `User` 객체 배열에서 성별이 남성(`"M"`)인 사용자만 추려내어 동적 배열에 저장하고 출력하는 종합 실습:
```java
User[] users = getUsers();
User[] maleUsers = new User[0];

for (int i = 0; i < users.length; i++) {
    if (users[i].gender.equals("M")) {
        User[] newMaleUsers = new User[maleUsers.length + 1];
        for (int j = 0; j < maleUsers.length; j++) {
            newMaleUsers[j] = maleUsers[j];
        }
        newMaleUsers[newMaleUsers.length - 1] = users[i];
        maleUsers = newMaleUsers;
    }
}
```

---

# 6. ch06. 메서드 심화와 생성자 오버로딩

> **관련 소스 파일:** `ch06/Method01.java` ~ `Method03.java`  
> **핵심 키워드:** 정적 메서드 vs 인스턴스 메서드, 메서드 오버로딩(Overloading), JDK `PrintStream` 분석, 생성자 오버로딩, `this`, `toString()` 재정의

### 6.1 정적(`static`) 메서드 vs 인스턴스 메서드
```java
Method0102.run("1");                  // static 메서드는 클래스명으로 바로 호출 가능!
new Method0101().run(new Method0101()); // 인스턴스 메서드는 반드시 new로 객체를 만들어야 호출 가능!
```

### 6.2 메서드 오버로딩 (Method Overloading)
**오버로딩(Overloading)**이란 하나의 클래스 내에 **이름은 같지만 매개변수의 개수, 타입, 순서가 다른 메서드를 여러 개 정의**하는 것을 말합니다.
```java
class Parameter01 {
    static void 세탁하기() { ... }
    static void 세탁하기(int 세제) { ... }
    static void 세탁하기(double 세제) { ... }
    static void 세탁하기(int 세제, int 섬유유연제) { ... }
}
```
- **오버로딩이 필요한 이유:** 우리가 매일 쓰는 `System.out.println()`이 대표적입니다. 만약 오버로딩이 없다면 `printlnInt()`, `printlnString()`, `printlnDouble()` 처럼 타입마다 다른 이름의 메서드를 외워서 써야 했을 것입니다.
- **JDK 내부 코드 분석 (`Method02.java`):**
  ```java
  public void println(String x) { ... }
  public void println(int x) { ... }
  public void println(Object x) { ... }
  ```
- **주의:** 반환 타입(Return Type)만 다르고 매개변수가 동일한 경우는 오버로딩이 성립하지 않습니다! (컴파일 에러)

### 6.3 생성자 오버로딩 (Constructor Overloading, `Method03.java`)
객체를 다양한 초기값 조합으로 유연하게 생성할 수 있도록 생성자 역시 오버로딩할 수 있습니다.
```java
class Student {
    String name;
    int age;
    String address;

    Student() { ... }                             // 1. 기본 생성자 (No-Args)
    Student(String name) { this.name = name; }   // 2. 이름만 받음
    Student(int age) { this.age = age; }         // 3. 나이만 받음
    Student(String name, int age) { ... }         // 4. 이름, 나이 받음
    Student(int age, String address) { ... }      // 5. 나이, 주소 받음 (타입 순서가 다름)
}
```

---

# 7. ch07. 객체지향의 핵심: 상속, 다형성, 추상화, 인터페이스

> **관련 소스 파일:** `ch07/AbstractMain01.java` ~ `AbstractMain06.java`, `Main.java`, `ObjectMain01.java`  
> **핵심 키워드:** 다형성(Polymorphism), `List` 인터페이스(`ArrayList`, `LinkedList`), 상속(`extends`), 오버라이딩(`@Override`), 업캐스팅, 다운캐스팅, `instanceof`, `super` 키워드, 추상 클래스(`abstract`), 인터페이스(`interface`), 동적 바인딩 퍼즐, `Object.toString()`

---

### 7.1 컬렉션 프레임워크와 다형성의 첫걸음 (`AbstractMain01`)
```java
List<String> names = new ArrayList<>();
List<String> names2 = new LinkedList<>();
```
- 좌항은 상위 인터페이스인 `List` 타입으로 선언하고, 우항은 실제 구현체인 `ArrayList`나 `LinkedList` 객체를 생성하여 대입합니다.
- **다형성의 이점:** 나중에 성능 최적화 등을 이유로 `ArrayList`를 `LinkedList`로 바꾸더라도, `List` 인터페이스에 정의된 표준 메서드(`add`, `get`, `size`)를 사용하므로 나머지 코드를 한 줄도 수정할 필요가 없습니다.

---

### 7.2 상속(`extends`)과 메서드 오버라이딩(`@Override`) (`AbstractMain02`, `03`)
- **상속:** 부모 클래스가 가진 필드와 메서드를 자식 클래스가 물려받아 그대로 사용하거나 기능을 확장하는 문법입니다.
- **오버라이딩:** 부모 클래스로부터 물려받은 메서드의 동작을 자식 클래스에서 자신에 맞게 **재정의**하는 것입니다.

```java
class Animal2 {
    void move() { System.out.println("움직인다"); }
}

class Dog2 extends Animal2 {
    @Override // 컴파일러에게 부모 메서드를 정확히 재정의했는지 검증 요청하는 애너테이션
    void move() { System.out.println("많이움직인다"); } // 재정의!
    void bark() { System.out.println("짖다"); }
}

class Tiger2 extends Animal2 {
    void hunt() { System.out.println("사냥하다"); }
}
```

---

### 7.3 업캐스팅과 다운캐스팅, 그리고 `instanceof` (`AbstractMain04`)

```
               [ Animal3 (부모) ]
                  ▲        ▲
       (업캐스팅) │        │ (업캐스팅)
                  │        │
           [ Dog3 ]        [ Tiger3 ]
```

#### 1. 업캐스팅 (Upcasting)
- 자식 객체를 부모 타입의 참조 변수에 담는 것 (자동 형변환 지원).
- `Animal3 animal1 = new Dog3();`
- **특징:** 부모 타입으로 변환되면 부모에게 선언되어 있는 메서드(`move()`)만 호출할 수 있고, 자식 고유의 메서드(`bark()`)는 보이지 않게 가려집니다. 단, 재정의된 메서드는 자식의 것이 실행됩니다! (동적 바인딩)

#### 2. 다운캐스팅 (Downcasting)
- 부모 타입에 담겨 있던 객체를 다시 원래의 자식 타입으로 되돌리는 것 (명시적 형변환 필수).
- `Dog3 d = (Dog3) animal1; d.bark();`

#### 3. 잘못된 다운캐스팅과 `instanceof`
```java
Animal3 animal2 = new Tiger3();
// Dog3 dog = (Dog3) animal2; // 문법 에러는 안 나지만, 실행 시 ClassCastException 예외 발생!

// 안전한 다운캐스팅을 위해 반드시 instanceof로 실체를 확인해야 함!
if (animal2 instanceof Dog3) {
    Dog3 d = (Dog3) animal2;
    d.bark();
} else if (animal2 instanceof Tiger3) {
    Tiger3 t = (Tiger3) animal2;
    t.hunt();
}
```

---

### 7.4 생성자 호출 순서와 `super` 키워드 (`AbstractMain05`)
자식 객체를 생성하면, JVM은 **부모 클래스의 생성자(`super()`)를 먼저 호출**하여 부모 부분부터 메모리에 만들고 난 뒤 자식 생성자를 실행합니다.

```java
class Phone {
    String phoneNumber;
    Phone() { System.out.println("Phone 생성자 호출"); }
    void call() { System.out.println("전화를 건다."); }
}

class SmartPhone extends Phone {
    SmartPhone() {
        // super(); 가 첫 줄에 컴파일러에 의해 자동으로 들어감!
        System.out.println("SmartPhone 생성자 호출");
    }
    public void call() {
        System.out.println("전화 어플에 들어가서 전화를 건다.");
        super.call(); // 부모의 call() 메서드도 함께 실행!
    }
}
```

#### 필드 은닉 (Shadowing)과 `super.필드`
부모와 자식에 동일한 이름의 필드(`phoneNumber`)가 있을 때:
- `this.phoneNumber`: 자식 클래스 자신의 필드를 가리킴
- `super.phoneNumber`: 부모 클래스로부터 물려받은 필드를 가리킴

---

### 7.5 추상 클래스(`abstract`)와 인터페이스(`interface`) (`AbstractMain06`)

```java
interface Sensor {
    void send(); // public abstract 생략됨 (순수 규격)
    void on();
    void off();
    default void send2() { ... } // Java 8+: 기본 구현을 제공하는 default 메서드
}

abstract class RemoteControl implements Sensor {
    String modelName;
    void showModelName() { System.out.println(modelName); } // 일반 메서드 가능
    abstract void powerOn(); // 추상 메서드: 자식이 반드시 구현해야 함!
}
```

| 구분 | 추상 클래스 (`abstract class`) | 인터페이스 (`interface`) |
|---|---|---|
| **키워드** | `abstract class`, 상속은 `extends` | `interface`, 구현은 `implements` |
| **다중 상속** | 불가능 (단일 상속만 지원) | 가능 (여러 인터페이스 동시 구현 가능) |
| **목적** | 관련성이 높은 클래스들의 공통 상태/기능 확장 | 서로 다른 클래스들에 표준 규격(스펙) 제공 |
| **인스턴스 생성** | `new RemoteControl()` 불가! | `new Sensor()` 불가! |

---

### 7.6 상속 실행 순서와 동적 바인딩 심화 퍼즐 (`Main.java`)

```java
public class Main {
    public static void main(String[] args) {
        new Child();
        System.out.println(Parent.total);
    }
}

class Parent {
    static int total = 0;
    int v = 1;
    public Parent() {
        total += (++v); // v가 2가 됨. total = 2
        show();         // ★ 핵심 함정: 자식이 show()를 오버라이딩했으므로 자식의 show()가 호출됨!
    }
    public void show() { total += total; }
}

class Child extends Parent {
    int v = 10;
    public Child() {
        total += v++; // 부모 생성자 끝난 뒤 실행. total = 6 + 10 = 16 (v는 11이 됨)
        show();       // total = 16 + (16 * 2) = 48
    }
    @Override
    public void show() {
        total += total * 2;
    }
}
```
- **실행 단계별 분석:**
  1. `new Child()` 실행 시작 -> 먼저 부모 `Parent` 생성자 진입
  2. `total += (++v)`: `Parent.v`가 2가 되고, `total`은 2가 됨.
  3. `Parent` 생성자 안에서 `show()` 호출: 현재 생성 중인 실제 인스턴스는 `Child`이므로, **동적 바인딩에 의해 `Child`의 오버라이딩된 `show()`가 실행됨!**
  4. `Child`의 `show()`: `total += total * 2` -> `total`은 $2 + (2 \times 2) = 6$이 됨.
  5. `Parent` 생성자 종료 후 `Child` 생성자 실행: `total += v++` -> `Child.v`인 10이 더해져 `total`은 $6 + 10 = 16$이 됨.
  6. `Child` 생성자에서 `show()` 호출: `total += total * 2` -> $16 + (16 \times 2) = 48$이 됨.
  7. 최종 출력값: **`48`**

---

### 7.7 생성자 설계 패턴과 `Object` 클래스 (`ObjectMain01.java`)
- **`final` 필드의 필수 초기화:** `final int code; final String name;` 처럼 선언된 필드는 생성자가 종료되기 전까지 반드시 초기화되어야 합니다.
- **생성자 설계 패턴:**
  - `NoArgsConstructor`: 매개변수가 없는 기본 생성자
  - `RequiredArgsConstructor`: `final` 필드 등 필수 인자만 받는 생성자
  - `AllArgsConstructor`: 모든 필드값을 전달받아 초기화하는 생성자
- **`toString()` 재정의:** `Object`의 기본 `toString()`은 `클래스명@해시코드`를 반환하므로, 객체의 필드 상태를 한눈에 디버깅하기 위해 오버라이딩합니다.

---

## 🎯 학습 점검 퀴즈 & 자가 진단 (Self Test)

1. **[ch01]** `Student3<int>`처럼 제네릭 타입에 기본형 `int`를 넣을 수 없는 이유와 올바른 대안은 무엇인가요?
   *(정답: 제네릭은 참조형(`Object`) 기반으로 동작하므로 기본형을 쓸 수 없으며, 래퍼 클래스인 `Integer`를 사용해야 합니다.)*
2. **[ch02]** 메서드에서 여러 개의 값을 한 번에 반환(`return`)하고 싶을 때 자바에서 사용하는 방법은?
   *(정답: 배열(`int[]`)이나 객체(클래스 인스턴스)로 묶어서 반환합니다.)*
3. **[ch03]** `static` 변수가 저장되는 JVM 메모리 영역과, `static { ... }` 블록이 실행되는 정확한 시점은 언제인가요?
   *(정답: 메서드 영역(Method Area)에 저장되며, 해당 클래스가 코드에서 최초로 참조(로딩)되는 순간 단 1회 실행됩니다.)*
4. **[ch04]** `int[][] arr = new int[2][3];`에서 `arr[0]`이 가리키는 것은 무엇인가요?
   *(정답: 0번째 행에 해당하는 크기 3짜리 1차원 정수 배열(`int[]`)의 힙 메모리 주소값입니다.)*
5. **[ch05]** `Scanner.nextInt()` 바로 뒤에 `Scanner.nextLine()`을 호출할 때 첫 번째 입력이 무시되는 원인과 해결책은?
   *(정답: `nextInt()`가 버퍼에 남긴 줄바꿈 개행문자(`\n`) 때문이며, 사이에 `scanner.nextLine()`을 한 줄 추가하여 버퍼를 비워주어야 합니다.)*
6. **[ch06]** 메서드 오버로딩(Overloading)의 필수 성립 조건 3가지는 무엇인가요?
   *(정답: 메서드 이름이 같아야 하고, 매개변수의 ① 개수, ② 타입, ③ 순서 중 적어도 하나가 달라야 합니다. 반환 타입만 다른 것은 불가능합니다.)*
7. **[ch07]** 부모 타입으로 선언된 변수에 담긴 자식 객체의 고유 메서드를 호출하기 위해 필요한 작업과, 런타임 에러(`ClassCastException`)를 막기 위한 키워드는?
   *(정답: 다운캐스팅(Downcasting)이 필요하며, 안전한 검증을 위해 `instanceof` 연산자를 사용합니다.)*
