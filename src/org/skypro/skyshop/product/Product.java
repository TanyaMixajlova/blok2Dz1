package org.skypro.skyshop.product;

public abstract class Product {
    private final String name;


    public Product(String name, int price) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
    public abstract int getPrice();

    @Override
    public String toString() {
        return "Имя" + this.name;
    }
}

