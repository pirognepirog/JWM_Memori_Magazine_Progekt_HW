package org.skypro.skyshop.Article;

public interface Searchable {
    //Метод получения search term (термина поиска) — метод,
    // который будет возвращать текст, по которому мы будем искать.
    String getSearchTerm();

    //Метод получения типа контента, который мы нашли.
    // Метод должен возвращать строку с названием типа контента.
    String getContentType();

    //Метод получения имени Searchable -объекта.
    String getName();

    default String getStringRepresentation() {
        return getName() + " — " + getContentType();
    }

}
