package ru.geekbrains.spring.first.services;

import ru.geekbrains.spring.first.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAll();
}
