package ru.geekbrains.app;

import java.util.List;

public interface ProductRepository {
    Product getById(int id);

    List<Product> getProducts();
}
