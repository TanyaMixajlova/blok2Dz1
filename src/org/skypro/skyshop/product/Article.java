package org.skypro.skyshop.product;

public class Article implements Searchable {
    private final String titleArticle;
    private final String textArticle;

    public Article(String titleArticle, String textArticle) {
        this.titleArticle = titleArticle;
        this.textArticle = textArticle;
    }

    @Override
    public String toString() {
        return this.titleArticle + "\n" + this.textArticle;
    }

    public String getTitleArticle() {
        return this.titleArticle;
    }
    public String getTextArticle() {
        return this.titleArticle;
    }

    @Override
    public String searchTerm(){
        return titleArticle + textArticle;
    };
    @Override
    public String typeOfContent() {
        return "ARTICLE";
    }

}
