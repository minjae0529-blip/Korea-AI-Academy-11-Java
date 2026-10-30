# ☕ Korea-AI-Academy-11-Java

대한민국인공지능아카데미 11기 **Java 기초(`ch01`~`ch14`)부터 실전 콘솔 앱, Servlet 웹 서버, MySQL(JDBC) 데이터베이스 연동**까지 전 과정을 챕터별 핵심 위주로 정리한 학습 & 복습 레포지토리입니다.

---

## 🛠 Tech Stack & Environment

| 항목 | 내용 | 비고 |
| :--- | :--- | :--- |
| **Language** | Java 21 (LTS) | OOP, Collection, Lambda, Stream, Enum |
| **Web / WAS** | Java Servlet 4.0, JSP, Apache Tomcat 9.0 | `@WebServlet`, Filter(UTF-8/CORS), MVC 포워딩 & JSON API |
| **Database** | **MySQL & JDBC (`mysql-connector-j`)** | `DriverManager`, `PreparedStatement`, `ResultSet`, `try-with-resources` |
| **Build & Library** | Maven, **Lombok**, **Jackson** | `@Data`, `@AllArgsConstructor`, JSON 직렬화/역직렬화 |
| **IDE & OS** | IntelliJ IDEA Ultimate / macOS | 개발, 디버깅 및 DB 연동 환경 |

---

## 📁 Repository Structure

```text
Korea-AI-Academy-11-Java/
├── pom.xml                               # Maven 설정 (Java 21, Lombok)
├── src/main/java/
│   ├── ch03/                             # [Ch03] JVM 메모리(MethodArea, Static) & 접근 제어자(access)
│   └── com/korai/
│       ├── ch01/                         # [Ch01] 기초 입출력(Scanner), 배열/객체/추상화/싱글톤 복습
│       ├── ch02/practice/                # [Ch02] 실전 미니 프로젝트 - 메모장 앱 (DI 구조)
│       ├── ch03/practice/                # [Ch03] 캡슐화 실습 (Visitor)
│       ├── ch04/                         # [Ch04] 1차원/2차원 배열과 메모리 참조 (ArrayMain01~04)
│       ├── ch05/                         # [Ch05] 조건문(if/switch), 반복문, 동적 배열 확장 (ControlMain~7)
│       ├── ch06/                         # [Ch06] 메서드 정의, 호출, 오버로딩 (Method01~03)
│       ├── ch07/                         # [Ch07] 상속(super), 추상 클래스, 인터페이스, 다형성, List 기초
│       ├── ch08/                         # [Ch08] Object 클래스 (toString, equals, hashCode)
│       ├── ch09/                         # [Ch09] 계층형 아키텍처(Entity-Repository-Service) & Lombok
│       ├── ch10/                         # [Ch10] 싱글톤 패턴 & 콘솔 풀스택 Todo 앱 / 호텔·도서관·주차장 실습
│       ├── ch11/                         # [Ch11] 싱글톤 View 리스트 기반 화면 라우팅 (TodoMain, StudentMain)
│       ├── ch12/                         # [Ch12] 컬렉션 심화(List/Set/Map), CustomLinkedList 구현, 예외 처리
│       ├── ch13/                         # [Ch13] 익명 클래스(Anonymous Class) & 람다식(Lambda), 표준 함수형 인터페이스
│       └── ch14/                         # [Ch14] Stream API (filter/map/toList) & CustomStream 직접 구현
├── servlet-study-basic/                  # [Servlet 기초] FirstServlet, HelloServlet, web.xml
├── servlet-jdbc-study/                   # [Servlet 심화 & MySQL JDBC 연동]
│   └── src/main/java/com/korai/serveltstudy2/
│       ├── database/                     # DBConnectionTest.java (MySQL 연동), Menu.java
│       ├── controller/                   # Book, Car, Product, User, Student (View & REST API 컨트롤러)
│       ├── model/                        # Entity, Service, Repository 계층
│       └── filter/                       # Utf8EncodingFilter, CorsFilter
└── docs/                                 # 서블릿 노트(servlet_study_workbook.md) 및 학습 요약 자료
```

---

## 📌 챕터별 핵심 요약 노트 (Ch01 ~ Ch14 + Servlet & DB)

### **Ch01. 자바 기초 입출력 & 종합 복습**
* **핵심 키워드**: `Scanner`, `System.out.println`, 배열 응용, 객체 모델링
* **주요 내용**:
  * 콘솔 입력(`ScannerTest01`)과 1차원 `boolean` 배열을 결합한 **좌석 예약 시스템(`ArrayTest03`)** 구현.
  * 도메인 객체(`Movie`, `Author`, `Homeplus`)의 필드/메서드 설계 및 기초 문법 자가진단.

---

### **Ch02. 의존성 주입(DI) 기초 — 메모장 미니 프로젝트 (`MemoApplication`)**
* **핵심 키워드**: `Entity` - `Repository` - `Service` - `View`, **DI(Dependency Injection)**
* **주요 내용**:
  * 클래스 내부에서 직접 `new`로 의존 객체를 생성하지 않고, **외부(`MemoApplication`)에서 생성자를 통해 주입**해 주는 구조.
  ```java
  MemoRepository repo = new MemoRepository();
  MemoService service = new MemoService(repo); // 저장소 주입(DI)
  MemoView view = new MemoView(service);       // 서비스 주입(DI)
  ```

---

### **Ch03. JVM 메모리 구조 & 접근 제어자(캡슐화)**
* **핵심 키워드**: `Method Area(static)`, `Heap(new)`, `Stack`, `private`, `getter/setter`
* **주요 내용**:
  * **메모리 3영역**:
    * **Method Area (`static`)**: 클래스 로딩 시 생성되어 모든 인스턴스가 공유하는 공용 영역 (`StaticBasic`).
    * **Heap Area (`new`)**: 생성된 객체(인스턴스)가 실제로 저장되는 공간.
    * **Stack Area**: 메서드 호출 시 지역 변수와 참조 주소값이 저장되었다가 메서드 종료 시 사라지는 공간.
  * **캡슐화 (`access/`, `Visitor.java`)**: 필드는 `private`으로 외부 직접 접근을 막고, `getter/setter`나 검증 메서드(`moneyCheck`)를 통해서만 안전하게 값을 다루도록 설계.

---

### **Ch04. 배열(Array) 심화 (`ArrayMain01 ~ 04`)**
* **핵심 키워드**: 고정 길이 자료구조, 인덱스(`0 ~ length-1`), 2차원 배열, 참조 주소 복사
* **주요 내용**:
  * 배열은 생성 시 크기가 고정되며, 변수에는 배열의 실제 값이 아닌 **Heap 메모리 주소값**이 저장됨.
  * 1차원 및 다차원 배열 선언, 초기화, 반복문 순회 패턴 실습.

---

### **Ch05. 제어문 응용 & 동적 배열 확장 (`ControlMain ~ 7`)**
* **핵심 키워드**: `if-else`, `switch-case`, `for`, `while`, `break / continue`, 배열 크기 확장
* **주요 내용**:
  * **`switch ~ case` (`ControlMain2`)**: 일치하는 `case`로 바로 이동하며, `break`가 없으면 아래 `case`까지 연속 실행됨.
  * **동적 배열 확장 (`ControlMain6`)**: 고정 배열이 꽉 찼을 때 **더 큰 새 배열을 만들어 기존 데이터를 복사해 옮기는 원리** 구현 (`ArrayList`의 내부 동작 원리).

---

### **Ch06. 메서드와 생성자 (`Method01 ~ 03`)**
* **핵심 키워드**: 매개변수(Parameter), 반환값(`return`), **오버로딩(Overloading)**, 생성자 `this()`
* **주요 내용**:
  * **메서드 오버로딩**: 메서드 이름은 같지만 **매개변수의 타입, 개수, 순서**를 다르게 정의하여 다양한 입력을 처리하는 기법.
  * **생성자 체이닝(`this()`)**: 생성자 안에서 다른 생성자를 호출해 초기화 코드 중복을 제거.

---

### **Ch07. 객체지향 4대 원칙(상속·추상화·다형성) & `List` 기초**
* **핵심 키워드**: `extends`, `super()`, `abstract class`, `interface`, 업캐스팅/다운캐스팅, `instanceof`
* **주요 내용**:
  * **상속과 `super`**: 자식 객체 생성 시 부모 생성자(`super()`)가 먼저 실행됨.
  * **다형성(Polymorphism)**:
    * **업캐스팅**: `부모타입 변수 = new 자식객체();` (여러 자식 객체를 하나의 부모 리스트 `List<부모>`로 묶어서 관리 가능).
    * **다운캐스팅**: 자식의 고유 기능을 쓸 때 `if (obj instanceof 자식타입)`으로 확인 후 안전하게 형변환.
  * **추상 클래스 vs 인터페이스**:
    * `abstract class`(`extends`): 공통 필드와 일반 메서드를 물려주면서 일부 추상 메서드 구현 강제 (단일 상속).
    * `interface`(`implements`): 구현 강제를 위한 기능 규격서, 다중 구현 가능 (`default` 메서드 지원).
  * 📖 상세 노트: [`src/main/java/com/korai/ch07/README.md`](file:///Users/kangminjae/Documents/gov/java/study/src/main/java/com/korai/ch07/README.md)

---

### **Ch08. 최상위 `Object` 클래스 (`Object01 ~ 02`)**
* **핵심 키워드**: `toString()`, `equals()`, `hashCode()`, 동일성(`==`) vs 동등성(`equals`)
* **주요 내용**:
  * **`toString()`**: 객체 출력 시 메모리 주소 대신 내부 필드 값을 문자열로 보여주도록 오버라이딩.
  * **`==` vs `equals()`**: `==`는 두 객체의 **메모리 주소**가 같은지 비교하고, `equals()`는 객체 안의 **실제 데이터(값)**가 같은지 비교.
  * **`hashCode()`**: `equals()`가 `true`이면 `hashCode()` 값도 같아야 함 (`HashSet`, `HashMap`에서 중복 판별 기준).

---

### **Ch09. 실무 계층형 아키텍처 & Lombok (`CarMain`)**
* **핵심 키워드**: `@Data`, `@AllArgsConstructor`, `@NoArgsConstructor`, 3계층 분리
* **주요 내용**:
  * **Lombok**: 어노테이션만으로 `Getter`, `Setter`, `toString`, `equals`, `hashCode`, 생성자를 자동 생성.
  * **역할 분리**: `Car`(데이터 엔티티) ↔ `CarRepository`(배열/리스트 저장 및 조회) ↔ `InitService`(비즈니스 처리).

---

### **Ch10. 디자인 패턴(싱글톤) & 실전 도메인 프로젝트 (`TODO`, `hotel`, `library`, `parking`)**
* **핵심 키워드**: **Singleton 패턴**, `Enum`, 세션 인증(`SecurityConfig`), `RootRouter`
* **주요 내용**:
  * **싱글톤 패턴 (`SingletonMain`)**: 생성자를 `private`으로 막고 `getInstance()`로 프로그램 전체에서 **단 1개의 객체만 공유**해 메모리 낭비를 방지.
  * **실전 Todo 콘솔 앱 (`ch10/TODO`)**:
    * `View` ↔ `RootRouter`(화면 전환) ↔ `Service` ↔ `Repository` ↔ `Entity` 구조.
    * `SecurityConfig`: 로그인 성공 시 `UUID@userId` 토큰을 발급해 내 할 일만 조회/등록.
    * `TodoStatus(Enum)`: 할 일 상태를 `[진행전 / 진행중 / 완료]` 3가지로 안전하게 제한.
  * **도메인 연습 3종**: 호텔 객실 관리(`hotel`), 도서관 대출/반납(`library`), 주차장 요금 정산(`parking`).

---

### **Ch11. 싱글톤 View 리스트 기반 화면 라우팅 (`TodoMain`, `StudentMain`)**
* **핵심 키워드**: `List<View>`, `pathIndex`, 싱글톤 View 재사용
* **주요 내용**:
  * `HomeView`, `RegisterView`, `ListView`를 각각 싱글톤(`getHomeView()` 등)으로 만들어 `viewList`에 등록.
  * `while (running)` 루프 안에서 `viewList.get(pathIndex).show()`를 실행하고, 메뉴 선택에 따라 `pathIndex`(0, 1, 2)만 변경하여 화면을 전환하는 패턴.

---

### **Ch12. 컬렉션 프레임워크 심화 & 연결 리스트 직접 구현 (`CollectionMain01 ~ 09`)**
* **핵심 키워드**: `List`, `Set`, `Map`, `Node<E>`, `CustomLinkedList`, `RuntimeException`, `entrySet()`
* **주요 내용**:
  1. **컬렉션 3대 인터페이스**:
     * **`List` (`ArrayList`, `LinkedList`)**: 순서(인덱스) 있음, 데이터 중복 허용.
     * **`Set` (`HashSet`, `TreeSet`)**: 순서 없음, **데이터 중복 불가** (`TreeSet`은 자동 정렬).
     * **`Map` (`HashMap`, `LinkedHashMap`, `TreeMap`)**: **`Key : Value` 쌍**으로 저장 (Key는 중복 불가, `TreeMap`은 Key 기준 정렬).
  2. **`CustomLinkedList<E>` 직접 구현 (`CollectionMain02`)**:
     * 내부 정적 클래스 `Node<E>`에 `item`(값)과 `next`(다음 노드 주소)를 두고 `head`와 `tail`을 이어 붙이는 단방향 연결 리스트 구현.
  3. **커스텀 예외 (`CollectionMain04`)**: `RuntimeException`을 상속받아 사용자 정의 예외 클래스 생성 및 `throw` 실습.
  4. **중첩 컬렉션 & `entrySet()` (`CollectionMain09`)**:
     * `List<Map<String, Map<...>>>` 구조에서 `keySet()` 중첩 반복문과 `(Student)` 다운캐스팅으로 내부 객체 데이터 추출.
     * `Map.Entry<K, V>`와 `ages.entrySet()`을 사용해 Key와 Value를 동시에 순회.

---

### **Ch13. 익명 클래스(Anonymous Class) & 람다식(Lambda) (`AnonymousClass01~02`, `Lambda01~03`)**
* **핵심 키워드**: 일회성 익명 구현 객체, `@FunctionalInterface`, 람다 축약 규칙, 표준 함수형 인터페이스 5종
* **주요 내용**:
  1. **익명 클래스 (`AnonymousClass01~02`)**: 재사용하지 않고 1회성으로 쓸 인터페이스/추상클래스(예: 버튼 클릭 이벤트 `MouseEvent`)를 별도 클래스 파일 없이 `new 인터페이스() { @Override ... }`로 즉석 생성.
  2. **람다식 문법 규칙 (`Lambda01~02`)**:
     * **사용 조건**: 인터페이스에 **추상 메서드가 딱 1개**만 있어야 함.
     * 기본 형태: `(매개변수) -> { 실행문; }`
     * 실행문이 1줄이면 `{}` 생략 가능, `return`문 1줄이면 `{}`와 `return`을 함께 생략 가능.
  3. **자바 내장 함수형 인터페이스 5종 (`Lambda03`)**:
     * **`Runnable`**: `() -> void` (매개변수 X, 반환값 X / `.run()`)
     * **`Supplier<T>`**: `() -> T` (매개변수 X, 값 공급 / `.get()`)
     * **`Consumer<T>`**: `T -> void` (매개변수 소비, 반환값 X / `.accept(t)`)
     * **`Function<T, R>`**: `T -> R` (T를 받아 R로 변환 / `.apply(t)`)
     * **`Predicate<T>`**: `T -> boolean` (조건이 맞는지 판별 / `.test(t)`)

---

### **Ch14. Stream API & `CustomStream<T>` 구현 (`Stream01 ~ 03`)**
* **핵심 키워드**: `stream()`, 중간 연산(`filter`, `map`), 최종 연산(`toList`, `forEach`), `CustomStream`
* **주요 내용**:
  * **Stream 파이프라인 3단계**: `생성(stream())` → `중간 연산(filter, map)` → `최종 연산(toList())`. (스트림은 1회용이며 원본 데이터를 변경하지 않음).
  * **주요 연산**:
    * `.filter(n -> 조건식)`: 조건(`Predicate`)이 `true`인 요소만 걸러냄.
    * `.map(n -> 변환식)`: 요소를 다른 값이나 DTO 객체(`User` → `UserDto`)로 변환(`Function`).
  * **`CustomStream<T>` 직접 구현 (`Stream03`)**: 제네릭 클래스에 `filter(Predicate<T>)`와 `map(Function<T, R>)`을 직접 만들어보며 스트림 체이닝 동작 원리 이해.

---

### **🌐 Servlet 웹 서버 & 🗄️ MySQL(JDBC) 데이터베이스 연동 (`servlet-study-basic`, `servlet-jdbc-study`)**
* **핵심 키워드**: `@WebServlet`, `doGet/doPost`, `forward`, `Jackson`, `Filter`, `DriverManager`, `PreparedStatement`, `ResultSet`
* **주요 내용**:
  1. **Servlet MVC & REST API**:
     * **생명주기**: `init()`(최초 1회) → `doGet()` / `doPost()`(요청마다 실행) → `destroy()`(종료 시 1회).
     * **View 포워딩**: `req.setAttribute()`로 데이터를 담고 `req.getRequestDispatcher("/WEB-INF/views/...jsp").forward(req, resp)`로 JSP 화면 출력.
     * **JSON REST API**: `Jackson ObjectMapper`로 요청 JSON을 객체로 읽고(`readValue`), 응답 객체를 JSON으로 변환.
     * **공통 필터**: `Utf8EncodingFilter`(한글 인코딩 처리), `CorsFilter`(프론트엔드 CORS 허용).
  2. **MySQL + IntelliJ Java JDBC 연동 (`database/DBConnectionTest.java`, `Menu.java`)**:
     * **URL 형식**: `jdbc:mysql://localhost:3306/hanip_delivery02`
     * **`try-with-resources`**: `try (Connection conn = DriverManager.getConnection(...))`를 사용하여 DB 작업이 끝나면 **커넥션 객체를 자동으로 소멸(`close`)**시켜 다른 연결이 가능하도록 보장.
     * **쿼리 실행 및 `ResultSet` 매핑**:
       ```java
       try (Connection connection = DriverManager.getConnection(url, username, password)) {
           PreparedStatement pstmt = connection.prepareStatement("select * from menus");
           ResultSet rs = pstmt.executeQuery(); // 조회 결과를 rs에 담음

           while (rs.next()) { // 다음 행(Row)을 한 줄씩 가져오며 Menu 객체 생성
               Menu menu = new Menu(
                       rs.getInt("menu_id"),
                       rs.getInt("restaurant_id"),
                       rs.getString("name"),
                       rs.getInt("price"),
                       rs.getString("description"),
                       rs.getBoolean("is_signature"),
                       rs.getBoolean("is_sold_out")
               );
               menus.add(menu);
           }
       }
       ```

---

## 🚀 실행 방법

```bash
# 전체 컴파일
mvn clean compile

# [Ch02] 메모장 앱 실행
mvn exec:java -Dexec.mainClass="com.korai.ch02.practice.MemoApplication"

# [Ch10] 콘솔 Todo 앱 실행
mvn exec:java -Dexec.mainClass="com.korai.ch10.TODO.TodoApplication"
```
