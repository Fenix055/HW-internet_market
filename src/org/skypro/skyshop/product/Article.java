package org.skypro.skyshop.product;

import java.util.Objects;

public final class Article implements Searchable{
    private final String name;
    private final String text;

    public Article(String name, String text) {
        this.name = name;
        this.text = text;
    }

    @Override
    public String toString() {
        return name + '\n' + text;
    }
    @Override
    public String getSearchableName() {return name;}
    @Override
    public String getSearchableType() {return "ARTICLE";};
    @Override
    public String getSearchableTerm() {return toString();};

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Article article = (Article) o;
        return Objects.equals(name, article.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}
