package org.skypro.skyshop;

import java.util.Scanner;

import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.basket.ProductBasket;


public class App {
    public static void main(String[] args) {
        Product product1 = new Product("яблоки", 150);
        Product product2 = new Product("сахар", 50);
        Product product3 = new Product("кофе", 230);
        Product product4 = new Product("конфеты", 360);
        Product product5 = new Product("хлеб", 46);
        Product product6 = new Product("молоко", 90);

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
    }
}
