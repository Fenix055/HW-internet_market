package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.*;

import java.util.Arrays;

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


        /// /////////////////////////////////////////////////////////


        SearchEngine toSearch = new SearchEngine(5);

        toSearch.add(example1);
        toSearch.add(example2);
        toSearch.add(example3);
        toSearch.add(example4);
        toSearch.add(example5);
        toSearch.add(example6);

        Article article1 = new Article("Ar1", "Ar1text");
        Article article2 = new Article("Ar2", "Ar2text");

        toSearch.add(article1);
        toSearch.add(article2);

        System.out.println(Arrays.toString(toSearch.search("Ar1Ar2Ar3")));
        System.out.println(Arrays.toString(toSearch.search("Ex1Ex2Ex3")));


        /// /////////////////////////////////////////////////////////////

        Article abc = new Article("a","b");
        System.out.println(abc.toString());
        abc.getStringRepresentation();

        /// ////////////////////////////////////////////////////////////

        try {
            SimpleProduct testProduct = new SimpleProduct("   ", 0);
            DiscountedProduct testDiscounted = new DiscountedProduct("   ", 0, 101);
        }
        catch (IllegalArgumentException text){
            System.out.println(text);
        }

        System.out.println(toSearch.getSearchTerm("Ex3"));
    }
}