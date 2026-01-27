package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.article.Article; // Импорт исправлен
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.Searchable;
import java.util.Set;

public class App {
    public static void main(String[] args) {
        SearchEngine engine = new SearchEngine();

        engine.add(new SimpleProduct("Яблоко", 100));
        engine.add(new SimpleProduct("Яблоко", 100)); // Проверка на дубликаты
        engine.add(new SimpleProduct("Груша конференция", 150));
        engine.add(new Article("Яблоки и их польза", "Текст статьи..."));

        System.out.println("--- Результаты поиска (по длине имени) ---");
        Set<Searchable> results = engine.search("Ябл");

        if (results.isEmpty()) {
            System.out.println("Ничего не найдено");
        } else {
            for (Searchable item : results) {

                System.out.println(item.getStringRepresentation());
            }
        }
    }
}