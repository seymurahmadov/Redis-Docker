package com.example.redisdocker.controller;



import com.example.redisdocker.dto.ProdDto;
import com.example.redisdocker.entity.ProductEntity;
import com.example.redisdocker.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProdController {

    private final ProductService service;

    @PostMapping("/save")
    public void saveProd(@RequestBody ProdDto prodDto){
        service.saveProducts(prodDto);
    }

    @GetMapping("/get-all")
    public List<ProductEntity> getAll(){
     return service.getAll();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteProduct(@PathVariable String id){
        service.deleteProduct(id);
    }

    @PutMapping("/update")
    public ProductEntity updateProduct(@RequestBody ProdDto dto){
     return   service.updateProduct(dto);
    }
}
