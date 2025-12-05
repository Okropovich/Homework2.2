package org.skypro.skyshop.product;

public class SimpleProduct extends Product {
    private final int price;

    public SimpleProduct(String productName, int price) {
        super(productName);
        this.price = price;
    }

    @Override
    public int getCastProduct() {
        return this.price;
    }

    public String toString() {
        return getProductName() + " : " + getCastProduct();
    }
}
