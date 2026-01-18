package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {
    private final int basePrice;
    private final int discount;

    public DiscountedProduct(String productName, int basePrice, int discount) {
        super(productName);

        this.basePrice = basePrice;
        if (basePrice <= 0)
            throw new IllegalArgumentException("ошибка");

        this.discount = discount;
        if (discount < 0 || discount > 100)
            throw new IllegalArgumentException("ошибка");
    }

    @Override
    public int getCastProduct() {
        int discountAmount = (basePrice * discount) / 100;
        return basePrice - discountAmount;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    public String toString() {
        return getCastProduct() + " : " + getProductName();
    }
}
