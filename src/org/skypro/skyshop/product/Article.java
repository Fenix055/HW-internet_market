package org.skypro.skyshop.product;

public final class Article implements Searchable{
    String name;
    String text;

    public Article(String name, String text) {
        this.name = name;
        this.text = text;
    }

    @Override
    public String toString() {
        return name + '\'' + text;
    }

    public String getSearchableName() {return name;}
    public String getSearchableType() {return "Article";};
    public String getSearchableTerm() {return toString();};
}
