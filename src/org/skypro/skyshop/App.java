package org.skypro.skyshop;

import java.util.Scanner;
import java.util.Arrays;


import org.skypro.skyshop.product.*;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.SearchEngine;


public class App {
    public static void main(String[] args) {
        SimpleProduct product1 = new SimpleProduct("яблоки", 150);
        SimpleProduct product2 = new SimpleProduct("сахар", 50);
        DiscountedProduct product3 = new DiscountedProduct("кофе", 200, (byte)20);
        DiscountedProduct product4 = new DiscountedProduct("конфеты", 100, (byte)30);
        FixPriceProduct product5 = new FixPriceProduct("хлеб");
        FixPriceProduct product6 = new FixPriceProduct("молоко");

        ProductBasket element = new ProductBasket();

        //Добавление продукта в корзину.
        element.addBasket(product1);
        element.addBasket(product2);
        element.addBasket(product3);
        element.addBasket(product4);
        element.addBasket(product5);
        //Добавление продукта в заполненную корзину, в которой нет свободного места.
        element.addBasket(product6);

        //Печать содержимого корзины с несколькими товарами и получение стоимости корзины с несколькими товарами.
        element.printBasket();

        // Поиск продукта в корзине
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите название продукта: ");
        String productInBasket = scanner.nextLine();
        boolean a = element.productSearch(productInBasket);
        System.out.println("Продукт: " + a);

        // Поиск товара, которого нет в корзине
        String productInBasket1 = "масло";
        boolean b = element.productSearch(productInBasket1);
        System.out.println("Продукт " + productInBasket1+": " + b);

        //Очистка корзины
        element.clearingBasket();

        //Печать содержимого пустой корзины
        System.out.println("Печать содержимого пустой корзины");
        element.printBasket();

        //Получение стоимости пустой корзины
        System.out.println("Получение стоимости пустой корзины");
        element.gettingBasketPrice();

        //Поиск товара по имени в пустой корзине
        Scanner scanner1 = new Scanner(System.in);
        System.out.print("Введите название продукта: ");
        String productInBasket2 = scanner.nextLine();
        boolean elementBasket = element.productSearch(productInBasket2);
        System.out.println("Продукт: " + elementBasket);




        System.out.println("новая часть кода" );

        Article product7 = new Article("Java","Полиморфиз и интерфейсы");
        Article product8 = new Article("Статья 2","Текст статьи 2");

        SearchEngine element2 = new SearchEngine(7);


        //Добавление продукта в массив.
        element2.add(product1);
        element2.add(product2);
        element2.add(product3);
        element2.add(product4);
        element2.add(product5);
        element2.add(product6);
        element2.add(product7);
        element2.add(product8);


        Searchable[] results = element2.search("Полиморфизм");
        System.out.println(Arrays.toString(results));


        results = element2.search("ARTICLE");
        System.out.println(Arrays.toString(results));


        results = element2.search("PRODUCT");
        System.out.println(Arrays.toString(results));



    }
}
