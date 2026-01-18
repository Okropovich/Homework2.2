package org.skypro.skyshop.search;

import org.skypro.skyshop.exceptions.BestResultNotFoundException;

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

    public Searchable findBestMatch(String search) throws BestResultNotFoundException {
        Searchable bestMatch = null;
        int maxCount = 0;
        for (Searchable element : searchables) {
            if (element == null) continue;
            String str = element.getSearchTerm();
            int count = 0;
            int index = 0;
            int foundIndex = str.indexOf(search, index);
            while (foundIndex != -1) {
                count++;
                index = foundIndex + search.length();
                foundIndex = str.indexOf(search, index);
            }
            if (count > maxCount) {
                maxCount = count;
                bestMatch = element;
            }
        }
        if (bestMatch == null) {
            throw new BestResultNotFoundException(search);
        }
        return bestMatch;
    }
}