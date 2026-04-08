package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.LinkedHashMap;
import java.util.Map;

public class ProductBasket {
    private final Map <Product, Integer> basket = new LinkedHashMap<>();

    public void addProduct(Product product) {
        if (basket.containsKey(product)){
            basket.computeIfPresent(product, (k, v) -> v + 1);
        } else { basket.put(product, 1); }
    }

    public int sumPrice() {
        int sum = 0;
        for (Map.Entry<Product, Integer> entry : basket.entrySet()) {
            sum += entry.getKey().getPrice() * entry.getValue();
        }
        return sum;
    }

    public void list() {
        if (basket.isEmpty()){
            System.out.println("В корзине пусто");
            return;
        }
        int special = 0;
        for (Map.Entry<Product, Integer> entry : basket.entrySet()) {
            if (entry != null) {
                System.out.println(entry.getKey().toString());
                if (entry.getKey().isSpecial()) special++;
            } else {
                break;
            }
        }
        System.out.println("Итого: " + sumPrice());
        System.out.println("Специальных товаров: " + special);
    }

    public boolean nameChek (String name) {
        for (Map.Entry<Product, Integer> entry : basket.entrySet()) {
            if (entry.getKey().getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public void fullClear () {
        basket.clear();
    }

    public Map<Product, Integer> clearByName (String name) {
        Map <Product, Integer> deletedProducts = new LinkedHashMap<>();
        for (Map.Entry<Product, Integer> entry : basket.entrySet()) {
            if (entry.getKey().getName().equals(name)){
                deletedProducts.put(entry.getKey(), entry.getValue());
                basket.remove(entry.getKey());
                return deletedProducts;
            }
        }
        return deletedProducts;
    }

    public void printBasket () {
        int x = 1;
        for (Map.Entry<Product, Integer> entry : basket.entrySet()) {
            System.out.println("Номер " + x + " - " + entry.getKey().getName() + " в количестве " + entry.getValue() + " по цене " + entry.getKey().getPrice() + " всего " + entry.getKey().getPrice() * entry.getValue());
            x++;
        }
    }




}
