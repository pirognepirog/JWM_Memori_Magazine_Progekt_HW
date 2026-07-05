package org.skypro.skyshop;

import java.util.*;

import org.skypro.skyshop.SimpleProduct;

public class ProductBasket {
    // по заданию нужно убрать массив и сделать его листом
    // private Product[] products;
    // private List<Product> products;
    private Map<String, List<Product>> products;
    private int count;
    private int totalPrice;

/*
    public ProductBasket() { // int size - убран, так как List не имеет размера (динамический набор)
        //this.products = new Product[size];
        // по заданию нужно убрать массив и сделать его листом
        // реализация листа в контрукторе
        this.products = new ArrayList<>();
        this.count = 0;
        this.totalPrase = 0;
    }
/*
Вам нужно заменить список, используемый в продуктовой корзине, на Map.
Ключом будет имя, а значением — список продуктов (поскольку продукты с одним и тем же именем могут быть добавлены несколько раз).
Тип Map выберите самостоятельно с учетом того, что у нас есть несколько операций получения продуктов по имени.
 */

    public ProductBasket() { // int size - убран, так как List не имеет размера (динамический набор)
        //this.products = new Product[size];
        // по заданию нужно убрать массив и сделать его листом
        // реализация листа в контрукторе
        this.products = new HashMap<>();
        this.count = 0;
        this.totalPrice = 0;
    }

    public void addProduсtInBasket(String name, int prise) {
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

    // новый метод для перегрузки метода addProduсtInBasket
    public void addProduсtInBasket(Product product) {
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
        for (List<Product> productList : products.values()) { // цикл — по всем спискам товаров
            for (Product product : productList) { // цикл — по каждому товару внутри списка
                if (product != null && product.isSpecial()) {
                    specialCount++;
                }
            }

        }
        return specialCount;
    }

    public int totalPrice () {
        return totalPrice;
    }

    public void printBacket() {
        if (products.isEmpty()) {
            System.out.println("В корзине пусто!");
            return;
        }
/*
        for (Product product : products) {
            System.out.println(product);;
        }
*/
        for (List<Product> productList : products.values()) { // цикл — по всем спискам товаров
            for (Product product : productList) { // цикл — по каждому товару внутри списка
                System.out.println(product);
            }
        }
        System.out.println("Итого: " + totalPrice  + " руб.");
    }
/*
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

 */
    public boolean verificationBacket(String nameProduct) {
        for (List<Product> productList : products.values()) { // цикл — по всем спискам товаров
            for (Product product : productList) { // цикл — по каждому товару внутри списка
                if (product != null && product.getNameProduct().equals(nameProduct)) {
                    System.out.println("В корзине найдено наименование продукта: " + nameProduct);
                    return true;
                }
            }
        }
        System.out.println("В корзине не найдено наименование продукта: " + nameProduct);
        return false;
    }

    public void clearBacket() {
        products.clear();
        totalPrice = 0;
        System.out.println("Очистка корзины завершена!");
    }


}