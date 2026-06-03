package org.skypro.skyshop.Article;

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
}
