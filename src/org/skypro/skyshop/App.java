package org.skypro.skyshop;

import org.skypro.skyshop.product.*;
import org.skypro.skyshop.basket.ProductBasket;
import java.util.List;

public class App {
    public static void main(String[] args) {
        ProductBasket basket = new ProductBasket();
        basket.addProduct(new SimpleProduct("Milk", 100));
        basket.addProduct(new SimpleProduct("Bread", 50));
        basket.addProduct(new SimpleProduct("Milk", 100)); // Дубликат для теста удаления

        System.out.println("--- Содержимое до удаления ---");
        basket.printContent();

        System.out.println("\n--- Удаляем Milk ---");
        List<Product> removed = basket.removeProductByName("Milk");
        if (removed.isEmpty()) {
            System.out.println("Список пуст");
        } else {
            System.out.println("Удалено товаров: " + removed.size());
            for (Product p : removed) System.out.println("Удален: " + p);
        }

        System.out.println("\n--- Содержимое после удаления ---");
        basket.printContent();

        System.out.println("\n--- Удаляем несуществующий товар ---");
        List<Product> emptyRemoved = basket.removeProductByName("Chocolate");
        if (emptyRemoved.isEmpty()) System.out.println("Список пуст");
    }
}