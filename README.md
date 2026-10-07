# ☕ Korea-AI-Academy-11-Java

대한민국인공지능아카데미 11기 **Java 기초부터 실무 객체지향 프로그래밍(OOP), 디자인 패턴 & 실전 애플리케이션(Todo Console App)** 종합 학습 레포지토리입니다.  
비전공자도 쉽게 이해할 수 있도록 **일상의 직관적인 비유(출입증, 장부, 3색 스티커, 회전목마)**와 **실무 백엔드 아키텍처(Layered Architecture & MVC)**를 결합하여 체계적으로 정리했습니다.

---

## 🛠 Tech Stack & Environment

| 항목 | 내용 | 비고 |
| :--- | :--- | :--- |
| **Language** | Java 21 (LTS) | 최신 모던 자바 문법 (Record, Pattern Matching, Enum 등) |
| **Build Tool** | Apache Maven 3.9+ | 의존성 관리 및 빌드 자동화 |
| **Library** | **Lombok 1.18.48** | 보일러플레이트 코드(`@Data`, `@AllArgsConstructor` 등) 제거 |
| **Architecture** | **Layered Architecture & MVC** | View ↔ Router ↔ Service ↔ Repository ↔ Entity 5계층 구조 |
| **Design Pattern** | **Singleton, Strategy, Router** | 단일 인스턴스 보장, 화면 다형성 라우팅 제어 |
| **IDE** | IntelliJ IDEA Ultimate | 개발, 디버깅 및 실행 |
| **OS** | macOS | 개발 및 실행 환경 |

---

## 📁 Repository Structure (ch01 ~ ch10)

```text
Korea-AI-Academy-11-Java/
├── pom.xml                               # Maven 빌드 설정 파일 (Java 21, Lombok 의존성)
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── ch01/                     # [기초 입출력 & 종합 자가진단 복습]
│   │   │   │   ├── ScannerTest01.java    # 키보드 입력 처리
│   │   │   │   ├── ArrayTest01~03.java   # 성적 관리, 짝수 탐색, 좌석 예약 시스템
│   │   │   │   ├── AbstractTest01.java   # 추상화 및 안전한 다운캐스팅 실습
│   │   │   │   ├── ObjectTest.java       # equals & hashCode 복습
│   │   │   │   └── SingletonTest01.java  # 싱글톤 패턴 자가진단 코드
│   │   │   ├── ch02/
│   │   │   │   └── practice/             # [실전 미니 프로젝트 - 메모장 앱] (New ✨)
│   │   │   │       ├── Memo.java         # 메모 데이터 엔티티
│   │   │   │       ├── MemoRepository.java # 메모 인메모리 저장소
│   │   │   │       ├── MemoService.java  # 메모 비즈니스 로직
│   │   │   │       ├── MemoView.java     # 콘솔 입출력 UI 화면
│   │   │   │       └── MemoApplication.java # 의존성 주입(DI) 및 무한 루프 실행
│   │   │   ├── ch03/                     # [JVM 메모리 구조 & 접근 제어자]
│   │   │   │   ├── access/               # 캡슐화(private, getter/setter) 및 정보 은닉
│   │   │   │   ├── MethodArea.java       # 클래스 로딩과 static 영역의 동작 원리
│   │   │   │   └── StaticBasic.java      # 공용 static 변수 vs 개인 인스턴스 변수
│   │   │   ├── ch04/                     # [배열 심화] 1차원/2차원 배열과 메모리 참조
│   │   │   ├── ch05/                     # [제어문 응용] if, for, while, 3차원 구구단, 동적 배열 확장
│   │   │   ├── ch06/                     # [메서드 & 생성자] 인스턴스/스태틱 메서드, 메서드 오버로딩
│   │   │   ├── ch07/                     # [객체지향 4대 원칙 & 컬렉션]
│   │   │   │   ├── AbstractMain01~06.java # List 컬렉션, 추상 클래스, 다형성, super, 인터페이스
│   │   │   │   ├── Practice01~04.java     # 다형성 종합 실습 (탈것, 결제, 급여, 2차원 리스트)
│   │   │   │   └── README.md             # Ch07 전용 핵심 개념 정리 노트
│   │   │   ├── ch08/                 # [Object 클래스 완전 정복]
│   │   │   │   ├── Object01.java         # getClass(), instanceof, toString() 재정의
│   │   │   │   └── Object02.java         # 동일성(==) vs 동등성(equals) & hashCode
│   │   │   ├── ch09/                 # [실무 계층형 아키텍처 & 롬복]
│   │   │   │   ├── entity/Car.java       # Lombok(@Data)을 활용한 차량 엔티티 모델링
│   │   │   │   ├── repository/CarRepository.java # 차량 데이터 보관 및 CRUD(등록/삭제/조회)
│   │   │   │   ├── service/InitService.java      # 시스템 초기화 및 싱글톤 저장소 관리
│   │   │   │   └── CarMain.java          # 차량 관리 시스템 실행 컨트롤러
│   │   │   ├── ch10/                 # [디자인 패턴 & 실전 Todo 풀스택 앱] 🌟 (Major Update)
│   │   │   │   ├── SingletonMain.java    # 싱글톤 패턴 기초 (StudentService)
│   │   │   │   └── TODO/                 # [실전 콘솔 풀스택 Todo 애플리케이션]
│   │   │   │       ├── TodoApplication.java # 메인 엔트리포인트 (회전목마 모터)
│   │   │   │       ├── config/           # [보안 & 세션 관리]
│   │   │   │       │   └── SecurityConfig.java # UUID 세션 토큰 발급 및 로그인 상태 유지
│   │   │   │       ├── entity/           # [데이터 모델링]
│   │   │   │       │   ├── User.java     # 회원 엔티티
│   │   │   │       │   ├── Todo.java     # 할 일 엔티티 (User 연관관계)
│   │   │   │       │   └── TodoStatus.java # 열거형(Enum): 진행전/진행중/완료
│   │   │   │       ├── repository/       # [데이터 보관소]
│   │   │   │       │   ├── UserRepository.java # 회원 인메모리 저장소
│   │   │   │       │   └── TodoRepository.java # 할 일 CRUD 및 사용자별 필터링
│   │   │   │       ├── service/          # [비즈니스 총괄 매니저]
│   │   │   │       │   ├── UserService.java # 로그인 인증 및 토큰 발급 연계
│   │   │   │       │   └── TodoService.java # 세션 기반 할 일 등록/조회/상태변경
│   │   │   │       ├── view/             # [UI 화면 창구]
│   │   │   │       │   ├── View.java     # 화면 공통 인터페이스 (show() 규격)
│   │   │   │       │   ├── LoginView.java # 로그인 화면
│   │   │   │       │   ├── TodoListView.java # 내 할 일 목록 조회 화면
│   │   │   │       │   ├── TodoRegisterView.java # 새 할 일 등록 화면
│   │   │   │       │   └── TodoStatusView.java   # 상태 변경(3색 스티커) 화면
│   │   │   │       ├── router/           # [화면 라우팅]
│   │   │   │       │   └── RootRouter.java # 경로(Path) 기반 화면 전환 컨트롤러
│   │   │   │       └── docs/             # [13개 클래스별 상세 가이드 & 마스터 문서]
│   │   │   └── study/                # JVM 메모리 구조 및 함수 개념 탐구
│   │   └── resources/
│   └── test/
└── README.md                             # 프로젝트 전체 통합 가이드 문서
```

---

## 🧭 Ch01 ~ Ch10 단계별 커리큘럼 로드맵 (비전공자 눈높이 가이드)

### 🟢 1단계: 프로그래밍 기본기와 의존성 주입 기초 (Ch01 ~ Ch03)

#### **Ch01. 자바 기초 & 누적 종합 복습**
* **개념**: 컴퓨터와의 대화 시작. 콘솔에서 입력을 받고(`Scanner`), 결과를 화면에 출력(`System.out.println`).
* **실습 하이라이트**: 좌석 예약 프로그램(`ArrayTest03`), 누적 학습 내용(추상화, 다운캐스팅, 싱글톤) 자가 진단 테스트 코드 작성.

#### **Ch02 (Practice). 실전 미니 프로젝트 — 메모장 앱 (`MemoApplication`)** ✨
* **비전공자 핵심 포인트: 의존성 주입(Dependency Injection, DI)**
  * 요리사(`Service`)가 직접 텃밭에서 배추(`Repository`)를 기르는 것이 아니라, **외부에서 싱싱한 배추를 손에 쥐여주는 것**이 DI입니다!
  ```java
  // 1) 보관함(저장소) 생성
  MemoRepository memoRepository = new MemoRepository();
  // 2) 매니저에게 보관함을 쥐여줌 (DI)
  MemoService memoService = new MemoService(memoRepository);
  // 3) 화면에 매니저를 연결해줌 (DI)
  MemoView memoView = new MemoView(memoService);
  ```

#### **Ch03. JVM 메모리 구조 & 정보 은닉(캡슐화)**
* **비전공자 3대 메모리 비유**:
  * **Method Area (스태틱 영역)**: 마을의 **공용 게시판**. 누구나 언제든 바로 볼 수 있음 (`static`).
  * **Heap Area (힙 영역)**: 물건을 만드는 **공장 부지**. `new`를 외치면 이곳에 객체가 지어짐.
  * **Stack Area (스택 영역)**: 작업자가 쓰는 **개인 메모장**. 메서드가 끝나면 메모장 페이지를 찢어서 버림.
* **접근 제어자 (캡슐화)**: `private`(내 방 비밀금고), `getter/setter`(금고지기).

---

### 🟡 2단계: 데이터 묶음과 흐름 제어 (Ch04 ~ Ch06)

#### **Ch04 ~ Ch05. 배열과 제어문의 응용**
* **배열의 본질**: 크기가 고정된 계란판.
* **동적 배열 확장 기법 (`ControlMain6`)**: 배열이 꽉 차면 더 큰 새 배열(2배 크기)로 데이터를 이사시키는 실무 원리.
* **반복 제어**: `break`(문 닫고 탈출), `continue`(이번 순번만 건너뛰기).

#### **Ch06. 메서드와 생성자 (Constructor)**
* **메서드 오버로딩 (Overloading)**: "이름은 하나인데 일하는 방식은 여러 개!" (파라미터에 따라 맞춤 동작).
* **생성자 체이닝 (`this()`)**: 기본값으로 주문할 때 기존 주문서를 재활용하여 중복 제거.

---

### 🟠 3단계: 객체지향 4대 원칙 & 컬렉션 (Ch07)

* **추상 클래스 (`is-a`) vs 인터페이스 (`can-do`)**:
  * **추상 클래스**: "동물(부모)은 숨을 쉰다"처럼 공통의 상태와 피를 물려줌.
  * **인터페이스**: "운전할 수 있는 자격증"처럼 특정 기능/규격을 강제함.
* **다형성 (Polymorphism)**:
  * **업캐스팅 (Upcasting)**: `Animal a = new Dog();` 부모 타입으로 자식 객체를 유연하게 다룸.
  * **다운캐스팅 (Downcasting)**: `instanceof`로 진짜 강아지인지 확인 후 안전하게 고유 기능 호출.
* **컬렉션 `List`**: 크기가 자동으로 늘어나는 마법의 주머니 (`ArrayList` vs `LinkedList`).

---

### 🔴 4단계: 자바 최상위 클래스 & 계층 아키텍처 (Ch08 ~ Ch09)

#### **Ch08. 자바의 시조새 — `Object` 클래스**
1. **`toString()`**: 기본 메모리 암호 대신 사람이 읽을 수 있는 데이터 문자열로 변환.
2. **동일성(`==`) vs 동등성(`equals()`) [사물함 비유]**:
   * **`==`**: 사물함 번호(메모리 주소)가 같은가?
   * **`equals()`**: 사물함 번호는 달라도 안에 든 물건(데이터)이 같은가?
3. **`hashCode()`**: "내용물이 같으면 도서관 청구기호(해시코드)도 반드시 같아야 한다!"

#### **Ch09. 계층형 아키텍처(Layered) & 롬복(Lombok)**
* **3단 분리**: Entity(주문서) $\rightarrow$ Repository(창고 관리자) $\rightarrow$ Service(총괄 매니저).
* **Lombok (`@Data`)**: 수십 줄의 Getter/Setter 코드를 어노테이션 하나로 자동 완성.

---

### 🟣 5단계: 디자인 패턴 & 실전 콘솔 풀스택 Todo 앱 (Ch10) 🌟 [NEW]

Ch10에서는 단순 문법 학습을 넘어, **웹/앱 프레임워크(Spring Boot 등)의 근간이 되는 풀스택 아키텍처를 순수 자바 콘솔 환경에서 직접 구현**했습니다.

```text
               ┌─────────────────────────────────────────┐
               │    TodoApplication (회전목마 모터)       │
               │   while (true) { currentView.show(); }  │
               └────────────────────┬────────────────────┘
                                    │ 현재 화면 요청
                                    ▼
               ┌─────────────────────────────────────────┐
               │          RootRouter (교통경찰)           │
               │  "login" -> LoginView                   │
               │  "todo-list" -> TodoListView            │
               │  "todo-register" -> TodoRegisterView    │
               │  "todo-status" -> TodoStatusView        │
               └────────────────────┬────────────────────┘
                                    │ 화면 출력 & 입력 접수
                                    ▼
                         ┌──────────────────────┐
                         │   View (공통 인터페이스)│
                         └──────────┬───────────┘
                                    │ 비즈니스 처리 요청
                                    ▼
       ┌────────────────────────────┴────────────────────────────┐
       ▼                                                         ▼
┌──────────────┐ (로그인/인증)                           ┌──────────────┐ (할 일 CRUD)
│ UserService  │                                         │ TodoService  │
└──────┬───────┘                                         └──────┬───────┘
       │                                                        │
       ├─────────────► SecurityConfig (출입증 발급기) ◄──────────┤
       │               [uuid@userId 세션 토큰 보관]               │
       ▼                                                         ▼
┌──────────────┐                                         ┌──────────────┐
│UserRepository│                                         │TodoRepository│
│  (회원 장부)   │                                         │ (할 일 바인더) │
└──────────────┘                                         └──────────────┘
```

#### 🗺️ [한눈에 보는 비전공자 찰떡 비유 맵]

| 현실 세계 비유 | 프로그램 속 클래스명 | 실제 시스템 역할 |
|:---|:---|:---|
| 🎡 **회전목마 모터** | `TodoApplication` | 프로그램이 꺼지기 전까지 계속 화면을 돌려주는 무한 루프 엔진 |
| 📐 **화면 규격 약속** | `View` (인터페이스) | 모든 모니터가 똑같은 전원 버튼(`show()`)을 갖추도록 정한 인터페이스 |
| 👮 **안내 데스크 & 교통경찰** | `RootRouter` | 부품을 조립하고, 경로(`current`)에 따라 "다음 화면!"을 전환해 주는 라우터 |
| 🎫 **출입증 발급기 & 세션** | `SecurityConfig` | 로그인 성공 시 유일한 출입증(`UUID@userId`)을 발급하고 로그인 상태를 기억하는 싱글톤 설정 |
| 🪪 **회원 신분증** | `User` (Entity) | 회원 번호, 아이디, 비밀번호, 이름이 적힌 회원 데이터 객체 |
| 📝 **할 일 메모지** | `Todo` (Entity) | 할 일 내용과 3색 스티커가 붙어 있고 작성자(`User`) 정보가 꽂힌 객체 |
| 🏷️ **3색 상태 스티커** | `TodoStatus` (Enum) | [진행전 / 진행중 / 완료] 딱 3가지만 붙일 수 있도록 규격화한 열거형 |
| 📖 **회원 관리 장부** | `UserRepository` | 회원 아이디로 회원을 검색하고 저장하는 인메모리 장부 |
| 🗂️ **할 일 바인더 & 번호표 기계** | `TodoRepository` | 메모지가 들어올 때마다 1, 2, 3 번호표(`autoIncrement`)를 붙이고, 내 메모만 골라줌 |
| 🕵️ **신분증 검사관** | `UserService` | 아이디/비밀번호를 장부와 대조하여 일치하면 출입증 발급 |
| 👨‍💼 **할 일 총괄 매니저** | `TodoService` | 출입증을 검사해 "누구의 메모인지" 확인하고 등록/조회/상태변경을 총괄 지휘 |
| 🖥️ **화면 창구들** | `LoginView`, `TodoListView`, `TodoRegisterView`, `TodoStatusView` | 사용자에게 입력을 받고 처리 결과를 보여주는 콘솔 UI 창구 |

---

## 📊 Day-10 대규모 업데이트 비교표

| 구분 | 이전 커밋 (`2727f21`) | 오늘 최신화 (`Day-10`, `f28e854`) | 비고 |
| :--- | :--- | :--- | :--- |
| **프로젝트 규모** | 챕터별 문법 예제 중심 | **실전 풀스택 Todo 애플리케이션 (5계층) 추가** | 미니/대형 실전 프로젝트 2종 탑재 |
| **화면 제어 방식** | 단순 콘솔 단일 루프 | **다형성 라우터 (`RootRouter`) 기반 화면 전환** | 웹 프론트엔드의 SPA 라우팅 원리 적용 |
| **보안 & 세션** | 미구현 | **`SecurityConfig` (UUID 기반 토큰 & 세션 유지)** | 로그인 인증 상태 유지 구현 |
| **상태 관리** | 문자열(String) 단순 처리 | **`TodoStatus` 열거형 (Enum) 타입 안전성 확보** | 진행전 / 진행중 / 완료 상태 제어 |
| **데이터 연관관계** | 단순 단일 객체 | **User ↔ Todo (1:N 연관관계 & 작성자 필터링)** | 로그인한 본인의 할 일만 조회/관리 |
| **문서화** | README 중심 요약 | **13개 클래스별 가이드 문서 + HTML 대시보드** | `ch10/TODO/docs/` 내 완전한 문서화 |

---

## 💡 비전공자를 위한 핵심 1분 Q&A (FAQ)

### Q1. Enum(열거형)은 왜 쓰나요? 그냥 문자열(`"진행중"`)로 쓰면 안 되나요?
> **답변**: 문자열로 쓰면 개발자가 오타를 내서 `"진행즁"`이나 `"중"`이라고 적어도 컴파일러가 잡아내지 못해 큰 버그가 생깁니다. `Enum`을 쓰면 미리 정해둔 `todo`, `inProgress`, `done` 외에는 아예 입력을 못 하도록 **컴파일러가 완벽하게 안전장치**를 걸어줍니다!

### Q2. 웹 브라우저도 아닌 콘솔 프로그램인데 왜 Router(라우터)와 Session(세션)이 필요한가요?
> **답변**: 콘솔 프로그램도 화면이 1개만 있는 것이 아닙니다. [로그인 화면] $\rightarrow$ [목록 화면] $\rightarrow$ [등록 화면]처럼 화면이 바뀔 때마다 코드가 꼬이지 않도록 **"교통경찰(Router)"**이 길을 안내해 주어야 하고, 로그인한 사람이 누구인지 기억하는 **"출입증 주머니(Session)"**가 있어야 내 할 일만 쏙 골라 보여줄 수 있기 때문입니다.

### Q3. 의존성 주입(DI)은 왜 실무 필수인가요?
> **답변**: 부품 간의 결합도를 낮추기 위해서입니다. 내가 직접 자동차 엔진을 내 방에서 조립해 넣으면 나중에 다른 엔진으로 바꿀 때 자동차 전체를 뜯어고쳐야 합니다. 밖에서 완성된 엔진을 조립해 넣어주면(DI), 엔진이 고장 나도 엔진만 쏙 바꿔 끼울 수 있어 유지보수가 엄청나게 쉬워집니다.

---

## 🚀 프로젝트 실행 및 테스트 방법

### 1. 전체 프로젝트 컴파일
```bash
mvn clean compile
```

### 2. 신규 실전 프로젝트 실행

#### 📌 [Ch02 Practice] 간이 메모장 애플리케이션 실행
```bash
mvn exec:java -Dexec.mainClass="com.korai.ch02.practice.MemoApplication"
```

#### 📌 [Ch10 TODO] 콘솔 풀스택 Todo 애플리케이션 실행
```bash
mvn exec:java -Dexec.mainClass="com.korai.ch10.TODO.TodoApplication"
```
* **테스트 기본 계정**: 
  * 아이디: `test` / 비밀번호: `1234` (또는 신규 가입)
* **주요 기능 체험**:
  1. 로그인 및 UUID 세션 발급
  2. 내 할 일 등록 (`todo-register`)
  3. 내 할 일 목록 조회 (`todo-list`)
  4. 3색 상태 스티커 변경 (`todo-status`: 진행전 $\rightarrow$ 진행중 $\rightarrow$ 완료)
