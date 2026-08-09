package org.skypro.skyshop.product;

import org.skypro.skyshop.BestResultNotFound;

import java.util.LinkedList;
import java.util.List;

public class SearchEngine {
    private List<Searchable> searchables = new LinkedList<>();

    public SearchEngine() {
        this.searchables = new LinkedList<>();
    }

    public List<Searchable> Search(String searchBar) throws BestResultNotFound {
        List<Searchable> results = new LinkedList<>();
        for (Searchable element : searchables) {
            if (element != null && element.searchTerm().contains(searchBar)) {
                results.add(element);
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







