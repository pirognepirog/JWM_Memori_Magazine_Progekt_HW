package org.skypro.skyshop.Article;

import org.skypro.skyshop.Article.BestResultNotFound;

public class SearchEngine {
    // константа для ограничения поиска
    private static final int MAX_SIZE = 5;
    // массив строк для поиска
    private Searchable[] searchables;

    //котструктор размерности массива
    public SearchEngine() {
        this.searchables = new Searchable[MAX_SIZE];
    }

    // метод для работы поискового движка для поиска предметов
    public void add(Searchable item){
        for (int i = 0; i < searchables.length; i++) {
            if(searchables[i] == null){ // если находим пустую ячейку массива
                searchables[i] = item;  // кладем в нее поисковый предмет
                return;                 // выходим по заполнению массива
            }
        }
        System.out.println("Массив поиска заполнен!");
    }

    // метод - поисковый движок
    public Searchable[] search(String query) {
        // обьявляю массив незультатов
        Searchable[] result = new Searchable[MAX_SIZE];
        int counter = 0;                  // счетчик результатов

        for (int i = 0; i < searchables.length; i++) {
                                          // проверка на количество результатов
            if (counter >= MAX_SIZE){     // если нашли результатов до ограничения - выходим
                break;                    // чтобы не грузить систему с поиском лишнего
            }
                                          // проверка на null, для получения значения из ячейки массива
            if (searchables[i] != null) {
                                          // присваиваю значение поисковой строке
                String searchTerm = searchables[i].getSearchTerm();
                                          // сверяю значения из массива товаров с поисковой строкой
                if (searchTerm != null && searchTerm.contains(query)){
                    result[counter] = searchables[i]; // добавляю массив в результат
                    counter++;
                }

            }

        }
        return result;
    }

    // метод - поиск релевантного значения
    public Searchable[] searchRelevant(String query) {

            if(query == null && query.isEmpty()){
                throw new IllegalArgumentException("Введено не корректное поисковое значение!");
            }
            // ищем максимальное количество вхлждений
            int maxCount = 0;
            for (int i = 0; i < searchables.length; i++) {
                if (searchables[i] != null) {
                    String searchTerm = searchables[i].getSearchTerm();
                    if (searchTerm != null) {
                        int count = countInStr(searchTerm, query);
                        if (count > maxCount) {
                            maxCount = count;
                        }
                    }
                }
            }
            // если нечего не найдено
            if (maxCount == 0) {
                throw new BestResultNotFound("Не найдено подходящих результатов!");
            }

            // Сначала считаем, сколько элементов подходит
            int validCount = 0;
            for (int i = 0; i < searchables.length; i++) {
                if (searchables[i] != null) {
                    String searchTerm = searchables[i].getSearchTerm();
                    if (searchTerm != null) {
                        int count = countInStr(searchTerm, query);
                        if (count == maxCount) {
                            validCount++;
                        }
                    }
                }
            }

            // собираем все найденные элементы в массив
            Searchable[] result = new Searchable[validCount];
            int counter = 0;
            for (int i = 0; i < searchables.length; i++) {
                if (searchables[i] != null) {
                    String searchTerm = searchables[i].getSearchTerm();
                    if (searchTerm != null) {
                        int count = countInStr(searchTerm, query);
                        if (count == maxCount) {
                            result[counter] = searchables[i];
                            counter++;
                        }
                    }
                }
            }
            return result;
    }

    // вспомогительный метод для подсчета вхождения строки в подстроку
    private int countInStr(String text, String subString) {

        if (text == null || subString == null || subString.isEmpty()) {
            return 0;
        }

        int count = 0;
        int index = 0;
        int subStrInd = text.indexOf(subString, index);

        while (subStrInd != -1) {
            count++;
            index = subStrInd + subString.length();
            subStrInd = text.indexOf(subString, index);
        }
        return count;
    }
}
