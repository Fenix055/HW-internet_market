package org.skypro.skyshop.product;

public interface Searchable {

    String getSearchableTerm();
    String getSearchableType();
    String getSearchableName();

    default void getStringRepresentation(){
        System.out.println("имя " + getSearchableName() + " - тип " + getSearchableType());
    }
}
