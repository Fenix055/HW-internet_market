package org.skypro.skyshop.product;

import java.util.Objects;

public abstract class Product implements Searchable{
    private String name;

    public Product(String name) {
        if (!name.isBlank()){
            this.name = name;
        } else {
            throw new IllegalArgumentException("Недопустимое название продукта");
        }
    }

    public String getName() {return name;}
    public abstract int getPrice();

    public void setName(String name) {this.name = name;}

    public abstract boolean isSpecial();

    @Override
    public String getSearchableName() {return name;}
    @Override
    public String getSearchableType() {return "PRODUCT";};
    @Override
    public String getSearchableTerm() {return name;};

    @Override
    public int hashCode() {return Objects.hash();}
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product that = (Product) o;
        return hashCode() == that.hashCode() && Objects.equals(name, that.name);
    }
}
