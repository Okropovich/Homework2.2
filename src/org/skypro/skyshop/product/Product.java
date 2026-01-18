package org.skypro.skyshop.product;

import org.skypro.skyshop.search.Searchable;

public abstract class Product implements Searchable {
    public Product(String productName) {
        if (productName == null || productName.isBlank())
            throw new IllegalArgumentException("Название продукта не может быть пустым или null");
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


    @Override
    public String getContentType() {
        return "PRODUCT";
    }

    @Override
    public String getSearchTerm() {
        return getName();
    }

    @Override
    public String getName() {
        return productName;
    }
}

