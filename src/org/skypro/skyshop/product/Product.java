package org.skypro.skyshop.product;
import java.util.Objects;


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

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        Product product = (Product) other;
        return Objects.equals(name, product.name);
    }


}




