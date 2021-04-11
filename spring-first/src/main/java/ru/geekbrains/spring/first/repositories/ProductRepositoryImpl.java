package ru.geekbrains.spring.first.repositories;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.geekbrains.spring.first.model.Product;
import ru.geekbrains.spring.first.model.ProductImpl;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component("products")
@Scope("singleton")
public class ProductRepositoryImpl implements ProductRepository {
    private List<Product> products;

    @PostConstruct
    public void initialize() {
        products = new ArrayList<>(Arrays.asList(
                new ProductImpl(1, "Banana", .3f),
                new ProductImpl(2, "Bread", .2f),
                new ProductImpl(3, "Apple", .25f),
                new ProductImpl(4, "Raspberry", .1f),
                new ProductImpl(5, "Orange", .31f)
        ));
    }

    public Optional<Product> getById(int id) {
        for (Product product : this.products) {
            if (product.getId() == id)
                return Optional.of(product);
        }

        return Optional.empty();
    }

    public List<Product> getProducts() {
        return products;
    }
}
