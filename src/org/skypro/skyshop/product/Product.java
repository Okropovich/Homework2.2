package org.skypro.skyshop.product;

public abstract class Product {
    public Product(String productName) {
        this.productName = productName;
    }

    private final String productName;


    public abstract int getCastProduct();



    public String getProductName() {
        return productName;
    }


    public boolean isSpecial() {
        return false;
    }
}

