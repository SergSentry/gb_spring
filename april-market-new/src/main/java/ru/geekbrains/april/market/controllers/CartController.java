package ru.geekbrains.april.market.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.april.market.dtos.CartDto;
import ru.geekbrains.april.market.models.Product;
import ru.geekbrains.april.market.services.ProductService;
import ru.geekbrains.april.market.utils.Cart;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/cart")
@RequiredArgsConstructor
@Slf4j
public class CartController {
    private final ProductService productService;
    private final Cart cart;

    @GetMapping("/ping")
    public void ping(@RequestParam Long id) {
        log.info("ping: " + id);
    }

    @GetMapping
    public CartDto getCartProducts() {
        return new CartDto(cart);
    }

    @PostMapping("/add")
    public void addProduct(@RequestParam Long id) {
        Optional<Product> product = productService.findById(id);
        if (product.isPresent()) {
            log.info("add product: " + id);
            cart.addProduct(product.get());
        }
    }

    @PostMapping("/clear")
    public void clearCart() {
        log.info("clear cart");
        cart.clear();
    }
}
