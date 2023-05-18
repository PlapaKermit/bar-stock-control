package com.plapa_kermit.gestion_bar.Model;


public class Beer {
    private String name;
    private int id;
    private String type;
    private double alcohol;
    private double price;
    private int stock;


    public Beer(String name , String type, double alcohol, double price, int stock) {
        this.name = name;
        this.type = type;
        this.alcohol = alcohol;
        this.price = price;
        this.stock = stock;
    }

    public void setQuantity(int stock) {
        this.stock = stock;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public int getStock() {
        return stock;
    }
}