package com.plapa_kermit.gestion_bar.Model;

public class Beer extends Beverage {
    private String type;
    private int stock;

    public Beer(String name, String type, double alcohol, double price, int stock) {
        super(name, alcohol, price);
        this.type = type;
        this.stock = stock;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
