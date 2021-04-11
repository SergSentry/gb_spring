package ru.geekbrains.spring.first.repositories;

import ru.geekbrains.spring.first.model.Product;

import java.util.List;

public interface ProductRepository {
    Product getById(int id);

    List<Product> getProducts();
}
