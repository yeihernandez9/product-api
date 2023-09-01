package com.producto.api.service;

import com.producto.api.model.ProductModel;
import com.producto.api.repository.PruductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ProductServiceTest {

    @Mock
    private PruductRepository productRepository;

    @InjectMocks
    private ProductService productService;

    @BeforeEach
    void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetAllProducts() {
        // Mock the behavior of the product repository
        List<ProductModel> productList = new ArrayList<>();
        productList.add(new ProductModel(1L, "Producto 1", "Descripcion 1", 10.0, "Categoria 1"));
        when(productRepository.findAll()).thenReturn(productList);

        // Test the service method
        List<ProductModel> result = productService.getAllProducts();

        // Verify the result
        assertEquals(1, result.size());
        assertEquals("Product 1", result.get(0).getNombre());
    }

    @Test
    void testGetProductById() {
        // Mock the behavior of the product repository
        Long productId = 1L;
        ProductModel product = new ProductModel(productId, "Producto 1", "Description 1", 10.0, "Categoria 1");
        when(productRepository.findById(productId)).thenReturn(Optional.of(product));

        // Test the service method
        Optional<ProductModel> result = productService.getProductById(productId);

        // Verify the result
        assertTrue(result.isPresent());
        assertEquals("Producto 1", result.get().getNombre());
    }

    @Test
    void testCreateProduct() {
        // Create a new product
        ProductModel newProduct = new ProductModel(1L, "Nuevo producto", "Descripcion nuevo producto", 10.0, "Categoria 1");

        // Mock the behavior of the product repository
        when(productRepository.save(newProduct)).thenReturn(newProduct);

        // Test the service method
        ProductModel result = productService.createProduct(newProduct);

        // Verify the result
        assertNotNull(result);
        assertEquals("Nuevo producto", result.getNombre());
    }

}
