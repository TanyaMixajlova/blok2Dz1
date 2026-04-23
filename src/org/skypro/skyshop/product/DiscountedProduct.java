package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {
    private final int basePrice;
    private final byte discount;


    public DiscountedProduct(String name, int basePrice, byte discount) {
        super(name);
        this.basePrice = basePrice;
        this.discount = discount;
    }

    @Override
    public int getPrice() {
       int discountAmount = basePrice*discount/100;
        return basePrice-discountAmount;
    }

    @Override
    public String toString() {
        return "Имя продукта со скидкой " + super.toString() + ": "+ getPrice() + " (" + this.discount+ ")";
    }

    @Override
    public boolean isSpecial() {
        return true;
    }
}
