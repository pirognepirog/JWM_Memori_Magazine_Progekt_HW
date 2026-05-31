package org.skypro.skyshop;

public abstract class Product {

    // Эти значения должны быть немодифицируемыми  (тогда только геттеры)
    // после создания объекта, но должна быть возможность получить эти значения в других классах.
    // Создаю поля класса

    private final String nameProduct;
    //private final int priceProduct;

    //создаю конструктор
    public Product(String nameProduct) { //, int priceProduct){
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

}



