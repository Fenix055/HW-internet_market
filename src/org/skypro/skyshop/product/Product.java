package org.skypro.skyshop.product;

public abstract class Product implements Searchable{
    private String name;

    public Product(String name) {
        this.name = name;
    }

    public String getName() {return name;}
    public abstract int getPrice();

    public void setName(String name) {this.name = name;}

    public abstract boolean isSpecial();


    public String getSearchableName() {return name;}
    public String getSearchableType() {return "PRODUCT";};
    public String getSearchableTerm() {return name;};
}
