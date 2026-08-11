package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.List;
import java.util.LinkedList;
import java.util.Iterator;
import java.util.HashMap;
import java.util.Map;

public class ProductBasket {
    private final Map<String, List<Product>> list = new HashMap<>();
    int basketPrice = 0;

    public void addProduct(Product product) {
        list.computeIfAbsent(product.getName(), k -> new LinkedList<>()).add(product);
        basketPrice += product.getPrice();
    }

    public int gettingBasketPrice() {
        int total = 0;
        for (List<Product> productList : list.values()) {
            for (Product product : productList) {
                total += product.getPrice();
            }
        }
        return total;
    }


    public List<Product> removalProducts(String productName) {
       return list.remove(productName);


        //List<Product> products = list.get(productName);
       // if (products == null) {
         //   return new LinkedList<>();
       // }
       // if (productName == null || productName.isEmpty()) {
           // return new LinkedList<>();
        //}
        //Iterator<Product> iterator = products.iterator();
        //List<Product> listRemovalProducts = new LinkedList<>();
        // Перебор элементов с использованием итератора
        //while (iterator.hasNext()) {
          //  Product element = iterator.next();
//            {
//                if (element.getName().equals(productName)) {
//                    iterator.remove();
//                    basketPrice -= element.getPrice();
//                    listRemovalProducts.add(element);
//                }
//            }
//        }
//        return listRemovalProducts; // Вывод списка удаленных продуктов
    }

    public int countingSpecialProducts() {
        int specialProductCount = 0;
        for (List<Product> productList : list.values()) {
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
        for (List<Product> productList : list.values()) {
            for (Product product : productList) {
                System.out.println(product.toString());
            }
        }
        System.out.println("Итого: " + basketPrice);
        System.out.println("Специальных товаров " + countingSpecialProducts());
    }

    public boolean productSearch(String productInBasket) {
        for (List<Product> productList : list.values()) {
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