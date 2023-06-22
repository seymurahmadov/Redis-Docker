package com.example.redisdocker.repositrory;

import com.example.redisdocker.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdRepository extends JpaRepository<ProductEntity,String> {
}
