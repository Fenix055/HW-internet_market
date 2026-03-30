package org.skypro.skyshop.product;

import java.util.ArrayList;

public class SearchEngine {
    ArrayList<Searchable> searchables = new ArrayList<>();

    public ArrayList<Searchable> search(String text) {
        ArrayList <Searchable> finded = new ArrayList<>();
        for (Searchable searchable : searchables) {
            if (searchable.getSearchableName().equals(text)){
                finded.add(searchable);
            }
        }
        return finded;
    }

    public void add(Searchable newSearchable) {
        searchables.add(newSearchable);
    }

    public Searchable getSearchTerm(String search) throws BestResultNotFound {
        search = search.toLowerCase();
        int[] result = new int[searchables.size()];

        for (int i = 0; i < searchables.size(); i++) {
            if (searchables.get(i) != null) {
                if (searchables.get(i).getSearchableName().toLowerCase().contains(search)) {
                    result[i] = searchables.get(i).getSearchableName().length() - search.length() + 1;
                }
            }
        }

        int best = -1;

        for (int i = 0; i < result.length; i++) {
            if (result[i] > 0) {
                if (best == -1) {
                    best = i;
                }
                if (result[i] < result[best]){
                    best = i;
                }
            }
        }
        if (best >= 0) {
            return searchables.get(best);
        } else {
            throw new BestResultNotFound(search + " не найден.");
        }
    }
}
