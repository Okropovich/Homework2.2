package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;
import java.util.*;
import java.util.stream.Collectors;

public class ProductBasket {
    private final Map<String, List<Product>> products = new HashMap<>();

    public void addProduct(Product product) {
        products.computeIfAbsent(product.getProductName(), k -> new ArrayList<>()).add(product);
    }

    public int getTotalCost() {
        return products.values().stream()
                .flatMap(Collection::stream)
                .mapToInt(Product::getCastProduct)
                .sum();
    }


    public void printContent() {
        if (products.isEmpty()) {
            System.out.println("в корзине пусто");
            return;
        }


        products.values().stream()
                .flatMap(Collection::stream)
                .forEach(System.out::println);

        System.out.println("Итого: " + getTotalCost());
        System.out.println("Специальных товаров: " + getSpecialCount());
    }


    private long getSpecialCount() {
        return products.values().stream()
                .flatMap(Collection::stream)
                .filter(Product::isSpecial)
                .count();
    }

    public List<Product> removeProductByName(String name) {
        List<Product> removed = products.remove(name);
        return (removed != null) ? removed : new ArrayList<>();
    }
}