package ru.geekbrains.spring.first.services;

import ru.geekbrains.spring.first.domain.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> getAll();

    Optional<Product> getById(int id);
}
