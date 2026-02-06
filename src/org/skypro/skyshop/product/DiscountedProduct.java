package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {
    int price;
    int discount;

    public DiscountedProduct(String name, int price, int discount) {
        super(name);
        this.price = price;
        this.discount = discount;
    }
    @Override
    public int getPrice() {
        return price-price/100*discount;
    }

    public int getDiscount() {
        return discount;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    @Override
    public boolean isSpecial(){
        return true;
    }

    @Override
    public String toString() {
        return getName() + ": " + getPrice() + " (" + getDiscount()+"%)";
    }
}
