package org.skypro.skyshop.product;

public class SearchEngine {
    Searchable[] searchables;

    public SearchEngine(int searchablesSize) {
        this.searchables = new Searchable[searchablesSize];
    }

    public Searchable[] search(String text) {
        short x = 0;
        Searchable[] finded = new Searchable[5];
        for (Searchable searchable : searchables) {
            if (searchable == null) continue;
            if (text.contains(searchable.getSearchableTerm())) {
                finded[x] = searchable;
                x++;
                if (x == 5) return finded;
            }
        }
        return finded;
    }

    public void add(Searchable newSearchable) {
        for (int x = 0; x < searchables.length; x++) {
            if (searchables[x] == null) {
                searchables[x] = newSearchable;
                return;
            }
        }
        Searchable[] newSearchables = new Searchable[searchables.length + 5];
        for (int x = 0; x < searchables.length; x++) {
            newSearchables[x] = searchables[x];
        }
        searchables = newSearchables;
        add(newSearchable);
    }

    public Searchable getSearchTerm(String search) throws BestResultNotFound {
        search = search.toLowerCase();
        int[] result = new int[searchables.length];

        for (int i = 0; i < searchables.length; i++) {
            if (searchables[i] != null) {
                if (searchables[i].getSearchableName().toLowerCase().contains(search)) {
                    result[i] = searchables[i].getSearchableName().length() - search.length() + 1;
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
            return searchables[best];
        } else {
            throw new BestResultNotFound(search + " не найден.");
        }
    }
}
