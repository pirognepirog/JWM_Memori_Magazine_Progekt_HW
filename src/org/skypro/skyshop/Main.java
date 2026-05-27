package org.skypro.skyshop;

public class Main {
    public static void main(String[] args) {
    //Демонстрация

    ProductBasket basket = new ProductBasket(3);
        System.out.println("===Добавление продукта в корзину.===");
        basket.addProduktInBasket("фломастер",50);
        basket.addProduktInBasket("карандашь",25);
        basket.addProduktInBasket("маркер",150);

        System.out.println("===Печать содержимого корзины с несколькими товарами и Получение стоимости корзины с несколькими товарами.===");
        basket.printBacket();

        System.out.println("===Поиск товара, который есть в корзине.===");
        basket.verificationBacket("фломастер");

        System.out.println("===Поиск товара, которого нет в корзине.===");
        basket.addProduktInBasket("тетрадь",70);
        basket.verificationBacket("тетрадь");

        System.out.println("===Очистка корзины и Печать содержимого пустой корзины и Получение стоимости пустой корзины.===");
        basket.clearBacket();
        basket.printBacket();

        System.out.println("===Поиск товара по имени в пустой корзине.===");
        basket.verificationBacket("фломастер");

    }



}