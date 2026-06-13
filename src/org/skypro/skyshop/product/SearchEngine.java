package org.skypro.skyshop.product;

import java.util.Set;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.Comparator;

public class SearchEngine {
    Set <Searchable> searchables = new HashSet<>();

    public Set<String> search(String text) {
        Searchable[] finded = new Searchable[5];
        Searchable newFinded = searchables.stream().filter(Searchable -> text.equals(Searchable.getSearchableName())).findFirst().orElse(null);

        for (short i = 0; i<5; i++)
            if (finded[i]==null) finded[i] = newFinded;

        Set<String> sortFinded = new TreeSet<>(Comparator.comparingInt(String::length).thenComparing(Comparator.naturalOrder()));
        for (short i = 0; i < 5; i++)
            if (finded[i] != null) {
                sortFinded.add(("имя " + finded[i].getSearchableName() + " - тип " + finded[i].getSearchableType()));
            }
        return sortFinded;
    }

    public void add(Searchable newSearchable) {
        searchables.add(newSearchable);
    }

    public Searchable getSearchTerm(String search) throws BestResultNotFound {
        search = search.toLowerCase();
        Searchable best = null;
        int bestSize = 2147483647;

        for (Searchable entry : searchables) {
            if (entry.getSearchableName().toLowerCase().contains(search)){
                if (best == null){
                    best = entry;
                    bestSize = entry.getSearchableName().length() - search.length();
                } else {
                    if (bestSize > entry.getSearchableName().length() - search.length()){
                        best = entry;
                        bestSize = entry.getSearchableName().length() - search.length();
                    }
                }
            }
        }


        if (best != null) {
            return best;
        } else {
            throw new BestResultNotFound(search + " не найден.");
        }
    }
}
