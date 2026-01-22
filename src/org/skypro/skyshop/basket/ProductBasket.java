package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;
import java.util.LinkedList;
import java.util.List;
import java.util.Iterator;

public class ProductBasket {
    private final List<Product> products = new LinkedList<>();

    public void addProduct(Product product) {
        this.products.add(product);
    }

    public int getTotalCost() {
        int totalCost = 0;
        for (Product item : products) {
            totalCost += item.getCastProduct();
        }
        return totalCost;
    }

    public void printContent() {
        if (products.isEmpty()) {
            System.out.println("в корзине пусто");
            return;
        }

        int specialCount = 0;
        System.out.println("--- Список товаров ---");
        for (Product item : products) {
            System.out.println(item.toString());
            if (item.isSpecial()) {
                specialCount++;
            }
        }
        System.out.println("Итого: " + this.getTotalCost());
        System.out.println("Специальных товаров: " + specialCount);
    }

    public boolean checkProductByName(String name) {

        for (Product item : products) {
            if (item.getProductName().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }

    public void clearBasket() {
        products.clear();
        System.out.println("Корзина очищена.");
    }

    // Тот самый новый метод удаления!
    public List<Product> removeProductByName(String name) {
        List<Product> removed = new LinkedList<>();
        Iterator<Product> iterator = products.iterator();

        while (iterator.hasNext()) {
            Product current = iterator.next();
            if (current.getProductName().equalsIgnoreCase(name)) {
                removed.add(current);
                iterator.remove();
            }
        }
        return removed;
    }
}