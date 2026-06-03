package org.skypro.skyshop;

import org.skypro.skyshop.Article.Article;
import org.skypro.skyshop.Article.SearchEngine;
import org.skypro.skyshop.Article.Searchable;

public class Main {
    public static void main(String[] args) {
    //Демонстрация

   // ProductBasket basket = new ProductBasket(3);
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


        System.out.println();
        System.out.println("===  Main для второго задания  ===");// Main для второго задания

        SimpleProduct simpleProduct = new SimpleProduct("Маркер",100);
        //<имя продукта>: <стоимость>
        System.out.println(simpleProduct);
        //<имя продукта со скидкой>: <стоимость> (<скидка>%)
        DiscountedProduct discountedProduct = new DiscountedProduct("Карандаш",100,10);
        System.out.println(discountedProduct);
        //<имя продукта c фиксированной ценой>: Фиксированная цена <значение константы фиксированной цены>
        FixPriceProduct fixPrice = new FixPriceProduct("Тетрадь");
        System.out.println(fixPrice);

        // Создаём корзину и добавляем товары
        ProductBasket basketHw2 = new ProductBasket(10);
        basketHw2.addProduktInBasket(simpleProduct);
        basketHw2.addProduktInBasket(discountedProduct);
        basketHw2.addProduktInBasket(fixPrice);

        //Итого: <общая стоимость корзины>
        basketHw2.printBacket();
        //Специальных товаров: <Количество специальных товаров>
        System.out.println("Специальных товаров: " + basketHw2.getSpecialProductCount());

        testSearchEngine();

    }

    private static void testSearchEngine(){
        System.out.println("Main.testSearchEngine");
        //Создайте один объект типа SearchEngine и добавьте в него все товары
        SearchEngine searchEngine = new SearchEngine();
        // добавление объектов
        searchEngine.add(new Article("Погодные условия","12/05/ Погода дождливая...."));
        searchEngine.add(new SimpleProduct("Погодный зонт",100));
        searchEngine.add(new SimpleProduct("Тетрадь",50));

        //создание поискового массива (добавление объектов)
        String query = "Погод";
        System.out.println("Результат поиска по поисковому значению = " + query);
        Searchable[] found = searchEngine.search(query);

        for (Searchable item : found) {
            if (item != null) {
                System.out.println(item.getStringRepresentation());
            }
        }

    }
}