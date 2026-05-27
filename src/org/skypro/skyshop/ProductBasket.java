package org.skypro.skyshop;

import java.util.Arrays;

public class ProductBasket {
// методы должны быть публичные

    // поля класса
   private Product[] products;
   private int count;
   private int totalPrase;

   // создаю контсруктор
    public ProductBasket(int size) {
        this.products = new Product[size];
        this.count = 0;
        this.totalPrase = 0;
    }

    public void addProduktInBasket(String name, int prise){
        if (products == null) {
            System.out.println("Корзина не создана, отсутствует продукт!");
            return;
        }

        if(count < products.length) {
            products[count] = new Product(name, prise);
            totalPrase += prise;
            count++;
        }else {
            System.out.println("Невозможно добавить продукт, корзина заполнена!");
        }
    }

    public int getTotalPrase() {
        return totalPrase;
    }

    public void printBacket() {
        if (count == 0){
            System.out.println("В корзине пусто!");
            return;
        }
        for (int i = 0; i < count; i++) {
            System.out.println(products[i]); // работает через toString
        }
        System.out.println("Итого: = " + totalPrase);
    }
    //Метод, проверяющий продукт в корзине по имени: метод принимает в себя строку имени и возвращает
    //boolean
    // в зависимости от того, есть продукт в корзине или его нет.

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

    //Метод очистки корзины: метод ничего не принимает и очищает массив, проставляя всем его элементам null
    public void clearBacket() {
        for (int i = 0; i < count; i++) {
            products[i] = null;
        }
        count = 0;
        totalPrase = 0;
        System.out.println("Очистка корзины завершена!");
    }


}
