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
* **💻 핵심 예제 코드 (`ArrayTest03.java` - 좌석 예약 원리)**:
  ```java
  boolean[] seats = new boolean[10]; // false: 빈자리(□), true: 예약됨(■)
  Scanner sc = new Scanner(System.in);

  int choiceNum = sc.nextInt();      // 사용자가 선택한 좌석 번호 (1~10)
  // 배열 인덱스는 0부터 시작하므로 choiceNum - 1 로 접근!
  if (seats[choiceNum - 1] == true) {
      System.out.println("이미 예약된 좌석입니다.");
  } else {
      seats[choiceNum - 1] = true;   // 빈자리면 true로 상태 변경
      System.out.println(choiceNum + "번 좌석 예약되었습니다.");
  }
  ```

---

### **Ch02. 의존성 주입(DI) 기초 — 메모장 미니 프로젝트 (`MemoApplication`)**
* **핵심 키워드**: `Entity` - `Repository` - `Service` - `View`, **DI(Dependency Injection)**
* **주요 내용**:
  * 클래스 내부에서 직접 `new`로 의존 객체를 생성하지 않고, **외부(`MemoApplication`)에서 생성자를 통해 주입**해 주는 구조.
* **💻 핵심 예제 코드 (`MemoApplication.java`, `MemoService.java`)**:
  ```java
  // 1) 외부(Application)에서 부품을 조립해서 넣어줌 (DI)
  MemoRepository repo = new MemoRepository();
  MemoService service = new MemoService(repo); // 저장소 주입(DI)
  MemoView view = new MemoView(service);       // 서비스 주입(DI)

  // 2) Service는 밖에서 건네준 repo를 받아서 쓰기만 함
  public class MemoService {
      private final MemoRepository memoRepository;

      public MemoService(MemoRepository memoRepository) {
          this.memoRepository = memoRepository; // 외부에서 주입받은 객체 연결
      }
  }
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
* **💻 핵심 예제 코드 (`StaticBasic.java` & `Visitor.java`)**:
  ```java
  // [1. static 공용 변수 vs 인스턴스 개인 변수]
  class 학생관리시스템 {
      static int 년도 = 2026; // Method Area에 딱 1개 생성 (모두가 공유)
      static int 번호 = 1;    // 학생이 추가될 때마다 1, 2, 3... 공용 카운트 증가

      static 학생 학생추가(String 이름) {
          return new 학생(년도 * 10000 + 번호++, 이름); // new -> Heap 메모리에 학생 생성
      }
  }

  // [2. 캡슐화: private으로 숨기고 메서드로 안전하게 접근]
  public class Visitor {
      private String name;    // 외부에서 visitor.haveMoney = -9999 처럼 직접 조작 불가!
      private int haveMoney;

      public void moneyCheck(int price) {
          if (haveMoney < price) {
              System.out.println("비용이 부족해 이용하실 수 없습니다");
          }
      }
  }
  ```

---

### **Ch04. 배열(Array) 심화 (`ArrayMain01 ~ 04`)**
* **핵심 키워드**: 고정 길이 자료구조, 인덱스(`0 ~ length-1`), 2차원 배열, 참조 주소 복사
* **주요 내용**:
  * 배열은 생성 시 크기가 고정되며, 변수에는 배열의 실제 값이 아닌 **Heap 메모리 주소값**이 저장됨.
  * 1차원 및 다차원 배열 선언, 초기화, 반복문 순회 패턴 실습.
* **💻 핵심 예제 코드 (`ArrayMain01.java` - 배열의 주소 참조 원리)**:
  ```java
  Student[] students = new Student[4];
  students[0] = new Student();
  students[0].name = "강민재";

  // 배열 변수를 대입하면 값 복사가 아니라 '같은 Heap 메모리 주소'를 가리킴(얕은 복사)!
  Student[] students2 = students;
  students2[0].name = "이름변경";
  // students[0].name 도 함께 "이름변경"으로 바뀜 (같은 집 주소를 바라보고 있으므로)
  ```

---

### **Ch05. 제어문 응용 & 동적 배열 확장 (`ControlMain ~ 7`)**
* **핵심 키워드**: `if-else`, `switch-case`, `for`, `while`, `break / continue`, 배열 크기 확장
* **주요 내용**:
  * **`switch ~ case` (`ControlMain2`)**: 일치하는 `case`로 바로 이동하며, `break`가 없으면 아래 `case`까지 연속 실행됨.
  * **동적 배열 확장 (`ControlMain6`)**: 고정 배열이 꽉 찼을 때 **더 큰 새 배열을 만들어 기존 데이터를 복사해 옮기는 원리** 구현 (`ArrayList`의 내부 동작 원리).
* **💻 핵심 예제 코드 (`ControlMain6.java` - 배열 칸수 자동으로 늘리기)**:
  ```java
  String[] names = new String[0]; // 처음엔 0칸짜리 배열

  // 새 이름을 추가할 때마다 기존보다 1칸 더 큰 새 배열을 생성!
  String[] newNames = new String[names.length + 1];

  // 1) 기존 배열에 있던 값들을 새 배열로 그대로 이사시킴
  for (int i = 0; i < names.length; i++) {
      newNames[i] = names[i];
  }
  // 2) 새로 생긴 마지막 빈칸에 새 데이터 넣기
  newNames[newNames.length - 1] = "새이름";

  // 3) names 변수가 새 배열의 주소를 가리키도록 교체 (헌 배열은 GC가 정리)
  names = newNames;
  ```

---

### **Ch06. 메서드와 생성자 (`Method01 ~ 03`)**
* **핵심 키워드**: 매개변수(Parameter), 반환값(`return`), **오버로딩(Overloading)**, 생성자 `this()`
* **주요 내용**:
  * **메서드 오버로딩**: 메서드 이름은 같지만 **매개변수의 타입, 개수, 순서**를 다르게 정의하여 다양한 입력을 처리하는 기법.
  * **생성자 체이닝(`this()`)**: 생성자 안에서 다른 생성자를 호출해 초기화 코드 중복을 제거.
* **💻 핵심 예제 코드 (`Method02.java` - 오버로딩과 생성자 `this()`)**:
  ```java
  // 1) 메서드 오버로딩: 이름은 add로 같지만 매개변수 구성이 다름
  int add(int a, int b) { return a + b; }
  int add(int a, int b, int c) { return a + b + c; }
  double add(double a, double b) { return a + b; }

  // 2) 생성자 체이닝: this()로 기존 생성자 재사용
  class Student {
      final int code;
      final String name;
      String address;

      public Student(int code, String name) {
          this.code = code;
          this.name = name;
      }
      public Student(int code, String name, String address) {
          this(code, name); // 위의 2개짜리 생성자를 먼저 호출! (코드 중복 제거)
          this.address = address;
      }
  }
  ```

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
* **💻 핵심 예제 코드 (`AbstractMain04~06.java` - 업캐스팅과 안전한 다운캐스팅)**:
  ```java
  abstract class Animal {
      abstract void sound(); // 자식이 반드시 오버라이딩해야 하는 추상 메서드
  }
  class Dog extends Animal {
      @Override void sound() { System.out.println("멍멍!"); }
      void bark() { System.out.println("강아지 고유 기능: 꼬리 흔들기"); }
  }

  // 1) 업캐스팅: 부모 타입으로 자식 객체를 담음
  Animal a = new Dog();
  a.sound(); // "멍멍!" (동적 바인딩: 실제 자식 객체의 오버라이딩된 메서드가 실행됨)

  // 2) 다운캐스팅: 자식 고유 메서드(bark)를 부르려면 instanceof 확인 후 형변환!
  if (a instanceof Dog) {
      Dog d = (Dog) a;
      d.bark();
  }
  ```

---

### **Ch08. 최상위 `Object` 클래스 (`Object01 ~ 02`)**
* **핵심 키워드**: `toString()`, `equals()`, `hashCode()`, 동일성(`==`) vs 동등성(`equals`)
* **주요 내용**:
  * **`toString()`**: 객체 출력 시 메모리 주소 대신 내부 필드 값을 문자열로 보여주도록 오버라이딩.
  * **`==` vs `equals()`**: `==`는 두 객체의 **메모리 주소**가 같은지 비교하고, `equals()`는 객체 안의 **실제 데이터(값)**가 같은지 비교.
  * **`hashCode()`**: `equals()`가 `true`이면 `hashCode()` 값도 같아야 함 (`HashSet`, `HashMap`에서 중복 판별 기준).
* **💻 핵심 예제 코드 (`Object02.java` - 주소 비교 vs 값 비교)**:
  ```java
  Student s1 = new Student("강민재", 26);
  Student s2 = new Student("강민재", 26); // s1과 내용은 같지만 new로 새로 만든 다른 객체

  System.out.println(s1 == s2);                  // false (힙 메모리 주소가 다름)
  System.out.println(s1.equals(s2));             // true  (내부 필드 값이 같음)
  System.out.println(s1.hashCode() == s2.hashCode()); // true  (Objects.hash("강민재", 26) 기반 동일한 해시값)
  ```

---

### **Ch09. 실무 계층형 아키텍처 & Lombok (`CarMain`)**
* **핵심 키워드**: `@Data`, `@AllArgsConstructor`, `@NoArgsConstructor`, 3계층 분리
* **주요 내용**:
  * **Lombok**: 어노테이션만으로 `Getter`, `Setter`, `toString`, `equals`, `hashCode`, 생성자를 자동 생성.
  * **역할 분리**: `Car`(데이터 엔티티) ↔ `CarRepository`(배열/리스트 저장 및 조회) ↔ `InitService`(비즈니스 처리).
* **💻 핵심 예제 코드 (`Car.java` & `CarMain.java`)**:
  ```java
  @Data                 // Getter, Setter, toString, equals, hashCode 자동 생성!
  @AllArgsConstructor   // 모든 필드를 받는 생성자 자동 생성
  @NoArgsConstructor    // 기본 생성자 자동 생성
  public class Car {
      private Long id;
      private String carNumber;
      private String model;
      private String owner;
  }

  // 실행부에서는 역할이 분리된 Repository의 메서드를 호출해 등록/삭제/출력
  Car car = new Car(null, "15노 6810", "쏘나타Dn8", "강민재");
  InitService.getCarRepository().insert(car);
  InitService.getCarRepository().printAll();
  ```

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
* **💻 핵심 예제 코드 (`SingletonMain.java` - 싱글톤 공식 3단계)**:
  ```java
  class StudentService {
      // 1) 유일한 객체를 담아둘 static 변수 선언
      private static StudentService instance;

      // 2) 외부에서 new StudentService()를 못 하도록 생성자를 private으로 잠금!
      private StudentService() {}

      // 3) 오직 이 static 메서드를 통해서만 단 1개의 객체를 꺼내갈 수 있음
      public static StudentService getInstance() {
          if (instance == null) {               // 최초 호출 시에만 딱 1번 생성
              instance = new StudentService();
          }
          return instance;                      // 이후에는 이미 만들어진 객체 반환
      }
  }
  ```

---

### **Ch11. 싱글톤 View 리스트 기반 화면 라우팅 (`TodoMain`, `StudentMain`)**
* **핵심 키워드**: `List<View>`, `pathIndex`, 싱글톤 View 재사용
* **주요 내용**:
  * `HomeView`, `RegisterView`, `ListView`를 각각 싱글톤(`getHomeView()` 등)으로 만들어 `viewList`에 등록.
  * `while (running)` 루프 안에서 `viewList.get(pathIndex).show()`를 실행하고, 메뉴 선택에 따라 `pathIndex`(0, 1, 2)만 변경하여 화면을 전환하는 패턴.
* **💻 핵심 예제 코드 (`StudentMain.java` - 인덱스 기반 화면 전환)**:
  ```java
  public class StudentMain {
      public static int pathIndex = 0;      // 현재 보여줄 화면 번호 (0: 홈, 1: 등록, 2: 목록)
      public static boolean running = true;

      public static void main(String[] args) {
          List<View> viewList = new ArrayList<>();
          viewList.add(HomeView.getHomeView());         // index 0
          viewList.add(RegisterView.getRegisterView()); // index 1
          viewList.add(ListView.getListView());         // index 2

          while (running) {
              // pathIndex 번호만 바꾸면 다음 루프에서 해당 화면의 show()가 실행됨!
              viewList.get(pathIndex).show();
          }
      }
  }
  ```

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
* **💻 핵심 예제 코드 (`CollectionMain02, 04, 09.java`)**:
  ```java
  // [1. CustomLinkedList의 노드(Node) 연결 구조]
  class CustomLinkedList<E> {
      private static class Node<E> {
          E item;         // 실제 데이터
          Node<E> next;   // 다음 노드의 주소를 가리키는 포인터
      }
      private Node<E> head;
      private Node<E> tail;
  }

  // [2. 나만의 커스텀 예외 클래스 정의]
  class 내가만든예외 extends RuntimeException {
      public 내가만든예외(String message) {
          super(message); // 부모(RuntimeException)에게 에러 메시지 전달
      }
  }

  // [3. Map에서 entrySet()으로 Key와 Value 한 번에 꺼내기]
  Map<String, Integer> ages = Map.of("강민재", 26, "강민재1", 27);
  for (Map.Entry<String, Integer> entry : ages.entrySet()) {
      System.out.println(entry.getKey() + " : " + entry.getValue());
  }
  ```

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
* **💻 핵심 예제 코드 (`AnonymousClass02.java` & `Lambda02~03.java`)**:
  ```java
  // 1) 익명 클래스: 클래스를 따로 안 만들고 그 자리에서 바로 구현해서 생성
  Button loginButton = new Button("로그인", new MouseEvent() {
      @Override
      public void click() {
          System.out.println("로그인 되었습니다");
      }
  });

  // 2) 람다식 축약: (매개변수) -> 반환식 (return과 {} 동시 생략!)
  Calculator calc = (x, y) -> x + y;

  // 3) 표준 함수형 인터페이스 5종 활용
  Runnable runnable = () -> System.out.println("실행!");     // runnable.run()
  Supplier<Integer> supplier = () -> 1000;                   // supplier.get() -> 1000
  Consumer<String> consumer = msg -> System.out.println(msg);// consumer.accept("안녕")
  Function<Integer, Integer> func = n -> n * 10;             // func.apply(5) -> 50
  Predicate<Integer> isEven = n -> n % 2 == 0;               // isEven.test(4) -> true
  ```

---

### **Ch14. Stream API & `CustomStream<T>` 구현 (`Stream01 ~ 03`)**
* **핵심 키워드**: `stream()`, 중간 연산(`filter`, `map`), 최종 연산(`toList`, `forEach`), `CustomStream`
* **주요 내용**:
  * **Stream 파이프라인 3단계**: `생성(stream())` → `중간 연산(filter, map)` → `최종 연산(toList())`. (스트림은 1회용이며 원본 데이터를 변경하지 않음).
  * **주요 연산**:
    * `.filter(n -> 조건식)`: 조건(`Predicate`)이 `true`인 요소만 걸러냄.
    * `.map(n -> 변환식)`: 요소를 다른 값이나 DTO 객체(`User` → `UserDto`)로 변환(`Function`).
  * **`CustomStream<T>` 직접 구현 (`Stream03`)**: 제네릭 클래스에 `filter(Predicate<T>)`와 `map(Function<T, R>)`을 직접 만들어보며 스트림 체이닝 동작 원리 이해.
* **💻 핵심 예제 코드 (`Stream02~03.java` - Stream 파이프라인 & `CustomStream` 내부 원리)**:
  ```java
  List<Integer> nums = List.of(5, 2, 10, 30, 22, 33, 50, 53);

  // 1) filter로 5의 배수만 걸러내어 새 리스트로 만들기
  List<Integer> fiveList = nums.stream()
          .filter(n -> n % 5 == 0)                 // [5, 10, 30, 50] 통과
          .toList();

  // 2) map으로 데이터를 가공/변환하기 (User 엔티티 -> UserDto 변환 등)
  List<UserDto> dtos = users.stream()
          .filter(user -> user.getRole().getName().equals("ADMIN")) // 관리자만 필터링
          .map(UserDto::from)                                       // User -> UserDto 변환
          .toList();

  // 3) 직접 만든 CustomStream의 filter 내부 구조
  public CustomStream<T> filter(Predicate<T> predicate) {
      List<T> newList = new ArrayList<>();
      for (T item : list) {
          if (predicate.test(item)) { // 람다 조건식이 true인 것만 새 리스트에 담음!
              newList.add(item);
          }
      }
      return new CustomStream<>(newList); // 체이닝을 위해 새 CustomStream 반환
  }
  ```

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

---

# 🌐 Servlet & REST API & Filter 완전 정복 (전체 내용 총정리)

---

## 📚 [Step 0] 용어 사전: 이것만 알면 시작할 수 있다

> 🍜 **식당 비유로 기억하기**
> 손님(브라우저)이 주문서(요청)를 내면 → 매니저(톰캣)가 받아서 → 담당 요리사(서블릿)에게 넘기고 → 요리사가 접시(응답)에 음식을 담으면 → 매니저가 손님에게 가져다줍니다.

| 용어 | 쉬운 뜻 | 식당 비유 |
|---|---|---|
| **클라이언트** | 서비스를 요청하는 쪽. 보통 **브라우저(크롬)** | 손님 |
| **서버** | 요청을 받아 처리해주는 컴퓨터/프로그램 | 식당 |
| **요청 (Request)** | 브라우저가 서버에 보내는 메시지. "이 주소 화면 주세요 + 추가 정보" | 주문서 |
| **응답 (Response)** | 서버가 브라우저에 돌려주는 메시지. 보통 화면에 그릴 글자(HTML/JSON) | 음식이 담긴 접시 |
| **HTTP** | 브라우저와 서버가 대화하는 **규칙**. 주문서 양식이라고 생각하면 됨 | 주문서 양식 |
| **URL** | 주소. 예: `http://localhost:8080/servlet_study/hello` | 메뉴판의 메뉴 위치 |
| **톰캣 (Tomcat)** | 요청을 받아서 알맞은 서블릿을 실행해주는 프로그램 (WAS) | 매니저 |
| **서블릿 (Servlet)** | 요청을 처리하는 **자바 클래스**. 우리가 직접 작성하는 부분 | 요리사 |
| **HTML / JSP** | 브라우저가 화면을 그릴 때 읽는 문서. `<h1>제목</h1>`처럼 **태그**로 감쌈 | 음식 담는 모양 |
| **파라미터** | 요청에 같이 보내는 추가 정보. `?name=민재` 에서 이름 `name`, 값 `민재` | 주문서의 "맵기: 보통" 같은 메모 |
| **어노테이션** | `@Override` 같은 **`@` 표시**. 컴퓨터에게 주는 메모. 서블릿에선 `@WebServlet`을 씀 | 요리사 이름표 |

### 🔤 HTML 3분 속성 강의
HTML은 **`<태그>내용</태그>`** 모양으로 씁니다. 여는 태그와 닫는 태그(`/` 붙음) 사이에 내용을 넣어요.
```html
<h1>큰 제목</h1>          <!-- h1 = heading 1 = 가장 큰 제목 글씨 -->
<p>일반 문장</p>           <!-- p = paragraph = 문단 -->
첫 줄<br>둘째 줄           <!-- br = 줄바꿈. 닫는 태그 없이 혼자 씀 -->
<b>굵게</b>                <!-- b = bold = 굵은 글씨 -->
<a href="/hello">이동</a>  <!-- a = 링크. 클릭하면 href에 적힌 주소로 이동 -->
<!-- 이렇게 생긴 건 HTML 주석. 화면에 안 보임 (자바의 // 와 같음) -->
```

---

## 📌 [Step 1] 첫 서블릿 & 생명주기 (Lifecycle)

### 📖 개념 핵심
1. **서블릿에는 `main()`이 없다**: 톰캣이 알아서 객체를 만들고(`new`), 요청이 오면 메서드를 호출해 줍니다. 우리는 "요청이 오면 할 일"만 메서드(`doGet`, `doPost`) 안에 적으면 됩니다.
2. **상속 구조**:
   ```text
   HttpServlet (톰캣이 제공하는 부모 클래스, 기본 기능이 다 들어 있음)
       ↑ extends (상속)
   MyServlet   (내가 만드는 자식 클래스. 필요한 메서드만 @Override)
   ```
3. **생명주기 = 서블릿 객체의 일생**:

| 순서 | 메서드 | 언제 호출? | 몇 번? | 식당 비유 |
|---|---|---|---|---|
| 1 | `init()` | 첫 요청이 왔을 때 객체 만든 직후 | **딱 1번** | 요리사 출근해서 앞치마 입기 (`BookService.getInstance()` 등 초기화) |
| 2 | `doGet()` / `doPost()` | 요청이 올 때마다 | **요청마다 계속** | 주문 들어올 때마다 요리 |
| 3 | `destroy()` | 톰캣이 꺼질 때 | **딱 1번** | 퇴근하며 정리 |

4. **⚠️ 요리사는 딱 1명 (싱글톤과 동일!)**:
   손님이 100명 와도 서블릿 **객체는 1개만** 만들어집니다. 따라서 **필드(클래스 맨 위 변수)에 손님 정보를 저장하면 손님끼리 데이터가 섞입니다.** 손님 정보는 항상 **메서드 안의 지역 변수**에 두어야 합니다.

### 🛠️ 실습 1-1. 첫 서블릿 (`HelloServlet`)
```java
@WebServlet("/hello2")                    // "주소 끝이 /hello2인 요청은 이 클래스가 처리한다"는 이름표
public class HelloServlet2 extends HttpServlet {   // HttpServlet을 상속받아야 톰캣이 서블릿으로 인정함

    @Override
    protected void doGet(HttpServletRequest req,    // req  = 톰캣이 만들어서 넘겨주는 주문서 (손님이 보낸 정보)
                         HttpServletResponse resp)  // resp = 톰캣이 넘겨주는 빈 접시 (여기에 결과를 담음)
            throws IOException {

        resp.setContentType("text/html; charset=UTF-8");
        // ↑ 브라우저에게 "지금 보내는 건 HTML이고, 글자는 UTF-8(한글 가능) 방식이야"라고 알려줌 (안 쓰면 한글 깨짐)

        PrintWriter out = resp.getWriter();
        // ↑ 접시(resp)에서 펜(PrintWriter)을 꺼냄.
        //   System.out.println()은 IntelliJ 콘솔에 찍히고, out.println()은 브라우저 화면에 찍힘!

        out.println("<h1>Hello Servlet!</h1>");
        out.println("<p>지금 시간: " + java.time.LocalDateTime.now() + "</p>");
    }
}
```

### 🛠️ 실습 1-2. 생명주기 눈으로 확인하기 (`LifeServlet`)
```java
@WebServlet("/life")
public class LifeServlet extends HttpServlet {
    @Override
    public void init() {                     // 객체가 처음 만들어진 직후 톰캣이 1번만 호출
        System.out.println("[init] 요리사 출근!");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("[doGet] 주문 처리 중");  // 새로고침(요청) 할 때마다 콘솔에 찍힘
        resp.getWriter().println("check console");
    }

    @Override
    public void destroy() {                  // 톰캣이 꺼질 때 1번만 호출
        System.out.println("[destroy] 요리사 퇴근!");
    }
}
```

---

## 📌 [Step 2] 손님이 보낸 정보 받기 (파라미터, GET vs POST)

### 📖 개념 핵심
1. **파라미터 = 주문서에 적힌 메모 (`.../greet?name=민재&age=20`)**:
   * `?` 뒤부터 파라미터 시작, `&`로 여러 개 연결.
   * 서블릿에서 꺼낼 때:
     ```java
     String name = req.getParameter("name"); // "민재"
     String age  = req.getParameter("age");  // "20" ← 숫자처럼 보여도 항상 String! 계산하려면 Integer.parseInt(age)
     ```
2. **HTML `<form>` 태그와 서블릿의 연결 고리**:
   ```html
   <form action="greet" method="get">   <!-- action: 어느 주소로 보낼지 / method: get 또는 post -->
       <input type="text" name="name">   <!-- ⭐ input의 name="name"과 req.getParameter("name")이 똑같아야 함! -->
       <button>보내기</button>
   </form>
   ```
3. **GET vs POST 완벽 비교**:

| 구분 | GET | POST |
|---|---|---|
| **데이터 위치** | 주소창 뒤에 `?name=민재`로 **보임** (Query String) | 주소창에 **안 보임** (HTTP Body 봉투 안에 넣어 전송) |
| **언제 쓰나** | 검색, 목록 조회, 상세 페이지 보기 | 로그인, 회원가입, 글쓰기, 데이터 등록/수정 |
| **서블릿 메서드** | `doGet()` | `doPost()` |
| **비유** | 엽서 (누구나 내용을 봄) | 봉투에 넣은 편지 |

4. **여러 개 선택하는 체크박스(`checkbox`) 받기**:
   * `<input type="radio" name="gender" value="M">`: 하나만 선택되므로 `req.getParameter("gender")` (`"M"`이 옴, 화면 글자가 아니라 `value` 값이 전송됨!)
   * `<input type="checkbox" name="hobby" value="game">`: 여러 개 선택 가능하므로 **`String[] hobbies = req.getParameterValues("hobby");`** (복수형 `s`, 아무것도 체크 안 하면 `null` 반환)
   * 아예 없는 파라미터 이름을 꺼내면 `null`, 빈칸으로 제출하면 `""`(빈 문자열)이 오므로 `if (id == null || id.isBlank())`로 검증!

---

## 📌 [Step 3] 다른 페이지로 넘기기: `forward` vs `redirect` (MVC 패턴의 핵심!)

### 📖 개념 핵심
서블릿(Controller)이 처리를 마친 뒤 **JSP 화면(View)이나 다른 서블릿에게 일을 넘기는 방법**은 2가지입니다.

| 구분 | `forward` (포워드) | `redirect` (리다이렉트) |
|---|---|---|
| **식당 비유** | 주방 안에서 몰래 B 요리사(JSP)에게 주문서를 넘김 | 손님에게 "B 창구로 다시 가세요"라고 안내함 |
| **브라우저 요청 횟수** | **1번** (손님은 내부에서 넘어간 줄 모름) | **2번** (브라우저가 새 주소로 다시 요청함) |
| **브라우저 주소창** | **안 바뀜** (`/book/list` 그대로 유지) | **바뀜** (`sendRedirect`에 적은 주소로 변경) |
| **`req.setAttribute` 포스트잇** | **유지됨!** (같은 `req` 주문서를 그대로 넘기므로) | **사라짐!** (`null` 됨, 새 요청이라 주문서가 새로 만들어짐) |
| **언제 쓰나** | **조회 화면(JSP) 보여줄 때** (`BookListViewController` 등) | **글쓰기/로그인/삭제 완료 후 목록이나 홈으로 이동시킬 때** |
| **핵심 코드** | `req.getRequestDispatcher("/WEB-INF/views/book-list.jsp").forward(req, resp);` | `resp.sendRedirect("login.html");` |

### 🛠️ `getParameter` vs `getAttribute` 차이
* **`req.getParameter("key")`**: **손님(브라우저)**이 보낸 값. 읽기만 가능하며 무조건 `String`.
* **`req.setAttribute("key", 값)` / `req.getAttribute("key")`**: **서블릿(요리사)**이 주문서에 붙이는 포스트잇. 다음 서블릿이나 JSP가 읽을 수 있으며 아무 객체(`Object`, `List<Book>` 등)나 붙일 수 있음.

```java
// [실제 프로젝트 예시: BookListViewController.java]
@WebServlet("/book/list")
public class BookListViewController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // WEB-INF 폴더 안의 JSP는 브라우저에서 직접 주소로 접속할 수 없고, 오직 서블릿이 forward 해줄 때만 열림! (보안성)
        req.getRequestDispatcher("/WEB-INF/views/book-list.jsp").forward(req, resp);
    }
}
```

---

## 📌 [Step 4] 손님 기억하기: 세션(`HttpSession`)과 3대 보관소(Scope)

### 📖 개념 핵심
1. **세션(Session) = 손님별 사물함**:
   * HTTP는 요청이 끝나면 손님을 잊어버리므로, 처음 온 손님에게 서버에 **사물함(`HttpSession`)**을 만들어주고 **사물함 열쇠 번호표(`JSESSIONID` 쿠키)**를 브라우저에게 줍니다.
   * **사물함(데이터)은 서버에** 있고, 브라우저는 **번호표(`JSESSIONID`)만** 들고 다닙니다.
2. **데이터 보관 장소 3가지 (Scope 비교)**:

| 보관 장소 (Scope) | 비유 | 유지 기간 | 공유 범위 | 코드 |
|---|---|---|---|---|
| **`request`** | 주문서 포스트잇 | 요청 1번 끝나면 소멸 (`forward` 시에는 유지) | 해당 요청 1개 | `req.setAttribute("cnt", r)` |
| **`session`** | **손님별 사물함** | 로그아웃(`invalidate`)하거나 30분간 안 오면 소멸 | **그 손님(같은 브라우저)만** | `req.getSession().setAttribute("loginId", id)` |
| **`application`** | 식당 입구 공용 게시판 | 톰캣 서버가 꺼질 때까지 유지 | **접속한 모든 손님 공유** | `getServletContext().setAttribute("cnt", a)` |

3. **세션 필수 코드 4줄**:
   ```java
   HttpSession session = req.getSession();                    // 1) 내 사물함 가져오기
   session.setAttribute("loginId", "admin");                  // 2) 사물함에 넣기 (로그인 처리)
   String loginId = (String) session.getAttribute("loginId"); // 3) 사물함에서 꺼내기 (Object -> String 다운캐스팅)
   session.invalidate();                                      // 4) 사물함 통째로 비우기 (로그아웃 처리)
   ```

---

## 📌 [Step 5] 실무형 JSON REST API 컨트롤러 & Jackson (`*ApiController`) 🌟

과거에는 서블릿이 HTML/JSP를 직접 만들어 보냈지만, 현대 웹 개발(React/JS Fetch 연동)에서는 **데이터만 JSON 문자열로 주고받는 REST API 방식**을 사용합니다. (`servlet-jdbc-study` 실습 내용)

### 📖 핵심 도구: `ObjectMapper` (Jackson 통역사)
* **`mapper.readValue(req.getInputStream(), 클래스.class)`**: 프론트엔드가 보낸 **JSON 글자 → 자바 객체**로 자동 변환(역직렬화)!
* **`mapper.writeValueAsString(자바객체)`** 또는 **`mapper.writeValue(resp.getWriter(), 자바객체)`**: **자바 객체/리스트 → JSON 글자**로 자동 변환(직렬화)하여 응답!

### 🛠️ 실전 코드 1: 상품 목록 조회(GET) & 등록(POST) API (`ProductApiController.java`)
```java
@WebServlet("/api/products")
public class ProductApiController extends HttpServlet {

    // [GET] 자바의 List<Product>를 JSON 배열 문자열로 바꿔서 브라우저에 응답
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> products = new ArrayList<>();
        products.add(new Product("상품1", 10000));
        products.add(new Product("상품2", 20000));

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(products); // 리스트 -> JSON 문자열 변환

        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().println(json);
    }

    // [POST] 프론트엔드가 보낸 JSON 데이터를 Product 자바 객체로 한 방에 읽기
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Product p = objectMapper.readValue(req.getInputStream(), Product.class); // JSON -> Product 객체 변환
        System.out.println(p);
    }
}
```

### 🛠️ 실전 코드 2: 중복 예외 처리(`DuplicatedException`)와 상태 코드 응답 (`UserApiController.java`)
```java
@WebServlet("/api/users")
public class UserApiController extends HttpServlet {
    private UserService userService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        userService = UserService.getInstance(); // 서블릿 출근(init) 시 싱글톤 서비스 연결
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        User user = objectMapper.readValue(req.getInputStream(), User.class);

        try {
            userService.register(user); // 비즈니스 로직 실행 (중복 시 DuplicatedException 발생)
            resp.setContentType("application/json");
            resp.setCharacterEncoding("UTF-8");
            resp.getWriter().println(objectMapper.writeValueAsString(Map.of("message", "사용자 등록성공")));
        } catch (DuplicatedException e) {
            resp.setContentType("application/json");
            resp.setCharacterEncoding("UTF-8");
            resp.setStatus(400); // 400 Bad Request 상태 코드 반환
            resp.getWriter().println(objectMapper.writeValueAsString(Map.of("message", e.getMessage())));
        }
    }
}
```

---

## 📌 [Step 6] 서블릿 필터(`Filter`)와 CORS & `web.xml` 설정 🌟

모든 서블릿마다 매번 `req.setCharacterEncoding("UTF-8")`과 CORS 허용 헤더를 복붙하는 것은 비효율적입니다. **서블릿에 들어가기 전(전처리)과 나온 후(후처리)에 공통 작업을 처리하는 문지기가 바로 `Filter`**입니다!

### 1) 한글 인코딩 필터 (`Utf8EncodingFilter.java`)
* `chain.doFilter(request, response);` **기준으로 위쪽이 전처리(서블릿 가기 전), 아래쪽이 후처리(서블릿 다녀온 후)**입니다.
```java
public class Utf8EncodingFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        // [전처리] 서블릿에 도착하기 전에 미리 UTF-8 인코딩 세팅!
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        chain.doFilter(request, response); // 다음 필터 또는 목적지 서블릿으로 통과!

        // [후처리] 서블릿 실행이 끝난 뒤 실행되는 영역
    }
}
```

### 2) CORS 허용 필터와 `OPTIONS` 정찰병 처리 (`CorsFilter.java`)
* **CORS란?**: 프론트엔드(예: `localhost:5500` Live Server)와 백엔드(`localhost:8080` Tomcat)의 주소(포트)가 다르면 브라우저가 보안상 요청을 차단합니다. 서버가 **"외부에서 오는 요청도 허용한다(`Access-Control-Allow-Origin: *`)"**고 문을 열어주어야 합니다.
* **왜 `OPTIONS` 메서드를 처리하나요? (Preflight 정찰병)**:
  * 브라우저가 `POST`로 JSON 데이터를 보내기 전에, 먼저 **`OPTIONS`라는 정찰병 요청**을 보내서 "나 여기에 POST로 JSON 보내도 돼?"라고 사전 검사를 합니다. 이때 `200 OK`로 정찰병을 돌려보내 주어야 본 요청(`POST`)이 정상적으로 들어옵니다!
```java
public class CorsFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        String method = req.getMethod();

        // 1) CORS 허용 헤더 부착
        resp.setHeader("Access-Control-Allow-Origin", "*");
        resp.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS");
        resp.setHeader("Access-Control-Allow-Headers", "Content-Type");

        // 2) 브라우저가 보낸 사전 검사(OPTIONS 정찰병)면 바로 200 OK 주고 돌려보냄
        if ("OPTIONS".equals(method)) {
            resp.setStatus(200);
            return;
        }

        chain.doFilter(request, response); // 본 요청(GET/POST)이면 서블릿으로 통과!
    }
}
```

### 3) `WEB-INF/web.xml` 필터 순서 매핑
* `@WebFilter` 어노테이션을 쓰면 필터 실행 순서를 정하기 어렵지만, `web.xml`에 등록하면 **적힌 순서대로(인코딩 필터 → CORS 필터 → 서블릿)** 정확하게 실행됩니다.
```xml
<filter>
    <filter-name>utf8EncodingFilter</filter-name>
    <filter-class>com.korai.serveltstudy2.filter.Utf8EncodingFilter</filter-class>
</filter>
<filter-mapping>
    <filter-name>utf8EncodingFilter</filter-name>
    <url-pattern>/api/*</url-pattern>
</filter-mapping>

<filter>
    <filter-name>corsFilter</filter-name>
    <filter-class>com.korai.serveltstudy2.filter.CorsFilter</filter-class>
</filter>
<filter-mapping>
    <filter-name>corsFilter</filter-name>
    <url-pattern>/api/*</url-pattern>
</filter-mapping>
```

---

## 🧯 서블릿 에러 났을 때 보는 치트시트

| 화면/콘솔 상태코드 | 뜻 | 확인할 것 |
|---|---|---|
| **404 Not Found** | 그런 주소(메뉴) 없음 | `@WebServlet("/주소")`와 브라우저 주소창 철자 비교, JSP/HTML 파일 위치 확인 |
| **405 Method Not Allowed** | 그 방식(GET/POST/OPTIONS)은 처리 못함 | form/fetch의 `method`와 서블릿의 `doGet`/`doPost`/`doOptions`가 맞는지 확인 |
| **500** + `NumberFormatException` | 숫자가 아닌 걸 `parseInt` 함 | 숫자 입력칸을 빈칸(`""`)으로 보냈는지 확인 |
| **500** + `NullPointerException` | `null`인 변수를 사용함 | 파라미터 이름 오타 (HTML `name` 속성과 `getParameter("이름")` 비교) |
| **CORS policy 차단 에러** | 포트/도메인이 달라 브라우저가 막음 | `CorsFilter`가 해당 경로에 적용되었는지, `OPTIONS` 요청에 200 응답을 주는지 확인 |
| **한글이 `???`로 깨짐** | 인코딩 설정 누락 | `Utf8EncodingFilter` 적용 여부 또는 `setContentType("...;charset=UTF-8")` 확인 |
