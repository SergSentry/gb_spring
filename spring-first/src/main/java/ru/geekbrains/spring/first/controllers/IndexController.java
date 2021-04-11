package ru.geekbrains.spring.first.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller()
public class IndexController {
    private static final String PRODUCTS_PAGE_REDIRECT = "redirect:/products/all";

    @GetMapping()
    public String getProducts() {
        return PRODUCTS_PAGE_REDIRECT;
    }
}
