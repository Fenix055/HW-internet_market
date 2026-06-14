package org.skypro.skyshop.product;

import java.util.*;

public class SearchEngine {
    Set <Searchable> searchables = new HashSet<>();

    public Set<String> search(String text) {
        return searchables.stream()
                .filter(s -> text.equals(s.getSearchableName()))
                .findFirst()
                .map(newFinded -> java.util.stream.Stream.generate(() -> newFinded)
                        .limit(5)
                        .map(s -> "имя " + s.getSearchableName() + " - тип " + s.getSearchableType())
                        .collect(java.util.stream.Collectors.toCollection(() -> new java.util.TreeSet<>(
                                java.util.Comparator.comparingInt(String::length).thenComparing(java.util.Comparator.naturalOrder())
                        ))))
                .orElseGet(java.util.TreeSet::new);
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
