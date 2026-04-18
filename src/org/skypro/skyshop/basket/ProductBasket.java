package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

public class ProductBasket extends Product{
    private final Product[] productBasket = new Product[5];


    public void addBasket(Product product) {
        for (int i = 0; i < productBasket.length; i++) {
            if (productBasket[i] == null) {
                productBasket[i] = product;
                return;
            }
        }
        System.out.println("Продукт добавить невозможно");
    }

    public int gettingBasketPrice() {
        int basketPrice = 0;
        boolean isEmpty = true;
        for (Product product : productBasket) {
            if (product != null) {
                basketPrice += product.getPrice();
                isEmpty = false;
            }
        }
        if (isEmpty) {
            System.out.println("В корзине пусто");
        }
        return basketPrice;
    }

    public void printBasket() {
        int basketPrice = gettingBasketPrice();
        for (Product product : productBasket) {
            if (product != null) {
                System.out.println(product.getName() + ": " + product.getPrice());
            }
        }
        System.out.println("Итого: " + basketPrice);
    }

    public boolean productSearch(String productInBasket){
        for (Product product : productBasket) {
            if (product != null && product.getName().equals(productInBasket)) {
                return true; // Продукт найден
            }
        }
        return false; // Продукт не найден
    }

    public void clearingBasket() {
        for (int i = 0; i < productBasket.length; i++) {
            productBasket[i] = null;
        }
    }


}

