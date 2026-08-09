package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.List;
import java.util.LinkedList;
import java.util.Iterator;

public class ProductBasket {
    private final List<Product> list = new LinkedList<>();
    int basketPrice = 0;

    public void addProduct(Product product) {
        list.add(product);
        basketPrice += product.getPrice();
    }

    public int gettingBasketPrice() {
        if (list.isEmpty()) {
            System.out.println("В корзине пусто");
        }
        return basketPrice;
    }

    public List<Product> removalProducts(String productName) {
        if (productName == null || productName.isEmpty()) {
            return new LinkedList<>();
        }
        Iterator<Product> iterator = list.iterator();
        List<Product> listRemovalProducts = new LinkedList<>();
        // Перебор элементов с использованием итератора
        while (iterator.hasNext()) {
            Product element = iterator.next();
            {
                if (element.getName().equals(productName)) {
                    iterator.remove();
                    basketPrice -= element.getPrice();
                    listRemovalProducts.add(element);
                }
            }
        }return listRemovalProducts; // Вывод списка удаленных продуктов
    }

    public int countingSpecialProducts() {
        int specialProductCount = 0;
        for (Product product : list) {
            if (product.isSpecial()) {
                specialProductCount++;
            }
        }
        return specialProductCount;
    }

    public void printBasket() {
        int basketPrice = gettingBasketPrice();

        for (Product product : list) {
            System.out.println(product.toString());
        }
        System.out.println("Итого: " + basketPrice);
        System.out.println("Специальных товаров " + countingSpecialProducts());
    }

    public boolean productSearch(String productInBasket) {
        for (Product product : list) {
            if (product.getName().equals(productInBasket)) {
                return true; // Продукт найден
            }
        }
        return false; // Продукт не найден
    }

    public void clearingBasket() {
        list.clear();
        basketPrice = 0;
    }


}


