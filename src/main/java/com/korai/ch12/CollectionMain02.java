package com.korai.ch12;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

public class CollectionMain02 {
    public static void main(String[] args) {
    CustomLinkedList<String> list1 = new CustomLinkedList<>();
    list1.add("자바");
    list1.add("자바1");
    list1.add("자바2");
    System.out.println(list1.get(2));
    }
}

//선형리스트 : 한방향으롱 연결된 리스트
//노드를 연결함. 여기서 노드란, 연결된 다른 노드들의 주소와 저장할 값을 포함한 것

class CustomLinkedList<E> {
    @AllArgsConstructor
    private static class Node<E> {
        E item;         //데이터 저장
        //        Node<E> prev;   // 이전 노드
        Node<E> next;   // 다음 노드
    }

    private Node<E> head;
    private Node<E> tail;
    private int size;

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        Node<E> current = head;

        for(int i = 0; i < size; i++){
            builder.append(current.item);
            if(i != size -1){
                builder.append(", ");
            }
            current = current.next;     // 다음 주소를 가리키는 것
        }
        builder.append("]");
        return super.toString();
    }

    public void add(E e) {
        Node<E> newNode = new Node<>(e, null);
        if(head == null){
            head = new Node<>(e, null);
            tail = head;
        }else {
            tail.next = newNode;
            tail = newNode;
        }
         size++;
    }

    public E get(int index){
        if(!(index < size && index > -1)){
            throw new IndexOutOfBoundsException();
        }
        Node<E> current = head;
        for(int i = 0; i < index; i++){
            current = current.next;
        }
        return current.item;
    }



}