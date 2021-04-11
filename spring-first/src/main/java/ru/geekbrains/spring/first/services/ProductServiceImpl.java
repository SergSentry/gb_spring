package ru.geekbrains.spring.first.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.geekbrains.spring.first.model.Product;
import ru.geekbrains.spring.first.repositories.ProductRepository;

import java.util.List;
import java.util.Optional;

@Component
public class ProductServiceImpl implements ProductService {
    private ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getAll() {
        return this.productRepository.getProducts();
    }

    @Override
    public Optional<Product> getById(int id) {
        return this.productRepository.getById(id);
    }
}
