package org.skypro.skyshop.search;

import org.skypro.skyshop.exceptions.BestResultNotFoundException;
import java.util.*;

public class SearchEngine {

    private final Set<Searchable> searchables = new HashSet<>();

    public void add(Searchable element) {
        searchables.add(element);
    }

    public Map<String, Searchable> search(String query) {

        Map<String, Searchable> results = new TreeMap<>();
        for (Searchable s : searchables) {
            if (s.getSearchTerm().contains(query)) {
                results.put(s.getSearchTerm(), s);
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