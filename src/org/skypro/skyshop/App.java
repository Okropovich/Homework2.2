package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;

public class App {
    public static void main(String[] args) {
        Product bread = new Product("Bread", 50);


        Product apple = new Product("Apple", 150);
        Product milk = new Product("Milk", 90);
        Product orange = new Product("Orange", 50);
        Product cheese = new Product("Cheese", 300);
        Product wine = new Product("Wine", 500); // 5-й товар (заполнит корзину)
        Product juice = new Product("Juice", 120); // 6-й товар (для проверки переполнения)

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




    }
}
