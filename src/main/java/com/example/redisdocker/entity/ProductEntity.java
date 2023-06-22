package com.example.redisdocker.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;


@Data
@EqualsAndHashCode
@RedisHash("products")
@Builder
@FieldDefaults(level =  AccessLevel.PRIVATE)
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    String id;

    String productName;

    String category;

    Integer price;

    Integer count;

    String color;

    String size;



}
