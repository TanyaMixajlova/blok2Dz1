package org.skypro.skyshop.product;

public class Product {
    private final String name;
    private final int price;

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }


    //Создаём геттеры
    public String getName() {
        return this.name;
    }
    public int getPrice() {
        return this.price;
    }

    //Реализуем вывод информации
    @Override
    public String toString() {
        return "Имя" + this.name;
    }


}

