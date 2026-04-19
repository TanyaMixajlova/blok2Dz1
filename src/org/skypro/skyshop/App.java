package org.skypro.skyshop;

import java.util.Scanner;

import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;

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
    }
}
