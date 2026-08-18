package org.skypro.skyshop.product;

import org.skypro.skyshop.BestResultNotFound;

import java.util.*;

public class SearchEngine {

    private Set<Searchable> searchables;

    public SearchEngine() {
        this.searchables = new HashSet<>();
    }

    public Set<Searchable> search(String searchBar) throws BestResultNotFound {
        Set<Searchable> results = new TreeSet<>(new SearchableComparator());
        for (Searchable searchableItem : searchables) {
            if (searchableItem.searchTerm().contains(searchBar)) {
                results.add(searchableItem);
            }
        }
        if (results.isEmpty()) {
            throw new BestResultNotFound("Нет подходящего объекта");
        }
        return results;
    }
    public void add(Searchable newSearchable) {
        searchables.add(newSearchable);
    }
}








