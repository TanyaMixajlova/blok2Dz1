package org.skypro.skyshop.product;

import java.util.Comparator;

public class SearchableComparator implements Comparator<Searchable> {
    @Override
    public int compare(Searchable o1, Searchable o2) {
        int integerCompare = Integer.compare(o1.getName().length(), o2.getName().length());
        if (integerCompare == 0) {
            return o2.getName().compareTo(o1.getName());
        }
        return integerCompare;
    }
}



