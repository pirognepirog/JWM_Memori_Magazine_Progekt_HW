package org.skypro.skyshop;

import java.text.MessageFormat;

public class DiscountedProduct extends Product {
   private int basePrice; //базовая цена
    private int discountPercent; //скидка в целых процентах

    public DiscountedProduct(String nameProduct, int basePrice, int discountPercent) {
        super(nameProduct);
/*
  В конструкторе класса DiscountedProduct реализуйте проверки базовой цены и процента скидки.
  Правила для базовой цены — такие же, как для цены в классе SimpleProduct. Правила для процента скидки —
  процент должен быть числом в диапазоне от 0 до 100 включительно. Слово «включительно» означает, что границы
  диапазона 0 и 100 тоже являются правильными значениями.
*/
        if (basePrice < 1) {
            throw new IllegalArgumentException("Базовая цена продукта быть больше 0! Для " +
                    nameProduct + " указана базовая цена = " + basePrice);
        }
        if (!(discountPercent >= 0 && discountPercent <= 100)) {
            throw new IllegalArgumentException(nameProduct + ": скидка должна лежать в диапазоне от 0 до 100%" +
                    ", задано значение = " + discountPercent + "; это не верно!");
        }

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


    @Override
    public String getSearchTerm() {
        return getContentType();
    }

    @Override
    public String getContentType() {
        return getContentType();
    }

    @Override
    public String getName() {
        return getName();
    }
}
