# ☕ Korea-AI-Academy-11-Java

대한민국인공지능아카데미 11기 **Java 기초 및 객체지향 프로그래밍(OOP)** 학습 및 실습 레포지토리입니다.  
기본적인 자바 문법부터 JVM 내부 아키텍처, 객체지향 설계 핵심 원칙(캡슐화, 상속, 다형성, 추상화, SOLID) 및 자바 컬렉션 프레임워크(`List`)를 체계적으로 실습하고, 실무 관점의 깊이 있는 컴퓨터 과학(CS) 지식을 함께 기록합니다.

---

## 🛠 Tech Stack & Environment

| 항목 | 내용 |
| :--- | :--- |
| **Language** | Java 21 (LTS) |
| **Build Tool** | Apache Maven 3.9+ |
| **IDE** | IntelliJ IDEA Ultimate |
| **OS** | macOS |

---

## 📁 Repository Structure

```text
Korea-AI-Academy-11-Java/
├── pom.xml                               # Maven 프로젝트 설정 파일 (Java 21)
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── ch03/                     # JVM 메모리 구조 및 접근 제어자 실습
│   │   │   │   ├── access/               # 캡슐화(private, getter/setter) 및 패키지 은닉
│   │   │   │   ├── MethodArea.java       # 클래스 로딩 및 Static 동작 이해
│   │   │   │   └── StaticBasic.java      # 인스턴스 vs 클래스 멤버 메모리 실습
│   │   │   ├── com/korai/
│   │   │   │   ├── ch01/                 # 자바 기초 입출력, 배열 기초, toString()
│   │   │   │   ├── ch04/                 # 배열 심화 (1차원/2차원 배열, 메모리 참조)
│   │   │   │   ├── ch05/                 # 제어문(if, for, while, break, continue) 및 연산자
│   │   │   │   │   └── practice/         # 조건문/반복문 응용 실습 (구구단, 다차원 배열)
│   │   │   │   ├── ch06/                 # 메서드(인스턴스/스태틱), 오버로딩, 생성자 기초
│   │   │   │   ├── ch07/                 # 객체지향 심화: 추상화, 다형성, 인터페이스, List
│   │   │   │   │   ├── AbstractMain01~06.java # 컬렉션 List, 추상 클래스, 다형성, super, 인터페이스
│   │   │   │   │   ├── Practice01~04.java     # 다형성 응용 종합 실습 (탈것, 결제, 급여, 2차원 리스트)
│   │   │   │   │   └── README.md             # Ch07 핵심 정리 노트 & 셀프 테스트
│   │   │   │   └── study/                # JVM 메모리 구조 및 함수 개념 탐구
│   │   └── resources/
│   └── test/                             # 단위 테스트 디렉토리
└── README.md                             # 메인 프로젝트 문서 (실습 + AI 기술 심화 가이드)
```

---

## 📚 Key Topics & Curriculum

### 1. 자바 기본 문법 및 제어문 (Basic Syntax & Control Flow)
- **콘솔 입출력**: `Scanner`를 활용한 표준 입력 처리 및 버퍼 개행 문자 처리
- **연산자**: 단락 평가(Short-circuit Evaluation)를 고려한 논리 연산자(`&&`, `||`), 증감 연산자, 삼항 연산자
- **조건문**: `if`, `else if`, `else`, 단일 행 블록 중괄호 생략 규칙
- **반복문**: `for`, `while`, `do-while`, 루프 제어(`break`, `continue`), 다중 중첩 루프 레이블링

### 2. 배열 (Arrays & Multi-dimensional Arrays)
- **1차원 배열**: 힙(Heap) 메모리 연속 할당, 기본값 초기화 규칙, 인덱싱 및 순회
- **다차원 배열**: 가변 배열(Ragged Array) 개념, 참조의 참조를 통한 2차원/3차원 배열 데이터 모델링
- **동적 배열 확장**: 고정 크기 배열의 한계를 극복하기 위한 `System.arraycopy()` 및 새 배열 생성/복사 메커니즘

### 3. 객체 지향 프로그래밍 (Object-Oriented Programming)
- **클래스와 인스턴스**: 객체의 상태(Field)와 행위(Method) 모델링, 힙 메모리 인스턴스화
- **생성자 (Constructor) & `final`**: 
  - 기본 생성자(No-args), 필수 생성자(Required-args), 전체 생성자(All-args)
  - `this()` 생성자 체이닝을 통한 코드 중복 제거
  - `final` 불변 필드 초기화 보장 규칙
- **메서드 (Method)**: 인스턴스 메서드 vs 정적(`static`) 메서드, 시그니처 기반 메서드 오버로딩(Overloading)
- **캡슐화 (Encapsulation)**: 접근 제어자(`private`, `default`, `protected`, `public`)를 통한 데이터 은닉과 접근자/설정자(`getter`/`setter`)
- **상속 (Inheritance) & `super`**: 
  - `extends`를 통한 단일 상속 구조
  - 자식 객체 생성 시 부모 생성자 선행 호출 원리 및 `super()`, `super.` 멤버 참조
- **다형성 (Polymorphism)**:
  - **업캐스팅 (Upcasting)**: 부모 타입으로 자식 객체 참조, 동적 바인딩(Dynamic Binding)을 통한 다형적 메서드 실행
  - **다운캐스팅 (Downcasting)**: 명시적 형변환 및 `ClassCastException` 방지를 위한 `instanceof` 타입 검증
- **추상화 (Abstraction)**:
  - **추상 클래스 (`abstract class`)**: 공통 상태/기능 상속 및 하위 클래스 구현 강제화
  - **인터페이스 (`interface`)**: 다중 구현(`implements`), 결합도 완화(Decoupling), Java 8 `default` / `static` 메서드 활용

### 4. 자바 컬렉션 프레임워크 (Collections Framework)
- **`List<E>` 인터페이스**: 순서 보장, 중복 허용, 동적 크기 조절
- **`ArrayList` vs `LinkedList`**: 배열 기반 인덱스 접근($O(1)$) vs 노드 참조 기반 삽입/삭제 구조 비교
- **불변 리스트**: `List.of()`를 활용한 읽기 전용 불변 컬렉션 안전성 확보
- **다차원 컬렉션**: `List<List<E>>` 중첩 리스트를 통한 가변 다차원 데이터 구조 설계

---

## 💻 Practice Highlights

| 실습 파일 | 핵심 개념 | 상세 구현 내용 |
| :--- | :--- | :--- |
| `com.korai.ch01.ArrayTest03` | 배열 & 입출력 | 1차원 `boolean` 배열과 `Scanner`를 결합한 콘솔 좌석 예약/취소 시스템 |
| `com.korai.ch05.practice.Practice02_01` | 다차원 배열 | 3차원 배열(`int[8][9][3]`)을 활용한 구구단 결과 데이터 저장 및 서식화 출력 |
| `com.korai.ch05.UserMain` | 객체 배열 & 필터링 | `User` 객체 배열 순회 및 특정 조건(나이, 권한)에 부합하는 엔티티 검색 |
| `com.korai.ch05.ControlMain6` | 동적 배열 관리 | 고정 배열 한계 도달 시 2배 크기로 재할당하고 데이터를 이전하는 Vector 구현 원리 |
| `com.korai.ch06.Method02` | 메서드 오버로딩 | 파라미터 타입/개수에 따른 다중 메서드 정의 및 컴파일 타임 바인딩 실습 |
| `ch03.access.AccessMain` | 캡슐화 & 패키지 은닉 | 패키지 분리 환경에서 `public` vs `private` 접근 제한과 무결성 보호 |
| `com.korai.ch07.AbstractMain04` | 다형성 다운캐스팅 | `instanceof` 패턴 검사를 통해 런타임 캐스팅 오류(`ClassCastException`) 방지 |
| `com.korai.ch07.AbstractMain06` | 인터페이스 다형성 | `interface` 규격 선언과 `List.of()` 기반의 다형적 객체 일괄 순회 제어 |
| `com.korai.ch07.Practice01` | 추상 클래스 컬렉션 | `Vehicle` 추상 클래스를 상속받은 하위 인스턴스들의 일괄 운행 및 다운캐스팅 |
| `com.korai.ch07.Practice02` | 인터페이스 & default | 결제 인터페이스의 `default` 영수증 발급 기능 및 신용카드 무이자 할부 다운캐스팅 |
| `com.korai.ch07.Practice03` | 불변성 & 생성자 위임 | `final` 필드, 생성자 체이닝(`this()`), 추상 메서드를 통한 다형적 급여 정산 |
| `com.korai.ch07.Practice04` | 2차원 리스트 응용 | `List<List<String>>` 중첩 리스트 구조를 이용한 마켓 카테고리/상품 동적 관리 |

> 💡 **패키지 전용 상세 학습 노트**: [👉 Ch07 객체지향 추상화 & 컬렉션 List 핵심 정리 노트 바로가기](src/main/java/com/korai/ch07/README.md)

---

## 🧠 AI Deep Dive: 컴퓨터 과학(CS) & 엔지니어링 심화 분석

### 1. JVM 런타임 메모리 구조 (JVM Runtime Data Area Deep Dive)

JVM은 OS로부터 메모리를 할당받아 다음과 같이 5가지 영역으로 나누어 관리합니다:

```text
+-------------------------------------------------------------------------------+
|                             JVM Runtime Data Area                             |
+------------------------------------+------------------------------------------+
|       모든 스레드가 공유하는 영역     |              각 스레드마다 독립 생성      |
+------------------+-----------------+------------------+-----------+-----------+
|   Method Area    |    Heap Area    |    JVM Stacks    | PC Regs   | Native St.|
| (Metaspace /     | (Young / Old,   | (Stack Frames,   | (현재 실행 | (JNI 호출 |
|  Static, Class)  |  String Pool)   |  Local Variables)|  명령 주소)|  C/C++용) |
+------------------+-----------------+------------------+-----------+-----------+
```

1. **Method Area (Java 8+ Metaspace)**
   - 클래스 로더가 컴파일된 바이트코드(`.class`)를 읽어 클래스 메타데이터, `static` 변수, 메서드 코드, 런타임 상수 풀(Runtime Constant Pool)을 보관합니다.
   - Java 7까지는 고정 크기 JVM Heap의 `PermGen`에 있었으나, 메모리 고갈(`OutOfMemoryError: PermGen space`) 문제를 해결하기 위해 Java 8부터 Native Memory를 사용하는 **`Metaspace`**로 이관되었습니다.
2. **Heap Area**
   - `new` 키워드로 생성된 모든 인스턴스와 배열이 위치합니다.
   - 가비지 컬렉터(Garbage Collector, GC)의 주요 관리 대상이며, 객체 수명 주기에 따라 **Young Generation (Eden, S0, S1)**과 **Old Generation**으로 분할되어 Minor GC와 Major GC가 수행됩니다.
3. **JVM Stacks**
   - 각 스레드가 실행될 때마다 메서드 호출 시 **스택 프레임(Stack Frame)**이 푸시되고 종료 시 팝됩니다.
   - 스택 프레임 내부에는 **지역 변수 배열(Local Variable Table)**, **피연산자 스택(Operand Stack)**, **프레임 데이터(Frame Data)**가 포함됩니다.
   - 원시 타입(Primitive) 변수는 실제 값이 스택에 직접 저장되며, 참조 타입(Reference) 변수는 힙 영역의 메모리 주소값(Reference ID)만 스택에 저장됩니다.

---

### 2. Java의 파라미터 전달 방식: Pass-by-Value의 본질

Java는 **오직 값에 의한 전달(Strictly Pass-by-Value)**만을 지원합니다. 흔히 "객체를 넘기면 참조에 의한 전달(Pass-by-Reference)이다"라고 오해하지만, 내부 동작은 다음과 같습니다:

```java
public void modify(User u) {
    u = new User("새로운유저"); // 호출자의 원본 참조 변수는 절대 바뀌지 않음!
}

public void changeName(User u) {
    u.setName("이름변경");       // 복사된 주소값이 가리키는 힙 메모리의 상태를 변경하는 것
}
```

* **원시 타입 전달 시**: 값 자체가 복사되어 전달됩니다.
* **객체(참조 타입) 전달 시**: 객체 자체가 아니라 **"객체를 가리키는 32비트/64비트 메모리 주소값(Pointer)"이 값으로서 복사**되어 전달됩니다.

---

### 3. 다형성(Polymorphism)의 내부 메커니즘: 동적 바인딩과 vtable

부모 타입 변수로 자식의 오버라이딩 메서드를 호출할 때 올바른 자식 메서드가 실행되는 원리는 **동적 바인딩(Dynamic Binding)**에 있습니다.

```text
Animal a = new Dog();
a.cry(); // 컴파일 타임에는 Animal.cry()로 검사되지만, 런타임에는 Dog.cry()가 호출됨!
```

* **컴파일 타임**: javac 컴파일러는 `Animal` 클래스에 `cry()`가 존재하는지만 검증하고 `invokevirtual` 바이트코드를 생성합니다.
* **런타임**: JVM은 객체의 메모리 헤더에 있는 클래스 메타정보를 확인하고, 해당 클래스의 **가상 메서드 테이블(Virtual Method Table, vtable)**에서 실제 오버라이딩된 `Dog.cry()`의 주소를 조회하여 실행합니다.

---

### 4. 컬렉션 프레임워크 딥다이브: `ArrayList` vs `LinkedList`

| 비교 항목 | `ArrayList` | `LinkedList` |
| :--- | :--- | :--- |
| **내부 자료구조** | 연속된 메모리 배열 (`Object[] elementData`) | 양방향 연결 노드 (`Node<E>`: item, next, prev) |
| **임의 조회 (`get(i)`)** | **$O(1)$** (인덱스 즉시 계산: `base + i * size`) | **$O(N)$** (첫 노드 또는 끝 노드부터 링크 추적) |
| **끝 삽입 (`add()`)** | $O(1)$ (배열 확장 시 $O(N)$ 발생) | $O(1)$ |
| **중간 삽입/삭제** | $O(N)$ (이후 요소들의 메모리 블록 이동 발생) | $O(1)$ (단, 해당 위치를 찾는 탐색 비용 $O(N)$ 소요) |
| **CPU 캐시 효율** | **압도적 우수** (Spatial Locality, 메모리 연속) | **열악** (노드가 힙에 분산되어 Cache Miss 빈발) |
| **메모리 오버헤드** | 적음 (남은 여유 capacity 공간만 존재) | 큼 (각 노드마다 이전/다음 참조 포인터 추가 소모) |

> 📌 **실무 Best Practice**: 특별히 앞/중간 위치에서 잦은 삽입/삭제가 지속해서 일어나는 큐/덱 구조가 아니라면, **현대 컴퓨터 아키텍처의 CPU 캐시 지역성(Cache Locality) 덕분에 거의 모든 상황에서 `ArrayList`가 `LinkedList`보다 압도적으로 빠르고 효율적**입니다.

---

### 5. 불변 컬렉션 비교: `List.of()` vs `Arrays.asList()`

| 특징 | `List.of(...)` (Java 9+) | `Arrays.asList(...)` (Java 1.2+) |
| :--- | :--- | :--- |
| **불변성 여부** | **완전 불변 (Immutable)** | 크기만 고정 (Fixed-Size) |
| **원소 수정 (`set()`)** | ❌ 불가 (`UnsupportedOperationException`) | ⭕ **가능** (수정 시 원본 배열도 함께 변경됨) |
| **원소 추가/삭제** | ❌ 불가 (`UnsupportedOperationException`) | ❌ 불가 (`UnsupportedOperationException`) |
| **`null` 허용 여부** | ❌ **불허** (`NullPointerException` 발생) | ⭕ 허용 |
| **내부 구현** | 최적화된 소형 불변 클래스 (`ImmutableCollections`) | `java.util.Arrays$ArrayList` 래퍼 |

---

### 6. 객체지향 5대 원칙 (SOLID)과 본 실습의 연계

1. **SRP (단일 책임 원칙, Single Responsibility Principle)**
   * `UserService`는 회원 비즈니스 로직만, `User` 엔티티는 데이터 상태만 담당하여 변경의 이유를 단 하나로 유지.
2. **OCP (개방-폐쇄 원칙, Open-Closed Principle)**
   * `Payment` 인터페이스 또는 `Vehicle` 추상 클래스를 상속받아 새로운 결제 수단(카카오페이, 네이버페이)이나 이동 수단을 추가할 때, 기존 실행 루프 코드는 전혀 수정할 필요 없이 확장 가능.
3. **LSP (리스코프 치환 원칙, Liskov Substitution Principle)**
   * `Animal` 타입이 필요한 모든 자리에 `Dog`나 `Cat`을 대체 투입해도 프로그램의 계약 조건이 깨지지 않고 정상 동작.
4. **ISP (인터페이스 분리 원칙, Interface Segregation Principle)**
   * 하나의 거대한 만능 인터페이스 대신, 목적에 맞는 인터페이스(`RemoteControl`)를 정의하여 불필요한 메서드 구현 강제를 방지.
5. **DIP (의존 역전 원칙, Dependency Inversion Principle)**
   * 고수준 모듈(클라이언트 코드)이 구체 클래스(`TvRemoteControl`)에 직접 의존하지 않고 상위 추상화 인터페이스(`RemoteControl`)에 의존하도록 설계.

---

## 🎯 기술 면접 단골 질문 & 핵심 답변 (Interview Q&A)

### Q1. 메서드 오버로딩(Overloading)과 오버라이딩(Overriding)의 결정적 차이는 무엇인가요?
> **답변 요약**:
> * **오버로딩(Overloading)**은 같은 클래스 내에서 **메서드 이름은 같고 매개변수 타입/개수가 다른** 새로운 메서드를 정의하는 것입니다. 호출될 메서드가 **컴파일 타임에 결정(정적 바인딩)**됩니다.
> * **오버라이딩(Overriding)**은 상위 클래스의 메서드를 **하위 클래스에서 시그니처를 동일하게 유지한 채 재정의**하는 것입니다. 호출될 메서드가 **런타임에 실제 객체 타입에 따라 결정(동적 바인딩)**되어 다형성을 실현합니다.

### Q2. 추상 클래스(`abstract class`)와 인터페이스(`interface`)의 차이 및 사용 기준은?
> **답변 요약**:
> * **추상 클래스**: 클래스 간의 강한 상속 관계(`is-a`)에서 하위 클래스들의 **공통 상태(인스턴스 필드)와 기본 로직을 재사용 및 확장**할 때 사용합니다 (단일 상속).
> * **인터페이스**: 클래스의 혈통과 무관하게 공통의 **역할/규격(`can-do`)을 정의**하여 결합도를 낮출 때 사용합니다 (다중 구현 가능).
> * Java 8에서 `default` 메서드가 도입되었지만, 인터페이스는 여전히 **인스턴스 상태(상태를 저장하는 멤버 변수)를 가질 수 없다**는 본질적인 차이가 있습니다.

### Q3. Java 16+의 'Pattern Matching for instanceof' 문법은 무엇인가요?
> **답변 요약**:
> 이전에는 `instanceof`로 타입을 검사한 후 다시 명시적 형변환(Casting)을 해야 했습니다:
> ```java
> if (vehicle instanceof Car) {
>     Car car = (Car) vehicle; // 번거로운 다운캐스팅
>     car.drive();
> }
> ```
> Java 16부터는 패턴 매칭을 통해 타입 검사와 동시에 변수 바인딩이 가능합니다:
> ```java
> if (vehicle instanceof Car car) {
>     car.drive(); // 즉시 사용 가능
> }
> ```

---

## 🚀 Getting Started

### 1. Prerequisites
- **Java Development Kit (JDK) 21** 이상
- **Apache Maven 3.8+** (또는 IntelliJ 내장 Maven)

### 2. Clone & Run
```bash
# 1. 저장소 클론
git clone https://github.com/minjae0529-blip/Korea-AI-Academy-11-Java.git

# 2. 프로젝트 디렉토리로 이동
cd Korea-AI-Academy-11-Java

# 3. Maven 컴파일
mvn clean compile
```

터미널에서 특정 클래스 실행 예시:
```bash
# 예시 1: UserMain 실행 (배열 & 필터링)
mvn exec:java -Dexec.mainClass="com.korai.ch05.UserMain"

# 예시 2: AbstractMain06 실행 (인터페이스 & 컬렉션 순회)
mvn exec:java -Dexec.mainClass="com.korai.ch07.AbstractMain06"

# 예시 3: Practice02 실행 (결제 시스템 다형성 종합)
mvn exec:java -Dexec.mainClass="com.korai.ch07.Practice02"
```
