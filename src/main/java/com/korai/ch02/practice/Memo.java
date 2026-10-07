package com.korai.ch02.practice;

public class Memo {
    /*
     * [선언 이유: private 필드들]
     * - id : 메모를 고유하게 식별하기 위한 정수형 번호표 변수
     * - name : 메모 작성자의 이름을 저장하는 문자열 변수
     * - content : 사용자가 작성한 메모 본문을 저장하는 문자열 변수
     * - private을 붙인 이유: 외부 클래스에서 변수에 직접 접근(memo.name = "...")하여
     *   데이터를 함부로 변경하는 것을 막고, 반드시 getter/setter 메서드를 통해서만 다루도록 캡슐화(보호)하기 위함입니다.
     */
    private int id;
    private String name;
    private String content;

    /*
     * [작성 이유: 생성자 public Memo(int id, String name, String content)]
     * - 'new Memo(...)'로 객체 인스턴스를 힙(Heap) 메모리에 생성할 때,
     *   3개의 필드값을 한 번에 전달받아 this를 통해 자기 자신의 멤버 변수에 초기화하기 위함입니다.
     */
    public Memo(int id, String name, String content) {
        this.id = id;
        this.name = name;
        this.content = content;
    }

    /*
     * [작성 이유: Getter / Setter 메서드들]
     * - private으로 숨겨둔 필드값들을 외부 클래스에서 안전하게 꺼내 읽거나(getId, getName, getContent),
     *   필요할 때 값을 변경(setId, setName, setContent)할 수 있도록 통로를 열어두기 위함입니다.
     */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /*
     * [작성 이유: toString() 오버라이딩]
     * - System.out.println(memo)를 실행했을 때 "Memo@16b98e56" 같은 알 수 없는 메모리 주소 대신,
     *   id, name, content에 들어있는 실제 문자열 값이 한눈에 보기 쉽게 출력되도록 재정의한 것입니다.
     */
    @Override
    public String toString() {
        return "Memo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
