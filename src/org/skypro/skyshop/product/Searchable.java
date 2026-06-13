package org.skypro.skyshop.product;

import java.util.TreeSet;
import java.util.Set;
import java.util.Comparator;

public interface Searchable {

    String getSearchableTerm();
    String getSearchableType();
    String getSearchableName();

    default void getStringRepresentation(){
        System.out.println("имя " + getSearchableName() + " - тип " + getSearchableType());
    }
}
