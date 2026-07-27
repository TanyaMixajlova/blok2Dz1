package org.skypro.skyshop.product;

import org.skypro.skyshop.BestResultNotFound;

public class SearchEngine {
    private Searchable[] searchableArray;

    public SearchEngine(int size) {
        this.searchableArray = new Searchable[size];
    }

    public Searchable Search(String searchBar) throws BestResultNotFound {

        Searchable bestMatch = null;
        int maxCount = 0;
        for (Searchable element : searchableArray) {
            if (element != null) {
                int index = 0;
                int count = 0;
                String searchTerm = element.searchTerm();
                int indexStr = searchTerm.indexOf(searchBar, index);

                while (indexStr != -1) {
                    count++;
                    index = indexStr + searchBar.length();
                    indexStr = searchTerm.indexOf(searchBar, index);
                }

                if (count > maxCount) {
                    maxCount = count;
                    bestMatch = element;
                }
            }
        }
        if (bestMatch == null) {
            throw new BestResultNotFound("Нет подходящего объекта");
        }
        return bestMatch;
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






