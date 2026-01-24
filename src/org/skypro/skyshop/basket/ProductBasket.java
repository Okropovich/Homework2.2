package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;
import java.util.*;

public class ProductBasket {
    private final Map<String, List<Product>> products = new HashMap<>();

    public void addProduct(Product product) {
        products.computeIfAbsent(product.getProductName(), k -> new ArrayList<>()).add(product);
    }

    public void printContent() {
        if (products.isEmpty()) {
            System.out.println("в корзине пусто");
            return;
        }
        int specialCount = 0;
        for (List<Product> list : products.values()) {
            for (Product p : list) {
                System.out.println(p);
                if (p.isSpecial()) specialCount++;
            }
        }
        System.out.println("Итого: " + getTotalCost());
        System.out.println("Специальных товаров: " + specialCount);
    }

    private int getTotalCost() {
        int total = 0;
        for (List<Product> list : products.values()) {
            for (Product p : list) {
                total += p.getCastProduct();
            }
        }
        return total;
    }

    public List<Product> removeProductByName(String name) {
        List<Product> removed = products.remove(name);
        return (removed != null) ? removed : new ArrayList<>();
    }
}