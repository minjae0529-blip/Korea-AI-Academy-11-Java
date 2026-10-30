package com.korai.serveltstudy2.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    private int customerId;
    private String name;
    private String phones;
    private String email;
    private String birthDate;
    private String district;
    private String address;
    private String grade;
    private String marketingAgreed;
    private String joinedAt;
}
