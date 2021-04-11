package ru.geekbrains.spring.first.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.geekbrains.spring.first.repositories.ProductRepository;

import java.util.ArrayList;
import java.util.List;

@Component()
@Scope("prototype")
public class Cart {
    private final ProductRepository productRepository;
    private final List<Product> products;

    @Autowired
    public Cart(ProductRepository productRepository) {
        this.productRepository = productRepository;
        this.products = new ArrayList<>();
    }

    public boolean attachProduct(int id) {
        Product product = this.productRepository.getById(id);
        if (product != null) {
            products.add(product);
            return true;
        }

        return false;
    }

    public boolean detachProduct(int id) {
        Product product = this.productRepository.getById(id);
        if (product != null) {
            products.remove(product);
            return true;
        }

        return false;
    }

    public List<Product> getProducts() {
        return products;
    }
}
