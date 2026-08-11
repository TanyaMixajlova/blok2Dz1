package org.skypro.skyshop.product;

import org.skypro.skyshop.BestResultNotFound;

import java.util.*;

public class SearchEngine {

    private List<Searchable> searchables;

    public SearchEngine() {
        this.searchables = new LinkedList<>();
    }

    public Map<String, Searchable> search(String searchBar) throws BestResultNotFound {
        Map<String, Searchable> results = new TreeMap<>();
        for (Searchable searchableItem : searchables) {
            if (searchableItem.searchTerm().contains(searchBar)) {
                results.put(searchableItem.getName(), searchableItem);
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








