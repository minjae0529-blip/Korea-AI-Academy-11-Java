# 📄 [클래스 09] Todo.java (엔티티)

- **소속 패키지**: `com.korai.ch10.TODO.entity`
- **파일 위치**: [`Todo.java`](file:///Users/kangminjae/Documents/gov/java/study/src/main/java/com/korai/ch10/TODO/entity/Todo.java)
- **주요 역할**: 할 일(TODO) 항목 데이터를 표현하는 도메인 데이터 모델(Entity)

---

## 1. 왜 이 클래스를 만들었는가? (설계 배경)

TODO 애플리케이션의 핵심 주인공이 되는 데이터입니다.  
각 할 일은 "고유 번호(id)"와 "할 일 내용(content)", 그리고 가장 중요한 **"누가 작성했는가?(user)"**에 대한 정보를 함께 품고 있어야 합니다. 이를 객체 지향적으로 표현하기 위해 설계되었습니다.

---

## 2. 코드 전체 보기 (상세 주석 포함)

```java
package com.korai.ch10.TODO.entity;

// [작성 이유]: 모든 필드를 초기화하는 생성자를 자동 생성하기 위해 Lombok import
import lombok.AllArgsConstructor;
// [작성 이유]: Getter, Setter, toString 등을 자동 생성하기 위해 Lombok import
import lombok.Data;

@Data
@AllArgsConstructor
public class Todo {

    /*
     * [작성 이유: private int id]
     * 할 일의 고유 번호(Primary Key)입니다.
     * TodoRepository의 autoIncrement에 의해 1번부터 차례대로 1씩 증가하며 자동 발급됩니다.
     */
    private int id;

    /*
     * [작성 이유: private String content]
     * 사용자가 등록한 할 일의 상세 내용 문장입니다. (예: "자바 10장 복습하기")
     */
    private String content;

    /*
     * [작성 이유: private User user (객체 지향적 연관관계 매핑)]
     * 아주 중요한 설계 포인트!
     * 데이터베이스 관점에서는 단순히 'int userId'라는 숫자 외래키(FK)만 저장하는 경우가 많지만,
     * 자바 객체지향 설계에서는 이 할 일을 작성한 'User 객체 자체'를 참조 변수로 갖도록 합니다.
     * -> 효과: 나중에 todo.getUser().getName() 처럼 작성자의 이름이나 세부 정보를
     *    별도의 번거로운 추가 조회 없이 객체 탐색(Object Graph Traversal)으로 즉시 꺼낼 수 있습니다.
     */
    private User user;

}
```

---

## 3. 핵심 코드 심층 해설 (왜 이렇게 작성했는가?)

### Q1. `int userId` 대신 `User user` 객체를 직접 필드로 둔 이유는?
- **객체 지향 모델링의 장점**을 극대화하기 위해서입니다.
- 단순히 `int userId`만 가지고 있으면, 화면에 작성자 이름을 띄우고 싶을 때마다 `userRepository.findById(todo.getUserId())`를 매번 다시 호출해야 합니다.
- 반면 `User user` 참조를 가지고 있으면, 객체 간의 자연스러운 연결이 유지되어 `todo.getUser().getName()`으로 아주 우아하고 직관적으로 접근할 수 있습니다.

### Q2. `new Todo(0, content, foundUser)` 처럼 처음에 id에 0을 넣는 이유는?
- 객체를 처음 만드는 시점(`TodoService.register`)에는 아직 이 데이터가 저장소에 들어가기 전이므로 최종 ID 번호를 알지 못합니다.
- 따라서 임시값인 0을 채워 넣고, 실제 저장소(`TodoRepository.insert`)에 도달했을 때 `autoIncrement++` 값을 부여받도록 설계했습니다.

---

## 4. Todo와 User의 객체 연관관계

```mermaid
classDiagram
    class Todo {
        -int id
        -String content
        -User user
        +getId() int
        +getContent() String
        +getUser() User
    }

    class User {
        -int id
        -String username
        -String password
        -String name
    }

    Todo --> User : 1개의 Todo는 1명의 작성자(User)를 참조 (N:1)
```
