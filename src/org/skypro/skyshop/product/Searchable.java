package org.skypro.skyshop.product;

import javax.xml.namespace.QName;

public interface Searchable {
    String getName();
    String searchTerm();
    String typeOfContent();
    default String getStringRepresentation() {
        return searchTerm() + " - " + typeOfContent();
    }
}