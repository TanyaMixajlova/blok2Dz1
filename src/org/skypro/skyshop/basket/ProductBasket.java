package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;


public class ProductBasket {
    private final Map<String, Set<Product>> listProduct = new HashMap<>();
    int basketPrice = 0;

    //добавляем продукт
    public void addProduct(Product product) {
        listProduct.computeIfAbsent(product.getName(), k -> new HashSet<>()).add(product);
        basketPrice += product.getPrice();
    }

    //Получение цены на корзину
    public int gettingBasketPrice() {
        //получения всех значений из listProduct, который является Map, и превращаем их в поток (stream). values() возвращает коллекцию списков товаров.
        return listProduct.values().stream()
                //Преобразуем поток списков товаров в один плоский поток товаров. Это позволяет работать с каждым товаром отдельно, а не с целыми списками товаров.
                .flatMap(Collection::stream)
                //Преобразуем каждый товар в его цену. mapToInt создаёт поток целых чисел, представляющих цену каждого товара в списке.
                .mapToInt(Product::getPrice)
                //Складываем все цены из потока, чтобы получить общую стоимость всех товаров в корзине.
                .sum();
    }

    public Set<Product> removalProducts(String productName) {
        return listProduct.remove(productName);
    }

    //Подсчет специальных продуктов
    public long getSpecialCount() {
        return listProduct.values().stream()
                .flatMap(Collection::stream)
                .filter(Product::isSpecial)
                .count();
    }

    // печатаем содержимое корзины
    public void printBasket() {
        int basketPrice = gettingBasketPrice();
        //получения всех значений из listProduct, который является Map, и превращаем их в поток (stream). values() возвращает коллекцию списков товаров.
        listProduct.values().stream()
                //Преобразуем поток списков товаров в один плоский поток товаров. Это позволяет работать с каждым товаром отдельно, а не с целыми списками товаров.
                // Превращаем поток списков в поток отдельных продуктов
                .flatMap(Collection::stream)
                .forEach(System.out::println);
    //.forEach(product -> System.out.println(product.getName() + " - " + product.getPrice()));
        System.out.println("Итого: " + basketPrice);
        System.out.println("Специальных товаров " + getSpecialCount());
    }

    public boolean productSearch(String productInBasket) {
        for (Set<Product> productList : listProduct.values()) {
            for (Product product : productList) {
                if (product.getName().equals(productInBasket)) {
                    return true; // Продукт найден
                }
            }
        }
        return false; // Продукт не найден
    }

    public void clearingBasket() {
        listProduct.clear();
        basketPrice = 0;
    }
}