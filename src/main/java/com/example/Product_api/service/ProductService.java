package com.example.Product_api.service;

import com.example.Product_api.dto.ProductDTO;
import com.example.Product_api.model.Product;
import com.example.Product_api.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class ProductService {

    private static final Logger logger = 
            LoggerFactory.getLogger(ProductService.class);

    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    // CREATE
    public Product createProduct(ProductDTO dto) {

        logger.info("Creating product: {}", dto.getName());

        Product product =
                new Product(
                        dto.getName(),
                        dto.getDescription(),
                        dto.getPrice());

        Product savedProduct = repository.save(product);

        logger.info("Product created successfully with ID: {}", savedProduct.getId());

        return savedProduct;
    }

    // READ ALL
    public List<Product> getAllProducts() {

        logger.info("Fetching all products");

        return repository.findAll();
    }

    // READ ONE
    public Optional<Product> getProductById(Long id) {

        logger.info("Fetching product with ID: {}", id);

        return repository.findById(id);
    }

    // UPDATE
    public Optional<Product> updateProduct(Long id, ProductDTO dto) {

        logger.info("Updating product with ID: {}", id);

        return repository.findById(id)
                .map(existingProduct -> {

                    existingProduct.setName(dto.getName());
                    existingProduct.setDescription(dto.getDescription());
                    existingProduct.setPrice(dto.getPrice());

                    logger.info("Product updated successfully: {}", id);

                    return repository.save(existingProduct);
                });
    }

    // DELETE
    public boolean deleteProduct(Long id) {

        logger.info("Deleting product with ID: {}", id);

        if (repository.existsById(id)) {

            repository.deleteById(id);

            logger.info("Product deleted successfully: {}", id);

            return true;
        }

        logger.warn("Delete failed. Product not found: {}", id);

        return false;
    }
}