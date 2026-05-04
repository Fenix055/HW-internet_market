package org.skypro.skyshop.product;

import java.util.Set;
import java.util.HashSet;

public class SearchEngine {
    Set <Searchable> searchables = new HashSet<>();

    public Searchable search(String text) {
        Searchable finded = searchables.stream().filter(Searchable -> text.equals(Searchable.getSearchableName())).findFirst().orElse(null);

        return finded;
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
