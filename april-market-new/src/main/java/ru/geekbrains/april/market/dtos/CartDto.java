package ru.geekbrains.april.market.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.geekbrains.april.market.models.Product;
import ru.geekbrains.april.market.utils.Cart;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class CartDto {
    private int totalPrice;
    private List<ProductDto> products;

    public CartDto(Cart cart) {
        products = new ArrayList<>();
        for (var product: cart.getItems()) {
            this.totalPrice += product.getPrice();
            this.products.add(new ProductDto(product));
        }
    }
}