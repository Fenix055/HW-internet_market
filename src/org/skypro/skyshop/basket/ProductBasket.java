package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Collections;
import java.util.stream.IntStream;
import java.util.ArrayList;

public class ProductBasket {
    private final Map <Product, Integer> basket = new LinkedHashMap<>();

    public void addProduct(Product product) {
        if (basket.containsKey(product)){
            basket.computeIfPresent(product, (k, v) -> v + 1);
        } else { basket.put(product, 1); }
    }

    public int sumPrice() {
        return basket.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrice() * entry.getValue()).sum();
    }

    public void list() {
        if (basket.isEmpty()){
            System.out.println("В корзине пусто");
            return;
        }
        int special = basket.entrySet().stream()
                .filter(Objects::nonNull)
                .peek(entry -> System.out.println(entry.getKey().toString()))
                .mapToInt(entry -> entry.getKey().isSpecial() ? 1 : 0)
                .sum();
        System.out.println("Итого: " + sumPrice());
        System.out.println("Специальных товаров: " + special);
    }

    public boolean nameChek (String name) {
        return basket.entrySet().stream().anyMatch(entry -> entry.getKey().getName().equals(name));
    }

    public void fullClear () {
        basket.clear();
    }

    public Map<Product, Integer> clearByName (String name) {
        return basket.entrySet().stream()
                .filter(entry -> entry.getKey().getName().equals(name))
                .findFirst()
                .map(entry -> {
                    basket.remove(entry.getKey());
                    return Map.of(entry.getKey(), entry.getValue());
                })
                .orElse(Collections.emptyMap());
    }

    public void printBasket () {
        var entries = new ArrayList<>(basket.entrySet());

        IntStream.range(0, entries.size())
                .forEach(i -> {
                    var entry = entries.get(i);
                    var product = entry.getKey();
                    System.out.printf("Номер %d - %s в количестве %d по цене %d всего %d%n",
                            i + 1,
                            product.getName(),
                            entry.getValue(),
                            product.getPrice(),
                            product.getPrice() * entry.getValue());
                });
    }




}
