package org.skypro.skyshop;

import org.skypro.skyshop.Article.Searchable;

import java.util.Objects;

public abstract class Product implements Searchable {

    // Эти значения должны быть немодифицируемыми (тогда только геттеры)
    // после создания объекта, но должна быть возможность получить эти значения в других классах.
    // Создаю поля класса

    private final String nameProduct;
    //private final int priceProduct;

    //создаю конструктор
    public Product(String nameProduct) { //, int priceProduct){
   /*
     Название продукта не может быть пустой строкой или null. При этом пустая строка может быть также строкой,
     состоящей только из пробелов: в этом случае правило не выполняется, так как это неправильное название
     для продукта.
    */
        if (nameProduct == null || nameProduct.isBlank()) {
            throw new IllegalArgumentException("Название продукта не корректно!");
        }
        this.nameProduct = nameProduct;
        //this.priceProduct = priceProduct;
    }
    // инициализация геттеров для чтения данных класса


    public String getNameProduct() {
        return nameProduct;
    }

    public abstract boolean isSpecial();


    public abstract int getPriceProduct();// {return priceProduct;

    @Override
    public String toString() {
        return nameProduct + ": " + getPriceProduct() + " руб.";// + priceProduct;
    }

    // методы интерфейса Searchable

    @Override
    public String getSearchTerm() {
        return getNameProduct();
    }

    @Override
    public String getContentType() {
        return nameProduct + " цена " + getPriceProduct() + " руб.";
    }

    @Override
    public String getName() {
        return nameProduct;
    }
// ==================================
// в рамках ДЗ Java Collections Framework: Set
// ==================================

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(nameProduct, product.nameProduct);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(nameProduct);
    }
}



