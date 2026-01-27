package org.skypro.skyshop.product;

public class FixPriceProduct extends Product {
    private static final int FIX_PRICE = 50;

    public FixPriceProduct(String productName) {
        super(productName);
    }

    @Override
    public int getCastProduct() {
        return FIX_PRICE;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public String toString() {
        return getProductName() + ": фиксированная цена " + FIX_PRICE;
    }
}