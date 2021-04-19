package ru.geekbrains.spring.first.domain.repositories;

import ru.geekbrains.spring.first.domain.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    Optional<Product> getById(int id);

    List<Product> getProducts();
}
