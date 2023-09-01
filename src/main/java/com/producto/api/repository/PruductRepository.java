package com.producto.api.repository;

import com.producto.api.model.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PruductRepository extends JpaRepository<ProductModel, Long> {
}
