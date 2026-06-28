package org.skypro.skyshop.Article;

import org.skypro.skyshop.Article.BestResultNotFound;

import java.util.*;

public class SearchEngine {
    // константа для ограничения поиска
    // private static final int MAX_SIZE = 5;
    // массив строк для поиска
    private List<Searchable> searchables;

    //котструктор размерности массива
    public SearchEngine() {
        this.searchables = new LinkedList<>(); //[MAX_SIZE]; - не нужен, так как нет размерности
    }
/*
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

 */
    // новый метод для работы поискового движка для поиска предметов
    public void add(Searchable item){
        // проверка на null
        if (item == null) {
            System.out.println("Нет товара для добавления в корзину!");
            return;
        }
        // проверка на то, что в корзине элемент уже существует
        if (searchables.contains(item)) {
            System.out.println(item + " - этот товар уже добавлен в корзину!");
            return;
        }
        searchables.add(item); // ложим товар в корзину
    }
/*
    // метод - поисковый движок
    public List<Searchable> search(String query) {
        // обьявляю список незультатов
        List<Searchable> result = new LinkedList<>();

        // проходим по всем элементам списка циклом
        for (Searchable i : searchables) {
                                          // проверка на количество результатов
                                          // проверка на null, для получения значения из ячейки массива
            if (i != null) {
                                          // получаю поисковую строку
                String searchTerm = i.getSearchTerm();
                                          // сверяю значения из с поисковым запросом
                if (searchTerm != null && searchTerm.contains(query)){
                    result.add(i); // добавляю массив в результат
                }

            }

        }
        return result;
    }
 */
 /*
 2. Модификация возвращаемого значения в методе поиска
В классе поискового движка вам нужно модифицировать метод поиска таким образом,
чтобы он возвращал отсортированную по именам мапу:
с ключом — именем Searchable-объекта и значением — самим Searchable -объектом.
*/

    // метод - поисковый движок (выбрал - TreeMap - так как сортирует под капотом)
    public Map<String,Searchable> search(String query) {
        // обьявляю список незультатов
        Map<String, Searchable> result = new TreeMap();

        // проходим по всем элементам списка циклом

            for (Searchable i : searchables) { // цикл — по каждому товару внутри списка
                // проверка на количество результатов
                // проверка на null, для получения значения из ячейки массива
                if (i != null) {

                    // Получаю имя объекта (ключ)
                    String name = i.getName();

                    // получаю поисковую строку (имя объекта по ключу)
                    String searchTerm = i.getSearchTerm();
                    // сверяю значения из с поисковым запросом
                    if (searchTerm != null && searchTerm.contains(query)) {
                        result.put(name ,i); // добавляю массив в результат
                    }

                }
            }
        return result;
    }
    // метод - поиск релевантного значения
    // кинул исправленный код для проверкии ИИ, в результате было обнаружено, что код по массиву проходит 3 раза
    // что не является оптимальным, тут использовал код, предложенный ИИ

    public Searchable[] searchRelevant(String query) throws BestResultNotFound {
        // Проверка на null или пустую строку
        if (query == null || query.isEmpty()) {
            throw new IllegalArgumentException("Введено некорректное поисковое значение!");
        }

        // Используем Map для хранения результатов и их релевантности
        Map<Searchable, Integer> relevanceMap = new HashMap<>();
        int maxCount = 0;

        for (Searchable item : searchables) {
            if (item != null) {
                String searchTerm = item.getSearchTerm();
                if (searchTerm != null) {
                    int count = countInStr(searchTerm, query);
                    if (count > 0) {
                        relevanceMap.put(item, count);
                        if (count > maxCount) {
                            maxCount = count;
                        }
                    }
                }
            }
        }

        // Если ничего не найдено
        if (relevanceMap.isEmpty() || maxCount == 0) {
            throw new BestResultNotFound(query);
        }

        // Собираем результаты с максимальной релевантностью
        List<Searchable> result = new ArrayList<>();
        for (Map.Entry<Searchable, Integer> entry : relevanceMap.entrySet()) {
            if (entry.getValue() == maxCount) {
                result.add(entry.getKey());
            }
        }

        return result.toArray(new Searchable[0]);
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

    // метод для удаления из корзины
    public List<Searchable> removeProductBasket(String query) {
        // обьявляю список результатов
        List<Searchable> removedProducts  = new LinkedList<>();

        // проверяем, есть ли в корзине товары, до того как выполнять поиск
        if (searchables.isEmpty()) {
            System.out.println("Корзина пуста!");
            return removedProducts; // возвращаем пустой список
        }
        // использование итератора для удаления
        Iterator<Searchable> iterator = searchables.iterator();
        while (iterator.hasNext()) {
            Searchable i = iterator.next();
            if (i != null) {
                String searchTerm = i.getSearchTerm();
                if (searchTerm != null && searchTerm.contains(query)) {
                    removedProducts.add(i); // добавление в список удаленных
                    iterator.remove(); // удаление из корзины через итератор
                }
            }
        }
        // проверка, пуста ли стала корзина
        if (searchables.isEmpty()) {
            System.out.println("В корзине больше нечего нет!");
        }

        return removedProducts;
    }
    public boolean isEmpty() {
        return searchables.isEmpty();
    }

    public List<Searchable> getSearchables() {
        return searchables;
    }
}
