package ru.job4j.pojo;

import java.util.Arrays;

public class ShopDrop {
    public static Product[] delete(Product[] products, int index) {
        Product temp = new Product("", 0);
        for (int i = index; i < products.length - 1; i++) {
            products[i] = products[i + 1];
        }
        products[products.length - 1] = null;
        System.out.println(Arrays.toString(products));
        return products;
    }
}
