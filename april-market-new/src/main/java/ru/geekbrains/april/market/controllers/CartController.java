package ru.geekbrains.april.market.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.april.market.models.Product;
import ru.geekbrains.april.market.services.ProductService;
import ru.geekbrains.april.market.utils.Cart;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cart")
@RequiredArgsConstructor
@Slf4j
public class CartController {
    private final Cart cart;

    @GetMapping("/ping")
    public void ping(@RequestParam Long id) {
        log.info("ping: " + id);
    }

    @GetMapping
    public List<Product> getCartProducts() {
        return cart.getItems();
    }

    @PostMapping("/add")
    public void addProduct(@RequestBody Product product) {
        log.info("add product: " + product.getTitle());
        cart.addProduct(product);
    }

    @PostMapping("/clear")
    public void clearCart() {
        log.info("clear cart");
        cart.clear();
    }
}
