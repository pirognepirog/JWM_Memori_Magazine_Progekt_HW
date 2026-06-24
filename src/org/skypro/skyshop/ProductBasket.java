package org.skypro.skyshop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.skypro.skyshop.SimpleProduct;

public class ProductBasket {
    // по заданию нужно убрать массив и сделать его листом
    // private Product[] products;
    private List<Product> products;
    private int count;
    private int totalPrase;

    public ProductBasket() { // int size - убран, так как List не имеет размера (динамический набор)
        //this.products = new Product[size];
        // по заданию нужно убрать массив и сделать его листом
        // реализация листа в контрукторе
        this.products = new ArrayList<>();
        this.count = 0;
        this.totalPrase = 0;
    }

    public void addProduktInBasket(String name, int prise) {
        if (products == null) {
            System.out.println("Корзина не создана, отсутствует продукт!");
            return;
        }
/*      отключено, так как теперь не имеет смысла следить за размерностью листа
        так как от не имеет размера (динамический набор данных)
        if (count < products.length) {
            products[count] = new SimpleProduct(name, prise);  // теперь работает
            totalPrase += prise;
            count++;
        } else {
            System.out.println("Невозможно добавить продукт, корзина заполнена!");
        }
 */
    }

    // новый метод для перегрузки метода addProduktInBasket
    public void addProduktInBasket(Product product) {
        if (products == null) {
            System.out.println("Корзина не создана, отсутствует продукт!");
            return;
        }
/*      отключено, так как теперь не имеет смысла следить за размерностью листа
        так как от не имеет размера (динамический набор данных)
        if (count < products.length) {
            products[count] = product;
            totalPrase += product.getPriceProduct();
            count++;
        } else {
            System.out.println("Невозможно добавить продукт, корзина заполнена!");
        }

 */
    }

    // Метод подсчёта специальных товаров (FixPriceProduct и DiscountedProduct)
    public int getSpecialProductCount() {
        int specialCount = 0;
        for (Product product : products) {
           if (product != null && product.isSpecial()) {
               specialCount++;
           }
        }
        return specialCount;
    }

    public int getTotalPrase() {
        return totalPrase;
    }

    public void printBacket() {
        if (products.isEmpty()) {
            System.out.println("В корзине пусто!");
            return;
        }
        for (Product product : products) {
            System.out.println(product);;
        }
        System.out.println("Итого: " + totalPrase  + " руб.");
    }

    public boolean verificationBacket(String nameProduct) {
        for (Product product : products) {
            if (product != null && product.getNameProduct().equals(nameProduct)) {
                System.out.println("В корзине найдено наименование продукта: " + nameProduct);
                return true;
            }
        }
        System.out.println("В корзине не найдено наименование продукта: " + nameProduct);
        return false;
    }

    public void clearBacket() {
        products.clear();
        totalPrase = 0;
        System.out.println("Очистка корзины завершена!");
    }


}