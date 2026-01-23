package org.skypro.skyshop.article;

import org.skypro.skyshop.search.Searchable;

public class Article implements Searchable {
    private final String nameArticle;
    private final String textArticle;

    public Article(String nameArticle, String textArticle) {
        this.nameArticle = nameArticle;
        this.textArticle = textArticle;


    }

    @Override
    public String getName() {
        return nameArticle;
    }

    @Override
    public String getContentType() {
        return "ARTICLE";
    }

    @Override
    public String getSearchTerm() {
        return this.toString();

    }

    public String toString(){
        return nameArticle + " \n " + textArticle;
    }
}
