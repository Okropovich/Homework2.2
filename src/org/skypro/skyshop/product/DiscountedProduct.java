package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {
    private final int basePrice;
    private final int discount;

    public DiscountedProduct(String productName, int basePrice, int discount) {
        super(productName);
        if (basePrice <= 0) {
            throw new IllegalArgumentException("Базовая цена должна быть больше 0. Передано: " + basePrice);
        }
        if (discount < 0 || discount > 100) {
            throw new IllegalArgumentException("Скидка должна быть в диапазоне от 0 до 100. Передано: " + discount);
        }
        this.basePrice = basePrice;
        this.discount = discount;
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
