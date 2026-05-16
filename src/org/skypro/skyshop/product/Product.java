package org.skypro.skyshop.product;

public abstract class Product implements Searchable {
    private final String name;


    public Product(String name) {
        this.name = name;
        if ((this.name == null || this.name.isBlank())){
            throw new IllegalArgumentException("Имя не может быть создано");
        }
    }

    public String getName() {
        return this.name;
    }
    public abstract int getPrice();

    @Override
    public String toString() {
        return this.name;
    }


    public abstract boolean isSpecial();

    @Override
    public String searchTerm(){
        return name;
    };
    @Override
    public String typeOfContent() {
        return "PRODUCT";
    }


}




