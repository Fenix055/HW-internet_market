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
    public int hashCode() {return Objects.hash();}
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Article that = (Article) o;
        return hashCode() == that.hashCode() && Objects.equals(name, that.name);
    }
}
