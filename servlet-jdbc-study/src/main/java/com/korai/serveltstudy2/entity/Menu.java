package com.korai.serveltstudy2.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Menu {
    private int menuId;
    private int restaurantId;
    private String name;
    private int price;
    private String description;
    private boolean isSignature;
    private boolean isSoldOut;
}
