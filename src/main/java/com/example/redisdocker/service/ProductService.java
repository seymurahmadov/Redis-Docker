package com.example.redisdocker.service;


import com.example.redisdocker.dto.ProdDto;
import com.example.redisdocker.entity.ProductEntity;
import com.example.redisdocker.repositrory.ProdRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProdRepository repository;
    private final RedisService redisService;

    public ProductEntity saveProducts(ProdDto dto) {
        ProductEntity entity = ProductEntity.builder()
                .productName(dto.getProductName())
                .category(dto.getCategory())
                .price(dto.getPrice())
                .color(dto.getColor())
                .count(dto.getCount())
                .size(dto.getSize())
                .build();
        redisService.redisStorage(dto.getId(), dto.getProductName());
        return repository.save(entity);
    }

    public void deleteProduct(String id) {
        redisService.deleteKey(id);
    }


    public List<ProductEntity> getAll() {

        Iterable<ProductEntity> all = repository.findAll();
        List<ProductEntity> list = new ArrayList<>();

        all.forEach(list::add);
        return list;
    }


    public ProductEntity updateProduct(ProdDto dto) {
        ProductEntity entity = repository.findById(dto.getId()).orElseThrow();
        entity.setProductName(dto.getProductName());
        entity.setCategory(dto.getCategory());
        entity.setPrice(dto.getPrice());
        entity.setColor(dto.getColor());
        entity.setCount(dto.getCount());
        entity.setSize(dto.getSize());

        return repository.save(entity);
    }
}
