# ☕ Java Ch07: 객체지향 추상화 & 컬렉션 List 핵심 정리 노트

> 학습 일자: 2026. 10. 02  
> 학습 코드 위치: `com.korai.ch07`

---

## 📌 한눈에 보는 핵심 맵

| 주제 | 핵심 키워드 | 관련 실습 파일 |
| :--- | :--- | :--- |
| **생성자 & final** | `final`, 생성자 오버로딩, `NoArgs`, `RequiredArgs`, `AllArgs` | [`ObjectMain01.java`](./ObjectMain01.java) |
| **List 컬렉션 기초** | `List<E>`, `ArrayList`, `LinkedList`, 중첩 리스트(`List<List<E>>`) | [`AbstractMain01.java`](./AbstractMain01.java) |
| **추상 클래스 & 업캐스팅** | `abstract class`, `extends`, 업캐스팅(다형성) | [`AbstractMain02.java`](./AbstractMain02.java) |
| **오버라이딩 & 다형성 리스트** | `@Override`, 동적 바인딩, `List<부모타입>` 컬렉션 | [`AbstractMain03.java`](./AbstractMain03.java) |
| **다운캐스팅 & instanceof** | 다운캐스팅, `ClassCastException`, `instanceof` 타입 검사 | [`AbstractMain04.java`](./AbstractMain04.java) |
| **상속 생성자 순서 & super** | 부모 생성자 선행 호출, `super()`, `super.필드`, `super.메서드()` | [`AbstractMain05.java`](./AbstractMain05.java) |
| **인터페이스 & 순회 반복문** | `interface`, `default` 메서드, `implements`, `List.of()`, 향상된 for문 | [`AbstractMain06.java`](./AbstractMain06.java) |

---

## 1. 생성자(Constructor)와 `final` 키워드

### 핵심 요약
1. **`final` 필드**: 값이 한 번 정해지면 변경 불가(불변). **선언 시점** 또는 **모든 생성자**에서 반드시 초기화되어야 함.
2. **생성자 오버로딩 (Overloading)**:
   * **기본 생성자 (No-Args)**: 매개변수 없음
   * **필수 생성자 (Required-Args)**: `final` 등 필수 필드만 매개변수로 받음
   * **전체 생성자 (All-Args)**: 모든 필드를 매개변수로 받음

```java
class Student {
    final int code;       // [필수] 생성 시 반드시 값 할당
    final String name;    // [필수]
    String address;       // [선택]

    // 1. 필수 생성자
    public Student(int code, String name) {
        this.code = code;
        this.name = name;
    }

    // 2. 전체 생성자 (선택적 필드까지 처리)
    public Student(int code, String name, String address) {
        this(code, name); // 기존 필수 생성자 재사용
        this.address = address;
    }
}
```

---

## 2. 상속(Inheritance)과 `super` 키워드

### 핵심 요약
1. **인스턴스 생성 순서**: `자식 객체 생성` $\rightarrow$ **부모 클래스 생성자가 먼저 실행**된 후 자식 생성자 실행
2. **`super` 용법**:
   * `super()` : 부모의 생성자 호출 (첫 줄에 위치, 미작성 시 `super()` 자동 삽입)
   * `super.메서드()` : 오버라이딩되기 전 부모 메서드 호출
   * `super.필드명` : 부모 클래스의 변수 접근 (이름 충돌 시 구분)

```java
class Phone {
    String phoneNumber;
    Phone() { System.out.println("1. Phone 부모 생성자"); }
    void call() { System.out.println("전화 거는 중..."); }
}

class SmartPhone extends Phone {
    SmartPhone() {
        super(); // 부모 생성자 호출 (생략 가능)
        System.out.println("2. SmartPhone 자식 생성자");
    }

    @Override
    void call() {
        super.call(); // 부모의 기존 동작 수행
        System.out.println("스마트폰 앱 화면 띄우기"); // 추가 동작
    }
}
```

---

## 3. 다형성(Polymorphism): 업캐스팅 & 다운캐스팅

### 핵심 비교

```
        ┌─────────────┐
        │   Animal    │  (부모 / 공통 인터페이스)
        └──────┬──────┘
               │  ▲ 
  업캐스팅     │  │  다운캐스팅
(자연스러운 변환)│  │ (명시적 캐스팅 + instanceof 필수)
               ▼  │
        ┌─────────────┐
        │     Dog     │  (자식 / 고유 기능 확장)
        └─────────────┘
```

1. **업캐스팅 (자식 $\rightarrow$ 부모)**:
   * 자동 형변환: `Animal animal = new Dog();`
   * **오버라이딩된 메서드**는 부모 타입 변수로 불러도 **실제 자식 객체의 메서드가 실행(동적 바인딩)**됨.
2. **다운캐스팅 (부모 $\rightarrow$ 자식)**:
   * 강제 형변환: `Dog dog = (Dog) animal;`
   * 실제 객체가 해당 타입이 아니면 `ClassCastException` 발생.
3. **`instanceof` 안전장치**:
   ```java
   if (animal instanceof Dog) {
       Dog d = (Dog) animal;
       d.bark(); // Dog만의 고유 메서드 호출
   }
   ```

---

## 4. 추상화: 추상 클래스 vs 인터페이스

| 구분 | 추상 클래스 (`abstract class`) | 인터페이스 (`interface`) |
| :--- | :--- | :--- |
| **목적** | 관련성이 깊은 하위 클래스들의 공통 속성/기능 상속 및 확장 | 역할 및 규격 정의, 클래스 간 결합도 완화, 다중 구현 |
| **키워드** | `extends` (단일 상속) | `implements` (다중 구현 가능) |
| **추상 메서드** | `abstract void powerOn();` | `void on();` (기본 public abstract) |
| **일반 구현 메서드** | 자유롭게 일반 메서드 작성 가능 | Java 8부터 `default void send2() { ... }` 지원 |
| **객체 직접 생성** | ❌ 불가 (`new` 불가) | ❌ 불가 (`new` 불가) |

---

## 5. 자바 컬렉션: `List` 완전 정복

### 1) `ArrayList` vs `LinkedList`
* `ArrayList`: 내부가 **배열** 기반. 인덱스 검색(`get`) 속도가 매우 빠름 ($O(1)$).
* `LinkedList`: 각 요소가 **노드 링크**로 연결. 중간 데이터 삽입/삭제가 빈번할 때 유리.

### 2) 배열 vs 리스트 크기 확인
* 배열: `arr.length` (속성/필드)
* 리스트: `list.size()` (메서드)

### 3) 2차원 리스트 (`List<List<String>>`)
```java
List<List<String>> list2D = new ArrayList<>();
list2D.add(new ArrayList<>());
list2D.get(0).add("강민재");
System.out.println(list2D.get(0).get(0)); // "강민재"
```

### 4) 리스트 순회 2가지 방법
```java
List<RemoteControl> list = List.of(new TvRemoteControl(), new MonitoremoteControl());

// 방법 1: 일반 인덱스 for문 (인덱스가 필요할 때)
for (int i = 0; i < list.size(); i++) {
    list.get(i).powerOn();
}

// 방법 2: 향상된 for문 (for-each, 전체 순회 시 권장)
for (RemoteControl r : list) {
    r.powerOn();
}
```

---

## 📝 셀프 테스트 연습문제

### [Quiz 1] 다음 실행 코드의 출력 결과는?
```java
class A {
    A() { System.out.print("1"); }
}
class B extends A {
    B() { System.out.print("2"); }
}
public class Main {
    public static void main(String[] args) {
        B b = new B();
    }
}
```
> **정답**: `12` (부모 생성자가 먼저 호출된 후 자식 생성자가 호출됨)

---

### [Quiz 2] 런타임 에러(`ClassCastException`)가 발생하는 코드는?
```java
Animal a = new Dog();

// 1번
if (a instanceof Dog) {
    Dog d = (Dog) a;
}

// 2번
Cat c = (Cat) a;
```
> **정답**: `2번` (`a`는 실제 `Dog` 객체를 가리키고 있으므로 `Cat`으로 형변환할 수 없습니다.)

---

### [Quiz 3] 불변 리스트의 특징
```java
List<String> list = List.of("사과", "바나나");
list.add("포도"); // 여기서 발생하는 결과는?
```
> **정답**: `UnsupportedOperationException` 에러 발생 (`List.of()`로 만든 리스트는 수정/추가가 불가능한 불변 리스트)

---

## 💻 생성된 실습 연습문제 파일 목록

직접 실행하며 복습할 수 있도록 `com.korai.ch07` 패키지에 다음 4개의 완성형 연습문제 파일을 준비했습니다:

| 파일명 | 주제 | 다루는 핵심 개념 |
| :--- | :--- | :--- |
| [`Practice01.java`](./Practice01.java) | **탈것(Vehicle) 다형성 관리** | 추상 클래스, `super()`, `List<부모>`, `instanceof`, 다운캐스팅 |
| [`Practice02.java`](./Practice02.java) | **결제(Payment) 시스템** | `interface`, `default` 메서드, `List.of()`, 카드 할부 다운캐스팅 |
| [`Practice03.java`](./Practice03.java) | **직원(Employee) 급여 관리** | `final` 불변 필드, 생성자 위임, 추상 메서드, 총 급여 누적 합산 |
| [`Practice04.java`](./Practice04.java) | **2차원 마켓 카테고리 관리** | `List<List<String>>`, `ArrayList` vs `LinkedList`, 이중 for문, `get(i).get(j)` |

