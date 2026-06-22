package org.skypro.skyshop.Article;

public class BestResultNotFound extends RuntimeException {
    private final String searchString;

    public BestResultNotFound(String searchString) {
        super("Не найдено ни одного релевантного результата для: " + searchString);
        this.searchString = searchString;
    }

    @Override
    public String toString() {
        return "BestResultNotFound{searchString='" + searchString + "'}";
    }
}