package org.skypro.skyshop.product;

public class FixPriceProduct extends Product{
    private static final int FIXED_PRICE=100;
    private int price;

    public FixPriceProduct (String name){
        super(name);
        this.price = FIXED_PRICE;
    }
    @Override
    public int getPrice() {
        return FIXED_PRICE;
    }

    @Override
    public String toString() {
        return super.toString() + ": Фиксированная цена " + FIXED_PRICE;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }
}
