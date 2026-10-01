# ☕ Korea-AI-Academy-11-Java

대한민국인공지능아카데미 11기 **Java 기초 및 객체지향 프로그래밍(OOP)** 학습 및 실습 레포지토리입니다.  
기본적인 자바 문법부터 JVM 메모리 구조, 객체지향 설계의 핵심 개념(클래스, 객체, 캡슐화, 생성자, 메서드 오버로딩 등)을 체계적으로 실습하고 기록합니다.

---

## 🛠 Tech Stack & Environment

| 항목 | 내용 |
| :--- | :--- |
| **Language** | Java 21 (JDK 21) |
| **Build Tool** | Apache Maven |
| **IDE** | IntelliJ IDEA |
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
│   │   │   │   ├── access/               # 캡슐화(private, getter/setter) 및 패키지 분리
│   │   │   │   ├── MethodArea.java       # 클래스 로딩 및 Static 동작 이해
│   │   │   │   └── StaticBasic.java      # 인스턴스 vs 클래스 멤버 실습
│   │   │   ├── com/korai/
│   │   │   │   ├── ch01/                 # 자바 기초 입출력, 배열 기초, toString()
│   │   │   │   ├── ch04/                 # 배열 심화 (1차원/2차원 배열, 메모리 할당)
│   │   │   │   ├── ch05/                 # 제어문(if, for, while, break, continue) 및 연산자
│   │   │   │   │   └── practice/         # 조건문/반복문 응용 실습 (구구단, 다차원 배열)
│   │   │   │   ├── ch06/                 # 메서드(인스턴스/스태틱), 오버로딩, 생성자 기초
│   │   │   │   ├── ch07/                 # 객체지향 심화 (final, 생성자 제어)
│   │   │   │   └── study/                # JVM 메모리 구조 및 함수 개념 탐구
│   │   └── resources/
│   └── test/                             # 단위 테스트 디렉토리
└── README.md                             # 프로젝트 문서
```

---

## 📚 Key Topics & Curriculum

### 1. 자바 기본 문법 및 제어문 (Basic Syntax & Control Flow)
- **콘솔 입출력**: `Scanner`를 활용한 사용자 입력 처리
- **연산자**: 논리 연산자(`&&`, `||`, `!`), 증감 연산자, 대입 연산자 및 연산자 우선순위
- **조건문**: `if`, `else if`, `else`, 단일 행 블록 중괄호 생략 규칙
- **반복문**: `for`, `while`, 무한 루프 제어, `break`, `continue`

### 2. 배열 (Arrays & Multi-dimensional Arrays)
- **1차원 배열**: 배열의 선언, 초기화, 인덱싱, 탐색, 최대값/최소값 및 합계 계산
- **다차원 배열**: 2차원/3차원 배열의 메모리 참조 구조 및 구구단 데이터 저장 실습
- **동적 배열 확장**: 고정 크기 배열의 한계를 극복하기 위한 새로운 배열 생성 및 데이터 복사 기법

### 3. 객체 지향 프로그래밍 (Object-Oriented Programming)
- **클래스와 인스턴스**: 데이터 모델링 및 힙(Heap) 메모리 할당
- **생성자 (Constructor)**: 기본 생성자(No-args Constructor), 매개변수 생성자, `this` 키워드 활용
- **메서드 (Method)**: 인스턴스 메서드와 정적(`static`) 메서드의 차이 및 메서드 오버로딩(Overloading)
- **캡슐화 (Encapsulation)**: `private` 접근 제어자와 `getter`/`setter`를 통한 데이터 보호
- **Object 메서드**: `toString()` 오버라이딩을 통한 객체 정보 출력 형식 커스텀

### 4. JVM 메모리 구조 (JVM Memory Architecture)
- **Method Area (Class Area)**: 클래스 바이트코드 로딩, `static` 변수/메서드 공유 영역
- **Heap Area**: `new` 키워드로 생성된 동적 인스턴스 및 배열이 위치하는 메모리
- **Stack Area**: 메서드 호출 프레임, 지역 변수 및 참조 변수가 저장되는 영역

---

## 💻 Practice Highlights

| 실습 파일 | 주요 내용 |
| :--- | :--- |
| `com.korai.ch01.ArrayTest03` | 1차원 `boolean` 배열과 `Scanner`를 이용한 콘솔 좌석 예약 시스템 |
| `com.korai.ch05.practice.Practice02_01` | 3차원 배열(`int[8][9][3]`)을 이용한 구구단 결과 데이터 저장 및 출력 |
| `com.korai.ch05.UserMain` | `User` 객체 배열 생성 및 조건별 회원 데이터 필터링/조회 실습 |
| `com.korai.ch05.ControlMain6` | 입력에 따라 기존 배열 크기를 늘리고 복사하는 동적 배열 관리 실습 |
| `com.korai.ch06.Method02` | 다양한 파라미터 타입과 개수에 따른 메서드 오버로딩(`Parameter Overloading`) |
| `ch03.access.AccessMain` | 접근 제어자(`private`, `public`, `default`)와 정보 은닉 |

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

실행하고자 하는 클래스는 IDE(IntelliJ 등)에서 `Run` 버튼을 누르거나 터미널에서 실행할 수 있습니다:
```bash
# 예시: UserMain 실행
mvn exec:java -Dexec.mainClass="com.korai.ch05.UserMain"
```
