package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;

public class App {
    public static void main(String[] args) {
        SimpleProduct example1 = new SimpleProduct("Ex1", 1);
        SimpleProduct example2 = new SimpleProduct("Ex2", 2);
        DiscountedProduct example3 = new DiscountedProduct("Ex3", 100, 30);
        FixPriceProduct example4 = new FixPriceProduct("Ex4");
        SimpleProduct example5 = new SimpleProduct("Ex5", 5);
        SimpleProduct example6 = new SimpleProduct("Ex6", 6);

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