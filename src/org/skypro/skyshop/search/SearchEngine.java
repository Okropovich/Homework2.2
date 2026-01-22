package org.skypro.skyshop.search;

import org.skypro.skyshop.exceptions.BestResultNotFoundException;
import java.util.LinkedList;
import java.util.List;

public class SearchEngine {
    private final List<Searchable> searchables = new LinkedList<>();

    public void add(Searchable element) {
        searchables.add(element);
    }

    public List<Searchable> search(String query) {
        List<Searchable> results = new LinkedList<>();
        for (Searchable s : searchables) {
            if (s.getSearchTerm().contains(query)) {
                results.add(s);
            }
        }
        return results;
    }

    public Searchable findBestMatch(String search) throws BestResultNotFoundException {
        Searchable bestMatch = null;
        int maxCount = 0;
        for (Searchable s : searchables) {
            String str = s.getSearchTerm();
            int count = 0;
            int index = 0;
            while ((index = str.indexOf(search, index)) != -1) {
                count++;
                index += search.length();
            }
            if (count > maxCount) {
                maxCount = count;
                bestMatch = s;
            }
        }
        if (bestMatch == null) throw new BestResultNotFoundException(search);
        return bestMatch;
    }
}