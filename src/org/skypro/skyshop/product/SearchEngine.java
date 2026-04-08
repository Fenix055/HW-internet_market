package org.skypro.skyshop.product;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class SearchEngine {
    Map <String, Searchable> searchables = new TreeMap<>();

    public Map<String, Searchable> search(String text) {
        Map <String, Searchable> finded = new TreeMap<>();
        for (Map.Entry<String, Searchable> entry : searchables.entrySet()) {
            if (entry.getKey().equals(text)){
                finded.put(entry.getKey(), entry.getValue());
            }
        }
        return finded;
    }

    public void add(Searchable newSearchable) {
        searchables.put(newSearchable.getSearchableName(), newSearchable);
    }

    public Searchable getSearchTerm(String search) throws BestResultNotFound {
        search = search.toLowerCase();
        Searchable best = null;
        int bestSize = 2147483647;

        for (Map.Entry<String, Searchable> entry : searchables.entrySet()) {
            if (entry.getKey().toLowerCase().contains(search)){
                if (best == null){
                    best = entry.getValue();
                    bestSize = entry.getKey().length() - search.length();
                } else {
                    if (bestSize > entry.getKey().length() - search.length()){
                        best = entry.getValue();
                        bestSize = entry.getKey().length() - search.length();
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
