package org.skypro.skyshop.search;

import org.skypro.skyshop.exceptions.BestResultNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

public class SearchEngine {
    private final Set<Searchable> searchables = new HashSet<>();

    public void add(Searchable element) {
        searchables.add(element);
    }

    public Set<Searchable> search(String query) {

        Comparator<Searchable> searchComparator = (o1, o2) -> {
            int lenCompare = Integer.compare(o2.getSearchTerm().length(), o1.getSearchTerm().length());
            if (lenCompare == 0) {
                return o1.getSearchTerm().compareTo(o2.getSearchTerm());
            }
            return lenCompare;
        };


        return searchables.stream()
                .filter(s -> s.getSearchTerm().contains(query))
                .collect(Collectors.toCollection(() -> new TreeSet<>(searchComparator)));
    }

    public Searchable findBestMatch(String search) throws BestResultNotFoundException {

        return searchables.stream()
                .filter(s -> s.getSearchTerm().contains(search))
                .max(Comparator.comparingInt(s -> {
                    String str = s.getSearchTerm();
                    int count = 0, index = 0;
                    while ((index = str.indexOf(search, index)) != -1) {
                        count++;
                        index += search.length();
                    }
                    return count;
                }))
                .orElseThrow(() -> new BestResultNotFoundException(search));
    }
}