package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.Iterator;
import java.util.LinkedList;

public class ProductBasket {
    private final LinkedList<Product> basket = new LinkedList<>();

    public void addProduct(Product product) {
        basket.add(product);
    }

    public int sumPrice() {
        int sum = 0;
        for (Product added : basket) {
            if (added == null){
                break;
            }
            sum += added.getPrice();
        }
        return sum;
    }

    public void list() {
        if (basket.isEmpty()){
            System.out.println("В корзине пусто");
            return;
        }
        int special = 0;
        for (Product added : basket) {
            if (added != null) {
                System.out.println(added.toString());
                if (added.isSpecial()) special++;
            } else {
                break;
            }
        }
        System.out.println("Итого: " + sumPrice());
        System.out.println("Специальных товаров: " + special);
    }

    public boolean nameChek (String name) {
        for (Product added : basket) {
            if (added == null){
                return false;
            }
            if (added.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public void fullClear () {
        basket.clear();
    }

    public LinkedList<Product> clearByName (String name) {
        LinkedList <Product> deletedProducts = new LinkedList<>();
        Iterator <Product> iterator = basket.iterator();
        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (product.getName().equals(name)){
                deletedProducts.add(product);
                iterator.remove();
            }
        }
        return deletedProducts;
    }

    public void printBasket () {
        int x = 1;
        for (Product product : basket){
            System.out.println("Номер " + x + " - " + product.getName()+ " цена " + product.getPrice());
            x++;
        }
    }




}
