package org.skypro.skyshop;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.exceptions.BestResultNotFoundException;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.Searchable;

public class App {
    public static void main(String[] args) {
        Product bread = new SimpleProduct("Bread", 50);
        Product apple = new SimpleProduct("Apple", 150);
        Product milk = new DiscountedProduct("Milk", 90, 15);
        Product orange = new FixPriceProduct("Orange");
        Product cheese = new SimpleProduct("Cheese", 300);
        Product wine = new DiscountedProduct("Wine", 500, 20); // 5-й товар (заполнит корзину)
        Product juice = new SimpleProduct("Juice", 120); // 6-й товар (для проверки переполнения)

        ProductBasket myBasket = new ProductBasket();
        System.out.println("--- 1. Добавление продуктов ---");
        myBasket.addProduct(apple);
        myBasket.addProduct(milk);
        myBasket.addProduct(orange);
        myBasket.addProduct(cheese);
        myBasket.addProduct(wine);
        System.out.println("--- 2. Проверка переполнения ---");
        myBasket.addProduct(juice);
        System.out.println("\n--- 3. Печать содержимого корзины (5 товаров) ---");
        myBasket.printContent();
        System.out.println("\n--- 4. Получение общей стоимости ---");
        System.out.println("Общая стоимость корзины: " + myBasket.getTotalCost());
        System.out.println("\n--- 5. Поиск товара ---");
        String productToFind = "Milk";
        boolean found = myBasket.checkProductByName(productToFind);
        System.out.println("Найден ли товар [" + productToFind + "]? " + found); // Ожидаем: true
        String productMissing = "Water";
        boolean notFound = myBasket.checkProductByName(productMissing);
        System.out.println("Найден ли товар [" + productMissing + "]? " + notFound); // Ожидаем: false
        System.out.println("\n--- 6. Очистка корзины ---");
        myBasket.clearBasket();
        System.out.println("\n--- 7. Проверка пустой корзины ---");
        myBasket.printContent();
        System.out.println("Стоимость пустой корзины: " + myBasket.getTotalCost());
        boolean foundInEmpty = myBasket.checkProductByName("Apple");
        System.out.println("Найден ли товар [Apple] в пустой корзине? " + foundInEmpty);

        SearchEngine searchEngine = new SearchEngine(10);
        searchEngine.add(new Article("Польза молока", "Молоко полезно для костей..."));
        searchEngine.add(new Article("Как выбирать сыр", "Сыр Маасдам должен иметь дырки..."));

        System.out.println("Результаты поиска для 'Маасдам':");
        Searchable[] results= searchEngine.search("Маасдам");

        try {
            Product sol = new SimpleProduct("Sol", -1);
            System.out.println(sol);
        } catch (IllegalArgumentException e) {
            System.out.println("Не удалось создать товар: " + e.getMessage());
        }




        for(Searchable element:results){
            if(element!=null){
                System.out.println(element.getStringRepresentation());
            }
        }
        System.out.println("\n--- 8. Тестирование умного поиска ---");


        try {
            Searchable best = searchEngine.findBestMatch("Сыр");
            System.out.println("Самый подходящий результат: " + best.getStringRepresentation());
        } catch (BestResultNotFoundException e) {
            System.out.println(e.getMessage());
        }


        try {
            Searchable missing = searchEngine.findBestMatch("Космолет");
            System.out.println(missing.getStringRepresentation());
        } catch (BestResultNotFoundException e) {
            System.out.println("Поймали исключение: " + e.getMessage());
        }
    }
}
