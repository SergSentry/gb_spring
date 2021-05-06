package ru.geekbrains.april.market.utils;

import org.springframework.stereotype.Component;
import ru.geekbrains.april.market.models.Product;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class Cart {
    private List<Product> items;

    @PostConstruct
    public void init() {
        items = new ArrayList<>();
    }

    public List<Product> getItems() {
        return items;
    }

    public void addProduct(Product product) {
        if (product == null)
            throw new IllegalArgumentException("product");
        items.add(product);
    }

    public void clear() {
        items.clear();
    }
}
