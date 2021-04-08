package ru.geekbrains.app;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component("products")
@Scope("singleton")
public class ProductRepositoryImpl implements ProductRepository {
    private final List<Product> products = new ArrayList<Product>();

    @PostConstruct
    public void initialize() {
        products.add(new ProductImpl(1, "Banana", .3f));
        products.add(new ProductImpl(2, "Bread", .2f));
        products.add(new ProductImpl(3, "Apple", .25f));
        products.add(new ProductImpl(4, "Raspberry", .1f));
        products.add(new ProductImpl(5, "Orange", .31f));
    }

    public Product getById(int id) {
        for (Product product : this.products) {
            if (product.getId() == id)
                return product;
        }

        return null;
    }

    public List<Product> getProducts() {
        return products;
    }
}
