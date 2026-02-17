package org.skypro.skyshop.product;

public abstract class Product {
    private String name;

    public Product(String name) {
        this.name = name;
    }

    public String getName() {return name;}
    public abstract int getPrice();

    public void setName(String name) {this.name = name;}

    public abstract boolean isSpecial();
}
