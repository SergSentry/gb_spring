package ru.geekbrains.app;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class)) {
            ProductRepository shop = context.getBean("products", ProductRepositoryImpl.class);
            System.out.println("\nShop products");
            System.out.println(shop.getProducts());

            Cart bobCart = context.getBean("cart", Cart.class);
            bobCart.attachProduct(1);
            bobCart.attachProduct(3);
            System.out.println("\nBobs cart");
            System.out.println(bobCart.getProducts());

            Cart stuartCart = context.getBean("cart", Cart.class);
            stuartCart.attachProduct(1);
            stuartCart.attachProduct(2);
            stuartCart.attachProduct(4);
            stuartCart.attachProduct(5);
            System.out.println("\nStuarts cart");
            System.out.println(stuartCart.getProducts());

            System.out.println("\nStuart doesn't eat bread, detach it!!");
            stuartCart.detachProduct(2);

            System.out.println("\nStuarts cart");
            System.out.println(stuartCart.getProducts());
        }
    }
}
