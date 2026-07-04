package org.skypro.skyshop.Article;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Article article = (Article) o;
        return Objects.equals(nameArticle, article.nameArticle) &&
                Objects.equals(textArticle, article.textArticle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameArticle, textArticle);
    }
//@Override
    //public String getStringRepresentation() {
        //return Searchable.super.getStringRepresentation();
    //}
}
