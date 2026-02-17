package org.skypro.skyshop.product;

public class FixPriceProduct extends Product{
    private static int price = 150;

    public FixPriceProduct(String name) {
        super(name);
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public boolean isSpecial(){
        return true;
    }

    @Override
    public String toString() {
        return getName() + ": Фиксированная цена " + getPrice();
    }
}
