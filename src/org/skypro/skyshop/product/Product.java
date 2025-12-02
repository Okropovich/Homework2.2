package org.skypro.skyshop.product;

public class Product {
    public Product(String productName,int castProduct){
        this.productName=productName;
        this.castProduct=castProduct;
    }

    private final String productName;
    private final  int castProduct;

    public int getCastProduct() {
        return castProduct;
    }

    public String getProductName() {
        return productName;
    }

    public void addProduct(){

    }
}

