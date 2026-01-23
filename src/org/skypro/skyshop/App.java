package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.Searchable;

import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) {

        ProductBasket basket = new ProductBasket();


        basket.addProduct(new SimpleProduct("Молоко", 100));
        basket.addProduct(new DiscountedProduct("Хлеб", 50, 10));
        basket.addProduct(new SimpleProduct("Молоко", 110)); // Еще одно молоко
        basket.addProduct(new SimpleProduct("Сыр", 300));

        System.out.println("--- Содержимое корзины до удаления ---");
        basket.printContent();


        System.out.println("\n--- Удаляем 'Молоко' ---");
        List<Product> removedMilk = basket.removeProductByName("Молоко");
        if (removedMilk.isEmpty()) {
            System.out.println("Список пуст");
        } else {
            System.out.println("Удалено товаров (" + removedMilk.size() + "):");
            for (Product p : removedMilk) {
                System.out.println(p);
            }
        }

        System.out.println("\n--- Корзина после удаления молока ---");
        basket.printContent();


        System.out.println("\n--- Удаляем несуществующий продукт 'Шоколад' ---");
        List<Product> removedNone = basket.removeProductByName("Шоколад");
        if (removedNone.isEmpty()) {
            System.out.println("Список пуст");
        }

        System.out.println("\n--- Итоговая корзина ---");
        basket.printContent();


        System.out.println("\n--- Тестирование поиска (результаты отсортированы) ---");
        SearchEngine engine = new SearchEngine();

        engine.add(new SimpleProduct("Яблоко", 100));
        engine.add(new SimpleProduct("Апельсин", 150));
        engine.add(new SimpleProduct("Банан", 80));
        engine.add(new SimpleProduct("Ягода Малина", 200));


        String query = "Я";
        System.out.println("Поиск по запросу: '" + query + "'");
        Map<String, Searchable> searchResults = engine.search(query);

        if (searchResults.isEmpty()) {
            System.out.println("Ничего не найдено");
        } else {

            for (Searchable item : searchResults.values()) {
                System.out.println("Найдено: " + item.getSearchTerm());
            }
        }
    }
}