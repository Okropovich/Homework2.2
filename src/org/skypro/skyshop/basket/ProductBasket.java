package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

public class ProductBasket {
    private int currentIndex = 0;
    private Product[] arrayProducts;

    public ProductBasket() {
        this.arrayProducts = new Product[5];
    }

    public void addProduct(Product product) {
        if (this.currentIndex >= arrayProducts.length) {
            System.out.println("Невозможно добавить продукт");
            return;
        }
        this.arrayProducts[this.currentIndex] = product;
        this.currentIndex++;

    }

    public int getTotalCost() {
        int totalCost = 0;

        for (
                Product item : arrayProducts) {
            if (item != null) {
                totalCost += item.getCastProduct();
            }
        }
        return totalCost;

    }

    public void printContent() {
        if (currentIndex == 0) {
            System.out.println("в корзине пусто");
            return;
        }
        for (Product item : this.arrayProducts) {
            if (item != null) {
                System.out.println(item.getProductName() + " : " + item.getCastProduct());
            }
            System.out.println("Итого " + this.getTotalCost());


        }
    }

    public boolean checkProductByName(String name) {
        for (int i = 0; i < arrayProducts.length; i++) {

            if (this.arrayProducts[i] != null) {
                if (arrayProducts[i].getProductName().equalsIgnoreCase(name)) {
                    return true;


                }

            }

        }
        return false;
    }

    public void clearBasket() {
        for (int i = 0; i < arrayProducts.length; i++) {
            this.arrayProducts[i] = null;

        }
        this.currentIndex = 0;

        System.out.println("Корзина очищена.");
    }


}