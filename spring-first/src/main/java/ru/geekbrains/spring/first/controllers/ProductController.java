package ru.geekbrains.spring.first.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.geekbrains.spring.first.model.Product;
import ru.geekbrains.spring.first.services.ProductService;

import java.util.List;
import java.util.Optional;

@Controller()
@RequestMapping("/products")
public class ProductController {
    private static final String PRODUCTS_PAGE_NAME = "products";
    private static final String PRODUCT_INFO_PAGE_NAME = "product_info";
    private static final String PRODUCTS_VALUE_NAME = "products";
    private static final String PRODUCT_VALUE_NAME = "product";

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/all")
    public String showProductsPage(Model model) {
        List<Product> products = productService.getAll();
        model.addAttribute(PRODUCTS_VALUE_NAME, products);
        return PRODUCTS_PAGE_NAME;
    }

    @GetMapping("/{id}")
    public String showProductsPage(@PathVariable(name = "id") int id, Model model) {
        Optional<Product> product = productService.getById(id);
        product.ifPresent(value -> model.addAttribute(PRODUCT_VALUE_NAME, value));
        return PRODUCT_INFO_PAGE_NAME;
    }
}
