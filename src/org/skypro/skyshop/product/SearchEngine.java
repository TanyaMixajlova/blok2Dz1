package org.skypro.skyshop.product;

public class SearchEngine {
    private Searchable[] searchableArray;

    public SearchEngine(int size) {
        this.searchableArray = new Searchable[size];
    }

    public Searchable[] search(String searchBar) {
        Searchable[] results = new Searchable[5];
        int i = 0;
        for (Searchable element : searchableArray) {
            if (element != null) {
                System.out.println("Checking element: " + element.getStringRepresentation());
                if (element.searchTerm().contains(searchBar)) {
                    results[i] = element;
                    i++;
                    if (i >= 5) {
                        break;
                    }
                }
            }
        }
        return results;
    }

    public void add(Searchable newSearchable) {
        for (int i = 0; i < searchableArray.length; i++) {
            if (searchableArray[i] == null) {
                searchableArray[i] = newSearchable; // присваиваем новое значение элементу массива
                break; // выходим из цикла после добавления
            }
        }
    }
}






