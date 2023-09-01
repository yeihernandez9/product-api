package com.producto.api.controller;

import com.producto.api.model.ProductModel;
import com.producto.api.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class Product {

    @Autowired
    private ProductService productService;

    @GetMapping
    public List<ProductModel> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Optional<ProductModel> getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    @PostMapping
    public ProductModel createProduct(@Valid @RequestBody ProductModel product) {
        return productService.createProduct(product);
    }

    @PutMapping("/{id}")
    public ProductModel updateProduct(@PathVariable Long id, @RequestBody ProductModel updatedProduct) {
        return productService.updateProduct(id, updatedProduct);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }

}
