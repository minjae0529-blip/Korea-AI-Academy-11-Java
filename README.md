# ☕ Korea-AI-Academy-11-Java

대한민국인공지능아카데미 11기 **Java 기초부터 실무 객체지향 프로그래밍(OOP) & 디자인 패턴** 학습 레포지토리입니다.  
비전공자도 쉽게 이해할 수 있도록 **일상의 직관적인 비유**와 **실무 백엔드 아키텍처**를 결합하여 체계적으로 정리했습니다.

---

## 🛠 Tech Stack & Environment

| 항목 | 내용 | 비고 |
| :--- | :--- | :--- |
| **Language** | Java 21 (LTS) | 최신 모던 자바 문법 활용 |
| **Build Tool** | Apache Maven 3.9+ | 의존성 및 빌드 라이프사이클 관리 |
| **Library** | **Lombok 1.18.48** (New ✨) | 보일러플레이트 코드(Getter/Setter 등) 자동화 |
| **IDE** | IntelliJ IDEA Ultimate | 코드 자동완성, 리팩토링, 디버깅 |
| **OS** | macOS | 개발 및 실행 환경 |

---

## 📁 Repository Structure (ch01 ~ ch10)

```text
Korea-AI-Academy-11-Java/
├── pom.xml                               # Maven 빌드 설정 파일 (Java 21, Lombok 의존성 추가)
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── ch03/                     # [JVM 메모리 & 접근 제어자]
│   │   │   │   ├── access/               # 캡슐화(private, getter/setter) 및 정보 은닉
│   │   │   │   ├── MethodArea.java       # 클래스 로딩과 static 영역의 동작 원리
│   │   │   │   └── StaticBasic.java      # 공용 static 변수 vs 개인 인스턴스 변수
│   │   │   ├── com/korai/
│   │   │   │   ├── ch01/                 # [기초 입출력 & 누적 종합 복습 테스트]
│   │   │   │   │   ├── ScannerTest01.java    # 키보드 입력 처리
│   │   │   │   │   ├── ArrayTest01~03.java   # 좌석 예약 시스템 등 배열 조작
│   │   │   │   │   ├── ToStringTest01.java   # 객체 문자열 변환
│   │   │   │   │   ├── AbstractTest01.java   # 추상화 및 다운캐스팅 테스트 (New ✨)
│   │   │   │   │   ├── ObjectTest.java       # equals & hashCode 복습 (New ✨)
│   │   │   │   │   └── SingletonTest.java    # 도서관 저장소 싱글톤 실습 (New ✨)
│   │   │   │   ├── ch04/                 # [배열 심화] 1차원/2차원 배열과 메모리 참조
│   │   │   │   ├── ch05/                 # [제어문 응용] if, for, while, 3차원 구구단, 동적 배열 확장
│   │   │   │   ├── ch06/                 # [메서드 & 생성자] 인스턴스/스태틱 메서드, 메서드 오버로딩
│   │   │   │   ├── ch07/                 # [객체지향 4대 원칙 & 컬렉션]
│   │   │   │   │   ├── AbstractMain01~06.java # List 컬렉션, 추상 클래스, 다형성, super, 인터페이스
│   │   │   │   │   ├── Practice01~04.java     # 다형성 종합 실습 (탈것, 결제, 급여, 2차원 리스트)
│   │   │   │   │   └── README.md             # Ch07 전용 개념 정리 노트
│   │   │   │   ├── ch08/                 # [Object 클래스 완전 정복] (New ✨)
│   │   │   │   │   ├── Object01.java         # getClass(), instanceof, toString() 재정의
│   │   │   │   │   └── Object02.java         # 동일성(==) vs 동등성(equals) & hashCode
│   │   │   │   ├── ch09/                 # [실무 계층형 아키텍처 & 롬복] (New ✨)
│   │   │   │   │   ├── entity/Car.java       # Lombok(@Data)을 활용한 차량 엔티티 모델링
│   │   │   │   │   ├── repository/CarRepository.java # 차량 데이터 보관 및 CRUD(등록/삭제/조회)
│   │   │   │   │   ├── service/InitService.java      # 시스템 초기화 및 싱글톤 저장소 관리
│   │   │   │   │   └── CarMain.java          # 차량 관리 시스템 실행 컨트롤러
│   │   │   │   ├── ch10/                 # [디자인 패턴 - 싱글톤] (New ✨)
│   │   │   │   │   └── SingletonMain.java    # 단 하나만 존재하는 객체(StudentService) 만들기
│   │   │   │   └── study/                # JVM 메모리 구조 및 함수 개념 탐구
│   │   └── resources/
│   └── test/
└── README.md                             # 프로젝트 전체 통합 가이드 문서
```

---

## 🧭 Ch01 ~ Ch10 핵심 커리큘럼 총정리 (비전공자 눈높이 가이드)

### 🟢 1단계: 프로그래밍 기본기와 메모리 이해 (Ch01 ~ Ch03)

#### **Ch01. 자바 기초 & 누적 종합 복습**
* **개념**: 컴퓨터와의 대화 시작. 콘솔에서 입력을 받고(`Scanner`), 결과를 화면에 출력(`System.out.println`).
* **실습 하이라이트**: 좌석 예약 프로그램(`ArrayTest03`), 누적 학습 내용(추상화, 다운캐스팅, 싱글톤) 자가 진단 테스트 코드 작성.

#### **Ch02 ~ Ch03. JVM 메모리 구조 & 정보 은닉(캡슐화)**
* **비전공자 비유**:
  * **Method Area (스태틱 영역)**: 마을의 **공용 게시판**. 누구나 언제든 바로 볼 수 있음 (`static`).
  * **Heap Area (힙 영역)**: 물건을 만드는 **공장 부지**. `new`를 외치면 이곳에 객체가 지어짐.
  * **Stack Area (스택 영역)**: 작업자가 쓰는 **개인 메모장**. 메서드가 끝나면 메모장 페이지를 찢어서 버림.
* **접근 제어자 (캡슐화)**:
  * `private`: 내 방 비밀금고 (외부 접근 절대 금지)
  * `getter / setter`: 금고지기 (안전하게 값을 꺼내고 검증 후 수정)

---

### 🟡 2단계: 데이터 묶음과 흐름 제어 (Ch04 ~ Ch06)

#### **Ch04 ~ Ch05. 배열과 제어문의 응용**
* **배열의 본질**: 크기가 정해진 계란판. 한 번 10칸으로 만들면 11번째 계란을 넣을 수 없음!
* **동적 배열 확장 기법 (`ControlMain6`)**: 배열이 꽉 차면 더 큰 새 배열(2배 크기)을 사 와서 기존 데이터를 이사시키는 실무 원리 체득.
* **반복 제어**: `break`(문 닫고 탈출), `continue`(이번 순번만 건너뛰고 다음으로).

#### **Ch06. 메서드와 생성자 (Constructor)**
* **메서드 오버로딩 (Overloading)**: "이름은 하나인데 일하는 방식은 여러 개!" (같은 요리사에게 라면만 달라고 할 때와, 계란 추가해서 달라고 할 때).
* **생성자 체이닝 (`this()`)**: 기본값으로 주문할 때 기존 주문서를 재활용하는 지혜.

---

### 🟠 3단계: 객체지향의 꽃 - 상속, 다형성, 컬렉션 (Ch07)

* **추상 클래스 (`abstract class`) vs 인터페이스 (`interface`)**:
  * **추상 클래스 (`is-a`)**: "동물(부모)은 숨을 쉰다"처럼 공통의 피(상태와 기본 로직)를 물려줌.
  * **인터페이스 (`can-do`)**: "운전할 수 있는 자격증"처럼 특정 기능/규격을 강제함.
* **다형성 (Polymorphism)**:
  * **업캐스팅 (Upcasting)**: `Animal a = new Dog();` 강아지를 동물이라고 불러도 문제없음 (자동 변환).
  * **다운캐스팅 (Downcasting)**: `Dog d = (Dog) a;` 동물 중에서 진짜 강아지인지 **`instanceof`**로 확인 후 전용 기능(짖기)을 사용.
* **컬렉션 `List`**: 크기가 자동으로 늘어나는 마법의 주머니! (`ArrayList` vs `LinkedList`).

---

### 🔴 4단계: 실무 필수 기본기 & 아키텍처 (Ch08 ~ Ch10) 🌟 [NEW]

#### **Ch08. 자바의 시조새 - `java.lang.Object` 클래스**
자바의 모든 클래스는 따로 적지 않아도 자동으로 `extends Object`가 붙습니다. 즉, 모든 객체의 최상위 조상입니다.

1. **`toString()` - 객체의 속마음 들여다보기**
   * 기본 `toString()`은 `Student@1b6d3586`처럼 외계인 암호(메모리 해시)를 줍니다.
   * 이를 오버라이딩하여 `Student{name='강민재', age=26}`처럼 읽기 쉬운 문자열로 예쁘게 포장합니다.
2. **동일성(`==`) vs 동등성(`equals()`) - [사물함 비유]**
   * **`==` (동일성, Identity)**: "두 열쇠가 **같은 사물함 번호(메모리 주소)**를 가리키는가?"
   * **`equals()` (동등성, Equivalence)**: "사물함 번호는 달라도, **안에 든 내용물(데이터 값)**이 똑같은가?"
3. **`hashCode()`가 세트로 움직여야 하는 이유**
   * "내용물이 같으면(`equals == true`), 도서관 청구기호(`hashCode`)도 반드시 같아야 한다!"
   * 둘 중 하나만 만들면 `HashSet`, `HashMap` 같은 실무 자료구조에서 데이터를 잃어버리는 대참사가 일어납니다.

---

#### **Ch09. 실무 백엔드 개발의 정석 - 계층형 아키텍처(Layered) & 롬복(Lombok)**

혼자 다 하는 만능 클래스를 만들면 코드가 엉망이 됩니다. 실무에서는 **철저하게 역할을 3단계로 분리(단일 책임 원칙, SRP)**합니다:

```text
 [사용자 요청] 
      │
      ▼
┌─────────────┐   "데이터 주문서"
│   Entity    │ : 순수하게 정보만 담는 객체 (Car: 번호, 모델명, 소유자)
└─────────────┘   Lombok(@Data)으로 게터/세터/생성자 1초 만에 완성!
      ▲
      │
┌─────────────┐   "창고 관리자"
│ Repository  │ : 데이터 저장소 (CarRepository)
└─────────────┘   차량 등록(insert), 삭제(delete), 전체 목록 조회(printAll) 전담
      ▲
      │
┌─────────────┐   "총괄 매니저"
│   Service   │ : 비즈니스 로직 및 시스템 초기화 (InitService)
└─────────────┘   공유 창고를 단 하나만 준비하고 조율하는 역할
```

* **Lombok 라이브러리 도입 (`@Data`, `@AllArgsConstructor`)**:
  * 수십 줄의 Getter, Setter, 생성자 코드를 단 한두 줄의 어노테이션으로 자동 생성하여 개발 생산성을 극대화합니다.

---

#### **Ch10. 디자인 패턴의 첫걸음 - 싱글톤 패턴 (Singleton Pattern)**

* **비전공자 비유**: **"한 학교에 교장선생님은 오직 한 분이어야 한다!"**
  * 여러 곳에서 교장선생님 객체를 제각각 `new`로 새로 만들면, 결재가 엉뚱한 사람에게 가고 메모리가 낭비됩니다.
* **싱글톤을 만드는 불변의 3단계 공식**:
  1. **`private static` 변수**: 나 자신의 유일한 객체를 담을 변수를 static 공간에 마련.
  2. **`private` 생성자**: 밖에서 마음대로 `new`를 하지 못하도록 문을 걸어 잠금!
  3. **`public static getInstance()`**: 오직 이 메서드를 통해서만 유일한 인스턴스를 얻어갈 수 있도록 통로를 단일화.

```java
class StudentService {
    // 1) static 공간에 단 하나만 존재할 자리 마련
    private static StudentService instance;

    // 2) 외부에서 new 하지 못하게 private으로 차단
    private StudentService() {}

    // 3) 오직 이 메서드로만 유일한 객체를 공유
    public static StudentService getInstance() {
        if (instance == null) {
            instance = new StudentService(); // 처음 부를 때만 딱 한 번 생성
        }
        return instance;
    }
}
```

---

## 📊 이번 작업(차이점) 비교 요약표

| 구분 | 이전 커밋 (`180f224`, 10/2) | 현재 최신화 (`10/6`) | 비고 |
| :--- | :--- | :--- | :--- |
| **학습 범위** | `ch01` ~ `ch07` (객체지향 기초/심화) | **`ch01` ~ `ch10` 전 범위 확장** | 단원 대폭 확대 |
| **신규 단원** | - | **Ch08(Object), Ch09(계층 아키텍처), Ch10(싱글톤)** | 실무 패턴 도입 |
| **외부 라이브러리** | 순수 Java 표준 라이브러리 | **Project Lombok (`@Data`) 도입** | `pom.xml` 의존성 추가 |
| **소프트웨어 구조** | 단일 실행 클래스 중심 | **Entity - Repository - Service 3계층 분리** | 백엔드 실무 표준 방식 |
| **설계 패턴** | 다형성 위주 | **싱글톤(Singleton) 디자인 패턴 적용** | 메모리 절약 & 단일 객체 보장 |
| **종합 복습** | 각 챕터별 실습 | `ch01`에 최신 배운 개념 자가진단 코드 통합 | 복습 체계화 |

---

## 💡 비전공자를 위한 핵심 1분 Q&A (FAQ)

### Q1. `==`과 `equals()`는 왜 따로 있나요? 그냥 하나로 통일하면 안 되나요?
> **답변**: 사람이 볼 때는 같은 주민등록번호와 이름을 가진 "동일 인물"이어도, 컴퓨터 입장에서는 1층 101호와 2층 201호에 각각 살고 있는 "별개의 복제품"일 수 있습니다. 컴퓨터 메모리 방 번호가 같은지 볼 때는 `==`를 쓰고, 사람 관점에서 내용물이 같은지 볼 때는 `equals()`를 씁니다!

### Q2. 롬복(Lombok)은 왜 실무 필수라고 하나요?
> **답변**: 필드가 10개 있는 클래스를 만들면, Getter/Setter/생성자/toString만 쳐도 100줄이 넘어갑니다. 롬복은 `@Data` 딱 한 줄로 이 모든 걸 눈에 보이지 않게 컴파일러가 만들어주므로, 개발자가 핵심 비즈니스 로직에만 집중할 수 있게 해줍니다.

### Q3. 싱글톤은 언제 써야 하나요?
> **답변**: 로그인한 사용자 세션 관리자, 데이터베이스 연결 관리자, 환경설정 관리자처럼 **"프로그램 전체에서 데이터를 하나로 유지하고 다 같이 공유해야 하는 대상"**에 사용합니다.

---

## 🚀 실행 및 테스트 방법

### 1. Maven 의존성 빌드
```bash
mvn clean compile
```

### 2. 신규 실습 실행 예시
```bash
# [Ch08] Object equals & hashCode 비교 실행
mvn exec:java -Dexec.mainClass="com.korai.ch08.Object02"

# [Ch09] 실무 계층형 구조 기반 차량 관리 시스템 실행
mvn exec:java -Dexec.mainClass="com.korai.ch09.CarMain"

# [Ch10] 싱글톤 패턴 동작 검증 실행
mvn exec:java -Dexec.mainClass="com.korai.ch10.SingletonMain"
```
