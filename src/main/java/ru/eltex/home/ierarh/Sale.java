package ru.eltex.home.ierarh;

public class Sale {
    private String item;
    private  Double price;

    public Sale(String item, Double price) {
        this.item = item;
        this.price = price;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
    public String toString() {
        return this.item + " " + this.price;
    }
}
