package org.skypro.skyshop.search;

public class SearchEngine {
    private final Searchable[] searchables;
    private int count = 0;

    public SearchEngine(int size) {

        this.searchables = new Searchable[size];
    }

    public void add(Searchable element) {
        if (count < searchables.length) {
            searchables[count] = element;
            count++;
        } else {
            System.out.println("Массив заполнен, невозможно добавить: " + element.getName());
        }
    }

    public Searchable[] search(String query) {
        Searchable[] results = new Searchable[5];
        int resultCount = 0;
        for (Searchable element : searchables) {
            if (element == null) {
                continue;
            }
            if (element.getSearchTerm().contains(query)) {
                results[resultCount] = element;
                resultCount++;
                if (resultCount == 5) {
                    break;
                }
            }
        }
        return results;
    }
}
