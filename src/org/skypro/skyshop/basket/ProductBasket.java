package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.List;
import java.util.LinkedList;
import java.util.Iterator;
import java.util.HashMap;
import java.util.Map;
import java.util.HashSet;
import java.util.Set;


public class ProductBasket {
    private final Map<String, Set<Product>> list = new HashMap<>();
    int basketPrice = 0;

    public void addProduct(Product product) {
        list.computeIfAbsent(product.getName(), k -> new HashSet<>()).add(product);
        basketPrice += product.getPrice();
    }

    public int gettingBasketPrice() {
        int total = 0;
        for (Set<Product> productList : list.values()) {
            for (Product product : productList) {
                total += product.getPrice();
            }
        }
        return total;
    }


    public Set<Product> removalProducts(String productName) {
        return list.remove(productName);
    }

    public int countingSpecialProducts() {
        int specialProductCount = 0;
        for (Set<Product> productList : list.values()) {
            for (Product product : productList) {
                // действия с каждым продуктом
                if (product.isSpecial()) {
                    specialProductCount++;
                }
            }
        }
        return specialProductCount;
    }

    public void printBasket() {
        int basketPrice = gettingBasketPrice();
        for (Set<Product> productList : list.values()) {
            for (Product product : productList) {
                System.out.println(product.toString());
            }
        }
        System.out.println("Итого: " + basketPrice);
        System.out.println("Специальных товаров " + countingSpecialProducts());
    }

    public boolean productSearch(String productInBasket) {
        for (Set<Product> productList : list.values()) {
            for (Product product : productList) {
                if (product.getName().equals(productInBasket)) {
                    return true; // Продукт найден
                }
            }
        }
        return false; // Продукт не найден
    }

    public void clearingBasket() {
        list.clear();
        basketPrice = 0;
    }
}