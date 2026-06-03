package org.skypro.skyshop.Article;

public final class Article implements Searchable {

    private String nameArticle;
    private String textArticle;

    public Article(String nameArticle, String textArticle) {
        this.nameArticle = nameArticle;
        this.textArticle = textArticle;
    }

    @Override
    public String toString() {
        return "Название статьи: " + nameArticle + "Текст статьи: '" + textArticle;
    }

    @Override
    public String getSearchTerm() {
        return nameArticle + " " + textArticle;
    }

    @Override
    public String getContentType() {
        return textArticle;
    }

    @Override
    public String getName() {
        return nameArticle;
    }

    //@Override
    //public String getStringRepresentation() {
        //return Searchable.super.getStringRepresentation();
    //}
}
