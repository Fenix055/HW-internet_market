package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;

public class App {
    public static void main(String[] args) {
        Product example1 = new Product("Ex1", 1);
        Product example2 = new Product("Ex2", 2);
        Product example3 = new Product("Ex3", 3);
        Product example4 = new Product("Ex4", 4);
        Product example5 = new Product("Ex5", 5);
        Product example6 = new Product("Ex6", 6);

        ProductBasket basket = new ProductBasket();

        basket.addProduct(example1);
        basket.addProduct(example2);
        basket.addProduct(example3);
        basket.addProduct(example4);
        basket.addProduct(example5);
        basket.addProduct(example6);

        basket.list();
        System.out.println(basket.sumPrice());
        System.out.println(basket.nameChek("Ex1"));
        System.out.println(basket.nameChek("Ex7"));
        basket.clear();
        basket.list();
        System.out.println(basket.sumPrice());
        System.out.println(basket.nameChek("Ex1"));
    }
}