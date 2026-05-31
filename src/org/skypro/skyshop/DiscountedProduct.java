package org.skypro.skyshop;

import java.text.MessageFormat;

public class DiscountedProduct extends Product {
   private int basePrice; //базовая цена
    private int discountPercent; //скидка в целых процентах

    public DiscountedProduct(String nameProduct, int basePrice, int discountPercent) {
        super(nameProduct);
        this.basePrice = basePrice;
        this.discountPercent = discountPercent;
    }

    @Override
    public boolean isSpecial() {
        return true;  // специальный товар
    }

    @Override
    public int getPriceProduct() {
        return basePrice * (100 - discountPercent) / 100; // цена со скидкой
    }

    @Override
    public String toString() {
        return "продукт: " + getNameProduct() + ", стоимость " + getPriceProduct() + " руб. (скидка " + discountPercent + "%)";
    }


}
