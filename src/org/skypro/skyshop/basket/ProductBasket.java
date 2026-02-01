package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

public class ProductBasket {
    private Product[] basket = new Product[5];

    public void addProduct(Product product) {
        for (int i = 0; i < basket.length; i++) {
            if (basket[i] == null) {
                basket[i] = product;
                return;
            }
        }
        System.out.println("Невозможно добавить продукт.");
        Product[] newBasket = new Product[basket.length + 5];
        for (int i = 0; i < basket.length; i++) {
            newBasket[i] = basket[i];
        }
        basket = newBasket;
        addProduct(product);
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
        if (basket[0] == null){
            System.out.println("В корзине пусто");
            return;
        }
        for (Product added : basket) {
            if (added != null) {
                System.out.println(added.getName() + ": " + added.getPrice());
            } else {
                break;
            }
        }
        System.out.println("Итого: " + sumPrice());
    }

    public boolean nameChek (String name) {
        for (Product added : basket) {
            if (added == null){
                return false;
            }
            if (added.getName() == name) {
                return true;
            }
        }
        return false;
    }

    public void clear () {
        if (basket[0] == null){
            return;
        }
        for (int i = 0; i < basket.length; i++) {
            if (basket[i] != null) {
                basket[i] = null;
            } else {
                break;
            }
        }
    }




}
