package org.skypro.skyshop;

import java.util.Arrays;
import org.skypro.skyshop.SimpleProduct;

public class ProductBasket {
    private Product[] products;
    private int count;
    private int totalPrase;

    public ProductBasket(int size) {
        this.products = new Product[size];
        this.count = 0;
        this.totalPrase = 0;
    }

    public void addProduktInBasket(String name, int prise) {
        if (products == null) {
            System.out.println("Корзина не создана, отсутствует продукт!");
            return;
        }

        if (count < products.length) {
            products[count] = new SimpleProduct(name, prise);  // теперь работает
            totalPrase += prise;
            count++;
        } else {
            System.out.println("Невозможно добавить продукт, корзина заполнена!");
        }
    }

    // новый метод для перегрузки метода addProduktInBasket
    public void addProduktInBasket(Product product) {
        if (products == null) {
            System.out.println("Корзина не создана, отсутствует продукт!");
            return;
        }
        if (count < products.length) {
            products[count] = product;
            totalPrase += product.getPriceProduct();
            count++;
        } else {
            System.out.println("Невозможно добавить продукт, корзина заполнена!");
        }
    }

    // Метод подсчёта специальных товаров (FixPriceProduct и DiscountedProduct)
    public int getSpecialProductCount() {
        int specialCount = 0;
        for (int i = 0; i < this.count; i++) {
           if (products[i] != null && products[i].isSpecial()) {
               specialCount++;
           }
        }
        return specialCount;
    }

    public int getTotalPrase() {
        return totalPrase;
    }

    public void printBacket() {
        if (count == 0) {
            System.out.println("В корзине пусто!");
            return;
        }
        for (int i = 0; i < count; i++) {
            System.out.println(products[i]);
        }
        System.out.println("Итого: " + totalPrase  + " руб.");
    }

    public boolean verificationBacket(String nameProduct) {
        for (int i = 0; i < count; i++) {
            if (products[i] != null && products[i].getNameProduct().equals(nameProduct)) {
                System.out.println("В корзине найдено наименование продукта: " + nameProduct);
                return true;
            }
        }
        System.out.println("В корзине не найдено наименование продукта: " + nameProduct);
        return false;
    }

    public void clearBacket() {
        for (int i = 0; i < count; i++) {
            products[i] = null;
        }
        count = 0;
        totalPrase = 0;
        System.out.println("Очистка корзины завершена!");
    }
}