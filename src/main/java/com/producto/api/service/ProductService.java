package com.producto.api.service;

import com.producto.api.controller.Product;
import com.producto.api.model.ProductModel;
import com.producto.api.repository.PruductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {


    @Autowired
    private PruductRepository productRepository;

    public List<ProductModel> getAllProducts() {
        return productRepository.findAll();
    }

    public Optional<ProductModel> getProductById(Long id) {
        return productRepository.findById(id);
    }

    public ProductModel createProduct(ProductModel product) {
        return productRepository.save(product);
    }

    public ProductModel updateProduct(Long id, ProductModel updatedProduct) {
        ProductModel existingProduct = productRepository.findById(id).orElse(null);
        if (existingProduct != null) {
            existingProduct.setNombre(updatedProduct.getNombre());
            existingProduct.setDescripcion(updatedProduct.getDescripcion());
            existingProduct.setPrecio(updatedProduct.getPrecio());
            existingProduct.setCategoria(updatedProduct.getCategoria());
            return productRepository.save(existingProduct);
        }
        return null;
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

}
