package com.korai.ch09.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Objects;

//엔티티 클래스 (정보를 저장하는 클래스)
//생성자, getter/setter, toString, equals, hashcode

@AllArgsConstructor         //모든 인자가 있는 생성자를 만들어라
@Data                       //롬복 라이브러리 자바 개발자 필수
public class Car {
    private Long id;
    private String number;
    private String model;
    private String owner;
}
