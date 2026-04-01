package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

public class ProductBasket {
    public Product[] productBasket = new Product[5];
    int basketPrice = 0;

    //добавление товаров в корзину
    public boolean addBasket(Product product) {
        for (int i = 0; i < productBasket.length; i++) {
            if (productBasket[i] == null) {
                productBasket[i] = product;
            }
        }
        return false;
        // надо добавить добавить не возможно
    }

    public int gettingBasketPrice() {
        for (int i = 0; i < productBasket.length; i++) {
            if (productBasket[i] != null) {
                basketPrice = basketPrice + productBasket[i].getPrice();
        return basketPrice;
    }

    public void printBasket() {
        for (int i = 0; i < productBasket.length; i++) {
            if (productBasket[i] == null) {
                System.out.println("В корзине пусто");
            } else {
                for (Product product : productBasket) {
                    if (product != null) {
                        System.out.println(product.getName() + ": " + product.getPrice());
                    }
                }
            }System.out.println("Итого: " + basketPrice);
        }
    }
}



