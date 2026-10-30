# ☕ Korea-AI-Academy-11 Java 완벽 마스터 노트 & 실전 연습문제

> 💡 **학습자**: 강민재  
> **과정**: 대한민국인공지능아카데미 11기 Java 백엔드  
> **핵심 키워드**: 객체지향 4대 원칙, Layered Architecture, 5계층 콘솔 Todo 앱, 디자인 패턴

---

## 📌 [Ch01] 자바 기초 & 누적 종합 복습
> 📄 **주요 소스**: `ScannerTest01.java`, `ArrayTest02.java`, `ArrayTest03.java`, `ClassMainTest01.java`  
> 💡 **핵심 비유**: 컴퓨터와의 첫 대화! 배열 인덱스는 0부터 시작한다는 원칙과 boolean 좌석표, 최상위 Object의 다형성

- [ ] **문제 1. 짝수 필터링과 개수 구하기**
  - **요구사항**: `int[] numbers = {12, 7, 5, 20, 33, 40, 18};` 배열에서 짝수만 출력하고 총 개수를 반환하세요.
  <details>
  <summary><b>💡 모범 답안 및 해설 보기</b></summary>

  ```java
  public static int countEvens(int[] numbers) {
      int count = 0;
      for (int num : numbers) {
          if (num % 2 == 0) {
              System.out.println("짝수: " + num);
              count++;
          }
      }
      return count;
  }
  ```
  * **해설**: 나머지 연산자(`num % 2 == 0`)로 짝수를 판별하고 카운터 변수를 증가시킵니다.
  </details>

- [ ] **문제 2. 영화관 좌석 예약 시스템**
  - **요구사항**: 크기 10의 좌석 배열 `boolean[] seats`(false=빈자리, true=예약됨)에서 사용자가 선택한 `seatNum`(1~10) 좌석을 예약 처리하세요.
  <details>
  <summary><b>💡 모범 답안 및 해설 보기</b></summary>

  ```java
  public static boolean reserveSeat(boolean[] seats, int seatNum) {
      int index = seatNum - 1; // 인덱스는 0부터 시작
      if (seats[index]) {
          System.out.println("이미 예약된 좌석입니다.");
          return false;
      }
      seats[index] = true;
      System.out.println(seatNum + "번 좌석 예약 완료!");
      return true;
  }
  ```
  </details>

---

## 📌 [Ch02] 함수 & 의존성 주입 (DI) 메모장 앱
> 📄 **주요 소스**: `Memo.java`, `MemoRepository.java`, `MemoService.java`, `MemoView.java`, `MemoApplication.java`  
> 💡 **핵심 비유**: 요리사(Service)가 직접 텃밭에서 배추(Repository)를 기르지 않고 외부에서 싱싱한 배추를 손에 쥐여주는 원리!

- [ ] **문제 1. 번호표 기계 (autoIncrement) 저장소 구현**
  - **요구사항**: 메모 등록 시 1부터 시작해 1씩 증가하는 id를 부여하고 리스트에 저장하세요.
  <details>
  <summary><b>💡 모범 답안 및 해설 보기</b></summary>

  ```java
  public class MemoRepository {
      private List<Memo> memoList = new ArrayList<>();
      private int autoIncrement = 1;

      public void save(Memo memo) {
          memo.setId(this.autoIncrement++);
          memoList.add(memo);
      }
  }
  ```
  </details>

- [ ] **문제 2. 3계층 의존성 주입(DI) 조립 순서**
  - **요구사항**: Repository -> Service -> View 하위 계층부터 차례대로 생성하여 조립하세요.
  <details>
  <summary><b>💡 모범 답안 및 해설 보기</b></summary>

  ```java
  // 1) 데이터 저장소(하위) 생성
  MemoRepository memoRepository = new MemoRepository();
  // 2) 비즈니스 서비스에 저장소 주입
  MemoService memoService = new MemoService(memoRepository);
  // 3) UI 화면에 서비스 주입
  MemoView memoView = new MemoView(memoService);
  ```
  </details>

---

## 📌 [Ch03] JVM 메모리 구조 & 정보 은닉 (캡슐화)
> 📄 **주요 소스**: `MethodArea.java`, `StaticBasic.java`, `AccessMain.java`, `Visitor.java`  
> 💡 **핵심 비유**: 공용 게시판(Method Area/static) vs 인스턴스 공장(Heap) vs 개인 메모장(Stack)

- [ ] **문제 1. 놀이공원 방문객 소지금 음수 방지 캡슐화**
  - **요구사항**: `Visitor`의 `money` 필드를 `private`으로 감추고, 음수 입력 시 경고를 띄우며 변경을 차단하는 setter를 구현하세요.
  <details>
  <summary><b>💡 모범 답안 및 해설 보기</b></summary>

  ```java
  public class Visitor {
      private int money;

      public void setMoney(int money) {
          if (money < 0) {
              System.out.println("소지금은 음수가 될 수 없습니다.");
              return;
          }
          this.money = money;
      }

      public int getMoney() {
          return this.money;
      }
  }
  ```
  </details>

---

## 📌 [Ch04] 배열 심화 (1차원 / 2차원 배열과 메모리 참조)
> 📄 **주요 소스**: `ArrayMain01.java` ~ `ArrayMain04.java`  
> 💡 **핵심 비유**: 크기가 고정된 계란판! Stack 지역 변수의 쓰레기 값 방지와 0 초기화 누적합

- [ ] **문제 1. 2차원 대각선 요소 합 계산**
  - **요구사항**: `matrix[3][3]`에서 `matrix[0][0]`, `matrix[1][1]`, `matrix[2][2]`의 합을 단일 for문으로 구하세요.
  <details>
  <summary><b>💡 모범 답안 및 해설 보기</b></summary>

  ```java
  int sum = 0;
  for (int i = 0; i < matrix.length; i++) {
      sum += matrix[i][i];
  }
  ```
  </details>

---

## 📌 [Ch05] 제어문 응용 & 동적 배열 확장
> 📄 **주요 소스**: `ControlMain6.java`, `ScannerTest.java`, `Practice01.java`, `Practice02_01.java`  
> 💡 **핵심 비유**: 방이 꽉 차면 1칸 더 큰 새 배열을 짓고 이전 주민들을 이사시킨다!

- [ ] **문제 1. 동적 배열 확장 (이사하기 원리)**
  - **요구사항**: 기존 `arr` 배열보다 1칸 더 큰 새 배열을 만들어 기존 데이터를 복사하고 새 값을 맨 끝에 넣으세요.
  <details>
  <summary><b>💡 모범 답안 및 해설 보기</b></summary>

  ```java
  public static int[] append(int[] arr, int newValue) {
      int[] newArr = new int[arr.length + 1];
      for (int i = 0; i < arr.length; i++) {
          newArr[i] = arr[i];
      }
      newArr[newArr.length - 1] = newValue;
      return newArr;
  }
  ```
  </details>

---

## 📌 [Ch06] 메서드 & 생성자 체이닝 (`this()`)
> 📄 **주요 소스**: `Method01.java`, `Method02.java`, `Method03.java`  
> 💡 **핵심 비유**: 이름은 하나인데 일하는 방식은 여러 개(오버로딩), 기본 주문서 재활용(`this()`)

- [ ] **문제 1. `this()` 생성자 체이닝**
  - **요구사항**: `Student(name, age)` 호출 시 기본 학교명 "한국고"를 전달하는 1줄 생성자를 작성하세요.
  <details>
  <summary><b>💡 모범 답안 및 해설 보기</b></summary>

  ```java
  public Student(String name, int age) {
      this(name, age, "한국고");
  }
  ```
  </details>

---

## 📌 [Ch07] 객체지향 4대 원칙 & 다형성 컬렉션
> 📄 **주요 소스**: `Practice01.java` ~ `Practice04.java`  
> 💡 **핵심 비유**: 부모 타입(`Vehicle`)으로 묶어 달리고(`drive`), 진짜 비행기(`Airplane`)일 때만 날개를 편다(`flyHigh`)!

- [ ] **문제 1. 탈것 다형성 순회 & 다운캐스팅**
  <details>
  <summary><b>💡 모범 답안 및 해설 보기</b></summary>

  ```java
  for (Vehicle v : list) {
      v.drive(); // 동적 바인딩
      if (v instanceof Car car) {
          car.openTrunk();
      } else if (v instanceof Airplane airplane) {
          airplane.flyHigh();
      }
  }
  ```
  </details>

---

## 📌 [Ch08] Object 클래스 완전 정복
> 📄 **주요 소스**: `Object01.java`, `Object02.java`  
> 💡 **핵심 비유**: 사물함 번호가 같은가(`==`) vs 사물함 속 내용물이 같은가(`equals()`)

- [ ] **문제 1. `Objects.hash()`를 활용한 해시코드 재정의**
  <details>
  <summary><b>💡 모범 답안 및 해설 보기</b></summary>

  ```java
  @Override
  public int hashCode() {
      return java.util.Objects.hash(name, age);
  }
  ```
  </details>

---

## 📌 [Ch09] 계층형 아키텍처 & Lombok
> 📄 **주요 소스**: `Car.java`, `CarRepository.java`, `InitService.java`, `CarMain.java`  
> 💡 **핵심 비유**: 주문서(Entity) -> 창고 관리자(Repository) -> 총괄 매니저(Service)

- [ ] **문제 1. 차량 관리 저장소의 삭제(`delete`) 메서드**
  <details>
  <summary><b>💡 모범 답안 및 해설 보기</b></summary>

  ```java
  public Car delete(Long id) {
      for (int i = 0; i < carList.size(); i++) {
          if (carList.get(i).getId().equals(id)) {
              return carList.remove(i);
          }
      }
      return null;
  }
  ```
  </details>

---

## 📌 [Ch10] 디자인 패턴 & 실전 Todo 풀스택 콘솔 앱
> 📄 **주요 소스**: `FeeCalculator.java`, `TodoApplication.java`, `RootRouter.java`, `SecurityConfig.java`, `TodoStatus.java`  
> 💡 **핵심 비유**: 회전목마 모터(`TodoApplication`) ↔ 교통경찰(`RootRouter`) ↔ 출입증(`UUID@userId`) ↔ 3색 스티커(`TodoStatus Enum`)

- [ ] **문제 1. 주차장 요금 정산 로직 구현**
  - **요구사항**: 30분 이하 무료, 30분 초과 시 기본 1,000원 + 10분당 500원 올림 가산
  <details>
  <summary><b>💡 모범 답안 및 해설 보기</b></summary>

  ```java
  public static int calculateParkingFee(int minutes) {
      if (minutes <= 30) return 0;
      int overtime = minutes - 30;
      int units = (int) Math.ceil(overtime / 10.0);
      return 1000 + (units * 500);
  }
  ```
  </details>

---

## 📌 [Ch11] 화면 라우팅 & 다형성 View 시스템 심화
> 📄 **주요 소스**: `TodoMain.java`, `StudentMain.java`  
> 💡 **핵심 비유**: `List<View>`에 화면들을 등록하고 `pathIndex`로 회전목마처럼 화면 순환

- [ ] **문제 1. 화면 전환 엔진 분기**
  <details>
  <summary><b>💡 모범 답안 및 해설 보기</b></summary>

  ```java
  if ("1".equals(choice)) {
      StudentMain.pathIndex = 1; // 등록 화면
  } else if ("2".equals(choice)) {
      StudentMain.pathIndex = 2; // 목록 화면
  } else if ("q".equalsIgnoreCase(choice)) {
      StudentMain.running = false; // 프로그램 종료
  }
  ```
  </details>

---

## 📌 [Ch12] 컬렉션 프레임워크 & 자료구조 & 예외 처리
> 📄 **주요 소스**: `CollectionMain02.java`, `CollectionMain04.java`, `Test01.java`  
> 💡 **핵심 비유**: 내 손으로 직접 만드는 연결 리스트의 `Node<E>`와 나만의 런타임 예외 클래스!

- [ ] **문제 1. `CustomLinkedList`의 `Node<E>` 구조체 선언**
  <details>
  <summary><b>💡 모범 답안 및 해설 보기</b></summary>

  ```java
  private static class Node<E> {
      E data;
      Node<E> next;

      public Node(E data) {
          this.data = data;
          this.next = null;
      }
  }
  ```
  </details>
