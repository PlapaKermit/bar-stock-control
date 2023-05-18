package com.plapa_kermit.gestion_bar.Model;

public class Beverage {
    private String name;
    private double alcohol;
    private double price;

    public Beverage(String name, double alcohol, double price) {
        this.name = name;
        this.alcohol = alcohol;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public double getAlcohol() {
        return alcohol;
    }

    public void setAlcohol(double alcohol) {
        this.alcohol = alcohol;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
