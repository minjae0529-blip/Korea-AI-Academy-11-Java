package com.korai.serveltstudy2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Car {
    private String carName;
    private String color;
    private int carNumber;
    private String model;
}
