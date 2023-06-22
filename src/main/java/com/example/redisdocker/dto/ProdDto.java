package com.example.redisdocker.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level =  AccessLevel.PRIVATE)
public class ProdDto {
    String id;

    String productName ;

    String category;

    Integer price;

    Integer count;

    String color;

    String size;
}