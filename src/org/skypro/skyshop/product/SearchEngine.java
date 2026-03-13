package org.skypro.skyshop.product;

public class SearchEngine {
    Searchable[] searchables;

    public SearchEngine(int searchablesSize) {
        this.searchables = new Searchable[searchablesSize];
    }

    public Searchable[] search(String text){
        short x = 0;
        Searchable[] finded = new Searchable[5];
        for (Searchable searchable : searchables){
            if (searchable == null) return finded;
            if (text.contains(searchable.getSearchableTerm())){
                finded[x] = searchable;
                x++;
                if (x == 4) return finded;
            }
        }
        return finded;
    }

    public void add (Searchable newSearchable){
        for (int x = 0; x< searchables.length; x++){
            if (searchables[x] == null){
                searchables[x] = newSearchable;
                return;
            }
        }
        Searchable[] newSearchables = new Searchable[searchables.length + 5];
        for (int x = 0; x< searchables.length; x++){
            newSearchables[x] = searchables[x];
        }
        searchables=newSearchables;
        add(newSearchable);
    }
}
