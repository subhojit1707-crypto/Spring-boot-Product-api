package com.example.Product_api.service;

import com.example.Product_api.dto.ProductDTO;
import com.example.Product_api.model.Product;
import com.example.Product_api.repository.ProductRepository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class ProductServiceTest {

    @Mock
    private ProductRepository repository;

    @InjectMocks
    private ProductService service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createProduct_ShouldSaveProduct() {

        ProductDTO dto =
                new ProductDTO("Laptop",
                        "Gaming Laptop",
                        1200.0);

        Product savedProduct =
                new Product("Laptop",
                        "Gaming Laptop",
                        1200.0);

        when(repository.save(any(Product.class)))
                .thenReturn(savedProduct);

        Product result = service.createProduct(dto);

        assertEquals("Laptop", result.getName());

        verify(repository, times(1))
                .save(any(Product.class));
    }

    @Test
    void getAllProducts_ShouldReturnList() {

        when(repository.findAll())
                .thenReturn(List.of(
                        new Product("Mouse","RGB",50.0),
                        new Product("Keyboard","Mechanical",80.0)
                ));

        List<Product> products =
                service.getAllProducts();

        assertEquals(2, products.size());

        verify(repository, times(1))
                .findAll();
    }

    @Test
    void getProductById_ShouldReturnProduct() {

        Product product =
                new Product("Mouse",
                        "RGB",
                        50.0);

        when(repository.findById(1L))
                .thenReturn(Optional.of(product));

        Optional<Product> result =
                service.getProductById(1L);

        assertTrue(result.isPresent());

        verify(repository, times(1))
                .findById(1L);
    }

        @Test
    void updateProduct_ShouldUpdateExistingProduct() {

        Product existingProduct =
                new Product("Laptop",
                        "Gaming Laptop",
                        1200.0);

        ProductDTO updatedDto =
                new ProductDTO("Laptop Pro",
                        "Updated Laptop",
                        1500.0);

        when(repository.findById(1L))
                .thenReturn(Optional.of(existingProduct));

        when(repository.save(any(Product.class)))
                .thenAnswer(invocation -> invocation.getArgument(0));

        Optional<Product> result =
                service.updateProduct(1L, updatedDto);

        assertTrue(result.isPresent());

        assertEquals("Laptop Pro",
                result.get().getName());

        assertEquals("Updated Laptop",
                result.get().getDescription());

        assertEquals(1500.0,
                result.get().getPrice());

        verify(repository, times(1))
                .findById(1L);

        verify(repository, times(1))
                .save(any(Product.class));
    }

    @Test
    void deleteProduct_ShouldDeleteWhenExists() {

        when(repository.existsById(1L))
                .thenReturn(true);

        boolean result =
                service.deleteProduct(1L);

        assertTrue(result);

        verify(repository, times(1))
                .deleteById(1L);
    }
}