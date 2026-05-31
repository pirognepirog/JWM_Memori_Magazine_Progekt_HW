package org.skypro.skyshop;

public class SimpleProduct extends Product {

    private int priceProduct;

    public SimpleProduct(String nameProduct, int priceProduct) {
        super(nameProduct);
        this.priceProduct = priceProduct;

    }

    @Override
    public boolean isSpecial() {
        return false;  // обычный товар
    }

    @Override
    public int getPriceProduct() {
        return priceProduct;
    }
}
