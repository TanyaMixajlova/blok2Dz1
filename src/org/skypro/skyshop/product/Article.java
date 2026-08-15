package org.skypro.skyshop.product;
import java.util.Objects;

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
        return this.textArticle;
    }

    @Override
    public String getName() {
        return "";
    }

    @Override
    public String searchTerm(){
        return titleArticle + textArticle;
    };

    @Override
    public String typeOfContent() {
        return "ARTICLE";
    }

    @Override
    public String getStringRepresentation() {
        return Searchable.super.getStringRepresentation();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) return false;
        Article article = (Article) o;
        return Objects.equals(titleArticle, article.titleArticle);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(titleArticle);
    }
}
