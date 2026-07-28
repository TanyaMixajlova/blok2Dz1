package org.skypro.skyshop;

import java.util.Scanner;
import java.util.Arrays;
import java.util.List;
import java.util.LinkedList;

import org.skypro.skyshop.product.*;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.SearchEngine;


public class App {
    public static void main(String[] args) {
        Product product1 = new SimpleProduct("яблоки красные", 150);
        Product product2 = new DiscountedProduct("яблоки зеленые", 200, (byte) 20);
        Product product3 = new FixPriceProduct("молоко");

        ProductBasket element = new ProductBasket();
        SearchEngine element2 = new SearchEngine(7);

        try {
            Product product4 = new SimpleProduct("сахар", -20);
            element.addProduct(product4);
            element2.add(product4);

        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        try {
            FixPriceProduct product5 = new FixPriceProduct("     ");
            element.addProduct(product5);
            element2.add(product5);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        try {
            DiscountedProduct product6 = new DiscountedProduct("конфеты", 100, (byte) 130);
            element.addProduct(product6);
            element2.add(product6);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }


        //Добавление продукта в корзину.
        element.addProduct(product1);
        element.addProduct(product2);
        element.addProduct(product3);
        element.addProduct(product1);
        element.addProduct(product3);
        element.addProduct(product2);

        //Печать содержимого корзины с несколькими товарами и получение стоимости корзины с несколькими товарами.
        System.out.println("Список продуктов в корзине" );
        element.printBasket();


        // Поиск продукта в корзине
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите название продукта: ");
        String productInBasket = scanner.nextLine();
        boolean a = element.productSearch(productInBasket);
        System.out.println("Продукт: " + a);

        // Удаление продукта из корзины
        Scanner scanner1 = new Scanner(System.in);
        System.out.print("Введите название продукта, находящегося в корзине: ");
        String productToRemove = scanner.nextLine();
        List<Product> removedProducts = element.removalProducts(productToRemove);
        System.out.println("Список удаленных продуктов: " + removedProducts);

        //Печать содержимого корзины с несколькими товарами и получение стоимости корзины с несколькими товарами.
        System.out.println("Список продуктов в корзине" );
        element.printBasket();

        // Удаление несуществующего продукта из корзины
        Scanner scanner2 = new Scanner(System.in);
        System.out.print("Введите название продукта, находящегося в корзине: ");
        String productToRemove2 = scanner.nextLine();
        List<Product> removedProducts2 = element.removalProducts(productToRemove);
        if (removedProducts2.isEmpty()) {
            System.out.println("Список пуст");
        } else {
            System.out.println("Список содержит элементы");
        }

        //Печать содержимого корзины с несколькими товарами и получение стоимости корзины с несколькими товарами.
        System.out.println("Список продуктов в корзине" );
        element.printBasket();


        // Поиск товара, которого нет в корзине
        String productInBasket1 = "масло";
        boolean b = element.productSearch(productInBasket1);
        System.out.println("Продукт " + productInBasket1 + ": " + b);

        //Очистка корзины
        element.clearingBasket();

        //Печать содержимого пустой корзины
        System.out.println("Печать содержимого пустой корзины");
        element.printBasket();

        //Получение стоимости пустой корзины
        System.out.println("Получение стоимости пустой корзины");
        element.gettingBasketPrice();

        //Поиск товара по имени в пустой корзине
        Scanner scanner3 = new Scanner(System.in);
        System.out.print("Введите название продукта: ");
        String productInBasket2 = scanner.nextLine();
        boolean elementBasket = element.productSearch(productInBasket2);
        System.out.println("Продукт: " + elementBasket);


        System.out.println("новая часть кода");

        Article product7 = new Article("Питон язык программирования и Java язык программирования ", "Полиморфиз и интерфейсы");
        Article product8 = new Article("си язык программирования ", "Текст статьи 2");


        //Добавление продукта в массив.
        element2.add(product1);
        element2.add(product3);
        element2.add(product8);
        element2.add(product7);
        element2.add(product2);



        try {
            Searchable result = element2.Search("программирования");
            System.out.println(result);
            Searchable result2 = element2.Search("мармелад");
            System.out.println(result2);
        } catch (BestResultNotFound e) {
            // Обрабатываем наше исключение
            System.out.println("Произошло исключение: " + e.getMessage());
        }
    }
}
