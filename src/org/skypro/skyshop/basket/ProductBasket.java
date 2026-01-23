package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;
import java.util.*;

public class ProductBasket {

    private final Map<String, List<Product>> products = new HashMap<>();

    public void addProduct(Product product) {

        products.computeIfAbsent(product.getProductName(), k -> new ArrayList<>()).add(product);
    }

    public int getTotalCost() {
        int total = 0;

        for (List<Product> productList : products.values()) {
            for (Product product : productList) {
                total += product.getCastProduct();
            }
        }
        return total;
    }

    public void printContent() {
        if (products.isEmpty()) {
            System.out.println("в корзине пусто");
            return;
        }
        int specialCount = 0;
        System.out.println("--- Список товаров ---");
        // Двойной цикл: по мапе и по вложенным спискам
        for (List<Product> productList : products.values()) {
            for (Product product : productList) {
                System.out.println(product);
                if (product.isSpecial()) specialCount++;
            }
        }
        System.out.println("Итого: " + getTotalCost());
        System.out.println("Специальных товаров: " + specialCount);
    }

    public boolean checkProductByName(String name) {

        return products.containsKey(name);
    }

    public void clearBasket() {
        products.clear();
        System.out.println("Корзина очищена.");
    }

    public List<Product> removeProductByName(String name) {

        List<Product> removed = products.remove(name);

        return (removed != null) ? removed : new ArrayList<>();
    }
}