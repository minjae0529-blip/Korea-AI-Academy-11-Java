package com.korai.ch02.practice;

import java.util.List;

public class MemoService {

    /*
     * [선언 이유: private MemoRepository memoRepository]
     * - 이 클래스(MemoService) 안에서 MemoRepository 객체가 가지고 있는
     *   insert() 메서드와 printAll() 메서드를 호출하여 데이터를 저장하고 꺼내오기 위해 선언한 참조 변수입니다.
     * - private을 붙인 이유: 외부 클래스에서 저장소 객체 참조를 마음대로 바꾸거나 직접 조작하지 못하게 보호하기 위함입니다.
     */
    private MemoRepository memoRepository;

    /*
     * [작성 이유: 생성자 매개변수로 MemoRepository 받기 (의존성 주입 DI)]
     * - MemoService 내부에서 직접 'new MemoRepository()'를 생성하면 두 클래스 간의 결합도가 높아집니다.
     * - 그래서 외부(MemoApplication)에서 이미 만들어진 MemoRepository 객체 인스턴스를 매개변수로 넘겨받아
     *   this.memoRepository 변수에 할당해 두고 사용하기 위해 이렇게 작성한 것입니다.
     */
    public MemoService(MemoRepository memoRepository) {
        this.memoRepository = memoRepository;
    }

    /*
     * [작성 이유: public void register(String name, String content)]
     * - 1. 사용자가 화면에 입력한 이름(name)과 내용(content)을 매개변수로 받습니다.
     * - 2. 'new Memo(0, name, content)'를 실행하여 새로운 Memo 객체 인스턴스를 힙(Heap) 메모리에 생성합니다.
     *      (이때 id는 아직 저장소에 들어가기 전이므로 임시값 0을 전달합니다)
     * - 3. memoRepository 객체의 insert(memo) 메서드를 호출하여, 저장소가 번호표를 찍고 리스트에 보관하도록 위임합니다.
     */
    public void register(String name, String content) {
        Memo memo = new Memo(0, name, content);
        memoRepository.insert(memo);
    }

    /*
     * [작성 이유: public List<Memo> getMemos()]
     * - memoRepository 객체의 printAll() 메서드를 호출하여,
     *   저장소에 보관된 전체 Memo 리스트를 가져와서 화면(MemoView)에 반환하기 위함입니다.
     */
    public List<Memo> getMemos() {
        return memoRepository.printAll();
    }
}