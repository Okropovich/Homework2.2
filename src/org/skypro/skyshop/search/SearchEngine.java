package org.skypro.skyshop.search;

import org.skypro.skyshop.exceptions.BestResultNotFoundException;
import java.util.*;

public class SearchEngine {
    private final Set<Searchable> searchables = new HashSet<>();

    public void add(Searchable element) {
        searchables.add(element);
    }

    public Set<Searchable> search(String query) {

        Comparator<Searchable> searchComparator = new Comparator<Searchable>() {
            @Override
            public int compare(Searchable o1, Searchable o2) {
                int lenCompare = Integer.compare(o2.getSearchTerm().length(), o1.getSearchTerm().length());
                if (lenCompare == 0) {
                    return o1.getSearchTerm().compareTo(o2.getSearchTerm());
                }
                return lenCompare;
            }
        };

        Set<Searchable> results = new TreeSet<>(searchComparator);
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